package codingwithscpark_ch12;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TextFieldDemo extends JFrame implements ActionListener {

	private JPanel myPanel = new JPanel();
	private JLabel label1 = new JLabel("숫자 입력:");
	private JLabel label2 = new JLabel("제곱한 값:");
	private JTextField textField1 = new JTextField(20);
	private JTextField textField2 = new JTextField(20);
	private JButton button = new JButton("OK");
	
	public TextFieldDemo() {
		this.setSize(350, 130);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("텍스트 필드");
		
		textField2.setEditable(false);
		button.addActionListener(this);
		
		myPanel.add(label1);
		myPanel.add(textField1);
		myPanel.add(label2);
		myPanel.add(textField2);
		myPanel.add(button);
		this.add(myPanel, BorderLayout.CENTER);
		this.add(button, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new TextFieldDemo();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int n = Integer.parseInt(textField1.getText());
		textField2.setText(String.valueOf(n * n));
	}
}
