package LR2;

public class Point {
    private double x;
    private double y;

    public Point(double xVal, double yVal) {
        this.setX(xVal);
        this.setY(yVal);
    }

    public void setX(double xVal) {
        this.x = xVal;
    }

    public void setY(double yVal) {
        this.y = yVal;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
};