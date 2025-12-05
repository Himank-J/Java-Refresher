package Strings_MathsFunctions;

public class CircleMaths {
    public static void main(String[] args) {
        int r = 3;
        double perimeter = 2 * Math.PI * r;
        double area = Math.PI * Math.pow(r, 2);
        System.out.printf("Perimeter is %f", perimeter);
        System.out.printf("\\nArea is %f", area);
    }
}
