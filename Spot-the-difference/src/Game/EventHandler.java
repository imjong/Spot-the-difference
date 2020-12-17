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
		PanelController.gameMain.lblGameCorrectCnt.setText("���� ���� : "+ GameMain.numOfCorAns +" / 10");
		PanelController.gameMain.setImgGame();
		PanelController.gameMain.lblGameImg.setIcon(PanelController.gameMain.imgGame[0]);

		imgIndex = 0;
		lifeCnt = 0;
		for (int i = 0; i < PanelController.gameMain.lblGameLife.length; i++) {
			PanelController.gameMain.lblGameLife[i].setVisible(true);
		}
		
		
		
		
	}
	
////�̺�Ʈ �������̵�////
	//--------��ư �׼��̺�Ʈ--------
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
				if(login.memberList.containsKey(login.tfId.getText())) { 	//memberList�� ����� Ű��(id)�� tfId�� ���� id���� ���Ѵ�
					String password=login.memberList.get(login.tfId.getText()); // id�� ���� �´ٸ� id�� �Է������� ���� id�� memberList���� id���� ��ġ�� �н����� ������ �����´�.
					if(password.equals(login.tfPassword.getText())) {	  	//tfPassword�� ���� �н������ memberList�� �ִ� �н����带 ���Ѵ�.
						JOptionPane.showMessageDialog(login.pnBase, login.tfId.getText() +" �� ȯ���մϴ�.", "�α���",JOptionPane.DEFAULT_OPTION);// �α��� �����Ҷ� �ߴ� �˸�â (id�� pw�� ���� ��ġ)
						if(login.tfId.getText().equals("admin")) {			//�� �߿��� id�� admin�ϰ��
							JOptionPane.showMessageDialog(login.pnBase, "�����ڸ��� �����ϼ̽��ϴ�.", "�α���",JOptionPane.INFORMATION_MESSAGE);// �����ڷ� �α��� �Ҷ� �ߴ� �˸�â
						}
						//����Ÿ��Ʋ â ����
						PanelController.toggleShowGameTitle();
						PanelController.toggleShowGameLogin();
						
						GameLogin.ID = PanelController.getGameLogin().tfId.getText();
						
						PanelController.getGameLogin().tfId.setText("");
						PanelController.getGameLogin().tfPassword.setText("");
					} else {	//id���� ���� ������ password���� �ٸ���
							JOptionPane.showMessageDialog(login.pnBase, "�н����尡 ��ġ���� �ʽ��ϴ�.", "�α���",JOptionPane.WARNING_MESSAGE);// pw�� ��ġ���� ������ �ߴ� �˸�â
					}
				} else {		//id���� �ٸ���
					JOptionPane.showMessageDialog(login.pnBase, "�������� �ʴ� ȸ���Դϴ�.", "�α���",JOptionPane.YES_OPTION); // ȸ���� ������ �ߴ� �˸�â
				}
			} else if(obj == login.btNaver||obj == login.btGoogle||obj == login.btKakao||obj == login.btFacebook ) {
				JOptionPane.showMessageDialog(login.pnBase, "�Ҽȷα��� �غ����Դϴ�", "�α���",JOptionPane.WARNING_MESSAGE); //�˸�â
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
	//--------��ư �׼��̺�Ʈ--------��

	
	//--------���콺 �̺�Ʈ--------
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
		
		//GameMain Ʋ���׸�ã�� �̺�Ʈ
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
					
					//���� Ŭ��
					if(disPoint1 < ansRange || disPoint2 < ansRange) {
						main.lblGameImg.setIcon(main.imgGame_ans[imgIndex]);
						main.imgGame[imgIndex] = main.imgGame_ans[imgIndex];
						main.lblGameCorrectCnt.setText("���� ���� : "+ (++(GameMain.numOfCorAns)) +"/ 10");
						//���� 10��
						if(GameMain.numOfCorAns == 10) {
							PanelController.toggleShowGameMain();
							PanelController.toggleShowGameEndClear();
							initGame();
						}
					} else {
						//���� ����ġ
						if(lifeCnt == 5) {
							//�����
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
					JOptionPane.showMessageDialog(main.paneMain, "�̹� ���� �����Դϴ�", "����",JOptionPane.YES_OPTION);
				}
			}
		}
	}
	//--------���콺 �̺�Ʈ--------��

}////end of class