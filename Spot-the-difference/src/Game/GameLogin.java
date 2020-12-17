package Game;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.awt.event.*;

public class GameLogin extends JFrame {
	static String ID;	// GameLogin.ID

	EventHandler event;
	
	HashMap<String, String> memberList = new HashMap<String, String>(); //id와 pw워드를 받아 저장하기 위한 hashmap생성
	
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

	MyLabel lbLogin = new MyLabel(new ImageIcon("./images/login/login.gif"), 800, 372);// lbLogin 이미지 경로와 width, height 설정
	MyLabel lbInsertCoin = new MyLabel(new ImageIcon("./images/login/insertcoin.gif"), 320, 100);// lbInsertCoin 이미지 경로와 width, height 설정
	
	SizeButton btLogin = new SizeButton(new ImageIcon("./images/login/login2-normal.png"),new ImageIcon("./images/login/login2-normal.png"),new ImageIcon("./images/login/login2-pressed.png"),185,185);
														// 평소 모습                              // 마우스를 올렸을때                                 // 마우스를 눌렀을때        //width //height
	SizeButton2 btNaver = new SizeButton2(new ImageIcon("./images/login/naver.png"),350,81);// btNaver 버튼 이미지 경로와 width, height 설정
	SizeButton2 btGoogle = new SizeButton2(new ImageIcon("./images/login/kakao.png"),350,81);// btGoogle 버튼 이미지 경로와 width, height 설정
	SizeButton2 btKakao = new SizeButton2(new ImageIcon("./images/login/google.png"), 350,81);// btKakao 버튼 이미지 경로와 width, height 설정
	SizeButton2 btFacebook = new SizeButton2(new ImageIcon("./images/login/facebook.png"),350,81);// btFacebook 버튼 이미지 경로와 width, height 설정
	
	GameTitle gt;
	
	public void join() { //회원정보가 있는 join() 메소드
		
		//id , pw
		memberList.put("1", "1");
		memberList.put("lee", "1");
		memberList.put("ku", "1");
		memberList.put("park", "1");
		memberList.put("choi", "1");
		memberList.put("admin", "tiger");
		
	}//join()
	
