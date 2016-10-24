import javax.swing.*;
import java.util.Scanner;

/**
 * Created by Matt on 10/21/16.
 */
public class FinalTrumpCard extends FinalCard
        //the template for all trump cards
{
    String name, category;

    public FinalTrumpCard()
    //basic constructor, creates an unnamed card that allows players to choose the playable trump
    {
        name = "Unnamed_Trump";
        category = "your choice";
    }

    public FinalTrumpCard(String newname, String newcategory)
    //constructor: accepts a name and a trump that the card will turn the active trump too
    //will only accept hardness, specific gravity, crystal abundance, economic value, cleavage or your choice for newcategory
    //prompts for a valid category/trump if given an invalid one
    {
        name = newname;
        if (newcategory.equals("hardness") || newcategory.equals("specific gravity") || newcategory.equals("crystal abundance") || newcategory.equals("economic value") || newcategory.equals("cleavage") || newcategory.equals("your choice"))
        {
            category = newcategory;
        }
        else
        {
            System.out.println("The trump you entered was not valid, please enter a valid trump category:");
            Scanner scanner = new Scanner(System.in);
            String validcategory = scanner.nextLine();
            this.changeCategory(validcategory);
        }
    }

    public void showStats()
    //displays a brief description of the card's effect
    {
        System.out.printf("%20s", name + ":");
        System.out.println(" allows a player to change the playable trump to "+ category + ".");
        //System.out.println(name + " allows a player to change the playable trump to "+ category + ".");
    }

    public void changeName(String newname)
    //changes the name of a card
    {
        name = newname;
    }

    public void changeCategory(String newcategory)
    //changes the category the card changes the playable trump too
    {
        switch(newcategory)
        {
            case "hardness":
                category = newcategory;
                break;
            case "specific gravity":
                category = newcategory;
                break;
            case "economic value":
                category = newcategory;
                break;
            case "crystal abundance":
                category = newcategory;
                break;
            case "cleavage":
                category = newcategory;
                break;
            default:
                System.out.println("The trump you entered was invalid, please enter a valid trump category:");
                Scanner newscanner = new Scanner(System.in);
                this.changeCategory(newscanner.nextLine());
        }
    }

    public String getName()
    //retrieves name of card
    {
        return name;
    }

    public String getCategory()
    //retrieves category the card will change the playable trump too
    {
        return category;
    }

    public String getNewCurrentCategory(String current_category)
    //returns the category to the category of the trump card
    {
        if (category.equals("your choice"))        //deals with trump cards that give the player a choice
        {
            System.out.println("Which category do you want the new playable trump to be?");
            Scanner scanner = new Scanner(System.in);
            String newcategory = scanner.nextLine();
            switch(newcategory.toLowerCase())
            {
                case "hardness":
                    current_category = "hardness";
                    break;
                case "economic value":
                    current_category = "economic value";
                    break;
                case "cleavage":
                    current_category = "cleavage";
                    break;
                case "specific gravity":
                    current_category = "specific gravity";
                    break;
                case "crystal abundance":
                    current_category = "crystal abundance";
                    break;
                default:
                    System.out.println("Your answer was unclear, pick one of the five categories:");
                    System.out.println(" hardness, specific gravity, economic value, crystal abundance, or cleavage");
                    getNewCurrentCategory(current_category);
            }
        }
        else
        //deals with all other trump cards
        {
            current_category = category;
        }
        return current_category;
    }

    public double getNewCurrentValue(String current_category)
    //returns -1 because a trump card reverts the playable trump
    {
        return -1;
    }

    public boolean checkIfPlayable(String current_category, double current_value)
    //since all supertrump cards are always playable this always returns true
    {return true;}

}
