package pieces;

import pieces.config.ColourEnum;

public class Pawn extends Piece // разширение
{
	
	public Pawn(int row, int col, ColourEnum colour) // конструктор
	{
		super(row, col, colour);
		this.score=1;
		this.sign="P";
	}
	
	private boolean isPossible(int toRow, int toCol, int expectedRowCoefficient, int expectedColCoefficient)
	{
		int rowCoefficient=Math.abs(toRow-this.row);
		int colCoefficient=Math.abs(toCol-this.col);
		
		return rowCoefficient==expectedRowCoefficient && colCoefficient==expectedColCoefficient;
	}

	@Override
	public boolean isMovePossible(int toRow, int toCol)
	{
		return false;
	}

	@Override
	public boolean isAttackPossible(int toRow, int toCol)
	{
		return false;
	}
	
}
