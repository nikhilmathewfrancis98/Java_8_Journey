package Com.Java8_FunctionalProgramming.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * In this example we can create more examples using the methods like
 *  distinct() -> Return Stream with unique elements
 *  count() -> Return long type -> the total no of elements in the stream
 *  sorted() -> Return sort the elements in the stream
 *  Apply this in the student activity stream
 */
public class SomeMoreStreamMethods {
    static long getCount(List<Integer> li){
        return li.stream().count(); // long
    }
    public static void main(String[] args) {
        List<Integer> s1= new ArrayList(Arrays.asList(4,5,8,2,9,6,7,8,6,1,2,2,8,9,7,1,2,3,4,56,89,56));

        System.out.println(s1.stream().distinct().sorted(). // Stream with distinct -> the Stream with sorted
                collect(Collectors.toList()));
        System.out.println(getCount(s1));

    }
}
