package Game;

import java.awt.event.ActionListener;

import javax.swing.Timer;

public class MyTimer extends Timer{
	private int currnetTime = 60;
	private int maxTime = 60;

	public int getCurrnetTime() {
		return currnetTime;
	}

	public void setCurrnetTime(int currnetTime) {
		this.currnetTime = currnetTime;
	}

	public int getMaxTime() {
		return maxTime;
	}

	public void setMaxTime(int maxTime) {
		this.maxTime = maxTime;
	}

	public MyTimer(int delay, int time, ActionListener listener) {
		super(delay, listener);
		this.currnetTime = time;
		this.maxTime = time;
	}

	// 시간 초기화...
	public void resetCurrentTime() {
		this.setCurrnetTime(this.maxTime);
	}

	public void countTime() {
		if (this.currnetTime > 0) {
			this.currnetTime--;
		} else if(this.currnetTime == 0){
			PanelController.toggleShowGameEndTimeover();
			PanelController.toggleShowGameMain();
			PanelController.gameEndTimeover.tfScore.setText(Integer.toString(GameMain.numOfCorAns));
			EventHandler.initGame();
		}
	}
}
