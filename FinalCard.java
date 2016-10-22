import javax.swing.*;
import java.awt.*;

/**
 * Created by Matt on 10/21/16.
 */
public abstract class FinalCard{
    public abstract void showStats();
    //allows for showStats() from MineralCard and TrumpCard to be used

    public abstract String getName();
    //allows for getName() from MineralCard and TrumpCard to be used

    public abstract String getNewCurrentCategory(String current_category);
    //allows for getCurrentCategory() from MineralCard and TrumpCard to be used

    public abstract double getNewCurrentValue(String current_category);
    //allows for getCurrentValue() from MineralCard and TrumpCard to be used

    public abstract boolean checkIfPlayable(String current_category, double current_value);

    public ImageIcon transformPic(ImageIcon i)
    {
        Image image = i.getImage();
        Image new_image = image.getScaledInstance(150,200, Image.SCALE_SMOOTH);
        return (new ImageIcon(new_image));
    }
}
