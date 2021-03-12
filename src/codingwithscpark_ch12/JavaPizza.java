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
import javax.swing.JTextField;

public class JavaPizza extends JFrame implements ActionListener {

	private JPanel menuPanel, kindPanel, toppingPanel, sizePanel, resultPanel;
	private JButton orderButton, cancleButton;
	private JRadioButton combo, potato, niku;
	private JCheckBox pepper, cheese, pepperoni, Bacon;
	private JRadioButton small, medium, large;
	private JTextField textField;
	
	public JavaPizza() {
		this.setTitle("피자 주문");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 250);
		
		JLabel welComeLabel = new JLabel("자바 피자에 오신것을 환영합니다.", JLabel.CENTER);
		this.add(welComeLabel, BorderLayout.NORTH);
		
		menuPanel = new JPanel();
		menuPanel.setLayout(new GridLayout(1, 3));
		this.add(menuPanel, BorderLayout.CENTER);
		
		kindPanel = new JPanel(); // 종류 패널
		kindPanel.setLayout(new GridLayout(3, 1));
		kindPanel.setBorder(BorderFactory.createTitledBorder("종류"));
		menuPanel.add(kindPanel);
		
		combo = new JRadioButton("콤보(11,900)", true); // 종류 라디오 버튼
		potato = new JRadioButton("포테이토(12,900)");
		niku = new JRadioButton("불고기(13,900)");
		kindPanel.add(combo);
		kindPanel.add(potato);
		kindPanel.add(niku);
		ButtonGroup kindGroup = new ButtonGroup(); // 종류 그룹
		kindGroup.add(combo);
		kindGroup.add(potato);
		kindGroup.add(niku);
		
		toppingPanel = new JPanel(); // 추가토핑 패널
		toppingPanel.setLayout(new GridLayout(4, 1));
		toppingPanel.setBorder(BorderFactory.createTitledBorder("추가토핑"));
		menuPanel.add(toppingPanel);
		
		pepper = new JCheckBox("피망(+500)"); // 추가토핑 체크박스
		cheese = new JCheckBox("치즈(+1,000)");
		pepperoni = new JCheckBox("페페로니(+1,200)");
		Bacon = new JCheckBox("베이컨(+1,500)");
		toppingPanel.add(pepper);
		toppingPanel.add(cheese);
		toppingPanel.add(pepperoni);
		toppingPanel.add(Bacon);
		
		sizePanel = new JPanel(); // 사이즈 패널
		sizePanel.setLayout(new GridLayout(3, 1));
		sizePanel.setBorder(BorderFactory.createTitledBorder("크기"));
		menuPanel.add(sizePanel);
		
		small = new JRadioButton("Small(+0)", true); // 사이즈 라디오 버튼
		medium = new JRadioButton("Medium(+3,000)");
		large = new JRadioButton("Large(+5,000)");
		sizePanel.add(small);
		sizePanel.add(medium);
		sizePanel.add(large);
		ButtonGroup sizeGroup = new ButtonGroup(); // 사이즈 그룹
		sizeGroup.add(small);
		sizeGroup.add(medium);
		sizeGroup.add(large);
		
		resultPanel = new JPanel();
		this.add(resultPanel, BorderLayout.SOUTH);
		
		orderButton = new JButton("주문");
		orderButton.addActionListener(this);
		resultPanel.add(orderButton);
		
		cancleButton = new JButton("취소");
		cancleButton.addActionListener(this);
		resultPanel.add(cancleButton);
		
		textField = new JTextField(7);
		textField.setEnabled(false);
		resultPanel.add(textField);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		if(e.getSource() == )
		
	}
	
	public static void main(String[] args) {
		new JavaPizza();
	}
}
