package codingwithscpark;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class AnimationBasic extends JPanel implements ActionListener {

	private static final int WIDTH = 1280, HEIGHT = 720;
	private BufferedImage image;
	private Timer timer;
	private int x, y;
	private int drecX = 1;
	private int drecY = -1;
	private final int START_X = 0, START_Y = 200;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.add(new AnimationBasic());
		frame.setTitle("애니메이션 테스트");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		
		new AnimationBasic();
	}
	
	public AnimationBasic() {
		// 이미지 파일을 읽어서 image 객체로 생성
		// 20ms 마다 이벤트를 발생시키는 timer 객체를 생성하고 timer를 start 시킴
		
		File file = new File("images/ship.png"); // 119, 200
		try {
			image = ImageIO.read(file);
		} catch(IOException e) {
			e.printStackTrace();
			System.exit(1);
			// 이미지 읽기 실패시 프로그램 종료
		}
		
		x = START_X;
		y = START_Y;
		
		timer = new Timer(20, this); // ms, actionListener
		timer.start();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// x, y 좌표에 이미지를 그린다.
		g.drawImage(image, x, y, this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// x, y 좌표 변경
		
//		if(x > WIDTH) {
//			x = START_X;
//			y = START_Y;
//		}
		
		if(y < 0) {
			drecX *= 1;
			drecY *= -1;
		}
		if(y-200 > HEIGHT) {
			drecX *= 1;
			drecY *= -1;
		}
		
		x = x + 1*drecX;
		y = y + 1*drecY;
		
		repaint();
	}

}
