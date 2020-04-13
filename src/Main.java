import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static void main(String[] args) {
        MyFrame frame = new MyFrame();
        frame.setVisible(true);


        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                frame.drawing.repaint();
             }
            },DelayPaint.saveDelay);
//        f.add(m);
//        f.setSize(1500, 1000);
//        f.setTitle("Elle's Paintings");
//        f.setLocationRelativeTo(null);
//        f.setBackground(Color.black);
//        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        f.setVisible(true);
    }
}
