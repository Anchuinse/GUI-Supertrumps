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
    int who_turn, winner_number, playernumber;
    ImageIcon last_card = new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                                           "Programming Final/project_mineral_super_trumps_game-master/images/zzStock1.jpg");;
    String current_category;
    double current_value;
    ArrayList<FinalCard> Deck;
    FinalPlayer[] playerlist, winnerlist;
    Random generator = new Random();
    Font font = new Font("Arial", Font.BOLD, 24);
    Font font2 = new Font("Arial", Font.PLAIN, 14);

    JPanel tophalf = new JPanel();
    JPanel currents = new JPanel();
    JLabel turn_player = new JLabel("");
    JLabel displayed_category = new JLabel("no category yet");
    JLabel displayed_value = new JLabel("no value yet");
    JLabel messages = new JLabel("How many players are there?");
    JLabel displayed_card = new JLabel();
    JPanel bottomhalf = new JPanel();

    JPanel player_num_form = new JPanel();
    JButton three = new JButton("3");
    JButton four = new JButton("4");
    JButton five = new JButton("5");

    JPanel player_name_form = new JPanel();

    JPanel hand_form = new JPanel();
    JPanel fhand_form = new JPanel();
    JButton pass = new JButton("pass");
    CardButton button1 = new CardButton();
    CardButton button2 = new CardButton();
    CardButton button3 = new CardButton();
    CardButton button4 = new CardButton();
    CardButton button5 = new CardButton();
    CardButton button6 = new CardButton();
    CardButton button7 = new CardButton();
    CardButton button8 = new CardButton();
    CardButton button9 = new CardButton();
    CardButton button10 = new CardButton();
    CardButton button11 = new CardButton();
    CardButton button12 = new CardButton();
    CardButton button13 = new CardButton();
    CardButton button14 = new CardButton();
    CardButton button15 = new CardButton();
    ArrayList<CardButton> button_list = new ArrayList<CardButton>();

    CardButton button011 = new CardButton();
    CardButton button21 = new CardButton();
    CardButton button31 = new CardButton();
    CardButton button41 = new CardButton();
    CardButton button51 = new CardButton();
    CardButton button61 = new CardButton();
    CardButton button71 = new CardButton();
    CardButton button81 = new CardButton();
    CardButton button91 = new CardButton();
    CardButton button101 = new CardButton();
    CardButton button111 = new CardButton();
    CardButton button121 = new CardButton();
    CardButton button131= new CardButton();
    CardButton button141 = new CardButton();
    CardButton button151 = new CardButton();
    ArrayList<CardButton> fbutton_list = new ArrayList<CardButton>();

    JPanel new_trump_form = new JPanel();
    JButton hardness = new JButton("Hardness");
    JButton value = new JButton("Economic Value");
    JButton gravity = new JButton("Specific Gravity");
    JButton cleavage = new JButton("Cleavage");
    JButton abundance = new JButton("Crystal Abundance");
    Timer timer = new Timer(2000, this);

    public FinalGame()
    {
        super("Mineral Supertrumps");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocation(0,0);
        setSize(1440,900);
        setLayout(new GridLayout(2,1));

        current_category = "none";
        current_value = -1;
        Deck = initializeDeck();
        current_category = "none";
        current_value = -1;                             //use -1 as default so lowest value(0) card can play
        displayCurrentCategory();
        displayCurrentValue();
        winner_number = 0;

        currents.setLayout(new GridLayout(8,1));
        turn_player.setFont(font);
        currents.add(turn_player);
        displayed_category.setFont(font2);
        displayed_value.setFont(font2);
        currents.add(displayed_category);
        currents.add(displayed_value);
        messages.setHorizontalAlignment(SwingConstants.CENTER);
        messages.setFont(font);
        currents.add(messages);
        currents.setBackground(Color.GREEN);
        tophalf.setLayout(new GridLayout(1,2));
        tophalf.add(currents);
        last_card = specialTransformPic(last_card);
        displayed_card.setIcon(last_card);
        displayed_card.setHorizontalAlignment(SwingConstants.CENTER);
        tophalf.add(displayed_card);

        player_num_form.setLayout(new FlowLayout());                //creates the player number form
        three.addActionListener(this);
        four.addActionListener(this);
        five.addActionListener(this);
        player_num_form.add(three);
        player_num_form.add(four);
        player_num_form.add(five);

        player_name_form.setLayout(new FlowLayout());               //creates the name asker form

        hand_form.setLayout(new GridLayout(2,7));                   //creates the hand form
        button_list.add(button1);
        button_list.add(button2);
        button_list.add(button3);
        button_list.add(button4);
        button_list.add(button5);
        button_list.add(button6);
        button_list.add(button7);
        button_list.add(button8);
        button_list.add(button9);
        button_list.add(button10);
        button_list.add(button11);
        button_list.add(button12);
        button_list.add(button13);
        button_list.add(button14);
        button_list.add(button15);
        pass.addActionListener(this);
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);
        button8.addActionListener(this);
        button9.addActionListener(this);
        button10.addActionListener(this);
        button11.addActionListener(this);
        button12.addActionListener(this);
        button13.addActionListener(this);
        button14.addActionListener(this);
        button15.addActionListener(this);
        hand_form.add(pass);
        hand_form.add(button1);
        hand_form.add(button2);
        hand_form.add(button3);
        hand_form.add(button4);
        hand_form.add(button5);
        hand_form.add(button6);
        hand_form.add(button7);
        hand_form.add(button8);
        hand_form.add(button9);
        hand_form.add(button10);
        hand_form.add(button11);
        hand_form.add(button12);
        hand_form.add(button13);
        hand_form.add(button14);
        hand_form.add(button15);

        fhand_form.setLayout(new GridLayout(2,7));              //creates the false hand form
        fbutton_list.add(button011);
        fbutton_list.add(button21);
        fbutton_list.add(button31);
        fbutton_list.add(button41);
        fbutton_list.add(button51);
        fbutton_list.add(button61);
        fbutton_list.add(button71);
        fbutton_list.add(button81);
        fbutton_list.add(button91);
        fbutton_list.add(button101);
        fbutton_list.add(button111);
        fbutton_list.add(button121);
        fbutton_list.add(button131);
        fbutton_list.add(button141);
        fbutton_list.add(button151);
        fhand_form.add(button1);
        fhand_form.add(button2);
        fhand_form.add(button3);
        fhand_form.add(button4);
        fhand_form.add(button5);
        fhand_form.add(button6);
        fhand_form.add(button7);
        fhand_form.add(button8);
        fhand_form.add(button9);
        fhand_form.add(button10);
        fhand_form.add(button11);
        fhand_form.add(button12);
        fhand_form.add(button13);
        fhand_form.add(button14);
        fhand_form.add(button15);

        new_trump_form.setLayout(new GridLayout(1,5));
        hardness.addActionListener(this);
        gravity.addActionListener(this);
        abundance.addActionListener(this);
        cleavage.addActionListener(this);
        value.addActionListener(this);
        new_trump_form.add(hardness);
        new_trump_form.add(gravity);
        new_trump_form.add(abundance);
        new_trump_form.add(cleavage);
        new_trump_form.add(value);
        tophalf.setBackground(Color.GREEN);
        add(tophalf);
        player_num_form.setBackground(Color.GREEN);
        new_trump_form.setBackground(Color.GREEN);
        hand_form.setBackground(Color.GREEN);
        bottomhalf.add(player_num_form);
        bottomhalf.setBackground(Color.GREEN);
        add(bottomhalf);

        winnerlist = new FinalPlayer[0];

        validate();
        repaint();
    }

    public ArrayList<FinalCard> initializeDeck()
    {
        ArrayList Deck = new ArrayList();
        Deck.add(new FinalMineralCard("Apatite", 5, 3.2, "2 poor", "low", "high"));
        Deck.add(new FinalMineralCard("Augite", 6.5, 3.6, "2 good", "high", "trivial"));
        Deck.add(new FinalMineralCard("Barite", 3.5, 4.5, "2 perfect, 1 good", "trace", "moderate"));
        Deck.add(new FinalMineralCard("Beryl", 8, 2.9, "1 poor", "trace", "moderate"));
        Deck.add(new FinalMineralCard("Biotite", 3, 3.3, "1 perfect", "moderate", "low"));
        Deck.add(new FinalMineralCard("Calcite", 3, 2.7, "3 perfect", "moderate", "high"));
        Deck.add(new FinalMineralCard("Cassiterite", 7, 7.1, "1 good, 1 poor", "trace", "high"));
        Deck.add(new FinalMineralCard("Chalcopyrite", 4, 4.3, "2 poor", "low", "very high"));
        Deck.add(new FinalMineralCard("Chlorite", 3, 3.3, "1 perfect", "moderate", "low"));
        Deck.add(new FinalMineralCard("Chromite", 5.5, 5.1, "none", "low", "high"));
        Deck.add(new FinalMineralCard("Corundum", 9, 4, "none", "trace", "moderate"));
        Deck.add(new FinalMineralCard("Diamond", 10, 3.5, "4 perfect", "ultratrace", "I'm rich!"));
        Deck.add(new FinalMineralCard("Dolomite", 4, 2.9, "3 perfect", "low", "low"));
        Deck.add(new FinalMineralCard("Epidote", 6.5, 3.5, "1 perfect", "moderate", "trivial"));
        Deck.add(new FinalMineralCard("Fluorite", 4, 3.2, "4 perfect", "trace", "moderate"));
        Deck.add(new FinalMineralCard("Galena", 2.5, 7.6, "3 perfect", "trace", "high"));
        Deck.add(new FinalMineralCard("Garnet", 7.5, 4.3, "none", "moderate", "moderate"));
        Deck.add(new FinalMineralCard("Gibbsite", 3.5, 2.4, "1 perfect", "low", "high"));
        Deck.add(new FinalMineralCard("Glaucophane", 6, 3.2, "2 good", "low", "trivial"));
        Deck.add(new FinalMineralCard("Goethite", 5.5, 4.3, "1 perfect, 1 good", "moderate", "moderate"));
        Deck.add(new FinalMineralCard("Gold", 3, 19.3, "none", "ultratrace", "I'm rich!"));
        Deck.add(new FinalMineralCard("Graphite", 2, 2.2, "1 perfect", "trace", "moderate"));
        Deck.add(new FinalMineralCard("Gypsum", 2, 2.3, "1 perfect, 2 good", "trace", "high"));
        Deck.add(new FinalMineralCard("Halite", 2.5, 2.2, "3 perfect", "trace", "moderate"));
        Deck.add(new FinalMineralCard("Hematite", 6, 5.3, "none", "trace", "high"));
        Deck.add(new FinalMineralCard("Hornblende", 6, 3.5, "2 good", "moderate", "trivial"));
        Deck.add(new FinalMineralCard("Ilmenite", 6, 4.8, "none", "low", "moderate"));
        Deck.add(new FinalMineralCard("Kaolinite", 2.5, 2.7, "1 perfect", "moderate", "high"));
        Deck.add(new FinalMineralCard("Kyanite", 7, 3.7, "1 perfect, 1 good", "trace", "moderate"));
        Deck.add(new FinalMineralCard("Magnesite", 4, 3, "3 perfect", "low", "moderate"));
        Deck.add(new FinalMineralCard("Magnetite", 6, 5.2, "none", "moderate", "very high"));
        Deck.add(new FinalMineralCard("Molybdenite", 1.5, 4.7, "1 perfect", "trace", "high"));
        Deck.add(new FinalMineralCard("Monazite", 5, 5.3, "1 good, 1 poor", "trace", "moderate"));
        Deck.add(new FinalMineralCard("Muscovite", 3, 2.9, "1 perfect", "moderate", "moderate"));
        Deck.add(new FinalMineralCard("Olivine", 7, 4.4, "2 poor", "high", "low"));
        Deck.add(new FinalMineralCard("Orthoclase", 6.5, 2.6, "1 perfect, 1 good", "high", "moderate"));
        Deck.add(new FinalMineralCard("Orthopyroxene", 6, 3.9, "2 good", "high", "trivial"));
        Deck.add(new FinalMineralCard("Plagioclase", 6.5, 2.8, "1 perfect, 1 good", "very high", "moderate"));
        Deck.add(new FinalMineralCard("Pyrite", 6.5, 5, "2 poor", "low", "moderate"));
        Deck.add(new FinalMineralCard("Pyrrhotite", 4.5, 4.6, "none", "low", "moderate"));
        Deck.add(new FinalMineralCard("Quartz", 7, 2.65, "poor/none", "high", "moderate"));
        Deck.add(new FinalMineralCard("Rutile", 6.5, 4.3, "2 good", "low", "high"));
        Deck.add(new FinalMineralCard("Siderite", 4.5, 4, "3 perfect", "trace", "moderate"));
        Deck.add(new FinalMineralCard("Sillimanite", 7.5, 3.25, "1 perfect, 1 good", "low", "low"));
        Deck.add(new FinalMineralCard("Sphalerite", 4, 4.1, "6 perfect", "trace", "high"));
        Deck.add(new FinalMineralCard("Staurolite", 7, 3.8, "1 good", "trace", "low"));
        Deck.add(new FinalMineralCard("Talc", 1, 2.8, "1 perfect", "low", "moderate"));
        Deck.add(new FinalMineralCard("Titanite", 5.5, 3.6, "3 good", "low", "low"));
        Deck.add(new FinalMineralCard("Topaz", 8, 3.6, "1 perfect", "ultratrace", "low"));
        Deck.add(new FinalMineralCard("Tourmaline", 7.5, 3.2, "2 poor", "trace", "moderate"));
        Deck.add(new FinalMineralCard("Zircon", 7.5, 4.7, "2 poor", "trace", "moderate"));
        Deck.add(new FinalTrumpCard("TheGemmologist", "hardness"));
        Deck.add(new FinalTrumpCard("TheGeologist", "your choice"));
        Deck.add(new FinalTrumpCard("TheGeophysicist", "specific gravity"));
        Deck.add(new FinalTrumpCard("TheMiner", "economic value"));
        Deck.add(new FinalTrumpCard("TheMineralogist", "cleavage"));
        Deck.add(new FinalTrumpCard("ThePetrologist", "crystal abundance"));
        return Deck;
    }

    public void displayCurrentCategory() {
        displayed_category.setText("The current category is: " + current_category);
        validate();
        repaint();
    }

    public void displayCurrentValue() {
        if (current_value == -1) {displayed_value.setText("No Value Yet");}
        else {
            switch (current_category) {
                case "hardness":
                case "specific gravity":
                    displayed_value.setText("" + current_value);
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
                    displayed_value.setText(rarity);
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
                    displayed_value.setText(price);
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
                    displayed_value.setText(cleave);
                    break;
                default:
                    System.out.print(current_value);
                    break;
            }
        }
        validate();
        repaint();
    }

    public void displayCurrentPlayer()
    {
        turn_player.setText("It is " + playerlist[who_turn].getName() + "'s turn.");
    }

    public void displayCurrentCard()
    {
        displayed_card.setIcon(specialTransformPic(last_card));
    }

    public void displayCurrents()
    {
        displayCurrentCategory();
        displayCurrentValue();
        displayCurrentPlayer();
        displayCurrentCard();
        validate();
        repaint();
    }

    public void drawCard(FinalPlayer player)
    {
        FinalCard newdraw = Deck.get(generator.nextInt(Deck.size()));
        player.getHand().add(newdraw);
        Deck.remove(newdraw);                                           //removes card from deck
    }

    public void dealCards()
    {
        for (int i = 0; i < playerlist.length; ++i) {
            for (int x = 0; x < 8; ++x) {
                drawCard(playerlist[i]);        //drawCard()
            }
        }
    }

    public void displayHand(FinalPlayer player)
    {
        messages.setText("Which card do you want to play? You can also pass.");
        hand_form = new JPanel();
        hand_form.setBackground(Color.GREEN);
        hand_form.setLayout(new GridLayout(2,8));
        pass.setVisible(true);
        hand_form.add(pass);
        ArrayList<FinalCard> hand = playerlist[who_turn].getHand();
        for (int i=0; i < hand.size(); ++i)                             //renaming buttons
        {
            button_list.get(i).setVisible(true);
            button_list.get(i).renameButton(hand.get(i).getName());
        }
        for (int i=hand.size(); i < 15; ++i)                            //clearing buttons
        {
            button_list.get(i).setVisible(false);
        }
        for (int i=0; i < button_list.size(); ++i)                      //adding buttons to hand form
        {
            hand_form.add(button_list.get(i));
        }
        bottomhalf.add(hand_form);
        validate();
        repaint();
    }

    public void displayFalseHand(FinalPlayer player) {
        fhand_form = new JPanel();
        fhand_form.setBackground(Color.GREEN);
        fhand_form.setLayout(new GridLayout(2, 8));
        pass.setVisible(true);
        ArrayList<FinalCard> hand = playerlist[who_turn].getHand();
        for (int i = 0; i < hand.size(); ++i)                             //renaming buttons
        {
            fbutton_list.get(i).setVisible(true);
            fbutton_list.get(i).renameButton(hand.get(i).getName());
        }
        for (int i = hand.size(); i < 15; ++i)                            //clearing buttons
        {
            fbutton_list.get(i).setVisible(false);
        }
        for (int i = 0; i < fbutton_list.size(); ++i)                      //adding buttons to hand form
        {
            fhand_form.add(fbutton_list.get(i));
        }
        bottomhalf.add(fhand_form);
        validate();
        repaint();
    }

    public ArrayList getHandNames(FinalPlayer player)
    {
        ArrayList<String> cardnames = new ArrayList<String>();
        for (int i = 0; i < player.getHand().size(); ++i) {
            cardnames.add(player.getHand().get(i).getName().toLowerCase());
        }
        return cardnames;
    }

    public boolean isSoloPLayer()
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

    public void checkCombo() //*
    {
        if (getHandNames(playerlist[who_turn]).contains("magnetite") && getHandNames(playerlist[who_turn]).contains("thegeophysicist"))
        {
            messages.setText("Do you want to play Magnetite and The Geophysicist together to win? Yes or no.");
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

    public void playCard(String string)
    {
        ArrayList<FinalCard> hand = playerlist[who_turn].getHand();
        for (int i=0; i < hand.size(); ++i)
        {
            if (hand.get(i).getName() == string)
            {
                if (hand.get(i).checkIfPlayable(current_category, current_value) == true)
                {
                    if (hand.get(i).getName() == "TheGeologist")
                    {
                        current_category = "hardness";
                    }
                    else { current_category = hand.get(i).getNewCurrentCategory(current_category);}
                    current_value = hand.get(i).getNewCurrentValue(current_category);
                    last_card = new ImageIcon("/Users/Matt/Desktop/Australian School/" +
                            "Programming Final/project_mineral_super_trumps_game-master/images/"+hand.get(i).getName()+".jpg");
                    displayCurrents();
                    hand.remove(i);
                    validate();
                    repaint();
                    nextTurn();
                }
                else
                {
                    messages.setText("You can't play that card. Its " + current_category + " is too low!");
                }
            }
        }
    }

    public void pass()
    {
        playerlist[who_turn].changePlayStatus(false);
        drawCard(playerlist[who_turn]);
        nextTurn();
    }

    public boolean checkForWin()
    {
        if (playerlist[who_turn].getWinStatus() == false)
        {
            if (playerlist[who_turn].getHand().size() == 0)
            {
                return true;
            }
        }
        return false;
    }

    public void checkFinish()
    {
        if (winner_number == playerlist.length-1)
        {
            endGame();
        }
    }

    public void playerWins()
    {
        messages.setText(playerlist[who_turn].getName() + " wins!");
        playerlist[who_turn].changeWinStatus(true);
        FinalPlayer player = playerlist[who_turn];
        winnerlist[winner_number] = player;
        winner_number++;
        timer.start();
    }

    public void specialNextTurn()
    {
        checkFinish();
        ++who_turn;
        messages.setText("Which card do you want to play? You can also pass.");
        if (who_turn >= playerlist.length) {
            who_turn = 0;
        }
        displayCurrents();
        if (isSoloPLayer() == false) {displayHand(playerlist[who_turn]);}
        if (isSoloPLayer() == true && playerlist[who_turn].getWinStatus() == false)
        {
            bottomhalf.remove(hand_form);
            messages.setText("What should the new active trump be?");
            bottomhalf.add(new_trump_form);
            displayFalseHand(playerlist[who_turn]);
            validate();
            repaint();
            for (int i=0; i < playerlist.length; ++i)
            {
                playerlist[i].changePlayStatus(true);
            }
        }
        if (playerlist[who_turn].canTheyPlay() == false || playerlist[who_turn].getWinStatus() == true) {
            nextTurn();
        }
        checkCombo();
    }

    public void nextTurn() {
        if (checkForWin() == true)
        {
            playerWins();
        } else
            {
            checkFinish();
            ++who_turn;
            messages.setText("Which card do you want to play? You can also pass.");
            if (who_turn >= playerlist.length) {
                who_turn = 0;
            }
            displayCurrents();
            if (isSoloPLayer() == false) {
                displayHand(playerlist[who_turn]);
            }
            if (isSoloPLayer() == true || playerlist[who_turn].getWinStatus() == false) {
                bottomhalf.remove(hand_form);
                messages.setText("What should the new active trump be?");
                bottomhalf.add(new_trump_form);
                displayFalseHand(playerlist[who_turn]);
                validate();
                repaint();
                for (int i = 0; i < playerlist.length; ++i) {
                    playerlist[i].changePlayStatus(true);
                }
            }

            if (playerlist[who_turn].canTheyPlay() == false || playerlist[who_turn].getWinStatus() == true) {
                nextTurn();
            }
            checkCombo();
        }
    }

    public void endGame()
    {
        ArrayList finallist = new ArrayList();
        String string = "";
        for (int i = 0; i < winnerlist.length; ++i) {
            int place = i + 1;
            string = string + (winnerlist[i].getName() + " is number " + place + "!" + "\n");
            finallist.add(winnerlist[i]);
        }
        for (int x = 0; x < playerlist.length; ++x) {
            if (finallist.contains(playerlist[x]) == false) {
                string = string + (playerlist[x].getName() + " loses!");
            }
        }
        System.out.println(string);
        System.out.println("THANK YOU FOR PLAYING!!!");
        System.exit(0);
    }

    public ImageIcon specialTransformPic(ImageIcon i)
    {
        Image image = i.getImage();
        Image new_image = image.getScaledInstance(240,300, Image.SCALE_SMOOTH);
        return (new ImageIcon(new_image));
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == three)                                             //3, 4, 5, buttons
        {
            playernumber = 3;
            bottomhalf.remove(player_num_form);
            FinalPlayer[] players = new FinalPlayer[playernumber];
            for (int i = 0; i < playernumber; ++i)
            {
                players[i] = new FinalPlayer(i+1, "TestPlayer " + (i+1));
            }
            who_turn = generator.nextInt(playernumber);     //decides first person at random
            playerlist = players;
            winnerlist = new FinalPlayer[2];
            dealCards();
            messages.setText("What should the new active trump be?");
            bottomhalf.add(new_trump_form);
            displayFalseHand(playerlist[who_turn]);
            bottomhalf.add(fhand_form);
            displayCurrents();
            validate();
            repaint();
        }
        if (e.getSource() == four)
        {
            playernumber = 4;
            bottomhalf.remove(player_num_form);
            FinalPlayer[] players = new FinalPlayer[playernumber];
            for (int i = 0; i < playernumber; ++i)
            {
                players[i] = new FinalPlayer(i+1, "TestPlayer " + (i+1));
            }
            who_turn = generator.nextInt(playernumber);     //decides first person at random
            playerlist = players;
            winnerlist = new FinalPlayer[3];
            dealCards();
            messages.setText("What should the new active trump be?");
            bottomhalf.add(new_trump_form);
            displayFalseHand(playerlist[who_turn]);
            bottomhalf.add(fhand_form);
            displayCurrents();
            validate();
            repaint();
        }
        if (e.getSource() == five)
        {
            playernumber = 5;
            bottomhalf.remove(player_num_form);
            FinalPlayer[] players = new FinalPlayer[playernumber];
            for (int i = 0; i < playernumber; ++i)
            {
                players[i] = new FinalPlayer(i+1, "TestPlayer " + (i+1));
            }
            who_turn = generator.nextInt(playernumber);     //decides first person at random
            playerlist = players;
            winnerlist = new FinalPlayer[4];
            dealCards();
            messages.setText("What should the new active trump be?");
            bottomhalf.add(new_trump_form);
            displayFalseHand(playerlist[who_turn]);
            bottomhalf.add(fhand_form);
            displayCurrents();
            validate();
            repaint();
        }
        ////////////////////////////////////////////////////////////////////////////////trump category buttons
        if (e.getSource() == hardness)
        {
            current_category = "hardness";
            current_value = -1;
            bottomhalf.remove(fhand_form);
            bottomhalf.remove(new_trump_form);
            displayCurrents();
            displayHand(playerlist[who_turn]);
        }
        if (e.getSource() == value)
        {
            current_category = "economic value";
            current_value = -1;
            bottomhalf.remove(fhand_form);
            bottomhalf.remove(new_trump_form);
            displayCurrents();
            displayHand(playerlist[who_turn]);
        }
        if (e.getSource() == gravity)
        {
            current_category = "specific gravity";
            current_value = -1;
            bottomhalf.remove(fhand_form);
            bottomhalf.remove(new_trump_form);
            displayCurrents();
            displayHand(playerlist[who_turn]);
        }
        if (e.getSource() == abundance)
        {
            current_category = "crystal abundance";
            current_value = -1;
            bottomhalf.remove(fhand_form);
            bottomhalf.remove(new_trump_form);
            displayCurrents();
            displayHand(playerlist[who_turn]);
        }
        if (e.getSource() == cleavage)
        {
            current_category = "cleavage";
            current_value = -1;
            bottomhalf.remove(fhand_form);
            bottomhalf.remove(new_trump_form);
            displayCurrents();
            displayHand(playerlist[who_turn]);
        }
        /////////////////////////////////////////////////////////////////////////////////card buttons
        if (e.getSource() == pass)
        {
            pass();
        }
        validate();
        repaint();

        if (e.getSource() == button1)
        {
            String cardname = button1.getName();
            for (int i=0; i < playerlist[who_turn].getHand().size(); ++i)
            {
                if (cardname == playerlist[who_turn].getHand().get(i).getName())
                {
                    playCard(button1.getName());
                }
            }
        }

        if (e.getSource() == button2)
        {
            String cardname = button2.getName();
            for (int i=0; i < playerlist[who_turn].getHand().size(); ++i)
            {
                if (cardname == playerlist[who_turn].getHand().get(i).getName())
                {
                    playCard(button2.getName());
                }
            }
        }

        if (e.getSource() == button3)
        {
            String cardname = button3.getName();
            for (int i=0; i < playerlist[who_turn].getHand().size(); ++i)
            {
                if (cardname == playerlist[who_turn].getHand().get(i).getName())
                {
                    playCard(button3.getName());
                }
            }
        }

        if (e.getSource() == button4)
        {
            String cardname = button4.getName();
            for (int i=0; i < playerlist[who_turn].getHand().size(); ++i)
            {
                if (cardname == playerlist[who_turn].getHand().get(i).getName())
                {
                    playCard(button4.getName());
                }
            }
        }

        if (e.getSource() == button5)
        {
            String cardname = button5.getName();
            for (int i=0; i < playerlist[who_turn].getHand().size(); ++i)
            {
                if (cardname == playerlist[who_turn].getHand().get(i).getName())
                {
                    playCard(button5.getName());
                }
            }
        }

        if (e.getSource() == button6)
        {
            String cardname = button6.getName();
            for (int i=0; i < playerlist[who_turn].getHand().size(); ++i)
            {
                if (cardname == playerlist[who_turn].getHand().get(i).getName())
                {
                    playCard(button6.getName());
                }
            }
        }

        if (e.getSource() == button7)
        {
            String cardname = button7.getName();
            for (int i=0; i < playerlist[who_turn].getHand().size(); ++i)
            {
                if (cardname == playerlist[who_turn].getHand().get(i).getName())
                {
                    playCard(button7.getName());
                }
            }
        }

        if (e.getSource() == button8)
        {
            String cardname = button8.getName();
            for (int i=0; i < playerlist[who_turn].getHand().size(); ++i)
            {
                if (cardname == playerlist[who_turn].getHand().get(i).getName())
                {
                    playCard(button8.getName());
                }
            }
        }

        if (e.getSource() == button9)
        {
            String cardname = button9.getName();
            for (int i=0; i < playerlist[who_turn].getHand().size(); ++i)
            {
                if (cardname == playerlist[who_turn].getHand().get(i).getName())
                {
                    playCard(button9.getName());
                }
            }
        }

        if (e.getSource() == button10)
        {
            String cardname = button10.getName();
            for (int i=0; i < playerlist[who_turn].getHand().size(); ++i)
            {
                if (cardname == playerlist[who_turn].getHand().get(i).getName())
                {
                    playCard(button10.getName());
                }
            }
        }

        if (e.getSource() == button11)
        {
            String cardname = button11.getName();
            for (int i=0; i < playerlist[who_turn].getHand().size(); ++i)
            {
                if (cardname == playerlist[who_turn].getHand().get(i).getName())
                {
                    playCard(button11.getName());
                }
            }
        }

        if (e.getSource() == button12)
        {
            String cardname = button12.getName();
            for (int i=0; i < playerlist[who_turn].getHand().size(); ++i)
            {
                if (cardname == playerlist[who_turn].getHand().get(i).getName())
                {
                    playCard(button12.getName());
                }
            }
        }

        if (e.getSource() == button13)
        {
            String cardname = button13.getName();
            for (int i=0; i < playerlist[who_turn].getHand().size(); ++i)
            {
                if (cardname == playerlist[who_turn].getHand().get(i).getName())
                {
                    playCard(button13.getName());
                }
            }
        }

        if (e.getSource() == button14)
        {
            String cardname = button14.getName();
            for (int i=0; i < playerlist[who_turn].getHand().size(); ++i)
            {
                if (cardname == playerlist[who_turn].getHand().get(i).getName())
                {
                    playCard(button14.getName());
                }
            }
        }

        if (e.getSource() == button15)
        {
            String cardname = button15.getName();
            for (int i=0; i < playerlist[who_turn].getHand().size(); ++i)
            {
                if (cardname == playerlist[who_turn].getHand().get(i).getName())
                {
                    playCard(button15.getName());
                }
            }
        }

        if (e.getSource() == timer)
        {
            specialNextTurn();
            timer.stop();
        }
    }

    public static void main(String[] args)
    {
        FinalGame game = new FinalGame();
    }
}