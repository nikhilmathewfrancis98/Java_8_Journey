package Com.Java8_FunctionalProgramming.Stream.TerminalMethods;

import Com.Java8_FunctionalProgramming.Consumer.StudentDatabaseModel;
import Com.Java8_FunctionalProgramming.Consumer.StudentModel;

import java.util.stream.Collectors;

/**
 * This is the example that concatenates  all the Student names into 1 string and returns
 * 3 versions of Joining can be seen here
 *
 */
public class Example1Joining {
    private static String joining_1(){
      return  StudentDatabaseModel.getAllStudents()
                .stream()
                .map(StudentModel::getName)
                .collect(Collectors.joining());
    }
    private static String joining_2(){
        return  StudentDatabaseModel.getAllStudents()
                .stream()
                .map(StudentModel::getName)
                .collect(Collectors.joining(" -//- "));
    }
    private static String joining_3(){
        return  StudentDatabaseModel.getAllStudents()
                .stream()
                .map(StudentModel::getName)
                .collect(Collectors.joining(" - ","(",")"));
    }
    public static void main(String[] args) {
        System.out.println("Students name w.r.t joining() : "+joining_1());
        System.out.println("Students name w.r.t joining(With delimiter) : "+joining_2());
        System.out.println("Students name w.r.t joining(With delimiter and prefix and suffix) : "+joining_3());

    }
}
