package magic.bnak;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

public class User 
{

	private String ID;
	private String Password;
	private String Money;
	
	SimpleDateFormat Geshi;
	Date now=new Date();
	
	public User(String ID,String password,String money) 
	{
		this.ID=ID;
		this.Password=password;
		this.Money=money;
	}
	
	public String getID() 
	{
		return ID;
	}
	public void setID(String iD)
	{
		ID = iD;
	}
	public String getPassword()
	{
		return Password;
	}
	public void setPassword(String password) 
	{
		Password = password;
	}
	public String getMoney()
	{
		return Money;
	}
	public void setMoney(String money)
	{
		Money=money;
	}
	
	
	public void deposit(String newMoneyString) //����
	{
		//д���¼
		try {
			int NewMoneyInt=Integer.parseInt(newMoneyString);
			int JiuMoneyInt=Integer.parseInt(init.currentUser.getMoney());	
			int ZuiMoneyInt=NewMoneyInt+JiuMoneyInt;
			String ZZhongMeny=ZuiMoneyInt+"";
			
			init.currentUser.setMoney(ZZhongMeny);
			
			Writer writer=new FileWriter(init.userFile);
			
			Geshi=new SimpleDateFormat("yy-MM-dd HH:mm:ss");
			String date=Geshi.format(now);
			
			writer.write(init.recordString.append(date+"\t"+init.currentUser.getID()+"\t"+"������"+newMoneyString+"Ԫ\r\n").toString());
			writer.flush();
			writer.close();
			
			init.UserList_Write_File();//�����ı���Ϣ
			
			JOptionPane.showMessageDialog(null, "���ɹ�");//����
			
			
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, "���ʧ��");//����
		}
		
	}
	public void Withdrawals(String newMoneyString)//ȡ���
	{   
		//д���¼
		try {
			int NewMoneyInt=Integer.parseInt(newMoneyString);
			int JiuMoneyInt=Integer.parseInt(init.currentUser.getMoney());	
			int ZuiMoneyInt=JiuMoneyInt-NewMoneyInt;
			String ZZhongMenyString=ZuiMoneyInt+"";
			
			init.currentUser.setMoney(ZZhongMenyString);
			
			Writer writer=new FileWriter(init.userFile);
			
			Geshi=new SimpleDateFormat("yy-MM-dd HH:mm:ss");//ȷ��ʱ��ĸ�ʽ
			String date=Geshi.format(now);//ת����ǰʱ��Ϊ���������õ�ʱ���ʽ
			
			writer.write(init.recordString.append(date+"\t"+init.currentUser.getID()+"\t"+"ȡ����"+newMoneyString+"Ԫ\r\n").toString());
			writer.flush();
			writer.close();
			
			init.UserList_Write_File();//�����ı���Ϣ
			
			JOptionPane.showMessageDialog(null, "ȡ��ɹ�");//����
			
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, "ȡ��ʧ��");//����
		}
		
	}
	public void Transfer(String userID,String newMoneyString)//ת�˷���
	{
		Geshi=new SimpleDateFormat("yy-MM-dd HH:mm:ss");//ȷ��ʱ��ĸ�ʽ
		String date=Geshi.format(now);//ת����ǰʱ��Ϊ���������õ�ʱ���
		for(int i=0;i<init.userList.size();i++)
		{
			if(init.userList.get(i).getID().equals(userID))//����ҵ��û��б��е��û���ȡ��
			{
				
				int NewMoneyInt=Integer.parseInt(newMoneyString);
				int JiuMoneyInt=Integer.parseInt(init.currentUser.getMoney());	
				int ZuiMoneyInt=JiuMoneyInt+NewMoneyInt;
				String ZZhongMenyString=ZuiMoneyInt+"";
				init.userList.get(i).setMoney(ZZhongMenyString);//���ñ�ת���˻������
				
				try {
					Writer writer=new FileWriter(init.userList.get(i).getID()+".txt");
					writer.write(date+"\t"+init.currentUser.getID()+"\t"+"��"+init.userList.get(i).getID()+"ת����"+newMoneyString+"Ԫ\r\n");
					
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "д�뱻ת���û���¼ʧ��");//����
				}
				

				
				try {
					Writer	writer1 = new FileWriter(init.userFile);
					writer1.write(init.recordString.append(date+"\t"+init.currentUser.getID()+"\t"+"��"+init.userList.get(i).getID()+"ת����"+newMoneyString+"Ԫ\r\n").toString());
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "д��ת���û���¼ʧ��");//����
				}
				
				init.UserList_Write_File();//�����ı���Ϣ
				
				JOptionPane.showMessageDialog(null, "ת�˳ɹ�");//����
			}
		
	     }
	     JOptionPane.showMessageDialog(null, "ת��ʧ��");//����
	}

	
	
}
	
	
