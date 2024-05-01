package ch04;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * JLabel 을 이용햇 ㅓ이미지를 다룰 수 있다. JLabel.add(); 메서드를 통해서 이미지를 겹칠수 있다. 좌표 기준으로 이미지를
 * 셋팅을 하려면 배치관리자를 null 값으로 셋팅해야한다.
 */

public class MyFrame extends JFrame {

	private JLabel backgroundMap;
	private JLabel player;
	private JLabel player2;

	public MyFrame() {
		initData();
		SetInitLayout();
	}

	private void initData() {
		setTitle("jLabel을 활용한 이미지 사용 연습");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Icon icon = new ImageIcon("images/background2.png"); // 업 캐스팅 상태
		backgroundMap = new JLabel(icon);
		backgroundMap.setSize(1500, 800);
		backgroundMap.setLocation(0, 0);

		player = new JLabel(new ImageIcon("images/image3.png"));
		player.setSize(56, 99);
		player.setLocation(200, 200);
		player2 = new JLabel(new ImageIcon("images/image2.png"));
		player2.setSize(100, 100);
		player2.setLocation(100, 200);
	}

	private void SetInitLayout() {
		// 좌표값으로 셋팅하기위해서는 배치 관리자를 null갑으로 만들어 주어야 한다.
		setLayout(null);
		add(backgroundMap);
		backgroundMap.add(player);
		backgroundMap.add(player2);
		setVisible(true);
	}
}
