package Com.Java8_FunctionalProgramming.Stream;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * 1: we have IntStream.range(1,50) -> Returns IntStream of 49 elements from 1-49
 * 2: IntStream.rangeClosed(1,50) -> returns 1-50
 * 3: LongStream.range(1,50) ->  Returns LongStream of 49 elements from 1-49
 * 4: LongStream.rangeClosed(1,50) -> Returns LongStream of 50 elements from 1-50
 * 5: DoubleStream -> do not support range and rangeClosed()
 */
public class NumericStreamRange_RangeClosed_Count_forEach {
    public static void main(String[] args) {
        // IntStream
        System.out.println("Count using the range() : "+IntStream.range(1,50).count());
        IntStream.range(1,50).forEach(x-> System.out.print(x+","));
        System.out.println();
        System.out.println("Count using the rangeClosed() : "+IntStream.rangeClosed(1,50).count());
        IntStream.rangeClosed(1,50).forEach(x-> System.out.print(x+","));
        //LongStream
        System.out.println();
        System.out.println("LongStream Count using the rangeClosed() : "+ LongStream.rangeClosed(1,50).count());
        LongStream.rangeClosed(1,50).forEach(x-> System.out.print(x+","));

//        DoubleStream we cannot use the .range and rangeClosed directly
        System.out.println();
        System.out.println("Double Streaming the Closed range values:");
        IntStream.rangeClosed(1,50).asDoubleStream().forEach(x-> System.out.print(x+",")); // asLongStream() also there


    }
}
