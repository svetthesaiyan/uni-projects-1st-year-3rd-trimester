package week_4_exercises;

import java.util.Scanner;

public class a_battle_city 
{
	public static void gameLoop(String[][] gameBoard)
	{
		// употреба на динамични методи
		Scanner scanner = new Scanner(System.in);
		System.out.println("Изберете посока: ");
		String direction=scanner.nextLine();
		
		gameBoard=b_game_board_manager.movePlayer(direction, gameBoard);
		b_game_board_manager.renderGameBoard(gameBoard);
		
		gameLoop(gameBoard);
	}
	public static void main(String[] args) 
	{
		// употреба на статичен метод
		String [][] gameBoard=b_game_board_manager.bootstrapGameBoard();
		b_game_board_manager.renderGameBoard(gameBoard);
		
		gameLoop(gameBoard);
	}
}
