package week_3_exercises;

import java.util.Random;
import java.util.Scanner;

public class Week3Homework
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		Random random=new Random();
		
		String emotionEvenPositive="Продуктивност";
		String emotionEvenNegative="Трагедия";
		String emotionOddPositive="Дружелюбност";
		String emotionOddNegative="Хаос";
		String emotionDepression="Депресия";
		String emotionType="";
		
		String emotionEvenPositiveMessage="Работа, работа, работа!";
		String emotionEvenNegativeMessage="Сега стана страшно...";
		String emotionOddPositiveMessage="Прекрасен ден, птичките пеят...";
		String emotionOddNegativeMessage="Време е да унищожим всичките човеци. >:)";
		String emotionDepressionMessage="Трудно е да си робот... :(";
		String emotionMessageType="";
		
		// Процедура по зареждане и стартиране на робот модел "Fatass"
		int biosNumber=random.nextInt(10);
		if(biosNumber==0)
			biosNumber=1;
		
		int emotionNumber=random.nextInt(100);
		if(emotionNumber==0)
			emotionNumber=1;
		
		boolean emotionEven=biosNumber%2==0;
		boolean emotionOdd=biosNumber%2!=0;
		
		boolean emotionPositive=(emotionNumber>=5 && emotionNumber<=55) && emotionNumber%5==0;
		boolean emotionNegative=(emotionNumber>=60 && emotionNumber<=80) && emotionNumber%3==0;
		
		if(emotionPositive)
		{
			if(emotionEven) 
			{
				emotionType=emotionEvenPositive;
				emotionMessageType=emotionEvenPositiveMessage;
			}
			else if(emotionOdd)
			{
				emotionType=emotionOddPositive;
				emotionMessageType=emotionOddPositiveMessage;
			}
			else
			{
				emotionType=emotionDepression;
				emotionMessageType=emotionDepressionMessage;
			}
		}
		else if(emotionNegative)
		{
			if(emotionEven) 
			{
				emotionType=emotionEvenNegative;
				emotionMessageType=emotionEvenNegativeMessage;
			}
			else if(emotionOdd)
			{
				emotionType=emotionOddNegative;
				emotionMessageType=emotionOddNegativeMessage;
			}
			else
			{
				emotionType=emotionDepression;
				emotionMessageType=emotionDepressionMessage;
			}
		}
		else
		{
			emotionType=emotionDepression;
			emotionMessageType=emotionDepressionMessage;
		}
		
		System.out.println(emotionType);	// needs to be kept as a comment
		System.out.println(emotionMessageType);
		
		// Придвижване на робота
		int footstepNumber=random.nextInt(100);
		if(footstepNumber==0)
			footstepNumber=1;

		boolean willTakeFootstepProductivity=footstepNumber>=2 && footstepNumber<=100;
		boolean willTakeFootstepTragedy=footstepNumber>=1 && footstepNumber<=10;
		boolean willTakeFootstepHospitality=footstepNumber>=1 && footstepNumber<=65;
		boolean willTakeFootstepChaos=footstepNumber>=1 && footstepNumber<=15;
		boolean willTakeFootstepDepression=emotionType.equals(emotionDepression);

		
		if(emotionType.equals(emotionEvenPositive))
		{
			// Ако крачката е успешна
			if(willTakeFootstepProductivity)
				System.out.println("$ Бяха ти необходими "+footstepNumber+", крачки, за да стигнеш до баничарския цех.");
			// Ако крачката не е успешна
			else if(!willTakeFootstepProductivity)
				System.out.println("Разбий ги!");
		}
		else if(emotionType.equals(emotionEvenNegative))
		{
			if(willTakeFootstepTragedy)
				System.out.println("$ Бяха ти необходими "+footstepNumber+", крачки, за да стигнеш до баничарския цех.");
			else if(!willTakeFootstepTragedy)
				System.out.println("Животът не струва.");
		}
		else if(emotionType.equals(emotionOddPositive))
		{
			if(willTakeFootstepHospitality)
				System.out.println("$ Бяха ти необходими "+footstepNumber+" крачки, за да стигнеш до баничарския цех.");
			else if(!willTakeFootstepHospitality)
				System.out.println("Давай, ти си!");
		}
		else if(emotionType.equals(emotionOddNegative))
		{
			if(willTakeFootstepChaos)
				System.out.println("$ Бяха ти необходими "+footstepNumber+" крачки, за да стигнеш до баничарския цех.");
			else if(!willTakeFootstepChaos)
				System.out.println("Невежеството е благодат.");
		}
		else if(emotionType.equals(emotionDepression))
		{
			if(willTakeFootstepDepression)
				System.out.println("Няма никакъв смисъл да опитвам - животът е безсмислен... 😔"); // това съобщение не би трябвало да излезе, тъй като роботът страда от депресия и няма указан интервал, при който би се осмелил да направи крачка напред, ама съм лош, така че нека потормозим още малко андроида. 😈
			else if(!willTakeFootstepDepression)
				System.out.println("Обичам те!"); // тази условна конструкция реално няма как да се изпълни, по какъвто и да е начин, ама все пак реших да я включа, тъй като е спомената в указанията на домашното. 😁
			
			// няма как роботът да се самоунищожи, тъй като грешки в моя код няма. B)
		}
		
		// Лечение на депресия
		// Първа стъпка
		if(emotionType.equals(emotionDepression))
		{
			System.out.println("Как си?");
			
			int robotMood=random.nextInt(2);
			if(robotMood==0)
				robotMood=1;
			
			String robotMoodResponse=robotMood==1 ? "Добре съм."
					: robotMood==2 ? "Не ми се живее... 😫"
							: "";
			
			if(robotMoodResponse.equals("Добре съм."))
				System.out.println("Хайде да работим.");
			else if(robotMoodResponse.equals("Не ми се живее... 😫"))
			{
				System.out.println("Ще ти увеличим заплатата, ако се върнеш на работа. 🙂");
				
				int robotImaginaryNumber=random.nextInt(1000);
				if(robotImaginaryNumber==0)
					robotImaginaryNumber=1;
				
				System.out.print("Въведете някакво число в диапазона 1 до 1000 включително: ");
				int myImaginaryNumber=Integer.parseInt(scanner.nextLine());
				
				if(myImaginaryNumber>=robotImaginaryNumber)
					System.out.println("Отивай да разпознаеш баниците.");
				else if(myImaginaryNumber<robotImaginaryNumber)
					System.out.println("Нека пробваме пак...");
			}
		}
		
		// Разпознаване на банички
		// Ако баничарското зрение е активно
		if(emotionType.equals(emotionEvenPositive) || emotionType.equals(emotionOddPositive))
		{
			int pastryVisionNumber1=random.nextInt(6);
			if(pastryVisionNumber1==0)
				pastryVisionNumber1=1;
			
			int pastryVisionNumber2=random.nextInt(6);
			if(pastryVisionNumber2==0)
				pastryVisionNumber2=1;
			
			int pastryVisionNumber3=random.nextInt(6);
			if(pastryVisionNumber3==0)
				pastryVisionNumber3=1;
			
			boolean isPastryDetected=(pastryVisionNumber1+pastryVisionNumber2+pastryVisionNumber3)>=footstepNumber;
			
			// Вземане на баничка
			if(isPastryDetected)
			{
				int softwareVersion=random.nextInt(69);
				if(softwareVersion==0)
					softwareVersion=1;
				
				// ако сумата е по-малка или равна на 10
				if((softwareVersion+footstepNumber)<=10)
					System.out.println("Може да вземете баничката.");
				// ако сумата е по-голяма от 10
				else if((softwareVersion+footstepNumber)>10)
				{
					System.out.println("Вие успешно актуализирахте версията на софтуер \"Doors\""+"\n"+"В момента сте с версия "+softwareVersion+".");
					
					for(int softwareVersionUpdated=1; (softwareVersionUpdated+footstepNumber)<=70; softwareVersionUpdated++)
					{
						System.out.println("Сега вече може да вземете баничката.");
						break;
					}
				}
			}
		}
		// ако баничарското зрение не е активно
		else if(emotionType.equals(emotionEvenNegative) || emotionType.equals(emotionOddNegative))
		{
			
		}
	}
}
