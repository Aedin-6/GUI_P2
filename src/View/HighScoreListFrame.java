package View;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class HighScoreListFrame extends JFrame
{

        HighScoreListFrame()
        {
            Vector<String> highScores = HighScoresList.getHighScore();
            JFrame hs = new JFrame("High Scores");
            HighScoresList highScoreList = new HighScoresList(highScores);
            JList hscores = new JList();
            hscores.setModel(highScoreList);
            hscores.setBackground(Color.BLUE);
            Font nameFont = new Font("Times New Roman", Font.BOLD, 20);
            hscores.setFont(nameFont);
            hscores.setForeground(Color.YELLOW);
            JScrollPane scorePane = new JScrollPane(hscores);
            hs.getContentPane().add(scorePane);
            hs.setSize(350, 300);
            hs.setVisible(true);
            hs.setLocationRelativeTo(null);
            hs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
}
