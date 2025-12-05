package Arrays;
class CountOccurance {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 2, 5, 2, 6};

        System.out.print("Enter number to count its occurrence: ");
        int num = 5;

        int count = checkOccurence(arr, num);
        System.out.println("The number " + num + " occurs " + count + " times");
    }

    public static int checkOccurence(int[] arr, int num) {
        int count = 0;
        int i = 0;
        while (i < arr.length) {
            if (arr[i] == num) {
                count += 1;
            }
            i++;
        }
        return count;
    }
}

// for loop
// public static int checkOccurrence(int[] arr, int num) {
//     int count = 0;
//     for (int i = 0; i < arr.length; i++) {
//         if (arr[i] == num) {
//             count++;
//         }
//     }
//     return count;
// }

// for each
// public static int checkOccurrence(int[] arr, int num) {
//     int count = 0;
//     for (int value : arr) {
//         if (value == num) {
//             count++;
//         }
//     }
//     return count;
// }

// Java Streams
// public static long checkOccurrence(int[] arr, int num) {
//     return Arrays.stream(arr).filter(x -> x == num).count();
// }

// Hashmap
// import java.util.HashMap;
// import java.util.Map;

// public static Map<Integer, Integer> countAllOccurrences(int[] arr) {
//     Map<Integer, Integer> map = new HashMap<>();
//     for (int num : arr) {
//         map.put(num, map.getOrDefault(num, 0) + 1);
//     }
//     return map;
// }
// Map<Integer, Integer> freq = countAllOccurrences(arr);
// int count = freq.getOrDefault(num, 0);