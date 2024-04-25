package tenco_swing.ch01;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

// 단축키 습관 - ctrl + shift + s, f, o
public class BorderLayoutEx2 extends JFrame {

	final int width = 600;
	final int height = 600;
	JButton[] buttons;
	String[] directions = { BorderLayout.EAST, BorderLayout.WEST, BorderLayout.NORTH, BorderLayout.SOUTH,
			BorderLayout.CENTER };

	// 생성자
	public BorderLayoutEx2() {
		initData();
		setInitLayout();

	}

	public void initData() {
		setTitle("borderLayout연습");
		setSize(600, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buttons = new JButton[directions.length];

	}

	public void setInitLayout() {
		// 배치 관리자 선정( 컨테이너)
		// BorderLayout -- 컴포넌트들을 동서남북 강ㄴ데로 배치 시켜주는 레이아웃이다.
		setLayout(new BorderLayout());
		for (int i = 0; i < buttons.length; i++) {
			add(new JButton(directions[i]), directions[i]);
		}
	}
//		add(new JButton("센터"), BorderLayout.CENTER);

	public static void main(String[] args) {
		new BorderLayoutEx2();

	}// end of main
}// end of class
