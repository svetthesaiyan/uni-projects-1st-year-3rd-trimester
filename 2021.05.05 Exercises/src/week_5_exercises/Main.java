package week_5_exercises;

public class Main 
{
	public static void main(String[] args) 
	{
		int[] weightCollection= {1, 7, 21, 12, 5, 20, 25, 15, 22};
		
//		BubbleSort.sort(weightCollection, true);	// при 'false' се подреждат числата по низходящ ред
		
		int[] newWeightCollection=BubbleSort.sortAsc(Utility.copyArray(weightCollection));
		Utility.loop(newWeightCollection);	
		System.out.println();
		BubbleSort.sortDesc(newWeightCollection);
		Utility.loop(newWeightCollection);	
		System.out.println();
		System.out.println("New weight collection");
		Utility.loop(newWeightCollection);
		System.out.println();
		System.out.println("Weight Collection");
		Utility.loop(weightCollection);
		System.out.println();
		
		System.out.println("Selection sort");
		int[] selectionSortCollection=SelectionSort.sort(Utility.copyArray(weightCollection));
		Utility.loop(selectionSortCollection);
		System.out.println();
		
		if(BinarySearch.isAvailable(weightCollection, 25))
		{
			System.out.println("The element is available");
		}
		
	}
}
