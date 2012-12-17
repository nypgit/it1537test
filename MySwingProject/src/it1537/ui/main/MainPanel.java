package it1537.ui.main;

import java.awt.CardLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPanel extends ParentPanel {
	
	
	
	public MainPanel(MainFrame frame) {
		super(frame);
		
		JLabel lblMainPanel = new JLabel("Main Panel");
		lblMainPanel.setBounds(99, 95, 125, 16);
		add(lblMainPanel);
		
		JButton btnHome = new JButton("Back");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel panel = (JPanel) parentFrame.getContentPane();
				CardLayout cardLayout = (CardLayout) panel.getLayout();
				cardLayout.show(panel, MainFrame.LOGINPANEL);
				
			}
		});
		
		btnHome.setBounds(80, 147, 117, 29);
		add(btnHome);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPanel panel = (JPanel) parentFrame.getContentPane();
				CardLayout cardLayout = (CardLayout) panel.getLayout();
				cardLayout.show(panel, MainFrame.TABLEPANEL);
			}
		});
		btnNext.setBounds(206, 147, 117, 29);
		add(btnNext);
		
	}



	
}
