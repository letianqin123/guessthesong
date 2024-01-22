/******
 Name: Letian Qin
 Assignment: 5004 final project
 Date: 12/10/2023
 Notes: This file constructs the Song class.
 ******/

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Song class represents a song in the Song Quiz game.
 */
public class Song {
    private String title;
    private String filePath;
    private Difficulty difficulty;
    private Timer timer;

    /**
     * Constructor
     *
     * @param difficulty The difficulty level of the song.
     * @param title      The title of the song.
     * @param filePath   The file path to the audio file of the song.
     */
    public Song(Difficulty difficulty, String title, String filePath) {
        this.title = title;
        this.filePath = filePath;
        this.difficulty = difficulty;
    }

    /**
     * Plays the song using an AudioPlayer instance.
     *
     * @param duration The duration for which the song will be played.
     */
    public void play(int duration) {
        AudioPlayer audioPlayer = new AudioPlayer(filePath);
        audioPlayer.play(duration);
    }

    /**
     * Retrieves the title of the song.
     *
     * @return The title of the song.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Retrieves the file path to the audio file of the song.
     *
     * @return The file path to the audio file.
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * Retrieves the difficulty level of the song.
     *
     * @return The difficulty level of the song.
     */
    public Difficulty getDifficulty() {
        return difficulty;
    }
}
