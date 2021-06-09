package pieces;

import pieces.config.ColourEnum;

public abstract class Piece
{
	protected int row;
	protected int col;
	protected int score; // можем и тук да инициализираме стойността на тази променлива, вместо в конструктора отдолу
	protected ColourEnum colour;
	protected String sign;
	
	public Piece(int row, int col, ColourEnum colour) // конструктор
	{
		this.row=row;
		this.col=col;
		this.colour=colour;
	}
	
	public String getColourSign()
	{
		if(this.colour==ColourEnum.BLACK)
		{
			return "b";
		}
		if(this.colour==ColourEnum.WHITE)
		{
			return "w";
		}
		
		return null;
	}
	
	public String getSign()
	{
		return this.getColourSign()+this.sign;
	}
	
	public void move(int moveRow, int moveCol)
	{
		this.row=moveRow;
		this.col=moveCol;
	}
	
	public abstract boolean isMovePossible(int toRow, int toCol);
	
	public abstract boolean isAttackPossible(int toRow, int toCol);
}
