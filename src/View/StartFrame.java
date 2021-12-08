package View;

import javax.swing.*;
import java.awt.*;

public class StartFrame extends JFrame
{
    public StartFrame()
    {
        GenerateStartFrame();
    }

    private static void GenerateStartFrame()
    {


        JFrame frame = new JFrame("CoronaAntiPlague");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        Container pane = frame.getContentPane();

        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        pane.setLocation(123, 4324);

        JButton newGame = new JButton("New Game");
        newGame.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(newGame);
        newGame.addActionListener(e -> {
            frame.dispose();
            SetDifficulty();
        }
        );

        JButton highScores = new JButton("High Scores");
        highScores.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(highScores);
        highScores.addActionListener(e -> {
            frame.dispose();
            OpenHighScores();
        });

        JButton third = new JButton("Exit");
        third.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(third);

        third.addActionListener(e -> {
            System.exit(0);
        });

        frame.setSize(300,150);
        frame.setVisible(true);
    }

    private static void OpenHighScores()
    {
        new HighScoreListFrame();
    }

    private static void SetDifficulty()
    {
        String[] possibleValues = { "Easy", "Normal", "Hard" };
        Object selectedValue = JOptionPane.showInputDialog(null,
                "Choose Difficulty:", "Set Difficulty",
                JOptionPane.QUESTION_MESSAGE, null,
                possibleValues, possibleValues[0]);

        if (selectedValue != null)
        {
            switch((String) selectedValue)
            {
            case "Easy":
            {
                new GameFrame();
                GameModel.Start.StartNewGame((String) selectedValue);
                break;
            }
            case "Normal":
            {
                new GameFrame();
                GameModel.Start.StartNewGame((String) selectedValue);
                break;
            }
            case "Hard":
            {
                new GameFrame();
                GameModel.Start.StartNewGame((String) selectedValue);
                break;
            }
            }
        }
        else
           GenerateStartFrame();

    }
}

