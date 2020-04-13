import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class MyDrawing extends JPanel {
    Keeper keeper;
    MouseListener listenerForWalls;
    MouseListener listenerForBalls;
    MyFrame frame;


    @Override
    public void paintComponent(Graphics g) // new
    {
        for (int i = 0; i < keeper.balls.size(); i++) {
            Dot center = keeper.balls.get(i).center;
            double rad = keeper.balls.get(i).radius;
            Color color = g.getColor();
            g.setColor(keeper.balls.get(i).color);

            g.fillOval((int) (center.x - rad), (int) (center.y - rad), (int) (2 * rad), (int) (2 * rad));
            g.setColor(color);
        }

        for (Line wall : keeper.walls) {
//            System.out.println(wall.startingDot.x + " " + wall.startingDot.y);
            g.drawLine((int) (wall.startingDot.x), (int) (wall.startingDot.y), (int) (wall.endingDot.x), (int) (wall.endingDot.y));
        }

    }


    public MyDrawing(MyFrame frame) {
        super();
        this.frame = frame;
        keeper = new Keeper();
        keeper.balls.add(new Ball(40, 5, new Dot(500, 500), new Vector(20, 20))); // new

        setSize(1300, 600);
        Border raisedBevel = BorderFactory.createRaisedBevelBorder();
        Border blackLine = BorderFactory.createLineBorder(Color.BLACK);
        Border line = BorderFactory.createCompoundBorder(blackLine, raisedBevel);
        Font font = new Font("Purisa", Font.BOLD, 13);
        Border titledOne = BorderFactory.createTitledBorder(line, "My Animation", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, font);
//        ((TitledBorder)titledOne).setTitleJustification(TitledBorder.CENTER);
        setBorder(titledOne);

    }

    static ArrayList<Dot> dots;

    void addMouseListenerForGettingWalls() {
        dots = new ArrayList<>();
        listenerForWalls = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                repaint();
                revalidate();
//                System.out.println("mouse clicked");
                int x = mouseEvent.getX();
                int y = mouseEvent.getY();
                frame.settingPanel.detailPanel.wal.dotX.setText(String.valueOf(x));
                frame.settingPanel.detailPanel.wal.dotY.setText(String.valueOf(y));

//                System.out.println("x: " + x + " y: " + y);
                dots.add(new Dot(x, y));
                if (dots.size() > 1) {
                    int n = dots.size();
                    frame.drawing.keeper.addWall(new Line(dots.get(n - 2), dots.get(n - 1)));
                }
                if (dots.size() == frame.settingPanel.detailPanel.wal.numberOfWalls) {
                    frame.drawing.keeper.addWall(new Line(dots.get(dots.size() - 1), dots.get(0)));
                    frame.drawing.removeMouseListener(frame.drawing.listenerForWalls);
                }
                revalidate();
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }


        };
        addMouseListener(listenerForWalls);
    }

    int centerx, centery, rad, velX, velY, count;

    void addMouseListenerForGettingBalls() {

        listenerForBalls = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                repaint();
                revalidate();
                int x = mouseEvent.getX();
                int y = mouseEvent.getY();
                if (count == 0) {
                    centerx = x;
                    centery = y;
                    count++;
                } else if (count == 1) {
                    Dot center = new Dot(centerx, centery);
                    rad = (int) (center.distanceOf(new Dot(x, y)));
                    count++;
                } else {
                    Vector vectrrrrr = new Vector(velX - centerx, velY - centery);
                    BallsDetails ballsDetails = frame.settingPanel.detailPanel.bal;
                    ballsDetails.radiusTextField.setText("" + rad);
                    ballsDetails.xTextField.setText("" + centerx);
                    ballsDetails.yTextField.setText("" + centery);
                    ballsDetails.velxTextField.setText("" + velX);
                    ballsDetails.velyTextField.setText("" + velY);
                }
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        };
        addMouseListener(listenerForBalls);
    }
}