package View;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class HighScoresList extends AbstractListModel
{
    private Vector<String> highScore;

    public HighScoresList(Vector<String> highScore)
    {
        this.highScore = highScore;
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
