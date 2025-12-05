package Collection_Generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class SwapElements {
    
    public static void main(String[] args) {
        
        ArrayList<Integer> intList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        Collections.swap(intList, 2, 4);
        System.out.println(intList);
    }
}
