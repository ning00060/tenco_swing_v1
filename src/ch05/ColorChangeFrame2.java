package ch05;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class ColorChangeFrame2 extends JFrame implements ActionListener {
	private JPanel panel;
	private JButton button1;
	private JButton button2;

	public ColorChangeFrame2() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		panel = new JPanel();
		panel.setBackground(Color.yellow);
		button1 = new JButton("click1");
		button2 = new JButton("click2");

	}

	private void setInitLayout() {
		add(panel, BorderLayout.CENTER);
		setVisible(true);
		add(button1, BorderLayout.NORTH);
		add(button2, BorderLayout.SOUTH);
	}

	// 이 메서드에 책임은 이벤트 리스너만 등록
	private void addEventListener() {
		button1.addActionListener(this);
		button2.addActionListener(this);
	}

	// -콜백 메서드
	// 오버라이드 :이벤트가 일어나면 호출 되어지는 메서드
	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println(e.getSource().toString());
		Object object = e.getSource();
		JButton selectedButton = (JButton) e.getSource();
		if (selectedButton == this.button1) {
			System.out.println("버튼1번 눌러짐");
			panel.setBackground(Color.black);
		} else {
			System.out.println("버튼2번 눌러짐");
			panel.setBackground(Color.blue);
		}
	}

	public static void main(String[] args) {
		new ColorChangeFrame2();
	}// end main

}
