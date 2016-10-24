import javax.swing.*;

import static java.lang.Math.round;

/**
 * Created by Matt on 10/21/16.
 */
public class FinalMineralCard extends FinalCard
        //the template for all mineral cards
{
    String name;
    double hardness,specific_gravity;
    double crystal_abundance, economic_value, cleavage;

    public FinalMineralCard()
    //basic constructor, creates an essentially worthless card (all lowest values)
    {
        name = "Unnamed_Mineral";
        hardness = 0;
        specific_gravity = 0;
        cleavage = 0;
        // in string form cleavage is referred to as cleave
        crystal_abundance = 0;
        // in string form crystal abundance is referred to as rarity
        economic_value = 0;
        // in string form economic value is referred to as price
    }

    public FinalMineralCard(String newname, double input_h, double input_sg, String cv, String ca, String ev)
    //constructor: accepts numbers for hardness and specific gravity and accepts strings for cleavage, abundance, and econ
    {
        name = newname;
        hardness = input_h;
        if (input_h < 1 || input_h > 10)
        {
            System.out.println("Hardness must be between 1 and 10 based on Moh's hardness scale.");
            System.out.println("Hardness set to 1 by default.");
            hardness = 1;
        }
        specific_gravity = input_sg;
        cleavage = cleaveToCleavage(cv);
        crystal_abundance = rarityToAbundance(ca);
        economic_value = priceToEconomicValue(ev);
    }

    public void showStats()
    //shows the hardness, specific gravity, cleavage, crystal abundance, and economic value of a card
    {
        String cv,ca,ev;
        cv = cleavageToCleave(cleavage);
        ca = abundanceToRarity(crystal_abundance);
        ev = economicValueToPrice(economic_value);
        System.out.printf("%20s", name + ":");
        System.out.printf("%11s", "hardness:");
        System.out.printf("%4s", hardness);
        System.out.printf("%18s", "specific gravity:");
        System.out.printf("%4s", specific_gravity);
        System.out.printf("%11s", "cleavage:");
        System.out.printf("%20s", cv);
        System.out.printf("%20s", "crystal abundance:");
        System.out.printf("%10s", ca);
        System.out.printf("%18s", "economic value:");
        System.out.printf("%10s", ev);
        System.out.println("");
        //System.out.println(name + ": hardness:" + hardness + " specific gravity:" + specific_gravity + " cleavage:" + cv + " crystal abundance:" + ca + " and economic value:" + ev);
    }

    public double cleaveToCleavage(String cleave)
    //converts cleavage string value into a numerical value
    {
        switch(cleave)
        {
            case "none":
                cleavage = 0;
                break;
            case "poor/none":
                cleavage = 1;
                break;
            case "1 poor":
                cleavage = 2;
                break;
            case "2 poor":
                cleavage = 3;
                break;
            case "1 good":
                cleavage = 4;
                break;
            case "1 good, 1 poor":
                cleavage = 5;
                break;
            case "2 good":
                cleavage = 6;
                break;
            case "3 good":
                cleavage = 7;
                break;
            case "1 perfect":
                cleavage = 8;
                break;
            case "1 perfect, 1 good":
                cleavage = 9;
                break;
            case "1 perfect, 2 good":
                cleavage = 10;
                break;
            case "2 perfect, 1 good":
                cleavage = 11;
                break;
            case "3 perfect":
                cleavage = 12;
                break;
            case "4 perfect":
                cleavage = 13;
                break;
            case "6 perfect":
                cleavage = 14;
                break;
            default:
                System.out.println("Cleavage unclear.");
                System.out.println("Cleavage set to none by default.");
                cleavage = 0;
                break;
        }
        return cleavage;
    }

    public String cleavageToCleave(double cleavage)
    //converts cleavage numerical value into a string value
    {
        int rounded = (int) round(cleavage);
        String cleave="";
        switch(rounded)
        {
            case 0:
                cleave = "none";
                break;
            case 1:
                cleave = "poor/none";
                break;
            case 2:
                cleave = "1 poor";
                break;
            case 3:
                cleave = "2 poor";
                break;
            case 4:
                cleave = "1 good";
                break;
            case 5:
                cleave = "1 good, 1 poor";
                break;
            case 6:
                cleave = "2 good";
                break;
            case 7:
                cleave = "3 good";
                break;
            case 8:
                cleave = "1 perfect";
                break;
            case 9:
                cleave = "1 perfect, 1 good";
                break;
            case 10:
                cleave = "1 perfect, 2 good";
                break;
            case 11:
                cleave = "2 perfect, 1 good";
                break;
            case 12:
                cleave = "3 perfect";
                break;
            case 13:
                cleave = "4 perfect";
                break;
            case 14:
                cleave = "6 perfect";
                break;
            default:
                System.out.println("Error in cleavage value.");
                System.out.println("Cleave set to 'none' by default.");
                break;
        }
        return cleave;
    }

    public double rarityToAbundance(String rarity)
    //converts crystal abundance string value into a numerical value
    {
        double ca=7;
        switch(rarity)
        {
            case "ultratrace":
                ca = 0;
                break;
            case "trace":
                ca = 1;
                break;
            case "low":
                ca = 2;
                break;
            case "moderate":
                ca = 3;
                break;
            case "high":
                ca = 4;
                break;
            case "very high":
                ca = 5;
                break;
            default:
                System.out.println("Crystal abundance unclear.");
                System.out.println("Crystal abundance set to ultratrace by default.");
                ca = 0;
                break;
        }
        return ca;
    }

    public String abundanceToRarity(double crystal_abundance)
    //converts crystal abundance numerical value into a string value
    {
        int rounded = (int) round(crystal_abundance);
        String rarity = "";
        switch(rounded)
        {
            case 0:
                rarity = "ultratrace";
                break;
            case 1:
                rarity = "trace";
                break;
            case 2:
                rarity = "low";
                break;
            case 3:
                rarity = "moderate";
                break;
            case 4:
                rarity = "high";
                break;
            case 5:
                rarity = "very high";
                break;
            default:
                System.out.println("Crystal Abundance unclear.");
                System.out.println("Crystal Abundance set to ultratrace by default.");
                rarity = "ultratrace";
                break;
        }
        return rarity;
    }

    public double priceToEconomicValue(String price)
    //converts economic value string value into a numerical value
    {
        byte ev;
        switch(price)
        {
            case "trivial":
                ev = 0;
                break;
            case "low":
                ev = 1;
                break;
            case "moderate":
                ev = 2;
                break;
            case "high":
                ev = 3;
                break;
            case "very high":
                ev = 4;
                break;
            case "I'm rich!":
                ev = 5;
                break;
            default:
                System.out.println("Economic value unclear.");
                System.out.println("Economic value set to trivial by default.");
                ev = 0;
                break;
        }
        return ev;
    }

    public String economicValueToPrice(double economic_value)
    //converts economoic value string value into a numerical value
    {
        int rounded = (int) round(economic_value);
        String price = "";
        switch(rounded)
        {
            case 0:
                price = "trivial";
                break;
            case 1:
                price = "low";
                break;
            case 2:
                price = "moderate";
                break;
            case 3:
                price = "high";
                break;
            case 4:
                price = "very high";
                break;
            case 5:
                price = "I'm rich!";
                break;
            default:
                System.out.println("Economic value is unclear.");
                System.out.println("Economic value set to trivial by default.");
                price = "trivial";
        }
        return price;
    }

    public String getName()
    //returns name; pretty simple
    {
        return name;
    }

    public double getHardness()
    //gets hardness
    {
        return hardness;
    }

    public double getGravity()
    //gets specific gravity
    {
        return specific_gravity;
    }

    public double getAbundance()
    //gets raw crystal abundance score used in computing, use showStats to see non-number value
    {
        return crystal_abundance;
    }

    public double getValue()
    //gets raw economic value score used in computing, use showStats to see non-number value
    {
        return economic_value;
    }

    public double getCleavage()
    //gets raw cleavage value score used in computing, use showStats to see non-number value
    {
        return cleavage;
    }

    public String getNewCurrentCategory(String current_category)
    //returns the current_category
    //does nothing because Mineral Cards do not change category
    {
        return current_category;
    }

    public double getNewCurrentValue(String current_category)
    //returns the value of the current trump category of the card
    {
        double newvalue = -1;
        switch(current_category)
        {
            case "hardness":
                newvalue = hardness;
                break;
            case "economic value":
                newvalue = economic_value;
                break;
            case "specific gravity":
                newvalue = specific_gravity;
                break;
            case "crystal abundance":
                newvalue = crystal_abundance;
                break;
            case "cleavage":
                newvalue = cleavage;
                break;
            default:
                System.out.println("BRO YOU HAVE A PROBLEM BECAUSE YOU ENTERED THE WRONG CURRENT CATEGORY IN YOUR CODE SOMEWHERE");
                break;

        }
        if (newvalue==-1)
        {
            System.out.println("YOUR getCurrentValue() HAS SOME PROBLEMS!!!");
        }
        return newvalue;
    }

    public boolean checkIfPlayable(String current_category, double current_value)
    //compares the card to the current value of the currently playable trump category
    { boolean returns = true;
        if(current_category.equals("hardness"))
        {
            if(getHardness() > current_value)
            {
                returns = true;
            }
            else
            {
                returns = false;
            }
        }
        if(current_category.equals("specific gravity"))
        {
            if(getGravity() > current_value)
            {
                returns = true;
            }
            else
            {
                returns = false;
            }
        }
        if(current_category.equals("economic value"))
        {
            if(getValue() > current_value)
            {
                returns = true;
            }
            else
            {
                returns = false;
            }
        }
        if(current_category.equals("crystal abundance"))
        {
            if(getAbundance() > current_value)
            {
                returns = true;
            }
            else
            {
                returns = false;
            }
        }
        if(current_category.equals("cleavage"))
        {
            if(getCleavage() > current_value)
            {
                returns = true;
            }
            else
            {
                returns = false;
            }
        }
        return returns;
    }

}