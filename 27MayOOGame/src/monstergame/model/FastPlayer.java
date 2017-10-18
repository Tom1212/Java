package monstergame.model;

public class FastPlayer extends Player {
	protected char [] directions = new char[3];
	int moveCount = 0;
	int lastMoveCount = 0;
	
	public FastPlayer(Grid g, int row, int col) throws Exception{
		super(g, row, col);
	}
	public void setDirection(char d){
		if(moveCount < 3)
			directions[moveCount] = d;
		moveCount++;
	}
	public Cell move(){
		currentCell = grid.getCell(currentCell, directions[0]);
		if(moveCount > 1)
			currentCell = grid.getCell(currentCell, directions[1]);
		if(moveCount > 2)
			currentCell = grid.getCell(currentCell, directions[2]);	
		lastMoveCount = moveCount;
		System.out.println("Fastplayer moves: " + lastMoveCount);
		moveCount = 0;
		return currentCell;
	}

}
