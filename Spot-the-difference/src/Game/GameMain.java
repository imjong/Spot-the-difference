package Game;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GameMain extends JFrame {
	
	EventHandler event;
	static int numOfCorAns = 0;				// GameMain.numOfCorAns
	
	static int iNumOfCorAns = 0;
	static int iClearTime = 0;
	
	public static final int gameCntNum = 60;	// ���ӽð�
	
	JPanel paneMain,
		paneGameCenter,	paneGameMenuTop, paneGameMenuRight, paneGameMenuLeft, paneGameMenuBot,
		paneGameMenuTop_cnt, paneGameMenuTop_life,
		paneGameMenuBot_cnt, paneGameMenuBot_cntBar, paneGameMenuBot_exit;
	JLabel  lblGameImg, lblGameCorrectCnt, lblGameTimeCnt, lblGameStage;
	JLabel[] lblGameLife = new JLabel[5];
	JButton btnLeftGame, btnRightGame, btnExitGame;
	
	ImageIcon imgPanel = new ImageIcon("./images/main/panel.png");
	ImageIcon imgLife = new ImageIcon("./images/main/life.png");
	ImageIcon imgLeftGame = new ImageIcon("./images/main/left_normal.png");
	ImageIcon imgRightGame = new ImageIcon("./images/main/right_normal.png");
	ImageIcon imgGiveup = new ImageIcon("./images/main/giveup_normal.png");
	ImageIcon imgLeftGame_hover = new ImageIcon("./images/main/left_pressed.png");
	ImageIcon imgRightGame_hover = new ImageIcon("./images/main/right_pressed.png");
	ImageIcon imgGiveup_hover = new ImageIcon("./images/main/giveup_pressed.png");
	MyLabel imgTime = new MyLabel(new ImageIcon("images/main/time.png"),100, 30);
	
	//Ÿ�����α׷����� ����ȯ�� �߰��� ����κ�////////////
	JProgressBar progressBar;
	MyProgressBar myProgressBar;
	MyTimer myTimer; 
	JLabel lbTimePicture;
	public final static int ONE_SECOND = 1000;
	
	
	//���� �̹������ �� ������ǥ ����
	String[][] gameInfo = {
			{ "./images/game_img/1.png", "295", "665" },
			{ "./images/game_img/2.png", "60", "630" },
			{ "./images/game_img/3.png", "705", "15" },
			{ "./images/game_img/4.png", "325", "145" },
			{ "./images/game_img/5.png", "635", "735" },
			{ "./images/game_img/6.png", "100", "710" },
			{ "./images/game_img/7.png", "55", "425" },
			{ "./images/game_img/8.png", "120", "565" },
			{ "./images/game_img/9.png", "105", "15" },
			{ "./images/game_img/10.png", "95", "490" },
			};
	
	ImageIcon[] imgGame = new ImageIcon[gameInfo.length];
	ImageIcon[] imgGame_ans = new ImageIcon[gameInfo.length];

	//�����̹��� ��� ImageIcon�迭�� �ʱ�ȭ
	public void setImgGame() {
		for (int i = 0; i < imgGame.length; i++) {
			imgGame[i] = new ImageIcon(gameInfo[i][0]);
		}
	}
	
	//�������� ��� ImageIcon�迭�� �ʱ�ȭ
	public void setImgGame_ans() {
		for (int i = 0; i < imgGame.length; i++) {
			imgGame_ans[i] = new ImageIcon("./images/game_img/"+ (i+1) +"_ans.png");
		}
	}
	
	
//------������ GameMain()
	public GameMain() {
		super("::Ʋ���׸�ã��::");
		setResizable(false);// â ������ �������� ���ϰ�
		
		Container cp = getContentPane();
		setImgGame();
		setImgGame_ans();
		initJComp();
		setBgColor();
		
		lblGameCorrectCnt.setFont(new Font("���", Font.BOLD, 32));
		lblGameTimeCnt.setFont(new Font("���", Font.BOLD, 32));
		
		//��ư ������ ����
		btnLeftGame.setPreferredSize(new Dimension(40, 100));
		btnRightGame.setPreferredSize(new Dimension(40, 100));
		btnExitGame.setPreferredSize(new Dimension(150, 50));
		
		//���̾ƿ�
		paneMain.setLayout(new BorderLayout());
		paneGameMenuTop.setLayout(new BorderLayout());//FlowLayout.LEFT,50,0)
		paneGameMenuBot.setLayout(new BorderLayout());
		
//////////����ȯ�� �߰��� �κ�(���α׷��� �� �κ�)//////
		paneGameMenuBot_cntBar.setLayout(new BorderLayout());
		paneGameMenuBot_cntBar.setBackground(Color.white);
		progressBar = new JProgressBar(0, 100);
		progressBar.setValue(100);
		
		//progressBar.setStringPainted(true); //�ۼ�Ʈ�� ������
		paneGameMenuBot_cntBar.add(progressBar, BorderLayout.CENTER);
		progressBar.setForeground(new Color(102, 57, 255));
		progressBar.setBackground(new Color(238, 238, 238));
		progressBar.setBorder(BorderFactory.createLineBorder(Color.black));
		myProgressBar = new MyProgressBar(progressBar, lblGameTimeCnt, gameCntNum); // �����ð� ����
		MyProgressBar.MyListener listener = myProgressBar.new MyListener();
		myTimer = new MyTimer(ONE_SECOND, gameCntNum, listener); //�����ð� ����
		listener.setMyTimer(myTimer);
		myTimer.start();
		lblGameTimeCnt.setText(Integer.toString(myTimer.getCurrnetTime()));

		
		//�����гο� ���� add
		cp.add(paneMain);
		paneMain.add(paneGameCenter, "Center");
		paneMain.add(paneGameMenuTop, "North");
		paneMain.add(paneGameMenuLeft, "West");
		paneMain.add(paneGameMenuRight, "East");
		paneMain.add(paneGameMenuBot, "South");

		//Center�� �����̹��� add
		paneGameCenter.add(lblGameImg);

		//����Panel�� label �ֱ�
		paneGameMenuTop_cnt.add(lblGameCorrectCnt);
		for (int i = 0; i < lblGameLife.length; i++) {
			paneGameMenuTop_life.add(lblGameLife[i]);
		}
		paneGameMenuBot_cnt.add(lblGameTimeCnt);
		
		//Top Panel�� �Ϻ�Panel add
		paneGameMenuTop.add(paneGameMenuTop_cnt, "West");
		paneGameMenuTop.add(paneGameMenuTop_life, "East");
		
		//Bot Panel�� �Ϻ�Panel add
		paneGameMenuBot_cnt.setLayout(new BorderLayout(20,0));
		paneGameMenuBot_cnt.add(imgTime,"West");		
		paneGameMenuBot_cnt.add(lblGameTimeCnt,"Center");
		
		
		paneGameMenuBot.add(paneGameMenuBot_cnt, "West");
		paneGameMenuBot.add(paneGameMenuBot_exit, "East");
		paneGameMenuBot.add(paneGameMenuBot_cntBar, "Center");


		event = new EventHandler(this);
		//��ư �׵θ� ����
		btnLeftGame.setBorderPainted(false);
		btnLeftGame.setContentAreaFilled(false);
		btnLeftGame.setFocusPainted(false);
		btnLeftGame.setOpaque(false);
		
		btnRightGame.setBorderPainted(false);
		btnRightGame.setContentAreaFilled(false);
		btnRightGame.setFocusPainted(false);
		btnRightGame.setOpaque(false);
		
		btnExitGame.setBorderPainted(false);
		btnExitGame.setContentAreaFilled(false);
		btnExitGame.setFocusPainted(false);
		btnExitGame.setOpaque(false);

		//��ư �׼� �̺�Ʈ
		btnLeftGame.addActionListener(event);
		btnRightGame.addActionListener(event);
		btnExitGame.addActionListener(event);
		//��ư ���콺 �̺�Ʈ
		btnLeftGame.addMouseListener(event);
		btnRightGame.addMouseListener(event);
		btnExitGame.addMouseListener(event);
		lblGameImg.addMouseListener(event);
		
		//Panel�� Button add
		paneGameMenuLeft.add(btnLeftGame);
		paneGameMenuRight.add(btnRightGame);
		paneGameMenuBot_exit.add(btnExitGame);

		setBounds(110, 10, 1700, 1030);
		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

//-----���� �ʱ�ȭ initJComp()
	public void initJComp() {
		//JPanel
		paneMain = new SizePanel(imgPanel, 1410, 1030);
		paneGameCenter = new JPanel();
		paneGameMenuTop = new MyJPanel(5, 0, 0, 0);
		paneGameMenuRight = new MyJPanel(400 , 0 , 0 , 0);
		paneGameMenuLeft = new MyJPanel(400 , 0 , 0 , 0);
		paneGameMenuBot = new MyJPanel(5 , 0 , 10 , 0);
		paneGameMenuTop_cnt = new MyJPanel(0, 50, 0, 0);
		paneGameMenuTop_life = new MyJPanel(0, 0, 0, 50);
		paneGameMenuBot_cnt = new MyJPanel(0, 70, 0, 0);
		paneGameMenuBot_cntBar = new MyJPanel(20, 20, 20, 20);
		paneGameMenuBot_exit = new MyJPanel(0, 0, 0, 50);

		paneGameCenter.setOpaque(false);
		paneGameMenuTop.setOpaque(false);
		paneGameMenuRight.setOpaque(false);
		paneGameMenuLeft.setOpaque(false);
		paneGameMenuBot.setOpaque(false);
		paneGameMenuTop_cnt.setOpaque(false);
		paneGameMenuTop_life.setOpaque(false);
		paneGameMenuBot_cnt.setOpaque(false);
		paneGameMenuBot_cntBar.setOpaque(false);
		paneGameMenuBot_exit.setOpaque(false);
		
		//JLabel
		lblGameImg = new JLabel(imgGame[0]);
		lblGameCorrectCnt = new JLabel("���� ���� : "+ GameMain.numOfCorAns +"/ 10");
		lblGameTimeCnt = new JLabel("999");
		for (int i = 0; i < lblGameLife.length; i++) {
			lblGameLife[i] = new JLabel(imgLife);
		}

		//JButton
		btnLeftGame = new JButton(imgLeftGame);
		btnRightGame = new JButton(imgRightGame);
		btnExitGame = new JButton(imgGiveup);
		
	}
	
//-----���ȭ�� ����setBgColor()
	public void setBgColor() {
		Color white = Color.WHITE;
		Color black = Color.BLACK;
		
		paneMain.setBackground(white);
		paneGameMenuTop.setBackground(white);
		paneGameMenuLeft.setBackground(white);
		paneGameMenuRight.setBackground(white);
		paneGameMenuBot.setBackground(white);
		paneGameMenuTop_cnt.setBackground(white);
		paneGameMenuTop_life.setBackground(white);
		paneGameMenuBot_cnt.setBackground(white);
		paneGameMenuBot_exit.setBackground(white);
		
		paneGameCenter.setBackground(black);
	}
}///////////////end of class GameMain
