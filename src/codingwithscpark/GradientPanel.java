package codingwithscpark;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GradientPanel extends JFrame {
	
	public GradientPanel() {
		JFrame frame = new JFrame();
		
		frame.setSize(610, 140);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("GradientBasic");
		frame.add(new MyPanel());
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new GradientPanel();
	}

}

class MyPanel extends JPanel {

	ArrayList<Shape> shape = new ArrayList<Shape>();
	
	public MyPanel() {
		shape.add(new Rectangle2D.Float(10, 10, 70, 70));
		shape.add(new RoundRectangle2D.Float(110, 10, 70, 80, 20, 20));
		shape.add(new Ellipse2D.Float(210, 10, 80, 80));
		shape.add(new Arc2D.Float(310, 10, 80, 80, 90, 90, Arc2D.OPEN));
		shape.add(new Arc2D.Float(410, 10, 80, 80, 0, 180, Arc2D.CHORD));
		shape.add(new Arc2D.Float(510, 10, 80, 80, 45, 90, Arc2D.PIE));
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		GradientPaint gp = new GradientPaint(0, 10, Color.white, 0, 70, Color.red);
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//		g2.setColor(Color.black);
//		g2.setStroke(new BasicStroke(3));
		g2.setPaint(gp);
		
		for(int i=0; i<shape.size(); i++) {
			g2.fill(shape.get(i));
		}
	}
}