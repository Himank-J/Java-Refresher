package Arrays;
public class Search2DArr {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3}, {4,5,6,7}, {8}, {9,10}};
        int num = 11;
        boolean found = searchNum(arr, num);
        System.out.println(found);
    }

    public static boolean searchNum(int[][] arr, int num) {
        int i=0;
        while(i < arr.length) {
            int[] element = arr[i];
            int j = 0;
            while (j < element.length) {
                if (element[j] == num) {
                    return true;
                }
                j++;
            }
            i++;
        }
        return false;
    }
}
