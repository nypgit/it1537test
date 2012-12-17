package it1537.ui.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Rectangle;
import java.awt.CardLayout;

public class MainFrame extends JFrame {

	public static final String LOGINPANEL = "LOGIN";
	public static final String MAINPANEL = "MAIN";
	public static final String TABLEPANEL = "TABLE";
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					createAllPanels(frame);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	protected static void createAllPanels(MainFrame frame) {
		LoginPanel loginPanel = new LoginPanel(frame);
		frame.getContentPane().add(loginPanel, LOGINPANEL);
		MainPanel mainPanel = new MainPanel(frame);
		frame.getContentPane().add(mainPanel, MAINPANEL);
		TablePanel tablePanel = new TablePanel(frame);
		frame.getContentPane().add(tablePanel, TABLEPANEL);
		JPanel content = (JPanel)frame.getContentPane();
		CardLayout c1 = (CardLayout)frame.getContentPane().getLayout();
		c1.show(content, LOGINPANEL);
		
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setBounds(new Rectangle(0, 0, 800, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
	}

}
