package config;

import java.util.Scanner;

import config.enums.UnitColour;
import config.enums.UnitDirections;
import config.pieces.Dwarf;
import config.pieces.Elf;
import config.pieces.Knight;
import config.utility.Dice;

public class Gameboard
{
	static Scanner scanner=new Scanner(System.in);
	/*
	 * на 1ви и 2ри ред се намира замъкът на червените
	 * на 3ти, 4ти и 5ти ред се намира бойното поле
	 * на 6ти и 7ми ред се намира замъкът на черните
	 */
	
	/* Играта се играе на два етапа:
	 * 1. Начало на играта – в този етап играчите позиционират фигурите си върху терена, като първият ход е на черния и също така фигурите могат да се слагат *единствено* в замъците на съответния играч 
	 * 2. Същинска игра – в този етап играчите извършват бойни и стратегически действия с цел нанасяне на щети върху техния опонент
	 *    2.1 Да придвижи фигурата си
	 *    2.2 Да атакува противникова фигура
	 *    2.3 Да излекува нанесените му щети
	 */
	private static final int GAMEBOARD_ROW_COUNT=7;
	private static final int GAMEBOARD_COL_COUNT=9;
	
	// Всеки играч разполага с 2 от всяка фигурка
	// ------------------------------------------
	/* Всяка една от фигурите се характеризира с пет свойства:
	 * 1. Атака – това е количеството щети, която фигурата нанася на противника
	 * 2. Броня – това е защитата, с която фигурата разполага в даден момент
	 * 3. Здраве – това е общото количество кръв, с което фигурата разполага. Ако стойността достигне 0, то фигурата се счита за **елиминирана**
	 * 4. Бойна дистанция – това е необходимата дистанция, на която фигурата трябва да застане, за да атакува противника. 
	 * 	  4.1 Елфите стрелят с лък и не може да се намират директно срещу противника
	 *    4.2 Джуджетата хвърлят чукове.
	 * 5. Скорост – това е количеството квадрати, през които може фигурата да премине в рамките на един ход.
	 */
	
//	private static final String UNIT_KNIGHT_RED  ="R%";
//	private static final String UNIT_ELF_RED     ="R&";
//	private static final String UNIT_DWARF_RED   ="R@";
//	private static final String UNIT_KNIGHT_BLACK="B%";
//	private static final String UNIT_ELF_BLACK   ="B&";
//	private static final String UNIT_DWARF_BLACK ="B@";
	
	// В рамките на БОЙНОТО ПОЛЕ се генерират на *случаен* принцип от 1 до 5 препятствия, като *задължително* трябва да има поне една стена.
	// -----------------------------------------------------------
	/* За двата типа препятствия са верни следните характеристики:
	 * 1. Не могат да бъдат прескачани
	 * 2. Могат да бъдат игнорирани от **Елфите**. Митичните същества също така могат да атакуват противника си дори на пътя им да има препятствие.
	 */
	private static final String UNIT_OBSTACLE_WALL      ="#";
	// барикадите могат да бъдат разрушавани, за да се освободи пътят
	private static final String UNIT_OBSTACLE_BARRICADE ="$";
	
	private static final String UNIT_TERRAIN_PLACEHOLDER="*";
	// при ред на даден играч полетата, на които той може да се премести, ще се означат с 'Х'-ове
	private static final String UNIT_TERRAIN_CONQUERABLE="X";
	
    private static int obstacleAmount=0;
    private static int turnCounter   =0;
    
    public static int redPlayerPointsTally  =0;
    public static int blackPlayerPointsTally=0;

    private static int redDeadUnitsCounter  =0; // 🤠
    private static int blackDeadUnitsCounter=0;
    private static String redDeadUnitsInChronologicalOrder  ="";
    private static String blackDeadUnitsInChronologicalOrder="";
	
