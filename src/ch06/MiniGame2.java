package ch06;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniGame2 extends JFrame {

	private JLabel backgroundmap;
	private JLabel image1;
	private int ximage = 100;
	private int yimage = 100;
	private final int move = 10;
	private final int xlimit = 440;
	private final int ylimit = 370;

	public MiniGame2() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		Icon icon = new ImageIcon("images/background2.png");
		backgroundmap = new JLabel(icon);
		backgroundmap.setSize(500, 500);
		backgroundmap.setLocation(0, 0);
		image1 = new JLabel(new ImageIcon("images/image3.png"));
		image1.setSize(56, 99);
		image1.setLocation(100, 100);
	}

	private void setInitLayout() {
		setVisible(true);
		add(backgroundmap);
		backgroundmap.add(image1);

	}

	private void addEventListener() {
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_UP) {

					yimage -= move;
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					ximage -= move;
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					ximage += move;
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					yimage += move;
				}
				if (ximage > xlimit) {
					ximage = xlimit;
					System.out.println("범위를 초과하였습니다");
				} else if (ximage < -xlimit) {
					ximage = -xlimit;
					System.out.println("범위를 초과하였습니다");
				}
				if (yimage > ylimit) {
					yimage = ylimit;
					System.out.println("범위를 초과하였습니다");
				} else if (yimage < -ylimit) {
					yimage = -ylimit;
					System.out.println("범위를 초과하였습니다");
				}
				image1.setLocation(ximage, yimage);
			}
		});
	}

	public static void main(String[] args) {
		new MiniGame2();
	}
}
