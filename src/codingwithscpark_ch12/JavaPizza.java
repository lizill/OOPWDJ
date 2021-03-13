package codingwithscpark_ch12;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class JavaPizza extends JFrame implements ActionListener, ItemListener {

	private JPanel menuPanel, kindPanel, toppingPanel, sizePanel, resultPanel;
	private JButton orderButton, cancleButton;
	private JLabel priceText;
	private static int price = 11900;
	
	private ArrayList<JRadioButton> menuList = new ArrayList<>();
	private String[] menuNameList = {"파인애플(11,900)", "포테이토(12,900)", "불고기(13,900)"};
	private int[] menuPriceList = {11900, 12900, 13900};
	private int mRadioBtnPreChecked = 0; // 0, 1, 2, 3
	
	private ArrayList<JCheckBox> toppingList = new ArrayList<>();
	private String[] toppingNameList = {"피망(+500)", "치즈(+1,000)", "페페로니(+1,200)", "베이컨(+1,500)"};
	private int[] toppingPriceList = {500, 1000, 1200, 1500};
	private boolean[] isCeckBoxChecked = new boolean[toppingNameList.length];
	
	private ArrayList<JRadioButton> sizeList = new ArrayList<>();
	private String[] sizeNameList = {"Smaill(+0)", "Medium(3,000)", "Large(5,000)"};
	private int[] sizePriceList = {0, 3000, 5000};
	private int sRadioBtnPreChecked = 0; // 0, 1, 2
	
	public JavaPizza() {
		this.setTitle("피자 주문");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 250);
		
		JLabel welComeLabel = new JLabel("자바 피자에 오신것을 환영합니다.", JLabel.CENTER);
		this.add(welComeLabel, BorderLayout.NORTH);
		
		menuPanel = new JPanel();
		menuPanel.setLayout(new GridLayout(1, 3));
		this.add(menuPanel, BorderLayout.CENTER);
		
		kindPanel = new JPanel(); // Kind Panel
		kindPanel.setLayout(new GridLayout(3, 1));
		kindPanel.setBorder(BorderFactory.createTitledBorder("종류"));
		menuPanel.add(kindPanel);

		ButtonGroup kindGroup = new ButtonGroup(); // Menu List
		for(int i=0; i<menuNameList.length; i++) {
			if(i==0) {
				menuList.add(new JRadioButton(menuNameList[i], true));
			} else {
				menuList.add(new JRadioButton(menuNameList[i]));
			}
			menuList.get(i).addItemListener(this);
			kindPanel.add(menuList.get(i));
			kindGroup.add(menuList.get(i));
		}
		
		toppingPanel = new JPanel(); // Topping Panel
		toppingPanel.setLayout(new GridLayout(4, 1));
		toppingPanel.setBorder(BorderFactory.createTitledBorder("추가토핑"));
		menuPanel.add(toppingPanel);
		
		for(int i=0; i<toppingNameList.length; i++) {
			toppingList.add(new JCheckBox(toppingNameList[i]));
			toppingList.get(i).addItemListener(this);
			toppingPanel.add(toppingList.get(i));
		}
		
		sizePanel = new JPanel(); // Size Panel
		sizePanel.setLayout(new GridLayout(3, 1));
		sizePanel.setBorder(BorderFactory.createTitledBorder("크기"));
		menuPanel.add(sizePanel);
		
		ButtonGroup sizeGroup = new ButtonGroup(); // Size List
		for(int i=0; i<sizeNameList.length; i++) {
			if(i==0) {
				sizeList.add(new JRadioButton(sizeNameList[i], true));
			} else {
				sizeList.add(new JRadioButton(sizeNameList[i]));
			}
			sizeList.get(i).addItemListener(this);
			sizePanel.add(sizeList.get(i));
			sizeGroup.add(sizeList.get(i));
		}
		
		resultPanel = new JPanel();
		this.add(resultPanel, BorderLayout.SOUTH);
		
		orderButton = new JButton("주문");
		orderButton.addActionListener((e) -> {
			
		});
		resultPanel.add(orderButton);
		
		cancleButton = new JButton("취소");
		cancleButton.addActionListener((e) -> {
			
		});
		resultPanel.add(cancleButton);
		
		priceText = new JLabel(String.valueOf(price));
		resultPanel.add(priceText);
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new JavaPizza();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		for(int i=0; i<menuList.size(); i++) {
			if(e.getSource() == menuList.get(i)) {
				price -= menuPriceList[mRadioBtnPreChecked];
				price += menuPriceList[i];
				mRadioBtnPreChecked = i;
			}
		}
		
		for(int i=0; i<toppingList.size(); i++) {
			if(e.getSource() == toppingList.get(i)) {
				if(!isCeckBoxChecked[i]) {
					price += toppingPriceList[i];
					isCeckBoxChecked[i] = true;
				} else {
					price -= toppingPriceList[i];
					isCeckBoxChecked[i] = false;
				}
			}
		}
		
		for(int i=0; i<sizeList.size(); i++) {
			if(e.getSource() == sizeList.get(i)) {
				price -= sizePriceList[sRadioBtnPreChecked];
				price += sizePriceList[i];
				sRadioBtnPreChecked = i;
			}
		}
		
		priceText.setText(String.valueOf(price));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
