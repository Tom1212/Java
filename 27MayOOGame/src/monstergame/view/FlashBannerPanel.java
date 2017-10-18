/**
 * 
 */
package monstergame.view;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author kinfmax
 *
 */
public class FlashBannerPanel extends JPanel {
	
	private JLabel message = new JLabel("Please click \"New Game\" button");

	public FlashBannerPanel()
	{
		this.setLayout(new FlowLayout());
		this.add(message);
	}
	
	public void hide()
	{
		message.setVisible(false);
	}
	
	public void show()
	{
		message.setVisible(true);
	}
	
	public void setMessage(String msg)
	{
		message.setText(msg);
		this.validate();
	}
	
}
