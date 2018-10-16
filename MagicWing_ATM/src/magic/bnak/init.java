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
	public static User currentUser;//当前用户
	public static File userFile;
	public static StringBuilder recordString=new StringBuilder();//登录后读取文本中的记录，然后和recordString拼接
	public static Menu menu;//静态的菜单界面，用于在更换密码后关闭菜单界面
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
				uWriter.flush();//刷新
                uWriter.close();			
			} 
			catch (IOException e) 
			{
				JOptionPane.showMessageDialog(null, "创建用户文档失败");
			}
			
		}
		
		userFile=userfile;
		UpedUserFile_Read_List();
		UserList_Write_File();
		
		Login login=new Login();
		
	}
	
	
	
	
	
	public static void UpedUserFile_Read_List()
	{
		
		/*从用户文档中写入用户到用户列表*/
		try {
			reader=new FileReader("User.txt");
		} catch (FileNotFoundException e) 
		{
			JOptionPane.showMessageDialog(null, "写入用户列表失败");
		}
		String tem="";
		BufferedReader userRead=new BufferedReader(reader);
		try 
		{
			while ((tem=userRead.readLine())!=null) 
			{
				String[] uString=new String[5];
				uString=tem.split("\\s+");
				System.out.println("余额："+uString[2]);
				User one=new User(uString[0], uString[1], uString[2]);
				userList.add(one);
				System.out.println("读取到用户："+one.getID());
			}
			reader.close();
			userRead.close();
			System.out.println("用户列表："+userList);
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("从用户文档写入用户列表中失败");
		}
	}
	
	public static void UserList_Write_File() 
	{
		/*从用户列表中写入用户文档中*/
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
			System.out.println("从用户列表中写入用户文档中失败");
		}
		
	}
	

}
