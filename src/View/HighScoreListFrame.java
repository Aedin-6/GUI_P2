package View;

import javax.swing.*;
import java.util.Vector;

public class HighScoreListFrame extends JFrame
{
        HighScoreListFrame()
        {
            Vector<String> highScores = new Vector<>();
            Score score = new Score("Wojtek", 124);
            Score score2 = new Score("Zbych", 124);
            highScores.add(0, score.toString());
            highScores.add(score2.toString());

            HighScoresList highScoreList = new HighScoresList(highScores);

            JList hscores = new JList();
            hscores.setModel(highScoreList);

            JScrollPane scorePane = new JScrollPane(hscores);
            this.getContentPane().add(scorePane);
            setSize(200, 200);
            setVisible(true);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        }
}
