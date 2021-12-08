package View;

import javax.swing.*;
import java.util.Vector;

public class HighScoreListFrame extends JFrame
{
        HighScoreListFrame()
        {
            Vector<String> nicks = new Vector<>();
            Vector<Integer> scores = new Vector<>();
            nicks.add("Abs");
            nicks.add("qew");
            scores.add(123);
            scores.add(432);
            HighScoresList highScoreList = new HighScoresList(nicks, scores);
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
