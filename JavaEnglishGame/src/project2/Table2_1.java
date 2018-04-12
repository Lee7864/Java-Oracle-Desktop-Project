package project2;
/*��������� ���°� �ǽ���ȹ��, �����ͺ��̽��ϼ�. ��Ʈ�� ��ģ���� ä��������. 
 * �ǹ��� �ڱ��̷��̶� ��Ī�س����°�. �ڱ��� ���ּҸ� ����� �˾Ƴ������Ѵ�.  
 * �ڱ�������Ʈ �Ѱ��� ����� �����ϰ��ִ°�?
 * �������� ������Ģ���� �ϰ��ִ°�
 * */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;


public class Table2_1 extends JFrame 
{
	Image back;
	ImageIcon icon, icon0, icon1, icon2, hp,status;
	
	static int Bx = 1000, By = 1000; //âũ��
	int C1x1=140/3, C1y1=150, C1x2=(140/3)*2, C1y2=193; //ĳ��1
	static int Fx1=225 ,Fy1=10,Fy2=120, Fx; // ��Ÿ�� ������
	public static int Hfx1=35,Hfy1=200,Hfx2=170,Hx1=0,Hy1=0, Hx2=210;  //hp 210 x 90
	int z=1, cnt=1, D,Dtotal;  Random rd, cu= new Random(); //�ֻ���
	int current=cu.nextInt(19);//����ȭ��Ű�� 0~19����
	Boolean flag=false ;
	public static boolean EF=false;
	JPanel Chat; //�Ʒ� �α� �г�
	static JButton ext, di; //������� ������ ��ư
	
