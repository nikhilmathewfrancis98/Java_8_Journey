package Com.Java8_FunctionalProgramming.Stream.TerminalMethods;

import Com.Java8_FunctionalProgramming.Consumer.StudentDatabaseModel;
import Com.Java8_FunctionalProgramming.Consumer.StudentModel;

import java.util.stream.Collectors;

/**
 *  In this example we are going to see through the examples of averagingInt and SummingInt
 *  Using Collect method
 *  averagingInt -> return avg as result we can have int double etc
 *  SummingInt -> return sum as result here also int, double etc
 */
public class SummingIntAveragingInt {
    private static int SummingInt(){
        return StudentDatabaseModel.getAllStudents()
                .stream()
                .collect(Collectors.summingInt(StudentModel::getNoteBooks));
    }
    private static double AveragingInt(){
        return StudentDatabaseModel.getAllStudents()
                .stream()
                .collect(Collectors.averagingInt(StudentModel::getNoteBooks));
    }
    public static void main(String[] args) {
        System.out.println("Total no of Notebooks whole students have:  "+SummingInt());
        System.out.println("The average no of NoteBooks : " +AveragingInt());
    }
}
