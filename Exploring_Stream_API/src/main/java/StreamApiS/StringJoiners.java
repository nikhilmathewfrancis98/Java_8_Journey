package StreamApiS;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * String joiners are the new feature added to the java 8
 * Where we can join the strings with delimiter and prefix and sufix
 * Also join the String elements in the array
 */
public class StringJoiners {
    public static void main(String[] args) {
        String[]arr={"Bus","is","so","cool"};
        StringJoiner j1=new StringJoiner(",","[","]");
        StringJoiner j2=new StringJoiner(",","[","]");
        System.out.println(j1); //o/p []
        j1.add("Apple");
        j1.add("Orange");
        j1.add("Grape");
        System.out.println(j1);
        for (String s:arr) {
            j2.add(s);
        }
        System.out.println(j2);

        // We can add a default value if there is no value
        StringJoiner j3=new StringJoiner(",","[","]");
        j3.setEmptyValue("Default"); // now [] won't show up
        System.out.println(j3);

        // merge 2 String joiner so that the middle prefix of second one won't show up
        j1.merge(j2);
        System.out.println(j1);
        // using the Stream Api
       String result= Arrays.stream(arr)
                .collect(Collectors.joining(",","[","]"));
        System.out.println(result);

        String s=String.join("-",arr);
        System.out.println(s);
    }
}
