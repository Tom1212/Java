/**
 * 
 */
package monstergame.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.Iterator;

import javax.swing.JButton;

import monstergame.model.user.GameUser;
import monstergame.util.FileHandler;
import monstergame.util.GameDataStore;
import monstergame.view.GameToolBar;
import monstergame.view.LevelPanel;
import monstergame.view.LoginWindow;
import monstergame.view.RegisterWindow;
import monstergame.view.UserPanel;

/**
 * @author kinfmax
 *
 */
public class ToolBarListener implements ActionListener {
	
	private GameToolBar bar;
	
	public ToolBarListener(GameToolBar bar)
	{
		this.bar = bar;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Login"))
		{
			new LoginWindow(this);
		}
		else if (e.getActionCommand().equals("Logout"))
		{
			GameDataStore.currentUser = null;
			GameDataStore.loginStatus = false;
			JButton button = (JButton) e.getSource();
			button.setText("Login");
			bar.getRegister().setEnabled(true);
			bar.getRegister().setText("Register");
//			GameDataStore.getGDS().getMainGUI().getTabbedPane().removeTabAt(2);
		}
		else if (e.getActionCommand().equals("Register"))
		{
			new RegisterWindow();
		}
		else if (e.getActionCommand().equals("New Game"))
		{
			new LevelPanel();
		}
	}
	
	public GameToolBar getBar()
	{
		return bar;
	}

}
