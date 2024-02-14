package StreamApiS;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UniqueAndRepeatingElements {
    public static void main(String[] args) {
//        List<Integer> s= Arrays.asList(1,2,3,4,5,6,7,8,9);
////        Iterator i=s.iterator();
////        while (i.hasNext()){
////            System.out.println(i.next());
////        }
//        ListIterator i2=s.listIterator();
//        while(i2.hasPrevious()){
//            System.out.println("mmmm");
//            System.out.println(i2.previous());
//        }

        String repeated="ilovethejavaguides";
       Map<String,Long>result= Arrays.stream(repeated.split(""))
                .collect(Collectors.groupingBy(
                        Function.identity(),Collectors.counting()
                ))
               .entrySet().stream()
               .filter(x->x.getValue()<=1) // x->x.getValue()>1 // for repeated values
               .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
//        System.out.println(result);
//        String repeated="ilovethejavaguides";
//       List<Map.Entry<String,List<String>>> result=Arrays.stream(repeated.split(""))
//                .collect(Collectors.groupingBy(s -> s,Collectors.mapping(s -> s,Collectors.toList())))// or simply give  groupingBy(s -> s))
//                .entrySet()
//                .stream()
//                .collect(Collectors.toList());
//        System.out.println(result);
//        String repeated="ilovethejavaguides";
//        List<String> result=Arrays.stream(repeated.split(""))
//                .collect(Collectors.groupingBy(s -> s,Collectors.counting()))// or simply give  groupingBy(s -> s))
//                .entrySet()
//                .stream().
//                filter(x->x.getValue()<=1)
//                .map(x->x.getKey())
//                .collect(Collectors.toList());
//        System.out.println(result);

        List<Integer> x=Arrays.asList(1,2,1,3,2,3,4,5,6,5,7,6,7);
       Map.Entry v= x.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream()
                .filter(a->a.getValue()<=1)
                .collect(Collectors.toList()).get(0);
        System.out.println(v.getKey());
    }
}
