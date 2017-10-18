/**
 * 
 */
package monstergame.view;

import javax.swing.JLabel;
import javax.swing.JPanel;

import monstergame.util.HTMLTabler;

/**
 * @author kinfmax
 *
 */
public class ScorePanel extends JPanel {
	
	public ScorePanel()
	{
		JLabel jt = new JLabel();
		
		HTMLTabler tablers = new HTMLTabler();
		
		tablers.addTH("Index|Name|Score");
		tablers.addTR("1|Kinfmax|100");
		tablers.addTR("2|John|99");
		String st = tablers.out();
		
		jt.setText(st);
		this.add(jt);
	}

}
