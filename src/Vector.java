public class Vector {
    double x, y;
    public Vector( double x, double y){
        this.x = x;
        this.y = y;
    }
    public double crossSize(Vector vector){
        return this.x*vector.y - this.y*vector.x;
    }
    public double innerCrossSize(Vector vector){
        return this.x * vector.x + this.y * vector.y;
    }
    public double vectorSize2(){
        return (this.x * this.x + this.y * this.y);
    }
    public Vector minus(Vector vector){
        Vector vec = new Vector(this.x - vector.x, this.y - vector.y);
        return vec;
    }
}
