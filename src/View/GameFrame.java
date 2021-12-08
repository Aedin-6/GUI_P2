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


    }
}

