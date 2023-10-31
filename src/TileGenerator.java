import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class TileGenerator extends JFrame implements ActionListener {

    JButton newGame = new JButton("Nytt spel");
    JLabel message = new JLabel(" ");
    JPanel top = new JPanel();
    JPanel game = new JPanel();
    JPanel bottom = new JPanel();
    ArrayList<JLabel> labelList = new ArrayList<>();

    public static Border standardBorder = BorderFactory.createLineBorder(Color.black);

    ArrayList<JLabel> labelList2 = new ArrayList<>();
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

        labelList2.add(new JLabel("1"));
        labelList2.add(new JLabel("2"));
        labelList2.add(new JLabel("3"));
        labelList2.add(new JLabel("4"));
        labelList2.add(new JLabel("5"));
        labelList2.add(new JLabel("6"));
        labelList2.add(new JLabel("7"));
        labelList2.add(new JLabel("8"));
        labelList2.add(new JLabel("9"));
        labelList2.add(new JLabel("10"));
        labelList2.add(new JLabel("11"));
        labelList2.add(new JLabel("12"));
        labelList2.add(new JLabel("13"));
        labelList2.add(new JLabel("14"));
        labelList2.add(new JLabel(" "));
        labelList2.add(new JLabel("15"));

        game.setLayout(new GridLayout(4, 4));
        setLabels(labelList);


        top.add(newGame);
        newGame.addActionListener(this);
        newGame.setFocusable(false);

        bottom.add(message);

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
    public void  setLabels(ArrayList<JLabel> list) {
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

            j.addMouseListener(new EventHandler(j,game));
        }
    }

    // metod som kollar av om alla är på rätt plats
    public void hasPlayerWon(ArrayList<JLabel> list){
        if (Objects.equals(list.get(0).getText(), "1") && Objects.equals(list.get(1).getText(), "2") && Objects.equals(list.get(2).getText(), "3")
                && Objects.equals(list.get(3).getText(), "4") && Objects.equals(list.get(4).getText(), "5") && Objects.equals(list.get(5).getText(), "6")
                && Objects.equals(list.get(6).getText(), "7") && Objects.equals(list.get(7).getText(), "8") && Objects.equals(list.get(8).getText(), "9")
                && Objects.equals(list.get(9).getText(), "10") && Objects.equals(list.get(10).getText(), "11") && Objects.equals(list.get(11).getText(), "12")
                && Objects.equals(list.get(12).getText(), "13") && Objects.equals(list.get(13).getText(), "14") && Objects.equals(list.get(14).getText(), "15")
                && Objects.equals(list.get(15).getText(), " ")) {
            message.setText("Grattis, du vann!");
            System.out.println("Du vann");
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        setLabels(labelList);
    }



    // fuskmetod med bara en bricka att flytta
    public void  setLabelsCheat(ArrayList<JLabel> list) {
        for (JLabel j : list) {
            j.setFont(new Font("Verdana", Font.PLAIN, 20));
            j.setPreferredSize(new Dimension(50, 50));
            j.setHorizontalAlignment(SwingConstants.CENTER);
            j.setVerticalAlignment(SwingConstants.CENTER);
            j.setOpaque(true);
            j.setBackground(Color.cyan);
            j.setBorder(BorderFactory.createLineBorder(Color.black));
            game.add(j);
            j.addMouseListener(new EventHandler(j,game));
        }
    }

}

