package View;

import GameModel.Assets.PowerUp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonActions
{
    public void OpenCountryMenu()
    {
        JFrame countryMenu = new JFrame("Power ups!");
        countryMenu.setLayout(new GridLayout(2,1, 10, 10));
        countryMenu.setSize(250,100);
        countryMenu.setVisible(true);
        countryMenu.setLocationRelativeTo(null);
        PowerUp[] _powerUps = {  }; // to change
        JComboBox menu = new JComboBox(_powerUps);
        menu.setName("Power ups!");
        menu.setVisible(true);
        JButton ok = new JButton("Ok");

        ok.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                var chosenPA = (PowerUp) menu.getSelectedItem();
                chosenPA.Activate();
                countryMenu.dispose();
            }
        });
        ok.setVisible(true);
        countryMenu.add(menu);
        countryMenu.add(ok);
    }
}
