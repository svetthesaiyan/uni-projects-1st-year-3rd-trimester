package week_1_exercises;

public class a_refresher 
{
	public static void main(String[] args) 
	{
		int number_of_rounds=4;
		
		int first_round_question_count=10;
		int second_round_question_count=7;
		int third_round_question_count=5;
		int fourth_round_question_count=1;
		int total_number_of_questions=23;
		int total_number_of_next_week_questions=total_number_of_questions;
		double money_prize=(int) 1205.75;
		float money_prize_next_week=500.50f;
		double money_prize_this_year=100000;
		
		int score_per_question=1;
		
		String show_title="Quizz show";
		
		System.out.println("It is showtime!");
		System.out.println(show_title);
		System.out.println(money_prize_this_year);
		
		int on_or_off=10;
		String yes_or_no="Y";
		
		boolean is_available=true;
		char serial_id='A';
		
		int visitors_on_Monday=1000;
		int visitors_on_Tuesday=2000;
		int visitors_on_Wednesday=3000;
		int visitors_on_Thursday=4000;
		int visitors_on_Friday=5000;
		int[] visitor_collection= {1000, 2000, 3000, 4000, 5000};

		String day_Monday="Monday";
		String day_Tuesday="Tueday";
		String day_Wednesday="Wednesday";
		String day_Thursday="Thursday";
		String day_Friday="Friday";
		String[] day_collection= {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
		
/*
		System.out.println(day_Monday+" - "+visitors_on_Monday);
		System.out.println(day_Tuesday+" - "+visitors_on_Tuesday);
		System.out.println(day_Wednesday+" - "+visitors_on_Wednesday);
		System.out.println(day_Thursday+" - "+visitors_on_Thursday);
		System.out.println(day_Friday+" - "+visitors_on_Friday);
*/
		System.out.print(day_collection[0]);
		System.out.print(" - ");
		System.out.println(visitor_collection[0]);
	}
}
