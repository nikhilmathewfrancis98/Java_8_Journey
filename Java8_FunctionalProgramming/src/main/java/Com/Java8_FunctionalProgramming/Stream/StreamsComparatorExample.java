package Com.Java8_FunctionalProgramming.Stream;

import Com.Java8_FunctionalProgramming.Consumer.StudentDatabaseModel;
import Com.Java8_FunctionalProgramming.Consumer.StudentModel;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * In this example we are going to sort the student database w.r.t name Using the Comparator Interface
 */
public class StreamsComparatorExample {
    static Comparator<StudentModel> studentModelComparator=(thisOne,thatOne)->{
        if (thisOne.getName().charAt(0)>thatOne.getName().charAt(0))
            return 1;
        else
            return -1;
    };
    public static void main(String[] args) {
//        List<StudentModel> list= StudentDatabaseModel.getAllStudents();
//
//        /**
//         * Sorting the student w.r.t name
//         */
//        list.sort(studentModelComparator::compare); // Literally sort method takes in the instance of the Comparator interface
//        list.forEach(System.out::println);
//        // We can do this in a better way as stream provide 2 sorted() 1: we already do 2: sorted(Comparator instance) takes this instance
//
////        list.stream().sorted(studentModelComparator).collect(Collectors.toList()); // Giving our Comparator instance
//        System.out.println(list.stream().sorted(Comparator.comparing(StudentModel::getName)).collect(Collectors.toList()));
//
//        // Print the Students w.r.t the gpa and in descending order , many other methods for Comparator interface
//        System.out.println("Students with Highest gpa are : \n");
//        list.stream().sorted(Comparator.comparing(StudentModel::getGpa).reversed()).collect(Collectors.toList())
//                .forEach(System.out::println);

        // Finding the maximum element
        List<String> names= Arrays.asList("Bananaa","oran","sotato","Suppotta","grape");
       names= names.stream().map(String::toLowerCase).sorted(Comparator.comparing(String::length).reversed())
               .collect(Collectors.toList());
        System.out.println(names.get(names.size()-1));
      List <String> peekedVal= names.stream().peek(x->x.toString()).collect(Collectors.toList());
        System.out.println(peekedVal);
//        String maxName=Collections.max(names);
//        System.out.println(maxName);
    }
}