	public static String[][] bootstrapGameBoard()
	{
		// тук ми е необходима помощ, че съвсем ги омутах типовете на методите xd
		String[][] gameBoard=new String[GAMEBOARD_ROW_COUNT][GAMEBOARD_COL_COUNT];
		
		gameBoard=generateTerrain(gameBoard);
		
        blackPlayerStartingPhase(gameBoard);
        System.out.println();
        redPlayerStartingPhase(gameBoard);
        
        generateObstacles(gameBoard);
        
        battlePhase(gameBoard);
        
        System.out.println("Изберете дали ще почвате нова игра или ще приключвате текущата игрова сесия.");
        System.out.println("1. Нова игра");
        System.out.println("2. Приключване на текуща игрова сесия");
        System.out.print("Въведете вашия избор тук: ");
        int input=Integer.parseInt(scanner.nextLine());
        if(input==1)
        	bootstrapGameBoard();
        else
            return gameBoard;
		
		return gameBoard;
	}
	
	public static void renderGameBoard(String[][] gameBoard)
	{
		System.out.println("    1     2     3     4     5     6     7     8     9  < колони");
		for(int row=0; row<GAMEBOARD_ROW_COUNT; row++)
		{
			System.out.print(row+1);
			for(int col=0; col<GAMEBOARD_COL_COUNT; col++)
			{
				System.out.print(" | "+gameBoard[row][col]+" |");
			}
			
			if(row==0 || row==1)
				System.out.print(" 👿 Замъкът на червените 👿");
			else if(row==2 || row==3 || row==4)
				System.out.print("    ⚡⚡ Бойно поле ⚡⚡");
			else if(row==5 || row==6)
				System.out.print("  🐵 Замъкът на черните 🐵");
			
			System.out.println();
		}
		System.out.println("^"+"\n"+"редове");
	}
	
	private static String[][] generateTerrain(String[][] gameBoard)
	{
		for(int row=0; row<GAMEBOARD_ROW_COUNT; row++)
		{
			for(int col=0; col<GAMEBOARD_COL_COUNT; col++)
			{
				gameBoard[row][col]=UNIT_TERRAIN_PLACEHOLDER;
			}
		}
		return gameBoard;
	}
	
    private static void blackPlayerStartingPhase(Assets[][] gameBoard)
    {
    	int unitKnightAvailable=2;
        int unitElfAvailable   =2;
        int unitDwarfAvailable =2;
        while(unitKnightAvailable>0 || unitElfAvailable>0 || unitDwarfAvailable>0) 
        {
            System.out.println("Изберете тип фигура, която да поставите във вашия замък.");
            System.out.println("1. Рицар"+"\t"+"Имате "+unitKnightAvailable+" оставащи рицари в арсенала си.");
            System.out.println("2. Елф"+"\t"+"Имате "+unitElfAvailable+" оставащи елфи в арсенала си.");
            System.out.println("3. Джудже"+"\t"+"Имате "+unitDwarfAvailable+" оставащи джуджета в арсенала си.");
            System.out.print("Въведете вашия избор тук: ");
            int command=Integer.parseInt(scanner.nextLine());
            String unitSymbol=" ";
            if(command==1 && unitKnightAvailable!=0) 
            {
                unitSymbol="%";
                generateUnits(unitSymbol, gameBoard, UnitColour.BLACK);
                unitKnightAvailable--;
            }
            else if(command==2 && unitElfAvailable!=0) 
            {
                unitSymbol="&";
                generateUnits(unitSymbol, gameBoard, UnitColour.BLACK);
                unitElfAvailable--;
            }
            else if(command==3 && unitDwarfAvailable!=0) 
            {
                unitSymbol="@";
                generateUnits(unitSymbol, gameBoard, UnitColour.BLACK);
                unitDwarfAvailable--;
            }
        }
    }
	
