package bubble.service;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import bubble.components.Enemy;
import bubble.components.Enemy2;
import bubble.components.Player;

/**
 * 현재 메인 쓰레드는 너~무 빠쁨 백그라운드에서 계속 Player 에 움직임을 관찰할 예정
 */
public class BackgroundEnemyService2 implements Runnable {

	private BufferedImage image;
	private Player player;
	private Enemy2 enemy2;

	// 생성자 의존 주입 DI
	public BackgroundEnemyService2(Enemy2 enemy2) {
		this.enemy2 = enemy2;

		try {
			image = ImageIO.read(new File("img/backgroundMapService.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		while (true) {
			// 색상 확인 todo (보정값 필요)
			Color leftColor = new Color(image.getRGB(enemy2.getX() + 10, enemy2.getY() + 25));
			Color rightColor = new Color(image.getRGB(enemy2.getX() + 50 + 10, enemy2.getY() + 25));

			// Color bottomColor = new Color(image.getRGB(player.getX(), player.getY()));

			// 흰색이면 바닥 RGB => 255 255 255
			// 바닥인 경우 --> 255 0 0 (바닥이라고 판단 가능)
			// 바닥인 경우 --> 0 0 255 (바닥이라고 판단 가능)
			int bottomColorLeft = image.getRGB(enemy2.getX() + 20, enemy2.getY() + 50 + 5);
			int bottomColorRight = image.getRGB(enemy2.getX() + 50 - 10, enemy2.getY() + 50 + 5);

			// 하얀색 ------> int 값이 - 2
			if (bottomColorLeft + bottomColorRight != -2) {
				// 여기는 멈추야 한다. ( 빨간 바닥 또는 파란색 바닥)
				enemy2.setDown(false);
			} else {
				if (!enemy2.isUp() && !enemy2.isDown()) {
					enemy2.down();
				}
			}

			// 왼쪽에 충돌함
			if (leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
				System.out.println("왼쪽벽에 충돌 함.");
				enemy2.setLeftWallCrash(true);
				enemy2.setLeft(false);

			} else if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
				System.out.println("오른쪽벽에 충돌 함.");
				enemy2.setRightWallCrash(true);
				enemy2.setRight(false);
			} else {
				enemy2.setLeftWallCrash(false);
				enemy2.setRightWallCrash(false);
			}

			// 위 두 조건이 아니면 player 마음대로 움직일 수 있다.
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

}
