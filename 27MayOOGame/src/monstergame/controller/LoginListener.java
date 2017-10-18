package monstergame.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import monstergame.model.user.GameUser;
import monstergame.util.FileHandler;
import monstergame.util.GameDataStore;
import monstergame.view.LoginWindow;

public class LoginListener implements ActionListener {
	
	LoginWindow loginWindow;

	public LoginListener(LoginWindow loginWindow) {
		
		this.loginWindow = loginWindow;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("Login"))
		{
			String username = loginWindow.getUsernameText().getText();
			String password = loginWindow.getPasswordText().getText();
			
			ArrayList<GameUser> data = FileHandler.load();
			
			/*
			Iterator<GameUser> itr = data.values().iterator();
			boolean notLogin = true;
			while (itr.hasNext())
			{
				GameUser user = itr.next();
				if (user.getUsername().equals(username) && user.getPassword().equals(password))
				{
					GameDataStore.currentUser = user;
					notLogin = false;
					loginWindow.dispose();
				}
			}*/
			boolean notLogin = true;
			for (GameUser user : data)
			{
				if (user.getUsername().equals(username) && user.getPassword().equals(password))
				{
					GameDataStore.currentUser = user;
					notLogin = false;
					loginWindow.dispose();
				}
			}
			
			
			if (notLogin)
			{
				JOptionPane.showMessageDialog(this.loginWindow,
					    "Your username or password is incorrect!",
					    "Login Error",
					    JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				if (GameDataStore.currentUser != null)
				{
					GameDataStore.loginStatus = true;
					loginWindow.getToolBarListener().getBar().getLogin().setText("Logout");
					
					loginWindow.getToolBarListener().getBar().getRegister().setEnabled(false);
					loginWindow.getToolBarListener().getBar().getRegister().setText("CurrentPlayer: " + GameDataStore.currentUser.getUsername());
					
//					UserPanel user = GameDataStore.getGDS().getMainGUI().getUser();
//					//here is also can be created as new.
//					GameDataStore.getGDS().getMainGUI().getTabbedPane().add("UserDetail", user);
//					GameDataStore.getGDS().getMainGUI().getTabbedPane().setSelectedIndex(2);
//					user.refresh();
				}
			}
			
		}else if (e.getActionCommand().equals("Cancel"))
		{
			loginWindow.dispose();
		}

	}

}
