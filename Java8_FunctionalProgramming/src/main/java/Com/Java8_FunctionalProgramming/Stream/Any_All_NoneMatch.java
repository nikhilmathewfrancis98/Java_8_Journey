package Com.Java8_FunctionalProgramming.Stream;

import Com.Java8_FunctionalProgramming.Consumer.StudentDatabaseModel;

import java.util.Arrays;
import java.util.List;

import static Com.Java8_FunctionalProgramming.PredicateFunctionalInterface.PredicateFInterface.studentflter;

/**
 *  anyMatch(),allMatch(),noneMatch()
 *  Takes in predicate as an input and returns a Boolean as output
 *  anyMatch() -> true -> if any one of the element matches the predicate , else false
 *  allMatch() -> true -> if all the element in the stream matches the predicate, else false
 *  nonMatch() -> opposite to allMatch() -> true if none of the stream elements don't match the predicate, else false
 */
public class Any_All_NoneMatch {
    public static void main(String[] args) {
        // allMatch()
        System.out.println("Result for the All match : "+allMatchMethod());
        System.out.println("Result for the Any match : "+anyMatchMethod());
        System.out.println("Result for the None match : "+noneMatchMethod());
    }

    private static boolean noneMatchMethod() {
        return StudentDatabaseModel.getAllStudents()
                .stream()
                .noneMatch(x->x.getGpa()>4.0); // o/p -> true -> ie, if none of the students matches this condition it returns true, false if gpa>=4.0
    }

    private static boolean anyMatchMethod() {
        return StudentDatabaseModel.getAllStudents()
                .stream().anyMatch(studentflter); // every things work except iff gpa>4.0 // return false
    }

    private static boolean allMatchMethod() {
        return StudentDatabaseModel.getAllStudents().stream()
                .allMatch(x->x.getGpa()>=3.5); // here this should return true since all the instances in the list satisfies this condition
        //.allMatch(x->x.getGpa()>=3.9); // false since only 3 ppl satisfies this cond
    }
}
