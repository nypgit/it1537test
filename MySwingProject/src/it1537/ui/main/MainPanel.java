package it1537.ui.main;

import java.awt.CardLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPanel extends JPanel {
	
	private  MainFrame parent = null;
	
	public MainPanel(MainFrame frame) {
		parent = frame;
		setBounds(new Rectangle(0, 0, 800, 600));
		setLayout(null);
		
		JLabel lblMainPanel = new JLabel("Main Panel");
		lblMainPanel.setBounds(99, 95, 125, 16);
		add(lblMainPanel);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel panel = (JPanel) parent.getContentPane();
				CardLayout cardLayout = (CardLayout) panel.getLayout();
				cardLayout.show(panel, MainFrame.LOGINPANEL);
				
			}
		});
		
		btnHome.setBounds(80, 147, 117, 29);
		add(btnHome);
		// TODO Auto-generated constructor stub
	}



	
}
