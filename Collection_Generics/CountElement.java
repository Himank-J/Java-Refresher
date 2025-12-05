package Collection_Generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CountElement {
    public static void main(String[] args) {
        ArrayList<Integer> intList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 4, 4, 4, 4, 5));
        int element = 4;
        int freq = Collections.frequency(intList, element);
        System.out.println(freq);
    }
}
