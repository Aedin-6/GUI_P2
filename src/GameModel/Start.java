package GameModel;

import GameModel.Assets.Player;
import GameModel.Assets.Virus;


import static View.StartFrame.getDifficulty;

public class Start
{
    private String difficulty = getDifficulty();

    public static void StartNewGame(String difficulty)
    {
        TimeFlow timer = new TimeFlow();
        Thread timeSim = new Thread(timer);
        timeSim.start();
        Virus  _virus = new Virus();
        Player _player = new Player();

    }

    public static void GameOver()
    {
    }

}
