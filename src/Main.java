/******
 Name: Letian Qin
 Assignment: 5004 final project
 Date: 12/10/2023
 Notes: This file constructs the driver.
 ******/

public class Main {
    public static void main(String[] args){
        SongList songs = new SongList();
        Song song1 = new Song(Difficulty.EASY, "super shy", "./resources/SuperShy.wav");
        Song song2 = new Song(Difficulty.EASY, "kill bill", "./resources/Kill-Bill.wav");
        Song song3 = new Song(Difficulty.MEDIUM, "august", "./resources/august.wav");
        Song song4 = new Song(Difficulty.MEDIUM, "paint the town red", "./resources/Paint The Town Red.wav");
        Song song5 = new Song(Difficulty.MEDIUM, "seven", "./resources/Seven.wav");
        Song song6 = new Song(Difficulty.HARD, "paint the town red", "./resources/Paint The Town Red.wav");
        Song song7 = new Song(Difficulty.HARD, "3 boys", "./resources/3 Boys.wav");
        Song song8 = new Song(Difficulty.HARD, "cuff it", "./resources/CUFF IT.wav");
        Song song9 = new Song(Difficulty.HARD, "golden hour", "./resources/golden hour.wav");
        Song song10 = new Song(Difficulty.HARD, "kitsch", "./resources/Kitsch.wav");

        songs.addSong(song1);
        songs.addSong(song2);
        songs.addSong(song3);
        songs.addSong(song4);
        songs.addSong(song5);
        songs.addSong(song6);
        songs.addSong(song7);
        songs.addSong(song8);
        songs.addSong(song9);
        songs.addSong(song10);

        new GameController(new CLView(), songs).go();
    }
}
