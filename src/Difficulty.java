/******
 Name: Letian Qin
 Assignment: 5004 final project
 Date: 12/10/2023
 Notes: This file constructs the Difficulty enum.
 ******/

/**
 * The Difficulty enum represents different difficulty levels for a song quiz game.
 */
public enum Difficulty {
    EASY{
        @Override
        public String toString(){
            return "easy";}
    },
    MEDIUM{
        @Override
        public String toString(){
            return "medium";}
    },
    HARD{
        @Override
        public String toString(){
            return "hard";}
    }
}
