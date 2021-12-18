package View;

import GameModel.Assets.Country;
import GameModel.Assets.Player;
import GameModel.Assets.PowerUp;
import GameModel.Assets.Virus;
import GameModel.Start;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class BreakListener implements KeyListener
{
    private ArrayList<Integer> pressed = new ArrayList<>();

    BreakListener()
    {
        /*
        javax.swing.Timer timer = new Timer(10, checkIfPressed);
        timer.start();
         */
    }
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e)
    {
        if(!pressed.contains(e.getKeyCode()))
        {
            pressed.add(e.getKeyCode());
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        if(pressed.contains(e.getKeyCode()))
        {
            pressed.remove(e.getKeyCode());
        }
    }


    public ActionListener checkIfPressed = e ->
    {
        if(pressed.contains(16) && pressed.contains(17)
                && pressed.contains(81))
        {
            System.out.println("123");
            GameFrame.exitFrame();
            Start.getTimeSim().setExit();
            Start.getSpreadSim().setExit();
            Country.GetCountryList().clear();
            Virus.ResetCount();
            Player.ClearPoints();
            new StartFrame();
            pressed.clear();
        }
    };

}
