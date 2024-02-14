package StreamApiS;

//import com.sun.org.apache.xpath.internal.operations.String;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * In this eq we are trying to print the elements starts with 1
 */
public class PrintElementsStartsWith {
    static Function<String, String> fn= (x)->new String(x);
    public static void main(String[] args) {
        int[]num={21,1,11,56,72,71,101};
        Arrays.stream(num)
                // or (x-> fn.apply(Integer.toString(x))
                // or i can use map(x->x + "") //
                .mapToObj(x->Integer.toString(x))
                .filter(x->x.startsWith("1"))
                .mapToInt(Integer::new)
                .boxed()
                .collect(Collectors.toList()).forEach(System.out::println);
    }
}