    private static void redPlayerStartingPhase(Assets[][] gameBoard)
    {
        int unitKnightAvailable=2;
        int unitDwarfAvailable =2;
        int unitElfAvailable   =2;
        while (unitKnightAvailable>0 || unitElfAvailable>0 || unitDwarfAvailable>0) 
        {
        	System.out.println("Изберете тип фигура, която да поставите във вашия замък.");
            System.out.println("1. Рицар"+"\t"+"Имате "+unitKnightAvailable+" оставащи рицари в арсенала си.");
            System.out.println("2. Елф"+"\t"+"Имате "+unitElfAvailable+" оставащи елфи в арсенала си.");
            System.out.println("3. Джудже"+"\t"+"Имате "+unitDwarfAvailable+" оставащи джуджета в арсенала си.");
            String unitSymbol=" ";
            int command=Integer.parseInt(scanner.nextLine());
            if(command==1 && unitKnightAvailable!=0) 
            {
                unitSymbol="%";
                generateUnits(unitSymbol, gameBoard, UnitColour.RED);
                unitKnightAvailable--;
            }
            else if(command==2 && unitElfAvailable!=0) 
            {
                unitSymbol="&";
                generateUnits(unitSymbol, gameBoard, UnitColour.RED);
                unitElfAvailable--;
            }
            else if(command==3 && unitDwarfAvailable!=0) 
            {
                unitSymbol="@";
                generateUnits(unitSymbol, gameBoard, UnitColour.RED);
                unitDwarfAvailable--;
            }
        }
    }

    private static void generateUnits(String unitSymbol, Assets[][] gameBoard, UnitColour colour){
    	int row=Console.input("Въведете ROW позиция");
        int col=Console.input("Въведете COL позиция");
        
        if(unitSymbol.equals("%"))
        {
            Knight knight=new Knight(row, col, colour);
            gameBoard[row][col]=knight;
        }
        else if(unitSymbol.equals("&"))
        {
            Elf elf=new Elf(row, col, colour);
            gameBoard[row][col]=elf;
        }
        else if(unitSymbol.equals("@"))
        {
            Dwarf dwarf=new Dwarf(row, col, colour);
            gameBoard[row][col]=dwarf;
        }
    }
    
    private static void generateObstacles(String[][] gameBoard)
    {
        for (int row=2; row<5; row++)
        {
            for (int col=0; col<GAMEBOARD_COL_COUNT; col++)
            {
                int randomNumber=Dice.generateObstacle();
                if(randomNumber==3 && obstacleAmount<5)
                {
                    int obstacleType=Dice.decideObstacleType();
                    if(obstacleType==1) // трябва да се довърше spawn-ването на препятствия
                    {
                    	
                        gameBoard[row][col]=UNIT_OBSTACLE_BARRICADE;
                        obstacleAmount++;
                    }
                    else if(obstacleType==2)
                    {
                    	
                        gameBoard[row][col]=UNIT_OBSTACLE_WALL;
                        obstacleAmount++;
                    }
                }
            }
        }
        
        if(obstacleAmount==1)
        {
            int row=0;
            int col=0;
            
            gameBoard[row][col]=UNIT_OBSTACLE_WALL;
        }
    }
    
    private static void battlePhase(Assets[][] gameBoard)
    {
        System.out.println("Ред е на черния играч.");
        menu(gameBoard, UnitColour.BLACK);
        
        System.out.println("Ред е на червения играч.");
        menu(gameBoard, UnitColour.RED);
        
        if(redDeadUnitsCounter==6)
        {
            System.out.println("Черният играч печели!");
            endOfGameStats(UnitColour.BLACK);
            return;
        }
        else if(blackDeadUnitsCounter==6)
        {
        	System.out.println("Червеният играч печели!");
            endOfGameStats(UnitColour.RED);
            return;
        }
        
        turnCounter++;
        battlePhase(gameBoard);
    }
    
