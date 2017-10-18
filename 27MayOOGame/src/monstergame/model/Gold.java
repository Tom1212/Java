package monstergame.model;

public class Gold  {
	private Player player;
	private Grid grid;
	private Cell currentCell;
	private boolean eaten = false;
	private int eatenCount = 100;
	public Gold(Grid g, Player p, int row, int col) throws Exception
	{
		grid = g;
		player = p;
		setCell(g.getCell(row,col));
	}

	public void setCell(Cell c)
	{
		currentCell = c;
	}
	public Cell getCell()
	{
		return currentCell;	    
	}
	public void setEaten(boolean val)
	{
		eaten = val;
	}
	public boolean isEaten()
	{   
		return eaten;
	}
	public int getGoldCount()
	{   
		return eatenCount;
	}
	public void setGold(int i){
		eatenCount += i;
		player.setCalories(eatenCount);
	}

}
