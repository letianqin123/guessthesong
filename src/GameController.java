/******
 Name: Letian Qin
 Assignment: 5004 final project
 Date: 12/10/2023
 Notes: This file constructs the GameController class.
 ******/

/**
 * The GameController class controls the flow of the song quiz game and interacts with the model and the view.
 */
public class GameController implements IController {
    private IModel model;
    private IView view;
    private SongList songList;
    private Difficulty difficulty;
    private GameSettings setting;

    /**
     * Constructor
     *
     * @param view   The view of the game.
     * @param songs  The songs used for the game.
     */
    public GameController(IView view, SongList songs) {
        this.view = view;
        this.songList = songs;
    }

    @Override
    public void go() {
        // ask the user for difficulty
        int answer = view.getDifficulty();

        // create the game settings based on the difficulty
        switch (answer) {
            case 1:
                difficulty = Difficulty.EASY;
                setting = new EasyGameSettings();
                break;
            case 2:
                difficulty = Difficulty.MEDIUM;
                setting = new MediumGameSettings();
                break;
            case 3:
                difficulty = Difficulty.HARD;
                setting = new HardGameSettings();
                break;
        }

        // create the model based on the settings and song list
        IModel model = new GameModel(setting, songList);

        // before the game begins, tells the user the information about the current difficulty
        view.displayDifficulty(difficulty, setting.getStartingPoints(), model.getSongCount(), setting.getSongDuration());

        // if the game is not over and there are still songs to be played
        while ((!model.isGameOver()) && (model.hasNextSong())) {

            // tell the user the song is playing
            view.playSongPrompt();

            // play the song
            model.playNext();

            // take the user guess
            String guess = view.getAnswer();

            // check the guess with the correct answer
            boolean result = model.checkUserGuess(guess, model.getCurrentTitle());

            // show user the result
            view.printResult(result);
        }

        // if the game is over and the current points hits 0, the user lost the game.
        // Otherwise, the user has guessed all songs and won the game.
        if (model.getCurrentPoints() <= 0){
            view.endGame();
        } else {
            view.winGame();
        }
    }
}

