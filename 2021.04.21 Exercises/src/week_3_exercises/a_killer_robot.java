package week_3_exercises;

import java.util.Random;
import java.util.Scanner;

public class a_killer_robot 
{
	
	
	public static void main(String[] args) 
	{
		System.out.println("Привет на новия ми господар.");
		System.out.println("Пред работа се намират следните обекти:");
		System.out.println("1. Стена");
		System.out.println("2. Стол");
		System.out.println("Пътят е чист.");
		System.out.println();
		
		Scanner scanner = new Scanner(System.in);
		int obstacleIndex=Integer.parseInt(scanner.nextLine());
		
/*
		String direction=obstacleIndex==1 ? "Go sideways."
				:obstacleIndex==2 ? "Jump"
						: "Forward";
*/
		
/*		Вариант №1
		String direction;
		if(obstacleIndex==1)
			direction="Go sideways.";
		else
		{
			if(obstacleIndex==2)
				direction="Jump.";
			else
				direction="Forward.";
		}
*/
		
/*		Вариант №2
		String direction="Forward";
		if(obstacleIndex==1)
			direction="Go sideways.";
		else
		{
			if(obstacleIndex==2)
				direction="Jump.";
		}
*/
		
//		Вариант №3
		String direction="Forward.";
		if(obstacleIndex==1)
			direction="Go sideways.";
		else if(obstacleIndex==2)
			direction="Jump.";
		
/*		Вариант №4
		String direction="Forward.";
		if(obstacleIndex==1)
			direction="Go sideways.";
		if(obstacleIndex==2)
			direction="Jump.";
*/			
		System.out.println(direction);
		
		int pixelCount=Integer.parseInt(scanner.nextLine());
		
		boolean isMouseTargetDetected=(pixelCount%2==0);
		
		int currentNumberOfHits=0;
		final int maxNumberOfHits=4;
		boolean isHitPossible=false;
		
		if(currentNumberOfHits<maxNumberOfHits)
		{
			isHitPossible=true;
			currentNumberOfHits++; //currentNumberOfHits=currentNumberOfHits+1;
		}
		
		Random random=new Random();
		int randomNumberResult=random.nextInt(11);
		if(randomNumberResult==0)	// долната ни граница е единица
			randomNumberResult=1;
		
/*		boolean isMouseTargetHit=false;
		if(randomNumberResult!=5)
			isMouseTargetHit=true;
*/	
		
		boolean isMouseTargetHit=(randomNumberResult!=5);
		
//		Math math=new Math();
//		Math.random()
	}
}
