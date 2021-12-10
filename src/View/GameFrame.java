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

        JPanel gameFramePanel = new JPanel();

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

        gameFramePanel.setLayout(new GridLayout(4,3, 10,10));

        JButton russia = new JButton("Russia");
        russia.setFont(new Font("Times New Roman", 0, 24));
        //russia.setIcon(new ImageIcon("russia.png"));
        gameFramePanel.add(russia);
        JButton usa = new JButton("USA");
        usa.setFont(new Font("Times New Roman", 0, 24));
        gameFramePanel.add(usa);
        JButton poland = new JButton("Poland");
        poland.setFont(new Font("Times New Roman", 0, 24));
        gameFramePanel.add(poland);
        JButton mexico = new JButton("Mexico");
        mexico.setFont(new Font("Times New Roman", 0, 24));
        gameFramePanel.add(mexico);
        JButton china = new JButton("China");
        china.setFont(new Font("Times New Roman", 0, 24));
        gameFramePanel.add(china);
        JButton japan = new JButton("Japan");
        japan.setFont(new Font("Times New Roman", 0, 24));
        gameFramePanel.add(japan);
        JButton france = new JButton("France");
        france.setFont(new Font("Times New Roman", 0, 24));
        gameFramePanel.add(france);
        JButton germany = new JButton("Germany");
        germany.setFont(new Font("Times New Roman", 0, 24));
        gameFramePanel.add(germany);
        JButton canada = new JButton("Canada");
        canada.setFont(new Font("Times New Roman", 0, 24));
        gameFramePanel.add(canada);
        JButton congo = new JButton("Congo");
        congo.setFont(new Font("Times New Roman", 0, 24));
        gameFramePanel.add(congo);
        JButton uae = new JButton("UAE");
        uae.setFont(new Font("Times New Roman", 0, 24));
        gameFramePanel.add(uae);
        JButton uk = new JButton("United Kingdom");
        uk.setFont(new Font("Times New Roman", 0, 24));
        gameFramePanel.add(uk);


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
}

