package GameModel;

import GameModel.Assets.*;
import View.EndGameFrame;


import java.awt.event.KeyListener;
import java.util.ArrayList;


public class Start
{
    private static TimeFlow timer;
    private static SpreadFlow spreadFlow;


    public void StartNewGame()
    {
        new Virus();
        new Player();
        timer = new TimeFlow();
        Thread timeSim = new Thread(timer);
        timeSim.start();
        spreadFlow = new SpreadFlow();
        Thread spreadSim = new Thread(spreadFlow);
        spreadSim.start();
        GenerateTransmissionPaths();
        GenerateCountries();
        GeneratePowerUps();
        //GenerateConnections();

    }

    /*
    private void GenerateConnections()
    {
        ArrayList<TransmissionMethod> transmissionMethodArrayList = new ArrayList<>();
        transmissionMethodArrayList.add(new TransmissionMethod("Cruise", 5));
        transmissionMethodArrayList.add(new TransmissionMethod("Border", 10));
        transmissionMethodArrayList.add(new TransmissionMethod("Plane", 15));
        ArrayList<Country> countries = Country.GetCountryList();
        int counter = countries.size()-1;
        for(int i = 0; i <= countries.size()-1; i++)
        {
            Connections connection1 = null;
            Connections connection2 = null;

            for (int j = counter; j >= 0; j--)
            {
                int idx1=0, idx2 =0;
                while (idx1 == idx2)
                {
                    idx1 = (int) (Math.random() * transmissionMethodArrayList.size());
                    idx2 = (int) (Math.random() * transmissionMethodArrayList.size());
                }
                if(Country.GetCountryList().get(i) != Country.GetCountryList().get(j))
                {
                    connection1 = new Connections(countries.get(i), countries.get(j), transmissionMethodArrayList.get(idx1));
                    connection2 = new Connections(countries.get(i), countries.get(j), transmissionMethodArrayList.get(idx2));
                }
            }
            counter--;
        }

        for(Country country: Country.GetCountryList())
        {
            for(Connections connections: Connections.GetConnectionsList())
            {
                if((connections.GetCountryA().equals(country) || connections.GetCountryB().equals(country)) && !country.getConnections().contains(connections))
                    country.getConnections().add(connections);
            }
        }
    }

     */

    private void GeneratePowerUps()
    {
        for(Country country: Country.GetCountryList())
        {
            ArrayList<PowerUp> powerUpList = new ArrayList<>();
            powerUpList.add(PowerUpGenerator("Masks", 50, 50));
            powerUpList.add(PowerUpGenerator("Hygiene Education", 70, 70));
            powerUpList.add(PowerUpGenerator("Sterile Gloves", 80, 80));
            powerUpList.add(PowerUpGenerator("Limits In Stores", 100, 100));
            powerUpList.add(PowerUpGenerator("Elder Hours", 110, 110));
            powerUpList.add(PowerUpGenerator("Covid Hospital", 500, 500));
            powerUpList.add(PowerUpGenerator("Forests Closed", 600, 600));
            powerUpList.add(PowerUpGenerator("VooDoo Therapy", 220, 220));
            powerUpList.add(PowerUpGenerator("Medicine", 1000, 1000));
            powerUpList.add(PowerUpGenerator("Vaccine", 2000, 2000));

            while(country.GetPowerUpList().size() < 7)
            {
                for (PowerUp powerUp: powerUpList)
                {
                    boolean luck = Math.random() > 0.5;
                    if(luck && country.GetPowerUpList().size() < 7 && !country.GetPowerUpList().contains(powerUp))
                        country.GetPowerUpList().add(powerUp);
                }
            }
        }
    }

    public static SpreadFlow getSpreadSim()
    {
        return spreadFlow;
    }

    public static TimeFlow getTimeSim()
    {
        return timer;
    }

    private PowerUp PowerUpGenerator(String name, int cost, int strength)
    {
        return new PowerUp(name, cost, strength);
    }

    private void GenerateTransmissionPaths()
    {
        TransmissionMethod.GetTransPaths().add(new TransmissionMethod("Cruise", 5));
        TransmissionMethod.GetTransPaths().add(new TransmissionMethod("Border", 10));
        TransmissionMethod.GetTransPaths().add(new TransmissionMethod("Plane", 15));
    }
    private void GenerateCountries()
    {
        CountryGenerator("Russia", 1000000);
        CountryGenerator("USA", 2300000);
        CountryGenerator("Poland", 400000);
        CountryGenerator("Mexico", 900000);
        CountryGenerator("UK", 1200000);
        CountryGenerator("Germany", 800000);
        CountryGenerator("France", 600000);
        CountryGenerator("China", 1500000);
        CountryGenerator("Japan", 600000);
        CountryGenerator("Norway", 500000);
        CountryGenerator("Canada", 1000000);
        CountryGenerator("Italy", 550000);

        for(Country country: Country.GetCountryList())
        {
            for(Connections connections: Connections.GetConnectionsList())
            {
                if((connections.GetCountryA().equals(country) || connections.GetCountryB().equals(country)) && !country.getConnections().contains(connections))
                    country.getConnections().add(connections);
            }
        }
    }

    private void CountryGenerator(String name, int population)
    {
        Country country = new Country(name, population);
        if (name.equals("China"))
            country.FirstCase();
        if(Country.GetCountryList().size()>1)
        {
            for (Country country1 : Country.GetCountryList())
            {
                if(!country.equals(country1))
                {
                    Connections connection1 = null;
                    Connections connection2 = null;
                    int idx1 = 0, idx2 = 0;
                    while (idx1 == idx2)
                    {
                        idx1 = (int) (Math.random() * TransmissionMethod.GetTransPaths().size());
                        idx2 = (int) (Math.random() * TransmissionMethod.GetTransPaths().size());
                    }
                    connection1 = new Connections(country,country1, TransmissionMethod.GetTransPaths().get(idx1));
                    connection2 = new Connections(country,country1, TransmissionMethod.GetTransPaths().get(idx2));
                }
            }
        }
    }

    public void GameOver(boolean winLose)
    {

            getTimeSim().setExit();
            getSpreadSim().setExit();
            new EndGameFrame(winLose);

    }

}
