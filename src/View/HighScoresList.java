package View;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class HighScoresList extends AbstractListModel
{
    private Vector<String> nick;
    private Vector<Integer> scores;

    public HighScoresList(Vector<String> nick, Vector<Integer> scores) {
        this.nick = nick;
        this.scores = scores;
    }

    @Override
    public int getSize() {
        return nick.size();
    }

    @Override
    public Object getElementAt(int index)
    {
        return nick.get(index);
    }

    
    public void AddScore(String name, int score, int index)
    {
       nick.add(index, name);
       scores.add(index, score);
       fireIntervalAdded(this, index, index);
    }
}
class HighScore()
{

}
