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

public class Withdrawals 
{
	JFrame DeFrame=new JFrame("ȡ��");
	
	JLabel Text=new JLabel("ȡ��");
	
	JLabel IDtext=new JLabel("��ǰ�˻���"+init.currentUser.getID());//init.currentUser.getID()
	
	JPanel deJPanel=new JPanel();
	JPanel JButton=new JPanel();
	
	JLabel deJLabel=new JLabel("������ȡ����:");
	TextField deJTextField=new TextField(20);
	
	JButton Confirm=new JButton("ȷ��");
	JButton Return=new JButton("����");
	
	BoxLayout boxLayout=new BoxLayout(DeFrame.getContentPane(), BoxLayout.Y_AXIS);
	
	
	
	public Withdrawals()
	{
		DeFrame.setLayout(boxLayout);
		DeFrame.setSize(395, 300);
		DeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DeFrame.setLocationRelativeTo(null);
		DeFrame.getContentPane().setBackground(new Color(255, 255, 255));
		
		DeFrame.add(Box.createVerticalStrut(25));
		
		Text.setFont(new Font("����", Font.BOLD, 20));
		Text.setAlignmentX(Component.CENTER_ALIGNMENT);
		DeFrame.add(Text);
		
		DeFrame.add(Box.createVerticalStrut(25));
		
		IDtext.setFont(new Font("����", Font.BOLD, 16));
		IDtext.setAlignmentX(Component.CENTER_ALIGNMENT);
		DeFrame.add(IDtext);
		
		DeFrame.add(Box.createVerticalStrut(25));
		
		deJLabel.setFont(new Font("����", Font.PLAIN, 14));
		deJPanel.add(deJLabel);
		
		//deJTextField.setEditable(false);
		deJPanel.add(deJTextField);
		
		deJPanel.setBackground(new Color(255, 255, 255));
		deJPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		DeFrame.add(deJPanel);
		
		DeFrame.add(Box.createVerticalStrut(15));
		
		Confirm.setBackground(new Color(112, 206, 248));
		Confirm.setFont(new Font("����", Font.PLAIN, 14));
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
				            if (!Character.isDigit(NewMoneyString.charAt(i)))//�ж�������ַ����Ƿ�����Ч�����֣����Ҳ����Ǹ���
				            {
				                shuzi=false;
				                JOptionPane.showMessageDialog(null, "��������ȷ��ȡ����");//����
				            }
				      }
				      
					if(shuzi)
					{
						init.currentUser.Withdrawals(NewMoneyString);
					}
					
					deJTextField.setText(null);
			}
		});
		
		Return.setBackground(new Color(112, 206, 248));
		Return.setFont(new Font("����", Font.PLAIN, 14));
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
		Withdrawals one=new Withdrawals();
	}*/
	
}