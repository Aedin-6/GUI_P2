package View;

import GameModel.Start;

import javax.swing.*;
import java.awt.*;

public class StartFrame extends JFrame
{
    private static String difficulty;

    public static String getDifficulty()
    {
        return difficulty;
    }

    public static void setDifficulty(String difficulty)
    {
        StartFrame.difficulty = difficulty;
    }

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

        third.addActionListener(e -> System.exit(0));

        frame.setSize(300,120);
        frame.setVisible(true);
    }

    private static void OpenHighScores()
    {
        new HighScoreListFrame();
    }

    private static void SetDifficulty()
    {
        Start start = new Start();
        String[] possibleValues = { "Easy", "Normal", "Hard" };
        Object selectedValue = JOptionPane.showInputDialog(null,
                "Choose Difficulty:", "Set Difficulty",
                JOptionPane.QUESTION_MESSAGE, null,
                possibleValues, possibleValues[0]);
        setDifficulty((String) selectedValue);
        if (selectedValue != null)
        {
            switch ((String) selectedValue)
            {
                case "Easy" -> {
                    start.StartNewGame();
                    new GameFrame();
                }
                case "Normal" -> {
                    start.StartNewGame();
                    new GameFrame();
                }
                case "Hard" -> {
                    start.StartNewGame();
                    new GameFrame();
                }
            }
        }
        else
           GenerateStartFrame();
    }
}

