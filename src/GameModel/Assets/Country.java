package GameModel.Assets;

public class Country
{
    private final int population;
    private final String name;
    private String id = "C";
    private static int count;

    private Country(String name, int population)
    {
        this.name = name;
        this.population = population;
        count++;
        id = id + count;
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

}
