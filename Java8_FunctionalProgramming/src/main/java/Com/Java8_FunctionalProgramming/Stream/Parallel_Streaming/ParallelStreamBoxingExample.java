package Com.Java8_FunctionalProgramming.Stream.Parallel_Streaming;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *  In this eg we are going to see through the use case like when not to use the parallel stream
 * In the below example we can see that the sequential-duration< parallel-duration
 * Its becoz the Integer to int ie, the unboxing takes time when it comes to parallel since the whole stream is divided in parts
 */
public class ParallelStreamBoxingExample {
    public static int parallelSum(List<Integer> list){
        long startTime=System.currentTimeMillis();
        int sum= list.parallelStream()
                .reduce(0,(x,y)->x+y); // the wrapper is unboxed to primitive so here it will take more time since we are having multiple parts of this
        long endTime=System.currentTimeMillis();
        System.out.println("Duration in Parallel Stream: "+(endTime-startTime));
        return sum;
    }
    public static int sequentialSum(@org.jetbrains.annotations.NotNull List<Integer> list){
        long startTime=System.currentTimeMillis();
       int sum= list.stream()
                .reduce(0,(x,y)->x+y); // the wrapper is unboxed to primitive
        long endTime=System.currentTimeMillis();
        System.out.println("Duration in Sequential Stream: "+(endTime-startTime));
        return sum;
    }
    public static void main(String[] args) {
       List<Integer> li= IntStream.rangeClosed(1,1000)
                .boxed() // Here the primitive is converted to Wrapper
                .collect(Collectors.toList());
       sequentialSum(li);
       parallelSum(li);
    }
}
