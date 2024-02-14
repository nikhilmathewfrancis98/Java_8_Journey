package Com.Java8_FunctionalProgramming.PredicateFunctionalInterface;

import Com.Java8_FunctionalProgramming.Consumer.StudentDatabaseModel;
import Com.Java8_FunctionalProgramming.Consumer.StudentModel;

import java.util.List;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * This is the example for the predicate interface
 */
public class PredicateFInterface {
    static Predicate<Integer> checkingOddOrNot=num->(num%2==0);
    static Predicate<Integer> integerEvenOrNot=num->num%5==0;

//    Predicate for the student db
  public static Predicate<StudentModel> studentModelPredicate=(student)->student.getGradeLevel()>=3; // Returns true if the grade is greater than 3
   public static Predicate<StudentModel> studentflter=(student)->student.getGpa()>=3.9;
    static BiConsumer<String, List<String>> studentModelBiConsumer=(name,activities)-> System.out.println(name+" : "+activities);
    // The And method returns true iff both the return type is true
    public static void predicateAnd(){
        System.out.println("Predicate And result is : "+integerEvenOrNot.and(checkingOddOrNot).test(10)); // predicate chaining
        System.out.println("Predicate And result is : "+integerEvenOrNot.and(checkingOddOrNot).test(9)); // predicate chaining

    }

    public static void predicateOr(){
        System.out.println("Predicate And result is : "+integerEvenOrNot.or(checkingOddOrNot).test(10)); // predicate chaining
        System.out.println("Predicate And result is : "+integerEvenOrNot.or(checkingOddOrNot).test(8)); // predicate chaining
        System.out.println("Predicate And result is : "+integerEvenOrNot.or(checkingOddOrNot).test(9)); // predicate chaining

    }

    public static void predicateNegate(){
        System.out.println("Predicate And result is : "+integerEvenOrNot.or(checkingOddOrNot).negate().test(10)); // predicate chaining
        System.out.println("Predicate And result is : "+integerEvenOrNot.or(checkingOddOrNot).negate().test(8)); // predicate chaining
        System.out.println("Predicate And result is : "+integerEvenOrNot.or(checkingOddOrNot).negate().test(9)); // predicate chaining

        System.out.println("Predicate And result is : "+integerEvenOrNot.and(checkingOddOrNot).negate().test(10)); // predicate chaining
        System.out.println("Predicate And result is : "+integerEvenOrNot.and(checkingOddOrNot).negate().test(9)); // predicate chaining

    }

    public static void filterStudentsByGradeLevel(){
        StudentDatabaseModel.getAllStudents().forEach(x->{
//            if (studentModelPredicate.test(x))
//                studentModelBiConsumer.accept(x.getName(),x.getActivities()); // Both this and the below code will print the same thing
            if (studentModelPredicate.test(x))
                System.out.println(x);
        });
    } // Like this we can create the gpa condition also

    public static void filterStudent(){
        StudentDatabaseModel.getAllStudents().forEach(x->{
            // In the below code we can use the or and negate method w.r.t our business logic
            if(studentModelPredicate.and(studentflter).test(x))
                System.out.println(x);
        });
        }
    public static void main(String[] args) {

        System.out.println(integerEvenOrNot.test(8));
//        System.out.println(checkingOddOrNot.test(5));

        /**
         * Using Negate, and, or ect of the predicate interface
         */

//        predicateAnd();
//    predicateOr();
//        predicateNegate();

        /**
         * Using the predicate for the Student Database eg
         */
//        filterStudentsByGradeLevel();
//        filterStudent();
    }

}
