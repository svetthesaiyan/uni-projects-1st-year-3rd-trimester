package config.pieces;

import config.Assets;
import config.enums.UnitColour;
import config.enums.UnitDirections;

public class Knight extends Assets
{
	/*
	 * Атака - 8 точки 
	 * Броня - 3 точки 
	 * Кръв - 15 точки 
	 * Бойна дистанция - 1 точкa 
	 * Скорост - 1 точкa
	 */
	// -------------------
	// Рицарят може да се мести само с 1 позиция напред, назад, вдясно или вляво, но не и диагонално, ако, разбира се, му е чист пътят, тъй като има само 1 точка Скорост
	
	public Knight(int row, int col, UnitColour colour)
	{
		super("%", row, col, 8, 3, 15, 1, 1, colour);
		this.colour=colour;
		this.unitName="Knight";
	}

	public boolean isMovePossible(UnitDirections input, int toRow, int toCol)
	{
		if(input==UnitDirections.W)
			return isPossible(toRow, toCol, -1, 0);
		else if(input==UnitDirections.A)
			return isPossible(toRow, toCol, 0, -1);
		else if(input==UnitDirections.S)
			return isPossible(toRow, toCol, 1, 0);
		else if(input==UnitDirections.D)
			return isPossible(toRow, toCol, 0, 1);
		
		return isPossible(toRow, toCol, 0, 0);
	}

	public boolean isAttackPossible(int toRow, int toCol)
	{
		return isPossible(toRow, toCol, 1, 0);
	}

	private boolean isPossible(int toRow, int toCol, int expectedRowCoefficient, int expectedColCoefficient)
	{

		int rowCoefficient=Math.abs(toRow-this.row);
		int colCoefficient=Math.abs(toCol-this.col);

		return rowCoefficient==expectedRowCoefficient && colCoefficient==expectedColCoefficient;
	}
}
