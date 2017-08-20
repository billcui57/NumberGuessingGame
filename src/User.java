import java.util.Scanner;

public class User {

	public static void main(String args[]) {
		CFred fred = new CFred(); // introduces object fred from class CFred
		CLog log = new CLog();
		GUI window = new GUI();
		
		
		Scanner input = new Scanner(System.in);

		System.out.println("Welcome to the number guessing game"); // says the lines
		System.out.println("In order to begin, first enter the highest number for Fred to guess");

		fred.maxnum = input.nextInt(); // asks for the maximum guess value
		
		if (fred.maxnum <= 0) { //error management
			System.out.println("Hey dimwit! Are you trying to break me?");
			System.exit(0);
		}

		System.out.printf("Think of a number between 1 and %d inclusive, don't tell Fred! \n", fred.maxnum);
		
		if (fred.maxnum == 1) {	//error management
			System.out.println("Wait...Fred knows the answer to this one...the answer is 1...smart pants");
			System.exit(0);
		}

		System.out.printf("Fred believes that he can guess your number in under %d tries \n",
				(int) Math.ceil((Math.log(fred.maxnum) / Math.log(2))));
		// uses some logarithms to impress the user ;)

		System.out.println("Press any key to continue");
		input.next(); // waits for user input before proceeding

		fred.num = fred.maxnum / 2; // the first number that it is going to guess is half of the value of the
									// maximum.
		// This is by far the most efficient method to find a number known as binary
		// searching

		while (true) { // loops because you cant just guess the right number in one try!

			if (fred.tries > (int) Math.ceil((Math.log(fred.maxnum) / Math.log(2)))) { //makes sure that player isnt cheating
				//For %99.99999999999 percent of the time, the computer is able to get the number in the set amount of tries
				//If the computer is unable to get the number in set amount of tries, the player has to be cheating
				System.out.println("There is no way that this could be happening, are you jesus? Or are you lying????");
				System.out.printf("Your number has to be &d \n", fred.num);
				System.exit(0);

			}

			fred.say(fred.num);
			// the value is returned from the method back into main

			int answer = input.nextInt(); // asks if answer is correct
			if (answer == 1) {
				System.out.printf("Fred won in %d tries! You suck!", fred.tries); // if the answer is correct game stops
	
				
				break;
			} else if (answer == 0) {
				System.out.println("Darn!"); // else if the answer is not correct the computer guesses again
				System.out.printf("Help Fred out here, is your number higher or lower than %d? (Reply 1 for Higher or 0 for Lower) \n",
						fred.num); // asks if number is higher or lower
				int parameter = input.nextInt(); // to create guessing parameters
				fred.guess(parameter); // the number that was guessed is returned

			}

		}
	}
}
