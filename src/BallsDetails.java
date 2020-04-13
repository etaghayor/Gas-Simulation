import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ConcurrentSkipListMap;

public class BallsDetails extends JPanel {
    MyFrame frame;
    JTextField radiusTextField, massTextField, numberOfBallsTextField, xTextField, yTextField, velxTextField, velyTextField;
    JButton addButtopn;
    JLabel radiusLabel, massLabel, numberOfBallsLabel, xLabel, yLabel, velxLabel, velyLabel;
    int numberOfBalls;
    public BallsDetails(MyFrame frame) {
        super();
        this.frame = frame;
        setSize(385, 280);
        Border raisedBevel = BorderFactory.createRaisedBevelBorder();
        Border blackLine = BorderFactory.createLineBorder(Color.BLACK);
        Border line = BorderFactory.createCompoundBorder(blackLine, raisedBevel);
        Font font = new Font("Purisa", Font.BOLD, 13);
        Font font2 = new Font("Purisa", Font.BOLD, 12);
        Border titledOne = BorderFactory.createTitledBorder(line, "Balls' Detail", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, font);
//        ((TitledBorder)titledOne).setTitleJustification(TitledBorder.CENTER);
        setBorder(titledOne);
//        setFont(font);
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();


        constraints.weighty = 1;
        constraints.weightx = 1;

        constraints.gridy = 0;

        numberOfBallsLabel = new JLabel("number of dots: ");
        numberOfBallsLabel.setFont(font2);
        numberOfBallsTextField = new JTextField("4", 3);
        JButton submitButton = new JButton("ok!");
        submitButton.setFont(font);

        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.gridx = 0;
        add(numberOfBallsLabel, constraints);

        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.gridx = 1;
        add(numberOfBallsTextField, constraints);

        constraints.gridx = 3;
        add(submitButton, constraints);

        constraints.gridy = 1;

        massLabel = new JLabel("mass: ");
        massLabel.setFont(font2);
        massTextField = new JTextField("1", 3);
        radiusLabel = new JLabel("radius: ");
        radiusLabel.setFont(font2);
        radiusTextField = new JTextField("10 ", 3);

        constraints.gridx = 0;
        constraints.anchor = GridBagConstraints.LINE_END;
        add(massLabel, constraints);

        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.LINE_START;
        add(massTextField, constraints);

        constraints.gridx = 2;
        constraints.anchor = GridBagConstraints.LINE_END;
        add(radiusLabel, constraints);

        constraints.gridx = 3;
        constraints.anchor = GridBagConstraints.LINE_START;
        add(radiusTextField, constraints);

        constraints.gridy = 2;

        xLabel = new JLabel("center(x): ");
        xLabel.setFont(font2);
        yLabel = new JLabel("center(y): ");
        yLabel.setFont(font2);
        xTextField = new JTextField("500", 3);
        yTextField = new JTextField("800", 3);

        constraints.gridx = 0;
        constraints.anchor = GridBagConstraints.LINE_END;
        add(xLabel, constraints);

        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.LINE_START;
        add(xTextField, constraints);

        constraints.gridx = 2;
        constraints.anchor = GridBagConstraints.LINE_END;
        add(yLabel, constraints);

        constraints.gridx = 3;
        constraints.anchor = GridBagConstraints.LINE_START;
        add(yTextField, constraints);

        constraints.gridy = 3;

        velxLabel = new JLabel("speed(x): ");
        velxLabel.setFont(font2);
        velyLabel = new JLabel("speed(y): ");
        velyLabel.setFont(font2);
        velxTextField = new JTextField("10", 3);
        velyTextField = new JTextField("10", 3);

        constraints.gridx = 0;
        constraints.anchor = GridBagConstraints.LINE_END;
        add(velxLabel, constraints);

        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.LINE_START;
        add(velxTextField, constraints);

        constraints.gridx = 2;
        constraints.anchor = GridBagConstraints.LINE_END;
        add(velyLabel, constraints);

        constraints.gridx = 3;
        constraints.anchor = GridBagConstraints.LINE_START;
        add(velyTextField, constraints);

        constraints.gridy = 4;

        addButtopn = new JButton("PaintBall");
        addButtopn.setFont(font);
        constraints.gridx = 3;
        add(addButtopn, constraints);



        addButtopn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                    numberOfBalls = Integer.valueOf(numberOfBallsTextField.getText());
                 }
                catch (Exception e){
                    System.out.println("Not a number");
                }
            }
        });
    }
}
