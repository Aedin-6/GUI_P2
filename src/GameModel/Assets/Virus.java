package GameModel.Assets;

import GameModel.Start;
import GameModel.TimeFlow;

import static View.StartFrame.getDifficulty;

public class Virus
{
    private static int count;
    private static int spreadRate;


    public Virus()
    { count++;}

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
//            case "Easy" -> count += _countriesInfected*(1000-spreadRate);
//            case "Normal" -> count += _countriesInfected*(2000-spreadRate);
//            case "Hard" -> count += _countriesInfected*(3000-spreadRate);

            case "Easy" -> count += CalcuLateCountrySpread(10000-spreadRate);
            case "Normal" -> count += CalcuLateCountrySpread(20000-spreadRate);
            case "Hard" -> count += CalcuLateCountrySpread(30000-spreadRate);
        }
    }

    public static void Contamination()
    {
        var ctr = Country.GetCountryList().get((int) ((Math.random() * Country.GetCountryList().size())));
        if (TimeFlow.time.getSecond() >= 10 && !ctr.GetIsContaminated())
        {
            ctr.Contamination();
        }
    }

    public static int CalcuLateCountrySpread(int diffLvl)
    {
        int virusCount = 0;

        for (Country country: Country.GetCountryList())
        {
            int countrySpread = 0;
            if(country.GetIsContaminated())
            {
                country.IncreaseInfectedPopulation(diffLvl);
                virusCount = virusCount+diffLvl;
                countrySpread = countrySpread+diffLvl;

                for(Connections connections: Connections.GetConnectionsList())
                {
                    if(connections.GetCountryA().equals(country) || connections.GetCountryB().equals(country))
                    {
                        virusCount= virusCount+connections.GetPath().GetCapacity();
                        countrySpread = countrySpread + connections.GetPath().GetCapacity();
                    }
                }
            }
            country.IncreaseInfectedPopulation(countrySpread);
        }

        return virusCount;
    }

    public static void MaxAchieved()
    {
        Start start = new Start();
        if (count >= Country.GetWorldPopulation())
        {
            start.GameOver(false);
        }
        else if (count <= 0)
        {
            start.GameOver(true);
        }
    }

    public static int GetCount()
    {
        return count;
    }

    public static int ResetCount()
    {
        return count = 1;
    }

    public static void ChangeSpreadRate(int change)
    {
        spreadRate = spreadRate + change;
    }

}
