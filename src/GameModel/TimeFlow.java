package GameModel;

import GameModel.Assets.Player;
import GameModel.Assets.Virus;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import static java.lang.Thread.sleep;

public class TimeFlow implements Runnable
{
    static LocalTime time = LocalTime.ofSecondOfDay(1);

    @Override
    public void run()
    {
        try
        {
            TimeIncrese();
        }
        catch (InterruptedException e)
        {
            System.out.println("Something interrupted the date.");;
        }
    }

    private synchronized void TimeIncrese() throws InterruptedException
    {
        for (int i = 0; i<Integer.MAX_VALUE; i++)
        {
            time = time.plusSeconds(1);
            sleep(1000);
            Virus.Spread();
            Virus.MaxAchieved();
            Player.ConstantPointsIncrease();
            System.out.println(time);
            System.out.println(Virus.count);
        }
    }
}
