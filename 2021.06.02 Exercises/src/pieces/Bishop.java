package pieces;

import pieces.config.ColourEnum;

public class Bishop extends Piece // разширение 
{
	
	public Bishop(int row, int col, ColourEnum colour) // конструктор
	{
		super(row, col, colour);
		this.score=10;
		this.sign="B";
		
	}
	
	public boolean isMovePossible(int toRow, int toCol)
	{
		int rowCoefficient=Math.abs(toRow-this.row);
		int colCoefficient=Math.abs(toCol-this.col);
		
		return rowCoefficient==colCoefficient;
	}
	
	public boolean isAttackPossible(int toRow, int toCol)
	{
		return this.isMovePossible(toRow, toCol);
	}
}
