package GameModel.Assets;

import GameModel.Start;

import static View.StartFrame.getDifficulty;

public class Virus
{
    public static int count;
    private final int maxCount = 50000000;

    public Virus()
    { }

    private void IncreaseCount(int viruses)
    {
        count+=viruses;
    }

    public static void Spread()
    {
        String diff = getDifficulty();
        switch (diff)
        {
            case "Easy" -> count += 10;
            case "Normal" -> count += 20;
            case "Hard" -> count += 30;
        }
    }

    private void MaxAchieved()
    {
        if (count == maxCount)
        {
            Start.GameOver();
        }
    }
}
