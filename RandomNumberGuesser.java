/*
 * Class: CMSC203 
 * Instructor: Professor Monshi
 * Description: (Give a brief description for each Class)
 * Due: 09/28/22
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: __Kaan Sen________
*/

import java.util.Scanner; //Imports scanner to accept user inputs

public class RandomNumberGuesser {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in); //Assigns input to scanner to accept user inputs into input variable
		int num, random;		// Integer variable for random integer and user inputed integer. 
		int maxGuess = 7;		//Variable that will keep track of amount of guesses done. 
		String option = "yes"; //Used for when user wants to keep on playing. 
		
		System.out.println("This application generates a random integer "
				+ "\nbetween 1 and 100 and asks the user to guess "
				+ "\nrepeatedly until they guess correctly. ");
		
		int playing = 0;
		
		while(option.equalsIgnoreCase("yes") && playing == 0) //A loop that runs the program when user wants to keep playing.
		{
			if(!option.equalsIgnoreCase("yes")) //If user do not want to play anymore, program breaks.
			{
				break;
			}
			
			RNG.rand();
			random = RNG.rand();  //Calling a method that generates a random integer. 
			
			int highGuess = 100, lowGuess = 1; //Variables that will keep track of low and high guesses.
		
			for(int i = RNG.getCount() + 1; i<=maxGuess; i++) //Loop that controls & keeps track the amount of guess.
			{
				if(i==1)
				{
					System.out.println("\nEnter your first guess: "); //Only displayed on their first guess / beginning of the loop. 
				}
			
				num = input.nextInt(); //Whatever integer the user enters it is saved into the input. 
			
				if(num==random) //if-statement for when user correctly guesses integer. When user integer is equal to random integer. 
				{
					System.out.println("Congratulations, you guessed correctly \nTry again (yes or no)");
					input.nextLine();
					option = input.nextLine();
				
					RNG.resetCount();
				
					if(option.equalsIgnoreCase("no"))	//When user wants to stop playing, program stops after message. 
					{
						System.out.println("Thanks for playing... \n \nProgrammer name: Kaan Sen");
						
					}
					break;
				}
			
				if(num>random)	//When user inputed integer is greater than random number, guess is too high and guess within a range is displayed.
				{
					if(num<highGuess)
					{
						if(i<maxGuess)
						{
							System.out.println("Your guess is too high");
							System.out.println("Number of guesses: " + i);	//Displays the amount of guesses that have been done so far.
							highGuess = num - 1;
							System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess);
						}

					}
					else
					{
						if(i<maxGuess)
						{
							RNG.inputValidation(num, lowGuess, highGuess);
							System.out.println("Number of guesses: " + i);
							System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess);
						}
					}
	
				
				}
				
				if(num<random)	//When user inputed integer is less than random number, guess is too low and guess within a range is displayed.
				{
					if(num>lowGuess)
					{
						if(i<maxGuess)
						{
							System.out.println("Your guess is too low");
							System.out.println("Number of guesses: " + i); //Displays the amount of guesses that have been done so far.
							lowGuess = num + 1;
							System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess);
						}
		
					}
				
					else 
					{
						if(i<maxGuess)
						{
							RNG.inputValidation(num, lowGuess, highGuess);
							System.out.println("Number of guesses: " + i);
							System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess);
						}
					}
	
				}
			
				if(i>=maxGuess)		//When user has reached maximum guesses. Game is over. 
				{
					System.out.println("You have exceeded the maximum number guesses, 7. Try again");
					playing = 1;	//This will break the while loop since game is over after maximum guesses. 
				}
			}
	
		}
			input.close(); //Closes the scanner
	}

}
