package Game;

import javax.swing.*;
import java.awt.*;

public class MyJPanel extends JPanel {
	int top, left, bottom, right;

	public MyJPanel() {
		this(0, 0, 0, 0);
	}
	public MyJPanel(int top, int left, int bottom, int right) {
		this.top = top;
		this.left = left;
		this.bottom = bottom;
		this.right = right;
	}

	/* 바깥 여백을 주는 메소드를 오버라이딩 */
	@Override
	public Insets getInsets() {
		Insets in = new Insets(top, left, bottom, right); //시계 반대방향으로 마진을 설정
		return in;
	}
}