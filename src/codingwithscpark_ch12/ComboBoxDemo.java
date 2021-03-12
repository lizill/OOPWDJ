package codingwithscpark_ch12;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;

public class ComboBoxDemo extends JFrame implements ActionListener {

	JLabel label;
	String[] fruits = {"apple", "grape", "orange"};
	JComboBox<String> fruitList = new JComboBox<>(fruits);
	
	public ComboBoxDemo() {
		this.setTitle("콤보 박스");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(210, 260);
		fruitList.setSelectedIndex(0);
		fruitList.addActionListener(this);
		fruitList.setEditable(true);
		
		label = new JLabel();
		label.setHorizontalAlignment(JLabel.CENTER);
		changeImage(fruits[fruitList.getSelectedIndex()]);
		
		this.add(fruitList, BorderLayout.PAGE_START);
		this.add(label, BorderLayout.PAGE_END);
		this.setVisible(true);
	}
	
	protected void changeImage(String name) {
		File file = new File("images/" + name + ".gif");
		ImageIcon icon = new ImageIcon(file.getPath());
		label.setIcon(icon);
		if(!file.isFile()) {
			System.out.println("이미지가 없습니다.");
			fruitList.addItem(name);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox<Object> cb = (JComboBox) e.getSource();
		String name = (String) cb.getSelectedItem();
		changeImage(name);
	}
	
	public static void main(String[] args) {
		new ComboBoxDemo();
	}
}
