package Encapsulation.utils;

import Encapsulation.geometry.Circle;
import Encapsulation.geometry.Rectangle;

public class AreaCalculator {
    public static void main(String[] args) {
        Circle circle = new Circle(5.5);
        Rectangle rect = new Rectangle(2, 5);

        double circleArea = circle.calculateArea();
        double rectArea = rect.calculateArea();

        System.out.printf("Area of cirlce is %f", circleArea);
        System.out.printf("Area of rectangle is %f", rectArea);
    }
}
