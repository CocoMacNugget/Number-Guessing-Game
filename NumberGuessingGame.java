package numberguessinggame;

import java.util.Scanner; // Allow user to input 
import java.util.Random; // Allowing the picking of random numbers

/**
 *
 * @author Safiya Elmi
 */
public class NumberGuessingGame {

    public static void main(String[] args) {
        // Initialising the scanner, random number picker and finalScore
        Scanner kbd = new Scanner(System.in); 
        Random random = new Random(); 
        int finalScore = 0; 
        
        System.out.println("Welcome to my number guessing game.");
        System.out.println("In this game you will enter any number of your "
                + "choice between 1 to 100.");
        System.out.println("The program will determine whether your number is "
                + "the same as the hidden number, or higher or lower.");
        System.out.println("You will get only 5 tries.");
        System.out.println("How the point system works:");
        System.out.println("    - Correct number: 10 points.");
        System.out.println("    - Close to the number: 5 points.");
        System.out.println("    - Farther (25 or more numbers away): No points."
                + "");
        System.out.println("You are allowed to play the game for as long as you"
                + " like.");
        System.out.println("When you enter stop. The program will calculate all"
                + " your points and show you your results.");
        
        while (true){
            int hiddenNumber = random.nextInt(100) + 1;
            int score = 0;
            
            for (int attempt = 1; attempt <= 5; attempt++) {
                System.out.println("You have " + (5 - attempt + 1) + " attempts"
                        + " left."); // Remaining attempts
                System.out.println("Attempt" + attempt + "\nEnter your number: "
                        + "");
                
                if (!kbd.hasNextInt()) {
                    String input = kbd.next();
                    if (input.equalsIgnoreCase("stop")) {
                        System.out.println("Game over! Your total score is: " 
                                + finalScore);
                        kbd.close();
                        return;
                    } else {
                        System.out.println("Invalid input. Please enter a "
                                + "number between 1 and 100.");
                        attempt--;
                        continue;
                    }
                }
            
                int guess = kbd.nextInt();
            
                if (guess < 1 || guess > 100) {
                    System.out.println("Please enter a valid number between 1"
                            + " and 100.");
                    attempt--;
                    continue; 
                }
            
                if (guess == hiddenNumber){
                    System.out.println("Congratulation! You guessed right!");
                    score += 10;
                    break;
                }else if (Math.abs(guess - hiddenNumber) <= 10){
                    System.out.println("Oh no! You were close. The number is " 
                        + (guess < hiddenNumber ? "higher." : "lower."));
                    score += 5;
                }else{
                    System.out.println("Oh sorry! You were far off. The number "
                            + "is " 
                            + (guess < hiddenNumber ? "higher." : "lower."));
                }
            }
            
            System.out.println("Round over! Your score this round was: " 
                    + score);
            finalScore += score;
            
            System.out.println("The hidden number was: " + hiddenNumber);
            System.out.println("You scored " + score + " points this round.");
            
            System.out.print("Do you want to play another round? (yes/no): ");
            String response = kbd.next();
            if (response.equalsIgnoreCase("no")) {
                System.out.println("Thank you for playing! Your total score is"
                        + ": " + finalScore);
                kbd.close();
                break;
            }
        }
    }
    
}
