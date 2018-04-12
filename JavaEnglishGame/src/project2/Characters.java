package project2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

public class Characters extends JFrame implements ActionListener {

	JRadioButton jb[] = new JRadioButton[3];
	ImageIcon ic = new ImageIcon("project2/silver hair.jpg");
	ImageIcon id = new ImageIcon("project2/Cat's ear.JPG");
	ImageIcon im = new ImageIcon("project2/Hoodie.png");
	JLabel text;

	JButton b1, b2;
	
	static Loginfront z;

	public Characters() {

		setLayout(null);
		// c.setBackground(new Color(159, 188, 223));
		setContentPane(new JLabel(new ImageIcon("project2/forest.png")));

		setTitle("Characters Select");
		setSize(650, 450);

		

		ButtonGroup bg = new ButtonGroup();

		bg = new ButtonGroup();

		for (int i = 0; i < 3; i++) {
			jb[i] = new JRadioButton();
			add(jb[i]);
			bg.add(jb[i]);

		}

		JLabel l = new JLabel();
		add(l);
		l.setText("Choose The Character");
		l.setBounds(160, 30, 800, 50);
		l.setFont(new Font("Verdana", Font.CENTER_BASELINE, 28));
		l.setForeground(new Color(41, 61, 61));

		jb[0].setBounds(40, 100, 100, 20);
		jb[1].setBounds(240, 100, 100, 20);
		jb[2].setBounds(430, 100, 100, 20);

		jb[0].setText("Silver Hair");
		jb[1].setText("Cat's Ear");
		jb[2].setText("Girl Of Red Hood");

		jb[2].setSize(250, 20);

		jb[0].setFont(new Font("Verdana", Font.BOLD, 13));
		jb[1].setFont(new Font("Verdana", Font.BOLD, 13));
		jb[2].setFont(new Font("Verdana", Font.BOLD, 13));

		jb[0].setOpaque(false);
		jb[1].setOpaque(false);
		jb[2].setOpaque(false);

		setLocation(640, 270);

		
		JLabel imageLabel = new JLabel(im);

		add(imageLabel);

		imageLabel.setBounds(440, 150, 100, 100);
		imageLabel.setSize(125, 125);

		
		JLabel imageLabel1 = new JLabel(ic);
		add(imageLabel1);

		imageLabel1.setBounds(40, 150, 100, 100);
		imageLabel1.setSize(125, 125);

		
		JLabel imageLabel2 = new JLabel(id);
		add(imageLabel2);

		imageLabel2.setBounds(240, 150, 100, 100);
		imageLabel2.setSize(125, 125);

		imageLabel.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, (new Color(194, 214, 214))));
		imageLabel1.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, (new Color(194, 214, 214))));
		imageLabel2.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, (new Color(194, 214, 214))));

		b1 = new JButton("Select");
		// b2 = new JButton("Cancel");

		b1.addActionListener(this);
		// b2.addActionListener(this);

		add(b1);
		// add(b2);

		b1.setBounds(210, 330, 175, 30);
		// b2.setBounds(350, 330, 175, 20);

		b1.setBackground(new Color(133, 173, 173));
		b1.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, (new Color(194, 214, 214))));
		
		getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, new Color(194,214,214)));
        setUndecorated(true);
		setVisible(true);
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int a=0;
		String x="";
		
		if (e.getSource() == b1) {
				if(jb[0].isSelected()==true) {
					a = 0;
					x = ic.getDescription();
					
				}else if(jb[1].isSelected()==true) {
					a = 1;
					x = id.getDescription();
				}else if(jb[2].isSelected()==true) {
					a = 2;
					x = im.getDescription();
				}
			dispose();
			z.dispose();
			new Table2_1(a, x);
			
	}
	}
	public static void main(String[] args) {
	}

}
