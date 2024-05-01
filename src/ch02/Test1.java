package ch02;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test1 extends JFrame {
	Test2 Test2;
	
	
	public Test1() {
		initData();
		setInitLayout();
	}

	private void initData() {
		setTitle("연습");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Test2= new Test2();
	}
	private void setInitLayout() {
		add(Test2);
		setVisible(true);

		
	}
	class Test2 extends JPanel{
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			g.drawString("gg", 12, 50);
		}
		
	}
}
