package monstergame.model;

public class SmartMonster extends Monster {

	public SmartMonster(Grid g, Player p, int row, int col) throws Exception {
		super(g, p, row, col);
	}

	@Override
	public Cell move() {
		
		//maybe consider later what is mean reflecting the direction of player move
		
		/*
		 * Consider player's energy level
		 * 
		 * if player has less energy then the distance between monster and play
		 * then will not consider trap and maneuverability
		 */
		
		//distance between player and monster
		int distance = this.grid.distance(getCell(), super.getPlayer().getCell());
		if (getPlayer().getCalories() >= distance)
		{
			/*
			 *  Deal with trap
			 *  
			 *  when monster sense there is an trap on the route
			 *  monster will calculate the trap current time as a factor 
			 *  for calculate distance, then choose other route move towards player
			 *  
			 */
			
			/*
			 * There is an design issue with your partner's player implementation
			 * 1. The player only able to set 1 trap at time
			 * 2. Gold implementation should be an object rather then the entity to 
			 * use as player's energy count
			 * 3. He need to create another 2 player type to make some of the smart
			 * monster function work.
			 * 4. Player that your partner implemented will not stopped by trap and
			 * road block
			 */
			
			currentDirection = grid.getBestPlayerDirection(currentCell, getPlayer().getCell(), getPlayer().getTrap());
			
			
			
			
			

			// monster will match up player's fast move
			if (super.getPlayer() instanceof FastPlayer)
			{
				FastPlayer fp = (FastPlayer) super.getPlayer();
				for (int i = 0; i < fp.lastMoveCount; i++)
				{
					currentCell = (grid.getCell(getCell(),getDirection()));
				}
				fp.lastMoveCount = 0;
				return currentCell;
			}
			
			// implement maneuverability, 1st need for monster to recognize the special player
			
			
			
			
		}
		
		
        currentCell = (grid.getCell(getCell(),getDirection()));
        return currentCell;
	}
	
	

}
