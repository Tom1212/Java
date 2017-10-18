package monstergame.model;

public class JumpingMonster extends Monster {

	public JumpingMonster(Grid g, Player p, int row, int col) throws Exception {
		super(g, p, row, col);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Cell move() {
        currentDirection = grid.getBestDirection(currentCell, getPlayer().getCell());
        
        int distance = this.grid.distance(getCell(), super.getPlayer().getCell());
		
		//jumping when monster has aligned with player
		//count how many steps between monster and player then use for loop to do get cell with correct direction
        
        int directAttackSteps = 1;
        if (currentCell.getCol() == getPlayer().getCell().getCol())
        {
        	directAttackSteps = Math.abs(currentCell.getRow() - getPlayer().getCell().getRow());
        	if (directAttackSteps != distance)
        	{
        		directAttackSteps =1;
        	}
        	
        } else if (currentCell.getRow() == getPlayer().getCell().getRow())
        {
        	directAttackSteps = Math.abs(currentCell.getCol() - getPlayer().getCell().getCol());
        	if (directAttackSteps != distance)
        	{
        		directAttackSteps =1;
        	}
        }
        
        System.out.println("Monster Moves: " + directAttackSteps);
		
		for (int i = 0;i<directAttackSteps;i++)
		{
			currentCell = (grid.getCell(getCell(),getDirection()));
		}
		
		
//        currentCell = (grid.getCell(getCell(),getDirection()));
        return currentCell;
		
	}
	
	

}
