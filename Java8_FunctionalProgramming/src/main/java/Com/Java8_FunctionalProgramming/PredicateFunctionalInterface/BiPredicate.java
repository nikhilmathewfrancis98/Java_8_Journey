package Com.Java8_FunctionalProgramming.PredicateFunctionalInterface;

import Com.Java8_FunctionalProgramming.Consumer.StudentDatabaseModel;
import Com.Java8_FunctionalProgramming.Consumer.StudentModel;

import java.util.List;
import java.util.function.BiConsumer;
//import java.util.function.Predicate;

/**
 * In this example we are trying to create a BiConsumer Instance
 * It takes 2 values of different types like the BiConsumer
 * Contains test,and,or,negate all in the Predicate
 * In the below example we have done the logic without the help of another Consumer
 * But in the previous eg we have a Consumer Instance
 */
public class BiPredicate {
    java.util.function.BiPredicate<Integer,Double> studentModelPredicate1=(gradeLevl, gpa)->gradeLevl>=3 && gpa>=3.9; // Note that the GPA can be filtered using separate predicate instance
    BiConsumer<String, List<String>> biConsumer=(name, activities)-> System.out.println(name+" : "+activities);
    public void PrintNameAndActivity(List<StudentModel> listStudents){
        listStudents.forEach(x->{
            if (studentModelPredicate1.test(x.getGradeLevel(),x.getGpa()))
                    biConsumer.accept(x.getName(),x.getActivities());
        });
    }
    public static void main(String[] args) {
        new BiPredicate().PrintNameAndActivity( StudentDatabaseModel.getAllStudents());
    }
}
