package magic.bnak;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextArea;
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

public class Inquire 
{
	JFrame DeFrame=new JFrame("查询");
	
	JLabel Text=new JLabel("查询");
	
	JLabel IDtext=new JLabel("当前账户："+init.currentUser.getID());//init.currentUser.getID()
	
	JPanel deJPanel=new JPanel();
	JPanel JButton=new JPanel();
	
	JLabel deJLabel=new JLabel("余额:");
	TextField deJTextField=new TextField(20);
	
	TextArea JiluText=new TextArea(5,5);
	
	JButton Confirm=new JButton("查询");
	JButton Return=new JButton("返回");
	
	BoxLayout boxLayout=new BoxLayout(DeFrame.getContentPane(), BoxLayout.Y_AXIS);
	
	
	
	public Inquire()
	{
		DeFrame.setLayout(boxLayout);
		DeFrame.setSize(395, 300);
		DeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DeFrame.setLocationRelativeTo(null);
		DeFrame.getContentPane().setBackground(new Color(255, 255, 255));
		
		DeFrame.add(Box.createVerticalStrut(10));
		
		Text.setFont(new Font("宋体", Font.BOLD, 20));
		Text.setAlignmentX(Component.CENTER_ALIGNMENT);
		DeFrame.add(Text);
		
		DeFrame.add(Box.createVerticalStrut(15));
		
		IDtext.setFont(new Font("宋体", Font.BOLD, 16));
		IDtext.setAlignmentX(Component.CENTER_ALIGNMENT);
		DeFrame.add(IDtext);
		
		DeFrame.add(Box.createVerticalStrut(10));
		
		deJLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		deJPanel.add(deJLabel);
		
		deJTextField.setEditable(false);
		deJPanel.add(deJTextField);
		
		deJPanel.setBackground(new Color(255, 255, 255));
		deJPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		DeFrame.add(deJPanel);
		
		DeFrame.add(Box.createVerticalStrut(5));
		
		JiluText.setEditable(false);
		DeFrame.add(JiluText);
		
		DeFrame.add(Box.createVerticalStrut(5));
		
		Confirm.setBackground(new Color(112, 206, 248));
		Confirm.setFont(new Font("宋体", Font.PLAIN, 14));
		Confirm.setForeground(new Color(255, 255, 255));
		JButton.add(Confirm);
		
		Confirm.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				deJTextField.setText(init.currentUser.getMoney());
				
				JiluText.setText(init.recordString.toString());
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
		Inquire one=new Inquire();
	}*/
	
	

}
