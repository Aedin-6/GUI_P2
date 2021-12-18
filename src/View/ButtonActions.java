package View;

import GameModel.Assets.*;

import javax.swing.*;
import java.awt.*;
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
        ArrayList<Connections> _connections = GetConnections(name);
        var paths = TransmissionMethod.GetTransPaths();
        ArrayList<Object> pUps = new ArrayList<>();
        for (PowerUp powerUp: _powerUps)
        {
            if (!powerUp.GetIsActive())
                pUps.add(powerUp);
        }
        if (pUps.size() <=5 && paths.size()==3)
            pUps.add(paths.get(2));
        if (pUps.size() <=3 && paths.size()==2)
            pUps.add(paths.get(1));
        if (pUps.size() <=1 && paths.size()==1)
            pUps.add(paths.get(0));
        Object[] avalPUs = pUps.toArray() ;
        JComboBox menu = new JComboBox(avalPUs);

        countryMenu.setTitle("Power ups for: " + name + "!");
        menu.setVisible(true);
        JButton ok = new JButton("Ok");

        ok.addActionListener(e ->
        {
            if(menu.getSelectedItem() instanceof PowerUp)
            {
                PowerUp chosenPA = (PowerUp) menu.getSelectedItem();
                chosenPA.Activate();
            }
            else if (menu.getSelectedItem() instanceof TransmissionMethod)
            {
                TransmissionMethod chosenPath = (TransmissionMethod) menu.getSelectedItem();
                if (paths.get(0).equals(chosenPath))
                {
                    for (Connections connections : _connections)
                    {
                        if (connections.GetPath().equals(paths.get(0)))
                        {
                            connections.Close();
                        }
                    }
                    paths.remove((paths.get(0)));
                    Player.AddPoints(1000);
                }
                else if (paths.get(1).equals(chosenPath))
                {
                    for (Connections connections : _connections)
                    {
                        if (connections.GetPath().equals(paths.get(1)))
                        {
                            connections.Close();
                        }
                    }
                    paths.remove((paths.get(1)));
                    Player.AddPoints(2000);
                }
                else if (paths.get(2).equals(chosenPath))
                {
                    for (Connections connections : _connections)
                    {
                        if (connections.GetPath().equals(paths.get(2)))
                        {
                            connections.Close();
                        }
                    }
                    paths.remove((paths.get(2)));
                    Player.AddPoints(3000);
                }
                PathClosed();
            }
            countryMenu.dispose();
        });
        ok.setVisible(true);
        countryMenu.add(menu);
        countryMenu.add(ok);
    }

    private void PathClosed()
    {
        JOptionPane.showMessageDialog(null, "Good job you have closed one of viruses paths!\n Close them in different states to stop the spread!", "Path Closed",
                JOptionPane.INFORMATION_MESSAGE);
    }
    private ArrayList<Connections> GetConnections(String name)
    {
        for (Country country: Country.GetCountryList())
        {
            if(name.equals(country.GetName()))
                return country.getConnections();
        }
        return null;
    }

    private ArrayList<PowerUp> GetPowerUpsForCountry(String name)
    {
        for (Country country: Country.GetCountryList())
        {
            if(name.equals(country.GetName()))
                return country.GetPowerUpList();
        }
        return null;
    }
}
