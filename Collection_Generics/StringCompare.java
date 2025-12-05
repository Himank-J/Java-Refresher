package Collection_Generics;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Arrays;

public class StringCompare {
    public static void main(String[] args) {
        List<String> listStr = Arrays.asList("Zoe", "Alex", "John", "Christopher");
        List<String> sortedListStr = stringSorter(listStr);
        System.out.println(sortedListStr);
    }

    public static List<String> stringSorter(List<String> listStr) {
        Comparator<String> desc = (s1,s2) -> s2.compareTo(s1);
        Collections.sort(listStr, desc);
        return listStr;
    } 
}
