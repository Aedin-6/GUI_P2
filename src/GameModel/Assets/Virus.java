package GameModel.Assets;

import GameModel.Start;

public class Virus
{
    private int count;
    private final int maxCount = 50000000;

    private Virus()
    { }

    private void IncreseCount()
    {
        count++;
    }

    private void Spread()
    {
        count+=10;
    }

    private void MaxAchived()
    {
        if (count == maxCount)
        {
            Start.GameOver();
        }
    }
}
