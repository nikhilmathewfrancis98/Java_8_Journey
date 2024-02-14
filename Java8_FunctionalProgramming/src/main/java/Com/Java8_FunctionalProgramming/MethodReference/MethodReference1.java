package Com.Java8_FunctionalProgramming.MethodReference;

import Com.Java8_FunctionalProgramming.Consumer.StudentDatabaseModel;
import Com.Java8_FunctionalProgramming.Consumer.StudentModel;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Syntax ClassName::instance-MethodName
 *         ClassName::static-MethodName
 *         instance::methodName
 * Used to make the implementation of lambda and functional interface easy
 * We can use this for the lambda Exp referring to the method directly
 *   We can use this for the lambda Exp referring to the method directly
 *   And also we can refer method to other methods
 *   We cannot do reference method impl if the method has a condition type return value eg:
 *   Predicate<> p=()->(x.age>y.age)?true:false; here the w.r.t condition we get the value so referencing will not possible
 */
public class MethodReference1 {
    public static boolean greaterThanGradeLevel(StudentModel studentModel){
        return studentModel.getGradeLevel()>=3;
    }
    public static void main(String[] args) {
//         We can use this for the lambda Exp referring to the method directly eg;
        Function<String,String> toUpperCase=(str)->str.toUpperCase(); // String.toUpperCase() won't work coz toUpperCase is an instance method
        Function<String,String> toUpperCase2=String::toUpperCase; // We are referring the toUpperCase method of String class directly to the apply method of Function
        System.out.println(toUpperCase.apply("nikhil")+" "+toUpperCase2.apply("mathew"));

        /**
         * Using Consumer interface we are trying to implement the Method Reference
         * By taking the student database values
         * ClassName::methodName
         */

        Consumer<StudentModel> studentModelConsumer= System.out::println;
        StudentDatabaseModel.getAllStudents().forEach(studentModelConsumer);

//        Getting all the activities syntax ClassName::instanceMethod
        Consumer<StudentModel> x=StudentModel::printAllActivities;
        StudentDatabaseModel.getAllStudents().forEach(x::accept);

//        How to refactor the method which is not compatible to method reference
        Predicate<StudentModel> studentModelPredicate=MethodReference1::greaterThanGradeLevel; // Returns true if the grade is greater than 3

        StudentDatabaseModel.getAllStudents().forEach(a->{
            if (studentModelPredicate.test(a))
                System.out.println(a+"  "+studentModelPredicate.test(a));
        });
//         Inside the StudentDatabaseModel we created a supplier that gives only one instance of Student
        Predicate<StudentModel> p1=MethodReference1::greaterThanGradeLevel;
        System.out.println(p1.test(StudentDatabaseModel.studentModelSupplier.get()));
    }
}
