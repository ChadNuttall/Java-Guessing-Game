// import important extras
import java.util.Random;
import java.util.Scanner;

public class NumberGuessGame {

    public static void main(String[] args) {
        // set upper and lower limits
        int lowerBound = 0;
        int upperBound = 100;
        // determine random number
        Random random = new Random();
        int randNo = random.nextInt(upperBound)+lowerBound;

        // opening script
        System.out.println("Number Guessing Game\n");
        System.out.printf("Guess the number selected between %d - %d!!\n",lowerBound+1,upperBound-1);
        System.out.println("Please Enter a Number:");

        Scanner scan = new Scanner(System.in);
        int playerGuess;

        // logic to determine if guess is correct. Give guidence to narrow search.
        while (true){
            try {
                playerGuess = Integer.parseInt(scan.next());
                if (playerGuess<lowerBound || playerGuess>upperBound){
                    System.out.println("Number given must be within " + lowerBound + " and " + upperBound);
                }
                else if (playerGuess==lowerBound || playerGuess==upperBound){
                    System.out.printf("Wrong input. Pls pick a number between %d and %d again\n",lowerBound,upperBound);
                }
                else if (playerGuess>randNo){
                    upperBound = playerGuess;
                    System.out.printf("The number is between %d and %d \n",lowerBound,upperBound);
                }
                else if(playerGuess<randNo){
                    lowerBound = playerGuess;
                    System.out.printf("The number is between %d and %d \n",lowerBound,upperBound);
                }
                else{
                    System.out.println("You Win!");
                    scan.close();
                    break;
                }
            // Error message if integer not entered or number outside of upper and lower bounds. Game continues.
            } 
            catch (IllegalArgumentException e) {
                System.out.printf("Only integers are accepted between %d and %d. Please Enter a Number:\n",lowerBound,upperBound);
            }
        }
    }
} 

