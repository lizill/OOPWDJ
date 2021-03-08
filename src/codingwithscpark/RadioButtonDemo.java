package codingwithscpark;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

public class RadioButtonDemo extends JFrame implements ActionListener {

	private JPanel topPanel, sizePanel, resultPanel;
	private JRadioButton small, medium, large;
	private JLabel textLabel;
	
	public RadioButtonDemo() {
		topPanel = new JPanel();
		JLabel label = new JLabel("어떤 크기의 커피를 주문하시겠습니까?");
		topPanel.add(label);
		
		this.add(topPanel, BorderLayout.NORTH);
		
		sizePanel = new JPanel();
		small = new JRadioButton("Small size");
		small.addActionListener(this);
		medium = new JRadioButton("medium size");
		medium.addActionListener(this);
		large = new JRadioButton("large size");
		large.addActionListener(this);
		
		ButtonGroup group = new ButtonGroup();
		group.add(small);
		group.add(medium);
		group.add(large);
		// radioButton 은 하나만 선택 되야하므로 논리적인 그룹으로 묶어줘야 한다.
		Border border = BorderFactory.createTitledBorder("크기"); // 경계선
		sizePanel.setBorder(border);
		
		sizePanel.add(small);
		sizePanel.add(medium);
		sizePanel.add(large);
		
		this.add(sizePanel, BorderLayout.CENTER);
		
		resultPanel = new JPanel();
		textLabel = new JLabel("크기가 선택되지 않았습니다.");
		textLabel.setForeground(Color.red);
		resultPanel.add(textLabel);
		
		this.add(resultPanel, BorderLayout.SOUTH);
		
		this.setSize(350, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == small) {
			textLabel.setText("small 사이즈가 선택 되었습니다.");
		} else if(e.getSource() == medium) {
			textLabel.setText("medium 사이즈가 선택 되었습니다.");
		} else {
			textLabel.setText("large 사이즈가 선택 되었습니다.");
		}
	}
	
	public static void main(String[] args) {
		new RadioButtonDemo();
	}

}
