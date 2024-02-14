package Com.Java8_FunctionalProgramming.Stream;


import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *  In this example we are going to implement the factory methods such as
 *   1: of()
 *   2: iterate()
 *   3: generate()
 */

public class StreamFactoryMethods {

   static UnaryOperator<Integer> integerUnaryOperator=(integer)->integer*2; // gives the value*2 each time
    static Predicate<String> firstCha=(a)->a.charAt(0)=='N';
    public static void main(String[] args) {
//        Stream<String> stringStream=Stream.of("nik","math","franc","nagul"); // Now it's a stream
////        stringStream.forEach(System.out::println);
//       List<String> list= stringStream.map(x->x.toUpperCase()).peek(System.out::println).filter(firstCha).collect(Collectors.toList());
//        System.out.println(list);

//        Iterate method -> it's an infinite loop that gives the infinite value
        Stream.iterate(1,integerUnaryOperator).
                limit(10).
                forEach(System.out::println); // it gives upto integer max value so we can add limit()

//        generate() also gives a infinit values takes in a supplier fn
//        Supplier<Integer> integerSupplier= new Random()::nextInt;
//        Stream.generate(integerSupplier).limit(10).forEach(System.out::println);

    }
}
