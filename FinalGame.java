import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import static java.lang.Math.round;

/**
 * Created by Matt on 10/21/16.
 */
public class FinalGame extends JFrame implements ActionListener
{
    int who_turn, winner_number;
    String current_category;
    double current_value;
    ArrayList<FinalCard> Deck;
    FinalPlayer[] playerlist, winnerlist;

    public FinalGame()
    //constructor: asks for number of players and let's you name them
    {
        System.out.println("Let's play Mineral SuperTrumps!");
        int playernumber = askForPlayers();
        FinalPlayer[] players = new FinalPlayer[playernumber];
        for (int i = 0; i < playernumber; ++i) {
            int number = i + 1;
            System.out.println("What is the name of Player " + number + "?");
            Scanner scanner = new Scanner(System.in);
            String inputname = scanner.nextLine();
            players[i] = new FinalPlayer(number, inputname);
        }
        Random generator = new Random();
        who_turn = generator.nextInt(playernumber);     //decides first person at random
        current_category = "none";
        current_value = -1;                                 //use -1 as default so lowest value(0) card can play
        Deck = initializeDeck();
        playerlist = players;
        winnerlist = new FinalPlayer[playernumber - 1];
        winner_number = 0;
    }

    public int askForPlayers()
    //this method is an easy way to ask about the number of players needed in a game
    //it will correct until the value put in is either 3, 4, or 5
    {
        int returnvalue = 0;
        System.out.println("Are there 3, 4, or 5 players?");
        Scanner scanner = new Scanner(System.in);
        int numberofplayers = scanner.nextInt();
        switch (numberofplayers) {
            case 3:
                returnvalue = 3;
                break;
            case 4:
                returnvalue = 4;
                break;
            case 5:
                returnvalue = 5;
                break;
            default:
                System.out.println("I'm sorry, that was unclear. Please only enter numbers 3, 4, or 5.");
                askForPlayers();
        }
        return returnvalue;
    }

