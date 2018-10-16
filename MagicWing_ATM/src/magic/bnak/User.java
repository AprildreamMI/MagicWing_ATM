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
	
	
	public void deposit(String newMoneyString) //存款方法
	{
		//写入记录
		try {
			int NewMoneyInt=Integer.parseInt(newMoneyString);
			int JiuMoneyInt=Integer.parseInt(init.currentUser.getMoney());	
			int ZuiMoneyInt=NewMoneyInt+JiuMoneyInt;
			String ZZhongMeny=ZuiMoneyInt+"";
			
			init.currentUser.setMoney(ZZhongMeny);
			
			Writer writer=new FileWriter(init.userFile);
			
			Geshi=new SimpleDateFormat("yy-MM-dd HH:mm:ss");
			String date=Geshi.format(now);
			
			writer.write(init.recordString.append(date+"\t"+init.currentUser.getID()+"\t"+"存入了"+newMoneyString+"元\r\n").toString());
			writer.flush();
			writer.close();
			
			init.UserList_Write_File();//更新文本信息
			
			JOptionPane.showMessageDialog(null, "存款成功");//弹窗
			
			
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, "存款失败");//弹窗
		}
		
	}
	public void Withdrawals(String newMoneyString)//取款方法
	{   
		//写入记录
		try {
			int NewMoneyInt=Integer.parseInt(newMoneyString);
			int JiuMoneyInt=Integer.parseInt(init.currentUser.getMoney());	
			int ZuiMoneyInt=JiuMoneyInt-NewMoneyInt;
			String ZZhongMenyString=ZuiMoneyInt+"";
			
			init.currentUser.setMoney(ZZhongMenyString);
			
			Writer writer=new FileWriter(init.userFile);
			
			Geshi=new SimpleDateFormat("yy-MM-dd HH:mm:ss");//确立时间的格式
			String date=Geshi.format(now);//转化当前时间为上面所设置的时间格式
			
			writer.write(init.recordString.append(date+"\t"+init.currentUser.getID()+"\t"+"取出了"+newMoneyString+"元\r\n").toString());
			writer.flush();
			writer.close();
			
			init.UserList_Write_File();//更新文本信息
			
			JOptionPane.showMessageDialog(null, "取款成功");//弹窗
			
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, "取款失败");//弹窗
		}
		
	}
	public void Transfer(String userID,String newMoneyString)//转账方法
	{
		Geshi=new SimpleDateFormat("yy-MM-dd HH:mm:ss");//确立时间的格式
		String date=Geshi.format(now);//转化当前时间为上面所设置的时间格
		for(int i=0;i<init.userList.size();i++)
		{
			if(init.userList.get(i).getID().equals(userID))//如果找到用户列表中的用户则取款
			{
				
				int NewMoneyInt=Integer.parseInt(newMoneyString);
				int JiuMoneyInt=Integer.parseInt(init.currentUser.getMoney());	
				int ZuiMoneyInt=JiuMoneyInt+NewMoneyInt;
				String ZZhongMenyString=ZuiMoneyInt+"";
				init.userList.get(i).setMoney(ZZhongMenyString);//设置被转入账户的余额
				
				try {
					Writer writer=new FileWriter(init.userList.get(i).getID()+".txt");
					writer.write(date+"\t"+init.currentUser.getID()+"\t"+"向"+init.userList.get(i).getID()+"转入了"+newMoneyString+"元\r\n");
					
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "写入被转账用户记录失败");//弹窗
				}
				

				
				try {
					Writer	writer1 = new FileWriter(init.userFile);
					writer1.write(init.recordString.append(date+"\t"+init.currentUser.getID()+"\t"+"向"+init.userList.get(i).getID()+"转入了"+newMoneyString+"元\r\n").toString());
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "写入转账用户记录失败");//弹窗
				}
				
				init.UserList_Write_File();//更新文本信息
				
				JOptionPane.showMessageDialog(null, "转账成功");//弹窗
			}
		
	     }
	     JOptionPane.showMessageDialog(null, "转账失败");//弹窗
	}

	
	
}
	
	
