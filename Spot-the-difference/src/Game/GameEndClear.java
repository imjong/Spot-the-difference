package Game;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class GameEndClear extends JFrame {
	EventHandler event;
	
	JPanel pnBase = new JPanel(); //pnBase
	SizePanel pnBackGround = new SizePanel(new ImageIcon("./images/result/clear.gif"), 900, 900); // pnBackGround �̹��� ��ο� width, height ����
	JPanel pnBackGroundCenter; //pnBackGroundCenter
	JPanel pnBackGroundSouth; //pnBackGroundSouth
	
	SizeButton btBack = new SizeButton(new ImageIcon("./images/result/back-normal.png"),new ImageIcon("./images/result/back-normal.png"),new ImageIcon("./images/result/back-pressed.png"),268,127);
													// ��� ���                              // ���콺�� �÷�����                                 // ���콺�� ��������        //width //height
	
	/////////////////////////////////////////////////////////////////////////////
	public GameEndClear() {
		
		super("::Ʋ���׸�ã��::");
			
		setResizable(false); // â ������ �������� ���ϰ�
		
		Container cp = getContentPane();// getContentPane();
		pnBase.setBackground(Color.black);// pnBase setBackground����
		cp.add(pnBase);// cp�� pnBase����
		
		pnBackGround.setLayout(new BorderLayout());// pnBackGround ���̾ƿ� ���� BorderLayout()
		pnBase.add(pnBackGround,"Center");//pnBase�� pnBackGround���� "Center"
	
		pnBackGroundCenter= new JPanel() ;// pnBackGroundCenter��ü ����
		pnBackGroundCenter.setOpaque(false); // pnBackGroundCenter �����ϰ� ����
		pnBackGround.add(pnBackGroundCenter,"Center");//pnBackGround�� pnBackGroundCenter���� "Center"
	
		pnBackGroundSouth = new MyJPanel(0, 200, 15, 0); // pnBackGroundSouth��ü ���� & ���� ���� ����
		pnBackGroundSouth.setOpaque(false); // pnBackGroundSouth �����ϰ� ����
		pnBackGroundSouth.add(btBack);// pnBackGroundSouth�� btBack ����
		pnBackGround.add(pnBackGroundSouth,"South");//pnBackGround�� pnBackGroundSouth���� "South"
		
		event = new EventHandler(this);
		btBack.addActionListener(event);
		btBack.addMouseListener(event);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //[x]������ ����ȴ�
			
		setBounds(510, 48, 900, 945);
		setVisible(true);
		
	}//GameEndClear()
}