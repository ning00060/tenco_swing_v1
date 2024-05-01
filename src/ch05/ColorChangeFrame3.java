package ch05;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ColorChangeFrame3 extends JFrame implements ActionListener {

	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JPanel panel1;
	private JPanel panel2;

	public ColorChangeFrame3() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		button1 = new JButton("1");
		button2 = new JButton("2");
		button3 = new JButton("3");
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel1.setBackground(Color.yellow);

	}

	private void setInitLayout() {
		add(panel1, BorderLayout.CENTER);
		add(panel2, BorderLayout.SOUTH);
//		add(button1, BorderLayout.SOUTH);
//		add(button2, FlowLayout.LEFT);
		panel2.add(button1);
		panel2.add(button2);
		panel2.add(button3);
		setVisible(true);
	}

	private void addEventListener() {
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
	}

	public static void main(String[] args) {
		new ColorChangeFrame3();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obecjt = e.getSource();
		JButton selectedButton = (JButton) e.getSource();
		if (selectedButton == this.button1) {
			System.out.println("버튼1번 눌러짐");
			panel1.setBackground(Color.black);
		} else if (selectedButton == this.button2) {
			System.out.println("버튼2번 눌러짐");
			panel1.setBackground(Color.blue);
		} else {
			System.out.println("버튼3번 눌러짐");
			panel1.setBackground(Color.CYAN);
		}
	}

}
