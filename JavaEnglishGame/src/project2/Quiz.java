
package project2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.ButtonUI;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.OptionPaneUI;
import javax.swing.plaf.PanelUI;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.plaf.metal.MetalBorders.OptionDialogBorder;
import project2.Table2_1;

class Quiz extends JFrame implements ActionListener {

	JLabel l;
	JRadioButton jb[] = new JRadioButton[5];
	JButton b1, b2, b3, b4;
	ButtonGroup bg;
	Container d = getContentPane();
	UIManager UI = new UIManager();
	JOptionPane jp = new JOptionPane();
	static boolean flag = false;
	
	int ssd[][]=new int[20][];
	int CO[] = {0,3,1,3,0,0,0,2,3,3,1,2,0,2,3,3,1,1,1,3};  

	int count = 0, current = 0, x = 1, y = 1, now = 0;
	int m[] = new int[10];

	Quiz(String s, int cur) {
		super(s);
		l = new JLabel();
		add(l);
		current=cur;
		bg = new ButtonGroup();
		for (int i = 0; i < 5; i++) {
			jb[i] = new JRadioButton();
			add(jb[i]);
			bg.add(jb[i]);
		}
		
		//���߹迭 ����
		
		for (int i = 0; i < 20; i++) {
			ssd[i] = new int[2];
			
				ssd[i][0]=i;
				ssd[i][1]=CO[i];
				
			
		}
		

		b1 = new JButton("Next");
		b2 = new JButton("Choose");
		b3 = new JButton("Quit");
		b4 = new JButton("Previous");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);

		add(b1);
		add(b2);
		add(b3);
		add(b4);
		set();

