package control_flow.assignment_problems;

public class GuessTheNumberGame {

    static void guessTheNumber(int secretNumber, int maxTries, int[] guesses) {
        int tryCount = 0;
        boolean guessedCorrectly = false;

        while (tryCount < maxTries && tryCount < guesses.length && !guessedCorrectly) {
            int guess = guesses[tryCount];
            if (guess > secretNumber) {
                System.out.println("Too high");
            } else if (guess < secretNumber) {
                System.out.println("Too low");
            } else {
                guessedCorrectly = true;
                System.out.println("Correct! You guessed it");
                break;
            }
            tryCount++;
        }

        if (!guessedCorrectly) {
            System.out.println("Out of tries - the number was " + secretNumber);
        }
    }

    public static void main(String[] args) {
        guessTheNumber(42, 4, new int[]{20, 60, 42});
    }
}