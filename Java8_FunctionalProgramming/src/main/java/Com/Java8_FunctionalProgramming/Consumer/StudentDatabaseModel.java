package Com.Java8_FunctionalProgramming.Consumer;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class StudentDatabaseModel {
   private static List<StudentModel> s;
   public static Supplier<StudentModel> studentModelSupplier=()->{
       // here Bike is not for every students only for selective ppl
//       Here we are adding the bike for Adam
       Bike b=new Bike();
       b.setModel("KB-100");
       b.setName("Honda");
      StudentModel s=new StudentModel("Adam",2,3.6,"Male", Arrays.asList("Swimming","Basketball","Volleyball"));
      s.setBike(Optional.ofNullable(b));
       return s;
   };
    public static Supplier<List<StudentModel>> listSupplier=()->
         Arrays.asList(new StudentModel("Adam",2,3.6,11,"Male", Arrays.asList("Swimming","Basketball","Volleyball"))
                ,new StudentModel("Jenny",2,3.8,12,"Female", Arrays.asList("Swimming","Gymnastic","Soccer"))
        ,new StudentModel("Emily",3,4.0,10,"Female", Arrays.asList("Swimming","Gymnastic","Aerobics"))
        ,new StudentModel("Dave",3,3.9,9,"Male", Arrays.asList("Swimming","Gymnastic","Soccer"))
        ,new StudentModel("Sophia",4,3.5,15,"Female", Arrays.asList("Swimming","Dancing","Football"))
        ,new StudentModel("Carlos",4,3.9,14,"Male", Arrays.asList("Swimming","Football","Basketball","Baseball"))
        ,null
        );

    public static List<StudentModel> getAllStudents(){
        /**
         * Second grade students
         */
        StudentModel student1=new StudentModel("Adam",2,3.6,11,"Male", Arrays.asList("Swimming","Basketball","Volleyball"));
        StudentModel student2=new StudentModel("Jenny",2,3.8,12,"Female", Arrays.asList("Swimming","Gymnastic","Soccer"));

        /**
         * Grade 3 students
         */
        StudentModel student3=new StudentModel("Emily",3,4.0,10,"Female", Arrays.asList("Swimming","Gymnastic","Aerobics"));
        StudentModel student4=new StudentModel("Dave",3,3.9,9,"Male", Arrays.asList("Swimming","Gymnastic","Soccer"));

        /**
         * Grade 4 students
         */
        StudentModel student5=new StudentModel("Sophia",4,3.5,15,"Female", Arrays.asList("Swimming","Dancing","Football"));
        StudentModel student6=new StudentModel("Carlos",4,3.9,14,"Male", Arrays.asList("Swimming","Football","Basketball","Baseball"));

        return s=Arrays.asList(student1,student2,student3,null,student4,student5,student6,null);
    }
}
