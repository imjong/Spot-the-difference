package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class MyProgressBar {
	private JProgressBar progressBar;
	private int time = 120;
	private int currentTime = 120;
	private MyTimer timer;
	private JLabel lbGameTimeCnt;

	// 이 스레드는 무조건 JProgress가 있어야하므로 기본생성자를 만들지 않았음
	public MyProgressBar(JProgressBar progressBar) {
		this.progressBar = progressBar;
	}
	
	public MyProgressBar(JProgressBar progressBar, JLabel lbGameTimeCnt) {
		this.progressBar = progressBar;
		this.lbGameTimeCnt = lbGameTimeCnt;
	}
	
	public MyProgressBar(JProgressBar progressBar, JLabel lbGameTimeCnt, int time) {
		this.progressBar = progressBar;
		this.lbGameTimeCnt = lbGameTimeCnt;
		this.time = time;
		this.currentTime = time;
	}

	public JProgressBar getProgressBar() {
		return progressBar;
	}

	public MyTimer getTimer() {
		return timer;
	}

	public void setTimer(MyTimer timer) {
		this.timer = timer;
	}

	public JLabel getLabel() {
		return lbGameTimeCnt;
	}

	public void setLabel(JLabel lbGameTimeCnt) {
		this.lbGameTimeCnt = lbGameTimeCnt;
	}

	public void setProgressBar(JProgressBar progressBar) {
		this.progressBar = progressBar;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(int currentTime) {
		this.currentTime = currentTime;
	}
	
	//inner class
	class MyListener implements ActionListener {
		MyTimer myTimer;
		
		public void setMyTimer(MyTimer mytimer) {
			myTimer=mytimer;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			myTimer.countTime();
			setCurrentTime(myTimer.getCurrnetTime());
			setTime(myTimer.getMaxTime());
			lbGameTimeCnt.setText(Integer.toString(currentTime));
			ConvertFromSecondToValue(time, currentTime);
		}
	}//////////////////////////////

	public void ConvertFromSecondToValue(int time, int currentTime) {
		float ratio = 100 / (float) time;
		int current_value = (int) (ratio * currentTime);
		progressBar.setValue(current_value);
	}
}
