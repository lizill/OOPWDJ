package codingwithscpark;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.GeneralPath;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BezierCurve extends JFrame implements MouseListener, MouseMotionListener {

	private int[] xs = {50, 150, 400, 450};
	private int[] ys = {200, 50, 300, 200};
	
	private int dragIndex = -1;
	
	private BezierPanel drawPanel;
	
	class BezierPanel extends JPanel {
		@Override
		public void paintComponent(Graphics g) {
			// xs, ys의 좌표를 이용해서 베지어 곡선을 그린다.
			
			Graphics2D g2 = (Graphics2D) g;
			g2.setColor(Color.blue);
			g2.fillRect(xs[0]-8, ys[0]-8, 16, 16);
			g2.fillRect(xs[2]-8, ys[2]-8, 16, 16);
			g2.setColor(Color.red);
			g2.fillRect(xs[1]-8, ys[1]-8, 16, 16);
			g2.fillRect(xs[3]-8, ys[3]-8, 16, 16);
			
			g2.setColor(Color.black);
			GeneralPath path = new GeneralPath();
			path.moveTo(xs[0], ys[0]);
			path.curveTo(xs[1], ys[1], xs[2], ys[2], xs[3], ys[3]);
			g2.draw(path);
		}
	}
	
	public BezierCurve() {
		this.setSize(600, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("베지어 커브 데모");
		
		drawPanel = new BezierPanel();
		drawPanel.addMouseListener(this);
		drawPanel.addMouseMotionListener(this);
		this.add(drawPanel, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		new BezierCurve();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// 선택된 점이 있는지 보고, 즉 dragIndex가 -1이 아닌지 보고
		// 아니라면 선택된 점의 x, y 좌표를 변경한다.
		
		if(dragIndex != -1) {
			xs[dragIndex] = e.getX();
			ys[dragIndex] = e.getY();
		}
		
		repaint();
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// 네 개의 점 중에서 어떤 점이 선택되었는지를 체크
		dragIndex = -1; // 1, 2, 3

		for(int i=0; i<4; i++) {
			Rectangle r = new Rectangle(xs[i]-8, ys[i]-8, 16, 16);
			if(r.contains(e.getX(), e.getY())) {
				dragIndex = i;
			}
		}
		
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		dragIndex = -1;
		
		repaint();
	}
	
	@Override
	public void mouseMoved(MouseEvent arg0) {}

	@Override
	public void mouseClicked(MouseEvent arg0) {}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	

}