package Com.Java8_FunctionalProgramming.Stream.TerminalMethods;

import Com.Java8_FunctionalProgramming.Consumer.StudentDatabaseModel;
import Com.Java8_FunctionalProgramming.Consumer.StudentModel;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import static Com.Java8_FunctionalProgramming.Consumer.StudentDatabaseModel.listSupplier;
import static java.util.stream.Collectors.*;

/**
 *  In this example we are trying to go through the 3rd version of the groupingBy(classifier,Supplier,downstream)
 */
public class GroupingByExample3 {
    private static Map<String, Set<StudentModel>> threeLeveGrouping(){ // If we see the mapping() of 2 params its internally calling the hashMap::new supplier her we are going to override it
       return StudentDatabaseModel.getAllStudents()
                .stream()
                .collect(groupingBy(StudentModel::getName, LinkedHashMap::new,toSet()));
        // here 1st arg=the key we are grouping w.r.t, 2nd arg= the output, 3rd arg= the value of the output -( the downstream)
    }
    public static void main(String[] args) {
        System.out.println(threeLeveGrouping());
    }
}
