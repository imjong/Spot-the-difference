package Game;
import javax.swing.*;
import java.awt.*;

public class GameRank extends JFrame {
	EventHandler event;
	
	JPanel pnBase, pnHead, pnBtn, pnFoot;
	JLabel lbHead, lbEasy, lbNormal, lbHard;
	JButton btFoot = new JButton("�� �� �� �� ��");
	
	String strId;
	int iNumOfCorAns_rank;
	int iClearTime_rank;
	
	//GameRank() ������
	public GameRank() {
		super("::::: Ʋ �� �� �� ã �� :::::");
		setResizable(false);
		
		init();
		
		Container cp = getContentPane();
		cp.add(pnBase);
		
		pnBase.setSize(350, 500);
		pnBase.setLayout(new BorderLayout(0, 40));
		pnBase.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 20)); // ��, ��, ��, ���� ������ ����.
		
		Color pnBaseColor = new Color(0xf0, 0xf0, 0xf0);
		pnBase.setBackground(pnBaseColor);
		
		pnBase.add(pnHead,BorderLayout.NORTH);
		pnHead.add(lbHead);
		pnHead.setBackground(pnBaseColor);
		lbHead.setFont(new Font("�������",Font.BOLD,40)); //�۾��� ���� , ũ�⸦ ����
		
		Color lbColor = new Color(124, 86, 255);
		lbHead.setForeground(lbColor);
		
		pnBase.add(pnBtn,BorderLayout.CENTER);
		
		pnBtn.setBackground(pnBaseColor);
		pnBtn.setLayout(new GridLayout(3,1,0,15));
		pnBtn.add(lbEasy);
		pnBtn.add(lbNormal);
		pnBtn.add(lbHard);

		lbEasy.setBackground(new Color(251,255,137));
		lbNormal.setBackground(new Color(255, 235, 137));
		lbHard.setBackground(new Color(255, 137, 137));
		
		lbEasy.setFont(new Font("�������",Font.BOLD,30));
		lbNormal.setFont(new Font("�������",Font.BOLD,30));
		lbHard.setFont(new Font("�������",Font.BOLD,30));
		btFoot.setFont(new Font("�������",Font.BOLD,20));
		
		pnBase.add(pnFoot,BorderLayout.SOUTH);
		pnFoot.setBackground(pnBaseColor);
		pnFoot.add(btFoot);
		
		event = new EventHandler(this);
		btFoot.addActionListener(event);
		
		setBounds(750, 250, 350, 500);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void init() {
		pnBase = new JPanel();
		pnHead = new JPanel();
		pnBtn = new JPanel();
		pnFoot = new JPanel();
		lbHead = new JLabel("�� �� �� �� �� ��");
		lbEasy 	= new JLabel("ID   :   User", JLabel.CENTER);
		lbNormal= new JLabel("���� ����   :   0   ��", JLabel.CENTER);
		lbHard 	= new JLabel("���� �ð�   :   0   ��", JLabel.CENTER);
	}
	
	public void updateRank() {
		strId = GameLogin.ID;
		int iNumOfCorAns = GameMain.iNumOfCorAns;
		int iClearTime = GameMain.iClearTime;
		
		if(iNumOfCorAns_rank < iNumOfCorAns) {
			iNumOfCorAns_rank = iNumOfCorAns;
			iClearTime_rank = iClearTime;
			
			lbEasy.setText("I D  :  "+ strId);
			lbNormal.setText("���� ����  :  "+ iNumOfCorAns_rank +" ��");
			lbHard.setText("���� �ð�  :  "+ iClearTime_rank + " ��");
			
		} else if(iNumOfCorAns_rank == iNumOfCorAns) {
			if(iClearTime_rank < iClearTime) {
				iNumOfCorAns_rank = iNumOfCorAns;
				iClearTime_rank = iClearTime;
				
				lbEasy.setText("I D  :  "+ strId);
				lbNormal.setText("���� ����  :  "+ iNumOfCorAns_rank +" ��");
				lbHard.setText("���� �ð�  :  "+ iClearTime_rank + " ��");
			}
		}		
		
		
		
		

	}
	
}////////end of class 