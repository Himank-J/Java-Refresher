package Arrays;
public class MinMaxArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,9,6,7,8,9};  
        int maxVal = getMax(arr);
        int minVal = getMin(arr);
        
        System.out.println(maxVal);
        System.out.println(minVal);
    }

    public static int getMax(int[] arr) {
        int maxVal = Integer.MIN_VALUE;
        int i = 0;
        while (i < arr.length) {
            if (arr[i] > maxVal) {
                maxVal = arr[i];
            }
            i++;
        }
        return maxVal;
    }

    public static int getMin(int[] arr) {
        int minVal = Integer.MAX_VALUE;
        int i = 0;
        while (i < arr.length) {
            if (arr[i] < minVal) {
                minVal = arr[i];
            }
            i++;
        }
        return minVal;
    }
}

// for loop
// public static int getMax(int[] arr) {
//     int maxVal = Integer.MIN_VALUE;
//     for (int i = 0; i < arr.length; i++) {
//         if (arr[i] > maxVal) {
//             maxVal = arr[i];
//         }
//     }
//     return maxVal;
// }

// public static int getMin(int[] arr) {
//     int minVal = Integer.MAX_VALUE;
//     for (int i = 0; i < arr.length; i++) {
//         if (arr[i] < minVal) {
//             minVal = arr[i];
//         }
//     }
//     return minVal;
// }

// for each
// public static int getMax(int[] arr) {
//     int maxVal = Integer.MIN_VALUE;
//     for (int num : arr) {
//         if (num > maxVal) {
//             maxVal = num;
//         }
//     }
//     return maxVal;
// }

// public static int getMin(int[] arr) {
//     int minVal = Integer.MAX_VALUE;
//     for (int num : arr) {
//         if (num < minVal) {
//             minVal = num;
//         }
//     }
//     return minVal;
// }

// for each combined
// public static int[] getMinMax(int[] arr) {
//     int min = Integer.MAX_VALUE;
//     int max = Integer.MIN_VALUE;

//     for (int num : arr) {
//         if (num > max) max = num;
//         if (num < min) min = num;
//     }

//     return new int[]{min, max};
// }

// int[] result = getMinMax(arr);
// System.out.println("Min: " + result[0]);
// System.out.println("Max: " + result[1]);
