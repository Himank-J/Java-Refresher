package Abstraction_Interface;

public class AbstractMain {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        Rectangle rect = new Rectangle(10, 20);

        System.out.println(circle.calculateArea());
        System.out.println(rect.calculateArea());
    }
}
