package week_4_homework;

public class Gameboard 
{
	private static final int GAMEBOARD_ROW_COUNT	=15;
	private static final int GAMEBOARD_COL_COUNT	=15;
	
	private static final String UNIT_SMALL_BUILDING ="*";
	private static final String UNIT_MEDIUM_BUILDING="%";
	private static final String UNIT_LARGE_BUILDING ="&";
	
	private static final String UNIT_TANK			="1";
	private static final String UNIT_SNIPER			="2";
	private static final String UNIT_SPY			="3";
	private static final String UNIT_SABOTEUR		="4";
	private static final String UNIT_WARDEN			="$";
	
	private static final String UNIT_TERRAIN		=".";
	
	private static final String DIRECTION_FORWARD	="w";
	private static final String DIRECTION_BACKWARD	="s";
	private static final String DIRECTION_LEFT		="a";
	private static final String DIRECTION_RIGHT		="d";
	
	private static int tankRow;
	private static int tankCol;
	private static int sniperRow;
	private static int sniperCol;
	private static int spyRow;
	private static int spyCol;
	private static int saboteurRow;
	private static int saboteurCol;
	private static int wardenRow;
	private static int wardenCol;
	
	private static int row=0;
	private static int col=0;
	
	public static String[][] bootstrapGameboard()
	{
		String[][] gameboard=new String[GAMEBOARD_ROW_COUNT][GAMEBOARD_COL_COUNT];
		
		gameboard=generatePassableTerrain(gameboard);
		gameboard=generateSmallBuilding	 (gameboard);
		gameboard=generateMediumBuilding (gameboard);
		gameboard=generateLargeBuilding  (gameboard);
		
		gameboard=generateTank           (gameboard);
		gameboard=generateSniper		 (gameboard);
		gameboard=generateSpy			 (gameboard);
		gameboard=generateSaboteur		 (gameboard);
		gameboard=generateWarden		 (gameboard);
		
		return gameboard;
	}
	
	public static String[][] moveObject(String direction, String[][]gameboard)
	{
		int tankCurrentRow    =tankRow;
		int tankCurrentCol    =tankCol;
		
		int sniperCurrentRow  =sniperRow;
		int sniperCurrentCol  =sniperCol;
		
		int spyCurrentRow     =spyRow;
		int spyCurrentCol     =spyCol;
		
		int saboteurCurrentRow=saboteurRow;
		int saboteurCurrentCol=saboteurCol;
		
		if(direction.equals(DIRECTION_FORWARD)) 
		{
			saboteurCurrentRow=spyCurrentRow;
			spyCurrentRow	  =sniperCurrentRow;
			sniperCurrentRow  =tankCurrentRow;
			tankCurrentRow--;
		}
		if(direction.equals(DIRECTION_BACKWARD)) 
		{
			saboteurCurrentRow=spyCurrentRow;
			spyCurrentRow	  =sniperCurrentRow;
			sniperCurrentRow  =tankCurrentRow;
			tankCurrentRow++;
		}
		if(direction.equals(DIRECTION_LEFT)) 
		{
			saboteurCurrentCol=spyCurrentCol;
			spyCurrentCol	  =sniperCurrentCol;
			sniperCurrentCol  =tankCurrentCol;
			tankCurrentCol--;
		}
		if(direction.equals(DIRECTION_RIGHT)) 
		{
			saboteurCurrentCol=spyCurrentCol;
			spyCurrentCol	  =sniperCurrentCol;
			sniperCurrentCol  =tankCurrentCol;
			tankCurrentCol++;
		}
		
		gameboard[tankRow][tankCol]		   =UNIT_TERRAIN;
		gameboard[sniperRow][sniperCol]	   =UNIT_TERRAIN;
		gameboard[spyRow][spyCol]		   =UNIT_TERRAIN;
		gameboard[saboteurRow][saboteurCol]=UNIT_TERRAIN;
		
		tankRow=tankCurrentRow;
		tankCol=tankCurrentCol;
		gameboard[tankRow][tankCol]=UNIT_TANK;
		
		sniperRow=sniperCurrentRow;
		sniperCol=sniperCurrentCol;
		gameboard[sniperRow][sniperCol]=UNIT_SNIPER;
		
		spyRow=spyCurrentRow;
		spyCol=spyCurrentCol;
		gameboard[spyRow][spyCol]=UNIT_SPY;
		
		saboteurRow=saboteurCurrentRow;
		saboteurCol=saboteurCurrentCol;
		gameboard[saboteurRow][saboteurCol]=UNIT_SABOTEUR;
		
		return gameboard;
	}
	
