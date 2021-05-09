package week_5_exercises;

public class BubbleSort
{
	public static int[] sortAsc(int[] collection)
	{
		return sort(collection, true);
	}
	
	public static int[] sortDesc(int[] collection)
	{
		return sort(collection, false);
	}
	
	private static int[] sort(int[] collection, boolean isAscending) 
	{
		for(int numberOfTrial=0; numberOfTrial<collection.length; numberOfTrial++)
		{
			for(int weightPosition=0; weightPosition<collection.length-1-numberOfTrial; weightPosition++)
			{
				int leftHandWeightPosition =weightPosition;
				int leftHandWeight		   =collection[weightPosition];
				
				int rightHandWeightPosition=weightPosition+1;
				int rightHandWeight		   =collection[weightPosition+1];
				
				boolean isReadyForSwap=(isAscending) ? rightHandWeight<leftHandWeight 
															: rightHandWeight>leftHandWeight;
				
				if(isReadyForSwap)
				{
					collection[leftHandWeightPosition] =rightHandWeight;
					collection[rightHandWeightPosition]=leftHandWeight;
				}
			}
		}
		return collection;
	}
	
}
