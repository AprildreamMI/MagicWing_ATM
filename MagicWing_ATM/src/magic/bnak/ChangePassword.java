package magic.bnak;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ChangePassword 
{
    JFrame Zlogin=new JFrame("修改密码");
	
	
	JPanel ZnameP=new JPanel();
	JPanel ZpasswordP=new JPanel();
	JPanel ZQpasswordP=new JPanel();
	JPanel JButtonP=new JPanel();
	
	BoxLayout ZboxLayout=new BoxLayout(Zlogin.getContentPane(), BoxLayout.Y_AXIS);
	
	JLabel ZTest=new JLabel("改   密");
	JLabel ZName= new JLabel("原密码:");
	JLabel ZPassword=new JLabel("新密码:");
	JLabel ZQPassword=new JLabel("确认密码:");
	
	TextField ZnameT=new TextField(20);
	TextField ZpasswordT=new TextField(20);
	TextField ZQpasswordT=new TextField(20);
	
	JButton Zqueding=new JButton("确定");
	JButton Return=new JButton("返回");
	
	public ChangePassword()
	{
		Zlogin.setLayout(ZboxLayout);
		Zlogin.setSize(370, 280);
		Zlogin.setLocationRelativeTo(null);
		Zlogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Zlogin.getContentPane().setBackground(new Color(255, 255, 255));
		
		Font TextFont=new Font("黑体", Font.BOLD, 16);//建立标题字体
		ZTest.setFont(TextFont);//设置标题字体
		
		Zlogin.add(Box.createVerticalStrut(25));//添加顶部间距
		Zlogin.add(ZTest);//添加标题
		ZTest.setAlignmentX(Component.CENTER_ALIGNMENT);
		Zlogin.add(Box.createVerticalStrut(30));//添加中部间距
		
		ZnameP.setBackground(new Color(255, 255, 255));
		ZnameP.add(ZName);
		
		//ZnameT.setEditable(false);
		ZnameP.add(ZnameT);
		
		ZpasswordP.setBackground(new Color(255, 255, 255));
		ZpasswordP.add(ZPassword);
		
		//ZpasswordT.setEditable(false);
		ZpasswordP.add(ZpasswordT);
		
		ZQpasswordP.setBackground(new Color(255, 255, 255));
		ZQpasswordP.add(ZQPassword);
		
		//ZQpasswordT.setEditable(false);
		ZQpasswordP.add(ZQpasswordT);
		
		
		Zlogin.add(ZnameP);
		Zlogin.add(ZpasswordP);
		Zlogin.add(ZQpasswordP);
		Zlogin.add(Box.createVerticalStrut(40));//添加底部间距
		
		Zqueding.setBackground(new Color(112, 206, 248));
		Zqueding.setFont(new Font("宋体", Font.PLAIN, 14));
		Zqueding.setForeground(new Color(255, 255, 255));
		JButtonP.add(Zqueding);
		
		Return.setBackground(new Color(112, 206, 248));
		Return.setFont(new Font("宋体", Font.PLAIN, 14));
		Return.setForeground(new Color(255, 255, 255));
		JButtonP.add(Return);
		Return.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				Zlogin.setVisible(false);
			}
		});
		
		JButtonP.setBackground(new Color(255, 255, 255));
		Zlogin.add(JButtonP);
		
		Zqueding.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				boolean Tongguo=false;
				if(init.currentUser.getPassword().equals(ZnameT.getText()))
				{
					if (ZpasswordT.getText().equals(ZQpasswordT.getText()))
					{
						init.currentUser.setPassword(ZQpasswordT.getText());
						
						init.UserList_Write_File();
						
						JOptionPane.showMessageDialog(null, "修改密码成功");
						
						init.menu.Menu.setVisible(false);
						
						new Login();
						
					}
					else
						JOptionPane.showMessageDialog(null, "两次输入密码不一致，修改密码失败，请重新输入");
				}
				else
					JOptionPane.showMessageDialog(null, "原密码错误，修改密码失败，请重新输入");
				
			}
		});
	
		Zlogin.add(Box.createVerticalStrut(30));//添加底部间距
		Zlogin.setVisible(true);
	}
/*	public static void main(String[] args) 
	{
		ChangePassword one=new ChangePassword();
	}*/
}
