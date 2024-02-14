package Com.Java8_FunctionalProgramming.SupplierFunctionalInterface;

import Com.Java8_FunctionalProgramming.Consumer.StudentDatabaseModel;
import Com.Java8_FunctionalProgramming.Consumer.StudentModel;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierUdemyLogic {
//    Creating the instance of Supplier
   static Supplier<StudentModel> studentSupplier=()->{
        return new StudentModel("Adam",2,3.6,"Male", Arrays.asList("Swimming","Basketball","Volleyball"));};
static Supplier<List<StudentModel>> listSupplier=()-> StudentDatabaseModel.getAllStudents();
    public static void main(String[] args) {
        System.out.println(studentSupplier.get());
        System.out.println(" ");
        System.out.println(listSupplier.get());
    }
}
