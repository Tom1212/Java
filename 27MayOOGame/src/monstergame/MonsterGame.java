/**
 * 
 */
package monstergame;

import javax.swing.JFrame;

import monstergame.util.GameDataStore;
import monstergame.view.GameGUI;

/**
 * @author kinfmax
 *
 */
public class MonsterGame {

	   public static void main(String args[]) throws Exception
	   {
	       GameGUI game = GameDataStore.data.getMainGUI();
	       game.setTitle("Monster Game");
	       game.setSize(1100,800);
	       game.setLocationRelativeTo(null);  // center the frame
	       game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       game.setVisible(true);
	       game.play(); 
	   }
	
}
