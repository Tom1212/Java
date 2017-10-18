package monstergame.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import monstergame.util.GameDataStore;
import monstergame.view.BoardPanel;
import monstergame.view.LevelPanel;

public class SelectLevelListener implements ActionListener {
	
	private LevelPanel lp;
	
	public SelectLevelListener(LevelPanel lp)
	{
		this.lp = lp;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("basic"))
		{
			GameDataStore.getGDS().setLevel(1);
		} else if (e.getActionCommand().equals("smart"))
		{
			GameDataStore.getGDS().setLevel(2);
		} else if (e.getActionCommand().equals("jumping"))
		{
			GameDataStore.getGDS().setLevel(3);
		} else if (e.getActionCommand().equals("productive"))
		{
			GameDataStore.getGDS().setLevel(4);
		} else if (e.getActionCommand().equals("OK"))
		{
			lp.dispose();
		}
		
		setCurrentSelection();
		GameDataStore.getGDS().getMainGUI().validate();
//		GameDataStore.getGDS().getMainGUI().rebuild();
		
	}
	
	public void setCurrentSelection()
	{
		int level = GameDataStore.getGDS().getLevel();
		BoardPanel bp = GameDataStore.getGDS().getMainGUI().getBp();
		switch (level)
		{
		case 1:	{bp.setBannerMessage("Basic Monster - Press ENTER to start game -"); break;}
		case 2:	{bp.setBannerMessage("Smart Monster - Press ENTER to start game -"); break;}
		case 3:	{bp.setBannerMessage("Jumping Monster - Press ENTER to start game -"); break;}
		case 4:	{bp.setBannerMessage("Productive Monster - Press ENTER to start game -"); break;}
		}
	}

}
