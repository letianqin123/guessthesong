/******
 Name: Letian Qin
 Assignment: 5004 final project
 Date: 12/10/2023
 Notes: This file constructs the EasyGameSettings class.
 ******/

/**
 * The EasyGameSettings class represents the game settings for the easy difficulty level in a song quiz game.
 */
public class EasyGameSettings extends GameSettings {

    /**
     * Constructs a new EasyGameSettings object.
     * Sets values for starting points and song duration.
     */
    public EasyGameSettings() {
        super(Difficulty.EASY);
        setValues();
    }

    @Override
    protected void setValues() {
        startingPoints = 2;
        songDuration = 10;
    }
}