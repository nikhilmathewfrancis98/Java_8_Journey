package StreamApiS;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SecondHighestNumber {
    public static void main(String[] args) {
//        List<Integer> num= Arrays.asList(1,2,3,4,5,6,7,8);
//      int result=  num.stream() // Logic 1
//                .sorted(Collections.reverseOrder(Integer::compareTo))
//                .
//                collect(Collectors.toList()).get(1);
//
//        System.out.println(result);
        // If the i/p is array
//        int[]arr={1,2,3,4,5,6,7,8}; // Logic 1
//        int result=  Arrays.stream(arr).boxed()
//                .sorted(Collections.reverseOrder())
//                .
//                collect(Collectors.toList()).get(1);
//        System.out.println(result);

//        int[]arr={1,2,3,4,5,6,7,8};
//        int result=  Arrays.stream(arr).boxed() // Logic 2
//                .sorted(Collections.reverseOrder())
//                        .skip(1).findFirst().get();
//
//        System.out.println(result);

    // Second Lowest Number
        int[]arr={1,2,3,4,5,6,7,8};
        int result=  Arrays.stream(arr).boxed() // Logic 2
                .sorted()
                .skip(1).findFirst().get();

        System.out.println(result);
    }
}
