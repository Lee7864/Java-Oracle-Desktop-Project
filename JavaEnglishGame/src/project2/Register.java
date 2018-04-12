package project2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Register extends JFrame implements ActionListener {

	List list;

	JLabel label, text, resultP;
	JTextField tf1, tf2;
	JPasswordField pw1, pw2;
	JPanel p1, p2, p3, p4, p5, p6;
	JButton insBtn, upBtn;
	Vector<MemberBean> vlist;
	MemberMgr mgr;
	JOptionPane jop = new JOptionPane();

	public Register() {
		setLayout(null);

		setContentPane(new JLabel(new ImageIcon("project2/forest.png")));
		
		setBounds(700, 280, 500, 500);
		setTitle("Register");
		mgr = new MemberMgr();
		
		JLabel a = new JLabel();
		add(a);
		a.setText("Register");
		a.setBounds(190, 30, 700, 50);
		a.setFont(new Font("Verdana", Font.CENTER_BASELINE, 28));
		a.setForeground(new Color(41, 61, 61));
		
		JLabel b = new JLabel();
		add(b);
		b.setText("ID  :");
		b.setBounds(130, 140, 50, 50);
		b.setFont(new Font("Verdana", Font.CENTER_BASELINE, 15));
		b.setForeground(new Color(41, 61, 61));
		
		tf1 = new JTextField(20);
		add(tf1);
		tf1.setBounds(180, 155, 150, 22);
		
		JLabel c = new JLabel();
		add(c);
		c.setText("Password  :");
		c.setBounds(70, 195, 150, 50);
		c.setFont(new Font("Verdana", Font.CENTER_BASELINE, 15));
		c.setForeground(new Color(41, 61, 61));
		
		pw1 = new JPasswordField(20);
		add(pw1);
		pw1.setBounds(180, 210, 150, 22);
		
		JLabel d = new JLabel();
		add(d);
		d.setText("PassCheck :");
		d.setBounds(65, 250, 150, 50);
		d.setFont(new Font("Verdana", Font.CENTER_BASELINE, 15));
		d.setForeground(new Color(41, 61, 61));
		
		pw2 = new JPasswordField(20);
		add(pw2);
		pw2.setBounds(180, 265, 150, 22);
		
		insBtn = new JButton("Register");
		insBtn.addActionListener(this);
		add(insBtn);
		insBtn.setBounds(165, 350, 175, 30);
		insBtn.setBackground(new Color(133, 173, 173));
		insBtn.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, (new Color(194, 214, 214))));
		
		JLabel s = new JLabel();
		add(s);
		s.setText("Name  :");
		s.setBounds(102, 90, 150, 50);
		s.setFont(new Font("Verdana", Font.CENTER_BASELINE, 15));
		s.setForeground(new Color(41, 61, 61));
		
		tf2 = new JTextField(20);
		add(tf2);
		tf2.setBounds(180, 105, 150, 22);
		
		setVisible(true);
		setResizable(false);
		
		validate();
	}

	// DB�� �����ؼ� ����Ʈ�� List��ü add�Ѵ�.
	public void viewList() {
		vlist = mgr.getMember();
		list = new List(vlist.size(), false);
		for (int i = 0; i < vlist.size(); i++) {
			MemberBean bean = vlist.get(i);
			String s = (i + 1) + "     ";
			s += bean.getUserID().trim() + "     ";
			s += bean.getUserPassword().trim() + "    ";
			list.add(s);
		}
		add(list, BorderLayout.CENTER);
		// /////////////////////////////
		int len = list.getItemCount();
		if (len > 0)
			list.select(0);
	}

	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == insBtn) {
			
			MemberBean bean = new MemberBean();
			
			//�̸� ���� ĭ
			if(tf2.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(null, tf2.getText() + "��ĭ�� �����մϴ�.", "�̸� ����", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			
			//���� ���̵� ��� �Ұ�
			if(tf1.getText().trim().equals("")){
				JOptionPane.showMessageDialog(null, tf1.getText() + "��ĭ�� �����մϴ�.", "���̵� ����", JOptionPane.ERROR_MESSAGE);
				return;
			}
			//ID �ߺ�Ȯ��
			if(!mgr.checkId(tf1.getText())){
				JOptionPane.showMessageDialog(null,"["+  tf1.getText()+"]" + "�� ����մϴ�.");
			}else{
				JOptionPane.showMessageDialog(null, "["+  tf1.getText()+"]" + "�� �ߺ��� ���̵��Դϴ�.\n      ����� �Ұ��մϴ�.", "�ߺ��� ���̵�", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			//���� ��й�ȣ ��� �Ұ�
			if(pw1.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(null,  pw1.getText() + "��ĭ�� �����մϴ�.", "��й�ȣ ����", JOptionPane.ERROR_MESSAGE);
				return;
			}
			//PW �ߺ�Ȯ��
			if(pw1.getText().equals(pw2.getText())) {
				JOptionPane.showMessageDialog(null, "��й�ȣ�� ��ġ�մϴ�.");
			}else{
				JOptionPane.showMessageDialog(null, "��й�ȣ�� ��ġ���� �ʽ��ϴ�.", "��й�ȣ ����", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			bean.setUserID(tf1.getText());
			bean.setUserPassword(pw1.getText());
			bean.setUserName(tf2.getText());

			if (mgr.insertMember(bean)) {
				// �Է¼���
				JOptionPane.showMessageDialog(null, "ȸ�������� �Ϸ�Ǿ����ϴ�.");
				dispose();
			}
		}// else if (obj == insBtn)
		validate();// frame�� �ٽ� �׸���.
	}

	public static void main(String[] args) {
		new Register();
	}
}