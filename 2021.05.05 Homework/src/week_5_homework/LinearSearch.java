package week_5_homework;

public class LinearSearch
{
		public static int isAvailable(int[] array, int element)
		{
			for(int i=0; i<array.length; i++)
			{
				if(array[i]==element)
					return i;
			}
			return -1;
		}
}
