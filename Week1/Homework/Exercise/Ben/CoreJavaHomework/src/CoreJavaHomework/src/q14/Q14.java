package CoreJavaHomework.src.q14;

import java.util.ArrayList;
import java.util.Scanner;

public class Q14
{
	public static void main(String[] args)
	{
		//Here, I name the iterator "steven" in case I want to use "i" later.
		for(int steven=1; steven<4; steven++)
		{
			//The program requirements state I must use a switch statement.
			switch(steven)
			{
			//Case 1: Find the square root of a number using Math.
			// No number is given, so I randomly generate one.
			case 1:
				double d = Math.random();
				System.out.println("The square root of " + d + " is " + Math.sqrt(d));
				break;	//It's important to break. Unless it isn't, which is very rare.
			//Case 2: Output the date and time.
			case 2:
				//First, I input the parameters of the Unix Epoch.
				int year = 1970;
				int month = 1;
				int day = 1;
				long hour = 0;
				long minute = 0;
				//Then, I set the current time to now.
				long time = System.currentTimeMillis()/1000;
				//For every 60 seconds, we can convert that into a minute.
				while(time >= 60)
				{
					time -=60;
					minute += 1;
				}
				//For every sixty minutes, 1 hour
				while(minute >= 60)
				{
					minute -=60;
					hour += 1;
				}
				//24 hours in a day
				while(hour >= 24)
				{
					hour -= 24;
					day += 1;
				}
				//Variable number of days in a year
				int monthLength = 31;
				while(day > monthLength)	//Not >= because we can't have the zeroth day of the month.
				{
					day -= monthLength;
					month += 1;
					switch(month%12)
					{
					case 1:	//The behavior is the same for several different months,
					case 3: // so we deliberately don't break across many of them.
					case 5: // This way, we minimize the number of assignment lines
					case 7: // for "monthLength."
					case 8:
					case 10:
					case 0:
						monthLength = 31;
						break;
					case 4:
					case 6:
					case 9:
					case 11:
						monthLength = 30;
						break;
					case 2:		//February
						if((month/12)%4 == 2)	//(Special case for leap years)
						{
							monthLength = 29;
						} else
						{
							monthLength = 28;
						}
						break;
					}
				}
				while(month>12)		//We can't have the zeroth month of the year.
				{
					month-=12;
					year+=1;
				}
				
				//And output the result.
				System.out.println(hour + ":" + minute + ":" + time + " UTC, " + month + "/" + day + "/" + year);
				break;
				
			//Case 3: Split the given string and store it in an array of strings
			case 3:
				final String input = "I am learning Core Java";
				
				//The scanner is a convenient way to split a string using certain delimiters like " "
				Scanner sc = new Scanner(input);
				//The ArrayList is good for holding an arbitrary number of elements.
				ArrayList<String> al = new ArrayList<>();
				
				//As long as the initial string still has stuff in it, put the next word in the arraylist.
				while(sc.hasNext())
				{
					al.add(sc.next());
				}
				//Convert the arraylist to an array, as the requirements call for an array.
				String[] output = new String[al.size()];
				al.toArray(output);
				
				//Output the results of the array to prove you did it.
				for(String yo : output)
				{
					System.out.print(yo + " ");
				}
				
				break;
			}
		}
	}
}