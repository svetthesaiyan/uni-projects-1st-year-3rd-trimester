package config.pieces;

import config.Assets;
import config.enums.UnitColour;
import config.enums.UnitDirections;

public class Dwarf extends Assets
{
	/*
	 * Атака - 6 точки 
	 * Броня - 2 точки 
	 * Кръв - 12 точки 
	 * Бойна дистанция - 2 точки
	 * Скорост - 2 точки
	 */
	// -------------------
	// Джуджето може да се мести с до 2 позиции напред, назад, вдясно или вляво, но не и диагонално, ако, разбира се, му е чист пътят, тъй като има 2 точки Скорост за разлика от Рицаря
	
	public Dwarf(int row, int col, UnitColour colour)
	{
		super("@", row, col, 6, 2, 12, 2, 2, colour);
		this.colour=colour;
		this.unitName="Dwarf";
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
		return isPossible(toRow, toCol, 2, 0);
	}

	private boolean isPossible(int toRow, int toCol, int expectedRowCoefficient, int expectedColCoefficient)
	{

		int rowCoefficient=Math.abs(toRow-this.row);
		int colCoefficient=Math.abs(toCol-this.col);

		return rowCoefficient==expectedRowCoefficient && colCoefficient==expectedColCoefficient;
	}
}
