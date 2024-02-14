package Com.Java8_FunctionalProgramming.Stream.TerminalMethods;

import Com.Java8_FunctionalProgramming.Consumer.StudentDatabaseModel;
import Com.Java8_FunctionalProgramming.Consumer.StudentModel;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * mapping() collector applies a transformation fn first and then collects the daa in a collection
 */
public class MappingCollector {
    private static Function<StudentModel,StudentModel> f=(studentModel -> {
        studentModel.setName(studentModel.getName().toUpperCase());
        return studentModel;
    });
    private static List<StudentModel> mapping1(){
     return    StudentDatabaseModel.getAllStudents()
                .stream()
             .collect(mapping(f,toList()));
//                .collect(Collectors.mapping((x->f.apply(x.getName())),toList());
        // In this method we are just taking the Student instance and mapping the Uppercase version of the name and
//        Again mapping it and making the Student list
    }
    private static List<String> mapping2(){
        return    StudentDatabaseModel.getAllStudents()
                .stream()
                .collect(mapping(StudentModel::getName,toList()));

    }
    public static void main(String[] args) {
        mapping1().forEach(System.out::println);
        mapping2().forEach(System.out::println);
        System.out.println("Collecting the values in a set : ");
       Set<String> studentSet= StudentDatabaseModel.getAllStudents()
                .stream()
                .collect(Collectors.mapping(StudentModel::getName,toSet()));
        System.out.println(studentSet);
    }
}
