package Game;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class GameEndClear extends JFrame {
	EventHandler event;
	
	JPanel pnBase = new JPanel(); //pnBase
	SizePanel pnBackGround = new SizePanel(new ImageIcon("./images/result/clear.gif"), 900, 900); // pnBackGround 이미지 경로와 width, height 설정
	JPanel pnBackGroundCenter; //pnBackGroundCenter
	JPanel pnBackGroundSouth; //pnBackGroundSouth
	
	SizeButton btBack = new SizeButton(new ImageIcon("./images/result/back-normal.png"),new ImageIcon("./images/result/back-normal.png"),new ImageIcon("./images/result/back-pressed.png"),268,127);
													// 평소 모습                              // 마우스를 올렸을때                                 // 마우스를 눌렀을때        //width //height
	
	/////////////////////////////////////////////////////////////////////////////
	public GameEndClear() {
		
		super("::틀린그림찾기::");
			
		setResizable(false); // 창 사이즈 변경하지 못하게
		
		Container cp = getContentPane();// getContentPane();
		pnBase.setBackground(Color.black);// pnBase setBackground설정
		cp.add(pnBase);// cp에 pnBase부착
		
		pnBackGround.setLayout(new BorderLayout());// pnBackGround 레이아웃 설정 BorderLayout()
		pnBase.add(pnBackGround,"Center");//pnBase에 pnBackGround부착 "Center"
	
		pnBackGroundCenter= new JPanel() ;// pnBackGroundCenter객체 생성
		pnBackGroundCenter.setOpaque(false); // pnBackGroundCenter 투명하게 설정
		pnBackGround.add(pnBackGroundCenter,"Center");//pnBackGround에 pnBackGroundCenter부착 "Center"
	
		pnBackGroundSouth = new MyJPanel(0, 200, 15, 0); // pnBackGroundSouth객체 생성 & 안쪽 여백 설정
		pnBackGroundSouth.setOpaque(false); // pnBackGroundSouth 투명하게 설정
		pnBackGroundSouth.add(btBack);// pnBackGroundSouth에 btBack 부착
		pnBackGround.add(pnBackGroundSouth,"South");//pnBackGround에 pnBackGroundSouth부착 "South"
		
		event = new EventHandler(this);
		btBack.addActionListener(event);
		btBack.addMouseListener(event);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //[x]누르면 종료된다
			
		setBounds(510, 48, 900, 945);
		setVisible(true);
		
	}//GameEndClear()
}