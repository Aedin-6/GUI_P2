package GameModel.Assets;

import javax.swing.*;

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

    public void Activate()
    {
        if(Player.GetPoints() >= this.cost)
        {
            this.isActive = true;
            Player.RemovePoints(cost);
            Virus.ChangeSpreadRate(strength);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Not enough points!", "Error",
                    JOptionPane.WARNING_MESSAGE);
        }
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

    @Override
    public String toString()
    {
        return  name +
                ", Cost: " + cost +
                ", Strength: " + strength;
    }

    public boolean GetIsActive()
    {
        return this.isActive;
    }
}
