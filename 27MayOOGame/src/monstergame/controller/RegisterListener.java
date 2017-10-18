package monstergame.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import monstergame.model.user.GameUser;
import monstergame.util.FileHandler;
import monstergame.view.RegisterWindow;

public class RegisterListener implements ActionListener {
	
	RegisterWindow registerWindow;

	public RegisterListener(RegisterWindow registerWindow) {
		this.registerWindow = registerWindow;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("Submit"))
		{
			String name = registerWindow.getNameText().getText();
			String address = registerWindow.getAddressText().getText();
			String username = registerWindow.getUsernameText().getText();
			String password = registerWindow.getPasswordText().getText();
			
			if (!name.equals("") && !address.equals("") && !username.equals("") && !password.equals(""))
			{
				FileHandler.save(new GameUser(name,address,username,password));
				
				this.registerWindow.dispose();
			}
			else
			{
				JOptionPane.showMessageDialog(this.registerWindow,
					    "All user field must be filled before submit.",
					    "Empty Field Detected!",
					    JOptionPane.ERROR_MESSAGE);
			}
			
			
		}else if (e.getActionCommand().equals("Cancel"))
		{
			this.registerWindow.dispose();
		}

	}

}
