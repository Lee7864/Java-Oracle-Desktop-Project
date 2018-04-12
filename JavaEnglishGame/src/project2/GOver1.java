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

public class GOver1 extends JFrame implements ActionListener {
	
	JLabel label1;
	JButton b1, b2;
	
	public GOver1() {
		
		setTitle("GAME OVER");
		setBounds(500, 150, 997, 539);
		
		getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, new Color(194, 214, 214)));
		
		setContentPane(new JLabel(new ImageIcon("gameover.jpg")));
		
		JLabel label1 = new JLabel();
		add(label1);
		label1.setText("<html>GAME OVER.<br>You'll never escape this Forest.</html>");
		label1.setBounds(150, 150, 900, 130);
		label1.setFont(new Font("Verdana", Font.CENTER_BASELINE, 28));
		label1.setForeground(new Color(153, 0, 51));

		label1.setFont(new Font("Verdana", Font.BOLD, 42));
		
		setLocation(500,170);
		
        b1 = new JButton("Start Over");
		
		

		b1.addActionListener(this);

		add(b1);

		b1.setBounds(230, 350, 175, 50);
		
		b1.setFont(new Font("Verdana", Font.BOLD, 14));

		b1.setBackground(new Color(133, 173, 173));
		b1.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, (new Color(194, 214, 214))));
		
		
        b2 = new JButton("Quit");
		
		

		b2.addActionListener(this);

		add(b2);

		b2.setBounds(580, 350, 175, 50);
		
		b2.setFont(new Font("Verdana", Font.BOLD, 14));

		b2.setBackground(new Color(133, 173, 173));
		b2.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, (new Color(194, 214, 214))));
		
		setUndecorated(true);
		
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==b1) {
			dispose();
		    new Loginfront();
		}
		if(e.getSource()==b2) {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new GOver1();

	}

}
