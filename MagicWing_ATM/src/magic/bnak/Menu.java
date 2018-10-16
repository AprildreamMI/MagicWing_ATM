package magic.bnak;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu 
{
	JFrame Menu=new JFrame("���ܲ˵�");
	
	JLabel Test=new JLabel("���ܲ˵�");
	
	Box  CQkuanH=Box.createHorizontalBox();
	Box ZCkuanH=Box.createHorizontalBox();
	Box QtkuanH=Box.createHorizontalBox();
	
	JButton deposit=new JButton("���");
	JButton withdrawal=new JButton("ȡ��");
	
	JButton transfer=new JButton("ת��");
	JButton query=new JButton("��ѯ");
	
	JButton Gpassword=new JButton("����");
	JButton BackCard=new JButton("�˿�");
	
	
	BoxLayout boxLayout=new BoxLayout(Menu.getContentPane(), BoxLayout.Y_AXIS);
	public Menu()
	{
		Menu.setLayout(boxLayout);
		Menu.setSize(395, 305);
		Menu.setLocationRelativeTo(null);
		Menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Menu.getContentPane().setBackground(new Color(255, 255, 255));
		
		Font tFont=new Font("����", Font.BOLD, 16);
		Test.setFont(tFont);
		Test.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		Menu.add(Box.createVerticalStrut(25));
		Menu.add(Test);
		Menu.add(Box.createVerticalStrut(25));
		
		
		/*              ���ȡ�����                            */
		
		deposit.setBackground(new Color(112, 206, 248));
		deposit.setFont(new Font("����", Font.PLAIN, 14));
		deposit.setForeground(new Color(255, 255, 255));
		deposit.addActionListener(new OKactonLere());
		CQkuanH.add(deposit);
		
		CQkuanH.add(Box.createHorizontalStrut(80));
		
		withdrawal.setBackground(new Color(112, 206, 248));
		withdrawal.setFont(new Font("����", Font.PLAIN, 14));
		withdrawal.setForeground(new Color(255, 255, 255));
		withdrawal.addActionListener(new OKactonLere());
		CQkuanH.add(withdrawal);
		
		CQkuanH.setBackground(new Color(255, 255, 255));
		
		Menu.add(CQkuanH);
		
		
		/*              ת�˲�ѯ���                            */
		
		transfer.setBackground(new Color(112, 206, 248));
		transfer.setFont(new Font("����", Font.PLAIN, 14));
		transfer.setForeground(new Color(255, 255, 255));
		transfer.addActionListener(new OKactonLere());
		ZCkuanH.add(transfer);
		
		ZCkuanH.add(Box.createHorizontalStrut(80));
		
		query.setBackground(new Color(112, 206, 248));
		query.setFont(new Font("����", Font.PLAIN, 14));
		query.setForeground(new Color(255, 255, 255));
		query.addActionListener(new OKactonLere());
		ZCkuanH.add(query);
		
		ZCkuanH.setBackground(new Color(255, 255, 255));
		
		Menu.add(ZCkuanH);
		
		
		/*              �����˿����                            */
		
		Gpassword.setBackground(new Color(112, 206, 248));
		Gpassword.setFont(new Font("����", Font.PLAIN, 14));
		Gpassword.setForeground(new Color(255, 255, 255));
		Gpassword.addActionListener(new OKactonLere());
		QtkuanH.add(Gpassword);
		
		QtkuanH.add(Box.createHorizontalStrut(80));
		
		BackCard.setBackground(new Color(112, 206, 248));
		BackCard.setFont(new Font("����", Font.PLAIN, 14));
		BackCard.setForeground(new Color(255, 255, 255));
		BackCard.addActionListener(new OKactonLere());
		QtkuanH.add(BackCard);
		
		QtkuanH.setBackground(new Color(255, 255, 255));
		
		Menu.add(QtkuanH);
		
		
		Menu.add(Box.createVerticalStrut(25));
		
		
		
		Menu.setVisible(true);
		
		
		
	}
	
	class OKactonLere implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if (e.getActionCommand().equals("���")) 
			{
				Deposit deposit=new Deposit();
			}
			if(e.getActionCommand().equals("ȡ��"))
			{
				Withdrawals withdrawals=new Withdrawals();
			}
			if(e.getActionCommand().equals("ת��"))
			{
				Transfer transfer=new Transfer();
			}
			if(e.getActionCommand().equals("��ѯ"))
			{
				Inquire inquire=new Inquire();
			}
			if(e.getActionCommand().equals("����"))
			{
				ChangePassword changePassword=new ChangePassword();
			}
			if(e.getActionCommand().equals("�˿�"))
			{
				Menu.setVisible(false);
				Login login=new Login();
			}
		}
	}
	
/*	
	public static void main(String[] args) 
	{
		Menu one=new Menu();
	}*/
}
