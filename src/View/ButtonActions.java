package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonActions implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        OpenCountryMenu();
    }

    private void OpenCountryMenu()
    {
        JFrame countryMenu = new JFrame();
        countryMenu.setSize(200,70);
        countryMenu.setVisible(true);
        countryMenu.setLocationRelativeTo(null);

        String[] petStrings = { "Bird", "Cat", "Dog", "Rabbit", "Pig" };
        JComboBox menu = new JComboBox(petStrings);
        menu.setName("Power ups!");
        menu.setVisible(true);
        menu.addActionListener(this);

        countryMenu.add(menu);
    }
}
