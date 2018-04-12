package project2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Stageclear extends JFrame implements ActionListener {

	JLabel label1;
	JButton b1, b2;

	public Stageclear() {

		setTitle("RadioButtonTest");
		setBounds(500, 150, 1000, 1000);
		setResizable(false);

		setContentPane(new JLabel(new ImageIcon("project2/back01.jpg")));

		JLabel label1 = new JLabel();
		add(label1);
		label1.setText("<html>Congratulations! <br>You've escaped the Forest!</html>");
		label1.setBounds(150, 330, 900, 130);
		label1.setFont(new Font("Verdana", Font.CENTER_BASELINE, 28));
		label1.setForeground(new Color(41, 61, 61));

		label1.setFont(new Font("Verdana", Font.BOLD, 42));
		
		setLocation(500,10);

		b1 = new JButton("Escape");
		
		

		b1.addActionListener(this);

		add(b1);

		b1.setBounds(400, 520, 175, 50);
		
		b1.setFont(new Font("Verdana", Font.BOLD, 14));

		b1.setBackground(new Color(133, 173, 173));
		b1.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, (new Color(194, 214, 214))));
		getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, new Color(194,214,214)));
		
		setUndecorated(true);

		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			System.exit(0);
		}

	}

	public static void main(String[] args) {
		new Stageclear();
	}

}
