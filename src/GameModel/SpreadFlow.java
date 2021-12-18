package GameModel;


import GameModel.Assets.Country;
import GameModel.Assets.Player;
import GameModel.Assets.Virus;
import static java.lang.Thread.sleep;

public class SpreadFlow implements Runnable
{
    private boolean exit = false;
    @Override
    public void run()
    {
        while(!exit)
        {
            try
            {
                sleep(1000);
                for(Country country: Country.GetCountryList())
                {
                    if (country.GetInfectedPopulationCount() > country.GetPopulation() *0.02)
                        Virus.Contamination();
                }
                Virus.MaxAchieved();

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
            sleep(1000);
            //Virus.Contamination();
            Virus.MaxAchieved();
        }
    }
    public void setExit()
    {
        exit = true;
    }
}
