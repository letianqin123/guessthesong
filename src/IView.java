/******
 Name: Letian Qin
 Assignment: 5004 final project
 Date: 12/10/2023
 Notes: This file constructs the IView interface.
 ******/

public interface IView {
    /**
     * Gets the difficulty level chosen by the user.
     *
     * @return The difficulty level chosen by the user.
     */
    int getDifficulty();

    /**
     * Displays the chosen difficulty, starting points, song numbers, and song duration to the user.
     *
     * @param difficulty The chosen difficulty level.
     * @param points The starting points.
     * @param count The number of songs to guess.
     * @param duration The duration of each song.
     */
    void displayDifficulty(Difficulty difficulty, int points, int count, int duration);

    /**
     * Gets the user's answer for the song title.
     *
     * @return The user's input for the song title.
     */
    String getAnswer();

    /**
     * Displays a message that says the song is now playing.
     */
    void playSongPrompt();

    /**
     * Prints the result of the user's guess.
     *
     * @param result  the result of the user's guess
     */
    void printResult(boolean result);

    /**
     * Displays a message that says the game is over, and the user lost.
     */
    void endGame();

    /**
     * Displays a message that says the game is over, and the user won.
     */
    void winGame();
}

