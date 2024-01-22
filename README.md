# song-quiz
This project is a Song Quiz game. The player will be presented with several songs that last seconds and need to guess the titles of the songs. The game has multiple difficulty levels with different settings such as harder songs, shorter intros, increasing song numbers, and fewer starting points.\
\
If the player guessed it correctly, they get one point. Otherwise, they lose one point. Once they hit 0 points, they lose the game. If the player guessed all songs without hitting 0 points, they win the game.\
\
As for the overall structure, I used an abstracted linked list to store all the songs. I downloaded all the songs and used the Java Sound API to play the audio files. The game follows the MVC design pattern and the SOLID Principles.
