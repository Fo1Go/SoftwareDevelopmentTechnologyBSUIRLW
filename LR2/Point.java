package LR2;

public class Point {
    private double x;
    private double y;

    public Point(double xVal, double yVal) {
        this.setX(xVal);
        this.setY(yVal);
    }

    public void setX(double xVal) {
        this.x = Math.ceil(xVal * 100) / 100;
    }

    public void setY(double yVal) {
        this.y = Math.ceil(yVal * 100) / 100;
    }

    private boolean isCloseToInt(double value) {
        return ((value - (int) (value) > -0.005) || (value - (int) (value) < 0.005));
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public Point add(Point point) {
        this.setX(this.getX() + point.getX());
        this.setY(this.getY() + point.getY());
        return this;
    }

    public Point submission(Point point) {
        this.setX(this.getX() - point.getX());
        this.setY(this.getY() - point.getY());
        return this;
    }

    public Point multiply(Point point) {
        this.setX(this.getX() * point.getX());
        this.setY(this.getY() * point.getY());
        return this;
    }

    public Point division(Point point) {
        this.setX(this.getX() / point.getX());
        this.setY(this.getY() / point.getY());
        return this;
    }

    public String toString() {
        String Xvalue = String.valueOf(this.getX());
        String Yvalue = String.valueOf(this.getY());
        if (this.isCloseToInt(this.getX())) {
            Xvalue = String.valueOf((int) this.getX());
        }
        if (this.isCloseToInt(this.getY())) {
            Yvalue = String.valueOf((int) this.getY());
        }
        return "(" + Xvalue + ", " + Yvalue + ")";
    }
};