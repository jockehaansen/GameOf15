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
    ArrayList<JLabel> newList = new ArrayList<>();

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


        game.setLayout(new GridLayout(4, 4));
        newList=setLabels(labelList);

        victory(labelList, labelList);

        top.add(newGame);
        newGame.addActionListener(this);

        bottom.add(message);

        setLayout(new BorderLayout());
        add(top, BorderLayout.NORTH);
        add(game, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);


        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }


    // metod som tar in och blandar alla labels och sätter ut dom
    public ArrayList<JLabel> setLabels(ArrayList<JLabel> list) {
        Collections.shuffle(list);
        ArrayList<JLabel> newList = new ArrayList<>();
        for (JLabel j : list) {
            j.setFont(new Font("Verdana", Font.PLAIN, 15));
            j.setPreferredSize(new Dimension(50, 50));
            j.setHorizontalAlignment(SwingConstants.CENTER);
            j.setVerticalAlignment(SwingConstants.CENTER);
            j.setOpaque(true);
            j.setBackground(Color.cyan);
            j.setBorder(BorderFactory.createLineBorder(Color.black));
            game.add(j);
            newList.add(j);
        }
        return  newList;
    }

    // metod som tar in två listor, både orginalet i rätt ordning och den nya vi gör. Om båda överensstämmer så skrivs meddelandet ut.
    public void victory(ArrayList<JLabel> labelList, ArrayList<JLabel> newList) {
        int counter = 0;
        int noOfRightPlaces = 0;
        for (JLabel j: newList) {
            if (Objects.equals(j.getText(), labelList.get(counter).getText())){
                counter++;
            noOfRightPlaces++;
            }
        }
        if (noOfRightPlaces == 16){
            message.setText("Grattis, du vann!");
        }
/*        if (Objects.equals(list.get(0).getText(), "1") && Objects.equals(list.get(1).getText(), "2") && Objects.equals(list.get(2).getText(), "3")
                && Objects.equals(list.get(3).getText(), "4") && Objects.equals(list.get(4).getText(), "5") && Objects.equals(list.get(5).getText(), "6")
                && Objects.equals(list.get(6).getText(), "7") && Objects.equals(list.get(7).getText(), "8") && Objects.equals(list.get(8).getText(), "9")
                && Objects.equals(list.get(9).getText(), "10") && Objects.equals(list.get(10).getText(), "11") && Objects.equals(list.get(11).getText(), "12")
                && Objects.equals(list.get(12).getText(), "13") && Objects.equals(list.get(13).getText(), "14") && Objects.equals(list.get(14).getText(), "15")
                && Objects.equals(list.get(15).getText(), " ")) {
            message.setText("Grattis, du vann!");
        }*/

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setLabels(labelList);
    }
}

