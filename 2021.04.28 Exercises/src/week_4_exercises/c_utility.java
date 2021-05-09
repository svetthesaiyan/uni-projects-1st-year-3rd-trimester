package week_4_exercises;

import java.util.Random;

public class c_utility 
{
	public static int random(int upperBound) 
	{
		Random generate=new Random();
		return generate.nextInt(upperBound);
	}
}
