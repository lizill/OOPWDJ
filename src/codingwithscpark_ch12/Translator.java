package codingwithscpark_ch12;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class Translator extends JFrame {

	private JTextArea textInputArea;
	private JTextArea textOutputArea;
	private JButton outputButton;
	private JButton clearButton;
	
	public Translator() {
		this.setSize(600, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("파파고 번역기");

		PapagoAPI ppA = new PapagoAPI();
		
		JPanel textAreaPanel = new JPanel();
		textAreaPanel.setLayout(new GridLayout(1, 2 , 20, 0));
		
		textInputArea = new JTextArea(10, 30);
		textInputArea.setBorder(new LineBorder(Color.black));
		textInputArea.setLineWrap(true);
		textAreaPanel.add(textInputArea);
		
		textOutputArea = new JTextArea();
		textOutputArea.setBorder(new LineBorder(Color.black));
		textOutputArea.setEditable(false);
		textOutputArea.setLineWrap(true);
		textAreaPanel.add(textOutputArea);
		
		JPanel buttonPanel = new JPanel();
		
		outputButton = new JButton("번역하기");
		outputButton.addActionListener((e) -> {
			if(!textInputArea.getText().strip().isEmpty()) {
				ppA.setText(textInputArea.getText());
				textOutputArea.setText(ppA.getText().toString());
			}
		});
		buttonPanel.add(outputButton);
		
		clearButton = new JButton("지우기");
		clearButton.addActionListener((e) -> {
			textInputArea.setText("");
			textOutputArea.setText("");
		});
		buttonPanel.add(clearButton);
		
		this.add(buttonPanel, BorderLayout.SOUTH);
		this.add(textAreaPanel, BorderLayout.CENTER);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Translator();
	}

}
