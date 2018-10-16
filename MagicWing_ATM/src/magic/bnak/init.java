package magic.bnak;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


public class init 
{
	public static List<User> userList;
	public static User currentUser;//��ǰ�û�
	public static File userFile;
	public static StringBuilder recordString=new StringBuilder();//��¼���ȡ�ı��еļ�¼��Ȼ���recordStringƴ��
	public static Menu menu;//��̬�Ĳ˵����棬�����ڸ��������رղ˵�����
	static Reader reader;
	
	public static void main(String[] args) 
	{
		
		userList=new ArrayList();
		
		File userfile=new File("User.txt");
		if(!userfile.exists())
		{
			try 
			{
				userfile.createNewFile();
				Writer uWriter=new FileWriter("User.txt");
				uWriter.write("admin  12345   88888");
				uWriter.flush();//ˢ��
                uWriter.close();			
			} 
			catch (IOException e) 
			{
				JOptionPane.showMessageDialog(null, "�����û��ĵ�ʧ��");
			}
			
		}
		
		userFile=userfile;
		UpedUserFile_Read_List();
		UserList_Write_File();
		
		Login login=new Login();
		
	}
	
	
	
	
	
	public static void UpedUserFile_Read_List()
	{
		
		/*���û��ĵ���д���û����û��б�*/
		try {
			reader=new FileReader("User.txt");
		} catch (FileNotFoundException e) 
		{
			JOptionPane.showMessageDialog(null, "д���û��б�ʧ��");
		}
		String tem="";
		BufferedReader userRead=new BufferedReader(reader);
		try 
		{
			while ((tem=userRead.readLine())!=null) 
			{
				String[] uString=new String[5];
				uString=tem.split("\\s+");
				System.out.println("��"+uString[2]);
				User one=new User(uString[0], uString[1], uString[2]);
				userList.add(one);
				System.out.println("��ȡ���û���"+one.getID());
			}
			reader.close();
			userRead.close();
			System.out.println("�û��б�"+userList);
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("���û��ĵ�д���û��б���ʧ��");
		}
	}
	
	public static void UserList_Write_File() 
	{
		/*���û��б���д���û��ĵ���*/
		StringBuilder uBuilder=new StringBuilder();
		try 
		{
			Writer uWriter=new FileWriter("User.txt");
			for (int i = 0; i <userList.size(); i++) 
			{
				uBuilder.append(userList.get(i).getID()+"   "+userList.get(i).getPassword()+"   "+userList.get(i).getMoney()+"\r\n");
			}
			uWriter.write(uBuilder.toString());
			uWriter.flush();
			uWriter.close();
		} 
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("���û��б���д���û��ĵ���ʧ��");
		}
		
	}
	

}