	//������ : ���� �ȿ��� Ŭ���� �������� ����.
	public Table2_1(int img, String stat) {
		System.out.println(img);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		icon = new ImageIcon("project2/back02.jpg");
		icon0 = new ImageIcon("project2/Ch"+img+".jpg"); //ĳ���� �ൿ�׸�����		
		hp = new ImageIcon("project2/HP.png");
		status = new ImageIcon(stat);
		
		// ��� Panel ������ �������������� ����
		JPanel background = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon. getImage(), 0, 0, Bx, By, null);
				setOpaque(false); // �׸��� ǥ���ϰ� ����,�����ϰ� ����
				super.paintComponent(g);
			}
			
			public void paintChildren(Graphics g) {
				
				g.drawImage(icon0.getImage(), Fx1, Fy1, Fx1+110, Fy1+110, C1x1, C1y1, C1x2, C1y2, null);//ĳ���� ����
				g.drawImage(status.getImage(), 10, 10, 190, 190, 5, 5, 145, 145, null);
				g.drawImage(hp.getImage(), Hfx1, Hfy1, Hfx2, Hfy1+50, Hx1, Hy1, Hx2/*�̳༮ ��ġ�� 70�� ����*/, Hy1+90, null);//hp
				setOpaque(false);
				super.paintChildren(g);
			}
		};
		
		
		//������ ��ư 							��ư������
		ext = new JButton("Exit");  	ext.setBounds(850, 800, 100, 100);
		
		
		//�ֻ��� ��ư							��ư ������
		di= new JButton("Click"); 	di.setBounds(865, 700, 70, 30); 
		di.addActionListener(new dice());

		//���̺�ü ����						������
		JTable t = new JTable(5, 4); t.setBackground(new Color(255, 0, 0, 0));//�����
		t.setLayout(null); t.setBounds(200, 0, 600, 800); t.setForeground(Color.WHITE);
		
		for (int i = 0; i < t.getRowCount(); i++) {
			if(cnt==1) {
				for (int j = 0; j < t.getColumnCount(); j++) {
					t.getColumnModel().getColumn(j).setPreferredWidth(Bx/7);
					t.setValueAt(z, i, j);  	z++;
				}
			}else if(cnt==2) {
				for (int j = t.getColumnCount()-1/*�÷��� ������ �����ִ� 4���ϱ� 0123 �̴� -1�� �������.*/; j > -1 ; j--) {
					t.getColumnModel().getColumn(j).setPreferredWidth(Bx/7);//1000/7 =142
					t.setValueAt(z, i, j);		z++;
					cnt=0;
				}
			} cnt++;
		}//for
		t.setRowHeight(By/7); //1000/7 = 142
		t.setEnabled(false);
		
		//â����
		background.setLayout(null);
		background.add(t); 	background.add(ext); 	background.add(di);
		add(background);
		setSize(Bx, By); setVisible(true); setResizable(false); 
		setBounds(570, 40, Bx, By); //��� ���߱�
		validate();
	}
	
	
	//�ֻ��� ����
	class dice implements ActionListener{
		int tempX, tempY=10, tempT;//������.
		int length=142;
		
		public void moveC() {
			while(true) {
				tempT-=length;
				//System.out.println(tempT);
				//System.out.println("Fx1 = "+Fx1+"   Flag ="+flag+"   Hfx1 : "+Hfx1  +"   Hfx2 : "+Hfx2 +" flag : "+flag);
				if(Fy1>=length*4 && Fx1 ==651) { Fy1=length*4; Fx1=651; di.setEnabled(false); Quiz.flag=true; QuizF(current);  repaint(); break; }
					if(flag==false) { //1��°��
						Quiz.flag=true;
						Fx1+=length;
						repaint();
						if(Fx1>651) {//������ĭ�� �Ѿ��
							Fx1=651;	Fy1+=length; 
							repaint();
							System.out.println("   dddd");
							
							if(tempT>=0) {//������ ���� �ϴ�.
								Fx1-=tempT;  QuizF(current); repaint(); flag=true; System.out.println("   dddd"); break;
							}
						}
						else if(Fx1==(tempX+Dtotal)) { QuizF(current); repaint(); break;}
					}else if(flag==true) {
						Fx1-=length;
						repaint();
						if(Fx1<225) {
							Fx1=225;	Fy1+=length;
							repaint();
							if(tempT>=0) {
								Fx1+=tempT; flag=false; repaint(); QuizF(current); break;
							}
						}else if(Fx1==(tempX-Dtotal)) {
							repaint(); QuizF(current); break;
						}
						if(Fy1>=length*4 && Fx1 ==651) { Fy1=length*4; Fx1=651; di.setEnabled(false); Quiz.flag=true; QuizF(current);  repaint(); break; }
					}
					//System.out.println("2   Fx1 = "+Fx1+"   Flag ="+flag+"   Hfx1 : "+Hfx1  +"   Hfx2 : "+Hfx2 +" flag : "+flag);
			}//while
		}//move
		
		public void QuizF(int cur) {
			new Quiz("Online Test Of Java", cur);
			current=cu.nextInt(19);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			rd = new Random(); /*random ��ü�� ����������� nullpointerexception ������ �ذ�ȴ�.*/
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("Click")) {
				D = rd.nextInt(3)+1;  Dtotal = (1000/7)*D; //������ ���簢��
				b.setEnabled(EF); //�ٵǸ� ��Ȱ��ȭ�����ϱ�.
				System.out.println("dice : "+D);
				Table2_1.this.setTitle(b.getText());
				tempX = Fx1; cnt = D; tempT=Dtotal;
				moveC();
			}//if
		}//actionperformed
	}//dice
	
	//�޸��� ����.
	class ChR implements Runnable{
		@Override
		public void run() {
			try {
					//C1x1=140/3; C1y1=336; C1x2=144; C1y2=384;
					Thread.sleep(100);
					//C1x1=0; C1y1=336; C1x2=48; C1y2=384;
					Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

//���ӿ���â ����
class GOver extends JFrame{
	
	JButton GB1 = new JButton("Try again"), GB2 = new JButton("No");
	JLabel GL1= new JLabel(); 
	int Gcnt=0;
	ImageIcon backg1= new ImageIcon("project2/gameover.jpg");
	String GS[] = {"��� �Ĺ��� ���ȴ�.. �ٽ� �ҷ�?", "�ܱ�� �� ��ġ���ع��ȴ�...", "������ �̷�����ΰ�...?", "���� ������ �ʹ�.."};
	BorderLayout borderlay = new BorderLayout();
	JPanel G1= new JPanel(), G2 = new JPanel();
	JPanel background = new JPanel() {
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(backg1.getImage(), 0, 0, 400, 400,  null);
		}
	};
	public GOver() {
		setTitle("Game over");	setSize(400, 400);	setVisible(true); setBounds(570+(Table2_1.Bx/2)-200, 40+(Table2_1.By/2)-200, 400, 400); //Gâ����
		background.setLayout(new BorderLayout());
		
		//��ü���� �� ����
		G1.setLayout(borderlay);
		if(Gcnt>3) { Gcnt=0;}
		GL1.setText(GS[Gcnt]); GL1.setForeground(Color.white);	GL1.setHorizontalAlignment(SwingConstants.CENTER);
		Gcnt++;
		G2.add(GB1); 	G2.add(GB2); G1.setOpaque(false); G2.setOpaque(false);
		G1.add(GL1, BorderLayout.CENTER); G1.add(G2, BorderLayout.SOUTH); 
		background.add(G1);
		add(background);
		validate();
	}
}
