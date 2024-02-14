package Com.Java8_FunctionalProgramming.Stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import static java.util.Comparator.comparing;

/**
 * In this example we are going to see an example of Limit and skip of stream\
 * limit(n) -> limits the 'n' number of elements to be processed in the stream
 *
 */
public class Stream_Limit_Skip {

    public static long getTheRandom(){
        int min=1;
        int max=9;
        int range=max-min;
       return (int)Math.floor((Math.random() * range) + min);
    }
    public static void main(String[] args) {
        List<Integer> li= Arrays.asList(2,5,9,7,3,8,1,4,6);
//        System.out.println(li.stream() // Stream<Integer>
//                .limit(getTheRandom()). // Stream<Integer> but a sub stream w..r.t the randomNo
//                        peek(System.out::println).
//                reduce(Integer::max));
        System.out.println(li.stream().limit(2).reduce(Integer::sum).get());

        // Skip method and finding the max from the rest of the values
//        System.out.println(li.stream().skip(6).peek(System.out::println).max(Integer::compareTo));
//        System.out.println(li.stream().skip(3).peek(System.out::println).max(Comparator.comparing(Integer::new))); // a->a
//        System.out.println(li.stream().skip(7).peek(System.out::println).reduce(Integer::sum));
    }
}
