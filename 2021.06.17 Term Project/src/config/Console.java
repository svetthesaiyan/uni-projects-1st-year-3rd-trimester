package config;

import java.util.Random;
import java.util.Scanner;

import config.enums.UnitDirections;

public class Console
{
	static Scanner scanner=new Scanner(System.in);
	static Random random=new Random();

	public static int input(String message)
	{
		System.out.print(message+" ");

		return Integer.parseInt(scanner.nextLine());
	}
	
	public static String missedAttackWarning()
	{
		int randomNumber=random.nextInt(5)+1;
		if(randomNumber==1)
			return "Фигурата пропусна целта! 😨";
		else if(randomNumber==2)
			return "Фигурата този рунд не възнамерява да атакува противника... 😐";
		else if(randomNumber==3)
			return "Фигурата е заспала. Моля, оставете я да си поспи малко. 😴";
		else if(randomNumber==4)
			return "Иииииииииииииии... пропуск. 😓";
		
		return "Противникът избяга от обсега на удара на фигурата! 😱";
	}

	public static UnitDirections direction(String message)
	{
		System.out.print(message+" ");
		String movementInput=scanner.nextLine();
		if(movementInput.equalsIgnoreCase("w"))
			return UnitDirections.W;
		else if(movementInput.equalsIgnoreCase("a"))
			return UnitDirections.A;
		else if(movementInput.equalsIgnoreCase("s"))
			return UnitDirections.S;
		else if(movementInput.equalsIgnoreCase("d"))
			return UnitDirections.D;
		
		return UnitDirections.GOTTA_HAVE_A_RETURN_VALUE_SOOO;
	}
}
