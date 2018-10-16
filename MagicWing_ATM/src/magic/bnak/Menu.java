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
	JFrame Menu=new JFrame("功能菜单");
	
	JLabel Test=new JLabel("功能菜单");
	
	Box  CQkuanH=Box.createHorizontalBox();
	Box ZCkuanH=Box.createHorizontalBox();
	Box QtkuanH=Box.createHorizontalBox();
	
	JButton deposit=new JButton("存款");
	JButton withdrawal=new JButton("取款");
	
	JButton transfer=new JButton("转账");
	JButton query=new JButton("查询");
	
	JButton Gpassword=new JButton("改密");
	JButton BackCard=new JButton("退卡");
	
	
	BoxLayout boxLayout=new BoxLayout(Menu.getContentPane(), BoxLayout.Y_AXIS);
	public Menu()
	{
		Menu.setLayout(boxLayout);
		Menu.setSize(395, 305);
		Menu.setLocationRelativeTo(null);
		Menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Menu.getContentPane().setBackground(new Color(255, 255, 255));
		
		Font tFont=new Font("宋体", Font.BOLD, 16);
		Test.setFont(tFont);
		Test.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		Menu.add(Box.createVerticalStrut(25));
		Menu.add(Test);
		Menu.add(Box.createVerticalStrut(25));
		
		
		/*              存款取款面板                            */
		
		deposit.setBackground(new Color(112, 206, 248));
		deposit.setFont(new Font("宋体", Font.PLAIN, 14));
		deposit.setForeground(new Color(255, 255, 255));
		deposit.addActionListener(new OKactonLere());
		CQkuanH.add(deposit);
		
		CQkuanH.add(Box.createHorizontalStrut(80));
		
		withdrawal.setBackground(new Color(112, 206, 248));
		withdrawal.setFont(new Font("宋体", Font.PLAIN, 14));
		withdrawal.setForeground(new Color(255, 255, 255));
		withdrawal.addActionListener(new OKactonLere());
		CQkuanH.add(withdrawal);
		
		CQkuanH.setBackground(new Color(255, 255, 255));
		
		Menu.add(CQkuanH);
		
		
		/*              转账查询面板                            */
		
		transfer.setBackground(new Color(112, 206, 248));
		transfer.setFont(new Font("宋体", Font.PLAIN, 14));
		transfer.setForeground(new Color(255, 255, 255));
		transfer.addActionListener(new OKactonLere());
		ZCkuanH.add(transfer);
		
		ZCkuanH.add(Box.createHorizontalStrut(80));
		
		query.setBackground(new Color(112, 206, 248));
		query.setFont(new Font("宋体", Font.PLAIN, 14));
		query.setForeground(new Color(255, 255, 255));
		query.addActionListener(new OKactonLere());
		ZCkuanH.add(query);
		
		ZCkuanH.setBackground(new Color(255, 255, 255));
		
		Menu.add(ZCkuanH);
		
		
		/*              改密退卡面板                            */
		
		Gpassword.setBackground(new Color(112, 206, 248));
		Gpassword.setFont(new Font("宋体", Font.PLAIN, 14));
		Gpassword.setForeground(new Color(255, 255, 255));
		Gpassword.addActionListener(new OKactonLere());
		QtkuanH.add(Gpassword);
		
		QtkuanH.add(Box.createHorizontalStrut(80));
		
		BackCard.setBackground(new Color(112, 206, 248));
		BackCard.setFont(new Font("宋体", Font.PLAIN, 14));
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
			if (e.getActionCommand().equals("存款")) 
			{
				Deposit deposit=new Deposit();
			}
			if(e.getActionCommand().equals("取款"))
			{
				Withdrawals withdrawals=new Withdrawals();
			}
			if(e.getActionCommand().equals("转账"))
			{
				Transfer transfer=new Transfer();
			}
			if(e.getActionCommand().equals("查询"))
			{
				Inquire inquire=new Inquire();
			}
			if(e.getActionCommand().equals("改密"))
			{
				ChangePassword changePassword=new ChangePassword();
			}
			if(e.getActionCommand().equals("退卡"))
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
