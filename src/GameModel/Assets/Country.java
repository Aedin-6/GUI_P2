package GameModel.Assets;

import View.GameFrame;

import javax.swing.*;
import java.util.ArrayList;


public class Country
{
    private final int population;
    private static long worldPopulation;
    private int infectedPopulation;
    private final String name;
    private String id = "C";
    private static int count;
    private static int infectedCount;
    private boolean isContaminated;
    private static ArrayList<Country> countryList = new ArrayList<>();
    private ArrayList<PowerUp> powerUpsList = new ArrayList<>();

    public Country(String name, int population)
    {
        this.name = name;
        this.population = population;
        infectedPopulation = 0;
        count++;
        infectedCount = 1;
        id = id + count;
        isContaminated = false;
        worldPopulation += population;
    }

    public static int GetInfectedCount()
    {
        return infectedCount;
    }

    public static ArrayList<Country> GetContryList()
    {
        return countryList;
    }

    public static long GetWorldPopulation()
    {
        return worldPopulation;
    }

    public boolean GetIsContaminated()
    {
        return isContaminated;
    }

    public int getPopulation()
    {
        return population;
    }

    public String getName()
    {
        return name;
    }

    public String getId()
    {
        return id;
    }
    public void Contamination()
    {
        GameFrame.Buttons btns = new GameFrame.Buttons();
        btns.GetBtn(this.name).setEnabled(true);
        infectedCount++;
        isContaminated = true;
        JOptionPane.showMessageDialog(null,  this.name +" has been contaminated! \nPeople are getting sick!", "Contaminated!",
                JOptionPane.INFORMATION_MESSAGE);
    }
    public void FirstCase()
    {
        infectedCount++;
        isContaminated = true;
    }
    public void Cured()
    {
        GameFrame.Buttons btns = new GameFrame.Buttons();
        btns.GetBtn(this.name).setEnabled(false);
        infectedCount--;
        isContaminated = false;
        JOptionPane.showMessageDialog(null,  "All people in "+ this.name +" has been cured!", "Cured",
                JOptionPane.INFORMATION_MESSAGE);
    }
    private void AllAreDead()
    {
        if(infectedPopulation>=population)
        {
            System.out.println("All people in this country are infected.");
        }
    }

    public String GetName()
    {
        return name;
    }

    public  ArrayList<PowerUp> GetPowerUpList()
    {
        return powerUpsList;
    }

}
