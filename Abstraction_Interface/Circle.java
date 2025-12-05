package Abstraction_Interface;

public class Circle extends Shape {
    private double radius;

    Circle (double radius) {
        this.radius = radius;
    }
    public double calculateArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }
}
