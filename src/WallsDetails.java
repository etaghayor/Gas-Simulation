import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WallsDetails extends JPanel {
    MyFrame frame;
    JTextField wallNumber;
    JTextField dotX;
    JTextField dotY;
    JLabel wallNumberLabel, dotXLabel, dotYLabel;
    JButton paintWall;

    public int numberOfWalls;
    public WallsDetails(MyFrame frame) {
        super();
        this.frame = frame;
        setSize(385, 280);
        Border raisedBevel = BorderFactory.createRaisedBevelBorder();
        Border blackLine = BorderFactory.createLineBorder(Color.BLACK);
        Border line = BorderFactory.createCompoundBorder(blackLine, raisedBevel);
        Font font = new Font("Purisa", Font.BOLD, 14);
        Font font2 = new Font("Purisa", Font.BOLD ,  12);
        Border titledOne = BorderFactory.createTitledBorder(line, "Walls' Detail", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, font);
//        ((TitledBorder) titledOne).setTitleJustification(TitledBorder.CENTER);
        setBorder(titledOne);

        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weighty = 1;
        constraints.weightx = 1;

        constraints.gridy = 0;
        constraints.gridx = 0;

        constraints.anchor = GridBagConstraints.LINE_END;
        wallNumberLabel = new JLabel("number of walls: ");
        wallNumberLabel.setFont(font2);
        add(wallNumberLabel, constraints);

        constraints.gridx = 1;
        constraints.anchor =  GridBagConstraints.LINE_START;
        wallNumber = new JTextField("4", 3);
        add(wallNumber, constraints);

        JButton okButton = new JButton("ok!");
        constraints.gridx = 2;
        okButton.setFont(font);
        add(okButton, constraints);

        paintWall = new JButton("PaintWall");
        paintWall.setFont(font);
//        constraints.gridx = 2;
//        add(paintWall, constraints);


        constraints.gridy = 1;

        constraints.gridx = 0;
        dotXLabel = new JLabel("x: ");
        constraints.anchor = GridBagConstraints.LINE_END;
        add(dotXLabel, constraints);

        constraints.gridx = 1;
        dotX = new JTextField("40", 5);
        constraints.anchor = GridBagConstraints.LINE_START;
        add(dotX, constraints);

        constraints.gridx = 2;
        dotYLabel = new JLabel("y: ");
        constraints.anchor = GridBagConstraints.LINE_END;
        add(dotYLabel, constraints);

        constraints.gridx = 3;
        dotY = new JTextField("40", 5);
        constraints.anchor = GridBagConstraints.LINE_START;
        add(dotY, constraints);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                    numberOfWalls = Integer.valueOf(wallNumber.getText());
                System.out.println(numberOfWalls);
                    frame.drawing.addMouseListenerForGettingWalls();
            }
        });

        constraints.gridy = 2;
        add(paintWall, constraints);

    }
}
