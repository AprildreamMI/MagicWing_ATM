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
    JFrame Zlogin=new JFrame("�޸�����");
	
	
	JPanel ZnameP=new JPanel();
	JPanel ZpasswordP=new JPanel();
	JPanel ZQpasswordP=new JPanel();
	JPanel JButtonP=new JPanel();
	
	BoxLayout ZboxLayout=new BoxLayout(Zlogin.getContentPane(), BoxLayout.Y_AXIS);
	
	JLabel ZTest=new JLabel("��   ��");
	JLabel ZName= new JLabel("ԭ����:");
	JLabel ZPassword=new JLabel("������:");
	JLabel ZQPassword=new JLabel("ȷ������:");
	
	TextField ZnameT=new TextField(20);
	TextField ZpasswordT=new TextField(20);
	TextField ZQpasswordT=new TextField(20);
	
	JButton Zqueding=new JButton("ȷ��");
	JButton Return=new JButton("����");
	
	public ChangePassword()
	{
		Zlogin.setLayout(ZboxLayout);
		Zlogin.setSize(370, 280);
		Zlogin.setLocationRelativeTo(null);
		Zlogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Zlogin.getContentPane().setBackground(new Color(255, 255, 255));
		
		Font TextFont=new Font("����", Font.BOLD, 16);//������������
		ZTest.setFont(TextFont);//���ñ�������
		
		Zlogin.add(Box.createVerticalStrut(25));//��Ӷ������
		Zlogin.add(ZTest);//��ӱ���
		ZTest.setAlignmentX(Component.CENTER_ALIGNMENT);
		Zlogin.add(Box.createVerticalStrut(30));//����в����
		
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
		Zlogin.add(Box.createVerticalStrut(40));//��ӵײ����
		
		Zqueding.setBackground(new Color(112, 206, 248));
		Zqueding.setFont(new Font("����", Font.PLAIN, 14));
		Zqueding.setForeground(new Color(255, 255, 255));
		JButtonP.add(Zqueding);
		
		Return.setBackground(new Color(112, 206, 248));
		Return.setFont(new Font("����", Font.PLAIN, 14));
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
						
						JOptionPane.showMessageDialog(null, "�޸�����ɹ�");
						
						init.menu.Menu.setVisible(false);
						
						new Login();
						
					}
					else
						JOptionPane.showMessageDialog(null, "�����������벻һ�£��޸�����ʧ�ܣ�����������");
				}
				else
					JOptionPane.showMessageDialog(null, "ԭ��������޸�����ʧ�ܣ�����������");
				
			}
		});
	
		Zlogin.add(Box.createVerticalStrut(30));//��ӵײ����
		Zlogin.setVisible(true);
	}
/*	public static void main(String[] args) 
	{
		ChangePassword one=new ChangePassword();
	}*/
}
