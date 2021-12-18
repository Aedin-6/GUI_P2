package GameModel;

import GameModel.Assets.Country;
import GameModel.Assets.Player;
import GameModel.Assets.Virus;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import static java.lang.Thread.sleep;

public class TimeFlow implements Runnable
{
    public static LocalTime time = LocalTime.ofSecondOfDay(1);
    private boolean exit = false;
    @Override
    public void run()
    {
        while(!exit)
        {
            try
            {
                time = time.plusSeconds(1);
                sleep(1000);
                Virus.Spread();
                Player.ConstantPointsIncrease();
                System.out.println(Virus.GetCount());
                System.out.println(time);
                //TimeIncrese();
            } catch (InterruptedException e)
            {
                System.out.println("Something interrupted the thread.");
            }
        }
    }

    private synchronized void TimeIncrese() throws InterruptedException
    {
        for (int i = 0; i<Integer.MAX_VALUE; i++)
        {
            time = time.plusSeconds(1);
            sleep(1000);
            Virus.Spread();
            Player.ConstantPointsIncrease();
            System.out.println(Virus.GetCount());
            System.out.println(time);
        }
    }
    public void setExit()
    {
        exit = true;
    }
}
