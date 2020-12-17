package Game;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

class EventHandler implements ActionListener, MouseListener {
	public static final int imgWidth= 785;
	public static final int ansRange = 50;
	static int imgIndex = 0;
	static int lifeCnt = 0;
	boolean oneTimeRun = true;
	
	GameEndClear end_clear;
	GameEndFailed end_failed;
	GameEndTimeover end_timeover;
	GameLogin login;
	GameMain main;
	GameRank rank;
	GameTitle title;
	
	public EventHandler(GameEndClear end_clear) {
		this.end_clear = end_clear;
	}
	public EventHandler(GameEndFailed end_failed) {
		this.end_failed = end_failed;
	}
	public EventHandler(GameEndTimeover end_timeover) {
		this.end_timeover = end_timeover;
	}
	public EventHandler(GameLogin login) {
		this.login = login;
	}
	public EventHandler(GameMain main) {
		this.main = main;
	}
	public EventHandler(GameRank rank) {
		this.rank = rank;
	}
	public EventHandler(GameTitle title) {
		this.title = title;
	}
	
	//AvengersAssemble
	public static void initGame() {
		GameMain.iNumOfCorAns = GameMain.numOfCorAns;
		GameMain.iClearTime = PanelController.gameMain.myTimer.getCurrnetTime();
		
		PanelController.gameMain.myTimer.stop();
		PanelController.gameMain.lblGameTimeCnt.setText(Integer.toString(GameMain.gameCntNum));
		PanelController.gameMain.progressBar.setValue(100);
		PanelController.gameMain.myTimer.resetCurrentTime();
		
		GameMain.numOfCorAns = 0;
		PanelController.gameMain.lblGameCorrectCnt.setText("맞춘 문제 : "+ GameMain.numOfCorAns +" / 10");
		PanelController.gameMain.setImgGame();
		PanelController.gameMain.lblGameImg.setIcon(PanelController.gameMain.imgGame[0]);

		imgIndex = 0;
		lifeCnt = 0;
		for (int i = 0; i < PanelController.gameMain.lblGameLife.length; i++) {
			PanelController.gameMain.lblGameLife[i].setVisible(true);
		}
		
		
		
		
	}
	
////이벤트 오버라이딩////
	//--------버튼 액션이벤트--------
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		//GameEndClear
		if(end_clear != null) {
			if(obj == end_clear.btBack) {
				PanelController.toggleShowGameEndClear();
				 PanelController.toggleShowGameTitle();
			}
		}
		
		//GameEndFailed
		else if(end_failed != null) {
			
			if(obj == end_failed.btBack) {
				PanelController.toggleShowGameEndFailed();
				PanelController.toggleShowGameTitle();
				initGame();
			}
		}
		
		//GameEndTimeover
		else if(end_timeover != null) {
			
			 if(obj == end_timeover.btBack) {
				 PanelController.toggleShowGameEndTimeover();
				 PanelController.toggleShowGameTitle();
			}
		}
		
		//GameLogin
		else if(login != null) {
			if(obj == login.btLogin) {
				if(login.memberList.containsKey(login.tfId.getText())) { 	//memberList에 저장된 키값(id)와 tfId에 적힌 id값을 비교한다
					String password=login.memberList.get(login.tfId.getText()); // id가 서로 맞다면 id를 입력했을때 나온 id로 memberList에서 id값과 일치한 패스워드 내용을 가져온다.
					if(password.equals(login.tfPassword.getText())) {	  	//tfPassword에 적힌 패스워드와 memberList에 있는 패스워드를 비교한다.
						JOptionPane.showMessageDialog(login.pnBase, login.tfId.getText() +" 님 환영합니다.", "로그인",JOptionPane.DEFAULT_OPTION);// 로그인 성공할때 뜨는 알림창 (id와 pw가 서로 일치)
						if(login.tfId.getText().equals("admin")) {			//이 중에서 id가 admin일경우
							JOptionPane.showMessageDialog(login.pnBase, "관리자모드로 접속하셨습니다.", "로그인",JOptionPane.INFORMATION_MESSAGE);// 관리자로 로그인 할때 뜨는 알림창
						}
						//게임타이틀 창 띄우기
						PanelController.toggleShowGameTitle();
						PanelController.toggleShowGameLogin();
						
						GameLogin.ID = PanelController.getGameLogin().tfId.getText();
						
						PanelController.getGameLogin().tfId.setText("");
						PanelController.getGameLogin().tfPassword.setText("");
					} else {	//id값은 서로 같으나 password값이 다를때
							JOptionPane.showMessageDialog(login.pnBase, "패스워드가 일치하지 않습니다.", "로그인",JOptionPane.WARNING_MESSAGE);// pw가 일치하지 않을때 뜨는 알림창
					}
				} else {		//id값이 다를때
					JOptionPane.showMessageDialog(login.pnBase, "존재하지 않는 회원입니다.", "로그인",JOptionPane.YES_OPTION); // 회원이 없을때 뜨는 알림창
				}
			} else if(obj == login.btNaver||obj == login.btGoogle||obj == login.btKakao||obj == login.btFacebook ) {
				JOptionPane.showMessageDialog(login.pnBase, "소셜로그인 준비중입니다", "로그인",JOptionPane.WARNING_MESSAGE); //알림창
			}
		}
		
