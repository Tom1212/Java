package monstergame.model;

public class Trap {
	private Player player;
	private Grid grid;
	private Cell currentCell;
	private boolean set = false;
	private int time = 0;
	public Trap(Grid g, Player p, int row, int col) throws Exception
	{
		grid = g;
		player = p;
		setCell(g.getCell(row,col));
		//pass trap to player
		p.setTrap(this);
	}

	public void setCell(Cell c)
	{
		currentCell = c;
	}
	public Cell getCell()
	{
		return currentCell;	    
	}
	public void set(boolean val)
	{
		set = val;
	}
	public boolean isSet()
	{   
		return set;
	}
	public int getTime(){
		return time;
	}
	public void setTime(int i){
		time+=i;
	}


}
