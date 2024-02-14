package Com.Java8_FunctionalProgramming.Stream;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 *  Aggregate fn's like - sum(),max(),min(),average()
 */
public class NumericStreamAggregate {
    public static void main(String[] args) {

        System.out.println("The sum of 1-50 is :"+IntStream.rangeClosed(1,50).sum()); // Sum

        // Max() as IntStream
         OptionalInt max= IntStream.rangeClosed(1,50).max();
        System.out.println("The max value is : "+ ((max.isPresent()) ? max.getAsInt(): " No value "));
        // Max() as longStream
        OptionalLong maxLong= LongStream.rangeClosed(1,50).max();
        System.out.println("The max value is : "+ ((maxLong.isPresent()) ? maxLong.getAsLong(): " No value "));

        // Min() as intStream
        OptionalInt max1= IntStream.rangeClosed(50,100).max();
        OptionalInt min= IntStream.rangeClosed(50,100).min();
        System.out.println("The min as intStream value is : "+ ((min.isPresent()) ? min.getAsInt(): " No value "));
        // Min() as LongStream
        OptionalLong max2Long= LongStream.rangeClosed(50,100).max();
        OptionalLong minLong= LongStream.rangeClosed(50,100).min();
        System.out.println("The min as LongStream value is : "+ ((minLong.isPresent()) ? minLong.getAsLong(): " No value "));

        // Average()

       OptionalDouble avg= IntStream.rangeClosed(1,50).average(); // Explore the method average so that we can see the return type of that method
        System.out.println("The average using IntStream is : "+((avg.isPresent())?avg.getAsDouble():0));
    }
}