	public static void renderGameboard(String[][] gameboard)
	{
		for(int row=0; row<GAMEBOARD_ROW_COUNT; row++)
		{
			for(int col=0; col<GAMEBOARD_COL_COUNT; col++)
			{
				System.out.print(" "+gameboard[row][col]);
			}
			System.out.println();
		}
	}
	
	private static String[][] generatePassableTerrain(String[][] gameboard)
	{
		for(int row=0; row<GAMEBOARD_ROW_COUNT; row++)
		{
			for(int col=0; col<GAMEBOARD_COL_COUNT; col++)
			{
				gameboard[row][col]=UNIT_TERRAIN;
			}
		}
		return gameboard;
	}
	
	private static String[][] generateSmallBuilding(String gameboard[][])
	{
		gameboard[row+2][col+2] =UNIT_SMALL_BUILDING;
		gameboard[row+3][col+2] =UNIT_SMALL_BUILDING;
		gameboard[row+2][col+3] =UNIT_SMALL_BUILDING;
		gameboard[row+3][col+3] =UNIT_SMALL_BUILDING;
					
		return gameboard;
	}
	
	private static String[][] generateMediumBuilding(String gameboard[][])
	{
		gameboard[row+4][col+7] =UNIT_MEDIUM_BUILDING;
		gameboard[row+5][col+7] =UNIT_MEDIUM_BUILDING;
		gameboard[row+4][col+8] =UNIT_MEDIUM_BUILDING;
		gameboard[row+5][col+8] =UNIT_MEDIUM_BUILDING;
		gameboard[row+4][col+9] =UNIT_MEDIUM_BUILDING;
		gameboard[row+5][col+9] =UNIT_MEDIUM_BUILDING;
		
		return gameboard;
	}
	
	private static String[][] generateLargeBuilding(String gameboard[][])
	{
		gameboard[row+8][col+1]	=UNIT_LARGE_BUILDING;
		gameboard[row+9][col+1] =UNIT_LARGE_BUILDING;
		gameboard[row+10][col+1]=UNIT_LARGE_BUILDING;
		gameboard[row+8][col+2] =UNIT_LARGE_BUILDING;
		gameboard[row+9][col+2] =UNIT_LARGE_BUILDING;
		gameboard[row+10][col+2]=UNIT_LARGE_BUILDING;
		gameboard[row+8][col+3] =UNIT_LARGE_BUILDING;
		gameboard[row+9][col+3] =UNIT_LARGE_BUILDING;
		gameboard[row+10][col+3]=UNIT_LARGE_BUILDING;
		
		return gameboard;
	}
	
	private static String[][] generateTank(String gameboard[][])
	{
		tankRow=(GAMEBOARD_ROW_COUNT-1);
		tankCol=(GAMEBOARD_COL_COUNT-4);
		gameboard[tankRow][tankCol]=UNIT_TANK;
		
		return gameboard;
	}
	
	private static String[][] generateSniper(String gameboard[][])
	{
		sniperRow=(GAMEBOARD_ROW_COUNT-1);
		sniperCol=(GAMEBOARD_COL_COUNT-3);
		gameboard[sniperRow][sniperCol]=UNIT_SNIPER;
		
		return gameboard;
	}
	
	private static String[][] generateSpy(String gameboard[][])
	{
		spyRow=(GAMEBOARD_ROW_COUNT-1);
		spyCol=(GAMEBOARD_COL_COUNT-2);
		gameboard[spyRow][spyCol]=UNIT_SPY;
		
		return gameboard;
	}
	
	private static String[][] generateSaboteur(String gameboard[][])
	{
		saboteurRow=(GAMEBOARD_ROW_COUNT-1);
		saboteurCol=(GAMEBOARD_COL_COUNT-1);
		gameboard[saboteurRow][saboteurCol]=UNIT_SABOTEUR;
		
		return gameboard;
	}
	
	private static String[][] generateWarden(String gameboard[][])
	{
		wardenRow=Utility.random(GAMEBOARD_ROW_COUNT);
		wardenCol=Utility.random(GAMEBOARD_COL_COUNT);
		gameboard[wardenRow][wardenCol]=UNIT_WARDEN;
		
		return gameboard;
	}
	
	public static void willWardenFire(String gameboard[][])
	{
		int triggerhappyCoefficient=Utility.random(24)+1;
		
		if(triggerhappyCoefficient%11==0)
		{
			System.out.println("Бай Петкан уцели фатално лидера!");
		}
		else
		{
			System.out.println("Бай Петкан не беше точен и се скри, за да презареди.");
		}
	}
}
