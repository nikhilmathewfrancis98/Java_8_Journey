package Com.Java8_FunctionalProgramming.DefaultAndStatic;

import Com.Java8_FunctionalProgramming.Consumer.StudentDatabaseModel;
import Com.Java8_FunctionalProgramming.Consumer.StudentModel;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 *  In this example we are going to handle if an ArrayList having null and we are going to sort the values what will happen
 */
public class SortComparatorExample2 {
  public static Function<StudentModel,String> fn=new Function<StudentModel, String>() {
      @Override
      public String apply(StudentModel s) {
//          Runnable r=new StudentModel()::getName;
          return s.getName();
      }
  };
   static Consumer<StudentModel> studentModelConsumer= System.out::println;
    public static List<StudentModel> getMyStudents() {

        /**
         * Second grade students
         */
        StudentModel student1 = new StudentModel("Adam", 2, 3.6, 11, "Male", Arrays.asList("Swimming", "Basketball", "Volleyball"));
        StudentModel student2 = new StudentModel("Jenny", 2, 3.8, 12, "Female", Arrays.asList("Swimming", "Gymnastic", "Soccer"));

        /**
         * Grade 3 students
         */
        StudentModel student3 = new StudentModel("Emily", 3, 4.0, 10, "Female", Arrays.asList("Swimming", "Gymnastic", "Aerobics"));
        StudentModel student4 = new StudentModel("Dave", 3, 3.9, 9, "Male", Arrays.asList("Swimming", "Gymnastic", "Soccer"));

        /**
         * Grade 4 students
         */
        StudentModel student5 = new StudentModel("Sophia", 4, 3.5, 15, "Female", Arrays.asList("Swimming", "Dancing", "Football"));
        StudentModel student6 = new StudentModel("Carlos", 4, 3.9, 14, "Male", Arrays.asList("Swimming", "Football", "Basketball", "Baseball"));

        List<StudentModel> s= Arrays.asList(student1, student2, student3, student4, student5, student6,null); // here its a null
        return s;
    }

    public static void sortWithNullValues(List<StudentModel> list){
//        StudentModel s=new StudentModel();
        Comparator<StudentModel> studentModelNameComparator=Comparator.comparing(fn);
      Comparator<StudentModel> cs= Comparator.nullsLast(studentModelNameComparator); // use nullsFirst so the null value will be evaluated first
        list.sort(cs);
        list.forEach(System.out::println);
    }
    public static void main(String[] args) {
        List<StudentModel> s= getMyStudents();
//        s.sort(Comparator.comparing(StudentModel::getName));
//        s.forEach(studentModelConsumer); // Now this will throw an error as the last element is null

        System.out.println("======================================");
        sortWithNullValues(s);

    }
}
