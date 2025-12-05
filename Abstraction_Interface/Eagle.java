package Abstraction_Interface;

public class Eagle extends Bird {
    public static void main(String[] args) {
        Eagle eagle = new Eagle();
        eagle.fly();
    }   
    public void fly() {
        System.out.println("Eagle is flying");
    }
}
