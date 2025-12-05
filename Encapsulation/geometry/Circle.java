package Encapsulation.geometry;

public class Circle {
    private double radius;

    public Circle (double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }
}
