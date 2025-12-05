package Arrays;
class ArraySumAverage {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};

        long sum = 0;
        int i = 0;
        while (i < arr.length) {
            sum += arr[i];
            i++;
        }

        System.out.println("Sum: " + sum);
        System.out.println("Average: " + (sum / arr.length));
    }
}

// Use for each
/* 
class ArraySumAverage {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};

        long sum = 0;
        for (int num : arr) {
            sum += num;
        }

        double average = (double) sum / arr.length;

        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
    }
}
*/

// Using Java stream
/*
import java.util.Arrays;

public class ArraySumAverage {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};

        long sum = Arrays.stream(arr).sum();
        double average = Arrays.stream(arr).average().orElse(0);

        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
    }
}
*/