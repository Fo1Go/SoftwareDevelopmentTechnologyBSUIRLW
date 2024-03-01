package LR2;

import LR2.Point;

public class Line {
    private Point p1;
    private Point p2;

    public Line(Point p1Val, Point p2Val) {
        this.setP1(p1Val);
        this.setP2(p2Val);
    }

    public void setP1(Point p1Val) {
        this.p1 = p1Val;
    }

    public void setP2(Point p2Val) {
        this.p2 = p2Val;
    }

    public Point getP1() {
        return this.p1;
    }

    public Point getP2() {
        return this.p2;
    }

    public String toString() {
        return "Line: " + p1.toString() + " - " + p2.toString();
    }

    public Point intersectionWithXAxis() {
        double xIntersect = (p1.getY() * p2.getX() - p2.getY() * p1.getX()) / (p1.getY() - p2.getY());
        return new Point(xIntersect, 0);
    }

    public Point intersectionWithYAxis() {
        double yIntersect = (p1.getX() * p2.getY() - p2.getX() * p1.getY()) / (p1.getX() - p2.getX());
        return new Point(0, yIntersect);
    }

    public Point intersectionWithLine(Line l) {
        double a1, a2, b1, b2, c1, c2;
        double x1, y1, x2, y2, x3, y3, x4, y4;
        x1 = p1.getX();
        x2 = p2.getX();
        y1 = p1.getY();
        y2 = p2.getY();
        y3 = l.p1.getY();
        y4 = l.p2.getY();
        x3 = l.p1.getX();
        x4 = l.p2.getX();

        a1 = y1 - y2;
        b1 = x2 - x1;
        c1 = x1 * y2 - x2 * y1;
        a2 = y3 - y4;
        b2 = x4 - x3;
        c2 = x3 * y4 - x4 * y3;

        double det = a1 * b2 - a2 * b1;
        double xIntersect = (b1 * c2 - b2 * c1) / det;
        double yIntersect = (a2 * c1 - a1 * c2) / det;

        return new Point(xIntersect, yIntersect);
    }

    public Line add(Line line) {
        this.setP1(this.getP1().add(line.getP2()));
        this.setP2(this.getP2().add(line.getP2()));
        return this;
    }

    public Line submission(Line line) {
        this.setP1(this.getP1().submission(line.getP2()));
        this.setP2(this.getP2().submission(line.getP2()));
        return this;
    }

    public Line multiply(Line line) {
        this.setP1(this.getP1().multiply(line.getP2()));
        this.setP2(this.getP2().multiply(line.getP2()));
        return this;
    }

    public Line division(Line line) {
        this.setP1(this.getP1().division(line.getP2()));
        this.setP2(this.getP2().division(line.getP2()));
        return this;
    }
};