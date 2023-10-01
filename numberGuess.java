import java.util.Random;
import java.util.Scanner;

public class numberGuess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minNumber = 1;
        int maxNumber = 100;
        int maxAttempts = 10;
        int roundsToPlay = 3; 
        int totalAttempts = 0;
        int roundsWon = 0; 

        System.out.println("Welcome to the Number Guessing Game!");

        for (int round = 1; round <= roundsToPlay; round++) {

            int randomNumber = random.nextInt(maxNumber - minNumber + 1) + minNumber;
            int guessCount = 0; 

            System.out.println("\nRound " + round + " - Guess the number between " + minNumber + " and " + maxNumber + ".");

            while (guessCount < maxAttempts) {
                System.out.print("Attempt " + (guessCount + 1) + "/" + maxAttempts + ": Enter your guess: ");
                int userGuess = scanner.nextInt();
                guessCount++;

                if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > randomNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the correct number " + randomNumber + " in " + guessCount + " attempts.");
                    roundsWon++;
                    totalAttempts += guessCount;
                    break;
                }
            }

            if (guessCount == maxAttempts) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was " + randomNumber + ".");
            }
        }

        System.out.println("\nGame Over!");
        System.out.println("Rounds won: " + roundsWon);
        System.out.println("Average attempts per round: " + (totalAttempts / (double) roundsToPlay));

        scanner.close();
    }
}
