package GameModel.Assets;

import GameModel.Start;
import GameModel.TimeFlow;

import static View.StartFrame.getDifficulty;

public class Virus
{
    private static int count;
    private static int spreadRate;


    public Virus()
    { }

    private void IncreaseCount(int viruses)
    {
        count+=viruses;
    }

    public static void Spread()
    {
        int _countriesInfected = Country.GetInfectedCount();
        String diff = getDifficulty();

        switch (diff)
        {
            case "Easy" -> count += _countriesInfected*(1000-spreadRate);
            case "Normal" -> count += _countriesInfected*(2000-spreadRate);
            case "Hard" -> count += _countriesInfected*(3000-spreadRate);
        }
    }

    public static void Contamination()
    {
        var ctr = Country.GetContryList().get((int) ((Math.random() * Country.GetContryList().size())));
        if (TimeFlow.time.getSecond() >= 10 && !ctr.GetIsContaminated())
        {
            ctr.Contamination();
        }
    }


    public static void MaxAchieved()
    {
        Start start = new Start();
        if (count >= Country.GetWorldPopulation())
        {
            start.GameOver(false);
        }
        else if (count <= 0)
        {
            start.GameOver(true);
        }
    }

    public static int GetCount()
    {
        return count;
    }

    public static void ChangeSpreadRate(int change)
    {
        spreadRate = spreadRate + change;
    }
}
