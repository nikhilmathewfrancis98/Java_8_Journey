package Com.Java8_FunctionalProgramming.Stream;

import Com.Java8_FunctionalProgramming.Consumer.StudentDatabaseModel;
import Com.Java8_FunctionalProgramming.Consumer.StudentModel;

//import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * In this example we are going to take the student and do some filtering using Stream API
 * Getting the student details and map the name and activities into a map
 */
public class StreamExample {
    static Predicate<StudentModel> studentGPA=((s)->s.getGpa()>=3.9);
    static Predicate<StudentModel> studentGradeLevel=(student->student.getGradeLevel()>=3);
    static Function<StudentModel, String> functionToGetName=(student)->{
        return  student.getName();
    };
    static Function<StudentModel, List<String>> functionToGetActivities=(student)->{
        return  student.getActivities();
    };
    public static void main(String[] args) {
      Stream<StudentModel> stream1= StudentDatabaseModel.getAllStudents().stream();
//      List<StudentModel> list=StudentDatabaseModel.getAllStudents();
//      Map<String,List<String>>result= stream1.collect(Collectors.toMap(functionToGetName::apply,functionToGetActivities));

//        Collecting to the map using the reference method another way
// Since I'm getting all the values and I have the connection and the constructor (instance) of student class
//        I can do the below code to get the name and activities for the map
//     Map<String,List<String>>result= stream1.collect(Collectors.toMap(StudentModel::getName,StudentModel::getActivities));

        Map<String,List<String>>result= stream1.
                filter(studentGradeLevel::test).
        peek(System.out::println). // This will print the streams after first filter debugging inside the stream
                filter(studentGPA). // reason why filter takes predicate because w.r.t the boolean it filters, until this the return type is Stream
                collect(Collectors.toMap(StudentModel::getName,StudentModel::getActivities));





        for (Map.Entry<String,List<String>> mapElement : result.entrySet()) {
            String key = mapElement.getKey();
            List<String> value = mapElement.getValue();
            System.out.println(key + " : " + value);
        }

    }
}
