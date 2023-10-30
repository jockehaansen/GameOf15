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


    public TileGenerator(){
        ArrayList<JLabel> labelList = new ArrayList<>();
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
        labelList.add(new JLabel("null"));

            game.setLayout(new GridLayout(4, 4));
            setLabels(labelList);


            top.add(newGame);
            newGame.addActionListener(this);

            bottom.add(message);

            setLayout(new GridLayout(3,1));
            add(top);
            add(game);
            add(bottom);

            pack();
            setVisible(true);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }

        // metod som tar in och blandar alla labels och sätter ut dom
        public void setLabels (ArrayList<JLabel> list){
            Collections.shuffle(list);
            for (JLabel j: list) {
                j.setFont(new Font("Verdana", Font.PLAIN, 15));
                j.setPreferredSize(new Dimension(50,50));
                j.setHorizontalAlignment(SwingConstants.CENTER);
                j.setVerticalAlignment(SwingConstants.CENTER);
                j.setBorder(BorderFactory.createLineBorder(Color.black));
                game.add(j);
            }
        }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

