package Game;

public class PanelController {
	static GameEndClear gameEndClear;
	static GameEndFailed gameEndFailed;
	static GameEndTimeover gameEndTimeover;
	static GameLogin gameLogin;
	static GameMain gameMain;
	static GameRank gameRank;
	static GameTitle gameTitle;
	
	static boolean blGameEndClearVisible = false;
	static boolean blGameEndFailedVisible = false;
	static boolean blGameEndTimeoverVisible = false;
	static boolean blGameLoginVisible = false;
	static boolean blGameMainVisible = false;
	static boolean blGameRankVisible = false;
	static boolean blGameTitleVisible = false;
	
	public static GameEndClear getGameEndClear() {
		if(gameEndClear==null) {
			gameEndClear = new GameEndClear();
			blGameEndClearVisible = true;
		}
		return gameEndClear;
	}
	
	public static GameEndFailed getGameEndFailed() {
		if(gameEndFailed==null) {
			gameEndFailed = new GameEndFailed();
			blGameEndFailedVisible = true;
		}
		return gameEndFailed;
	}
	
	public static GameEndTimeover getGameEndTimeover() {
		if(gameEndTimeover==null) {
			gameEndTimeover = new GameEndTimeover();
			blGameEndTimeoverVisible = true;
		}
		return gameEndTimeover;
	}
	
	public static GameLogin getGameLogin() {
		if(gameLogin==null) {
			gameLogin = new GameLogin();
			blGameLoginVisible = true;
		}
		return gameLogin;
	}
	
	public static GameMain getGameMain() {
		if(gameMain==null) {
			gameMain = new GameMain();
			blGameMainVisible = true;
		}
		return gameMain;
	}
	
	public static GameRank getGameRank() {
		if(gameRank==null) {
			gameRank = new GameRank();
			blGameRankVisible = true;
		}
		return gameRank;
	}
	
	public static GameTitle getGameTitle() {
		if(gameTitle==null) {
			gameTitle = new GameTitle();
			blGameTitleVisible = true;
		}
		return gameTitle;
	}
	
	/*	visible ����� �̿��� ��Ÿ���� ������� �ϰ�ʹٸ�
	 * 	PanelController.toggleShowGameEndClear(); <- �̰� �����
	 *  ����̴ϱ� ó���� ��Ÿ���� �ѹ��� ȣ���ϸ� ����� �׸��� �Ǵٽ� ȣ���ϸ� ��Ÿ��...
	 *  ���ô� GameMain class���� Ȯ���Ҽ��־�..
	 * */
	
	public static void toggleShowGameEndClear() {
		if(blGameEndClearVisible) {
			PanelController.getGameEndClear().setVisible(false);
			blGameEndClearVisible = false;
		}
		else {
			PanelController.getGameEndClear().setVisible(true);
			blGameEndClearVisible = true;
		}
	}
	
	public static void toggleShowGameEndFailed() {
		if(blGameEndFailedVisible) {
			PanelController.getGameEndFailed().setVisible(false);
			blGameEndFailedVisible = false;
		}
		else {
			PanelController.getGameEndFailed().setVisible(true);
			blGameEndFailedVisible = true;
		}
	}
	
	public static void toggleShowGameEndTimeover() {
		if(blGameEndTimeoverVisible) {
			PanelController.getGameEndTimeover().setVisible(false);
			blGameEndTimeoverVisible   = false;
		}
		else {
			PanelController.getGameEndTimeover().setVisible(true);
			blGameEndTimeoverVisible   = true;
		}
	}
	
	public static void toggleShowGameLogin() {
		if(blGameLoginVisible) {
			PanelController.getGameLogin().setVisible(false);
			blGameLoginVisible  = false;
		}
		else {
			PanelController.getGameLogin().setVisible(true);
			blGameLoginVisible  = true;
		}
	}
	
	public static void toggleShowGameMain() {
		if(blGameMainVisible) {
			PanelController.getGameMain().setVisible(false);
			blGameMainVisible  = false;
		}
		else {
			PanelController.getGameMain().setVisible(true);
			blGameMainVisible  = true;
		}
	}
	
	public static void toggleShowGameRank() {
		if(blGameRankVisible) {
			PanelController.getGameRank().setVisible(false);
			blGameRankVisible  = false;
		}
		else {
			PanelController.getGameRank().setVisible(true);
			blGameRankVisible  = true;
		}
	}
	
	public static void toggleShowGameTitle() {
		if(blGameTitleVisible) {
			PanelController.getGameTitle().setVisible(false);
			blGameTitleVisible  = false;
		}
		else {
			PanelController.getGameTitle().setVisible(true);
			blGameTitleVisible = true;
		}
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	
	
	/*   dispose �ϰ������ �̰� ��    */
	
	/* ���� dispose�� �츮�� new�� �ٽû츮�� �̷��� �ϰ������.... 
	 * 
	 * PanelController.disposeGameEndClear(); <- �̷��� dispose�� ���ε�
	 *
	 *  �츱�� -> PanelController.GameEndClear(); �̷��� �ϸ� ��...
	 * 
	 * */
//	public static void disposeGameEndClear() {
//		if(gameEndClear!=null) gameEndClear.dispose();
//	}
//	
//	public static void disposeGameEndFailed() {
//		if(gameEndFailed!=null) gameEndFailed.dispose();
//	}
//	
//	public static void disposeGameEndTimeover() {
//		if(gameEndTimeover!=null) gameEndTimeover.dispose();
//	}
//	
//	public static void disposeGameLogin() {
//		if(gameLogin!=null) gameLogin.dispose();
//	}
//	
//	public static void disposeGameRank() {
//		if(gameRank!=null) gameRank.dispose();
//	}
//	
//	public static void disposeGameTitle() {
//		if(gameTitle!=null) gameTitle.dispose();
//	}
//	/* 			dispose�ϰ������ ��     			*/
//	
//	//main()
//	public static void main(String[] args) {
//		
//	}
	
}
