import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class TileGenerator extends JFrame implements ActionListener {

    JButton newGame = new JButton("Nytt spel");
    JLabel message = new JLabel(" ");
    JPanel top = new JPanel();
    JPanel game = new JPanel();
    JPanel bottom = new JPanel();
    ArrayList<JLabel> labelList = new ArrayList<>();
    ArrayList<JLabel> labelList2 = new ArrayList<>();

    public static Border standardBorder = BorderFactory.createLineBorder(Color.black);


    public TileGenerator() {
        labelList.add(new JLabel("1"));
        labelList.add(new JLabel("2"));
        labelList.add(new JLabel("3"));
        labelList.add(new JLabel("4"));
        labelList.add(new JLabel("5"));
        labelList.add(new JLabel("6"));
        labelList.add(new JLabel("7"));
        labelList.add(new JLabel("8"));
        labelList.add(new JLabel("9"));
        labelList.add(new JLabel("10"));
        labelList.add(new JLabel("11"));
        labelList.add(new JLabel("12"));
        labelList.add(new JLabel("13"));
        labelList.add(new JLabel("14"));
        labelList.add(new JLabel("15"));
        labelList.add(new JLabel(" "));


        //Panels
        game.setLayout(new GridLayout(4, 4));

        //setLabels(labelList);
        setLabelsCheat(labelList);

        top.add(newGame);
        newGame.addActionListener(this);
        newGame.setFocusable(false);

        bottom.add(message);

        //Frame
        setLayout(new BorderLayout());
        add(top, BorderLayout.NORTH);
        add(game, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);

        setTitle("Game of 15");
        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        //För att läsa av posX, posY
        setResizable(false);
    }

    // metod som tar alla JLabel och gör dom till en lista, som vi sedan skickar in och kollar av i hasPlayerWon metoden
    public ArrayList<JLabel> testList (JPanel game){
        ArrayList<JLabel> test = new ArrayList<>();
        for (Component j: game.getComponents()) {
            test.add((JLabel) j);
        }
        return test;
    }

    // metod som tar in och blandar alla labels och sätter ut dom
    public void setLabels (ArrayList<JLabel> list) {
        Collections.shuffle(list);
        for (JLabel j : list) {
            j.setFont(new Font("Verdana", Font.PLAIN, 20));
            j.setPreferredSize(new Dimension(50, 50));
            j.setHorizontalAlignment(SwingConstants.CENTER);
            j.setVerticalAlignment(SwingConstants.CENTER);
            j.setOpaque(true);
            j.setBackground(Color.cyan);
            j.setBorder(standardBorder);
            game.add(j);

            j.addMouseListener(new EventHandler(j,game,message,list));
        }
    }

    //Bestämmer vilken lista som laddas när vi klickar på nytt spel
    @Override
    public void actionPerformed(ActionEvent e) {
        //setLabels(labelList);
        setLabelsCheat(labelList);
    }


    // fuskmetod med bara en bricka att flytta
    public void setLabelsCheat(ArrayList<JLabel> list) {
        for (JLabel j : list) {
            j.setFont(new Font("Verdana", Font.PLAIN, 20));
            j.setPreferredSize(new Dimension(50, 50));
            j.setHorizontalAlignment(SwingConstants.CENTER);
            j.setVerticalAlignment(SwingConstants.CENTER);
            j.setOpaque(true);
            j.setBackground(Color.cyan);
            j.setBorder(BorderFactory.createLineBorder(Color.black));
            game.add(j);
            j.addMouseListener(new EventHandler(j,game,message,list));
        }
    }

}

