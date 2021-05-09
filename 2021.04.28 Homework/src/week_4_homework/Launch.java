package week_4_homework;

import java.util.Scanner;

public class Launch 
{
	public static void gameLoop(String[][] gameboard)
	{
		Scanner scanner=new Scanner(System.in);
		System.out.print("Изберете посока: ");
		String direction=scanner.nextLine();
		
		gameboard=Gameboard.moveObject(direction, gameboard);
		Gameboard.renderGameboard(gameboard);
		Gameboard.willWardenFire(gameboard);
		
		gameLoop(gameboard);
	}
	
	public static void main(String[] args) 
	{
		String[][] gameboard=Gameboard.bootstrapGameboard();
		Gameboard.renderGameboard(gameboard);
		
		gameLoop(gameboard);
	}
}
