package monstergame.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Icon;

import monstergame.model.Gold;
import monstergame.model.Grid;
import monstergame.model.Monster;
import monstergame.model.Player;
import monstergame.model.Roadblock;
import monstergame.model.Trap;
import monstergame.util.GameDataStore;

public class GameKeyController extends AbstractAction {
	
	private String key;
	private Player player;
	private Grid grid;
	private Monster monster;
	private Trap trap;
	private Roadblock roadblock;
	private Gold gold;
	
	public GameKeyController(String key, Player player)
	{
		this.key = key;
		this.player = player;
	}
	
	public GameKeyController(String key, Grid grid, Player player, Gold gold, Trap trap, Roadblock roadblock)
	{
		this.key = key;
		this.player = player;
		this.grid = grid;
		this.trap = trap;
		this.roadblock = roadblock;
		this.gold = gold;
	}


	@Override
	public void actionPerformed(ActionEvent e) {	
		
		GameDataStore.getGDS().getMainGUI().requestFocus();
		
		if (key.equals("start"))
			player.setReady(true);
		else if (key.equals("up") && gold.getGoldCount()>1)
		{
			player.setDirection('U');
			gold.setGold(-2);
		}
		else if (key.equals("down") && gold.getGoldCount()>1)
		{
			player.setDirection('D');
			gold.setGold(-2);
		}
		else if (key.equals("left") && gold.getGoldCount()>1)
		{
			player.setDirection('L');
			gold.setGold(-2);
		}
		else if (key.equals("right") && gold.getGoldCount()>1)
		{
			player.setDirection('R');
			gold.setGold(-2);
		}
		else if (key.equals("roadblock") && !roadblock.isSet() && roadblock.countRoadblock>0)
		{
			roadblock.set(true);
			roadblock.setTime(5);
			roadblock.countRoadblock--;
		}
		else if (key.equals("settrap") && !trap.isSet() && gold.getGoldCount()>50)
		{
			trap.set(true);
			trap.setTime(10);
			gold.setGold(-50);
		}
		else if (key.equals("escape") && player.getEscape()>0 && !player.getIsEscape())
		{
			player.setEscape();
			player.setIsEscape(true);
		}
	}

}
