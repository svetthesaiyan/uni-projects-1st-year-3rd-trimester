package week_2_exercises;

import java.util.Scanner;

public class a_online_bakery 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		final int earlyAdopterBorder=99;	// не съществува клиент със сериен номер по-малък от този
		final int normalBorder=100_000;
		final int laggerBorder=999_999;
		
		System.out.print("Welcome to the world's most advanced online bakery."+"\n"+"Please enter your client card's serial number: ");
		int serialNumber=Integer.parseInt(scanner.nextLine());
		boolean isCustomerOfTypeNormal=serialNumber>=normalBorder && serialNumber<=laggerBorder;
		boolean isCustomerOfTypeLagger=serialNumber>laggerBorder;
		boolean isCustomerOfTypeEarlyAdopter=serialNumber>earlyAdopterBorder && isCustomerOfTypeLagger==false && isCustomerOfTypeNormal==false;	// тази булева променлива трябваше да се въведе последно, тъй като искаме да използваме другите булеви променливи, за да съкратим код. Колко код всъщност успяхме да съкратим е друг върпос, ама както и да е. 😅
		
		// след ":" е все едно "else" при boolean 
		String customerType=isCustomerOfTypeEarlyAdopter ? "\"Early Adopter\""
				: (isCustomerOfTypeLagger) ? "\"Lagger\" (or should I say, loser, lol xDDDDDDD)"
						: (isCustomerOfTypeNormal) ? "\"Normie\""
								: "yo, who tf is this nigga?";
		System.out.println("Customer is of type "+customerType);
		System.out.println();
		
		boolean isCustomerVip1stRequirement=(serialNumber%10)%2==0;
		boolean isCustomerVip2ndRequirement=(serialNumber%100)/10>3;
		
		boolean isCustomerVip=isCustomerVip1stRequirement && isCustomerVip2ndRequirement;
		
		if(isCustomerVip)	// 1ви главен случай, ако клиентът е ViP
		{
		System.out.print("As a ViP guest, you can pick a meal of your choice free of charge."+"\n"+"Enter (1) if you'd like a burger."+"\n"+"Enter (2) if you'd like a salad."+"\n"+"Enter (3) if you'd like a some ice-cream."+"\n"+"Enter the number that corresponds with the food you'd like: ");
		int orderNumber=Integer.parseInt(scanner.nextLine());
		String orderItem=(orderNumber==1)? "burger"
					:orderNumber==2?"salad"
						:orderNumber==3?"ice-cream"
							:"You have input an invalid number for your snack. Please try again";
		System.out.println("You chose to feast on a/some "+orderItem+".");
		System.out.println();
		}
		
		else if (!isCustomerVip)	// 2ри главен случай, ако клиентът не е ViP
		{
			System.out.print("Enter (1) if you'd like a burger."+"\n"+"Enter (2) if you'd like a salad."+"\n"+"Enter (3) if you'd like a some ice-cream."+"\n"+"Enter the number that corresponds with the food you'd like: ");
			int orderNumber=Integer.parseInt(scanner.nextLine());
			String orderItem=(orderNumber==1)? "burger"
					:orderNumber==2?"salad"
							:orderNumber==3?"ice-cream"
								:"You have input an invalid number for your snack. Please try again";
			System.out.println("You chose to feast on a/some "+orderItem+".");
			System.out.println();
			
			double orderItemPrice=(orderNumber==1)? 10.5
					:orderNumber==2?5.8
							:orderNumber==3?2.5
									:0;
			System.out.println("Your order is "+orderItemPrice+" leva.");
		}
	}
}
