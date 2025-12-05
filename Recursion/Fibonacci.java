package Recursion;

public class Fibonacci {
    
    public static void main(String[] args) {
        
        int num = 8;
        for (int i = 1; i <= num; i++) {
            System.out.print(fibonacci(i) + " ");
        }   
        System.out.println();
    }

    public static int fibonacci(int position) {
        if (position == 1) {
            return 0;
        }
        if (position == 2) {
            return 1;
        }
        return fibonacci(position - 1)
                + fibonacci(position - 2);
    } 
}