    public ArrayList<FinalCard> initializeDeck()
    //fill this out, and change Deck length
    {
        ArrayList Deck = new ArrayList();
        Deck.add(new FinalMineralCard("Apatite", 5, 3.2, "2 poor", "low", "high", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/Apatite.jpg")));
        Deck.add(new FinalMineralCard("Augite", 6.5, 3.6, "2 good", "high", "trivial", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/Augite.jpg")));
        Deck.add(new FinalMineralCard("Barite", 3.5, 4.5, "2 perfect, 1 good", "trace", "moderate", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/Barite.jpg")));
        Deck.add(new FinalMineralCard("Beryl", 8, 2.9, "1 poor", "trace", "moderate", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/Beryl.jpg")));
        Deck.add(new FinalMineralCard("Biotite", 3, 3.3, "1 perfect", "moderate", "low", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/Biotite.jpg")));
        Deck.add(new FinalMineralCard("Calcite", 3, 2.7, "3 perfect", "moderate", "high", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/Calcite.jpg")));
        Deck.add(new FinalMineralCard("Cassiterite", 7, 7.1, "1 good, 1 poor", "trace", "high", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/Cassiterite.jpg")));
        Deck.add(new FinalMineralCard("Chalcopyrite", 4, 4.3, "2 poor", "low", "very high", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/Chalcopyrite.jpg")));
        Deck.add(new FinalMineralCard("Chlorite", 3, 3.3, "1 perfect", "moderate", "low", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/Chlorite.jpg")));
        Deck.add(new FinalMineralCard("Chromite", 5.5, 5.1, "none", "low", "high", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/Chromite.jpg")));
        Deck.add(new FinalMineralCard("Corundum", 9, 4, "none", "trace", "moderate", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/Corundum.jpg")));
        Deck.add(new FinalMineralCard("Diamond", 10, 3.5, "4 perfect", "ultratrace", "I'm rich!", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/Diamond.jpg")));
        Deck.add(new FinalMineralCard("Dolomite", 4, 2.9, "3 perfect", "low", "low", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/Dolomite.jpg")));
        Deck.add(new FinalMineralCard("Epidote", 6.5, 3.5, "1 perfect", "moderate", "trivial", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/Epidote.jpg")));
        Deck.add(new FinalMineralCard("Fluorite", 4, 3.2, "4 perfect", "trace", "moderate", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/Fluorite.jpg")));
        Deck.add(new FinalMineralCard("Galena", 2.5, 7.6, "3 perfect", "trace", "high", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/Galena.jpg")));
        Deck.add(new FinalMineralCard("Garnet", 7.5, 4.3, "none", "moderate", "moderate", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/Garnet.jpg")));
        Deck.add(new FinalMineralCard("Gibbsite", 3.5, 2.4, "1 perfect", "low", "high", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/Gibbsite.jpg")));
        Deck.add(new FinalMineralCard("Glaucophane", 6, 3.2, "2 good", "low", "trivial", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/Glaucophane.jpg")));
        Deck.add(new FinalMineralCard("Goethite", 5.5, 4.3, "1 perfect, 1 good", "moderate", "moderate", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/Goethite.jpg")));
        Deck.add(new FinalMineralCard("Gold", 3, 19.3, "none", "ultratrace", "I'm rich!", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/Gold.jpg")));
        Deck.add(new FinalMineralCard("Graphite", 2, 2.2, "1 perfect", "trace", "moderate", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/Graphite.jpg")));
        Deck.add(new FinalMineralCard("Gypsum", 2, 2.3, "1 perfect, 2 good", "trace", "high", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/Gypsum.jpg")));
        Deck.add(new FinalMineralCard("Halite", 2.5, 2.2, "3 perfect", "trace", "moderate", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/Halite.jpg")));
        Deck.add(new FinalMineralCard("Hematite", 6, 5.3, "none", "trace", "high", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/Hematite.jpg")));
        Deck.add(new FinalMineralCard("Hornblende", 6, 3.5, "2 good", "moderate", "trivial", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/Hornblende.jpg")));
        Deck.add(new FinalMineralCard("Ilmenite", 6, 4.8, "none", "low", "moderate", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/Ilmenite.jpg")));
        Deck.add(new FinalMineralCard("Kaolinite", 2.5, 2.7, "1 perfect", "moderate", "high", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/Kaolinite.jpg")));
        Deck.add(new FinalMineralCard("Kyanite", 7, 3.7, "1 perfect, 1 good", "trace", "moderate", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/Kyanite.jpg")));
        Deck.add(new FinalMineralCard("Magnesite", 4, 3, "3 perfect", "low", "moderate", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/Magnesite.jpg")));
        Deck.add(new FinalMineralCard("Magnetite", 6, 5.2, "none", "moderate", "very high", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/Magnetite.jpg")));
        Deck.add(new FinalMineralCard("Molybdenite", 1.5, 4.7, "1 perfect", "trace", "high", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/Molybdenite.jpg")));
        Deck.add(new FinalMineralCard("Monazite", 5, 5.3, "1 good, 1 poor", "trace", "moderate", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/Monazite.jpg")));
        Deck.add(new FinalMineralCard("Muscovite", 3, 2.9, "1 perfect", "moderate", "moderate", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/Muscovite.jpg")));
        Deck.add(new FinalMineralCard("Olivine", 7, 4.4, "2 poor", "high", "low", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/Olivine.jpg")));
        Deck.add(new FinalMineralCard("Orthoclase", 6.5, 2.6, "1 perfect, 1 good", "high", "moderate", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/Orthoclase.jpg")));
        Deck.add(new FinalMineralCard("Orthopyroxene", 6, 3.9, "2 good", "high", "trivial", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/Orthopyroxene.jpg")));
        Deck.add(new FinalMineralCard("Plagioclase", 6.5, 2.8, "1 perfect, 1 good", "very high", "moderate", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/Plagioclase.jpg")));
        Deck.add(new FinalMineralCard("Pyrite", 6.5, 5, "2 poor", "low", "moderate", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/Pyrite.jpg")));
        Deck.add(new FinalMineralCard("Pyrrhotite", 4.5, 4.6, "none", "low", "moderate", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/Pyrrhotite.jpg")));
        Deck.add(new FinalMineralCard("Quartz", 7, 2.65, "poor/none", "high", "moderate", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/Quartz.jpg")));
        Deck.add(new FinalMineralCard("Rutile", 6.5, 4.3, "2 good", "low", "high", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/Rutile.jpg")));
        Deck.add(new FinalMineralCard("Siderite", 4.5, 4, "3 perfect", "trace", "moderate", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/Siderite.jpg")));
        Deck.add(new FinalMineralCard("Sillimanite", 7.5, 3.25, "1 perfect, 1 good", "low", "low", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/Sillimanite.jpg")));
        Deck.add(new FinalMineralCard("Sphalerite", 4, 4.1, "6 perfect", "trace", "high", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/Sphalerite.jpg")));
        Deck.add(new FinalMineralCard("Staurolite", 7, 3.8, "1 good", "trace", "low", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/Staurolite.jpg")));
        Deck.add(new FinalMineralCard("Talc", 1, 2.8, "1 perfect", "low", "moderate", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/Talc.jpg")));
        Deck.add(new FinalMineralCard("Titanite", 5.5, 3.6, "3 good", "low", "low", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/Titanite.jpg")));
        Deck.add(new FinalMineralCard("Topaz", 8, 3.6, "1 perfect", "ultratrace", "low", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/Topaz.jpg")));
        Deck.add(new FinalMineralCard("Tourmaline", 7.5, 3.2, "2 poor", "trace", "moderate", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/Tourmaline.jpg")));
        Deck.add(new FinalMineralCard("Zircon", 7.5, 4.7, "2 poor", "trace", "moderate", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/Zircon.jpg")));
        Deck.add(new FinalTrumpCard("The Gemmologist", "hardness", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/TheGemmologist.jpg")));
        Deck.add(new FinalTrumpCard("The Geologist", "your choice", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/TheGeologist.jpg")));
        Deck.add(new FinalTrumpCard("The Geophysicist", "specific gravity", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/TheGeophysicist.jpg")));
        Deck.add(new FinalTrumpCard("The Miner", "economic value", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/TheMiner.jpg")));
        Deck.add(new FinalTrumpCard("The Mineralogist", "cleavage", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/TheMineralogist.jpg")));
        Deck.add(new FinalTrumpCard("The Petrologist", "crystal abundance", new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                "Programming Final/project_mineral_super_trumps_game-master/images/ThePetrologist.jpg")));
        return Deck;
    }

    public void displayCurrentCategory() {
        System.out.print(current_category);
    }

    public void displayCurrentValue() {
        if (current_value == -1) {
            System.out.println("No Value Yet");
        } else {
            switch (current_category) {
                case "hardness":
                case "specific gravity":
                    System.out.print(current_value);
                    break;
                case "crystal abundance":
                    String rarity = "";
                    int rounded = (int) round(current_value);
                    switch (rounded) {
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
                    System.out.print(rarity);
                    break;
                case "economic value":
                    int rounded1 = (int) round(current_value);
                    String price = "";
                    switch (rounded1) {
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
                    System.out.print(price);
                    break;
                case "cleavage":
                    int rounded3 = (int) round(current_value);
                    String cleave = "";
                    switch (rounded3) {
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
                    System.out.print(cleave);
                    break;
                default:
                    System.out.print(current_value);
                    break;
            }
        }
    }

    public void drawCard(FinalPlayer player)
    //moves a card from the Deck to the hand of the peron who's turn it is
    {
        Random generator = new Random();
        FinalCard newdraw = Deck.get(generator.nextInt(Deck.size()));
        player.getHand().add(newdraw);
        Deck.remove(newdraw);                                           //removes card from deck
    }

    public void dealCards()
    //deals out 8 cards to each player
    {
        for (int i = 0; i < playerlist.length; ++i) {
            for (int x = 0; x < 8; ++x) {
                drawCard(playerlist[i]);        //drawCard()
            }
        }
    }

    public void declareCategory()
    //asks the player to declare a new active trump category and resets the current_value
    {
        System.out.println("What should the new playable trump be?");
        Scanner scanner = new Scanner(System.in);
        String response = scanner.nextLine();
        switch (response.toLowerCase()) {
            case "hardness":
                current_category = "hardness";
                break;
            case "economic value":
                current_category = "economic value";
                break;
            case "cleavage":
                current_category = "cleavage";
                break;
            case "crystal abundance":
                current_category = "crystal abundance";
                break;
            case "specific gravity":
                current_category = "specific gravity";
                break;
            default:
                System.out.println("Your answer was unclear.");
                System.out.println("Please only enter hardness, economic value, cleavage, crystal abundance, or specific gravity.");
                declareCategory();
        }
        current_value = -1;
    }

    public void displayHand(FinalPlayer player)
    //this displays the ArrayList of the hand followed by a description of each card
    {
        ArrayList<String> cardnames = new ArrayList<String>();
        for (int i = 0; i < player.getHand().size(); ++i) {
            cardnames.add(player.getHand().get(i).getName());
        }
        System.out.println(cardnames);
        System.out.println("");
        for (int i = 0; i < player.getHand().size(); ++i) {
            player.getHand().get(i).showStats();
        }
    }

    public ArrayList getHandNames(FinalPlayer player)
    //already to lowercase for ya
    {
        ArrayList<String> cardnames = new ArrayList<String>();
        for (int i = 0; i < player.getHand().size(); ++i) {
            cardnames.add(player.getHand().get(i).getName().toLowerCase());
        }
        return cardnames;
    }

    public boolean isSoloPLayer()
    //cycles through all players to check if they can play or not
    //returns true if they are the only player that hasn't passed
    {
        boolean returnvalue = false;
        int passedplayers = 0;
        for (int i = 0; i < playerlist.length; ++i) {
            if (playerlist[i].canTheyPlay() == false || playerlist[i].getWinStatus() == true) {
                ++passedplayers;
            }
        }
        if (passedplayers >= playerlist.length - 1) {
            returnvalue = true;
        }
        return returnvalue;
    }

    public void playFirstCardOfRound()
    //plays first card of round and resets everyone's play status
    {
        for (int i = 0; i < playerlist.length; ++i)           //changes everyone's play status to true
        {
            playerlist[i].changePlayStatus(true);
        }
        System.out.println("It is " + playerlist[who_turn].getName() + "'s turn.");
        System.out.println(playerlist[who_turn].getName() + " will start off a new round!");
        displayHand(playerlist[who_turn]);
        checkCombo();
        System.out.println("");
        declareCategory();
        playCardNoPass();
    }

    public void playCard()
    //displays hand, asks which card to play changes the value/category, and removes card
    {
        checkCombo();
        displayHand(playerlist[who_turn]);
        ArrayList<String> lowercardnames = new ArrayList<>();
        for (int i = 0; i < playerlist[who_turn].getHand().size(); ++i)       //converts the hand to lowercase letter names
        {
            lowercardnames.add(playerlist[who_turn].getHand().get(i).getName().toLowerCase());
        }
        System.out.println("Which card do you want to play? You can also type 'pass' to pass.");
        Scanner scanner = new Scanner(System.in);
        String cardname = scanner.nextLine();
        if (!lowercardnames.contains(cardname.toLowerCase()))               //if the card isn't found in the hand
        {
            if (cardname.equals("pass"))                                    //if they decide to pass
            {
                pass();
            } else {
                System.out.println("I couldn't find that card in your hand.");
                playCard();
            }
        } else                                                                //playing the card
        {
            FinalCard playedcard = new FinalMineralCard();
            //get card with name entered
            for (int i = 0; i < lowercardnames.size(); ++i) {
                if (cardname.toLowerCase().equals(lowercardnames.get(i))) {
                    playedcard = playerlist[who_turn].getHand().get(i);
                }
            }
            if (playedcard.checkIfPlayable(current_category, current_value) == false)  //checkIfPlayable()
            {
                System.out.println("I'm sorry, you can't play that card right now.");
                playCard();
            } else {
                current_category = playedcard.getNewCurrentCategory(current_category);
                current_value = playedcard.getNewCurrentValue(current_category);
                playerlist[who_turn].getHand().remove(playedcard);
            }
        }
    }

    public void playCard(String cardname)
    //remove if it doesn't work
    {
        FinalCard playedcard = new FinalMineralCard();
        for (int i = 0; i < getHandNames(playerlist[who_turn]).size(); ++i)           //get card with name entered
        {
            if (cardname.toLowerCase().equals(getHandNames(playerlist[who_turn]).get(i))) {
                playedcard = playerlist[who_turn].getHand().get(i);
            }
        }
        if (playedcard.checkIfPlayable(current_category, current_value) == false)  //checkIfPlayable()
        {
            System.out.println("I'm sorry, you can't play that card right now.");
            askPassOrPlay();
        } else {
            current_category = playedcard.getNewCurrentCategory(current_category);
            current_value = playedcard.getNewCurrentValue(current_category);
            playerlist[who_turn].getHand().remove(playedcard);
        }
    }

    public void checkCombo()
    //checks for the Magnetite/The Geophysicist combo
    {
        if (getHandNames(playerlist[who_turn]).contains("magnetite") && getHandNames(playerlist[who_turn]).contains("the geophysicist")) {
            System.out.println("Do you want to play Magnetite and The Geophysicist together to win? Yes or no.");
            Scanner scanner = new Scanner(System.in);
            switch (scanner.next().toLowerCase()) {
                case "yes":
                    playerWins();
                    nextTurn();
                    break;
                case "no":
                    break;
                default:
                    System.out.println("That was unclear.");
                    checkCombo();
            }
        }
    }

    public void pass()
    //changes can_play status and draws a card
    {
        playerlist[who_turn].changePlayStatus(false);
        drawCard(playerlist[who_turn]);
    }

    public void askPassOrPlay()
    //denotes whether the player will get pass() or playCard()
    {
        displayCurrentCategory();
        System.out.print(": ");
        displayCurrentValue();
        System.out.println("");
        displayHand(playerlist[who_turn]);
        System.out.println("Do you want to play a card or pass?");
        Scanner scanner = new Scanner(System.in);
        String entered = scanner.nextLine();
        if (getHandNames(playerlist[who_turn]).contains(entered.toLowerCase()) == true) {
            playCard(entered);
        } else {
            switch (entered) {
                case ("pass"):
                    pass();
                    break;
                case ("play"):
                case ("play a card"):
                    playCard();
                    break;
                default:
                    System.out.println("I'm sorry that wasn't clear. You can type play, a card's name, or pass.");
                    askPassOrPlay();
            }
        }
    }

    public void play()
    //an organizational method
    {
        System.out.println("It is " + playerlist[who_turn].getName() + "'s turn.");
        askPassOrPlay();
    }

    public void playCardNoPass()
    //doesn't give players the choice to pass, used in playFirstCardOfRound()
    {
        displayHand(playerlist[who_turn]);
        ArrayList<String> lowercardnames = new ArrayList<>();
        for (int i = 0; i < playerlist[who_turn].getHand().size(); ++i)       //converts the hand to lowercase letter names
        {
            lowercardnames.add(playerlist[who_turn].getHand().get(i).getName().toLowerCase());
        }
        System.out.println("Which card do you want to play?");
        Scanner scanner = new Scanner(System.in);
        String cardname = scanner.next();
        if (!lowercardnames.contains(cardname.toLowerCase()))               //if the card isn't found in the hand
        {
            System.out.println("I couldn't find that card in your hand.");
            playCardNoPass();
        } else                                                                //playing the card
        {
            FinalCard playedcard = new FinalMineralCard();
            //get card with name entered
            for (int i = 0; i < lowercardnames.size(); ++i) {
                if (cardname.toLowerCase().equals(lowercardnames.get(i))) {
                    playedcard = playerlist[who_turn].getHand().get(i);
                }
            }
            if (playedcard.checkIfPlayable(current_category, current_value) == false)  //checkIfPlayable()
            {
                System.out.println("I'm sorry, you can't play that card right now.");
                playCardNoPass();
            } else {
                current_category = playedcard.getNewCurrentCategory(current_category);
                current_value = playedcard.getNewCurrentValue(current_category);
                playerlist[who_turn].getHand().remove(playedcard);
            }
        }
    }

    public void turn()
    //organizational method
    //checks to see whether the player gets to play() or playFirstCardOfRound()
    {
        if (isSoloPLayer() == true) {
            playFirstCardOfRound();
            checkForWin();
            nextTurn();
        } else {
            play();
            checkForWin();
            nextTurn();
        }
    }

    public void checkForWin()
    //only does anything if the player's hand no longer contains anything
    {
        if (playerlist[who_turn].getHand().size() == 0) {
            playerWins();
        }
    }

    public void playerWins()
    //prints ____ wins! and changes their winner status to true
    {
        System.out.println(playerlist[who_turn].getName() + " wins!");
        playerlist[who_turn].changeWinStatus(true);
        winnerlist[winner_number] = playerlist[who_turn];
        winner_number++;
    }

    public void nextTurn()
    //moves the turn to the next player
    {
        ++who_turn;
        if (who_turn >= playerlist.length) {
            who_turn = 0;
        }
        if (playerlist[who_turn].canTheyPlay() == false || playerlist[who_turn].getWinStatus() == true) {
            nextTurn();
        }
    }

    public void endGame()
    //how you end a game with a full set of winners
    {
        ArrayList finallist = new ArrayList();
        for (int i = 0; i < winnerlist.length; ++i) {
            int place = i + 1;
            System.out.println(winnerlist[i].getName() + " is number " + place + "!");
            finallist.add(winnerlist[i]);
        }
        for (int x = 0; x < playerlist.length; ++x) {
            if (finallist.contains(playerlist[x]) == false) {
                System.out.println(playerlist[x].getName() + " loses!");
            }
        }
        System.out.println("Thank you all for playing!");
    }

    public void StartGame() {
        dealCards();
        playFirstCardOfRound();
        nextTurn();
        while (winner_number < playerlist.length - 1) {
            turn();
        }
        endGame();
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {

    }
}