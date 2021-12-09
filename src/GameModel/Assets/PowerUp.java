package GameModel.Assets;

public class PowerUp
{
    private String name;
    private String id = "P";
    private boolean isActive;
    private int cost;
    private int strength;
    private static int counter;


    public PowerUp(String name, int cost, int strength)
    {
        this.name = name;
        id = id + counter;
        counter++;
        this.isActive = false;
        this.cost = cost;
        this.strength = strength;
    }

    private void Activate()
    {
        isActive = true;
        Player.RemovePoints(cost);
    }

    private void Deactivate()
    {
        isActive = false;
        Player.AddPoints(cost/2);
    }

    private String GetID()
    {
        return  id;
    }
}
