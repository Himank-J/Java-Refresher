package Arrays;
public class CheckSortedArr {
    public static void main(String[] args) {
        int[] arr = {4,3,4,1};
        boolean sorted_decreasing = isDecreasing(arr);
        boolean sorted_increasing = isIncreasing(arr);
        
        if (sorted_decreasing || sorted_increasing) {
            System.out.println("SORTED");
        } else {
            System.out.println("NO");
        }
    }

    public static boolean isDecreasing(int[] numArr) {
        int i = 1;
        while (i < numArr.length) {
            if (numArr[i] > numArr[i-1]) {
                return false;
            }
            i++;
        }
        return true;
    }
    public static boolean isIncreasing(int[] numArr) {
        int i = 1;
        while (i < numArr.length) {
            if (numArr[i] < numArr[i-1]) {
                return false;
            }
            i++;
        }
        return true;
    }
}
