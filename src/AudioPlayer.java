/******
 Name: Letian Qin
 Assignment: 5004 final project
 Date: 12/10/2023
 Notes: This file constructs the AudioPlayer class.
 ******/

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * The AudioPlayer class represents an audio player that can play audio files using the Java Sound API.
 */
public class AudioPlayer {
    private Clip clip;

    /**
     * Constructor.
     *
     * @param filePath The path to the audio file.
     */
    public AudioPlayer(String filePath) {
        try {
            // Create an AudioInputStream from the audio file
            File audioFile = new File(filePath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);

            // Get information about the audio format and create a Clip
            AudioFormat format = audioInputStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(audioInputStream);

        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * play the audio file for a given duration.
     *
     * @param duration The duration for which the audio will be played.
     */
    public void play(int duration) {
        // Add a listener to stop playback when the clip finishes
        clip.addLineListener(event -> {
            if (event.getType() == LineEvent.Type.STOP) {
                clip.close();
            }
        });

        // Start the clip
        clip.start();

        // Set the timer to stop playback after the specified duration
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(duration);
                clip.stop();
                clip.close();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }}