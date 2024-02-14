package Com.Java8_FunctionalProgramming.Stream;

import java.util.*;
import java.util.stream.Collectors;

public class StreamMin_Max {
    public static void main(String[] args) {
        List<Integer> li= Arrays.asList(1,5,78,4,34,77);
//        System.out.println(getTheMaxValue(li).get());

        /**
         * Min operation of a list of integers
         */
//        System.out.println(findMinValue(li).get());
      //Optional <Integer> s= li.stream().max(Comparator.naturalOrder());
//        System.out.println(li.stream().collect(Collectors.maxBy(Comparator.naturalOrder())).get());
//        System.out.println(li.stream().collect(Collections.max(Comparator.naturalOrder())).get()); // error

//        System.out.println(s.get());
    }

    private static Optional<Integer> findMinValue(List<Integer> li) {
//        li.stream().reduce(Integer::min); // Returns an integer value
        return li.stream()
                .reduce((a,b)->a<b?a:b); // if identity is present it will get returned  .reduce(0,(a,b)->a<b?a:b);
    }

    private static Optional<Integer> getTheMaxValue(List<Integer> li) {
        return li.stream()
                //1 -> y
                //5 -> y
                //78 -> y
                //4 -> y
                //34 -> y
                //77 -> y
                //x value will get replaced with the recent max value
                .reduce((x,y)->x>y?x:y); // this is also valid .reduce(0,(x,y)->x>y?x:y); // also valid but if we pass null array it will give 0 as max value which is the default
//                .reduce(Integer::max);
    }
}