	public GameLogin() {
		
		super("::틀린그림찾기::");
		
		setResizable(false);// 창 사이즈 변경하지 못하게
		
		Container cp = getContentPane(); // getContentPane();
		cp.add(pnBase= new JPanel()); // pnBase객체 생성과 동시에 바로 cp에 pnBase부착
		pnBase.setLayout(new BorderLayout()); // pnBase 레이아웃 설정 BorderLayout()
		pnBase.setBackground(Color.white); //pnBase setBackground설정
		
		pnNorth = new MyJPanel(30, 50, 30, 50);// pnNorth객체 생성 & 안쪽 여백 설정
		pnNorth.setBackground(Color.white);//pnNorth setBackground설정
		pnNorth.add(lbLogin);
		pnBase.add(pnNorth,"North");// pnBase에 pnNorth부착 "North"
		
		pnCenter = new MyJPanel(0, 0, 20, 0);// pnCenter객체 생성 & 안쪽 여백 설정
		pnCenter.setBackground(Color.white);//pnCenter setBackground설정
		pnCenter.setLayout(new BorderLayout());// pnCenter 레이아웃 설정 BorderLayout()
		pnBase.add(pnCenter,"Center");// pnBase에 pnCenter부착 "Center"
		
		pnCenterCenter = new MyJPanel(0, 200, 20, 0);// pnCenterCenter객체 생성 & 안쪽 여백 설정
		pnCenterCenter.setOpaque(false); // pnCenterCenter 투명하게 설정
		pnCenterCenter.setLayout(new BorderLayout());// pnCenterCenter 레이아웃 설정 BorderLayout()
		pnCenter.add(pnCenterCenter,"Center");// pnCenter에 pnCenterCenter부착 "Center"
		
		pnCenterCenterCenter = new MyJPanel(0, 0, 0, 10);//pnCenterCenterCenter에 적용할 폰트와 폰트효과(plain:아무효과 없음),폰트크기 설정;}};// pnCenterCenterCenter객체 생성 & 안쪽 여백 설정
		pnCenterCenterCenter.setOpaque(false); // pnCenterCenterCenter 투명하게 설정
		pnCenterCenterCenter.setLayout(new GridLayout(4,1,0,10));// pnCenterCenterCenter 레이아웃 설정 GridLayout(4행 1열)
		
		lbIdInfo = new JLabel("아이디를 입력하세요");//lbIdInfo String입력
		lbIdInfo.setFont(new Font("나눔고딕", Font.BOLD , 40));//lbIdInfo에 적용할 폰트와 폰트효과(bold:굵게),폰트크기 설정
		pnCenterCenterCenter.add(lbIdInfo);// pnCenterCenterCenter에 lbIdInfo부착
					
		tfId = new JTextField();// tfId 객체 생성
		tfId.setFont(new Font("나눔고딕", Font.BOLD , 40));//tfId에 적용할 폰트와 폰트효과(bold:굵게),폰트크기 설정
		tfId.setHorizontalAlignment(JTextField.CENTER);//tfId는 가운데 정렬
					
		pnCenterCenterCenter.add(tfId);// pnCenterCenterCenter에 tfId부착
		lbPasswordInfo = new JLabel("패스워드를 입력하세요");//lbPasswordInfodp String입력
		lbPasswordInfo.setFont(new Font("나눔고딕", Font.BOLD , 40));//lbPasswordInfo에 적용할 폰트와 폰트효과(bold:굵게),폰트크기 설정
		pnCenterCenterCenter.add(lbPasswordInfo);// pnCenterCenterCenter에 lbPasswordInfo부착
					
		tfPassword = new JPasswordField(); // tfPassword 객체 생성
		tfPassword.setFont(new Font("나눔고딕", Font.BOLD , 40));//tfPassword에 적용할 폰트와 폰트효과(bold:굵게),폰트크기 설정
		tfPassword.setHorizontalAlignment(JTextField.CENTER);//tfPassword는 가운데 정렬
					
		pnCenterCenterCenter.add(tfPassword);// pnCenterCenterCenter에 tfPassword부착
		pnCenterCenter.add(pnCenterCenterCenter);// pnCenterCenter에 pnCenterCenterCenter부착
		
		pnCenterEast = new MyJPanel(10, 0, 0, 200);// pnCenterEast객체 생성 & 안쪽 여백 설정
		pnCenterEast.setOpaque(false); // pnCenterEast 투명하게 설정
		pnCenter.add(pnCenterEast,"East");// pnCenter에 pnCenterEast부착 "East"
		
		pnCenterCenterEast = new MyJPanel(0, 0, 0, 0);// pnCenterCenterEast객체 생성 & 안쪽 여백 설정
		pnCenterCenterEast.setOpaque(false); // pnCenterCenterEast 투명하게 설정
		pnCenterCenterEast.add(btLogin);// pnCenterCenterEast에 btLogin부착
		pnCenterEast.add(pnCenterCenterEast);// pnCenterEast에 pnCenterCenterEast부착
		
		pnCenterSouth = new MyJPanel(0, 200, 0, 200);// pnCenterSouth객체 생성 & 안쪽 여백 설정
		pnCenterSouth.setOpaque(false); // pnCenterSouth 투명하게 설정
		pnCenterSouth.setLayout(new GridLayout(2,2,20,20));// pnCenterSouth 레이아웃 설정 GridLayout(2,2,20,20)
		pnCenterSouth.add(btNaver);// pnCenterSouth에 btNaver부착
		pnCenterSouth.add(btKakao);// pnCenterSouth에 btKakao부착
		pnCenterSouth.add(btGoogle);// pnCenterSouth에 btGoogle부착
		pnCenterSouth.add(btFacebook);// pnCenterSouth에 btFacebook부착
		pnCenter.add(pnCenterSouth,"South");// pnCenter에 pnCenterSouth부착 "South"
		
		pnSouth = new MyJPanel(0, 0, 0, 0);// pnSouth객체 생성 & 안쪽 여백 설정
		pnSouth.setBackground(Color.white);//pnSouth setBackground설정
		pnSouth.add(lbInsertCoin);// pnSouth에 lbInsertCoin부착
		pnBase.add(pnSouth,"South");// pnBase에 pnSouth부착 "South"
		
		event = new EventHandler(this);
		btLogin.addActionListener(event);
		btLogin.addMouseListener(event);

		btNaver.addActionListener(event);
		btKakao.addActionListener(event);
		btGoogle.addActionListener(event);
		btFacebook.addActionListener(event);
		
		join();//join() 메소드 호출하기
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//[x]누르면 종료된다
		
		setBounds(360, 10, 1200, 1030);
		setVisible(true);
		
	}//GameLogin()

	public static void main(String[] args) {
		PanelController.toggleShowGameLogin();
	}//main()
}