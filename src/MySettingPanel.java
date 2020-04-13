import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class MySettingPanel extends JPanel {
    MyFrame frame;
    MyDetailPanel detailPanel;
    public MySettingPanel(MyFrame frame){
        super();
        this.frame = frame;
        setSize(1300, 370);
//        Border raisedBevel = BorderFactory.createRaisedBevelBorder();
//        Border blackLine = BorderFactory.createLineBorder(Color.BLACK);
//        Border line = BorderFactory.createCompoundBorder(blackLine, raisedBevel);
//        Border titledOne = BorderFactory.createTitledBorder(line, "#BONJOUR#");
//        ((TitledBorder)titledOne).setTitleJustification(TitledBorder.CENTER);
//        setBorder(blackLine);
        Menu details = new Menu(frame);
        details.setMaximumSize(new Dimension(510, 360));
        details.setMinimumSize(new Dimension(510, 360));
        details.setPreferredSize(new Dimension(510, 360));
        add(details,BorderLayout.WEST);

        MyDetailPanel details2 = new MyDetailPanel(frame);
        details2.setMaximumSize(new Dimension(780, 360));
        details2.setMinimumSize(new Dimension(780, 360));
        details2.setPreferredSize(new Dimension(780, 360));
        add(details2,BorderLayout.EAST);
        this.detailPanel = details2;
    }
}
