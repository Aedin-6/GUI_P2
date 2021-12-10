package View;
import GameModel.Assets.Player;
import GameModel.TimeFlow;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameFrame extends JFrame
{
    GameFrame()
    {
        JFrame gameFrame = new JFrame();
        gameFrame.setSize(1000, 1000);
        gameFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        gameFrame.setVisible(true);
        gameFrame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();



        JPanel score = new JPanel();
        JLabel scoreLabel = new JLabel();
        scoreLabel.setVisible(true);
        scoreLabel.setFont(new Font("Calibri", Font.BOLD, 25));
        score.add(scoreLabel);
        ActionListener scoreListener = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                scoreLabel.setText(Player.GetStringPoints());
            }
        };
        Timer scoreCheck = new Timer(1000, scoreListener);
        scoreCheck.setInitialDelay(1);
        scoreCheck.start();


        JPanel time = new JPanel();
        JLabel timeLabel = new JLabel();
        timeLabel.setVisible(true);
        timeLabel.setFont(new Font("Calibri", Font.BOLD, 25));
        time.add(timeLabel);

        ActionListener timerListener = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String time = TimeFlow.time.toString();
                timeLabel.setText(time);
            }
        };
        Timer timer = new Timer(1000, timerListener);
        timer.setInitialDelay(1);
        timer.start();


        JPanel gameFramePanel = new JPanel();
        gameFramePanel.setLayout(new GridLayout(4,3, 10,10));

        Font nameFont = new Font("Times New Roman", 0, 24);
        CreateCountryButton(gameFramePanel, "Russia", nameFont);
        CreateCountryButton(gameFramePanel, "USA", nameFont);
        CreateCountryButton(gameFramePanel, "Poland", nameFont);
        CreateCountryButton(gameFramePanel, "Mexico", nameFont);
        CreateCountryButton(gameFramePanel, "UK", nameFont);
        CreateCountryButton(gameFramePanel, "Germany", nameFont);
        CreateCountryButton(gameFramePanel, "France", nameFont);
        CreateCountryButton(gameFramePanel, "China", nameFont);
        CreateCountryButton(gameFramePanel, "Japan", nameFont);
        CreateCountryButton(gameFramePanel, "Norway", nameFont);
        CreateCountryButton(gameFramePanel, "Canada", nameFont);
        CreateCountryButton(gameFramePanel, "Italy", nameFont);



        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 10;
        c.gridwidth = 3;
        gameFrame.add(score);

        c.gridx = 3;
        c.gridy = 1;
        c.anchor = GridBagConstraints.FIRST_LINE_END;
        gameFrame.add(time);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 700;
        c.weightx = 10;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 1;
        c.anchor = GridBagConstraints.LAST_LINE_START;
        gameFrame.add(gameFramePanel,c);

    }

    private void CreateCountryButton(JPanel gameFramePanel, String name, Font nameFont)
    {
        JButton country = new JButton(name);
        country.setFont(nameFont);
        ButtonActions ba = new ButtonActions();
        country.addActionListener(ba);
        gameFramePanel.add(country);

    }
}

