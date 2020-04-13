import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class MyFrame extends JFrame {
     MyDrawing drawing;
    MySettingPanel settingPanel;
    public MyFrame() {
        super();

        setSize(1300, 1000);
        setLayout(new BorderLayout());
        setFont(new Font("Purisa", Font.BOLD, 13));
        setTitle("Elle's Paintings");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        MyDrawing drawing = new MyDrawing(this);

        drawing.setMaximumSize(new Dimension(1300, 600));
        drawing.setMinimumSize(new Dimension(1300, 600));
        drawing.setPreferredSize(new Dimension(1300, 600));
        add(drawing, BorderLayout.SOUTH);

        MySettingPanel setting = new MySettingPanel(this);

        setting.setMaximumSize(new Dimension(1300, 370));
        setting.setMinimumSize(new Dimension(1300, 370));
        setting.setPreferredSize(new Dimension(1300, 370));
        add(setting,BorderLayout.NORTH);

        this.drawing = drawing;
        this.settingPanel = setting;
    }
}