		//GameMain
		else if(main != null) {
			if(obj == main.btnLeftGame) {
				if(imgIndex == 0)
					imgIndex = 9;
				else
					imgIndex--;
				main.lblGameImg.setIcon(main.imgGame[imgIndex]);
			} else if(obj == main.btnRightGame) {
				if(imgIndex == 9)
					imgIndex = 0;
				else
					imgIndex++;
				main.lblGameImg.setIcon(main.imgGame[imgIndex]);
			} else if(obj == main.btnExitGame) {
				initGame();
				
				PanelController.toggleShowGameMain();
				PanelController.toggleShowGameTitle();
			}
		}
		
		//GameRank
		else if(rank != null) {
			if(obj == rank.btFoot) {
				PanelController.toggleShowGameRank();
			}
		}
		
		//GameTitle
		else if(title != null) {
			if(obj == title.btStart) {
				PanelController.toggleShowGameMain();
				PanelController.toggleShowGameTitle();
				
				PanelController.gameMain.myTimer.start();
			} else if(obj == title.btRanking) {
				PanelController.toggleShowGameRank();
				PanelController.gameRank.updateRank();
			} else if(obj == title.btExit) {
				PanelController.toggleShowGameTitle();
				PanelController.toggleShowGameLogin();
			}
		}
	}
	//--------버튼 액션이벤트--------끝

	
	//--------마우스 이벤트--------
	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		
		//GameEndClear
		if(end_clear != null) {
		}
		
		//GameEndFailed
		else if(end_failed != null) {
		}
		
		//GameEndTimeover
		else if(end_timeover != null) {
		}
		
		//GameLogin
		else if(login != null) {
		}
		
		//GameMain
		else if(main != null) {
			if(obj == main.btnLeftGame) {
				
			} else if(obj == main.btnRightGame) {
				
			} else if(obj == main.btnExitGame) {
				main.btnExitGame.setIcon(main.imgGiveup_hover);
			}
		}
		
		//GameRank
		else if(rank != null) {
		}
		
		//GameTitle
		else if(title != null) {
		}
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		Object obj = e.getSource();
		
		//GameEndClear
		if(end_clear != null) {
			
		}

		//GameEndFailed
		else if(end_failed != null) {
		}

		//GameEndTimeover
		else if(end_timeover != null) {
		}

		//GameLogin
		else if(login != null) {
		}

		//GameMain
		else if(main != null) {
			if(obj == main.btnLeftGame) {
				main.btnLeftGame.setIcon(main.imgLeftGame_hover);
			} else if(obj == main.btnRightGame) {
				main.btnRightGame.setIcon(main.imgRightGame_hover);
			} else if(obj == main.btnExitGame) {
				
			}
		}

		//GameRank
		else if(rank != null) {
		}

		//GameTitle
		else if(title != null) {
			if(obj == title.btStart) {
				title.btStart.tmpImg = title.btStart.rolloverImg;
				title.btStart.baseImg = title.btStart.blankImg;
			} else if(obj == title.btRanking) {
				title.btRanking.tmpImg = title.btRanking.rolloverImg;
				title.btRanking.baseImg = title.btRanking.blankImg;
			} else if(obj == title.btExit) {
				title.btExit.tmpImg = title.btExit.rolloverImg;
				title.btExit.baseImg = title.btExit.blankImg;
			}
		}
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		Object obj = e.getSource();
		
		//GameEndClear
		if(end_clear != null) {
			if(obj == end_clear.btBack) {
				end_clear.btBack.baseImg = end_clear.btBack.blankImg;
				end_clear.btBack.tmpImg = end_clear.btBack.pressedImg;
			}
		}

		//GameEndFailed
		else if(end_failed != null) {
			if(obj == end_failed.btBack) {
				end_failed.btBack.baseImg = end_failed.btBack.blankImg;
				end_failed.btBack.tmpImg = end_failed.btBack.pressedImg;
			}
		}

		//GameEndTimeover
		else if(end_timeover != null) {
			if(obj == end_timeover.btBack) {
				end_timeover.btBack.baseImg = end_timeover.btBack.blankImg;
				end_timeover.btBack.tmpImg = end_timeover.btBack.pressedImg;
			}
		}

		//GameLogin
		else if(login != null) {
			if(obj == login.btLogin) {
				login.btLogin.baseImg = login.btLogin.blankImg;
				login.btLogin.tmpImg = login.btLogin.pressedImg;
			}
		}

		//GameMain
		else if(main != null) {
			if(obj == main.btnLeftGame) {
				
			} else if(obj == main.btnRightGame) {
				
			} else if(obj == main.btnExitGame) {
				main.btnExitGame.setIcon(main.imgGiveup_hover);
			}
		}

		//GameRank
		else if(rank != null) {
		}

		//GameTitle
		else if(title != null) {
			if(obj == title.btStart) {
				title.btStart.tmpImg =  title.btStart.pressedImg;
			} else if(obj == title.btRanking) {
				title.btRanking.tmpImg =  title.btRanking.pressedImg;
			} else if(obj == title.btExit) {
				title.btExit.tmpImg =  title.btExit.pressedImg;
			}
		}
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		Object obj = e.getSource();
		
		//GameEndClear
		if(end_clear != null) {
			if(obj == end_clear.btBack) {
				end_clear.btBack.tmpImg = end_clear.btBack.resetImg;
			}
		}

		//GameEndFailed
		else if(end_failed != null) {
			if(obj == end_failed.btBack) {
				end_failed.btBack.tmpImg = end_failed.btBack.resetImg;
			}
		}

		//GameEndTimeover
		else if(end_timeover != null) {
			if(obj == end_timeover.btBack) {
				end_timeover.btBack.tmpImg = end_timeover.btBack.resetImg;
			}
		}

		//GameLogin
		else if(login != null) {
			if(obj == login.btLogin) {
				login.btLogin.tmpImg = login.btLogin.resetImg;
			}
		}

		//GameMain
		else if(main != null) {
			if(obj == main.btnLeftGame) {
				main.btnLeftGame.setIcon(main.imgLeftGame);
			} else if(obj == main.btnRightGame) {
				main.btnRightGame.setIcon(main.imgRightGame);
			} else if(obj == main.btnExitGame) {
				main.btnExitGame.setIcon(main.imgGiveup);
			}
		}

		//GameRank
		else if(rank != null) {
		}

		//GameTitle
		else if(title != null) {
			if(obj == title.btStart) {
				title.btStart.tmpImg =  title.btStart.resetImg;
			} else if(obj == title.btRanking) {
				title.btRanking.tmpImg =  title.btRanking.resetImg;
			} else if(obj == title.btExit) {
				title.btExit.tmpImg =  title.btExit.resetImg;
			}
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		Object obj = e.getSource();
		
		//GameMain 틀린그림찾기 이벤트
		if(main != null) {
			if(obj == main.lblGameImg) {
				if(main.imgGame[imgIndex].toString().indexOf("ans") == -1) {
					
					int ansPointX1 = Integer.parseInt(main.gameInfo[imgIndex][1]);
					int ansPointX2 = Integer.parseInt(main.gameInfo[imgIndex][1]) + imgWidth;
					int ansPointY = Integer.parseInt(main.gameInfo[imgIndex][2]);
					
					int disPointsedPosX = e.getX();
					int disPointsedPosY = e.getY();
					
					double disPoint1 = Math.sqrt((ansPointX1 - disPointsedPosX)*(ansPointX1 - disPointsedPosX) + (ansPointY - disPointsedPosY)*(ansPointY - disPointsedPosY));
					double disPoint2 = Math.sqrt((ansPointX2 - disPointsedPosX)*(ansPointX2 - disPointsedPosX) + (ansPointY - disPointsedPosY)*(ansPointY - disPointsedPosY));
					
					//정답 클릭
					if(disPoint1 < ansRange || disPoint2 < ansRange) {
						main.lblGameImg.setIcon(main.imgGame_ans[imgIndex]);
						main.imgGame[imgIndex] = main.imgGame_ans[imgIndex];
						main.lblGameCorrectCnt.setText("맞춘 문제 : "+ (++(GameMain.numOfCorAns)) +"/ 10");
						//정답 10개
						if(GameMain.numOfCorAns == 10) {
							PanelController.toggleShowGameMain();
							PanelController.toggleShowGameEndClear();
							initGame();
						}
					} else {
						//정답 불일치
						if(lifeCnt == 5) {
							//목숨끝
							PanelController.toggleShowGameMain();
							PanelController.toggleShowGameEndFailed();
							PanelController.gameEndFailed.tfScore.setText(Integer.toString(GameMain.numOfCorAns));
							initGame();
						} else {
							main.lblGameLife[lifeCnt].setVisible(false);
							lifeCnt++;
						}
					}
				} else {
					JOptionPane.showMessageDialog(main.paneMain, "이미 맞춘 문제입니다", "오류",JOptionPane.YES_OPTION);
				}
			}
		}
	}
	//--------마우스 이벤트--------끝

}////end of class