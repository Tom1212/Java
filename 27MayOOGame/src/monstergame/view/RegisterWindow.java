package monstergame.view;

import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import monstergame.controller.RegisterListener;

public class RegisterWindow extends JFrame {
	
	private JLabel name;
	private JLabel address;
	private JLabel username;
	private JLabel password;
	
	private JTextField nameText;
	private JTextField addressText;
	private JTextField usernameText;
	private JTextField passwordText;
	
	private JButton submit;
	private JButton cancel;
	

	public RegisterWindow() {
		super();
		
		name = new JLabel("Name:");
		address = new JLabel("Address:");
		username = new JLabel("Username:");
		password = new JLabel("Password:");
		
		nameText = new JTextField(15);
		addressText = new JTextField(15);
		usernameText = new JTextField(15);
		passwordText = new JTextField(15);
		
		submit = new JButton("Submit");
		cancel = new JButton("Cancel");
		
		submit.addActionListener(new RegisterListener(this));// RegisterListener is for controlling the whole window, Also the actionListener
															 // is for controlling the button. They are associated and work together.
		cancel.addActionListener(new RegisterListener(this));
		
		this.add(name);
		this.add(nameText);
		this.add(address);
		this.add(addressText);
		this.add(username);
		this.add(usernameText);
		this.add(password);
		this.add(passwordText);
		
		this.add(submit);
		this.add(cancel);
		
		this.setLayout(new GridLayout(5,2));
		this.setTitle("Player registeration");
		this.setSize(250, 200);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}


	public JTextField getNameText() {
		return nameText;
	}


	public void setNameText(JTextField nameText) {
		this.nameText = nameText;
	}


	public JTextField getAddressText() {
		return addressText;
	}


	public void setAddressText(JTextField addressText) {
		this.addressText = addressText;
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


	public JButton getSubmit() {
		return submit;
	}


	public void setSubmit(JButton submit) {
		this.submit = submit;
	}

	

}
