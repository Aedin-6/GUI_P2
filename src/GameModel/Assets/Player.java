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

    public static void ConstantPointsIncrease()
    {
        points+=1000;
    }

    public static String GetStringPoints()
    {
        String playerPoints = String.valueOf(points);
        return playerPoints;
    }
}
