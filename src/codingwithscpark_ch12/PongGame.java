package codingwithscpark_ch12;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PongGame extends JPanel implements ActionListener, KeyListener {
	
	private static final int WIDTH = 1280;
	private static final int HEIGHT = 720;
	
	private int direcX = 1;
	private int direcY = -1;

	private final int BSTART_X = 580, BSTART_Y = 260;
	private int BSPEED = 4;
	private final int BAll_SIZE = 30;
	private int bx, by;
	
	private final int P_HEIGHT = 120;
	private final int P_WIDTH = 20;
	private final int P_SPEED = 8;
	private int pAy, pBy;
	private int aScore = 0, bScore = 0;
	
	private Timer timer;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		frame.add(new PongGame());
		frame.setTitle("핑퐁 게임");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	public PongGame() {
		
		setBackground(Color.black);
		addKeyListener(this);
		setFocusable(true);
		requestFocus();
		
		bx = BSTART_X;
		by = BSTART_Y;
		
		pAy = HEIGHT/2 - P_HEIGHT/2;
		pBy = HEIGHT/2 - P_HEIGHT/2;
		
		timer = new Timer(20, this); // ms, actionListener
		timer.start();
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// x, y 좌표에 공을 그린다.
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		// 라인 그리기
		g2.setColor(Color.white);
		g2.drawLine(WIDTH/2-8, 0, WIDTH/2-8, HEIGHT);
		
		// 점수 그리기
		g2.setColor(Color.green);
		g2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 60));
		g2.drawString(String.format("%02d", aScore), WIDTH/2-8 - 130, 60);
		g2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 60));
		g2.drawString(String.format("%02d", bScore), WIDTH/2-8 + 60, 60);
		
		// 공 그리기
		g2.setColor(Color.white);
		g2.fillOval(bx, by, BAll_SIZE, BAll_SIZE);
		
		// 플레이어 1
		g2.setColor(Color.blue);
		g2.fillRect(0, pAy, P_WIDTH, P_HEIGHT);
		
		// 플레이어 2
		g2.setColor(Color.red);
		g2.fillRect(WIDTH-P_WIDTH-16, pBy, P_WIDTH, P_HEIGHT);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// x, y 좌표 변
		if(by < 0 || by+BAll_SIZE+40 > HEIGHT) { // 윗쪽 벽 충돌, 아랫쪽 벽 충돌
			direcY *= -1;
		}
		else if(bx < 0) { // 왼쪽 벽 충돌
			direcX *= -1;
			bScore++;
		}
		else if(bx+BAll_SIZE+16 > WIDTH) { // 오른쪽 벽 충돌
			direcX *= -1;
			aScore++;
		} 
		else if(collisionCheck()) {
			direcX *= -1;
		}
		
		bx += BSPEED*direcX;
		by += BSPEED*direcY;
		
		repaint();
	}
	
	public boolean collisionCheck() {
		
		if(bx < P_WIDTH && (by-BAll_SIZE/2 > pAy && by-BAll_SIZE/2 < pAy + P_HEIGHT)) {
			return true;
		} 
		if (bx+BAll_SIZE > WIDTH-P_WIDTH-16 && (by-BAll_SIZE/2 > pBy && by-BAll_SIZE/2 < pBy + P_HEIGHT)) {
			return true;
		}
		
		return false;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			pBy -= P_SPEED;
			if(pBy < 0-P_SPEED) pBy += P_SPEED;
		} else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			pBy += P_SPEED;
			if(pBy+P_HEIGHT > HEIGHT-40+P_SPEED) pBy -= P_SPEED;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_W) {
			pAy -= P_SPEED;
			if(pAy < 0-P_SPEED) pAy += P_SPEED;
		} else if(e.getKeyCode() == KeyEvent.VK_S) {
			pAy += P_SPEED;
			if(pAy+P_HEIGHT > HEIGHT-40+P_SPEED) pAy -= P_SPEED;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}

}