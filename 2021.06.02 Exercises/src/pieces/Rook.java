package pieces;

import pieces.config.ColourEnum;

public class Rook extends Piece // разширение 
{
	
	public Rook(int row, int col, ColourEnum colour) // конструктор
	{
		super(row, col, colour);
		this.score=10;
		this.sign="R";
	}
	
	public boolean isMovePossible(int toRow, int toCol)
	{
		int rowCoefficient=Math.abs(toRow-this.row);
		int colCoefficient=Math.abs(toCol-this.col);
		
		return rowCoefficient==toRow || colCoefficient==toCol;
	}
	
	public boolean isAttackPossible(int toRow, int toCol)
	{
		return this.isMovePossible(toRow, toCol);
	}
}
