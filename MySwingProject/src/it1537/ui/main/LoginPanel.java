package it1537.ui.main;

import it1537.dao.MemberDAO;
import it1537.entities.Member;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.Rectangle;

public class LoginPanel extends JPanel implements ActionListener {
	private JTextField textField;
	private JPasswordField passwordField;
	private ImageIcon imageIcon;
	private JLabel errorMessage;
	private JFrame parentFrame; 

	/**
	 * Create the panel.
	 */
	public LoginPanel(JFrame frame) {
		setBounds(new Rectangle(0, 0, 800, 600));
		
		parentFrame = frame;
		
		try
		{
		 imageIcon = new ImageIcon( "image/winter3.jpg" );
		}
		catch(Exception e){
			
		}
	
		setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(196, 105, 43, 16);
		add(lblLogin);
		
		textField = new JTextField();
		textField.setBounds(196, 145, 126, 28);
		add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(196, 185, 126, 28);
		add(passwordField);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblUsername.setBounds(108, 151, 76, 16);
		add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblPassword.setBounds(108, 191, 76, 16);
		add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		
		btnLogin.addActionListener(this);
		
		btnLogin.setBounds(186, 225, 117, 29);
		add(btnLogin);
		
		errorMessage = new JLabel("");
		errorMessage.setBounds(97, 35, 225, 16);
		add(errorMessage);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String username = textField.getText();
		String password = new String(passwordField.getPassword());
		System.out.println("username="+username + ",password=" + password);
		// check login 
		boolean allowed = checkLogin(username,password);
		if (allowed) {
			JPanel panel = (JPanel) parentFrame.getContentPane();
			CardLayout c1 = (CardLayout)parentFrame.getContentPane().getLayout();
			c1.show(panel, MainFrame.MAINPANEL);
		}
		else {
			errorMessage.setText("LoginFailed");
		}
	}

	private boolean checkLogin(String username, String password) {
		// use memberDao to retrieve username and password
		Member member = MemberDAO.searchByUsername(username);
		if (member != null) {
			String pwd = member.getPassword();
			if (pwd.equals(password)) 
				return true;
		
		} 
		return false;
	}
	
	/*public void paintComponent(Graphics g)
	{
		Dimension d = getSize();
		for( int x = 0; x < d.width; x += imageIcon.getIconWidth() )
		for( int y = 0; y < d.height; y += imageIcon.getIconHeight() ) 
		g.drawImage( imageIcon.getImage(), x, y, null, null );
		super.paint(g);
	}*/
	
}
