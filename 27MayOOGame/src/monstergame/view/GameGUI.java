package monstergame.view;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;

import javax.swing.*;

import monstergame.controller.BoardPanelListener;
import monstergame.controller.GameKeyController;
import monstergame.controller.MenuListener;
import monstergame.controller.ToolBarListener;
import monstergame.model.*;/*
import monstergame.util.GameDataStore;

import java.awt.*;

/* This class is the main System level class which creates all the objects 
 * representing the game logic (model) and the panel for user interaction. 
 * It also implements the main game loop 
 */
import monstergame.util.GameDataStore;

public class GameGUI extends JFrame {

	private final int TIMEALLOWED = 100;

	private JButton up = new JButton("up");
	private JButton down = new JButton("down");
	private JButton left = new JButton("left");
	private JButton right = new JButton("right");
	private JButton setTrap = new JButton("setTrap");
	private JButton escape = new JButton("escape");
	private JButton setRoadblock = new JButton("setRoadblock");
	private JButton start = new JButton("start");
	private JLabel mLabel = new JLabel("Time Remaining : " + TIMEALLOWED);
	private JLabel mLabel2 = new JLabel("Calories : 60");
	
	//use this label to display player energy level TOM
//	private JLabel enegryLevelLText = new JLabel("Energy: 40");
	
	private JLabel mLabel3 = new JLabel("Escape : 3");
	private JLabel mLabel4 = new JLabel("Roadblock : 3");

	private Grid grid;
	//private Player player;
	private Player player;
	private Monster monster;
	private Gold gold;
	private Trap trap;
	private Roadblock roadblock;
	private int i;
	private JTabbedPane tabbedPane;
	private BoardPanel bp;
	private ScorePanel score;
	private UserPanel user;
	private GameMenuBar menu;
	private GameToolBar toolbar;

