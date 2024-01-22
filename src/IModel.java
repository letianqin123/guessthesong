/******
 Name: Letian Qin
 Assignment: 5004 final project
 Date: 12/10/2023
 Notes: This file constructs the IController interface.
 ******/

/**
 * The IModel interface defines the model of the song quiz game.
 */
public interface IModel {

    /**
     * Plays the next song in the game.
     */
    void playNext();

    /**
     * Checks if the game is over.
     *
     * @return true if the game is over, false otherwise.
     */
    boolean isGameOver();

    /**
     * Gets the current points of the player.
     *
     * @return The current points.
     */
    int getCurrentPoints();

    /**
     * Gets the title of the current song being played.
     *
     * @return The title of the current song.
     */
    String getCurrentTitle();

    /**
     * Gets the total number of songs in the game.
     *
     * @return The total number of songs.
     */
    int getSongCount();

    /**
     * Checks if there is another song.
     *
     * @return true if there is another song, false otherwise.
     */
    boolean hasNextSong();

    /**
     * Gets the game settings of the model.
     *
     * @return The game settings.
     */
    GameSettings getGameSettings();

    /**
     * Checks the user's guess and updates the points.
     *
     * @param userGuess     The user's guess for the song title.
     * @param correctTitle  The correct title of the song.
     * @return true if the guess is correct, false otherwise.
     */
    boolean checkUserGuess(String userGuess, String correctTitle);

    /**
     * Gets the duration of each song in the game.
     *
     * @return The duration of each song.
     */
    int getSongDuration();
}
