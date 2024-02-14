package Com.Java8_FunctionalProgramming.Stream.TerminalMethods;

import Com.Java8_FunctionalProgramming.Consumer.StudentDatabaseModel;
import Com.Java8_FunctionalProgramming.Consumer.StudentModel;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * In this example we are going to see the example of MinBy and Maxby using the collect
 * This is the part of the terminal operation in Stream pipeline
 * Takes in the instance of the Comparator
 */

class C{
    public static int Comparing(StudentModel o1, StudentModel o2){
        return (o1.getGpa()>o2.getGpa())?1:-1;
        // I tried to use generic here,but unfortunately it didn't work
    }
}
public class Maxby_MinBy {

    static Comparator<StudentModel> studentModelComparator=C::Comparing; // or ((o1,o2)->(o1.getGpa()>o2.getGpa())?1:-1)
    private static Optional<StudentModel> getHighestGPAMaxBy(){
        return StudentDatabaseModel.getAllStudents()
                .stream()
                .collect(Collectors.maxBy(studentModelComparator)); // or .collect(Collectors.maxBy(Comparator.comparing(StudentModel::getGpa)));
    }
    private static Optional<StudentModel> getLowestGPAMinBy(){
        return StudentDatabaseModel.getAllStudents()
                .stream()
                .collect(Collectors.minBy(Comparator.comparing(StudentModel::getGpa))); // or .collect(Collectors.maxBy(Comparator.comparing(StudentModel::getGpa)));
    }
    public static void main(String[] args) {
        System.out.println((getHighestGPAMaxBy().isPresent())?getHighestGPAMaxBy().get():"No such student");
        System.out.println((getLowestGPAMinBy().isPresent())?getLowestGPAMinBy().get():" No such values");
    }
}
