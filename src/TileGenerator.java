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


    // metod som tar in och blandar alla labels och sätter ut dom
    public void setLabels(ArrayList<JLabel> list) {
        Collections.shuffle(list);
        for (JLabel j : list) {
            j.setFont(new Font("Verdana", Font.PLAIN, 15));
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

    @Override
    public void actionPerformed(ActionEvent e) {
        setLabels(labelList);
    }
}

