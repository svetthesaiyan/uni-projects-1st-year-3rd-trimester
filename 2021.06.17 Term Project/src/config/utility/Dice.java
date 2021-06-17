package config.utility;

import java.util.Random;

public class Dice
{
	static Random random=new Random();

	public static int generateObstacle()
	{
		return random.nextInt(4)+1;
	}

	public static int decideObstacleType()
	{
		return random.nextInt(2)+1;
	}

	public static int diceOffenseAndHeal()
	{
		return random.nextInt(6)+1;
	}
}
