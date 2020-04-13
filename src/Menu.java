import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JPanel {
    JButton saveData;
    JButton loadData;
    JButton saveSimulation;
    JButton simulate;
    MyFrame frame;

    public Menu(MyFrame frame) {
        super();
        this.frame = frame;
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        setSize(510, 360);
        Border raisedBevel = BorderFactory.createRaisedBevelBorder();
        Border blackLine = BorderFactory.createLineBorder(Color.BLACK);
        Border line = BorderFactory.createCompoundBorder(blackLine, raisedBevel);
        Font font = new Font("Purisa", Font.BOLD, 13);
        Border titledOne = BorderFactory.createTitledBorder(line, "Menu", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, font);
//        ((TitledBorder)titledOne).setTitleJustification(TitledBorder.CENTER);
        setBorder(titledOne);
        constraints.weightx = 1;
        constraints.weighty = 3;
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        saveData = new JButton("save data");
        saveData.setFont(font);
        saveData.setPreferredSize(new Dimension(160, 65));
        add(saveData, constraints);
        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.BELOW_BASELINE;
        loadData = new JButton("load data");
        loadData.setFont(font);
        loadData.setPreferredSize(new Dimension(160, 65));
        add(loadData, constraints);
        saveSimulation = new JButton("save simulation");
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.BELOW_BASELINE;
        saveSimulation.setFont(font);
        saveSimulation.setPreferredSize(new Dimension(160, 65));
        add(saveSimulation, constraints);
        constraints.gridx = 1;
        constraints.gridy = 2;
//        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.BELOW_BASELINE;
        simulate = new JButton("SIMULATE!");
        simulate.setPreferredSize(new Dimension(160, 160));
        simulate.setFont(font);
        add(simulate, constraints);

        simulate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        saveData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser jc = new JFileChooser();
                int ret = jc.showDialog((Component) actionEvent.getSource(), "save");
                if (ret == JFileChooser.APPROVE_OPTION) {
//                    System.out.println("mikhad save kone dar : " + (jc.getSelectedFile().getAbsolutePath()));
                    frame.drawing.keeper.saveSetting(jc.getSelectedFile());
                }

            }
        });
        loadData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser jc = new JFileChooser();
                int ret = jc.showDialog((Component) actionEvent.getSource(), "load");
                if (ret == JFileChooser.APPROVE_OPTION){
                    frame.drawing.keeper.loadSetting(jc.getSelectedFile());
                }
            }
        });
    }
}
