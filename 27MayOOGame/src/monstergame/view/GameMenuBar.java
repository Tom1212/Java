/**
 * 
 */
package monstergame.view;

import java.awt.MenuBar;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import monstergame.controller.MenuListener;

/**
 * @author kinfmax
 *
 */
public class GameMenuBar extends JMenuBar {
	
	private MenuListener mListener;
	private JMenu file;
	private JMenuItem exit;

	public GameMenuBar(MenuListener mListener) {
		super();
		this.mListener = mListener;
		
		
		file = new JMenu("File");
		exit = new JMenuItem("Exit");
		file.add(exit);
		
		exit.addActionListener(mListener);
		
		
		this.add(file);
		
		
		
	}

}
