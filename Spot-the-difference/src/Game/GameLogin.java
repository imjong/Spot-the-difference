package Game;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.awt.event.*;

public class GameLogin extends JFrame {
	static String ID;	// GameLogin.ID

	EventHandler event;
	
	HashMap<String, String> memberList = new HashMap<String, String>(); //id�� pw���带 �޾� �����ϱ� ���� hashmap����
	
	JPanel pnBase;
	
	JPanel pnNorth;
	JPanel pnCenter;
	JPanel pnSouth;
	
	JPanel pnCenterCenter;
	JPanel pnCenterEast;
	JPanel pnCenterSouth;
	
	JPanel pnCenterCenterCenter;
	JPanel pnCenterCenterEast;
	
	JLabel lbIdInfo;
	JLabel lbPasswordInfo;
	
	JTextField tfId;
	JPasswordField tfPassword;

	MyLabel lbLogin = new MyLabel(new ImageIcon("./images/login/login.gif"), 800, 372);// lbLogin �̹��� ��ο� width, height ����
	MyLabel lbInsertCoin = new MyLabel(new ImageIcon("./images/login/insertcoin.gif"), 320, 100);// lbInsertCoin �̹��� ��ο� width, height ����
	
	SizeButton btLogin = new SizeButton(new ImageIcon("./images/login/login2-normal.png"),new ImageIcon("./images/login/login2-normal.png"),new ImageIcon("./images/login/login2-pressed.png"),185,185);
														// ��� ���                              // ���콺�� �÷�����                                 // ���콺�� ��������        //width //height
	SizeButton2 btNaver = new SizeButton2(new ImageIcon("./images/login/naver.png"),350,81);// btNaver ��ư �̹��� ��ο� width, height ����
	SizeButton2 btGoogle = new SizeButton2(new ImageIcon("./images/login/kakao.png"),350,81);// btGoogle ��ư �̹��� ��ο� width, height ����
	SizeButton2 btKakao = new SizeButton2(new ImageIcon("./images/login/google.png"), 350,81);// btKakao ��ư �̹��� ��ο� width, height ����
	SizeButton2 btFacebook = new SizeButton2(new ImageIcon("./images/login/facebook.png"),350,81);// btFacebook ��ư �̹��� ��ο� width, height ����
	
	GameTitle gt;
	
	public void join() { //ȸ�������� �ִ� join() �޼ҵ�
		
		//id , pw
		memberList.put("1", "1");
		memberList.put("lee", "1");
		memberList.put("ku", "1");
		memberList.put("park", "1");
		memberList.put("choi", "1");
		memberList.put("admin", "tiger");
		
	}//join()
	
