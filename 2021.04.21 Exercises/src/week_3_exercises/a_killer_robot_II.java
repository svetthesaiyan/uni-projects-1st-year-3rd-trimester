package week_3_exercises;

import java.util.Random;
import java.util.Scanner;

public class a_killer_robot_II 
{
	public static String getDirection(int obstacleIndex)
	{
		if(obstacleIndex==1)
			return "Go sideways.";
		else if(obstacleIndex==2)
			return "Jump.";
		
		return "Forward.";
	}
	
	public static boolean isMouseTargetDetected(int pixelCount)
	{
		return (pixelCount%2==0);
	}
	
	public static boolean isMaxNumberOfHitsReached(int currentNumberOfHits)
	{
		final int maxNumberOfHits=4;
		return currentNumberOfHits<maxNumberOfHits;
	}
	
	public static boolean isHitCorrect()
	{
		Random random=new Random();
		int randomNumberResult=random.nextInt(11);
		if(randomNumberResult==0)
			randomNumberResult=1;
		
		boolean isHitCorrect=(randomNumberResult!=5);
		
		return isHitCorrect;
	}
	
	public static boolean isHitSuccessful(int pixelCount, int currentNumberOfHits)
	{
		boolean isMouseTargetDetected=isMouseTargetDetected(pixelCount);
		boolean isMaxNumberOfHitsReached=isMaxNumberOfHitsReached(currentNumberOfHits);
		boolean isHitCorrect=isHitCorrect();
		boolean isHitSuccessful=isMouseTargetDetected && isMaxNumberOfHitsReached && isHitCorrect;
		
		return isHitSuccessful;
	}
	
	public static void main(String[] args)
	{
		int currentNumberOfHits=0;
		Scanner scanner = new Scanner(System.in);
		boolean isRobotUpAndRunning=true;
		
		while(isRobotUpAndRunning)
		{
		System.out.println("Привет на новия ми господар.");
		System.out.println("Пред работа се намират следните обекти:");
		System.out.println("1. Стена");
		System.out.println("2. Стол");
		System.out.println("Пътят е чист.");
		System.out.println();
		
		int obstacleIndex=Integer.parseInt(scanner.nextLine());;
		System.out.println(getDirection(obstacleIndex));
		
		int numberOfPixels=Integer.parseInt(scanner.nextLine());
		isRobotUpAndRunning=isHitSuccessful(numberOfPixels, currentNumberOfHits);
		}
	}
}
