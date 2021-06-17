package config.obstacles;

import config.Assets;
import config.enums.UnitDirections;

public class Wall extends Assets
{
	public Wall(int row, int col)
	{
		super("#", row, col);
		this.health=10_000;
	}

	public boolean isMovePossible(UnitDirections input, int toRow, int toCol)
	{
		return isPossible(toRow, toCol, 0, 0);
	}

	public boolean isAttackPossible(int toRow, int toCol)
	{
		return isPossible(toRow, toCol, 0, 0);
	}

	private boolean isPossible(int toRow, int toCol, int expectedRowCoefficient, int expectedColCoefficient)
	{
		return false;
	}
}
