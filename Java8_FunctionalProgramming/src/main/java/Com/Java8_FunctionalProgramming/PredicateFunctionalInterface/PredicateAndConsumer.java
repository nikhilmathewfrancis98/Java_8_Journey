package Com.Java8_FunctionalProgramming.PredicateFunctionalInterface;

import Com.Java8_FunctionalProgramming.Consumer.StudentDatabaseModel;
import Com.Java8_FunctionalProgramming.Consumer.StudentModel;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * In this example we are trying to combine the Predicate and the Consumer interfaces
 */
public class PredicateAndConsumer {

    Predicate<StudentModel> studentModelPredicate=student->student.getGradeLevel()>=3&&student.getGpa()>=3.9; // Note that the GPA can be filtered using separate predicate instance
    BiConsumer<String, List<String>>  biConsumer=(name,activities)-> System.out.println(name+" : "+activities);
    Consumer<StudentModel> studentModelConsumer=(student)->{
        if (studentModelPredicate.test(student))
                biConsumer.accept(student.getName(),student.getActivities());
    };
    public void printNameAndActivities(List<StudentModel> studentModels){
        studentModels.forEach(studentModelConsumer);
    }
    public static void main(String[] args) {
        new PredicateAndConsumer().printNameAndActivities(StudentDatabaseModel.getAllStudents());
    }
}
