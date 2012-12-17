package it1537.ui.main;

import java.awt.CardLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ParentPanel extends JPanel {
	
	MainFrame parentFrame = null;
	
	public ParentPanel(MainFrame frame) {
		parentFrame = frame;
		setBounds(new Rectangle(0, 0, 800, 600));
		setLayout(null);
	}



	
}
