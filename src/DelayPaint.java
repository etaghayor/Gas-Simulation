import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

public class DelayPaint extends JPanel {
    MyFrame frame;
    TextField t;
    JLabel tLabel;
    JButton ok;
    public static int saveDelay = 5;
    public DelayPaint(MyFrame frame){
        super();
        this.frame = frame;
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        setSize( 385, 115);
        Border raisedBevel = BorderFactory.createRaisedBevelBorder();
        Border blackLine = BorderFactory.createLineBorder(Color.BLACK);
        Border line = BorderFactory.createCompoundBorder(blackLine, raisedBevel);
        Font font = new Font("Purisa", Font.BOLD ,  13);
        Border titledOne = BorderFactory.createTitledBorder(line, "Paint Delay", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, font);
//        ((TitledBorder)titledOne).setTitleJustification(TitledBorder.CENTER);
        Font font2 = new Font("Purisa", Font.BOLD ,  12);
        setBorder(titledOne);

        constraints.weighty = 1;
        constraints.weightx = 1;

        constraints.gridy = 0;

        constraints.gridx = 0;
        constraints.anchor = GridBagConstraints.LINE_END;
        t = new TextField("5", 3);
        tLabel = new JLabel("Paint Delay time(milli second):  " );
        tLabel.setFont(font2);
        add(tLabel, constraints);
        ok = new JButton("OK!");
        ok.setFont(font);
        ok.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    saveDelay = Integer.valueOf(t.getText());
                } catch (Exception ee) {
                    System.out.println("Not a number");
                }
            }

        });

        constraints.weightx=2;
        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.LINE_START;
        add(t, constraints);
//        constraints.weightx=1;
        constraints.gridx = 2;
        constraints.anchor = GridBagConstraints.LINE_START;
        add(ok, constraints);

//        tLabel.setBounds(100, 100 , 20 , 20);
//        t.setBounds();
    }

}
