package week_5_homework;

import java.util.Random;
import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Въведете колко на брой числа ще въвеждате: ");
		int length=Integer.parseInt(scanner.nextLine());
		int[] array=new int[length];
		double arraySum=0;
		double iCounter=0;
		
		for(int i=0; i<array.length; i++)
		{
			System.out.print("Въведете число №"+(i+1)+": ");
			array[i]=scanner.nextInt();
			arraySum+=array[i];
			iCounter++;
		}
		System.out.println();

		System.out.println("Изберете какво искате да направя с въведените от Вас числа:"+"\n"+"1.  Сортиране на въведените числа във възходящ ред"+"\n"+"2.  Сортиране на въведените числа в низходящ ред"+"\n"+"3.  Търсене на позиция на конкретно число"+"\n"+"4.  Разбъркване на числата"+"\n"+"5.  Изчисляване на сбора на всички числа"+"\n"+"6.  Намиране на най-голямото число"+"\n"+"7.  Намиране на най-малко число"+"\n"+"8.  Намиране средно-аритметично на числата"+"\n"+"9.  Проверка за симетричност на масива от числа"+"\n"+"10. Обръщане на масива от числа"+"\n"+"11. Визуализирай въведените числа"+"\n"+"12. Изход");
		System.out.print("Вашият избор е: ");
		int input=scanner.nextInt();
		System.out.println();
		
		// СОРТИРАНЕ НА ВЪВЕДЕНИТЕ ЧИСЛА ВЪВ ВЪЗХОДЯЩ РЕД
		if(input==1)
		{
		      for(int i=0; i<(length-1); i++) 
		      {
		        for(int j=0; j<(length-i-1); j++) 
		        {
		          if(array[j]>array[j+1]) 
		          {
		             int temp=array[j];
		             array[j]=array[j+1];
		             array[j+1]=temp;
		          }
		        }
		      }
		   
		      System.out.print("Числата, които въведохте, подредени по възходящ ред, биха изглеждали така: ");
		      for (int i=0; i<array.length; i++)   
		      {  
		    	  if(i<(array.length-1))
		    		  System.out.print(array[i]+", ");  
		    	  else
		    		  System.out.print(array[i]);
		      } 
		}
		
		// СОРТИРАНЕ НА ВЪВЕДЕНИТЕ ЧИСЛА В НИЗХОДЯЩ РЕД
		else if(input==2)
		{
			for(int i=0; i<(length-1); i++) 
		      {
		        for(int j=0; j<(length-i-1); j++) 
		        {
		          if(array[j]<array[j+1]) 
		          {
		             int temp=array[j];
		             array[j]=array[j+1];
		             array[j+1]=temp;
		          }
		        }
		      }
		   
		      System.out.print("Числата, които въведохте, подредени по низходящ ред, биха изглеждали така: ");
		      for (int i=0; i<array.length; i++)   
		      {  
		    	  if(i<(array.length-1))
		    		  System.out.print(array[i]+", ");  
		    	  else
		    		  System.out.print(array[i]);
		      } 
		}
		
		// ТЪРСЕНЕ НА ПОЗИЦИЯТА НА КОНКРЕТНО ЧИСЛО
		else if(input==3)
		{
			System.out.print("Въведете числото, което търсите: ");
			int element=scanner.nextInt();
			int index=LinearSearch.isAvailable(array, element);
			
//			if(<не знам какво трябва да въведа като аргумент за условната конструкция, че да има 2 случая>)
//			{
			System.out.print("Числото "+element+" е намерено на позиция: "+(index+1)+".");
//			}
//			else
//			{
//				System.out.print("Числото "+element+" не е намерено.");
//			}
		}
		
		// РАЗБЪРКВАНЕ НА ЧИСЛАТА
		else if(input==4)
		{
			Random random = new Random();  // Random number generator			
			 
			for (int i=0; i<array.length; i++) 
			{
			    int randomPosition=random.nextInt(array.length);
			    int temp=array[i];
			    array[i]=array[randomPosition];
			    array[randomPosition]=temp;
			}
			    
			   System.out.print("Числата, които въведохте, но разбъркани на произволен принцип, биха изглеждали така: ");
			   for (int i=0; i<array.length; i++)   
			   {  
				   if(i<(array.length-1))
					   System.out.print(array[i]+", ");  
				   else
					   System.out.print(array[i]);
				} 
		}
		
		// ИЗЧИСЛЯВАНЕ НА СБОРА НА ВСИЧКИ ЧИСЛА
		else if(input==5)
		{
			System.out.print("Сумата на числата, които въведохте, е: "+arraySum);
		}
		
		// НАМИРАНЕ НА НАЙ-ГОЛЯМОТО ЧИСЛО
		else if(input==6)
		{
			for(int i=0; i<length; i++) 
		      {
		        for(int j=i+1; j<length; j++) 
		        {
		          if(array[i]>array[j]) 
		          {
		             int temp=array[i];
		             array[i]=array[j];
		             array[j]=temp;
		          }
		        }
		      }
			
			System.out.print("Най-голямото число от тези, които въведохте, е: "+array[length-1]);
		}
		
		// НАМИРАНЕ НА НАЙ-МАЛКОТО ЧИСЛО
		else if(input==7)
		{
			for(int i=0; i<length; i++) 
		      {
		        for(int j=i+1; j<length; j++) 
		        {
		          if(array[i]<array[j]) 
		          {
		             int temp=array[i];
		             array[i]=array[j];
		             array[j]=temp;
		          }
		        }
		      }
			
			System.out.print("Най-малкото число от тези, които въведохте, е: "+array[length-1]);
		}
		
		// НАМИРАНЕ СРЕДНО-АРИТМЕТИЧНО НА ЧИСЛАТА
		else if(input==8)
		{
			System.out.printf("Средно-аритметично на числата, които въведохте, е: %.2f", (arraySum/iCounter));
		}
		
		// ПРОВЕРКА ЗА СИМЕТРИЧНОСТ НА МАСИВА ОТ ЧИСЛА
		else if(input==9)
		{
			int i=0;
			while(i<length && array[i]==array[array.length-1-i])
				i++;
			
			if(i==array.length/2)
				System.out.print("Масивът е симетричен.");
			else
				System.out.print("Масивът не е симетричен.");
		}
		
		// ОБРЪЩАНЕ НА МАСИВА ОТ ЧИСЛА
		else if(input==10)
		{
			for (int i=0; i<array.length/2; i++) 
			{
				int temp=array[i];
				array[i]=array[array.length-i-1];
				array[array.length-i-1] = temp;
			}
  
        System.out.print("Числата, които въведохте, но обърнати наобратно, биха изглеждали така: ");
	        for (int i=0; i<array.length; i++)   
			{  
				if(i<(array.length-1))
					System.out.print(array[i]+", ");  
				else
					System.out.print(array[i]);
			}
		}
		
		// ВИЗУАЛИЗИРАЙ ВЪВЕДЕНИТЕ ЧИСЛА
		else if(input==11)
		{
			System.out.print("Числата, които въведохте, са: ");
			for (int i=0; i<array.length; i++)   
			{  
				if(i<(array.length-1))
					System.out.print(array[i]+", ");  
				else
					System.out.print(array[i]);
			}  
		}
		
		// ИЗХОД ОТ МЕНЬОТО
		else if(input==12)
		{
			System.out.print("Дано да съм Ви бил от полза. ☺");
			System.exit(0);
		}
	}
}
