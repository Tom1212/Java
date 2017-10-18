package monstergame.model;

public class HiddenMonster extends Monster {

	public HiddenMonster(Grid g, Player p, int row, int col) throws Exception {
		super(g, p, row, col);
	}

	@Override
	public boolean viewable() {
		
		int distance = this.grid.distance(getCell(), super.getPlayer().getCell());
		
		if (distance < 6)
		{
			return true;
		}
		
		return false;
		
	}

}
