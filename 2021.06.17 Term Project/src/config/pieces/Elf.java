package config.pieces;

import config.Assets;
import config.enums.UnitColour;
import config.enums.UnitDirections;

public class Elf extends Assets
{
	/*
	 * Атака - 5 точки
	 * Броня - 1 точки
	 * Кръв - 10 точки 
	 * Бойна дистанция - 3 точки
	 * Скорост - 3 точки
	 */
	// -------------------
	// Елфът може да се мести с до 3 позиции напред, назад, вдясно или вляво, но не и диагонално, ако, разбира се, му е чист пътят, тъй като има 3 точки Скорост. Той също така може да предприеме движение във формата на 'Г', което да използва целите 3 точки Скорост, които елфът има на разположение.
	
	public Elf(int row, int col, UnitColour colour)
	{
		super("&", row, col, 5, 1, 10, 3, 3, colour);
		this.colour=colour;
		this.unitName="Elf";
	}

	public boolean isMovePossible(UnitDirections input, int toRow, int toCol)
	{
		if(input==UnitDirections.W)
			return isPossible(toRow, toCol, 1, 0);
		else if(input==UnitDirections.A)
			return isPossible(toRow, toCol, 0, 1);
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
