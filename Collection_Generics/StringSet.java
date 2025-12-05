package Collection_Generics;

import java.util.HashSet;

public class StringSet {
    public static void main(String[] args) {
        String str = "Hello";
        HashSet<Character> strSet = new HashSet<>();

        for (char s: str.toCharArray()) {
            strSet.add(s);
        }
        System.out.println(strSet.size());
    }
}
