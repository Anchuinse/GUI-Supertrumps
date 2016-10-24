/**
 * Created by Matt on 10/23/16.
 */
import javax.swing.*;
import java.awt.*;

public class CardButton extends JButton
{
    String string;
    ImageIcon image = new ImageIcon("/Users/Matt/Desktop/Australian School/" +
            "Programming Final/project_mineral_super_trumps_game-master/images/" + string + ".jpg");

    public CardButton()
    {
        string = "unassigned";
        image = null;
        //setIcon(image);
        setBackground(Color.BLACK);
        validate();
        repaint();
    }

    public CardButton(String new_string)
    {
        string = new_string;
        image = new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/" + string + ".jpg");
        //setIcon(image);
        setBackground(Color.YELLOW);
        validate();
        repaint();
    }

    public String getName()
    {
        return string;
    }

    public void renameButton(String new_string)
    {
        string = new_string;
        this.setBackground(Color.GREEN);
        //setIcon(image);
        validate();
        repaint();
    }
}
