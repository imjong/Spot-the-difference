package Game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameTitle extends JFrame {
	EventHandler event;
	
	JPanel pnBase;
	
	SizePanel pnNorth = new SizePanel(new ImageIcon("./images/title/title.gif"), 1200, 189); // pnNorth �̹��� ��ο� width, height ����
	
	SizePanel pnBackGround = new SizePanel(new ImageIcon("./images/title/main.gif"), 1200, 807, 50, 0, 50, 0); // pnBackGround �̹��� ��ο� width, height, ���ʿ��� ����
	
	JPanel pnCenter;
	
	JPanel pnCenterRight;
	
	SizeButton btStart = new SizeButton(new ImageIcon("./images/title/start-normal.png"),new ImageIcon("./images/title/start-entered.png"),new ImageIcon("./images/title/start-pressed.png"),200,200); // btStart �̹��� ��ο� width, height ����
													// ��� ���                              // ���콺�� �÷�����                                 // ���콺�� ��������        //width //height
	SizeButton btRanking = new SizeButton(new ImageIcon("./images/title/ranking-normal.png"),new ImageIcon("./images/title/ranking-entered.png"),new ImageIcon("./images/title/ranking-pressed.png"),200,200); // btRanking �̹��� ��ο� width, height ����
													// ��� ���                              // ���콺�� �÷�����                                 // ���콺�� ��������        //width //height
	SizeButton btExit = new SizeButton(new ImageIcon("./images/title/exit-normal.png"),new ImageIcon("./images/title/exit-entered.png"),new ImageIcon("./images/title/exit-pressed.png"),200,200); // btExit �̹��� ��ο� width, height ����
													// ��� ���                              // ���콺�� �÷�����                                 // ���콺�� ��������        //width //height
	
	/////////////////////////////////////////////////////////////////////////////
	public GameTitle() {
		
		super("::::: Ʋ �� �� �� ã �� :::::");
		
		setResizable(false); // â ������ �������� ���ϰ�
		
		Container cp = getContentPane(); // getContentPane();
		pnBase = new JPanel(); // pnBase��ü ����
		pnBase.setBackground(new Color(0xc0, 0xc0, 0xc0)); // pnBase setBackground����
		pnBase.setLayout(new BorderLayout()); // pnBase ���̾ƿ� ���� BorderLayout()
		cp.add(pnBase);// cp�� pnBase����
		
		pnNorth.setBackground(new Color(0xc0, 0xc0, 0xc0)); // pnNorth setBackground����
		pnBase.add(pnNorth,"North"); // pnBase�� pnNorth���� "North"
		
		pnBackGround.setLayout(new BorderLayout()); // pnBackGround ���̾ƿ� ���� BorderLayout()
		pnBase.add(pnBackGround, "Center"); // pnBase�� pnBackGround���� "Center"
		
		pnCenter = new JPanel(); // pnCenter��ü ����
		pnCenter.setLayout(new BorderLayout()); // pnCenter ���̾ƿ� ���� BorderLayout()
		pnCenter.setOpaque(false); // pnCenter �����ϰ� ����
		pnBackGround.add(pnCenter,"Center"); // pnBackGround�� pnCenter���� "Center"
		
		
		pnCenterRight = new MyJPanel(0, 0, 0, 45); // pnCenter��ü ���� & ���� ���� ����
		pnCenterRight.setLayout(new GridLayout(3, 1, 0, 10)); // pnCenterRight ���̾ƿ� ���� GridLayout(3�� 1��)
		pnCenterRight.setOpaque(false); // pnCenterRight �����ϰ� ����
		pnCenterRight.add(btStart); // pnCenterRight�� btStart ����
		pnCenterRight.add(btRanking); // pnCenterRight�� btRanking ����
		pnCenterRight.add(btExit); // pnCenterRight�� btExit ����
		pnCenter.add(pnCenterRight,"East"); // pnCenter�� pnCenterRight���� "East"
		
		
		event = new EventHandler(this);
		btStart.addActionListener(event);
		btStart.addMouseListener(event);

		btRanking.addActionListener(event);
		btRanking.addMouseListener(event);

		btExit.addActionListener(event);
		btExit.addMouseListener(event);
		
//		btStart.addMouseListener(GameTitleHandler);
//		btRanking.addMouseListener(GameTitleHandler);
//		btExit.addMouseListener(GameTitleHandler);
//		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //[x]������ ����ȴ�
		
		setBounds(360, 10, 1200, 1030);
		setVisible(true);
		
	}//GameTitle()
	
}