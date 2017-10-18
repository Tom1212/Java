/**
 * 
 */
package monstergame.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author kinfmax
 *
 */
public class MenuListener implements ActionListener {
	
	

	/**
	 * 
	 */
	public MenuListener() {
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("Exit"))
		{
			System.exit(0);
		}

	}

}
