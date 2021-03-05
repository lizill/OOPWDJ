package codingwithscpark;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class AnimationBasic extends JPanel implements ActionListener {

	private static final int WIDTH = 1280, HEIGHT = 720;

	private int x, y;
	private int direcX = 1;
	private int direcY = -1;
	
	private final int START_X = 580, START_Y = 260;
	private final int SPEED = 4;
	
	private BufferedImage image;
	private Timer timer;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		frame.add(new AnimationBasic());
		frame.setTitle("�ִϸ��̼� �׽�Ʈ");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		new AnimationBasic();
	}
	
	public AnimationBasic() {
		// �̹��� ������ �о image ��ü�� ����
		// 20ms ���� �̺�Ʈ�� �߻���Ű�� timer ��ü�� �����ϰ� timer�� start ��Ŵ
		
		File file = new File("images/ship.png"); // �̹��� ũ�� 119, 200
		try {
			image = ImageIO.read(file);
		} catch(IOException e) {
			e.printStackTrace();
			System.exit(1);
			// �̹��� �б� ���н� ���α׷� ����
		}
		
		x = START_X;
		y = START_Y;
		
		timer = new Timer(20, this); // ms, actionListener
		timer.start();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// x, y ��ǥ�� �̹����� �׸���.
		g.drawImage(image, x, y, this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// x, y ��ǥ ����
		
		if(y < 0 || y+200+40 > HEIGHT) { // ���� �� �浹, �Ʒ��� �� �浹
			direcY *= -1;
		}
		else if(x < 0 || x+119+16 > WIDTH) { // ���� �� �浹, ������ �� �浹
			direcX *= -1;
		}
		
		x += SPEED*direcX;
		y += SPEED*direcY;
		
		repaint();
	}

}
