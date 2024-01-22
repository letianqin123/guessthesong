/******
 Name: Letian Qin
 Assignment: 5004 final project
 Date: 12/10/2023
 Notes: This file constructs the GameModel class.
 ******/

import java.util.Iterator;

/**
 * The GameModel class represents the model of the song quiz game.
 */
public class GameModel implements IModel {
    private SongList songList;
    private GameSettings gameSettings;
    private int currentPoints;
    private int songDuration;
    private boolean gameOver;
    private Iterator<Song> songIterator;
    private Iterator<String> titleIterator;

    /**
     * Constructor
     *
     * @param gameSettings The settings for the game
     * @param songs        The songs for the game.
     */
    public GameModel(GameSettings gameSettings, SongList songs) {
        this.gameSettings = gameSettings;
        this.currentPoints = gameSettings.getStartingPoints();
        this.songDuration = gameSettings.getSongDuration();
        this.songList = songs.filterSongs(song -> song.getDifficulty() == gameSettings.getDifficulty());
        this.gameOver = false;
        this.songIterator = songList.iterator();
        this.titleIterator = songList.mapToTitle().iterator();
        }

    @Override
    public void playNext() {
        Song currentSong = songIterator.next();
        currentSong.play(getSongDuration());
    }

    @Override
    public boolean isGameOver() {
        return gameOver;
    }

    @Override
    public int getCurrentPoints() {
        return currentPoints;
    }

    @Override
    public String getCurrentTitle() {
        return titleIterator.next();
    }

    @Override
    public boolean hasNextSong() {
        return songIterator.hasNext();
    }

    @Override
    public GameSettings getGameSettings() {
        return gameSettings;
    }

    @Override
    public int getSongDuration() {
        return songDuration;
    }

    @Override
    public int getSongCount() {
        return songList.countSongs();
    }

    @Override
    public boolean checkUserGuess(String userGuess, String correctTitle) {
        if (userGuess.equalsIgnoreCase(correctTitle)) {
            currentPoints++;
            return true;
        } else {
            currentPoints--;
            if (getCurrentPoints() <= 0){
                gameOver = true;
            }
            return false;
        }
    }


}
