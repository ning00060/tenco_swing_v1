package ch08;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JFrame {

	BufferedImage backgroundImage;
	BufferedImage player1;
	BufferedImage enemy1;
	ImagePanel ImagePanel;
	int playerX = 150;
	int playerY = 300;
	int enemyX = 250;
	int enemyY = 420;
	boolean going = true;
	boolean going2 = true;

	public GameFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}

	// 클래스 안ㅇ ㅔ클래스 -> 중첩 클래스 -> 외부클래스, 내부클래스
	private class ImagePanel extends JPanel implements Runnable {

		@Override
		protected void paintComponent(Graphics g) {

			super.paintComponent(g);
			g.drawImage(backgroundImage, 0, 0, 600, 600, null);
			g.drawImage(player1, playerX, playerY, 50, 50, null);
			g.drawImage(enemy1, enemyX, enemyY, 50, 50, null);
			// Todo 플레이어, 적군 그림 그려야 함
			// 쓰레드를 활용할 예정
		}

		@Override
		public void run() {
			boolean direction = true;
			// true : 왼쪽으로 가는 상황
			// false: 오른쪽으로 가는 상황
			while (going) {
				System.out.println("진행중");

				if (direction) {
					enemyX -= 10;
				} else {
					enemyX += 10;
				}
				// 방향 바꾸는 개념은 적군 x좌표값이
				if (enemyX <= 50) {
					// false --> 오른쪽으로
					direction = false;
				}
				if (enemyX >= 500) {
					// true --> 왼쪽으로
					direction = true;
				}
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				repaint();
				System.out.println("유지중");
			}
		}

	}

	private void initData() {
		setSize(600, 600);
		setTitle("thread 활용한 미니 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try {
			// 예외가 발생할 수 있는 코드를 작성하는 영역
			backgroundImage = ImageIO.read(new File("img/backgroundMap.png"));
			player1 = ImageIO.read(new File("img/playerR.png"));
			enemy1 = ImageIO.read(new File("img/enemyL.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		ImagePanel = new ImagePanel();
		// 다른 작업자에게 일을 위임 시킨다
		Thread thread = new Thread(ImagePanel);
		thread.start();

	}

	private void setInitLayout() {
		// 배치관리자를 좌표 기반
//		setLayout(null);
//		setResizable(false);//프레임 크기 조절 불가 설정
		setVisible(true);

		add(ImagePanel);
	}

	private void addEventListener() {
		// 이벤트 리스너 등록 방법 2가지 중
		// 익명
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
//				int code = e.getKeyCode();
//				if (code == KeyEvent.VK_SPACE) {
//					// 1.스페이스를 눌렀을때 적군을 멈출 수 있도록 코드 수정
//					while (true) {
//					System.out.println("스페이스작동중");
//						boolean direction = false;
//						if (direction) {
//							enemyX -= 10;
//						} else {
//							enemyX += 10;
//						}
//						// 방향 바꾸는 개념은 적군 x좌표값이
//						if (enemyX <= 50) {
//							// false --> 오른쪽으로
//							direction = true;
//						}
//						if (enemyX >= 500) {
//							// true --> 왼쪽으로
//							direction = false;
//						}
//					}
//				}
			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {

//				System.out.println("여기가 동작 합니다");
				int code = e.getKeyCode();
				System.out.println(code);
				if (code == KeyEvent.VK_UP) {
					playerY -= 10;
				} else if (code == KeyEvent.VK_DOWN) {
					playerY += 10;
				} else if (code == KeyEvent.VK_LEFT) {
					playerX -= 10;
				} else if (code == KeyEvent.VK_RIGHT) {
					playerX += 10;
				} else if (code == KeyEvent.VK_SPACE) {
//					 1.스페이스를 눌렀을때 적군을 멈출 수 있도록 코드 수정
					if (going == true) {
						going = false;
						System.out.println("멈춤");

					}
				} if (code != KeyEvent.VK_SPACE) {
					if (going == false) {
						going = true;
						Thread thread = new Thread(ImagePanel);
						thread.start();
					}
					repaint();
					System.out.println("실행됨");
				}

				// 2. player가 적군과 만났다면 player 그림을 없애 주세요
				if (playerX == enemyX && playerX == enemyX) {
					player1 = null;
					repaint();

				} else {
					try {
						player1 = ImageIO.read(new File("img/playerR.png"));
						repaint();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				repaint();
			}

		});

	}

	public static void main(String[] args) {
		new GameFrame();
	}
}
