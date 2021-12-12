package View;

import GameModel.Assets.Country;
import GameModel.Assets.PowerUp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ButtonActions
{
    public void OpenCountryMenu(String name)
    {
        JFrame countryMenu = new JFrame("Power ups!");
        countryMenu.setLayout(new GridLayout(2,1, 10, 10));
        countryMenu.setSize(350,100);
        countryMenu.setVisible(true);
        countryMenu.setLocationRelativeTo(null);
        ArrayList<PowerUp> _powerUps = GetPowerUpsForCountry(name);
        ArrayList<PowerUp> pUps = new ArrayList<>();
        for (PowerUp powerUp: _powerUps)
        {
            if (!powerUp.GetIsActive())
                pUps.add(powerUp);
        }
        Object[] avalPUs = pUps.toArray() ;
        JComboBox menu = new JComboBox(avalPUs);

        countryMenu.setTitle("Power ups for: " + name + "!");
        menu.setVisible(true);
        JButton ok = new JButton("Ok");

        ok.addActionListener(e ->
        {
            var chosenPA = (PowerUp) menu.getSelectedItem();
            chosenPA.Activate();
            countryMenu.dispose();
        });
        ok.setVisible(true);
        countryMenu.add(menu);
        countryMenu.add(ok);
    }

    private ArrayList<PowerUp> GetPowerUpsForCountry(String name)
    {
        for (Country country: Country.GetContryList())
        {
            if(name.equals(country.GetName()))
                return country.GetPowerUpList();
        }
        return null;
    }
}
