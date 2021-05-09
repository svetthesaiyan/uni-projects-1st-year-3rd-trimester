package week_5_exercises;

public class SelectionSort 
{
	public static int[] sort(int[] collection)
	{
		for(int numberOfTrial=0; numberOfTrial<collection.length; numberOfTrial++)
		{
			int leftHandWeightPosition =numberOfTrial;
			int leftHandWeight		   =collection[numberOfTrial];
			
			int rightHandWeightPosition=0;
			int rightHandWeight		   =collection[0];
			
			for(int weightPosition=numberOfTrial; weightPosition<collection.length; weightPosition++)
			{
				rightHandWeightPosition=weightPosition;
				rightHandWeight		   =collection[weightPosition];
				
				if(leftHandWeight>rightHandWeight)
				{
					leftHandWeight		  =rightHandWeight;
					leftHandWeightPosition=rightHandWeightPosition;
				}
			}
			int currentElementValue			   =collection[numberOfTrial];
			collection[numberOfTrial]		   =leftHandWeight;
			collection[leftHandWeightPosition] =currentElementValue;
			
//			collection[leftHandWeightPosition] =rightHandWeight;
//			collection[rightHandWeightPosition]=leftHandWeight;
		}
		return collection;
	}
}
