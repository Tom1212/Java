package monstergame.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

import monstergame.controller.SelectLevelListener;
import monstergame.util.GameDataStore;

public class LevelPanel extends JFrame {
	
	private ButtonGroup levels;
	private JRadioButton l1;
	private JRadioButton l2;
	private JRadioButton l3;
	private JRadioButton l4;
	private SelectLevelListener sll;
	private JButton ok;
	
	public LevelPanel()
	{
		levels = new ButtonGroup();
		l1 = new JRadioButton("Basic Monster");
		l2 = new JRadioButton("Smart Monster");
		l3 = new JRadioButton("Jumping Monster");
		l4 = new JRadioButton("Productive Monster");
		ok = new JButton("OK");
		
		sll = new SelectLevelListener(this);
		
		l1.setActionCommand("basic");
		l2.setActionCommand("smart");
		l3.setActionCommand("jumping");
		l4.setActionCommand("productive");
		
		l1.addActionListener(sll);
		l2.addActionListener(sll);
		l3.addActionListener(sll);
		l4.addActionListener(sll);
		ok.addActionListener(sll);
		
		levels.add(l1);
		levels.add(l2);
		levels.add(l3);
		levels.add(l4);
		
		this.getContentPane().add(l1);
		this.getContentPane().add(l2);
		this.getContentPane().add(l3);
		this.getContentPane().add(l4);
		this.getContentPane().add(ok);
		
		this.setLayout(new GridLayout(5,1));
		
		this.setSize(200, 120);
		
		setCurrentSelection();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		
	}
	
	public void setCurrentSelection()
	{
		int level = GameDataStore.getGDS().getLevel();
		BoardPanel bp = GameDataStore.getGDS().getMainGUI().getBp();
		switch (level)
		{
		case 1:	{l1.setSelected(true); bp.setBannerMessage("Basic Monster - Press ENTER to start game -"); break;}
		case 2:	{l2.setSelected(true); bp.setBannerMessage("Smart Monster - Press ENTER to start game -"); break;}
		case 3:	{l3.setSelected(true); bp.setBannerMessage("Jumping Monster - Press ENTER to start game -"); break;}
		case 4:	{l4.setSelected(true); bp.setBannerMessage("Productive Monster - Press ENTER to start game -"); break;}
		}
	}
	

}
