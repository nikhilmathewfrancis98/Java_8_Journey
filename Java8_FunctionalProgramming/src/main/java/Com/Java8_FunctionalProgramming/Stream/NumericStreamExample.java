package Com.Java8_FunctionalProgramming.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * If we are using the numeric values we can use the IntStream for playing with the numbers
 *  If we are using the normal list we are making use of the wrapper class as the type
 *  So the stream will unbox the Integer to int if we are using the reduce or any other method
 *  That's a behind the hood scene
 */
public class NumericStreamExample {
    public static void main(String[] args) {
        List<Integer> li= Arrays.asList(1,2,3,4,5,6);
        System.out.println("Without intStream"+SunOfNumers(li));
        System.out.println("With IntStream "+sumOfNumbersIntSream(li));
    }

    private static int SunOfNumers(List<Integer> li) {
        return li.stream().reduce(0,(x,y)->x+y); // here the stream is unboxing the Integer to Int
    }

    private static int sumOfNumbersIntSream(List<Integer> li){
        return IntStream.rangeClosed(1,6).sum();
    }
}
