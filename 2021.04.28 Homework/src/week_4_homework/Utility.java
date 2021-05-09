package week_4_homework;

import java.util.Random;

public class Utility 
{
	public static int random(int upperBound)
	{
		Random random=new Random();
		return random.nextInt(upperBound);
	}
}
