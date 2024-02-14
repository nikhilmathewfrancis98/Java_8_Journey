package StreamApiS;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class FindLonestString {
    public static void main(String[] args) {
        String[]arr={"Apple","Orange","Grape","Ramboottan"};
//      String result=  Arrays.stream(arr) // Logic 1
//                .max(String::compareTo).get();
          // Logic 2
//                 String result=Collections.max(Arrays.stream(arr).collect(Collectors.toList()));
                 // Logic 3
//      String result=  Arrays.stream(arr) // Logic 3
//                .collect(Collectors.maxBy(String::compareTo)).get();
//        Logic 4
//        String result=  Arrays.stream(arr) // Logic 4
//                .reduce((x,y)->x.length()>y.length()?x:y).get();
//        Logic 5

        String result=  Arrays.stream(arr) // Logic 4
                .sorted(Collections.reverseOrder())
                .findFirst().get();
        System.out.println(result);
    }
}
