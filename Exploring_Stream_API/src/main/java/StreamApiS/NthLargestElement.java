package StreamApiS;

import javax.swing.*;
import javax.swing.text.html.parser.Entity;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NthLargestElement {
    public static void main(String[] args) {
//        Getting the nth largest salary
        // eg, 2nd largest
        Map<String,Integer> emp1=new HashMap<>(); // Dataset 1
        emp1.put("Nikhil",1400);
        emp1.put("Mathew",1200);
        emp1.put("Francis",1600); // output
        emp1.put("Sonu",1700);
        emp1.put("Balu",1100);
        emp1.put("Gopu",1300);

        Map<String,Integer> emp2=new HashMap<>(); // Dataset 2
        emp2.put("Nikhil",1400);
        emp2.put("Mathew",1600);
        emp2.put("Francis",1600); // output
        emp2.put("Sonu",1700);
        emp2.put("Balu",1400);
        emp2.put("Gopu",1700);
//        new NthLargestElement().getNthLargest(emp1,2);
        new NthLargestElement().getNthLargest(emp1,2);

    }
    public  void getNthLargest(Map<String,Integer> emp,int nth){
        // UseCase1 but dataSet 2 will give wrong o/p for this logic
//       Map.Entry<String,Integer> result= emp.entrySet().stream().
//                sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
//                .collect(Collectors.toList()).get(nth-1);
//        System.out.println(result);
//        for (Map.Entry<String, Integer> x:result) {
//            System.out.println(x.getKey()+" "+x.getValue());
//        }
//        System.out.println();
//        System.out.println(result.get(nth));
        // Logic for dataSet 2 and 1 also
//             Debugging Level1:   emp.entrySet().stream()
//                .collect(Collectors.groupingBy(Map.Entry::getValue)).
//               forEach((integer, entries) -> System.out.println(integer+" "+entries));
//         Debugging 2:
//        Map.Entry<Integer,List<Map.Entry<String,Integer>>> result=emp.entrySet().stream()
//                .collect(Collectors.groupingBy(Map.Entry::getValue));
//        Debugging 3:
//          Map.Entry<Integer,List<String>> result= emp.entrySet().stream()
//                .collect(Collectors.groupingBy(Map.Entry::getValue, // The below line will return Map<Integer,List<String>>
//                        Collectors.mapping(Map.Entry::getKey,Collectors.toList())))
//                .entrySet()
//                .stream().
//                sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
//                  .collect(Collectors.toList())
//                  .get(nth-1);
//        System.out.println(result);
//        Debugging 4
//      Map.Entry<Integer,List<Map.Entry<String,Integer>>> result= emp.entrySet().stream()
//              // Difference between the above and this code is we are grouping the above code with 2 conditions
//                .collect(Collectors.groupingBy(Map.Entry::getValue))
//                .entrySet()
//                .stream().
//                sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
//                .collect(Collectors.toList())
//                .get(nth - 1);
//        System.out.println(result);
        // Debugging 5 :
        Map.Entry<Integer,List<Map.Entry<String,Integer>>> result= emp.entrySet().stream()
                // Difference between the above and this code is we are grouping the above code with 2 conditions
                .collect(Collectors.groupingBy(Map.Entry::getValue))
                .entrySet()
                .stream().
                sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .max((o1, o2) -> o1.getKey()>o2.getKey()?o1.getKey():o2.getKey()).get();
        System.out.println(result);
    }
}
