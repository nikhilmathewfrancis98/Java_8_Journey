package Com.Java8_FunctionalProgramming.OptionalClass;

import Com.Java8_FunctionalProgramming.Consumer.StudentDatabaseModel;
import Com.Java8_FunctionalProgramming.Consumer.StudentModel;

import java.util.Optional;

/**
 *  In this example we see through the orElse(),orElseGet(),orElseThrow()
 *  In this example we are going to get the Student details
 *
 */
public class OptionalExample3 {
    public static String orElseOptional(){
       Optional<StudentModel> op1= Optional.ofNullable(StudentDatabaseModel.studentModelSupplier.get());
//        Optional<StudentModel> op1= Optional.ofNullable(null);

        String name=op1.map(StudentModel::getName).orElse("Default");
       return name;
    }
    public static String orElseGetOptional(){
        Optional<StudentModel> op1= Optional.ofNullable(StudentDatabaseModel.studentModelSupplier.get());
//        Optional<StudentModel> op1= Optional.ofNullable(null);

        String name=op1.map(StudentModel::getName).orElseGet(()->"Default"); // orElseGet takes the Supplier instance
        return name;
    }
    public static String orElseThrowOptional() throws Exception {
//        Optional<StudentModel> op1= Optional.ofNullable(StudentDatabaseModel.studentModelSupplier.get());
        Optional<StudentModel> op1= Optional.ofNullable(null);

        String name=op1.map(StudentModel::getName).orElseThrow(()->new RuntimeException("No Data Available!")); // orElseThrow takes the Supplier Exception instance
        return name;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("orElse : "+orElseOptional());
        System.out.println("orElseGet : "+orElseGetOptional());
        System.out.println("orElseThrow : "+orElseThrowOptional());
    }
}
