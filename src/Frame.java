import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame
{
    public Frame()
    {
        GenerateFrame();
    }

    private void GenerateFrame()
    {
        JFrame startFrame = new JFrame("BoxLayoutDemo");
        startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startFrame.setLocationRelativeTo(null);
        setSize(500, 500);



        GenerateButtons(startFrame);


        pack();
        setVisible(true);
    }

    private void GenerateButtons(Container startFrame)
    {
        startFrame.setLayout(new BoxLayout(startFrame, BoxLayout.Y_AXIS));
        JButton first = new JButton("New Game");
        first.setAlignmentX(Component.CENTER_ALIGNMENT);
        startFrame.add(first);
        JButton second = new JButton("High Scores");
        second.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(second);
        JButton third = new JButton("Exit");
        third.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(third);
    }



    /*
    public Frame()
    {
        GenerateFrame();

    }

    private void GenerateFrame()
    {

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));


        JButton firstButton = new JButton("New Game");
        JButton secondButton = new JButton("High Scores");
        JButton thirdButton = new JButton("Exit");
        firstButton.setAlignmentX(CENTER_ALIGNMENT);
        secondButton.setAlignmentX(CENTER_ALIGNMENT);
        thirdButton.setAlignmentX(CENTER_ALIGNMENT);

        add(firstButton);
        add(secondButton);
        add(thirdButton);



        add(buttonPanel);
        setSize(500, 500);
        setVisible(true);
        setLocationRelativeTo(null);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);

     */
}

