/**
 * 
 */
package monstergame.view;

import java.util.Hashtable;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JPanel;

import monstergame.model.user.GameUser;
import monstergame.util.FileHandler;
import monstergame.util.GameDataStore;
import monstergame.util.HTMLTabler;

/**
 * @author kinfmax
 *
 */
public class UserPanel extends JPanel {
	
	private JLabel jt;
	
	public UserPanel()
	{
		JLabel jt = new JLabel();
		
		this.add(jt);
	}
	
	public void refresh()
	{
		GameUser user = GameDataStore.currentUser;
		
		HTMLTabler tablers = new HTMLTabler();
		if (user != null)
		{
			tablers.addTH("Title|Content");
			tablers.addTR("Name:|"+user.getName());
			tablers.addTR("Address:|"+user.getAddress());
			tablers.addTR("Username:|"+user.getUsername());
			tablers.addTR("Password:|"+user.getPassword());
		}
		
		String st = tablers.out();
		
		jt.setText(st);
		this.validate();
	}

}
