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

	/* �ٱ� ������ �ִ� �޼ҵ带 �������̵� */
	@Override
	public Insets getInsets() {
		Insets in = new Insets(top, left, bottom, right); //�ð� �ݴ�������� ������ ����
		return in;
	}
}