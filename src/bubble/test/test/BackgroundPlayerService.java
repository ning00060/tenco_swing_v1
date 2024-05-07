package bubble.test.test;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BackgroundPlayerService implements Runnable {

	Player player;
	BufferedImage image;

	public BackgroundPlayerService(Player player) {
		this.player = player;
		try {
			image = ImageIO.read(new File("img/backgroundMap.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public void run() {
	}
		Color leftColor = new Color(image.getRGB(player.getX() + 20, player.getY()) + 30);
		Color rightColor = new Color(image.getRGB(player.getX() + 50, player.getY()) + 30);
//		if(leftColor.getRed()==255&&leftColor.getBlue()==255&&leftColor.getGreen()==255)
}
