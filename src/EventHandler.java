import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EventHandler implements MouseListener {

    JLabel l;
    JButton btn;
    Component c2, c3,c4,c5;
    JPanel jp;

    JLabel l2 = new JLabel();
    JLabel l3 = new JLabel();
    JLabel l4 = new JLabel();
    JLabel l5 = new JLabel();

    Point l2tempPoint,l3tempPoint,l4tempPoint,l5tempPoint;
    int lx, ly;

    public EventHandler(JLabel l, JPanel jp){
        this.l = l;
        this.jp = jp;
    }


    //Eventhantering för nytt spel och auto-win knappen
    public EventHandler(JButton btn) {
        this.btn = btn;
    }

    private boolean IsLabelInViewAndValid(JLabel label){
        if (label.getLocation().y < 1 || label.getLocation().y > 223 || label.getLocation().x < 0 || label.getLocation().x > 288) {
            return false;
        } else if (!label.getText().isBlank()) {
            return false;
        } else return true;
    }





    @Override
    public void mouseClicked(MouseEvent e) {
        //Eventuellt flytta ut detta till en getLabelLocations metod
        lx = l.getLocation().x;
        ly = l.getLocation().y;


        //TODO kör kontroller på att de inte är out-of-bounds innan vi sätter punkter och castar om
        l2tempPoint = new Point(lx,ly-74);
        if (l2tempPoint.getLocation().y >= 1) {
            c2 = jp.getComponentAt(l2tempPoint);
            l2 = (JLabel) c2;
        }

        l3tempPoint = new Point(lx,ly+74);
        if (l3tempPoint.getLocation().y <= 223) {
            c3 = jp.getComponentAt(l3tempPoint);
            l3 = (JLabel) c3;
        }

        l4tempPoint = new Point(lx-96,ly);
        if (l4tempPoint.getLocation().x >= 0) {
            c4 = jp.getComponentAt(l4tempPoint);
            l4 = (JLabel) c4;
        }

        l5tempPoint = new Point(lx+96,ly);
        if (l5tempPoint.getLocation().x <= 288) {
            c5 = jp.getComponentAt(l5tempPoint);
            l5 = (JLabel) c5;
        }


        if (l.getText().isBlank()) {
            System.out.println("klickade på en tom label");
            System.out.println("l location" + l.getLocation());
            System.out.println("l2temp" + l2tempPoint);
            System.out.println(l2.getText());
            System.out.println("----------");
            System.out.println("l3temp" + l3tempPoint);
            System.out.println(l3.getText());
            System.out.println("----------");
            System.out.println("l4temp" + l4tempPoint);
            System.out.println(l4.getText());
            System.out.println("----------");
            System.out.println("l5temp" + l5tempPoint);
            System.out.println(l5.getText());
            System.out.println("----------");

        } else {
            System.out.println("Klickade på en fylld label");
            System.out.println("l location" + l.getLocation());
            System.out.println("l2temp" + l2tempPoint);
            System.out.println(l2.getText());
            System.out.println("----------");
            System.out.println("l3temp" + l3tempPoint);
            System.out.println(l3.getText());
            System.out.println("----------");
            System.out.println("l4temp" + l4tempPoint);
            System.out.println(l4.getText());
            System.out.println("----------");
            System.out.println("l5temp" + l5tempPoint);
            System.out.println(l5.getText());
            System.out.println("----------");

        }


            if (IsLabelInViewAndValid(l2)) {
                l2.setText(l.getText());
                l.setText(" ");
            } else if (IsLabelInViewAndValid(l3)) {
                l3.setText(l.getText());
                l.setText(" ");
            } else if (IsLabelInViewAndValid(l4)) {
                l4.setText(l.getText());
                l.setText(" ");
            } else if (IsLabelInViewAndValid(l5)) {
                l5.setText(l.getText());
                l.setText(" ");
            }



            // Implementera denna metod
            // hasPlayerWon();
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

