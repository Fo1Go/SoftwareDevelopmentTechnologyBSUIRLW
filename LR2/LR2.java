package LR2;

import LR2.Point;
import LR2.Line;

import java.util.ArrayList;
import java.util.Scanner;


// Создать классы, спецификации которых приведены ниже.
// Определить конструкторы и методы setТип(), getТип(), toString().
// Определить дополнительно методы в классе, создающем массив объектов.
// Реализовать методы сложения, вычитания, умножения и деления объектов (для тех классов,
// объекты которых могут поддерживать арифметические действия). Задать критерий выбора данных
// и вывести эти данные на консоль. В каждом классе, обладающем информацией, должно быть объявлено
// несколько конструкторов.
// 21. Определить класс Прямая на плоскости (в пространстве),
// параметры которой задаются с помощью Рациональной Дроби.
// Определить точки пересечения прямой с осями координат.
// Определить координаты пересечения двух прямых.

public class LR2 {
    public static void main(String[] args) {
        Point p1 = new Point(1, 2),
                p2 = new Point(4, 5),
                p3 = new Point(2, 1),
                p4 = new Point(5, 4),
                p5 = new Point(2, 4),
                p6 = new Point(1, 7);

        Line line1 = new Line(p1, p2);
        Line line2 = new Line(p3, p4);
        Line line3 = new Line(p5, p6);

        ArrayList<Line> lines = new ArrayList<>();
        lines.add(line1);
        lines.add(line2);
        lines.add(line3);

        boolean is_running = true;
        int chooseCommand = -1;

        while (is_running) {
            System.out.println("what you wanna do: ");
            System.out.println("1. Enter new line");
            System.out.println("2. Watch all lines");
            System.out.println("3. Find the intersection with axis");
            System.out.println("4. Find intersection between 2 lines");
            System.out.println("0. Exit");

            Scanner scanner = new Scanner(System.in);
            chooseCommand = scanner.nextInt();

            if (chooseCommand == 0) {
                is_running = false;
            } else if (chooseCommand == 1) {
                Point point1 = getPoint();
                Point point2 = getPoint();
                lines.add(new Line(point1, point2));
            } else if (chooseCommand == 2) {
                for (int index = 0; index < lines.size(); index++) {
                    System.out.println("Line " + index + ": " + lines.get(index).toString());
                }
            } else if (chooseCommand == 3) {
                int point1Number;
                System.out.println("Choose number of line: ");
                point1Number = scanner.nextInt();
                if (point1Number < lines.size() && point1Number >= 0) {
                    System.out.println("With axis X: " + lines.get(point1Number).intersectionWithXAxis().toString());
                    System.out.println("With axis Y: " + lines.get(point1Number).intersectionWithYAxis().toString());
                } else {
                    System.out.println("Not valid number");
                }
            } else if (chooseCommand == 4) {
                Point pointOfIntersection = null;
                int numberLine1, numberLine2;
                System.out.println("Choose number of first line: ");
                numberLine1 = scanner.nextInt();
                System.out.println("Choose number of second line: ");
                numberLine2 = scanner.nextInt();
                if ((numberLine1 < lines.size() && numberLine1 >= 0) &&
                        (numberLine2 < lines.size() && numberLine2 >= 0)) {
                    pointOfIntersection = lines.get(numberLine1).intersectionWithLine(lines.get(numberLine2));
                }
                if (Double.isInfinite(pointOfIntersection.getX()) && Double.isInfinite(pointOfIntersection.getY())) {
                    System.out.println("No point of intersection. They are parallel");
                } else {
                    System.out.println("Point of intersection: " + pointOfIntersection.toString());
                }
            } else {
                System.out.println("Unknown command!");
            }
        }
    }

    public static Point getPoint() {
        Scanner scanner = new Scanner(System.in);
        double x, y;
        System.out.println("Enter x coordinate: ");
        x = scanner.nextDouble();
        System.out.println("Enter y coordinate: ");
        y = scanner.nextDouble();
        return new Point(x, y);
    }
}
