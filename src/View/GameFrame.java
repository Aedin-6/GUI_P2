package View;
import GameModel.Assets.Country;
import GameModel.Assets.Player;
import GameModel.Assets.Virus;
import GameModel.TimeFlow;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;


public class GameFrame extends JFrame
{
    private static JFrame  gameFrame;
    private static ArrayList<JButton> btnList = new ArrayList<>();
    GameFrame()
    {
        gameFrame = this;

        this.setTitle("Corona Anti Plague!");
        this.setSize(1700, 1000);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(new BorderLayout());

        JPanel scoreAndtimePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 300, 0));
        JLabel scoreLabel = new JLabel();
        scoreLabel.setVisible(true);
        scoreLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
        scoreAndtimePanel.add(scoreLabel);
        ActionListener scoreListener = e -> scoreLabel.setText("Score: " + Player.GetPoints());
        Timer scoreCheck = new Timer(100, scoreListener);
        scoreCheck.setInitialDelay(1);
        scoreCheck.start();


        JLabel timeLabel = new JLabel();
        timeLabel.setVisible(true);
        timeLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
        scoreAndtimePanel.add(timeLabel);

        ActionListener timerListener = e ->
        {
            String time = TimeFlow.time.toString();
            timeLabel.setText("Time: " + time);
        };
        Timer timer = new Timer(100, timerListener);
        timer.setInitialDelay(1);
        timer.start();

        JLabel virusLabel = new JLabel();
        virusLabel.setVisible(true);
        virusLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
        virusLabel.setForeground(Color.RED);
        scoreAndtimePanel.add(virusLabel);
        ActionListener virusListener = e -> virusLabel.setText("Virus/Population: "+ Virus.GetCount() + "/" + Country.GetWorldPopulation());
        Timer virusCheck = new Timer(100, virusListener);
        virusCheck.setInitialDelay(1);
        virusCheck.start();


        JPanel gameFramePanel = new JPanel();
        gameFramePanel.setLayout(new GridLayout(4, 3, 10, 10));

        Font nameFont = new Font("Times New Roman", Font.PLAIN, 24);

        for (Country country : Country.GetCountryList())
            CreateCountryButton(gameFramePanel, country, nameFont);


        this.getContentPane().add(BorderLayout.NORTH, scoreAndtimePanel);
        this.getContentPane().add(BorderLayout.CENTER, gameFramePanel);
        this.setFocusable(true);
        BreakListener breakListener = new BreakListener();
        this.addKeyListener(breakListener);
        Timer checkKeys = new Timer(10, breakListener.checkIfPressed);
        checkKeys.start();

    }

    public static void exitFrame()
    {
        gameFrame.dispose();
    }

    private void CreateCountryButton(JPanel gameFramePanel, Country country, Font nameFont)
    {
        JButton countryBtn = new JButton(country.GetName());
        countryBtn.setFont(nameFont);

        ActionListener countListener = e ->
        {
            String tttext = String.format("This tool tip for %s. \nPopulation: %2d.\nInfected Population: %2d", country.GetName(), country.GetPopulation(), country.GetInfectedPopulationCount());
            countryBtn.setToolTipText(tttext);
        };
        Timer timer = new Timer(1000, countListener);
        timer.setInitialDelay(1);
        timer.start();

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

