import java.util.Scanner;
import java.util.Random;

public class Game {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int score = 0;
        int round = 1;

        System.out.println("🎯 Welcome to the Number Guessing Game!");

        boolean playAgain = true;

        while (playAgain) {
            System.out.println("\n🔁 Round " + round);
            int secretNumber = rand.nextInt(100) + 1; // 1 to 100
            int attempts = 0;
            int maxAttempts = 5;
            boolean guessedCorrectly = false;

            while (attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + "/" + maxAttempts + " - Enter your guess (1 to 100): ");
                
                // Check if input is a number
                if (!sc.hasNextInt()) {
                    System.out.println("⛔ Please enter a valid number!");
                    sc.next(); // Clear wrong input
                    continue;
                }

                int guess = sc.nextInt();
                attempts++;

                if (guess == secretNumber) {
                    System.out.println("✅ Correct! You guessed it in " + attempts + " attempts.");
                    score++;
                    guessedCorrectly = true;
                    break;
                } else if (guess < secretNumber) {
                    System.out.println("📉 Too low!");
                } else {
                    System.out.println("📈 Too high!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("❌ Sorry! The correct number was: " + secretNumber);
            }

            System.out.print("🔄 Do you want to play another round? (yes/no): ");
            sc.nextLine(); // Clear buffer
            String response = sc.nextLine().toLowerCase();

            if (!response.equals("yes")) {
                playAgain = false;
            } else {
                round++;
            }
        }

        System.out.println("\n🏁 Game Over!");
        System.out.println("You played " + round + " round(s) and won " + score + " time(s).");
        System.out.println("Thanks for playing! 🙌");

        sc.close();
    }
}
