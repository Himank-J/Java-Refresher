package Arrays;
public class Arr2DSumAvg {
    public static void main(String[] args) {
        double[][] arr = {{3,4,5},{61,888,908765},{10101,6654029,0}};
        double[] result = SumNAvg(arr);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    public static double[] SumNAvg(double[][] arr) {
        int i=0;
        double sum=0;
        double noOfElements = 0;
        while(i < arr.length) {
            double[] element = arr[i];
            int j = 0;
            while (j < element.length) {
                sum += element[j];
                noOfElements += 1;
                j++;
            }
            i++;
        }
        double avg = (sum/noOfElements);
        return new double[] {sum, avg};
    }
}
