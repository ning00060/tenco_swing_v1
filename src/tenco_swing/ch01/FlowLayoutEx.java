package tenco_swing.ch01;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

// Swining -> 배치 관리자 : FlowLayout
// 컴포넌트들을 (버튼, 라벨) 등을 수평, 수직으로 배치를 해주는 클래스 이다.
public class FlowLayoutEx extends JFrame {

	// 배열 활용
	private JButton[] button1 ;
//	private JButton button2;
//	private JButton button3;
//	private JButton button4;
//	private JButton button5;
//	private JButton button6;

	public FlowLayoutEx() {
		super.setTitle("FlowLayout 연습");
		super.setSize(500, 500);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 생성자에서 메서드 호출 가능하다
		initData();
		setInitLayout();
	}

	// 멤버 변수를 초기화 하는 기능(값 넣다)
	// 반복문의 활용
	public void initData() {
		button1= new JButton[10];
		for (int i = 0; i < button1.length; i++) {
			button1[i] = new JButton("button" + i);

		}

	}

	// 컴포넌트들을 배치하는 기능
	public void setInitLayout() {
		// 배치 관리자 --> BorderLayout 이라는 배치관리자가 기본으로 활용 된다.
//		FlowLayoutEx flowlayout = new FlowLayoutEx();
//		super.setLayout(flowlayout); //배치 관리자 --> FlowLayout

		// 배치관리자 생성 및 JFrame 셋팅
//		super.setLayout(new FlowLayout(50 ,100,200));
		super.setLayout(new FlowLayout(FlowLayout.LEADING, 124, 232));

		// 컴포넌트들을 붙이다.
		// 반복문 활용
		for (int i = 0; i < button1.length; i++) {
			super.add(button1[i]);

		}

	}

	// 코드 테스트
	public static void main(String[] args) {
		new FlowLayoutEx();// <-- 익명 클래스
		// 다시 접근해서 사용할 일 없으면
	}
}
