package week_4_exercises;

public class b_game_board_manager 
{
	// модификатори за достъп
    // * public  - видим е за всеки
    // * private - видим е само и единствено без изключения в рамките на ТОЗИ клас
	private static final int GAME_BOARD_ROW_COUNT=10;
	private static final int GAME_BOARD_COL_COUNT=10;
	
	private static final String UNIT_TERRAIN=".";
	private static final String UNIT_PLAYER="%";
	private static final String UNIT_OBSTACLE="#";
	
	private static final String DIRECTION_FORWARD="w";
	private static final String DIRECTION_BACKWARD="s";
	private static final String DIRECTION_LEFT="a";
	private static final String DIRECTION_RIGHT="d";
	
	private static int playerRow;
	private static int playerCol;
	
	// 0. Създаване на игрова дъска
	public static String[][] bootstrapGameBoard()
	{
		String[][] gameBoard=new String[GAME_BOARD_ROW_COUNT][GAME_BOARD_COL_COUNT];
		gameBoard=generatePassableTerrain(gameBoard);
		gameBoard=generatePlayerTank(gameBoard);
		gameBoard=generateObstacles(gameBoard);
		
		return gameBoard;
	}
	
	public static String[][] movePlayer(String direction, String[][] gameBoard)
	{
	int playerCurrentRow=playerRow;
	int playerCurrentCol=playerCol;
	
	
		if(direction.equals(DIRECTION_FORWARD))
			playerCurrentRow--;
		if(direction.equals(DIRECTION_BACKWARD))
			playerCurrentRow++;
		if(direction.equals(DIRECTION_LEFT))
			playerCurrentCol--;
		if(direction.equals(DIRECTION_RIGHT))
			playerCurrentCol++;
		
		 // текущите координати преди да се извърши преместването
		gameBoard[playerRow][playerCol]=UNIT_TERRAIN;
		// да присвоя новите стойности
		playerRow=playerCurrentRow;
		playerCol=playerCurrentCol;
		// местим играча една позиция в определена посока
		gameBoard[playerRow][playerCol]=UNIT_PLAYER;
		
		return gameBoard;
	}
	
	// 1. Визуализация на боен терен
	public static void renderGameBoard(String[][] gameBoard)
	{
		for(int row=0; row<GAME_BOARD_ROW_COUNT; row++)
		{
			for(int col=0; col<GAME_BOARD_COL_COUNT; col++)
			{
				System.out.print(" "+gameBoard[row][col]);
			}
			System.out.println();
		}
	}
	
	private static String[][] generatePassableTerrain(String[][] gameBoard)
	{
		for(int row=0; row<GAME_BOARD_ROW_COUNT; row++)
		{
			for(int col=0; col<GAME_BOARD_COL_COUNT; col++)
			{
				gameBoard[row][col]=UNIT_TERRAIN;
			}
		}
		return gameBoard;
	}
	
	private static String[][] generatePlayerTank(String[][] gameBoard)	
	{
		final int playerRow=GAME_BOARD_ROW_COUNT-1;
		int playerCol=c_utility.random(GAME_BOARD_ROW_COUNT);
		
		gameBoard[playerRow][playerCol]=UNIT_PLAYER;
		return gameBoard;
	}
	
	private static String[][] generateObstacles(String[][] gameBoard)
	{
		final int obstacleStartIndex=3;
		final int obstacleEndIndex=6;
		
		for(int row=obstacleStartIndex; row<obstacleEndIndex; row++)
		{
			for(int col=0; col<GAME_BOARD_COL_COUNT; col++)
			{
				if(isPlacementOfObstaclePossible())
				{
					gameBoard[row][col]=UNIT_OBSTACLE;
				}
			}
		}
		return gameBoard;
	}
	
	public static boolean isPlacementOfObstaclePossible()
	{
		int chanceCoefficient=c_utility.random(6);
		return chanceCoefficient==1;
	}
}
