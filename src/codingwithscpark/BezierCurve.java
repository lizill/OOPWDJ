package codingwithscpark;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BezierCurve extends JFrame implements MouseListener, MouseMotionListener {

	private int[] xs = {50, 150, 400, 450};
	private int[] ys = {200, 50, 300, 200};
	
	private int dragIndex = -1;
	
	class BezierPanel extends JPanel {
		@Override
		public void paintComponent(Graphics g) {
			// xs, ys의 좌표를 이용해서 베지어 곡선을 그린다.
		}
	}
	
	public static void main(String[] args) {

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// 선택된 점이 있는지 보고, 즉 dragIndex가 -1이 아닌지 보고
		// 아니라면 선택된 점의 x, y 좌표를 변경한다.
		
		repaint();
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// 네 개의 점 중에서 어떤 점이 선택되었는지를 체크
		dragIndex = 0; // 1, 2, 3

		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
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