    private static void menu(Assets[][] gameBoard, UnitColour colour)
    {
    	System.out.println("Изберете бойно действие.");
        System.out.println("1. Премести избраната фигура");
        System.out.println("2. Атакувай с избраната фигура");
        System.out.println("3. Излекувай избраната фигура");
        System.out.println("4. Унищожаване на препятствие");
        System.out.println("5. Статистика на избраната фигура");
        System.out.print("Въведете вашия избор тук: ");
        int command=Integer.parseInt(scanner.nextLine());
        if(command==1)
            moveUnit(gameBoard);
        else if(command==2)
            attackUnit(gameBoard,colour);
        else if(command==3)
            healUnit(gameBoard);
        else if(command==4) // трябва да се имплементира *същинско* унищожаване на препятсвията, тъй като това е placeholder метод засега
        	destroyObstacle(gameBoard);
        else if(command==5)
            unitStats(colour);
    }
    
    // if(command==1)
    private static void moveUnit(Assets[][] gameBoard)
    {
        int currentUnitRow=Console.input("Въведете реда, на който фигурата, която искате да преместите, се намира в момента: ");
        int currentUnitCol=Console.input("Въведете колоната, на която фигурата, която искате да преместите, се намира в момента: ");
        Assets currentUnitPosition=gameBoard[currentUnitRow][currentUnitCol];
        
        UnitDirections movementCommand=Console.direction("Въведете на коя посока искате да преместите избраната фигура.");
        int newUnitRow=Console.input("Въведете реда, на който искате да преместите избраната фигурата: ");
        int newUnitCol=Console.input("Въведете колоната, на която искате да преместите избраната фигурата: ");
        
        if(currentUnitPosition.isMovePossible(movementCommand, newUnitRow, newUnitCol))
        {
            gameBoard[currentUnitRow][currentUnitCol]=null; // премахваме данните за позицията на избраната фигура преди самото преместване
            currentUnitPosition.move(newUnitRow, newUnitCol); // придвижваме избраната фигура
            gameBoard[newUnitRow][newUnitCol] = currentUnitPosition; // обновяваме данните за позицията на избраната фигура след преместването
        }
        else 
            System.out.println("Нямате право да преместите избраната фигура там!");
    }
    
    // допълнение към метода за атакуване
    private static void deathUnit(UnitColour colour, int enemySelectedRow, int enemySelectedCol, Assets[][] gameBoard)
    {
        String unitName="";
        
        if(colour==UnitColour.RED) // трябва да се довърши
        {
           
            redDeadUnitsInChronologicalOrder+=unitName+" ";
            redDeadUnitsCounter++;
        }
        else if(colour==UnitColour.BLACK) // трябва да се довърши
        {
          
            blackDeadUnitsInChronologicalOrder+=unitName+" ";
            blackDeadUnitsCounter++;
        }
    }
    
