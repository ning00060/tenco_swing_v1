package ch02;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PaintFrame extends JFrame {
	MyPaintPanel MyPaintPanel;

	public PaintFrame() {
		initData();
		setInitLayout();
	}

	private void initData() {
		setTitle("그림그리기");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyPaintPanel = new MyPaintPanel();

	}

	private void setInitLayout() {
		add(MyPaintPanel);
		setVisible(true);

	}

	class MyPaintPanel extends JPanel {

		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			g.setColor(Color.GRAY);
//			g.drawArc(100, 300, 100, 200, 51, 51);
//			g.drawRect(100, 100, 50, 100);
			g.drawRect(200, 200, 150, 100);
			g.drawOval(400, 450, 100, 100);
			g.drawOval(50, 450, 100, 100);
			g.drawOval(450, 50, 10, 10);
			g.drawOval(430, 60, 10, 10);
			g.drawOval(410, 80, 10, 10);
			g.drawOval(400, 100, 10, 10);
			g.drawOval(380, 120, 10, 10);
//			g.drawOval(EXIT_ON_CLOSE, DISPOSE_ON_CLOSE, WIDTH, HEIGHT);
			g.drawString("⭐", 200, 400);
			g.clearRect(220, 220, 100, 50);
			g.drawRoundRect(20, 300, 500, 200, 50, 50);
			g.fillRoundRect(20, 300, 150, 100, 50, 150);
//			g.drawRoundRect(EXIT_ON_CLOSE, DISPOSE_ON_CLOSE, WIDTH, HEIGHT, WIDTH, HEIGHT);
		}
	}

}
