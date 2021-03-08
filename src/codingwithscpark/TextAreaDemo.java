package codingwithscpark;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TextAreaDemo extends JFrame implements ActionListener {

	private JTextField textField = new JTextField(30);
	private JTextArea textArea = new JTextArea(10, 30);
	private JScrollPane scrollPane = new JScrollPane(textArea);
	
	public TextAreaDemo() {
		this.setSize(500, 300);
		this.setTitle("textArea, scrollPane");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textField.addActionListener(this);
		
		this.add(textField, BorderLayout.NORTH);
//		this.add(textArea, BorderLayout.CENTER);
		this.add(scrollPane, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new TextAreaDemo();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String str = textField.getText();
		textArea.setText(textArea.getText() + "\n" + str);
		textField.setText(null);
	}
}
