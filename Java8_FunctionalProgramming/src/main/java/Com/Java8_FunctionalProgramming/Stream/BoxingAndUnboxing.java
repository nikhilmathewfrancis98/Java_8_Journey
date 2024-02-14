package Com.Java8_FunctionalProgramming.Stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BoxingAndUnboxing {
    public static void main(String[] args) {
        System.out.println(boxing());
        List<Integer> boxedValues=boxing();
//        unBoxing(boxedValues).forEach(System.out::println);// 1-10 primitive types
        System.out.println(unBoxing(boxedValues));
    }

    private static int unBoxing(List<Integer> boxedValues) {
        return boxedValues.stream() // Stream of integers
                .mapToInt(Integer::intValue) // return type is inStream(int value of the wrapper class)
                .reduce(0,(x,y)->x+y); // her we return a int type also we can use .sum()
    }

    private static List<Integer> boxing() {
    return IntStream.rangeClosed(1,10) // int stream of 10 elements
            .boxed() // boxed to Integer Elements
            .collect(Collectors.toList());

    }
}
