package GameModel;


import GameModel.Assets.Player;
import GameModel.Assets.Virus;
import static java.lang.Thread.sleep;

public class SpreadFlow implements Runnable
{
    @Override
    public void run()
    {
        try
        {
            TimeIncrese();
        }
        catch (InterruptedException e)
        {
            System.out.println("Something interrupted the date.");
        }
    }

    private synchronized void TimeIncrese() throws InterruptedException
    {
        for (int i = 0; i<Integer.MAX_VALUE; i++)
        {
            sleep(1000);
            Virus.Contamination();
            Virus.MaxAchieved();
        }
    }
}
