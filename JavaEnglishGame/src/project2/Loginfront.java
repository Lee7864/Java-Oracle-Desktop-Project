package project2;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

/*import ch15.ChatClientAWT3;
import ch15.ChatProtocol3;*/
import project2.Register;;

public class Loginfront extends JFrame implements ActionListener {

	TextField idTx, pwTx; // idTx�� ���̵� �ִ� �Է¶�, pwTx�� �н����带 �ִ� �Է¶�
	/*
	 * logo�� ����, idl�� ID, pwl�� PASS, msgl�� ID�� PASS�� �Է��ϼ���., hg1�� ȸ������, hg2�� �۴��(|),
	 * hg3�� ȸ������
	 */
	JLabel logo, idl, pwl, msgl, hg1, hg2, hg3;
	JButton logBtn, register,quit, edit; // �α��� ��ư
	String id;
	Container e = getContentPane();
	ImageIcon icon;
	MemberMgr mgr;
	UIManager UI = new UIManager();

	public Loginfront() {
		
		
		mgr = new MemberMgr();
		setLayout(null);

		setContentPane(new JLabel(new ImageIcon("project2/forest.png")));

		logo = new JLabel("Escape The Forest");
		idl = new JLabel("ID");
		pwl = new JLabel("PASS");
		idTx = new TextField();
		pwTx = new TextField();
		logBtn = new JButton("Login");
		edit = new JButton("Edit");
		register = new JButton("Register");
		quit = new JButton("Quit");
		msgl = new JLabel("Insert ID & Password");
		

		logo.setFont(new Font("Verdana", Font.CENTER_BASELINE, 50));
		idl.setFont(new Font("Verdana", Font.BOLD, 13));
		pwl.setFont(new Font("Verdana", Font.BOLD, 13));
		msgl.setFont(new Font("Verdana", Font.BOLD, 13));
		
		
		logBtn.setBackground(new Color(133, 173, 173));
		edit.setBackground(new Color(133, 173, 173));
		register.setBackground(new Color(133, 173, 173));
		quit.setBackground(new Color(133, 173, 173));
		

		logo.setForeground(new Color(41, 61, 61));
		edit.setForeground(new Color(41, 61, 61));
		msgl.setForeground(new Color(194,214,214));

		setBounds(350, 200, 1221, 610);
		logo.setBounds(320, 80, 600, 60);
		idl.setBounds(480, 200, 50, 20);
		idTx.setBounds(530, 200, 100, 20);
		pwl.setBounds(480, 230, 50, 20);
		pwTx.setBounds(530, 230, 100, 20);
		logBtn.setBounds(480, 270, 150, 40);
		register.setBounds(405, 320, 150, 40);
		quit.setBounds(480, 370, 150, 40);
		msgl.setBounds(480, 410, 200, 40);
		edit.setBounds(555, 320, 150, 40);
		
		logBtn.addActionListener(this);
		edit.addActionListener(this);
		register.addActionListener(this);
		quit.addActionListener(this);
		pwTx.setEchoChar('*');
		
		
		logBtn.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, (new Color(194, 214, 214))));
		register.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, (new Color(194, 214, 214))));
		quit.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, (new Color(194, 214, 214))));
		edit.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, (new Color(194, 214, 214))));
		
		
		UI.put("OptionPane.background", new ColorUIResource(179, 204, 204));
		UI.put("Panel.background", new ColorUIResource(179, 204, 204));
		
		getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, new Color(194,214,214)));
		
		setTitle("Login Main");

		add(logo);
		add(idl);
		add(idTx);
		add(pwl);
		add(pwTx);
		add(logBtn);
		add(register);
		add(quit);
		add(msgl);
		add(edit);
		
        
		setUndecorated(true);
		setResizable(false);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(logBtn==obj) {
			if(mgr.login(idTx.getText(), pwTx.getText())){
				JOptionPane.showMessageDialog(null, "�α��� ����");
				System.out.println("�α��� ����");
				new Characters();
			}else {
				JOptionPane.showMessageDialog(null, "���̵� �Ǵ� ��й�ȣ�� Ȯ�����ּ���.", "Error", JOptionPane.ERROR_MESSAGE);
				System.out.println("�α��� ����");
			}
		}
		
		if(register==obj) {
			new Register();
		}
		
		if(quit==obj) {
			System.exit(0);
		}
		if(edit == obj) {
			new Edit();
		}
		
	}

	public static void main(String[] args) {
		
		//new Loginfront();
		Loginfront x = new Loginfront();
		Characters.z=x;
		
	}
}










