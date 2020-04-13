import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class AnimationTime extends JPanel {
    MyFrame frame;
    TextField animationTime;
    TextField animationTimeArea;
    public AnimationTime(MyFrame frame){
        super();
        this.frame = frame;

        setSize( 385, 115);
        Border raisedBevel = BorderFactory.createRaisedBevelBorder();
        Border blackLine = BorderFactory.createLineBorder(Color.BLACK);
        Border line = BorderFactory.createCompoundBorder(blackLine, raisedBevel);
        Font font = new Font("Purisa", Font.BOLD, 13);
        Border titledOne = BorderFactory.createTitledBorder(line, "Animation Time", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, font);
//        ((TitledBorder)titledOne).setTitleJustification(TitledBorder.CENTER);
        setBorder(titledOne);
        Font font2 = new Font("Symbol", Font.PLAIN ,  12);
        
    }
}
