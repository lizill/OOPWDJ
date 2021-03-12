package codingwithscpark_ch12;

import java.awt.event.*;
import java.io.File;

import javax.swing.*;

public class FileChooserTest extends JFrame implements ActionListener {

	JButton openButton, saveButton;
	JFileChooser fc;
	JLabel openFile;
	
	public FileChooserTest() {
		setTitle("파일 선택기 테스트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 200);
		
		fc = new JFileChooser();
		
		JLabel label = new JLabel("파일 선택기 컴포넌트 테스트입니다.");
		openButton = new JButton("파일 오픈");
		openButton.addActionListener(this);
		
		saveButton = new JButton("파일 저장");
		saveButton.addActionListener(this);
		
		openFile = new JLabel();
		
		JPanel panel = new JPanel();
		panel.add(label);
		panel.add(openButton);
		panel.add(saveButton);
		panel.add(openFile);
		add(panel);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == openButton) {
			int returnVal = fc.showOpenDialog(this);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				openFile.setText(file.getPath() + "파일 열림");
			} else {
				
			}
		}
		
		if(e.getSource() == saveButton) {
			int returnVal = fc.showSaveDialog(this);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				openFile.setText(file.getPath() + "파일 저장됨");
			} else {
				
			}
		}
	}
	
	public static void main(String[] args) {
		new FileChooserTest();
	}
}
