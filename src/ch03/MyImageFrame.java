package ch03;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 중첩 클래스 --> 외부, 내부 클래스로 내부 클래스로 --> 인스턴스 클래스
 */
public class MyImageFrame extends JFrame {

	private MyImagePanel myImagePanel;

	public MyImageFrame() {
		initData();
		setInitLayout();

	}

	private void initData() {
		setTitle("이미지활요연습");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		myImagePanel = new MyImagePanel();

	}

	private void setInitLayout() {
		add(myImagePanel);
		setVisible(true);
		//
	}

	// 내부 클래스 --> static 키워드 활용
	// 정적 (static) 내부 클래스라고 한다.
	static class MyImagePanel extends JPanel {
		private Image image1;
		private Image image2;

		public MyImagePanel() {
			image1 = new ImageIcon("image1.png").getImage();
			image2 = new ImageIcon("image2.png").getImage();
			// imageIcon 데이터 타입 -> getImage() 메서드를 호출하면
			// image 데이터 타입을 만들어 낼수 있다.
		}

		// paints --> x
		// print --> x
		// paint --> o
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			g.drawImage(image1, 100, 100, 200, 200, null);
			g.drawImage(image2, 200, 100, 200, 200, null);

		}
	}

}
