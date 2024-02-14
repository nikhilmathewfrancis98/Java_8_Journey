package Com.Java8_FunctionalProgramming.Stream.TerminalMethods;

import Com.Java8_FunctionalProgramming.Consumer.StudentDatabaseModel;

import java.util.stream.Collectors;

/**
 * Counting Terminal operation
 * Used inside collect
 */
public class CountingTerminalOperation {
    private static long Count(){
        return StudentDatabaseModel.getAllStudents()
                .stream()
//                .filter(x->x.getGpa()>=3.9)
                .collect(Collectors.counting());
        // here after stream we can call count directly
    }
    public static void main(String[] args) {
        System.out.println(Count());
    }
}
