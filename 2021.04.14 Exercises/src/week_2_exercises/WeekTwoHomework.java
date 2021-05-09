package week_2_exercises;

import java.util.Scanner;

public class WeekTwoHomework 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		// деклариране на константи, с които ще разпределим гласуващите спрямо ЕГН-тата им
		final int poorBorder=99;	
		final int normalBorder=100_000;
		final int richBorder=999_999;
		
		// въвеждане на ЕГН и деклариране на булеви параметри
		System.out.print("Здравейте, драги съграждани! Днес ще можете да гласувате за пореден път за нашата парт-, ъъъ, за бъдещето на великата ни държава Замунда. За да преценим кои вотове да си присво-, *cough* ...За да *осигурим* честни избори, ще Ви помолим да си въведете годишния дохо-, имам в предвид ЕГН-тата преди да гласувате."+"\n"+"Може да въведете Вашето ЕГН тук: " );
		int id=Integer.parseInt(scanner.nextLine());
		boolean isCitizenOfTypePoor=id>poorBorder && id<normalBorder;
		boolean isCitizenOfTypeNormal=id>=normalBorder && id <=richBorder;
		boolean isCitizenOfTypeRich=id>richBorder && isCitizenOfTypePoor==false && isCitizenOfTypeNormal==false;
		
		// изход спрямо въведеното ЕГН и наложените му булеви параметри
		String citizenType=isCitizenOfTypePoor ? "Хайде по-бързо и да те няма."
				: isCitizenOfTypeNormal ? "Радваме се, че нормални хора вече гласуват."
						: isCitizenOfTypeRich ? "Има за нас, има и за вас."
								: "Кой за Бога пък сте Вие?";
		System.out.println(citizenType);
		System.out.println();
		
		// изброяване на избираемите партии и избор
		System.out.println("Сега предстои най-интересната част, а именно да видим от чия партия ще открадн-, *cough* ... за коя партия ще гласувате."+"\n"+"Може да да дадете Вашия вот за една от следните партии: ");
		System.out.println("Номер на партия (1)   - \"Партия за прогресивен канибализъм\"");
		System.out.println("Номер на партия (27)  - \"Замундска вегетарианска партия\"");
		System.out.println("Номер на партия (666) - \"Синдикат на вуду-трактористите\"");
		System.out.println("Номер на партия (999) - \"Партия на труда, мотиката и наковалнята\"");
		
		System.out.print("Та, за коя партия ще гласувате? Въведете партийния ѝ номер тук: ");
		int partyNumberInput=Integer.parseInt(scanner.nextLine());
		String partyNumberName=partyNumberInput==1 ? "Партия за прогресивен канибализъм"
				: partyNumberInput==27 ? "Замундска вегетарианска партия"
						: partyNumberInput==666 ? "Синдикат на вуду-трактористите"
								: partyNumberInput==999 ? "Партия на труда, мотиката и наковалнята"
										: "никого, защото не можете да запомните 4 числа. Баси малоумника... 🤦🏻‍♂️";
		System.out.println("Вие си поръчахте да Ви управлява: "+partyNumberName);
		System.out.println();
		
		// деклариране на условие за ВИП гласуващ
		boolean isCitizenVip=(id%10)%2==0;
		// деклариране на условие за проверка за укрити данъци
		boolean isCitizenPossibleTaxEvader=(id%100)/10>3;
		
		// деклариране на главна условна конструкция за проверка за укрити данъци
		if(isCitizenPossibleTaxEvader==true)
		{
		System.out.print("Сега ще Ви помолим да бъдете честни с нас. Укривате ли данъци? "+"\n"+"Отговорете с \"да\" или \"не\": ");
		String taxEvaderConfession=scanner.nextLine();
		String taxEvaderConfessionType=taxEvaderConfession.equalsIgnoreCase("да") ? "Браво, моето момче/момиче."
				: taxEvaderConfession.equalsIgnoreCase("не") ? "Будала."
						: "Значи, или въведохте отговора си на език, различен от български, или се опитвате да смените темата. Каквото и да правите, няма да Ви мине номерът, господине!";
		System.out.println(taxEvaderConfessionType);
		System.out.println();
		
		boolean isCitizenSuperVip=isCitizenVip && taxEvaderConfession.equalsIgnoreCase("не");
			
			// деклариране на второстепенна условна конструкция за желание за баница
			if(isCitizenSuperVip==true)
			{
				System.out.print("Виждаме, че сте почтен гражданин, браво. Желаете ли безплатна баничка като награда? "+"\n"+"Отговорете с \"да\" или \"не\": ");
				String CitizenBanichkaRequest=scanner.nextLine();	// наглед ползвам PascalCase стандарта за именуване на променливи тук, но тъй като при всички останали променливи, включващи думичката "Citizen", тя е написана с главна, реших и тази променлива така да я именувам. Дано не ми анулирате домашното за това. ☹
				String CitizenBanichkaRequestType=CitizenBanichkaRequest.equalsIgnoreCase("да") ? "Не може."
						: CitizenBanichkaRequest.equalsIgnoreCase("не") ? "Ами, то и без това няма."
								: "Пак се опитвате да хитрувате, а?";
				System.out.println(CitizenBanichkaRequestType);
				System.out.println();
				
				// деклариране на третостепенна условна конструкция за напомняне на дадения гражданин, че ако положението е зле, то винаги може да стана още по-зле. 😌
				if(CitizenBanichkaRequest.equalsIgnoreCase("не") && isCitizenOfTypeNormal==true && partyNumberInput==27)
				{
					System.out.println("Животът е жесток понякога и, за съжаление, трябва да Ви информираме, че ни дължите данък от един банан. Дайте банана или насилствено ще Ви вземем препуциума. 🍆✂");
					System.out.println();
				}
			}
		}
		// край на програмата с поздрав, който непременно трябва да си пуснете, ако се считате за кадърен програмист
		System.out.println("Надяваме се крайкожието Ви да е непокътнато, но дори и да сме Ви го конфискували, надяваме се с този поздрав да Ви оправим настроението: https://www.youtube.com/watch?v=dQw4w9WgXcQ");
	}
}
