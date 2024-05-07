package bubble.components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import bubble.BubbleFrame;
import bubble.interfaces.Moveable;
import bubble.service.BackgroundBubbleService;
import bubble.state.PlayerWay;

public class Bubble extends JLabel implements Moveable {

	private BubbleFrame mContext;

	// 의존성 컴포지션 관계
	private BackgroundBubbleService backgroundBubbleService;
	private Player player;

	private int x;
	private int y;

	// 움직임 상태
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean space;

	// 적군을 맞춘 상태
	private int state; // 0.(기본 물방울), 1.(적을 가둔 상태 물방울)

	private ImageIcon bubble;// 기본
	private ImageIcon bubbled;// 가둠
	private ImageIcon bomb;// 터짐

	// 연관 관계, 의존성 컴포지션 관계, 생성자 의존( DI)
	public Bubble(BubbleFrame mContext) {
		this.mContext = mContext;
		this.player = mContext.getPlayer();
		initData();
		setInitLayout();

	}

	// enum 타입의 활용
	PlayerWay playerway;

	// get ,set
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public ImageIcon getBubble() {
		return bubble;
	}

	public void setBubble(ImageIcon bubble) {
		this.bubble = bubble;
	}

	public ImageIcon getBubbled() {
		return bubbled;
	}

	public void setBubbled(ImageIcon bubbled) {
		this.bubbled = bubbled;
	}

	public ImageIcon getBomb() {
		return bomb;
	}

	public void setBomb(ImageIcon bomb) {
		this.bomb = bomb;
	}

	private void initData() {

		bubble = new ImageIcon("img/bubble.png");
		bubbled = new ImageIcon("img/bubbled.png");
		bomb = new ImageIcon("img/bomb.png");
		backgroundBubbleService = new BackgroundBubbleService(this);

		left = false;
		right = false;
		up = false;
		state = 0;
	}

	private void setInitLayout() {
		x = player.getX();
		y = player.getY();
		setIcon(bubble);
		setSize(50, 50);
		setLocation(x, y);
		setVisible(true);

	}

	@Override
	public void left() {
		left = true;
		for (int i = 0; i < 400; i++) {
			x--;
			setLocation(x, y);

			// 만약 왼쪽 벽에 --> up()
			if (backgroundBubbleService.leftWall()) {
				// 부딪힘
				break;
			}

			// 현재 버블에 x,y 좌표값을 알수 있다
			//
			System.out.println("적군 x 좌표 위치:" + mContext.getEnemy().getX());
			System.out.println("적군 y 좌표 위치:" + mContext.getEnemy().getY());
			// x 절대값만 확인해 보자.

			int absX = Math.abs(x - mContext.getEnemy().getX());
			System.out.println("absX:" + absX);

			int absY = Math.abs(y - mContext.getEnemy().getY());
			System.out.println("absY:" + absY);
			if (absX < 10 && absY < 50) {
				// 단, 적군이 살아 있을 때
//				crash();
				if (mContext.getEnemy().getState() == 0) {
					crash();
				}
			}

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		up();
	}

	@Override
	public void right() {
		right = true;
		for (int i = 0; i < 400; i++) {
			x++;
			setLocation(x, y);

			if (backgroundBubbleService.rightWall()) {
				break;
			}
			// 적군 감지 및 충
			System.out.println("적군 x 좌표 위치:" + mContext.getEnemy().getX());
			System.out.println("적군 y 좌표 위치:" + mContext.getEnemy().getY());
			// x 절대값만 확인해 보자.

			int absX = Math.abs(x - mContext.getEnemy().getX());
			System.out.println("absX:" + absX);

			int absY = Math.abs(y - mContext.getEnemy().getY());
			System.out.println("absY:" + absY);
			if (absX < 10 && absY < 50) {
				if (mContext.getEnemy().getState() == 0) {
					crash();
				}
			}

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		up();
	}

	@Override
	public void up() {
		up = true;
		while (true) {
			y--;
			setLocation(x, y);
			if (backgroundBubbleService.topWall()) {
				break;
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		clearBubble();
	}

	// 외부 호출 안될 메서드
	private void clearBubble() {
		// 3초 뒤에 터짐
		try {
			Thread.sleep(3000);
			setIcon(bomb);
			Thread.sleep(500);
			// TO.do
			setIcon(null);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void crash() {
		mContext.getEnemy().setState(1);
		state = 1;
		setIcon(bubbled);
		// 적군이 살아있는 상태에
		// 버블에 갇힝 상태로 변경
//		mContext.getEnemy().setIcon(null);

		mContext.remove(mContext.getEnemy());
//		mContext.getEnemy(); 가비지 컬렉터의 제거 대상이 된다
		mContext.repaint();
		// 버블에 이미지를 변경 처리
	}

}
