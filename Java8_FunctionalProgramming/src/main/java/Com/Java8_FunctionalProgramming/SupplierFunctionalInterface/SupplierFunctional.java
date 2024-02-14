package Com.Java8_FunctionalProgramming.SupplierFunctionalInterface;

import Com.Java8_FunctionalProgramming.Consumer.StudentDatabaseModel;
import Com.Java8_FunctionalProgramming.Consumer.StudentModel;

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * Actually the Supplier interface has a method get that actually return a type
 * This is my Logic of Implementation
 */
public class SupplierFunctional {
    int i=-1;

     List<StudentModel> ValuesSoFar=new ArrayList<>();
    Supplier<StudentModel> studentModelSupplier=()->{
       List<StudentModel> li= StudentDatabaseModel.getAllStudents();
       i+=1;
      return  li.get(i);
    };
public  void display(){
    System.out.println(ValuesSoFar);
}
    public static void main(String[] args) {
        SupplierFunctional supplierFunctional=new SupplierFunctional();

        final Supplier<StudentModel> get =supplierFunctional.studentModelSupplier::get;
        supplierFunctional.ValuesSoFar.add(get.get());
        supplierFunctional.ValuesSoFar.add(get.get());
//        System.out.println(get.get());
//        System.out.println(get.get());
        supplierFunctional.Result(supplierFunctional);

    }

    private void Result(SupplierFunctional s) {
        SupplierExtending x=new SupplierExtending(s);
        x.get().display();
    }
}
