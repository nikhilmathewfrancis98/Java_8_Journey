package Com.Java8_FunctionalProgramming.FunctionInterface;

import Com.Java8_FunctionalProgramming.Consumer.StudentDatabaseModel;
import Com.Java8_FunctionalProgramming.Consumer.StudentModel;
import Com.Java8_FunctionalProgramming.PredicateFunctionalInterface.PredicateFInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * In this example we are going to make the Real life scenario
 * We are going to implement the student db using the Function interface
 */
public class FunctionInter2 {
   static Function<List<StudentModel>, Map<String, Double>> filteredGPAandGrade=(students)->{
     Map<String,Double> studentGAPMAP=new HashMap<>();
        students.forEach(x->{
            if (PredicateFInterface.studentflter.test(x))
                studentGAPMAP.put(x.getName(),x.getGpa());
        });
     return studentGAPMAP;
    };


    static String performConcat(String str) {
        return FunctionInter.functionAndThen.apply(str);
    }

    public static void main(String[] args) {
        System.out.println(performConcat("Nikhil"));
        System.out.println(filteredGPAandGrade.apply(StudentDatabaseModel.getAllStudents()));
    }
}
