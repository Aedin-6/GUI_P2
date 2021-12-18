package View;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class HighScoresList extends AbstractListModel
{
    private static Vector<String> highScore = new Vector<>();


    public HighScoresList(Vector<String> highScore)
    {
        if((new File("ScoreBoard")).exists())
            HighScoresList.highScore = Load();
        else
            HighScoresList.highScore = highScore;
    }

    private Vector<String> Load()
    {
        Vector<String> highScore = new Vector<>();
        try
        {
            FileInputStream fis = new FileInputStream("ScoreBoard");
            ObjectInputStream ois = new ObjectInputStream(fis);
            highScore = ( Vector<String>) ois.readObject();
            ois.close();

        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error during loading scoreboard: " + e.toString(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return highScore;
    }

    public static Vector<String> getHighScore()
    {
        return highScore;
    }

    @Override
    public int getSize() {
        return highScore.size();
    }

    @Override
    public Object getElementAt(int index)
    {
        return highScore.get(index);
    }


    public void AddScore(Score score, int index)
    {
       highScore.add(index, score.toString());
       fireIntervalAdded(this, index, index);
    }

    public void AddScore(Score score)
    {
        highScore.add(getSize(), score.toString());
    }

}
class Score
{
    String nick;
    int score;

    Score(String nick, int score)
    {
        this.nick = nick;
        this.score = score;
    }


    @Override
    public String toString()
    {
        return "NICK: " + nick + " SCORE: " + score;
    }
}
