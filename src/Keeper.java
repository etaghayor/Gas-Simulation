import java.awt.*;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Keeper {
     ArrayList<Ball> balls = new ArrayList<>();
     ArrayList<Line> walls =  new ArrayList<>();

    public Keeper() {
//        balls = new ArrayList<>();
//        walls = new ArrayList<>();
    }

    public void addBall(Ball ball) {
        this.balls.add(ball);
    }

    public void addWall(Line wall) {
        this.walls.add(wall);
//        System.out.println("called");
    }

    public void saveSetting(File file) {
        try {
            file.getParentFile().mkdirs();
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.println(balls.size());
            for (int i = 0; i < balls.size(); i++) {
                System.out.println(balls.get(i).toString());
            }
            printWriter.println(walls.size());
            for (int i = 0; i < walls.size(); i++) {
                System.out.println(walls.get(i).toString());
            }
            printWriter.close();
        } catch (Exception e) {
            System.out.println("Setting can't be saved");
        }

    }

    public void loadSetting(File file) {
        try {
            Scanner loading = new Scanner(file);
            balls.clear();
            walls.clear();
            int ballsSize = loading.nextInt();
            for (int i = 0; i < ballsSize; i++) {
                double radius = loading.nextDouble();
                double mass = loading.nextDouble();
                double centerX = loading.nextDouble();
                double centerY = loading.nextDouble();
                double speedX = loading.nextDouble();
                double speedY = loading.nextDouble();
                int colorRed = loading.nextInt();
                int colorGreen = loading.nextInt();
                int colorBlue = loading.nextInt();
                balls.add(new Ball(radius, mass, new Dot(centerX, centerY), new Vector(speedX, speedY), new Color(colorRed, colorGreen, colorBlue)));
            }
            int wallsSize = loading.nextInt();
            for (int i = 0; i < wallsSize; i++) {
                double startingDotX = loading.nextDouble();
                double startingDotY = loading.nextDouble();
                double endingDotX = loading.nextDouble();
                double endingDotY = loading.nextDouble();
                walls.add(new Line(new Dot(startingDotX, startingDotY), new Dot(endingDotX, endingDotY)));
            }

        } catch (Exception e) {
           e.printStackTrace();
//            System.out.println("Setting can't be loaded");
        }

    }

    public void makeSimulationFile(File file, double time) {
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.println(time);
            printWriter.println(balls.size());
            for (Ball item : balls) {
                System.out.println(item.toString());
            }
            printWriter.println(walls.size());
            for (Line line : walls) {
                System.out.println(line.toString());
            }
            double now = 0;
            while (now <= time) {
                double hitTime = time;
                for (int i = 0; i < balls.size(); i++) {
                    for (int j = 0; j < i; j++) {
                        double hittingTime = balls.get(i).hittingBallTime(balls.get(j));
                        if (hittingTime != -1 && hittingTime > 0.000001) {
                            hitTime = Math.min(hitTime, hittingTime);
                        }
                    }
                }
                for (Ball value : balls) {
                    for (Line wall : walls) {
                        double hittingTime = value.hittingWallTime(wall);
                        if (hittingTime != -1 && hittingTime > 0.000001) {
                            hitTime = Math.min(hitTime, hittingTime);
                        }
                    }
                }
                now += hitTime;
                printWriter.println(now);
                ArrayList<Ball> oldData = new ArrayList<>(balls);
                for (Ball ball : balls) {
                    ball.center.x += ball.speed.x * hitTime;
                    ball.center.y += ball.speed.y * hitTime;
                }
                for (int i = 0; i < balls.size(); i++) {
                    for (int j = 0; j < i; j++) {
                        if (balls.get(i).center.distanceOf(balls.get(j).center) <= balls.get(i).radius + balls.get(j).radius) {
                            balls.get(i).speed = oldData.get(i).hittingBallSpeedPrim(oldData.get(j));
                            balls.get(j).speed = oldData.get(j).hittingBallSpeedPrim(oldData.get(j));
                        }
                    }
                }
                for (Ball ball : balls) {
                    for (Line wall : walls) {
                        double hittingTime = ball.hittingWallTime(wall);
                        Vector vect1 = new Vector(wall.endingDot.x - wall.startingDot.x, wall.endingDot.y - wall.startingDot.y);
                        Vector vect2 = new Vector(wall.startingDot.x - wall.endingDot.x, wall.startingDot.y - wall.endingDot.y);
                        Vector vectCenter = new Vector(ball.center.x - wall.endingDot.x, ball.center.y - wall.endingDot.y);
                        if (vect1.innerCrossSize(vectCenter) >= 0 && vect2.innerCrossSize(vectCenter) >= 0 && hittingTime != -1 && hittingTime > 0.000001) {
                            ball.speed = ball.hittingWallSpeedPrim(wall);
                        }
                    }
                }

                for (Ball ball : balls) {
                    printWriter.println(ball.toString());
                }
            }
        } catch (Exception e) {
            System.out.println("Simulation can't be saved");
        }
    }
}
