package week_1_exercises;

public class WeekOneHomework 
{
	public static void main(String[] args) 
	{
		int facultyNumber=2001261051;
		String firstName="Svetoslav";
		String middleName="Dobromirov";
		
		System.out.println(facultyNumber+" "+firstName+" "+middleName+"\n");
		// или пък: System.out.printf("%d %s %s", faculty_number, first_name, middle_name);
		
		int metallicMachete=15;	// бонус точки за алитерацията? ;)
		int aluminumArmour=10;
		int gasGun=1;
		int timberTank=1;
		int plasticBarrel=1;	
		double leatherSatchel=169.77;
		
		char[] itemNounInitialid= {'M', 'A', 'G', 'T', 'B', 'S'};	// принципно "Танк" в примерната таблица не е форматиран в bold, ама пък уж "всеки един" артикул разполага със сериен код, така че, айде, от мен да мине. ;{
		int[] itemNounLetterQuantityid= {6, 5, 8, 4, 5, 3};		// за сбора на буквите гледам удебелените съществителни имена в примерната таблица, а не думите, както съм ги превел на английски. Включил съм сбора на буквите и на "Tank" за всеки случай. ;]
		

		System.out.printf("%c%d%n", itemNounInitialid[0], itemNounLetterQuantityid[0]);
		System.out.printf("%c%d%n", itemNounInitialid[1], itemNounLetterQuantityid[1]);
		System.out.printf("%c%d%n", itemNounInitialid[2], itemNounLetterQuantityid[2]);
		System.out.printf("%c%d%n", itemNounInitialid[3], itemNounLetterQuantityid[3]);
		System.out.printf("%c%d%n", itemNounInitialid[4], itemNounLetterQuantityid[4]);
		System.out.printf("%c%d%n", itemNounInitialid[5], itemNounLetterQuantityid[5]);
		System.out.println();
		
		String[] itemQualityCollection= {"Metallic", "Aluminum", "Gas", "Timber", "Plastic", "Leather"};
		String[] itemBoldCollection= {"Machete", "Armour", "Gun", "Tank", "Barrel", "Satchel"};
		
		System.out.println(itemQualityCollection[0]+" "+itemBoldCollection[0]+" "+itemQualityCollection[1]+" "+itemBoldCollection[1]+" "+itemQualityCollection[2]+" "+itemBoldCollection[2]+" "+itemQualityCollection[3]+" "+itemBoldCollection[3]+" "+itemQualityCollection[4]+" "+itemBoldCollection[4]+" "+itemQualityCollection[5]+" "+itemBoldCollection[5]);
		System.out.println();
		
		boolean willPassAcademy=true;
		System.out.println("Will the mighty Svet the Saiyan manage to overcome the obstacles this course has in store for him?"+"\n"+"If the word that pops up right underneath this piece of text just so happens to be \"true\" then that's a resounding \"YES\"!");
		System.out.println("↓");
		System.out.println(willPassAcademy+" ←");	// B)
		System.out.println("↑");
		System.out.print("Well, well, well... Would you look at that..."+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n");
		System.out.println("⠛⠛⣿⣿⣿⣿⣿⡷⢶⣦⣶⣶⣤⣤⣤⣀⠀⠀⠀");
		System.out.println("⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡀⠀");
		System.out.println("⠀⠀⠀⠉⠉⠉⠙⠻⣿⣿⠿⠿⠛⠛⠛⠻⣿⣿⣇⠀");
		System.out.println("⠀⠀⢤⣀⣀⣀⠀⠀⢸⣷⡄⠀⣁⣀⣤⣴⣿⣿⣿⣆");
		System.out.println("⠀⠀⠀⠀⠹⠏⠀⠀⠀⣿⣧⠀⠹⣿⣿⣿⣿⣿⡿⣿");
		System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠛⠿⠇⢀⣼⣿⣿⠛⢯⡿⡟");
		System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠦⠴⢿⢿⣿⡿⠷⠀⣿⠀");
		System.out.println("⠀⠀⠀⠀⠀⠀⠀⠙⣷⣶⣶⣤⣤⣤⣤⣤⣶⣦⠃⠀");
		System.out.println("⠀⠀⠀⠀⠀⠀⠀⢐⣿⣾⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀");
		System.out.println("⠀⠀⠀⠀⠀⠀⠀⠈⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀");
		System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠻⢿⣿⣿⣿⣿⠟⠁");
	}
}
