package Arrays;
public class DeleteElement {
    public static void main(String[] args) {
        int numToDelete = 5;
        int[] arr = {1,2,3,6,7,8};
        int[] newArr = deleteNumber(arr, numToDelete);
        int i = 0;
        while (i < newArr.length) {
            System.out.print(newArr[i] + " ");
            i++;
        }
        System.out.println();
    }
    
    public static int[] deleteNumber(int[] numArr, int numToDelete) {
        int occ = CountOccurance.checkOccurence(numArr, numToDelete);
        if (occ == 0) {
            return numArr;
        }
        int newSize = numArr.length - occ;
        int[] newArr = new int[newSize];

        int i = 0, j = 0;
        while (i < numArr.length) {
            if (numArr[i] != numToDelete) {
                newArr[j] = numArr[i];
                j++;
            }
            i++;
        }

        return newArr;
    }
}
