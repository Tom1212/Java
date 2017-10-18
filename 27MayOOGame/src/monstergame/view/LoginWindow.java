package monstergame.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import monstergame.controller.LoginListener;
import monstergame.controller.ToolBarListener;

public class LoginWindow extends JFrame {
	
	private JLabel username;
	private JLabel password;
	
	private JTextField usernameText;
	private JTextField passwordText;
	
	private JButton login;
	private JButton cancel;
	
	private ToolBarListener toolBarListener;
	
	public LoginWindow(ToolBarListener toolBarListener)
	{
		this.toolBarListener = toolBarListener;
		username = new JLabel("Username: ");
		password = new JLabel("Password: ");
		
		usernameText = new JTextField(15);
		passwordText = new JTextField(15);
		
		login = new JButton("Login");
		cancel = new JButton("Cancel");
		
		login.addActionListener(new LoginListener(this));
		cancel.addActionListener(new LoginListener(this));
		
		this.add(username);
		this.add(usernameText);
		this.add(password);
		this.add(passwordText);
		this.add(login);
		this.add(cancel);
		
		this.setLayout(new GridLayout(3,2));
		this.setTitle("Player login:");
		this.setSize(250, 200);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public JTextField getUsernameText() {
		return usernameText;
	}

	public void setUsernameText(JTextField usernameText) {
		this.usernameText = usernameText;
	}

	public JTextField getPasswordText() {
		return passwordText;
	}

	public void setPasswordText(JTextField passwordText) {
		this.passwordText = passwordText;
	}

	public ToolBarListener getToolBarListener() {
		return toolBarListener;
	}
	
	

}
