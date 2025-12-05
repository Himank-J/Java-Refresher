package Abstraction_Interface;

public class Rectangle extends Shape{
    private double length;
    private double breadth;

    Rectangle (double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public double calculateArea() {
        return this.length * this.breadth;
    }
}
