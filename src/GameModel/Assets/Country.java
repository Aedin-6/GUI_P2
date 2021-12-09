package GameModel.Assets;

import java.util.ArrayList;


public class Country
{
    private final int population;
    private int infectedPopulation;
    private final String name;
    private String id = "C";
    private static int count;
    private static int infectedCount;
    private boolean isContaminated;
    private ArrayList<Country> countryList;

    private Country(String name, int population)
    {
        this.name = name;
        this.population = population;
        infectedPopulation = 0;
        count++;
        infectedCount = 1;
        id = id + count;
        isContaminated = false;
    }

    public static int GetInfectedCount()
    {
        return infectedCount;
    }

    private boolean GetIsContaminated()
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
        infectedCount++;
        isContaminated = true;
    }
    public void Cured()
    {
        infectedCount--;
        isContaminated = false;
    }
    private void AllAreDead()
    {
        if(infectedPopulation>=population)
        {
            System.out.println("All people in this country are infected.");
        }
    }

}
