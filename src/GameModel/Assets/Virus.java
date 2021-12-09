package GameModel.Assets;

import GameModel.Start;

import static View.StartFrame.getDifficulty;

public class Virus
{
    public static int count;

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
            case "Easy" -> count += _countriesInfected*1000;
            case "Normal" -> count += _countriesInfected*2000;
            case "Hard" -> count += _countriesInfected*3000;
        }
    }


    public static void MaxAchieved()
    {
        int _maxCount = 50000000;
        if (count >= _maxCount)
        {
            Start.GameOver();
        }
    }
}
