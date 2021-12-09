package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class GameFrame extends JFrame
{
    GameFrame()
    {
        JFrame gameFrame = new JFrame();
        gameFrame.setSize(1000, 1000);
        gameFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        gameFrame.setVisible(true);
        gameFrame.setLayout(new GridLayout(2,1));
        gameFrame.setPreferredSize(new Dimension((int)(25 * 2.5)+20,
                (int)(25.getHeight() * 3.5)+20 * 2);
        JPanel scoreAndTime = new JPanel();
        gameFrame.add(scoreAndTime);
        JPanel gameFramePanel = new JPanel();
        gameFramePanel.setLayout(new GridLayout(4,3));
        gameFramePanel.add(new JButton("Btn1"));
        gameFramePanel.add(new JButton("Btn2"));
        gameFramePanel.add(new JButton("Btn3"));
        gameFramePanel.add(new JButton("Btn1"));
        gameFramePanel.add(new JButton("Btn2"));
        gameFramePanel.add(new JButton("Btn3"));
        gameFramePanel.add(new JButton("Btn1"));
        gameFramePanel.add(new JButton("Btn2"));
        gameFramePanel.add(new JButton("Btn3"));
        gameFramePanel.add(new JButton("Btn1"));
        gameFramePanel.add(new JButton("Btn2"));
        gameFramePanel.add(new JButton("Btn3"));
        gameFrame.add(gameFramePanel);
/*
        try {
            BufferedImage buttonIcon = ImageIO.read(new File("C:\\Users\\Aedin\\Downloads\\icon.png"));
            Image newImage = buttonIcon.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
            JButton button = new JButton(new ImageIcon(newImage));

            button.setBorder(BorderFactory.createEmptyBorder());
            button.setContentAreaFilled(false);
            button.setSize(20,20);
            gameFrame.getContentPane().add(button);

        }
        catch (Exception e){};
*/

    }
}

