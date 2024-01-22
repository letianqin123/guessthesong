/******
 Name: Letian Qin
 Assignment: 5004 final project
 Date: 12/10/2023
 Notes: This file constructs the GameSettings class.
 ******/

/**
 * The GameSettings class is an abstract class representing the settings for a song quiz game.
 */
public abstract class GameSettings {

    /**
     * The difficulty level for the game.
     */
    protected Difficulty difficulty;
    /**
     * The starting points for the player in the game.
     */
    protected int startingPoints;
    /**
     * The duration of each song in the game.
     */
    protected int songDuration;

    /**
     * Constructor
     *
     * @param difficulty The difficulty level for the game.
     */
    public GameSettings(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * Abstract method to set the values of starting points and song duration.
     */
    protected abstract void setValues();

    /**
     * Gets the difficulty level for the game.
     *
     * @return The difficulty level.
     */
    public Difficulty getDifficulty() {
        return difficulty;
    }

    /**
     * Gets the starting points for the player in the game.
     *
     * @return The starting points.
     */
    public int getStartingPoints() {
        return startingPoints;
    }

    /**
     * Gets the duration of each song in the game.
     *
     * @return The duration of each song.
     */
    public int getSongDuration() {
        return songDuration;
    }
}