	/*
	 * This constructor creates the main model objects and the panel used for
	 * UI. It throws an exception if an attempt is made to place the player or
	 * the monster in an invalid location.
	 */
	public GameGUI() {
		grid = new Grid();
		try {
			
			//player = new Player(grid, 0, 0);
			
			player = new FastPlayer(grid, 0, 0);
			
			monster = new Monster(grid, player, 10, 10);
			
			//monster = new SmartMonster(grid, player, 10, 10);
			
			//monster = new JumpingMonster(grid, player, 10, 10);
			
			
			
			
//			int level = GameDataStore.getGDS().getLevel();
//			Monster monster = null;
//				switch (level)
//				{
//				case 1:	{monster = new Monster(grid, player, 10, 10);break;}
//				case 2:	{monster = new SmartMonster(grid, player, 10, 10); break;}
//				case 3:	{monster = new JumpingMonster(grid, player, 10, 10); break;}
//				case 4:	{monster = new ProducvtiveMonster(grid, player, 10, 10); break;}
//				}
			
			
			
			//test for distribute gold;
			gold = new Gold(grid, player, 1, 0);
			trap = new Trap(grid, player, 2, 0);
			roadblock = new Roadblock(grid, player, 1, 0);

			/*while(k<57){
			for(int i = 0; i<=10; i++){
				if(i%5==0){
					for(int j=0; j<=10; j++){
						gold = new Gold(grid, player, i, j);
						k++;
					}
				}
				else{
					for(int j=0; j<=10; j+=5){
						gold = new Gold(grid, player, i, j);
						k++;
					}
				}
			}
		}*/	
			//if x%5==0 then 0<y<10
			//if x%5!=0 then y=0 || y=5 || y=10
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		bp = new BoardPanel(grid, player, monster, gold, trap, roadblock);
		
		
		

		score = new ScorePanel();

		user = new UserPanel();

		// create menu listener;
		MenuListener mListener = new MenuListener();
		
		
		
		
		
		menu = new GameMenuBar(mListener);
		toolbar = new GameToolBar();

		// Create a separate panel and add all the buttons
		JPanel panel = new JPanel();
		panel.add(up);
		panel.add(down);
		panel.add(left);
		panel.add(right);
		panel.add(setTrap);
		panel.add(escape);
		panel.add(setRoadblock);
		panel.add(start);
		panel.add(mLabel);
		
//		panel.add(enegryLevelLText);
		panel.add(mLabel2);
		panel.add(mLabel3);

		// create Action listener for all buttons
		BoardPanelListener bpListener = new BoardPanelListener(player, trap, gold, roadblock);
		
		
		// add Action listeners to all button events
		up.addActionListener(bpListener);
		down.addActionListener(bpListener);
		left.addActionListener(bpListener);
		right.addActionListener(bpListener);
		setTrap.addActionListener(bpListener);
		setRoadblock.addActionListener(bpListener);
		escape.addActionListener(bpListener);
		start.addActionListener(bpListener);
		
		

		// add panels to frame
		this.setJMenuBar(menu);
		

		// setup tabbed panel

		tabbedPane = new JTabbedPane();

		tabbedPane.addTab("Game", bp);

		tabbedPane.addTab("Score", score);


		add(toolbar, BorderLayout.NORTH);
		add(this.tabbedPane, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		
		
		
		InputMap im = panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap am = panel.getActionMap();
		
		this.impKeyAction(im, am, KeyEvent.VK_ENTER, "start");
		this.impKeyAction(im, am, KeyEvent.VK_UP, "up");
		this.impKeyAction(im, am, KeyEvent.VK_DOWN, "down");
		this.impKeyAction(im, am, KeyEvent.VK_LEFT, "left");
		this.impKeyAction(im, am, KeyEvent.VK_RIGHT, "right");
		
		this.impKeyAction(im, am, KeyEvent.VK_E, "escape");  // use E key to trigger Escape
		this.impKeyAction(im, am, KeyEvent.VK_R, "roadblock"); // use R key to trigger set roadblock action
		this.impKeyAction(im, am, KeyEvent.VK_T, "settrap"); // use T to set a trap
		
	}
	
	public void impKeyAction(InputMap im, ActionMap am, int keyStroke, String key)
	{
		im.put(KeyStroke.getKeyStroke(keyStroke,0), key);
		am.put(key, new GameKeyController(key, grid, player,gold,trap,roadblock));
	}

	// method to delay by specified time in ms
	public void delay(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/*
	 * This method waits until play is ready (until start button is pressed)
	 * after which it updates the moves in turn until time runs out (player won)
	 * or player is eaten up (player lost).
	 */
	public String play() throws Exception {
		int time = 0;
		String message;
		player.setDirection(' '); // set to no direction
		while (!player.isReady())
			delay(200);
		do {
			bp.hideBanner(); // hide the banner
			
			mLabel2.setText("Calories : " + (gold.getGoldCount()));
			//TOM
//			enegryLevelLText.setText("Energy: " + player.getCalories());
			
			Cell newPlayerCell = player.move();
			if (newPlayerCell == monster.getCell())
				break;
			player.setDirection(' '); // reset to no direction

			Cell newMonsterCell = monster.move();
			if (newMonsterCell == player.getCell())
				break;
			
			if(newPlayerCell == gold.getCell()){
				gold.setEaten(true);
				gold.setGold(6);
				mLabel2.setText("GOLD : " + (gold.getGoldCount()));
				//TOM
//				enegryLevelLText.setText("Energy: " + player.getCalories());
				
				if(i < 10){
					i++;
					gold.setEaten(false);
					gold.setCell(grid.getCell(i,0));
				}
				else{
					i = 0;
					gold.setEaten(false);
					gold.setCell(grid.getCell(i,0));
				}
				
			}
			if(trap.getTime()>9)
				trap.setCell(player.getCell());
			if(trap.isSet())
				trap.setTime(-1);
			if(trap.getTime()<1)
				trap.set(false);
			if(trap.getCell() == monster.getCell()){
				monster.setDirection(' ');
			}
			if(player.getIsEscape()){
				player.setCell(grid.getCell(0,0));
				player.setIsEscape(false);
			}
			
			if(roadblock.getTime()==5)
				roadblock.setCell(player.getCell());
			if(roadblock.getTime()>4)
				roadblock.setTime(-1);
			if(roadblock.isSet() && monster.getCell()==roadblock.getCell())
				roadblock.setTime(-1);
			if(roadblock.getTime()<1)
				roadblock.set(false);
			
			
			mLabel3.setText("Escape : " + (player.getEscape()));
			
			
			// update time and repaint
			time++;
			mLabel.setText("Time Remaining : " + (TIMEALLOWED - time));
			delay(1000);
			bp.repaint();

		} while (time < TIMEALLOWED);

		if (time < TIMEALLOWED) // players has been eaten up
			message = "Player Lost";
		else
			message = "Player Won";

		mLabel.setText(message);

		// bp.showBanner();
		// player.setReady(false);
		// play();

		return message;
	}

	public int getTIMEALLOWED() {
		return TIMEALLOWED;
	}

	public JButton getUp() {
		return up;
	}

	public JButton getDown() {
		return down;
	}

	public JButton getLeft() {
		return left;
	}

	public JButton getRight() {
		return right;
	}

	public JButton getStart() {
		return start;
	}

	public JLabel getmLabel() {
		return mLabel;
	}

	public Grid getGrid() {
		return grid;
	}

	public Player getPlayer() {
		return player;
	}

	public Monster getMonster() {
		return monster;
	}

	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	public BoardPanel getBp() {
		return bp;
	}

	public ScorePanel getScore() {
		return score;
	}

	public UserPanel getUser() {
		return user;
	}

	public GameMenuBar getMenu() {
		return menu;
	}

	public GameToolBar getToolbar() {
		return toolbar;
	}

}
