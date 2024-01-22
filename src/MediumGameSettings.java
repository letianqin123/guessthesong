/******
 Name: Letian Qin
 Assignment: 5004 final project
 Date: 12/10/2023
 Notes: This file constructs the MediumGameSettings class.
 ******/

/**
 * The MediumGameSettings class represents the game settings for the medium difficulty level in a song quiz game.
 */
public class MediumGameSettings extends GameSettings {

    /**
     * Constructs a new MediumGameSettings object.
     * Sets values for starting points and song duration.
     */
    public MediumGameSettings() {
        super(Difficulty.MEDIUM);
        setValues();
    }

    @Override
    protected void setValues() {
        startingPoints = 2;
        songDuration = 5;
    }
}
