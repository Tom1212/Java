package monstergame.view;

import java.awt.event.*;

import javax.swing.*;

import monstergame.model.*;
import monstergame.util.GameDataStore;


/*
import monstergame.model.Grid;
import monstergame.model.Monster;
import monstergame.model.Player;
import monstergame.model.Gold;
import monstergame.model.Trap;
*/
import java.awt.*;

/* This panel represents the game board (grid) 
 * It also responds to game related events
 * The overridden paintcompnent() is called whenever the board
 * or the pieces needs to be updated 
 */
public class BoardPanel extends JPanel {

	private Player player;
	private Monster monster;
	private Gold gold;
	private Grid grid;
	private Trap trap;
	private Roadblock roadblock;
	private Graphics gr;
	private GameGUI game;
	private final int CELLWIDTH = 40;
	private final int CELLHEIGHT = 40;
	private final int LMARGIN = 300;
	private final int TMARGIN = 100;
	
	private FlashBannerPanel banner = new FlashBannerPanel();

	public BoardPanel(Grid g, Player p, Monster m, Gold gd, Trap t, Roadblock r) {
		player = p;
		gold = gd;
		grid = g;
		trap = t;
		monster = m;
		roadblock =r;
//		try {
//			int level = GameDataStore.getGDS().getLevel();
//			Monster monster = null;
//				switch (level)
//				{
//				case 1:	{m = new Monster(grid, player, 10, 10);break;}
//				case 2:	{m = new SmartMonster(grid, player, 10, 10); break;}
//				case 3:	{m = new JumpingMonster(grid, player, 10, 10); break;}
//				case 4:	{m = new ProducvtiveMonster(grid, player, 10, 10); break;}
//				}
//		}catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		
		
		
		gr = this.getGraphics();
		
		this.setLayout(new BorderLayout());
		this.add(banner, BorderLayout.SOUTH);
	}

	/* returns the x coordinate based on left margin and cell width */
	private int xCor(int col) {
		return LMARGIN + col * CELLWIDTH;
	}

	/* returns the y coordinate based on top margin and cell height */
	private int yCor(int row) {
		return TMARGIN + row * CELLHEIGHT;
	}

	/*
	 * Redraws the board and the pieces Called initially and in response to
	 * repaint()
	 */
	protected void paintComponent(Graphics gr) {
		super.paintComponent(gr);
		Cell cells[] = grid.getAllCells();
		Cell cell;
		for (int i = 0; i < cells.length; i++) {
			cell = cells[i];
			if (cell.getCol() % 5 == 0 && cell.getRow() % 5 == 0)
				gr.setColor(Color.cyan);
			else
				gr.setColor(Color.white);
			gr.fillRect(xCor(cell.getCol()), yCor(cell.getRow()), CELLWIDTH,
					CELLHEIGHT);
			gr.setColor(Color.black);
			gr.drawRect(xCor(cell.getCol()), yCor(cell.getRow()), CELLWIDTH,
					CELLHEIGHT);
		}
		cell = player.getCell();
		gr.setColor(Color.red);
		gr.fillOval(xCor(cell.getCol()) + CELLWIDTH / 8, yCor(cell.getRow())
				+ CELLWIDTH / 8, CELLWIDTH * 3 / 4, CELLHEIGHT * 3 / 4);
		gr.setColor(Color.white);
		gr.drawString("P", xCor(cell.getCol()) + CELLWIDTH / 3,
				yCor(cell.getRow()) + 2 * CELLWIDTH / 3);

		if (monster.viewable()) {
			cell = monster.getCell();
			gr.setColor(Color.black);
			gr.fillRect(xCor(cell.getCol()), yCor(cell.getRow()), CELLWIDTH,
					CELLHEIGHT);
			gr.setColor(Color.white);
			gr.drawString("M", xCor(cell.getCol()) + CELLWIDTH / 3,
					yCor(cell.getRow()) + 2 * CELLWIDTH / 3);
		}
		if(!gold.isEaten()){
			cell = gold.getCell();
			gr.setColor(Color.yellow);
			gr.fillOval(xCor(cell.getCol()) + CELLWIDTH / 8, yCor(cell.getRow())
					+ CELLWIDTH / 8, CELLWIDTH * 3 / 4, CELLHEIGHT * 3 / 4);
			gr.setColor(Color.black);
			gr.drawString("G", xCor(cell.getCol()) + CELLWIDTH / 3,
						yCor(cell.getRow()) + 2 * CELLWIDTH / 3);
			}

		if(trap.isSet() && trap.getTime()>0){
			cell = trap.getCell();
			gr.setColor(Color.black);
			gr.fillOval(xCor(cell.getCol()) + CELLWIDTH / 8, yCor(cell.getRow())
					+ CELLWIDTH / 8, CELLWIDTH * 3 / 4, CELLHEIGHT * 3 / 4);
			gr.setColor(Color.red);
			gr.drawString(String.valueOf(trap.getTime()), xCor(cell.getCol()) + CELLWIDTH / 3,
					yCor(cell.getRow()) + 2 * CELLWIDTH / 3);
		}
		if(roadblock.isSet() && roadblock.getTime()>0){
			cell = roadblock.getCell();
			gr.setColor(Color.black);
			gr.fillOval(xCor(cell.getCol()) + CELLWIDTH / 8, yCor(cell.getRow())
					+ CELLWIDTH / 8, CELLWIDTH * 3 / 4, CELLHEIGHT * 3 / 4);
			gr.setColor(Color.red);
			gr.drawString(String.valueOf(roadblock.getTime()), xCor(cell.getCol()) + CELLWIDTH / 3,
					yCor(cell.getRow()) + 2 * CELLWIDTH / 3);
		}
		
	}
	
	public FlashBannerPanel getBanner() {
		return banner;
	}

	public void setBannerMessage(String msg)
	{
		banner.setMessage(msg);
	}
	
	public void hideBanner()
	{
		banner.hide();
	}
	
	public void showBanner()
	{
		banner.show();
	}

	public void setMonster(Monster monster) {
		this.monster = monster;
	}
	

	
}