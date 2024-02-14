package StreamApiS.SomeCodingQues;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Find the duplicate elements in an array
 */
public class FindDuplicateElements {
    public static void main(String[] args) {
        int[] inputArray = new int[] {111, 333, 555, 777, 333, 444, 555};
//        Arrays.stream(inputArray)
//                .boxed()
//                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet()
//                .stream().filter(x->x.getValue()>1)
//                .map(Map.Entry::getKey)
//                .collect(Collectors.toList()).forEach(System.out::println);

//        Or
        Set<Integer> uniqueElements = new HashSet<>();

        Arrays.stream(inputArray)
                .filter(i -> !uniqueElements.add(i)) // add mathod of set returns bool w.r.t the elements presence
                .boxed()
                .collect(Collectors.toList()).forEach(System.out::println);
    }
}
