package launch;

import config.Gameboard;

public class Main
{
	public static void gameLoop(String[][] gameBoard)
	{
		Gameboard.renderGameBoard(gameBoard);
	}
	
	public static void main(String[] args)
	{
		String[][] gameBoard=Gameboard.bootstrapGameBoard();
		
		gameLoop(gameBoard);
	}
}
