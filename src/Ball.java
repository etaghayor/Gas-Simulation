import javax.print.attribute.standard.OrientationRequested;
import java.awt.*;
import java.util.Random;

public class Ball {
    double radius, mass;
    Dot center;
    Vector speed;
    Color color;
//    double speedSize;
//    double teta;

    public Ball(double radius, double mass, Dot center, Vector speed, Color color) {
        this.radius = radius;
        this.mass = mass;
        this.center = center;
        this.speed = speed;
        this.color = color;
//        this.teta = Math.atan(speed.y / speed.x);
//        this.speedSize = Math.sqrt(speed.y * speed.y + speed.x * speed.x);
    }

    public Ball(double radius, double mass, Dot center, Vector speed) {
        this.radius = radius;
        this.mass = mass;
        this.center = center;
        this.speed = speed;
//        this.teta = Math.atan(speed.y / speed.x);
//        this.speedSize = Math.sqrt(speed.y * speed.y + speed.x * speed.x);
        Random randomGenerator = new Random();
        int red = randomGenerator.nextInt(256);
        int green = randomGenerator.nextInt(256);
        int blue = randomGenerator.nextInt(256);
        this.color = new Color(red,green,blue);
    }


    public Vector hittingBallSpeedPrim(Ball ball) {
        Vector vectorMinus1 = this.speed.minus(ball.speed);
//        Vector vectorMinus2 = ball.speed.minus(this.speed);
        Vector xMinus1 = new Vector(this.center.x - ball.center.x, this.center.y - ball.center.y);
//        Vector xMinus2 = new Vector(ball.center.x - this.center.x, ball.center.y - this.center.y);
        double dob1 = (2 * ball.mass) / (this.mass + ball.mass) * (vectorMinus1.innerCrossSize(xMinus1) / xMinus1.vectorSize2());
//        double dob2 = (2 * this.mass) / (this.mass + ball.mass) * (vectorMinus2.innerCrossSize(xMinus2) / xMinus2.vectorSize2());
        Vector vec1 = new Vector(dob1 * xMinus1.x, dob1 * xMinus1.y);
//        Vector vec2 = new Vector(dob2* xMinus2.x, dob2 * xMinus2.y);
        Vector v1 = this.speed.minus(vec1);
//        Vector v2 = ball.speed.minus(vec2);
        return v1;
//    double phi = (ball.center.y - this.center.y) / (ball.center.x - this.center.x);
//    double a = this.speedSize * Math.cos(this.teta - phi) * (this.mass - ball.mass) + 2 * this.mass * ball.mass * Math.cos(ball.teta - phi) / (this.mass + ball.mass);
//    double v1x = a * Math.cos(phi) + this.speedSize * Math.sin(this.teta - phi) * Math.cos(phi + Math.PI/2);
//    double v1y =a * Math.sin(phi) + this.speedSize * Math.sin(this.teta - phi) * Math.sin(phi + Math.PI/2);
//    double v2x =
    }

    public Vector hittingWallSpeedPrim(Line wall) {
        Vector vect = new Vector(wall.endingDot.x - wall.startingDot.x, wall.endingDot.y - wall.startingDot.y);
        double doub = 2 * this.speed.innerCrossSize(vect) / vect.vectorSize2();
        Vector vPrime = new Vector(doub * vect.x, doub * vect.y);
        return vPrime;
    }
//    public double hittingBalLocation(Ball ball){
//    if this.
//    }
//    public double hittingWallLocation(Line wall){
//
//    }

    public double hittingBallTime(Ball ball) {
        double a = this.center.x - ball.center.x;
        double b = this.speed.x - ball.speed.x;
        double c = this.center.y - ball.center.y;
        double d = this.speed.y - ball.speed.y;
        double delta = 4 * (a * b + c * d) * (a * b + c * d) - 4 * (b * b + d * d) * (a * a + c * c - (this.radius + ball.radius) * (this.radius + ball.radius));
        if (delta > 0) {
            return Math.min((-2 * (a * b + c * d) + Math.sqrt(delta)) / (2 * (b * b + d * d)), -2 * (a * b + c * d) - Math.sqrt(delta) / (2 * (b * b + d * d)));
        } else
            return -1;

    }

    public double hittingWallTime(Line wall) {
        double a = this.center.x - wall.startingDot.x;
        double b = wall.endingDot.y - wall.startingDot.y;
        double c = this.center.y - wall.startingDot.y;
        double d = wall.endingDot.x - wall.startingDot.x;
        double e = this.speed.x * b - this.speed.y * d;
        double delta = 4 * (e * e) * (a * b - c * d) - 4 * (e * e) * ((a * b - c * d) * (a * b - c * d) - this.radius * this.radius * (b * b + d * d));
        if (delta > 0) {
            return ((-2 * (e * (a * b - c * d) - delta)) / (2 * e));
        } else
            return -1;
    }

    @Override
    public String toString(){
        return this.radius + " " + this.mass + " " + this.center.x + " " + this.center.y + " " + this.speed.x + " " + this.speed.y + " " + this.color.getRed() + " " + this.color.getGreen() + " " + this.color.getBlue();
    }
}
