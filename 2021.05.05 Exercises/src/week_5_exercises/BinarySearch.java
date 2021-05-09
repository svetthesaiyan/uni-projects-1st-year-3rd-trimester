package week_5_exercises;

public class BinarySearch 
{
	public static boolean isAvailable(int[] collection, int element)
	{
		int[] newCollection=BubbleSort.sortAsc(Utility.copyArray(collection));
		int leftIndex=0;
		int rightIndex=newCollection.length-1;
		
		while(leftIndex<=rightIndex)
		{
			int middleIndex=(rightIndex+leftIndex)/2;
			
			if(newCollection[middleIndex]==element)
				return true;
			
			if(newCollection[middleIndex]<element)
				leftIndex=middleIndex+1;
			
			if(newCollection[middleIndex]>element)
				rightIndex=middleIndex-1;
		}
		return false;
	}
}
