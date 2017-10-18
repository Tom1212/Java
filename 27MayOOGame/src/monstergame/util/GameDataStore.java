/**
 * 
 */
package monstergame.util;

import monstergame.model.user.GameUser;
import monstergame.view.GameGUI;

/**
 * @author kinfmax
 *
 */
public class GameDataStore {
	
	private int level = 1;
	
	public static GameDataStore data = new GameDataStore();
	
	private GameGUI mainGUI = new GameGUI(); 
	
	public static boolean loginStatus = false;
	
	public static GameUser currentUser;
	
	private GameDataStore()
	{
		
	}
	
	public static GameDataStore getGDS()
	{
		return data;
	}

	public GameGUI getMainGUI() {
		return mainGUI;
	}
	
//	public GameGUI getNewMainGUI() {
//		return mainGUI = new GameGUI();
//	}
	
	public int getLevel()
	{
		return level;
	}
	
	public void setLevel(int l)
	{
		level = l;
	}

}
