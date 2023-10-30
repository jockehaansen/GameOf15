import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EventHandler implements MouseListener {

    JLabel l;
    JButton btn;
    private JLabel l2;
    private JLabel l3;
    private JLabel l4;
    private JLabel l5;

    JPanel jp;

    int lx, ly;

    public EventHandler(JLabel l, JPanel jp){
        this.l = l;
        this.jp = jp;
    }

    //Eventhantering för nytt spel och auto-win knappen
    public EventHandler(JButton btn) {
        this.btn = btn;
    }





    @Override
    public void mouseClicked(MouseEvent e) {
        if (l.getText() != null) {
            lx = l.getX();
            ly = l.getY();

            l2.setLocation(lx,ly+50);
            l3.setLocation(lx,ly-50);
            l4.setLocation(lx+50,ly);
            l5.setLocation(lx-50,ly);

            if (l2.getText() == null) {
                String temp = l2.getText();
                l.setText(temp);
                l2.setText(null);
            } else if (l3.getText() != null) {
                String temp = l3.getText();
                l.setText(temp);
                l3.setText(null);

            } else if (l4.getText() != null) {
                String temp = l4.getText();
                l.setText(temp);
                l4.setText(null);

            } else if (l5.getText() != null) {
                String temp = l5.getText();
                l.setText(temp);
                l5.setText(null);
            }

            // Implementera denna metod
            // hasPlayerWon();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //Eventuell kod för att highlighta den brickan man har musen på med att sätta bordern till en viss färg
        //Måste tas bort igen i MouseExited isåfall
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

