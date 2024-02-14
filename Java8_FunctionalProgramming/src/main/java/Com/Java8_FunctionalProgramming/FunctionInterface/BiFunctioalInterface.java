package Com.Java8_FunctionalProgramming.FunctionInterface;

import Com.Java8_FunctionalProgramming.Consumer.StudentDatabaseModel;
import Com.Java8_FunctionalProgramming.Consumer.StudentModel;
import Com.Java8_FunctionalProgramming.PredicateFunctionalInterface.PredicateFInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

/**
 * This accepts 2 inputs and return 1 output
 * Only 2  methods apply and andThen which accepts 2 inputs
 * The inputs can be any type 1: It can be a function itself
 * 2: It can be a Predicate or Consumer anything we can pass here
 */
public class BiFunctioalInterface {
   static BiFunction<List<StudentModel>, Predicate<StudentModel>, Map<String,Double>> listPredicateBiFunction=
            (students,gradeCheck)->{
        Map<String,Double> students_GradeMAp=new HashMap<>();
        students.forEach(x->{
            if (gradeCheck.test(x))
                students_GradeMAp.put(x.getName(),x.getGpa());
        });
        return students_GradeMAp;
    };

    public static void main(String[] args) {
//        We are filtering the data w.r.t gradeLevel also we can use gpa to filter
        System.out.println(listPredicateBiFunction.apply(StudentDatabaseModel.getAllStudents(), PredicateFInterface.studentModelPredicate));
    }
}
