package codingwithscpark;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SecondaryFunction extends JFrame implements ActionListener {
	
	public SecondaryFunction() {
		this.setSize(600, 700);
		this.setTitle("2���Լ� �׸���");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextField fieldA = new JTextField(10);
		JTextField fieldB = new JTextField(10);
		JTextField fieldC = new JTextField(10);
		JButton button = new JButton("�׸���");
		
		JPanel textPanel = new JPanel();
		textPanel.add(fieldA);
		textPanel.add(fieldB);
		textPanel.add(fieldC);
		textPanel.add(button);
		
		this.add(textPanel, BorderLayout.NORTH);
		this.add(new FunctionPanel(), BorderLayout.CENTER);
		
		this.setVisible(true);
	}

	class FunctionPanel extends JPanel {
		
		public FunctionPanel() {
			
		}
		
		@Override
		public void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			g2.setStroke(new BasicStroke(2));
			g2.drawLine(300, 0, 300, 600);
			g2.drawLine(0, 300, 600, 300);
			
			g2.setColor(Color.red);
			for(int i=0; i<300; i++) {
				g2.drawLine(300+i, 300+i*i, 300+i, 300-(i+1)*(i+1));
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public static void main(String[] args) {
		new SecondaryFunction();
	}
}