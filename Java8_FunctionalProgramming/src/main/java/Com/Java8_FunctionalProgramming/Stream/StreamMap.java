package Com.Java8_FunctionalProgramming.Stream;

import Com.Java8_FunctionalProgramming.Consumer.StudentDatabaseModel;
import Com.Java8_FunctionalProgramming.Consumer.StudentModel;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

/**
 * Exploring the map() of stream
 */
class FunctionDemo{
    public static String returnName(StudentModel studentModel){
            return studentModel.getName();
    }
}
public class StreamMap {
//   static Function<StudentModel,String> getName=(studentModel -> studentModel.getName());
//    static Function<StudentModel,String> getName=(student)->FunctionDemo.returnName(student);
static Function<StudentModel,String> getName=FunctionDemo::returnName;

   public static List<String> namesList(){
       Stream<StudentModel> streamStudent1= StudentDatabaseModel.getAllStudents().stream();
       //Without the Function Interface we are referring the student model getName method
//        List<String> StudentNames= streamStudent1.map(StudentModel::getName).collect(Collectors.toList());
       List<String> StudentNames= streamStudent1.map(getName::apply) // or StudentModel::getName // return type Stream<String>, give simply the getName
               .map(String::toUpperCase)// Stream<String> -> uppercase operation on each set of string values
               .collect(Collectors.toList());
       return StudentNames;
    }

    public static Set<String> namesSet(){
        Stream<StudentModel> streamStudent1= StudentDatabaseModel.getAllStudents().stream();
        //Without the Function Interface we are referring the student model getName method
//        List<String> StudentNames= streamStudent1.map(StudentModel::getName).collect(Collectors.toList());
        Set<String> StudentNames= streamStudent1.map(getName::apply)// or StudentModel::getName // return type Stream<String>, give simply the getName
                .map(String::toUpperCase)// Stream<String> -> uppercase operation on each set of string values
                .collect(toSet());
        return StudentNames;
    }
    public static void main(String[] args) {

        for(String name:namesList())
            System.out.println(name);

        System.out.println(namesSet());
    }
}
