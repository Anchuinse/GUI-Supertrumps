/**
 * Created by Matt on 10/23/16.
 */
import javax.swing.*;
import java.awt.*;

public class CardButton extends JButton
{
    String string;
    ImageIcon image = new ImageIcon("/Users/Matt/Desktop/Australian School/" +
            "Programming Final/project_mineral_super_trumps_game-master/images/Apatite.jpg");
    JPanel panel = new JPanel();
    JLabel label = new JLabel();
    Dimension size = new Dimension(150,150);

    public CardButton()
    {
        panel.setSize(size);
        add(panel);
        panel.add(label);
        string = "unassigned";
        image = null;
        //label.setIcon(image);
        validate();
        repaint();
    }

    public CardButton(String new_string)
    {
        panel.setSize(size);
        add(panel);
        panel.add(label);
        string = new_string;
        image = new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/Apatite.jpg");
        label.setIcon(image);
        //label.setIcon(image);
        //panel.setBackground(Color.YELLOW);
        validate();
        repaint();
    }

    public String getName()
    {
        return string;
    }

    public void renameButton(String new_string)
    {
        panel.setPreferredSize(size);
        string = new_string;
        //label.setPreferredSize(size);
        label.setIcon(transformPic(image));
        //label.setText(string);
        validate();
        repaint();
    }

    public ImageIcon transformPic(ImageIcon i)
    {
        Image image = i.getImage();
        Image new_image = image.getScaledInstance(150,200, Image.SCALE_SMOOTH);
        return (new ImageIcon(new_image));
    }
}
