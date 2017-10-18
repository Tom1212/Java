package monstergame.model;
/* This class uses a partially hollow 2D array to represent the games grid.  
 * Row and column corresponds to the 2D array row and column respectively. 
 * Hence, for the standard grid both row and column must be in the range 
 * 0 to 10. Furthermore, either row or column must be 0, 5 or 10.    
*/ 

public class Grid {

	Cell cells[] = new Cell[57];
    Cell cells2D[][] = new Cell[11][11];
			
	public Grid()
	{	
	   int k=0;
       for (int i=0; i<11; i++)
          for (int j=0; j<11; j++)
             if ( (i %5 == 0) ||(j%5 == 0 && i%5 != 0))
             {
                cells2D[i][j] = new Cell(i,j);
                cells[k++] = cells2D[i][j];
             }   	
	}
    /* Returns a reference to the specified cell.
     * row and cell must be in the range 0 .. 10 and either row or col
     * must be 0, 5 or 10.
    */
	public Cell getCell(int row, int col) throws Exception
	{
		if ((row %5 != 0 && col %5 != 0) || 
				 row < 0 || row > 10 || col < 0 || col > 10)
			throw new Exception("Invalid Coordiantes row = " + row + " column " + col);
		return cells2D[row][col];
	}

	/* Returns the cell in the specified direction of the given cell. 
	   Valid direction must be either 'R', 'L', 'U', 'D' or ' '.
	   A null value will be returned if attempt to get a non-existent cell.
	*/  
	public Cell getCell(Cell cell, char direction)
	{
       if (direction == ' ') return cell;
	   if (direction == 'U')
	   {
		   if (cell.getCol() %5 == 0 && cell.getRow() >0)
		      return cells2D[cell.getRow()-1][cell.getCol()];
		   return cell;
	   }
	   else if (direction == 'D')
	   {
		   if (cell.getCol() %5 == 0 && cell.getRow() <10)
		      return cells2D[cell.getRow()+1][cell.getCol()];
		   return cell;
	   }
	   else if (direction == 'L')
	   {
		   if (cell.getRow() %5 == 0 && cell.getCol() >0)
		      return cells2D[cell.getRow()][cell.getCol()-1];
		   return cell;
	   }
	   else if (direction == 'R')
	   {
		   if (cell.getRow() %5 == 0 && cell.getCol() <10)
		      return cells2D[cell.getRow()][cell.getCol()+1];
		   return cell;
	   }
	   return null;
	}

	public Cell[] getAllCells()
	{
		return cells;
	}
	
	/* helper method to check whether val is in the range a to b  
	 */
	private boolean inBetween(int val, int a, int b)
	{
		if (val >= a && val <= b)
			return true;
		else return false;
		
	}
	
    /* returns the best direction from source cell to the target cell.
     * Assumed cells passed are valid cells in the grid.
     * you need to verify this method 
     */
	public char getBestDirection(Cell from, Cell to)
	{

	    if (from.getRow() == to.getRow())
	    {
			if (from.getCol() < to.getCol())
				return 'R';
			else if (from.getCol() > to.getCol())
		        return 'L';
	    }
		else if (from.getCol() == to.getCol())
		{
			if (from.getRow() < to.getRow())
				return 'D';
			else if (from.getRow() > to.getRow())
		        return 'U';
		}
	
		int row = to.getRow();
	    int col = to.getCol();
	    
	    if (inBetween(to.getRow() %5, 1,2))
	       row = to.getRow()/5*5;
	    else if (inBetween(to.getRow() %5, 3,4))
	       row = to.getRow()/5*5 + 5;	
	    if (inBetween(to.getCol() %5, 1,2))
		    col = to.getCol()/5*5;
		else if (inBetween(to.getCol() %5, 3,4))
		    col = to.getCol()/5*5 + 5;		


	    if (from.getRow() % 5 == 0)
			if (from.getCol() < col)
				return 'R';
			else if (from.getCol() > col)
		        return 'L';
		if (from.getCol() %5 == 0)
			if (from.getRow() < row)
				return 'D';
			else if (from.getRow() > row)
		        return 'U';
		return ' ';
	}
	
	public char getBestPlayerDirection(Cell from, Cell to, Trap trap)
	{
		//will use trap time as a factor to calculate distance

		if (from.getRow() == to.getRow())
	    {
			if (from.getCol() < to.getCol())
				return 'R';
			else if (from.getCol() > to.getCol())
		        return 'L';
	    }
		else if (from.getCol() == to.getCol())
		{
			if (from.getRow() < to.getRow())
				return 'D';
			else if (from.getRow() > to.getRow())
		        return 'U';
		}
	
		int row = to.getRow();
	    int col = to.getCol();
	    
	    if (inBetween(to.getRow() %5, 1,2))
	       row = to.getRow()/5*5;
	    else if (inBetween(to.getRow() %5, 3,4))
	       row = to.getRow()/5*5 + 5;	
	    if (inBetween(to.getCol() %5, 1,2))
		    col = to.getCol()/5*5;
		else if (inBetween(to.getCol() %5, 3,4))
		    col = to.getCol()/5*5 + 5;		


	    if (from.getRow() % 5 == 0)
			if (from.getCol() < col)
				return 'R';
			else if (from.getCol() > col)
		        return 'L';
		if (from.getCol() %5 == 0)
			if (from.getRow() < row)
				return 'D';
			else if (from.getRow() > row)
		        return 'U';
		
		return ' ';
	}

	/* A helper method to get the absolute value */
	private int abs(int x)
    {
       if (x >= 0) return x;
       else return -x;
    }

	/* A helper method to get the minimum of three values */
	private int min(int x, int y, int z)
    {
       if ( x <= y && x <= z) return x;
       if ( y <= z && y <= x) return y;
       return z;
    }

	/* A method to get the shortest distance from one cell to another 
	 * Assumed cells are valid cells in the grid 
	 */  
	public int distance(Cell from, Cell to)
    {
         int d = 0;
         // compute minimum horizontal distance:  
         if ( from.getRow() == to.getRow()) d += abs(to.getCol()-from.getCol());
         else d += min(from.getCol()+to.getCol(), abs(from.getCol()-5) + abs(to.getCol()-5) , abs(from.getCol()-10) + abs(to.getCol()-10)); 
         
         // compute minimum vertical distance as follows:  
         if ( from.getCol() == to.getCol()) d += abs(to.getRow()-from.getRow());
         else d += min(from.getRow()+to.getRow(), abs(from.getRow()-5) + abs(to.getRow()-5) , abs(from.getRow()-10) + abs(to.getRow()-10)); 
         return d;
    }

    /* Test harness for Grid*/
	public static void main(String args[]) throws Exception
    {
	   Grid grid = new Grid();
	   Cell c1 = grid.getCell(0,0);
	   Cell c2 = grid.getCell(10,10);
	   Cell c3 = grid.getCell(0,2);
	   Cell c4 = grid.getCell(2,0);
	   Cell c5 = grid.getCell(8,5);
	   
	   System.out.println("Distance from (0,0) to (10,10) is " 
	                                      + grid.distance(c1, c2));
	   System.out.println("Distance from (0,0) to (8,5) is " 
               + grid.distance(c1, c5));
	   System.out.println("From (0,0) to (0,2) best direction is " 
	                                + grid.getBestDirection(c1,c3));
	   System.out.println("From (0,0) to (2,0) best direction is " 
                                    + grid.getBestDirection(c1,c4));
    }
}