package StreamApiS;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatingElement {
    public static void main(String[] args) {
//        String repeated="abcdadff";
        String repeated="abcbdcadf";

//       List<Map.Entry<String,Long>> result= Arrays.stream(repeated.split(""))
//                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
//                .entrySet()
//                .stream()
//                .filter(x->x.getValue()==1)
//                        .collect(Collectors.toList());
//        System.out.println(result);
//        Map.Entry<String,Long> result= Arrays.stream(repeated.split(""))
//                // In the below code we can give Treemap but it gives d=1 as o/p coz it maintains the insertion as default(ascending)
//                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new ,Collectors.counting()))
//                .entrySet()
//                .stream()
//                .filter(x->x.getValue()==1)
//                .findFirst()
//                .get();
//        System.out.println(result.getKey());


      new FirstNonRepeatingElement().getTheIndex(repeated);

//        System.out.println(result1);
    }
    public void getTheIndex(String repeated){
        int index=0;
      Map<String,Long> res=Arrays.stream(repeated.split(""))
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting())).
//                forEach((s, count) -> System.out.println(s+" "+count));
        entrySet()
                .stream().
                collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));

        for (Map.Entry x: res.entrySet()) {
            String val= (String) x.getKey();
            if ((Long)x.getValue()==1){
             index=   repeated.indexOf((String) x.getKey());
                break;
            }

        }
        System.out.println(index);
    }
}
