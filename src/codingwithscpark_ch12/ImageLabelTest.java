package codingwithscpark_ch12;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class ImageLabelTest extends JFrame implements ActionListener {
	private JPanel panel;
	private JLabel label;
	private JButton button;
	
	public ImageLabelTest() {
		this.setSize(300, 250);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("이미지 라벨 테스트");
		
		panel = new JPanel();
		label = new JLabel("이미지를 보려면 버튼을 누르세요");
		
		button = new JButton("이미지 보기");
//		ImageIcon icon = new ImageIcon("images/icon.gif");
//		button.setIcon(icon);
		button.addActionListener(this);
		
		panel.add(label);
		panel.add(button);
		
		this.add(panel);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ImageIcon ship = new ImageIcon("images/ship.png");
		File file = new File("images/ship.png");
		System.out.println(file.getAbsolutePath());
		label.setIcon(ship);
		label.setText(null);
	}
	
	public static void main(String[] args) {
		new ImageLabelTest();
	}
}