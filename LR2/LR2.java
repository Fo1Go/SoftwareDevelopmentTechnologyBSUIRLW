package LR2;

import LR2.Point;
import LR2.Line;


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
// Создать массив/список/множество объектов и определить группы параллельных прямых.
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

        System.out.println("Line 1: " + line1.toString());
        System.out.println("Line 2: " + line2.toString());
        System.out.println("Line 3: " + line3.toString());
        System.out.println("Line1 intersect X-axis: " + line1.intersectionWithXAxis().toString());
        System.out.println("Line1 intersect X-axis: " + line1.intersectionWithYAxis().toString());

        System.out.println("Intersection of Line 1 and Line 2: " + line1.intersectionWithLine(line2).toString());
        System.out.println("Intersection of Line 1 and Line 3: " + line1.intersectionWithLine(line3).toString());
    }
}
