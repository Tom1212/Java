/**
 * 
 */
package monstergame.view;

import javax.swing.JButton;
import javax.swing.JToolBar;

import monstergame.controller.ToolBarListener;

/**
 * @author kinfmax
 *
 */
public class GameToolBar extends JToolBar {
	
	private JButton login;
	private JButton register;
	private JButton newGame;
	private JButton reset;
	private JButton startPause;
	
	private ToolBarListener tListener;
	
	public GameToolBar()
	{
		this.tListener = new ToolBarListener(this);
		
		this.login = new JButton("Login");
		this.register = new JButton("Register");
		this.reset = new JButton("Reset");
		this.startPause = new JButton("Start");
		this.newGame = new JButton("New Game");
		
		this.login.addActionListener(tListener);
		this.register.addActionListener(tListener);
		this.reset.addActionListener(tListener);
		this.startPause.addActionListener(tListener);
		this.newGame.addActionListener(tListener);
		
		this.add(register);
		this.add(login);
		
		this.addSeparator();
		
		this.add(newGame);
		this.add(reset);
		this.add(startPause);
		
	}

	public JButton getLogin() {
		return login;
	}

	public JButton getRegister() {
		return register;
	}

}
