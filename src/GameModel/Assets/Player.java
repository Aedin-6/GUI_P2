package GameModel.Assets;

public class Player
{
    private static int points;


    public Player(){}

    protected static void RemovePoints(int cost)
    {
        points-=cost;
    }

    protected static void AddPoints(int cost)
    {
        points+=cost;
    }
}
