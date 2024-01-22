/******
 Name: Letian Qin
 Assignment: 5004 final project
 Date: 12/10/2023
 Notes: This file constructs the SongList class.
 ******/

import java.util.function.Predicate;
import java.util.Iterator;

/**
 * The SongList class represents the songs used in the Song Quiz game.
 */
public class SongList {
    private ADTList<Song> songs;

    /**
     * Constructs a SongList with an empty list of songs.
     */
    public SongList() {
        this.songs = new ADTList<>();
    }

    /**
     * Adds a song to the list.
     *
     * @param song The song to be added.
     */
    public void addSong(Song song) {
        songs.add(song);
    }

    /**
     * Removes a song from the list.
     *
     * @param index The index of the song to be removed.
     * @throws IllegalArgumentException if the index is invalid.
     */
    public void removeSong(int index) {
        if (index < 0 || index >= countSongs()) {
            throw new IllegalArgumentException("Invalid position");
        }
        songs.remove(index);
    }

    /**
     * Maps the songs in the list to their titles.
     *
     * @return A list of song titles.
     */
    public ADTList<String> mapToTitle() {
        return songs.map(Song -> Song.getTitle());
    }

    /**
     * Counts the total number of songs in the list.
     *
     * @return The number of songs in the list.
     */
    public int countSongs() {
        return songs.foldCount(0, (count, song) -> count + 1);
    }

    /**
     * Filters the songs in the list based on a given predicate.
     *
     * @param predicate A predicate to filter the songs.
     * @return A new SongList containing the filtered songs.
     */
    public SongList filterSongs(Predicate<Song> predicate) {
        SongList filteredList = new SongList();
        filteredList.songs = songs.filter(predicate);

        return filteredList;
    }

    /**
     * Returns an iterator over the songs in the list.
     *
     * @return An iterator over the songs.
     */
    public Iterator<Song> iterator() {
        return songs.iterator();
    }

}

