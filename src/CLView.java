/******
 Name: Letian Qin
 Assignment: 5004 final project
 Date: 12/10/2023
 Notes: This file constructs the CLView class.
 ******/

import java.util.Scanner;

/**
 * The CLView class represents a command-line view for the song quiz game.
 */
public class CLView implements IView{
    private final Scanner scanner;

    /**
     * Constructor
     */
    public CLView() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public int getDifficulty() {
        int level;
        while (true) {
            try {
                System.out.println("Welcome to the song quiz! Please choose a difficulty level.\n1 for easy. 2 for medium. 3 for hard.");
                level = Integer.parseInt(scanner.nextLine());

                if (level >= 1 && level <= 3) {
                    break;
                } else {
                    throw new IllegalArgumentException("Please enter a number between 1 and 3.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return level;
    }

    @Override
    public void displayDifficulty(Difficulty difficulty, int points, int count, int duration){
        System.out.println("You have chosen the " + difficulty.toString() + " difficulty.\n" +
                "Your starting points are " + points + ".\n" +
                "You will need to guess the titles of " + count + " songs.\n" +
                "These songs will only be played for " + duration + " seconds.\n");
    }

    @Override
    public String getAnswer(){
        System.out.println("Enter the title of the song:");
        return scanner.nextLine();
    }

    @Override
    public void playSongPrompt(){
        System.out.println("Now playing the song...");
    }

    @Override
    public void printResult(boolean result){
        if (result) {
            System.out.println("Correct guess! You earned a point.");
        } else {
            System.out.println("Incorrect guess! You lost a point.");
        }
    }

    @Override
    public void endGame(){
        System.out.println("Game Over! You've reached 0 point.");
    }

    @Override
    public void winGame(){
        System.out.println("Congratulations! You've won the game.");
    }

}
