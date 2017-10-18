package monstergame.model;
/*  This class encapsulates player position and direction  
 */
public class Player extends Moveable {
   private boolean readyToStart = false;
   private int escape = 3;
   private boolean isEscape = false;

   private Trap trap;
   
   //player has enery level as counted by calories - TOM
   private int calories;
   
   
   public Player(Grid g, int row, int col) throws Exception
   {
	   super(g);
	   currentCell = grid.getCell(row, col);   
	   currentDirection = ' ';
	   
	   //player start calories of 40
	   this.calories = 40;
   }
   public Cell move()
   {
	   //player sense if self is moved
	   
	   int originalRow = currentCell.getRow();
	   int originalCol = currentCell.getCol();
	   
	   currentCell = grid.getCell(currentCell,currentDirection);
	   
	   //each move uses 2 calories - TOM
	   if (currentCell.getCol() != originalCol || currentCell.getRow() != originalRow)
	   {
		   this.calories -= 2;
	   }
                 
       return currentCell;
   }
   public int maxCellsPerMove()
   {
	   return 1;
   }
   public  int pointsRemaining()
   {
	   return -1;  // not implemented
   }
   public void setReady(boolean val)
   {
	   readyToStart = val;
   }
   public boolean isReady()
   {   return readyToStart;
   }
   public void setEscape()
   {
	   escape--;
   }
   public int getEscape(){
	   return escape;
   }
   public boolean getIsEscape(){
	   return isEscape;
   }
   public void setIsEscape(boolean val){
	   isEscape = val;
   }
   /*
    * Editor: Tom
    * This method is to give player 6 calories when triggered by eaten a golden nougat
    */
   public void reward()
   {
	   this.calories += 6;
   }
   
   public int getCalories() {
		return calories;
	}
   
   public void setCalories(int c)
   {
	   this.calories = c;
   }
   
   public void setTrap(Trap trap)
   {
	   this.trap = trap;
   }
   
   public Trap getTrap()
   {
	   return this.trap;
   }
}