package codingwithscpark_ch12;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class JavaPizza extends JFrame implements ActionListener {

	private JPanel menuPanel, kindPanel, toppingPanel, sizePanel, resultPanel;
	private JButton orderButton, cancleButton;
	private JRadioButton combo, potato, niku;
	private JCheckBox pepper, cheese, pepperoni, Bacon;
	private JRadioButton small, medium, Large;
	
	public JavaPizza() {
		this.setTitle("피자 주문");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 250);
		
		JLabel welComeLabel = new JLabel("자바 피자에 오신것을 환영합니다.", JLabel.CENTER);
		this.add(welComeLabel, BorderLayout.NORTH);
		
		menuPanel = new JPanel();
		menuPanel.setLayout(new GridLayout(1, 3));
		this.add(menuPanel, BorderLayout.CENTER);
		
		kindPanel = new JPanel();
		kindPanel.setLayout(new GridLayout(3, 1));
		combo = new JRadioButton("콤보", true);
		potato = new JRadioButton("포테이토");
		niku = new JRadioButton("불고기");
		ButtonGroup kindGroup = new ButtonGroup();
		kindGroup.add(combo);
		kindGroup.add(potato);
		kindGroup.add(niku);
		kindPanel.setBorder(BorderFactory.createTitledBorder("종류"));
		menuPanel.add(kindPanel);
		
		
		resultPanel = new JPanel();
		this.add(resultPanel, BorderLayout.SOUTH);
		
		orderButton = new JButton("주문");
		orderButton.addActionListener(this);
		resultPanel.add(orderButton);
		
		cancleButton = new JButton("취소");
		cancleButton.addActionListener(this);
		resultPanel.add(cancleButton);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		new JavaPizza();
	}
}
