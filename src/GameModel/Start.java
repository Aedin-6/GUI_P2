package GameModel;

import GameModel.Assets.Country;
import GameModel.Assets.Player;
import GameModel.Assets.PowerUp;
import GameModel.Assets.Virus;


import java.util.ArrayList;


public class Start
{
    public void StartNewGame()
    {
        TimeFlow timer = new TimeFlow();
        Thread timeSim = new Thread(timer);
        timeSim.start();
        SpreadFlow spreadFlow = new SpreadFlow();
        Thread spreadSim = new Thread(spreadFlow);
        spreadSim.start();
        new Virus();
        new Player();
        GenerateCountries();
        GeneratePowerUps();

    }

    private void GeneratePowerUps()
    {
        for(Country country: Country.GetContryList())
        {
            ArrayList<PowerUp> powerUpList = new ArrayList<>();
            powerUpList.add(PowerUpGenerator("Masks", 50, 100));
            powerUpList.add(PowerUpGenerator("Hygiene Education", 70, 100));
            powerUpList.add(PowerUpGenerator("Sterile Gloves", 80, 200));
            powerUpList.add(PowerUpGenerator("Limits In Stores", 100, 100));
            powerUpList.add(PowerUpGenerator("Elder Hours", 110, 100));
            powerUpList.add(PowerUpGenerator("Covid Hospital", 500, 100));
            powerUpList.add(PowerUpGenerator("Forests Closed", 600, 100));
            powerUpList.add(PowerUpGenerator("VooDoo Therapy", 220, 100));
            powerUpList.add(PowerUpGenerator("Medicine", 1000, 100));
            powerUpList.add(PowerUpGenerator("Vaccine", 2000, 100));

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

    private PowerUp PowerUpGenerator(String name, int cost, int strength)
    {
        return new PowerUp(name, cost, strength);
    }

    private void GenerateCountries()
    {
        CountryGenerator("Russia", 100000000);
        CountryGenerator("USA", 100000000);
        CountryGenerator("Poland", 100000000);
        CountryGenerator("Mexico", 100000000);
        CountryGenerator("UK", 100000000);
        CountryGenerator("Germany", 100000000);
        CountryGenerator("France", 100000000);
        CountryGenerator("China", 100000000);
        CountryGenerator("Japan", 100000000);
        CountryGenerator("Norway", 100000000);
        CountryGenerator("Canada", 100000000);
        CountryGenerator("Italy", 100000000);

    }

    private void CountryGenerator(String name, int population)
    {
        Country country = new Country(name, population);
        if (name.equals("China"))
            country.FirstCase();
        Country.GetContryList().add(country);
    }

    public void GameOver(boolean winLose)
    {
        if(winLose)
        {
            System.out.println("You won!");

        }
        else
            System.out.println("You lost");

        //HighScoresList.SaveScore();
    }

}
