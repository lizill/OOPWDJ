package codingwithscpark_ch12;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class Capture extends JPanel {
	
	private Image img = null;
	private JFrame frame;
	
	public Capture() {
		frame = new JFrame();
		frame.setSize(1280, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("캡쳐 프로그램");
		
		JButton button = new JButton("캡쳐하기");
		button.addActionListener((e) -> {
			this.capture();
		});
		
		frame.add(button, BorderLayout.SOUTH);
		frame.add(this, BorderLayout.CENTER);
		frame.setVisible(true);
	}
	
	public void capture() {
        Robot robot;
        BufferedImage bufImage = null;
        try {
            robot = new Robot();
            Rectangle area = new Rectangle(frame.getWidth(), frame.getHeight());

            bufImage = robot.createScreenCapture(area);

            this.img = bufImage;
            this.repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	@Override
	public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, frame.getWidth(), frame.getHeight(), this);
	}

	public static void main(String[] args) {
		new Capture();
	}
}
