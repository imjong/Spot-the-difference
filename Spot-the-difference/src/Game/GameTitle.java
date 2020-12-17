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
	
	SizePanel pnNorth = new SizePanel(new ImageIcon("./images/title/title.gif"), 1200, 189); // pnNorth 이미지 경로와 width, height 설정
	
	SizePanel pnBackGround = new SizePanel(new ImageIcon("./images/title/main.gif"), 1200, 807, 50, 0, 50, 0); // pnBackGround 이미지 경로와 width, height, 안쪽여백 설정
	
	JPanel pnCenter;
	
	JPanel pnCenterRight;
	
	SizeButton btStart = new SizeButton(new ImageIcon("./images/title/start-normal.png"),new ImageIcon("./images/title/start-entered.png"),new ImageIcon("./images/title/start-pressed.png"),200,200); // btStart 이미지 경로와 width, height 설정
													// 평소 모습                              // 마우스를 올렸을때                                 // 마우스를 눌렀을때        //width //height
	SizeButton btRanking = new SizeButton(new ImageIcon("./images/title/ranking-normal.png"),new ImageIcon("./images/title/ranking-entered.png"),new ImageIcon("./images/title/ranking-pressed.png"),200,200); // btRanking 이미지 경로와 width, height 설정
													// 평소 모습                              // 마우스를 올렸을때                                 // 마우스를 눌렀을때        //width //height
	SizeButton btExit = new SizeButton(new ImageIcon("./images/title/exit-normal.png"),new ImageIcon("./images/title/exit-entered.png"),new ImageIcon("./images/title/exit-pressed.png"),200,200); // btExit 이미지 경로와 width, height 설정
													// 평소 모습                              // 마우스를 올렸을때                                 // 마우스를 눌렀을때        //width //height
	
	/////////////////////////////////////////////////////////////////////////////
	public GameTitle() {
		
		super("::::: 틀 린 그 림 찾 기 :::::");
		
		setResizable(false); // 창 사이즈 변경하지 못하게
		
		Container cp = getContentPane(); // getContentPane();
		pnBase = new JPanel(); // pnBase객체 생성
		pnBase.setBackground(new Color(0xc0, 0xc0, 0xc0)); // pnBase setBackground설정
		pnBase.setLayout(new BorderLayout()); // pnBase 레이아웃 설정 BorderLayout()
		cp.add(pnBase);// cp에 pnBase부착
		
		pnNorth.setBackground(new Color(0xc0, 0xc0, 0xc0)); // pnNorth setBackground설정
		pnBase.add(pnNorth,"North"); // pnBase에 pnNorth부착 "North"
		
		pnBackGround.setLayout(new BorderLayout()); // pnBackGround 레이아웃 설정 BorderLayout()
		pnBase.add(pnBackGround, "Center"); // pnBase에 pnBackGround부착 "Center"
		
		pnCenter = new JPanel(); // pnCenter객체 생성
		pnCenter.setLayout(new BorderLayout()); // pnCenter 레이아웃 설정 BorderLayout()
		pnCenter.setOpaque(false); // pnCenter 투명하게 설정
		pnBackGround.add(pnCenter,"Center"); // pnBackGround에 pnCenter부착 "Center"
		
		
		pnCenterRight = new MyJPanel(0, 0, 0, 45); // pnCenter객체 생성 & 안쪽 여백 설정
		pnCenterRight.setLayout(new GridLayout(3, 1, 0, 10)); // pnCenterRight 레이아웃 설정 GridLayout(3행 1열)
		pnCenterRight.setOpaque(false); // pnCenterRight 투명하게 설정
		pnCenterRight.add(btStart); // pnCenterRight에 btStart 부착
		pnCenterRight.add(btRanking); // pnCenterRight에 btRanking 부착
		pnCenterRight.add(btExit); // pnCenterRight에 btExit 부착
		pnCenter.add(pnCenterRight,"East"); // pnCenter에 pnCenterRight부착 "East"
		
		
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //[x]누르면 종료된다
		
		setBounds(360, 10, 1200, 1030);
		setVisible(true);
		
	}//GameTitle()
	
}