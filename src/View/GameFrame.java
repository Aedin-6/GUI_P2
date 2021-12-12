package View;
import GameModel.Assets.Country;
import GameModel.Assets.Player;
import GameModel.TimeFlow;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class GameFrame extends JFrame
{
    private static ArrayList<JButton> btnList = new ArrayList<>();
    GameFrame()
    {
        JFrame gameFrame = new JFrame();
        gameFrame.setSize(1000, 1000);
        gameFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        gameFrame.setVisible(true);
        gameFrame.setLayout(new BorderLayout());

        JPanel scoreAndtimePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 400,0));
        JLabel scoreLabel = new JLabel();
        scoreLabel.setVisible(true);
        scoreLabel.setFont(new Font("Calibri", Font.BOLD, 25));
        scoreAndtimePanel.add(scoreLabel);
        ActionListener scoreListener = e -> scoreLabel.setText(String.valueOf(Player.GetPoints()));
        Timer scoreCheck = new Timer(1000, scoreListener);
        scoreCheck.setInitialDelay(1);
        scoreCheck.start();


        JLabel timeLabel = new JLabel();
        timeLabel.setVisible(true);
        timeLabel.setFont(new Font("Calibri", Font.BOLD, 25));
        scoreAndtimePanel.add(timeLabel);

        ActionListener timerListener = e ->
        {
            String time = TimeFlow.time.toString();
            timeLabel.setText(time);
        };
        Timer timer = new Timer(1000, timerListener);
        timer.setInitialDelay(1);
        timer.start();


        JPanel gameFramePanel = new JPanel();
        gameFramePanel.setLayout(new GridLayout(4,3, 10,10));

        Font nameFont = new Font("Times New Roman", Font.PLAIN, 24);

        for(Country country: Country.GetContryList())
            CreateCountryButton(gameFramePanel, country, nameFont);


        gameFrame.getContentPane().add(BorderLayout.NORTH, scoreAndtimePanel);
        gameFrame.getContentPane().add(BorderLayout.CENTER, gameFramePanel);

    }

    private void CreateCountryButton(JPanel gameFramePanel, Country country, Font nameFont)
    {
        JButton countryBtn = new JButton(country.GetName());
        countryBtn.setFont(nameFont);
        if(!country.GetIsContaminated())
            countryBtn.setEnabled(false);
        btnList.add(countryBtn);
        ButtonActions ba = new ButtonActions();

        countryBtn.addActionListener(e ->
        {
            ButtonActions ba1 = new ButtonActions();
            ba1.OpenCountryMenu(country.GetName());
        });
        gameFramePanel.add(countryBtn);
    }


    public static class Buttons
    {
        public JButton GetBtn(String name)
        {
            for(JButton btn: btnList)
                if(btn.getText().equals(name))
                    return btn;
            return null;
        }
    }
}

