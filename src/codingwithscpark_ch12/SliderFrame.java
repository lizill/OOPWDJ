package codingwithscpark_ch12;

import java.awt.Component;

import javax.swing.*;
import javax.swing.event.*;

public class SliderFrame extends JFrame implements ChangeListener {
	
	private JSlider slider;
	private JButton button;
	private final int INIT_VALUE = 15;

	public SliderFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("슬라이더");
		
		JPanel Panel = new JPanel();
		Panel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JLabel label = new JLabel("Frames Per Second", JLabel.CENTER);
		Panel.add(label);
		
		slider = new JSlider(0, 30, INIT_VALUE);
		slider.setMajorTickSpacing(10);
		slider.setMinorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.addChangeListener(this);
		Panel.add(slider);
		
		button = new JButton();
		ImageIcon icon = new ImageIcon("images/ship.png");
		button.setIcon(icon);
		button.setSize(INIT_VALUE * 4, INIT_VALUE * 7);
		Panel.add(button);
		this.add(Panel);

		this.setSize(300, 300);
		this.setVisible(true);
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider) e.getSource();
		if(!source.getValueIsAdjusting()) {
			int value = (int) source.getValue();
			button.setSize(value * 4, value * 7);
		}
	}
	
	public static void main(String[] args) {
		new SliderFrame();
	}
}