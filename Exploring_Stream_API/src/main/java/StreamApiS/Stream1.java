package StreamApiS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// In this eg we are going to explore the foreach and the Consumer interface
public class Stream1 {
    public static void main(String[] args) {
        List<Integer> s1= new ArrayList(Arrays.asList(4,5,8,2,9,6,7,8,6,1,2));
//        We can print the above array as following types:
        // 1: Normal for loop
//                for (Integer x: s1){
//                    System.out.println(x);
//                }
        // 2: Since consumer is an interface which is functional we can use the anonymous class and the lambda

//                    Consumer<Integer> con1=(x)-> System.out.println(x); // Here we can have any Business logic
//                    s1.forEach(con1); // This foreach can take the consumer object also
                //   Also we can directly use the foreach loop without using the Consumer
//                    s1.forEach(x->System.out.println(x));

        //  3: Using the Stream Api
        System.out.println(s1.stream().distinct().collect(Collectors.toList()));
       Stream<Integer> stream1= s1.stream(); // This will return a stream and stream cannot be accessed twice can raise a runtime error
       Stream<Integer> stream2=stream1.filter(x->x%2==0); // Convert to list then convert to stream
       Stream<Integer> stream3=stream2.map(x->x*2);
//        Iterator<Integer> iterator=stream3.iterator();
//        iterator.forEachRemaining(x->System.out.println(x));
       stream3.collect(Collectors.toList()).forEach(System.out::println);

//       int stream4=stream3.reduce(0,(x,y)->x+y); // reducer always give an integer value // If i uncomment this line it can throw
//        Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
//        at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:229)
//        at java.util.stream.ReferencePipeline.reduce(ReferencePipeline.java:474)
//        at StreamApiS.Stream1.main(Stream1.java:36)  // Error because the stream cannot be accessed twice

        List<String> c=new ArrayList<>(Arrays.asList("Nik","Math","Beth","Vasu","Ragavan","Sarala","Sarasu","Thangamma","Thangappan"));
        c.stream().map(String::toLowerCase).filter(x -> x.startsWith("s")).sorted().forEach(System.out::println);

    }
}
