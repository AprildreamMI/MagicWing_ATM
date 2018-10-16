package magic.bnak;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.xml.crypto.Data;

public class Deposit 
{
	JFrame DeFrame=new JFrame("存款");
	
	JLabel Text=new JLabel("存款");
	
	JLabel IDtext=new JLabel("当前账户："+init.currentUser.getID());//init.currentUser.getID()
	
	JPanel deJPanel=new JPanel();
	JPanel JButton=new JPanel();
	
	JLabel deJLabel=new JLabel("请输入存款金额:");
	TextField deJTextField=new TextField(20);
	
	JButton Confirm=new JButton("确认");
	JButton Return=new JButton("返回");
	
	BoxLayout boxLayout=new BoxLayout(DeFrame.getContentPane(), BoxLayout.Y_AXIS);
	
	
	
	public Deposit()
	{
		DeFrame.setLayout(boxLayout);
		DeFrame.setSize(395, 300);
		DeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DeFrame.setLocationRelativeTo(null);
		DeFrame.getContentPane().setBackground(new Color(255, 255, 255));
		
		DeFrame.add(Box.createVerticalStrut(25));
		
		Text.setFont(new Font("宋体", Font.BOLD, 20));
		Text.setAlignmentX(Component.CENTER_ALIGNMENT);
		DeFrame.add(Text);
		
		DeFrame.add(Box.createVerticalStrut(25));
		
		IDtext.setFont(new Font("宋体", Font.BOLD, 16));
		IDtext.setAlignmentX(Component.CENTER_ALIGNMENT);
		DeFrame.add(IDtext);
		
		DeFrame.add(Box.createVerticalStrut(25));
		
		deJLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		deJPanel.add(deJLabel);
		
		//deJTextField.setEditable(false);
		deJPanel.add(deJTextField);
		
		deJPanel.setBackground(new Color(255, 255, 255));
		deJPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		DeFrame.add(deJPanel);
		
		DeFrame.add(Box.createVerticalStrut(15));
		
		Confirm.setBackground(new Color(112, 206, 248));
		Confirm.setFont(new Font("宋体", Font.PLAIN, 14));
		Confirm.setForeground(new Color(255, 255, 255));
		JButton.add(Confirm);
		
		Confirm.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
					String NewMoneyString=deJTextField.getText();
					Boolean shuzi=true;
					 for (int i = 0; i < NewMoneyString.length(); i++) 
					 {
				            System.out.println(NewMoneyString.charAt(i));
				            if (!Character.isDigit(NewMoneyString.charAt(i)))//判断输入的字符串是否是有效的数字，并且不能是负数
				            {
				                shuzi=false;
				                JOptionPane.showMessageDialog(null, "请输入正确的存款金额");//弹窗
				            }
				      }
				      
					if(shuzi)
					{
						init.currentUser.deposit(NewMoneyString);
					}
					
					deJTextField.setText(null);
			}
		});
		
		Return.setBackground(new Color(112, 206, 248));
		Return.setFont(new Font("宋体", Font.PLAIN, 14));
		Return.setForeground(new Color(255, 255, 255));
		JButton.add(Return);
		
		Return.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				DeFrame.setVisible(false);
			}
		});
		
		JButton.setBackground(new Color(255, 255, 255));
		JButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		DeFrame.add(JButton);
		

		DeFrame.setVisible(true);
	}
/*	public static void main(String[] args) 
	{
		Deposit one=new Deposit();
	}*/
	
	

}
