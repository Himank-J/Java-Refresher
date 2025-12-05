package Functional_Interface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Chaining {
    public static void main(String[] args) {
        List<String> strList = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));
        strList.stream()
                .map(Integer::parseInt)
                .map(x -> x*x)
                .reduce(Integer::sum)
                .ifPresent(System.out::println);
    }
}
