package Com.Java8_FunctionalProgramming.OptionalClass;

import Com.Java8_FunctionalProgramming.Consumer.Bike;
import Com.Java8_FunctionalProgramming.Consumer.StudentDatabaseModel;
import Com.Java8_FunctionalProgramming.Consumer.StudentModel;

import java.util.Optional;

/**
 *  In here we are going to see  through map(), flatMap(),filter()
 */
public class OptionalExample4 {
    public static void optionalFilter(){
        Optional<StudentModel> op1=Optional.ofNullable(StudentDatabaseModel.studentModelSupplier.get());
       StudentModel s= op1.filter(x->x.getGpa()>=3.5).get(); // Got the StudentModel
        op1.filter(x->x.getGpa()>=3.5).ifPresent(System.out::println);
    }
    public static void optionalMap(){
        Optional<StudentModel> op1=Optional.ofNullable(StudentDatabaseModel.studentModelSupplier.get());
        String s= op1.map(StudentModel::getName).get(); // Got the string name
        Optional<String> op=op1.filter(x->x.getGpa()>=3.5).map(StudentModel::getName);
       String s1= op.get();
        System.out.println(s1);
      //  op1.map(StudentModel::getName).ifPresent(System.out::println);
    }
    public static void optionalFlat(){
        Optional<StudentModel> op1=Optional.ofNullable(StudentDatabaseModel.studentModelSupplier.get());
       Optional<Optional<Bike>> optionalBike= op1.filter(x->x.getGpa()>=3.5)
                .map(StudentModel::getBike);
        Optional<String> bike1= op1.filter(x->x.getGpa()>=3.5)
                .flatMap(StudentModel::getBike)
                .map(Bike::getName);// Gets the name
       Optional<Bike> bike= op1.filter(x->x.getGpa()>=3.5)
                .map(StudentModel::getBike)
                .flatMap(x->x);
       Bike b= bike.get();
       String name=b.getName();
        System.out.println(" Optional<Optional<Bike>> : "+optionalBike.get().map(Bike::getName).get());
        System.out.println("His logic Bike name : "+bike1.get());
        System.out.println("My Logic Bike name  : "+name);
    }
    public static void main(String[] args) {
//        optionalFilter();
//        optionalMap();
        optionalFlat();
    }
}
