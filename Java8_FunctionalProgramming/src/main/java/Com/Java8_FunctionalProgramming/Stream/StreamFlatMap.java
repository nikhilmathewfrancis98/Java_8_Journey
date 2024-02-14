package Com.Java8_FunctionalProgramming.Stream;

import Com.Java8_FunctionalProgramming.Consumer.StudentDatabaseModel;
import Com.Java8_FunctionalProgramming.Consumer.StudentModel;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * flatMap()
 * Converts(Transforms) one type to another as like map()
 * In the context of stream where each element in the stream represents multiple elements
 * In this example we are going to print the activities which is already a list type as a list using stream
 * flatMap() => flat the list inside a stream or list into the stream element
 */
public class StreamFlatMap {
    static Function<StudentModel,List<String>> getActivities=((student)->student.getActivities());
    public static void main(String[] args) {
        System.out.println(getActivityAsList());
    }

    private static List<String> getActivityAsList() {
        List<List<String>> StudentList= StudentDatabaseModel.getAllStudents().stream()
                .map(getActivities) // type= Stream<List<String>> which cannot be returned
                .collect(Collectors.toList()); // Type = List<List<String>>
//         So the above type cannot be returned from this method here comes flatMap as the saviour
       List<String> result= StudentDatabaseModel.getAllStudents().stream(). // Stream<Students>
                map(StudentModel::getActivities) // Stream<List<String>>  basically here we need to convert this type into Stream<String>
                .flatMap(List::stream) // here we can use Set::stream w.r.t our Scenario,  Flatten the stream to one type Stream<String>
               .distinct() // will print the distinct values
               .collect(Collectors.toList());
        return result;
    }
}
