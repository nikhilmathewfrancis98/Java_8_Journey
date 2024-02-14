package Com.Java8_FunctionalProgramming.MethodReference;

import Com.Java8_FunctionalProgramming.Consumer.StudentModel;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Note Constructor reference can only be used with functional interface
 * syntax ClassName::new
 * Supplier<Student> s=Student::new; // gives the new instance of the Student class
 * For this to be executed we need an empty constructor fn inside Student Class
 * The output will be the toString of the Student class
 */
public class ConstructorReference {
   static Supplier<StudentModel> s=StudentModel::new;


   //The below fn interface takes the string and return the student instance value so we need
//    To create a constructor that takes string as input and assign it to the name and return the instance
   static Function<String,StudentModel> f=StudentModel::new;
    public static void main(String[] args) {
        System.out.println(s.get()); // We get the value as every field is null if we comment the toString method we get error
// Since we are trying to print the constructor value
System.out.println(f.apply("Nikhil"));
String display=new ConstructorReference().display();

        System.out.println(display);
    }

    private String display() {
       Supplier<String> name= this::getName;
        return name.get();
    }

    public String getName() {
        return "Nikhil Mathew Francis = this is just a demo piece";
    }



}
