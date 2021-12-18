package View;

import GameModel.Assets.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Vector;

public class EndGameFrame extends JFrame
{
    String dialogTitle = "";
    ImageIcon icon;
    public EndGameFrame(boolean WinOrLose)
    {
        JFrame endGame = new JFrame("End Game");
        if(WinOrLose)
        {

            BufferedImage victoryImg = null;
            try
            {
                FileInputStream file = new FileInputStream("Firework.jpg");
                victoryImg = ImageIO.read(file);
            } catch (IOException e)
            {
                e.printStackTrace();
            }
            Image dimg = victoryImg.getScaledInstance(800, 508, Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(dimg);
            endGame.add(new JLabel(imageIcon));

            JOptionPane provideScore = new JOptionPane("You have won!", JOptionPane.INFORMATION_MESSAGE, JOptionPane.YES_NO_OPTION);
            provideScore.createDialog("You have won!");
            provideScore.setVisible(true);
            dialogTitle = "Congrats! You have won!";
            icon = new ImageIcon("successIcon.jpg");
        }
        else
        {
            BufferedImage defeatImg = null;
            try
            {
                FileInputStream file = new FileInputStream("defeat.jpg");
                defeatImg = ImageIO.read(file);
            } catch (IOException e)
            {
                e.printStackTrace();
            }
            Image dimg = defeatImg.getScaledInstance(800, 508, Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(dimg);
            endGame.add(new JLabel(imageIcon));
            dialogTitle = "Everybody is dead! You have lost!";
            icon = new ImageIcon("skullIcon.jpg");

        }
        endGame.setSize(500, 500);
        endGame.setLocationRelativeTo(null);
        endGame.setVisible(true);
        String scoreText = String.format("Your score: %2d \nProvide your name: ", Player.GetPoints());
        String playerName = (String)JOptionPane.showInputDialog(endGame, scoreText, dialogTitle,
                JOptionPane.PLAIN_MESSAGE, icon, null, "");

        Vector<String> ladder = new Vector<>();
        if((new File("ScoreBoard")).exists())
           ladder  = Load();

        if(playerName.length() > 0 && playerName != null)
        {
            Score score = new Score(playerName, Player.GetPoints());
            ladder.add(score.toString());
        }
        else
        {
            playerName = "No Name";
            Score score = new Score(playerName, Player.GetPoints());
            ladder.add(score.toString());
        }
        Save(ladder);
        new HighScoreListFrame();
    }

    private void Save(Vector<String> highScore)
    {
        try
        {
            FileOutputStream scoreBoard = new FileOutputStream("ScoreBoard");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(scoreBoard);
            objectOutputStream.writeObject(highScore);
            objectOutputStream.close();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error during saving the scoreboard: " + e.toString(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
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
}
