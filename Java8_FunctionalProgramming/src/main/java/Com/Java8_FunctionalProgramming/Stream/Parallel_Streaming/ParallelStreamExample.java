package Com.Java8_FunctionalProgramming.Stream.Parallel_Streaming;

import java.util.function.Supplier;
import java.util.stream.IntStream;

/**
 * In this example we are creating 2 method one with parallel processing and sequential processing
 * So in here we are going to calculate the time took to complete the task if both called 20 times or more w.r.t our o/p
 * So we have a new method that takes the both methods of parallel and sequential
 * So the new method will be  taking the supplier and we are going to refer both the methods to it
 * Note using method reference we are trying to pass a method to function
 *
 */
interface X{
   public int Call();
}
public class ParallelStreamExample {
//    private static long checkThePerformance(Callable<Integer> theFn, int numberOfTimes) throws Exception {
//        long statTime=System.currentTimeMillis();
//        for (int i=0;i<numberOfTimes;i++) {
//            theFn.call();
//        }
//        long endTime=System.currentTimeMillis();
//        return endTime-statTime;
//    }
public static long checkThePerformance(X x, int numberOfTimes)  { //Supplier<Integer> theFn
    long statTime=System.currentTimeMillis();
    for (int i=0;i<numberOfTimes;i++) {
//        theFn.get();
        x.Call();
    }
    long endTime=System.currentTimeMillis();
    return endTime-statTime;
}

     static int sumSequentialStream(){
        return IntStream.rangeClosed(1,10000)
                .sum();
    }
     static int sumParallelStream(){
        return IntStream.rangeClosed(1,10000)
                .parallel() //  Here the range is divided into many parallel multiple parts and then do the sum concurrently
                .sum();
    }
    public static void main(String[] args) throws Exception {
//        System.out.println(sumSequentialStream()); // Both gives same result but who performs better?
//        System.out.println(sumParallelStream());
        System.out.println(Runtime.getRuntime().availableProcessors()); // Gives the available processors that a s/m has which helps in running threads
        System.out.println("=============Time Took For Each Function=====================");
//        Callable<Integer> integerCallable1=ParallelStreamExample::sum_Sequential_Stream;
//        Callable<Integer> integerCallable2=ParallelStreamExample::sumParallelStream;
//        integerCallable2.call();
        //  System.out.println("Sequential Stream: "+checkThePerformance(()-> IntStream.rangeClosed(1,10000).sum()
        //        ,20));
        System.out.println("Sequential Stream: "+checkThePerformance(ParallelStreamExample::sumSequentialStream,20));
        System.out.println("Parallel Stream: "+checkThePerformance(ParallelStreamExample::sumParallelStream,20));
    }
}