		l.setBounds(30, 40, 450, 20);
		jb[0].setBounds(45, 100, 100, 20);
		jb[1].setBounds(45, 130, 100, 20);
		jb[2].setBounds(45, 160, 100, 20);
		jb[3].setBounds(45, 190, 100, 20);
		b1.setBounds(45, 250, 100, 30);
		b2.setBounds(200, 250, 100, 30);
		b3.setBounds(350, 250, 100, 30);
		b4.setBounds(500, 250, 100, 30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLocation(600, 300);
		setUndecorated(true);
		setLayout(null);
		setVisible(true);
		
		setSize(650, 350);

		setResizable(true);
		;
		setTitle("Solve the problem");
		d.setBackground(new Color(159, 188, 223));

		b1.setBackground(new Color(105, 145, 201));
		b2.setBackground(new Color(105, 145, 201));
		b3.setBackground(new Color(105, 145, 201));
		b4.setBackground(new Color(105, 145, 201));

		jb[0].setBackground(new Color(159, 188, 223));
		jb[1].setBackground(new Color(159, 188, 223));
		jb[2].setBackground(new Color(159, 188, 223));
		jb[3].setBackground(new Color(159, 188, 223));
		b1.setFont(new Font("Verdana", Font.BOLD, 12));
		b2.setFont(new Font("Verdana", Font.BOLD, 12));
		b3.setFont(new Font("Verdana", Font.BOLD, 12));
		b4.setFont(new Font("Verdana", Font.BOLD, 12));
		l.setFont(new Font("Verdana", Font.BOLD, 13));
		jb[0].setFont(new Font("Verdana", Font.BOLD, 13));
		jb[1].setFont(new Font("Verdana", Font.BOLD, 13));
		jb[2].setFont(new Font("Verdana", Font.BOLD, 13));
		jb[3].setFont(new Font("Verdana", Font.BOLD, 13));
		l.setSize(550, 55);

		for (int i = 0; i < 4; i++) {
			jb[i].setSize(300, 20);
		}

		getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, (new Color(199, 214, 235))));
		b1.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, (new Color(199, 214, 235))));
		b2.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, (new Color(199, 214, 235))));
		b3.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, (new Color(199, 214, 235))));
		b4.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, (new Color(199, 214, 235))));

		UI.put("OptionPane.background", new ColorUIResource(223, 159, 159));
		UI.put("Panel.background", new ColorUIResource(223, 159, 159));
		
		
		
		setOpacity(0.85f);

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == b1) {
			current++;
			set();
		}

		if (e.getSource() == b2) {
			System.out.println("current : "+ssd[current][0] + " Jb[] : " +ssd[current][1]);
			if(Table2_1.Hfx1>=Table2_1.Hfx2) { 
				JOptionPane.showMessageDialog(null, "�־��� â�� ����ָ� �ǰ���.");
				
				return;
			}
			if(Table2_1.Fx1>=651 && Table2_1.Fy1>=142*4 && flag ==true) {
				if (current == ssd[current][0] && jb[ssd[current][1]].isSelected()) {//�´ٸ�
					new  Stageclear();
					return;
				} else if (current == ssd[current][0] && !jb[ssd[current][1]].isSelected()) {//�ƴ϶��
					new  GOver();
					return;
					
				}
				
			}

			if (current == ssd[current][0] && jb[ssd[current][1]].isSelected()) {//�´ٸ�
				JOptionPane.showMessageDialog(null, "Correct Answer! Keep Going"); 
				Table2_1.di.setEnabled(true);
				dispose();
			} else if (current == ssd[current][0] && !jb[ssd[current][1]].isSelected()) {//�ƴ϶��

				JOptionPane.showMessageDialog(null, "Wrong Answer! You lose 1 life ", "sorry",
						JOptionPane.ERROR_MESSAGE);
					Table2_1.di.setEnabled(true);
						Table2_1.Hx2-=70;
						Table2_1.Hfx2-=45;
						dispose();
			}
			
			/*if (current == 1 && jb[3].isSelected()) {

				JOptionPane.showMessageDialog(null, "Correct Answer! Keep Going");
				Table2_1.di.setEnabled(true);
				dispose();
			} else if (current == 1 && !jb[3].isSelected()) {

				JOptionPane.showMessageDialog(null, "Wrong Answer! You lose 1 life ", "sorry",
						JOptionPane.ERROR_MESSAGE);
				Table2_1.di.setEnabled(true);
				Table2_1.Hx2-=70;
				Table2_1.Hfx2-=45;
				dispose();
			}

			if (current == 2 && jb[1].isSelected()) {

				JOptionPane.showMessageDialog(null, "Correct Answer! Keep Going");
				Table2_1.di.setEnabled(true);
				dispose();
			} else if (current == 2 && !jb[1].isSelected()) {

				JOptionPane.showMessageDialog(null, "Wrong Answer! You lose 1 life ", "sorry",
						JOptionPane.ERROR_MESSAGE);
				Table2_1.di.setEnabled(true);
				Table2_1.Hx2-=70;
				Table2_1.Hfx2-=45;
				dispose();
			}

			if (current == 3 && jb[3].isSelected()) {

				JOptionPane.showMessageDialog(null, "Correct Answer! Keep Going");
				Table2_1.di.setEnabled(true);
				dispose();
			} else if (current == 3 && !jb[3].isSelected()) {

				JOptionPane.showMessageDialog(null, "Wrong Answer! You lose 1 life ", "sorry",
						JOptionPane.ERROR_MESSAGE);
				Table2_1.di.setEnabled(true);
				Table2_1.Hx2-=70;
				Table2_1.Hfx2-=45;
				dispose();
			}

			if (current == 4 && jb[0].isSelected()) {

				JOptionPane.showMessageDialog(null, "Correct Answer! Keep Going");
				Table2_1.di.setEnabled(true);
				dispose();
			} else if (current == 4 && !jb[0].isSelected()) {

				JOptionPane.showMessageDialog(null, "Wrong Answer! You lose 1 life ", "sorry",
						JOptionPane.ERROR_MESSAGE);
				Table2_1.di.setEnabled(true);
				Table2_1.Hx2-=70;
				Table2_1.Hfx2-=45;
				dispose();
			}

			if (current == 5 && jb[0].isSelected()) {

				JOptionPane.showMessageDialog(null, "Correct Answer! Keep Going");
				Table2_1.di.setEnabled(true);
				dispose();
			} else if (current == 5 && !jb[0].isSelected()) {

				JOptionPane.showMessageDialog(null, "Wrong Answer! You lose 1 life ", "sorry",
						JOptionPane.ERROR_MESSAGE);
				Table2_1.di.setEnabled(true);
				Table2_1.Hx2-=70;
				Table2_1.Hfx2-=45;
				dispose();
			}

			if (current == 6 && jb[0].isSelected()) {

				JOptionPane.showMessageDialog(null, "Correct Answer! Keep Going");
				Table2_1.di.setEnabled(true);
				dispose();
			} else if (current == 6 && !jb[0].isSelected()) {

				JOptionPane.showMessageDialog(null, "Wrong Answer! You lose 1 life ", "sorry",
						JOptionPane.ERROR_MESSAGE);
				Table2_1.di.setEnabled(true);
				Table2_1.Hx2-=70;
				Table2_1.Hfx2-=45;
				dispose();
			}

			if (current == 7 && jb[2].isSelected()) {

				JOptionPane.showMessageDialog(null, "Correct Answer! Keep Going");
				Table2_1.di.setEnabled(true);
				dispose();
			} else if (current == 7 && !jb[2].isSelected()) {

				JOptionPane.showMessageDialog(null, "Wrong Answer! You lose 1 life ", "sorry",
						JOptionPane.ERROR_MESSAGE);
				Table2_1.di.setEnabled(true);
				Table2_1.Hx2-=70;
				Table2_1.Hfx2-=45;
				dispose();
			}

			if (current == 8 && jb[3].isSelected()) {

				JOptionPane.showMessageDialog(null, "Correct Answer! Keep Going");
				Table2_1.di.setEnabled(true);
				dispose();
			} else if (current == 8 && !jb[3].isSelected()) {

				JOptionPane.showMessageDialog(null, "Wrong Answer! You lose 1 life ", "sorry",
						JOptionPane.ERROR_MESSAGE);
				Table2_1.di.setEnabled(true);
				Table2_1.Hx2-=70;
				Table2_1.Hfx2-=45;
				dispose();
			}

			if (current == 9 && jb[3].isSelected()) {

				JOptionPane.showMessageDialog(null, "Correct Answer! Keep Going");
				Table2_1.di.setEnabled(true);
				dispose();
			} else if (current == 9 && !jb[3].isSelected()) {

				JOptionPane.showMessageDialog(null, "Wrong Answer! You lose 1 life ", "sorry",
						JOptionPane.ERROR_MESSAGE);
				Table2_1.di.setEnabled(true);
				Table2_1.Hx2-=70;
				Table2_1.Hfx2-=45;
				dispose();
			}

			if (current == 10 && jb[1].isSelected()) {

				JOptionPane.showMessageDialog(null, "Correct Answer! Keep Going");
				Table2_1.di.setEnabled(true);
				dispose();
			} else if (current == 10 && !jb[1].isSelected()) {

				JOptionPane.showMessageDialog(null, "Wrong Answer! You lose 1 life ", "sorry",
						JOptionPane.ERROR_MESSAGE);
				Table2_1.di.setEnabled(true);
				Table2_1.Hx2-=70;
				Table2_1.Hfx2-=45;
				dispose();
			}

			if (current == 11 && jb[2].isSelected()) {

				JOptionPane.showMessageDialog(null, "Correct Answer! Keep Going");
				Table2_1.di.setEnabled(true);
				dispose();
			} else if (current == 11 && !jb[2].isSelected()) {

				JOptionPane.showMessageDialog(null, "Wrong Answer! You lose 1 life ", "sorry",
						JOptionPane.ERROR_MESSAGE);
				Table2_1.di.setEnabled(true);
				Table2_1.Hx2-=70;
				Table2_1.Hfx2-=45;
				dispose();
			}

			if (current == 12 && jb[0].isSelected()) {

				JOptionPane.showMessageDialog(null, "Correct Answer! Keep Going");
				Table2_1.di.setEnabled(true);
				dispose();
			} else if (current == 12 && !jb[0].isSelected()) {

				JOptionPane.showMessageDialog(null, "Wrong Answer! You lose 1 life ", "sorry",
						JOptionPane.ERROR_MESSAGE);
				Table2_1.di.setEnabled(true);
				Table2_1.Hx2-=70;
				Table2_1.Hfx2-=45;
				dispose();
			}

			if (current == 13 && jb[2].isSelected()) {

				JOptionPane.showMessageDialog(null, "Correct Answer! Keep Going");
				Table2_1.di.setEnabled(true);
				dispose();
			} else if (current == 13 && !jb[2].isSelected()) {

				JOptionPane.showMessageDialog(null, "Wrong Answer! You lose 1 life ", "sorry",
						JOptionPane.ERROR_MESSAGE);
				Table2_1.di.setEnabled(true);
				Table2_1.Hx2-=70;
				Table2_1.Hfx2-=45;
				dispose();
			}

			if (current == 14 && jb[3].isSelected()) {

				JOptionPane.showMessageDialog(null, "Correct Answer! Keep Going");
				Table2_1.di.setEnabled(true);
				dispose();
			} else if (current == 14 && !jb[3].isSelected()) {

				JOptionPane.showMessageDialog(null, "Wrong Answer! You lose 1 life ", "sorry",
						JOptionPane.ERROR_MESSAGE);
				Table2_1.di.setEnabled(true);
				Table2_1.Hx2-=70;
				Table2_1.Hfx2-=45;
				dispose();
			}

			if (current == 15 && jb[3].isSelected()) {

				JOptionPane.showMessageDialog(null, "Correct Answer! Keep Going");
				Table2_1.di.setEnabled(true);
				dispose();
			} else if (current == 15 && !jb[3].isSelected()) {

				JOptionPane.showMessageDialog(null, "Wrong Answer! You lose 1 life ", "sorry",
						JOptionPane.ERROR_MESSAGE);
				Table2_1.di.setEnabled(true);
				Table2_1.Hx2-=70;
				Table2_1.Hfx2-=45;
				dispose();
			}

			if (current == 16 && jb[1].isSelected()) {

				JOptionPane.showMessageDialog(null, "Correct Answer! Keep Going");
				Table2_1.di.setEnabled(true);
				dispose();
			} else if (current == 16 && !jb[1].isSelected()) {

				JOptionPane.showMessageDialog(null, "Wrong Answer! You lose 1 life ", "sorry",
						JOptionPane.ERROR_MESSAGE);
				Table2_1.di.setEnabled(true);
				Table2_1.Hx2-=70;
				Table2_1.Hfx2-=45;
				dispose();
			}

			if (current == 17 && jb[1].isSelected()) {

				JOptionPane.showMessageDialog(null, "Correct Answer! Keep Going");
				Table2_1.di.setEnabled(true);
				dispose();
			} else if (current == 17 && !jb[1].isSelected()) {

				JOptionPane.showMessageDialog(null, "Wrong Answer! You lose 1 life ", "sorry",
						JOptionPane.ERROR_MESSAGE);
				Table2_1.di.setEnabled(true);
				Table2_1.Hx2-=70;
				Table2_1.Hfx2-=45;
				dispose();
			}

			if (current == 18 && jb[1].isSelected()) {

				JOptionPane.showMessageDialog(null, "Correct Answer! Keep Going");
				Table2_1.di.setEnabled(true);
				dispose();
			} else if (current == 18 && !jb[1].isSelected()) {

				JOptionPane.showMessageDialog(null, "Wrong Answer! You lose 1 life ", "sorry",
						JOptionPane.ERROR_MESSAGE);
				Table2_1.di.setEnabled(true);
				Table2_1.Hx2-=70;
				Table2_1.Hfx2-=45;
				dispose();
			}

			if (current == 19 && jb[3].isSelected()) {

				JOptionPane.showMessageDialog(null, "Congratulations! You've won the game!");
				Table2_1.di.setEnabled(true);
				dispose();

			} else if (current == 19 && !jb[3].isSelected()) {

				JOptionPane.showMessageDialog(null, "Wrong Answer! You lose 1 life ", "sorry",
						JOptionPane.ERROR_MESSAGE);
				Table2_1.di.setEnabled(true);
				Table2_1.Hx2-=70;
				Table2_1.Hfx2-=45;
				dispose();
			}*/
			
			if(current>19) { current=19; return;}
			if(Table2_1.Hfx1>=Table2_1.Hfx2) { 
				new GOver();
			}
		}

		if (e.getSource() == b3) {
			JOptionPane.showMessageDialog(null, "You don't get out this place");
		}

		if (e.getSource() == b4) {
			current--;
			set();
		}
	}

	void set() {
		jb[4].setSelected(true);
		if (current == 0) {
			l.setText(
					"<html>Quiz1: About 9 million of the approximate 15 million Mormons live in North America. Which continent has the next highest Mormon membership?</html>");
			jb[0].setText("South America");//
			jb[1].setText("Asia");
			jb[2].setText("Oceania");
			jb[3].setText("Europe");

		}
		if (current == 1) {
			l.setText("Quiz2: Which of these is not part of the Ivy League?");
			jb[0].setText("Columbia");
			jb[1].setText("Dartmouth");
			jb[2].setText("Princeton");
			jb[3].setText("MIT");//
		}
		if (current == 2) {
			l.setText("Quiz3: Which of these films was NOT directed by Steven Spielberg?");
			jb[0].setText("Jaws");
			jb[1].setText("The Goonies");//
			jb[2].setText("The Color Purple");
			jb[3].setText("Hook");
		}
		if (current == 3) {
			l.setText(
					"<html>Quiz4: Which of the following countries does NOT have a population<br> exceeding 200 million?</html>");
			jb[0].setText("Indonesia");
			jb[1].setText("United Stated");
			jb[2].setText("Brazil");
			jb[3].setText("Nigeria");//
		}
		if (current == 4) {
			l.setText("<html>Quiz5: The flag of which country is the only non-rectangular national flag?</html>");
			jb[0].setText("Nepal");//
			jb[1].setText("Vatican City");
			jb[2].setText("Switzerland");
			jb[3].setText("Bhutan");
		}
		if (current == 5) {
			l.setText(
					"<html>Quiz6: What percentage of Canadians are estimated to live within 100 miles of the US border?</html>");
			jb[0].setText("75%");//
			jb[1].setText("90%");
			jb[2].setText("50%");
			jb[3].setText("10%");
		}
		if (current == 6) {
			l.setText("Quiz7: Which city's famous nickname is the 'Pearl of the Orient'?");
			jb[0].setText("Hong Kong");//
			jb[1].setText("Taipei");
			jb[2].setText("Kyoto");
			jb[3].setText("Singapore");
		}
		if (current == 7) {
			l.setText("Quiz8: Which celebrity was not born in the U.S.?");
			jb[0].setText("Kanye West");
			jb[1].setText("Michael Jordan");
			jb[2].setText("Arnold Schwarzenegger");//
			jb[3].setText("Chris Pratt");
		}
		if (current == 8) {
			l.setText("Quiz9: Which of these movies was not based on a book?");
			jb[0].setText("Jurassic Park");
			jb[1].setText("The Godfather");
			jb[2].setText("Blade Runner");
			jb[3].setText("Titanic");//
		}
		if (current == 9) {
			l.setText("<html>Quiz10: Which of these comic book superheroes does not belong to Marvel?</html>");
			jb[0].setText("Deadpool");
			jb[1].setText("The Hulk");
			jb[2].setText("Ant-Man");
			jb[3].setText("Wonder Woman");//
		}
		if (current == 10) {
			l.setText("Quiz11: On which island was Napoleon born?");
			jb[0].setText("Majorca");
			jb[1].setText("Corsica");//
			jb[2].setText("Sardinia");
			jb[3].setText("Sicily");
		}
		if (current == 11) {
			l.setText(
					"<html>Quiz12: Who was appointed the prime minister of Britain in 1940 to replace Neville Chamberlain, a few days before the invasion of France?</html>");
			jb[0].setText("Eamon de Valera");
			jb[1].setText("Anthony Eden");
			jb[2].setText("Winston Churchill");//
			jb[3].setText("Clement Atlee");
		}
		if (current == 12) {
			l.setText(
					"<html>Quiz13: Which of these teams have been the English Football Champions the most times?</html>");
			jb[0].setText("Manchester United");//
			jb[1].setText("Liverpool");
			jb[2].setText("Manchester City");
			jb[3].setText("Chelsea");
		}
		if (current == 13) {
			l.setText("Quiz14: What is the correct name for a Jewish place of worship??");
			jb[0].setText("Pagoda");
			jb[1].setText("Church");
			jb[2].setText("Synagogue");//
			jb[3].setText("Mosque");
		}
		if (current == 14) {
			l.setText(
					"<html>Quiz15: Which modern body of water is commonly believed to be the site of Moses and the Israelites' crossing during their exodus from the Egypt?</html>");
			jb[0].setText("Dead Sea");
			jb[1].setText("Jordan River");
			jb[2].setText("Red Sea");
			jb[3].setText("Suez Canal");//
		}
		if (current == 15) {
			l.setText("Quiz16: Which of these quantities is largest?");
			jb[0].setText("Three Pints");
			jb[1].setText("Two Litres");
			jb[2].setText("Four Cups");
			jb[3].setText("Two Gallon");//
		}
		if (current == 16) {
			l.setText(
					"<html> Quiz17: Which of these countries was considered part of the Axis in World War II?</html>");
			jb[0].setText("United Kingdom");
			jb[1].setText("Japan");//
			jb[2].setText("France");
			jb[3].setText("China");
		}
		if (current == 17) {
			l.setText(
					"<html>Quiz18 : Who did Donald Trump defeat in the 2016 election to become the US President?</html>");
			jb[0].setText("Bernie Sanders");
			jb[1].setText("Hillary Clinton");//
			jb[2].setText("Barack Obama");
			jb[3].setText("John McCain");
		}
		if (current == 18) {
			l.setText("<html>Quiz19: Which country has the highest population density of any in the world?</html>");
			jb[0].setText("Singapore");
			jb[1].setText("Monaco");//
			jb[2].setText("Bangladesh");
			jb[3].setText("Vatican City");
		}
		if (current == 19) {
			l.setText("Quiz20: What is the most spoken language in the world?");
			jb[0].setText("Arabic");
			jb[1].setText("Spanish");
			jb[2].setText("English");
			jb[3].setText("Mandarin");//
		}

	}

	public static void main(String s[]) {
		
	}
}
