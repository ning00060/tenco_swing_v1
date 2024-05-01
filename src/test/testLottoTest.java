package test;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class testLottoTest extends JFrame implements ActionListener {

	private testLotto testLotto;
	private JButton button;
	private int xplace = 50;
	private int yplace = 200;
	private int move = 50;
	private boolean go = true;

	public testLottoTest() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button = new JButton("Start");
		testLotto = new testLotto();
	}

	private void setInitLayout() {
		add(button, BorderLayout.NORTH);
		setVisible(true);
	}

	private void addEventListener() {
		button.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("시작");
		go = false;
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		if (go) {
			g.drawString("로또 번호를 클릭하세요", 230, 200);
		} else {
			int[] getNumber = testLotto.createNumber();
			for (int i = 0; i < getNumber.length; i++) {
				g.drawString(getNumber[i] + "", xplace + (i * move), yplace);

			}
		}

	}

	public static void main(String[] args) {

		new testLottoTest();
	}

}
