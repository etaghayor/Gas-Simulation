import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class MyDetailPanel extends JPanel {
    MyFrame frame;
    BallsDetails bal;
    WallsDetails wal;
    public MyDetailPanel(MyFrame frame) {

        super();
        this.frame = frame;
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        setSize(780, 360);
//        Border raisedBevel = BorderFactory.createRaisedBevelBorder();
//        Border blackLine = BorderFactory.createLineBorder(Color.BLACK);
//        Border line = BorderFactory.createCompoundBorder(blackLine, raisedBevel);
//        Border titledOne = BorderFactory.createTitledBorder(line, "MySetting");
//        ((TitledBorder)titledOne).setTitleJustification(TitledBorder.CENTER);
//      setBorder(titledOne);
        constraints.weightx = 1;
        constraints.weighty = 1;

        constraints.gridy = 0;

        constraints.gridx = 0;
        BallsDetails bal = new BallsDetails(frame);
        bal.setMaximumSize(new Dimension(385, 240));
        bal.setMinimumSize(new Dimension(385, 240));
        bal.setPreferredSize(new Dimension(385, 240));
        add(bal, constraints);

        constraints.gridx = 1;
        WallsDetails wal = new WallsDetails(frame);
        wal.setMaximumSize(new Dimension(385, 240));
        wal.setMinimumSize(new Dimension(385, 240));
        wal.setPreferredSize(new Dimension(385, 240));
        add(wal, constraints);

        constraints.gridy = 1;

        constraints.gridx = 0;
        AnimationTime t = new AnimationTime(frame);
        t.setMaximumSize(new Dimension(385, 115));
        t.setMinimumSize(new Dimension(385, 115));
        t.setPreferredSize(new Dimension(385, 115));
        add(t,constraints);

        constraints.gridx = 1;
        DelayPaint delay = new DelayPaint(frame);
        delay.setMaximumSize(new Dimension(385, 115));
        delay.setMinimumSize(new Dimension(385, 115));
        delay.setPreferredSize(new Dimension(385, 115));
        add(delay,constraints);


        this.bal = bal;
        this.wal = wal;

    }
}
