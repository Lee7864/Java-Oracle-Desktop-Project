package project2;
//package register;

import java.awt.BorderLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.NetworkChannel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class Edit extends JFrame implements ActionListener{
	
	MemberMgr mgr = new MemberMgr();
	String name, id;
	TextField TF1 = new TextField("",20)/*�̸�*/ , 
				TF2 = new TextField("", 20);/*�����*/ 
	JLabel Ename = new JLabel("")/*���̵�*/,
			 LT1 = new JLabel(""),
			 LT2 = new JLabel(""),
			 LTF = new JLabel("ȸ�� ����");
	JPanel JP1 = new  JPanel(),
			 JP2 = new JPanel(),
			 JPF = new JPanel();
	JButton  Find = new JButton("ã��"), Find1 = new JButton("ã��");
	BorderLayout BorF = new BorderLayout(20, 30),
						BorP = new BorderLayout(0, 30);
	
	/*�гο��� �־��ٰ�
	 * �� : ���̵� �ߴ°��ϳ� 
	 * �ؽ�Ʈ�ʵ�: �̸�ġ�� ����
	 * �ؽ�Ʈ�ʵ�2 : ����ٲٴ� ����
	 * ��ư �ϳ� :  �����Ϸ�
	 * 
	 * */
	
	public Edit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
		setVisible(true);
		setLayout(BorF);
		//setResizable(false);
		LTF.setHorizontalAlignment(SwingConstants.CENTER);
		LT1.setText("�̸����� ���̵� ã�� : ");
		
		LT2.setText("���̵�� ��й�ȣ ã�� : ");
		
		JP1.add(LT1); JP1.add(TF1); JP1.add(Find);
		JP2.add(LT2); JP2.add(TF2); JP2.add(Find1);
		
		JPF.setLayout(BorP);
		JPF.add(JP1, BorderLayout.NORTH); 
		JPF.add(Ename, BorderLayout.CENTER); 
		JPF.add(JP2, BorderLayout.SOUTH);
		
//		System.out.println(JP1);
		add(JPF, BorderLayout.CENTER);
		add(LTF, BorderLayout.NORTH);
		Find.addActionListener(this);
		Find1.addActionListener(this);
		}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == Find) {
			//�̸����� ���̵� ã��
			if(mgr.checkName(TF1.getText())) {
				JOptionPane.showMessageDialog(null, "ȸ������ ���̵��" + "[" + mgr.getId(TF1.getText()) + "]" +"�Դϴ�." );
			}else {
				JOptionPane.showMessageDialog(null, "'"+TF1.getText() +"' "+" �̶�� �̸����� ������ ���̵� �����ϴ�.", "����", JOptionPane.ERROR_MESSAGE);
			}
		}
		//���̵�� ��й�ȣ ã��
		if(obj==Find1) {
			if(mgr.checkId(TF2.getText())) {
				JOptionPane.showMessageDialog(null, "ȸ������ ��й�ȣ��" + "[" + mgr.getPassword(TF2.getText()) + "]" + "�Դϴ�.");
			}else {
				JOptionPane.showMessageDialog(null,  "'"+TF2.getText() + "'" + " �̶�� ���̵�� ���� ���̵� �Դϴ�.", "����", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
/*	if(!mgr.checkId(tf1.getText())){
		JOptionPane.showMessageDialog(null,"["+  tf1.getText()+"]" + "�� ����մϴ�.");
	}else{
		JOptionPane.showMessageDialog(null, "["+  tf1.getText()+"]" + "�� �ߺ��� ���̵��Դϴ�.\n      ����� �Ұ��մϴ�.", "�ߺ��� ���̵�", JOptionPane.ERROR_MESSAGE);
		return;
	}*/
	
	
	
	
	public static void main(String[] args) {
		new Edit();
	}

}
