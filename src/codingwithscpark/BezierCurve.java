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
			// xs, ys�� ��ǥ�� �̿��ؼ� ������ ��� �׸���.
		}
	}
	
	public static void main(String[] args) {

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// ���õ� ���� �ִ��� ����, �� dragIndex�� -1�� �ƴ��� ����
		// �ƴ϶�� ���õ� ���� x, y ��ǥ�� �����Ѵ�.
		
		repaint();
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// �� ���� �� �߿��� � ���� ���õǾ������� üũ
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
