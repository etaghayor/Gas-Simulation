public class Dot {
    double x, y;
    public Dot(double x, double y){
        this.x = x;
        this.y = y;
    }
    public double distanceOf( Dot dot){
        double a = dot.x - this.x;
        double b = dot.y - this.y;
        return Math.sqrt(a*a + b*b);
    }
    public boolean fitEquation(Line wall){
        return (this.y == ((wall.endingDot.y - wall.startingDot.y)%(wall.endingDot.x - wall.startingDot.x)) * (this.x - wall.startingDot.x) + wall.startingDot.y);
    }
}
