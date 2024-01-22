/******
 Name: Letian Qin
 Assignment: 5004 final project
 Date: 12/10/2023
 Notes: This file constructs the HardGameSettings class.
 ******/

/**
 * The HardGameSettings class represents the game settings for the hard difficulty level in a song quiz game.
 */
public class HardGameSettings extends GameSettings {

    /**
     * Constructs a new HardGameSettings object.
     * Sets values for starting points and song duration.
     */
    public HardGameSettings() {
        super(Difficulty.HARD);
        setValues();
    }

    @Override
    protected void setValues() {
        startingPoints = 1;
        songDuration = 1;
    }
}