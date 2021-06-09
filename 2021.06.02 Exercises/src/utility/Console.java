package utility;

import java.util.Scanner;

public class Console
{
	public static int input(String message)
	{
		System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());
        return input;
	}
}
