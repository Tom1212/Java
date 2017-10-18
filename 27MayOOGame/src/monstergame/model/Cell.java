package monstergame.model;

/* This class represents the individual cell in the grid.
 */

public class Cell {
	private int row;
	private int col;
	boolean gotGold = true;

	public Cell(int i, int j) {
		setRow(i);
		setCol(j);
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}
}
