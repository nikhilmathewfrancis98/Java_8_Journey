package Com.Java8_FunctionalProgramming.Stream;

//import com.sun.org.apache.xpath.internal.operations.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * As we have seen mapToInt()
 * There is 2: mapToObject -> convert intStream to other ObjectStream
 *          3: mapToLong() -> convert intStream to LongStream
 *          4: mapToDouble() -> convert intStream to DoubleStream
 */

class Bridge{
    public static  String setValue(String val){
        return new String(val);
    };
}
public class NumericStreamMapTo {
//   public static Supplier<List> supplier=() ->  new ArrayList<>();
    static Function<String, String> f=Bridge::setValue;
//    static  Function<String,String> f2=(s)->new String(Integer.toString(Integer.parseInt(s)));
  private static List<Integer> mapToObject(){
     List<Integer> integers= IntStream.rangeClosed(1,10) // IntStream 10 elements
              .mapToObj(value -> new Integer(value)) // new Integer() can be any Custom Object with input value is integer .mapToObj takes an intFunction where intFunction is an SAM that has an apply(takes in value) return R
             .collect(Collectors.toList());
      return integers;
    }
    private static List<Long> mapToLong(){
       List<Long> lng=IntStream.rangeClosed(1,10).          // IntStream 10 elements
                  mapToLong(value -> value)                  // returns a LongStream
               .boxed().
               collect(Collectors.toCollection(ArrayList::new));
//               collect(Collectors.toList());
        return lng;
    }
    private static Double mapToDouble(){

        return IntStream.rangeClosed(1,10) // IntStream 10 elements
                .mapToDouble(value -> value) // returns a LongStream
                .sum();
    }

    public static void main(String[] args) {
//        System.out.println(mapToObject());
        // In the below example we just tried to convert the integer list to string object using mapToObject() of steam and we used constructor reference since the new String() didn't work
//        List<Integer> li= Arrays.asList(1,2,3);
//        li.stream().mapToInt(Integer::intValue).
//                mapToObj(value->f.apply(Integer.toString(value))).
//                peek(x-> System.out.println(x.getClass().getSimpleName()))
//                .collect(Collectors.toList()).forEach(System.out::println);
        // Or this both returns the same o/p
//        li.stream().mapToInt(Integer::intValue).
//                mapToObj(x->Integer.toString(x)).
//                peek(x-> System.out.println(x.getClass().getSimpleName()))
//                .collect(Collectors.toList()).forEach(System.out::println);
//        System.out.println(mapToLong());
//        System.out.println(mapToDouble());

       List<Integer> list= Arrays.asList(4,5,6,7,8,9);
//        IntStream stream =list.stream().mapToInt(Integer::intValue);
//        System.out.println(stream.boxed().collect(Collectors.toList()));
//
       List<String>list1= list.stream().mapToInt(Integer::intValue)
                .mapToObj(x->f.apply(Integer.toString(x))).collect(Collectors.toList());

        list1.forEach(x-> System.out.println(x.getClass()));
    }
}