    // else if(command==2)
    private static void attackUnit(Assets[][] gameBoard,UnitColour colour)
    {
    	int attackingUnitRow=Console.input("Въведете реда, на който фигурата, с която искате да атакувате противника, се намира в момента: ");
        int attackingUnitCol=Console.input("Въведете колоната, на която фигурата, скоято искате да атакувате противника, се намира в момента: ");
        Assets attackingUnitPosition=gameBoard[attackingUnitRow][attackingUnitCol];
        
        System.out.println("Въведете координатите на противника, комуто искате да атакувате.");
        int enemyUnitRow=Console.input("Въведете реда, на който противниковата фигура се намира в момента: ");
        int enemyUnitCol=Console.input("Въведете колоната, на която противниковата фигура се намира в момента: ");
        Assets enemyPosition = gameBoard[enemyUnitRow][enemyUnitCol];
        
        if(attackingUnitPosition.isAttackPossible(enemyUnitRow, enemyUnitCol)) 
        {
            int firstDiceThrow =Dice.diceOffenseAndHeal();
            int secondDiceThrow=Dice.diceOffenseAndHeal();
            int thirdDiceThrow =Dice.diceOffenseAndHeal();
            int diceThrowSum=firstDiceThrow+secondDiceThrow+thirdDiceThrow;
            if(diceThrowSum==enemyPosition.health)
                System.out.println(Console.missedAttackWarning());
            else if(diceThrowSum==3)
            {
                int damage=(attackingUnitPosition.attack-enemyPosition.armour)/2;
                enemyPosition.health-=damage;
                
                if(colour==UnitColour.RED)
                    redPlayerPointsTally+=damage;
                else if(colour==UnitColour.BLACK)
                    blackPlayerPointsTally+=damage;
                
                gameBoard[enemyUnitRow][enemyUnitCol]=enemyPosition;
            }
            else 
            {
                int damage=attackingUnitPosition.attack-enemyPosition.armour;
                enemyPosition.health-=damage;
                
                if(colour==UnitColour.RED)
                    redPlayerPointsTally+=damage;
                else if(colour==UnitColour.BLACK)
                    blackPlayerPointsTally+=damage;
                
                gameBoard[enemyUnitRow][enemyUnitCol]=enemyPosition;
            }
            
            if (enemyPosition.health<=0)
            {
                if(colour==UnitColour.RED)
                    deathUnit(UnitColour.BLACK,enemyUnitRow,enemyUnitCol,gameBoard);
                else
                    deathUnit(UnitColour.RED,enemyUnitRow,enemyUnitCol,gameBoard);
            }
        }
        else 
            System.out.println("Не можете да атакувата избраната противникова фигура!");
    }
    
    // else if(command==3)
    private static void healUnit(Assets[][] gameBoard)
    {
    	int currentUnitRow=Console.input("Въведете реда, на който фигурата, която искате да излекувате, се намира в момента: ");
        int currentUnitCol=Console.input("Въведете колоната, на която фигурата, която искате да излекувате, се намира в момента: ");
        Assets currentUnitPosition=gameBoard[currentUnitRow][currentUnitCol];
        
        int healDice=Dice.diceOffenseAndHeal();
        currentUnitPosition.health+=healDice;
    }
    
    // else if(command==4)
    private static void destroyObstacle(Assets[][] gameBoard) 
    {
    	
    }
    
    // else if(command==5)
    private static void unitStats(UnitColour colour)
    {
    	int currentUnitRow=Console.input("Въведете реда, на който фигурата, чиито статистики искате да прегледате, се намира в момента: ");
        int currentUnitCol=Console.input("Въведете колоната, на която фигурата, чиито статистики искате да прегледате, се намира в момента: ");
        
        if(colour==UnitColour.RED) // трябва да се довърши
        {
           
        }
        else if(colour==UnitColour.BLACK) // трябва да се довърши
        {
          
        }
    }
    
    private static void endOfGameStats(UnitColour colour)
    {
        if(colour==UnitColour.RED) 
        {
            System.out.println("Статистиките на червения играч са:");
            System.out.println("Общо редове: "+turnCounter);
            System.out.println("Общ брой точки: " + redPlayerPointsTally);
            System.out.println("Паднали фигури в хронологичен ред: "+redDeadUnitsInChronologicalOrder);
            System.out.println();
            System.out.println("Общ брой точки на черния играч: "+blackPlayerPointsTally);
            System.out.println("Паднали фигури на черния играч в хронологичен ред: "+blackDeadUnitsInChronologicalOrder);
        }
        else if(colour==UnitColour.BLACK)
        {
            System.out.println("Статистиките на черния играч са:");
            System.out.println("Общо редове: "+turnCounter);
            System.out.println("Общ брой точки: "+blackPlayerPointsTally);
            System.out.println("Паднали фигури в хронологичен ред: "+blackDeadUnitsInChronologicalOrder);
            System.out.println();
            System.out.println("Общ брой точки на червения играч: " + redPlayerPointsTally);
            System.out.println("Паднали фигури на червения играч в хронологичен ред: "+redDeadUnitsInChronologicalOrder);
        }
    }
}
