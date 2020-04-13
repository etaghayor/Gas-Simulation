public class Line {
    Dot startingDot, endingDot;
    public Line(Dot dot1, Dot dot2){
        this.startingDot = dot1;
        this.endingDot = dot2;
    }
    @Override
    public String toString(){
        return this.startingDot.x + " " + this.startingDot.y + " " + this.endingDot.x + " " + this.startingDot.y;
    }

}
