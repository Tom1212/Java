package monstergame.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;

import monstergame.model.*;
import monstergame.util.GameDataStore;

public class BoardPanelListener implements ActionListener  {
	
	private Player player;
	private Trap trap;
	private Gold gold;
	private Roadblock roadblock;
	
	public BoardPanelListener(Player player, Trap trap, Gold gold, Roadblock roadblock)
	{
		this.player = player;
		this.trap = trap;
		this.gold = gold;
		this.roadblock = roadblock;
	}

	@Override
	/* responds to various button clicked messages */
	public void actionPerformed(ActionEvent e) {
		
		if (((JButton) e.getSource()).getText().compareTo("up") == 0 && gold.getGoldCount()>1){
			player.setDirection('U');
			gold.setGold(-2);
		}
			
		else if (((JButton) e.getSource()).getText().compareTo("down") == 0 && gold.getGoldCount()>1){
			player.setDirection('D');
			gold.setGold(-2);
		}
		else if (((JButton) e.getSource()).getText().compareTo("left") == 0 && gold.getGoldCount()>1){
			player.setDirection('L');
			gold.setGold(-2);
		}
		else if (((JButton) e.getSource()).getText().compareTo("right") == 0 && gold.getGoldCount()>1){
			player.setDirection('R');
			gold.setGold(-2);
		}
		else if (((JButton) e.getSource()).getText().compareTo("setTrap") == 0 && !trap.isSet() && gold.getGoldCount()>50){
			trap.set(true);
			trap.setTime(10);
			gold.setGold(-50);
		}
		else if (((JButton) e.getSource()).getText().compareTo("setRoadblock") == 0 && !roadblock.isSet() && roadblock.countRoadblock>0){
			roadblock.set(true);
			roadblock.setTime(5);
			roadblock.countRoadblock--;
		}
		else if (((JButton) e.getSource()).getText().compareTo("escape") == 0 && player.getEscape()>0 && !player.getIsEscape()){
			player.setEscape();
			player.setIsEscape(true);
		}
		else if (((JButton) e.getSource()).getText().compareTo("start") == 0)
			player.setReady(true);
	}

}