	public GameLogin() {
		
		super("::Ʋ���׸�ã��::");
		
		setResizable(false);// â ������ �������� ���ϰ�
		
		Container cp = getContentPane(); // getContentPane();
		cp.add(pnBase= new JPanel()); // pnBase��ü ������ ���ÿ� �ٷ� cp�� pnBase����
		pnBase.setLayout(new BorderLayout()); // pnBase ���̾ƿ� ���� BorderLayout()
		pnBase.setBackground(Color.white); //pnBase setBackground����
		
		pnNorth = new MyJPanel(30, 50, 30, 50);// pnNorth��ü ���� & ���� ���� ����
		pnNorth.setBackground(Color.white);//pnNorth setBackground����
		pnNorth.add(lbLogin);
		pnBase.add(pnNorth,"North");// pnBase�� pnNorth���� "North"
		
		pnCenter = new MyJPanel(0, 0, 20, 0);// pnCenter��ü ���� & ���� ���� ����
		pnCenter.setBackground(Color.white);//pnCenter setBackground����
		pnCenter.setLayout(new BorderLayout());// pnCenter ���̾ƿ� ���� BorderLayout()
		pnBase.add(pnCenter,"Center");// pnBase�� pnCenter���� "Center"
		
		pnCenterCenter = new MyJPanel(0, 200, 20, 0);// pnCenterCenter��ü ���� & ���� ���� ����
		pnCenterCenter.setOpaque(false); // pnCenterCenter �����ϰ� ����
		pnCenterCenter.setLayout(new BorderLayout());// pnCenterCenter ���̾ƿ� ���� BorderLayout()
		pnCenter.add(pnCenterCenter,"Center");// pnCenter�� pnCenterCenter���� "Center"
		
		pnCenterCenterCenter = new MyJPanel(0, 0, 0, 10);//pnCenterCenterCenter�� ������ ��Ʈ�� ��Ʈȿ��(plain:�ƹ�ȿ�� ����),��Ʈũ�� ����;}};// pnCenterCenterCenter��ü ���� & ���� ���� ����
		pnCenterCenterCenter.setOpaque(false); // pnCenterCenterCenter �����ϰ� ����
		pnCenterCenterCenter.setLayout(new GridLayout(4,1,0,10));// pnCenterCenterCenter ���̾ƿ� ���� GridLayout(4�� 1��)
		
		lbIdInfo = new JLabel("���̵� �Է��ϼ���");//lbIdInfo String�Է�
		lbIdInfo.setFont(new Font("�������", Font.BOLD , 40));//lbIdInfo�� ������ ��Ʈ�� ��Ʈȿ��(bold:����),��Ʈũ�� ����
		pnCenterCenterCenter.add(lbIdInfo);// pnCenterCenterCenter�� lbIdInfo����
					
		tfId = new JTextField();// tfId ��ü ����
		tfId.setFont(new Font("�������", Font.BOLD , 40));//tfId�� ������ ��Ʈ�� ��Ʈȿ��(bold:����),��Ʈũ�� ����
		tfId.setHorizontalAlignment(JTextField.CENTER);//tfId�� ��� ����
					
		pnCenterCenterCenter.add(tfId);// pnCenterCenterCenter�� tfId����
		lbPasswordInfo = new JLabel("�н����带 �Է��ϼ���");//lbPasswordInfodp String�Է�
		lbPasswordInfo.setFont(new Font("�������", Font.BOLD , 40));//lbPasswordInfo�� ������ ��Ʈ�� ��Ʈȿ��(bold:����),��Ʈũ�� ����
		pnCenterCenterCenter.add(lbPasswordInfo);// pnCenterCenterCenter�� lbPasswordInfo����
					
		tfPassword = new JPasswordField(); // tfPassword ��ü ����
		tfPassword.setFont(new Font("�������", Font.BOLD , 40));//tfPassword�� ������ ��Ʈ�� ��Ʈȿ��(bold:����),��Ʈũ�� ����
		tfPassword.setHorizontalAlignment(JTextField.CENTER);//tfPassword�� ��� ����
					
		pnCenterCenterCenter.add(tfPassword);// pnCenterCenterCenter�� tfPassword����
		pnCenterCenter.add(pnCenterCenterCenter);// pnCenterCenter�� pnCenterCenterCenter����
		
		pnCenterEast = new MyJPanel(10, 0, 0, 200);// pnCenterEast��ü ���� & ���� ���� ����
		pnCenterEast.setOpaque(false); // pnCenterEast �����ϰ� ����
		pnCenter.add(pnCenterEast,"East");// pnCenter�� pnCenterEast���� "East"
		
		pnCenterCenterEast = new MyJPanel(0, 0, 0, 0);// pnCenterCenterEast��ü ���� & ���� ���� ����
		pnCenterCenterEast.setOpaque(false); // pnCenterCenterEast �����ϰ� ����
		pnCenterCenterEast.add(btLogin);// pnCenterCenterEast�� btLogin����
		pnCenterEast.add(pnCenterCenterEast);// pnCenterEast�� pnCenterCenterEast����
		
		pnCenterSouth = new MyJPanel(0, 200, 0, 200);// pnCenterSouth��ü ���� & ���� ���� ����
		pnCenterSouth.setOpaque(false); // pnCenterSouth �����ϰ� ����
		pnCenterSouth.setLayout(new GridLayout(2,2,20,20));// pnCenterSouth ���̾ƿ� ���� GridLayout(2,2,20,20)
		pnCenterSouth.add(btNaver);// pnCenterSouth�� btNaver����
		pnCenterSouth.add(btKakao);// pnCenterSouth�� btKakao����
		pnCenterSouth.add(btGoogle);// pnCenterSouth�� btGoogle����
		pnCenterSouth.add(btFacebook);// pnCenterSouth�� btFacebook����
		pnCenter.add(pnCenterSouth,"South");// pnCenter�� pnCenterSouth���� "South"
		
		pnSouth = new MyJPanel(0, 0, 0, 0);// pnSouth��ü ���� & ���� ���� ����
		pnSouth.setBackground(Color.white);//pnSouth setBackground����
		pnSouth.add(lbInsertCoin);// pnSouth�� lbInsertCoin����
		pnBase.add(pnSouth,"South");// pnBase�� pnSouth���� "South"
		
		event = new EventHandler(this);
		btLogin.addActionListener(event);
		btLogin.addMouseListener(event);

		btNaver.addActionListener(event);
		btKakao.addActionListener(event);
		btGoogle.addActionListener(event);
		btFacebook.addActionListener(event);
		
		join();//join() �޼ҵ� ȣ���ϱ�
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//[x]������ ����ȴ�
		
		setBounds(360, 10, 1200, 1030);
		setVisible(true);
		
	}//GameLogin()

	public static void main(String[] args) {
		PanelController.toggleShowGameLogin();
	}//main()
}