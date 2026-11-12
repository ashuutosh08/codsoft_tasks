import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 7;
        int totalRounds = 0;
        int roundsWon = 0;
        int totalScore = 0;
        
        System.out.println("==========================================");
        System.out.println("       WELCOME TO THE NUMBER GAME!        ");
        System.out.println("==========================================");
        
        boolean playAgain = true;
        
        while (playAgain) {
            totalRounds++;
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attemptsTaken = 0;
            boolean guessedCorrectly = false;
            
            System.out.println("\n--- Round " + totalRounds + " ---");
            System.out.println("I have generated a number between " + minRange + " and " + maxRange + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess it. Good luck!\n");
            
            while (attemptsTaken < maxAttempts && !guessedCorrectly) {
                System.out.print("Attempt " + (attemptsTaken + 1) + "/" + maxAttempts + " - Enter your guess: ");
                
                // Validate that input is an integer
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input! Please enter a valid whole number.");
                    scanner.next(); // Clear invalid input
                    continue;
                }
                
                int userGuess = scanner.nextInt();
                attemptsTaken++;
                
                if (userGuess < minRange || userGuess > maxRange) {
                    System.out.println("Please keep your guess within the range of " + minRange + " to " + maxRange + ".");
                } else if (userGuess == targetNumber) {
                    guessedCorrectly = true;
                    roundsWon++;
                    // Calculate points: More points for fewer attempts
                    int roundPoints = (maxAttempts - attemptsTaken + 1) * 10;
                    totalScore += roundPoints;
                    System.out.println("\n🎉 Congratulations! You guessed the correct number (" + targetNumber + ") in " + attemptsTaken + " attempts!");
                    System.out.println("You earned " + roundPoints + " points this round.");
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try a higher number.");
                } else {
                    System.out.println("Too high! Try a lower number.");
                }
            }
            
            if (!guessedCorrectly) {
                System.out.println("\n❌ Out of attempts! The correct number was: " + targetNumber);
            }
            
            // Display current scoreboard
            System.out.println("\n--- Current Scoreboard ---");
            System.out.println("Rounds Played: " + totalRounds + " | Rounds Won: " + roundsWon + " | Total Score: " + totalScore);
            
            // Ask user if they want to play another round
            System.out.print("\nDo you want to play another round? (yes/no): ");
            String response = scanner.next().trim().toLowerCase();
            playAgain = response.equals("yes") || response.equals("y");
        }
        
        System.out.println("\n==========================================");
        System.out.println("             GAME OVER!                   ");
        System.out.println("Final Stats -> Rounds Won: " + roundsWon + "/" + totalRounds + " | Final Score: " + totalScore);
        System.out.println("Thank you for playing!");
        System.out.println("==========================================");
        
        scanner.close();
    }
}