package Com.Java8_FunctionalProgramming.FunctionalInterface;

import Com.Java8_FunctionalProgramming.Consumer.StudentDatabaseModel;
import Com.Java8_FunctionalProgramming.Consumer.StudentModel;

import java.util.List;
import java.util.function.Consumer;

/**
 *consumer Interface using lambda expression is done in this example
 * SAM (Simple abstract Method)
 */
public class FunctionalInterface {
    /**
     * Printing out the names of the students
     * Using the Consumer interface
     */
   public static Consumer<StudentModel> c3=(student)-> System.out.print(student.getName());
   public static Consumer<StudentModel> c4=(student)-> System.out.println(student.getActivities());
   static Consumer<StudentModel> studentModelConsumer=(student)-> System.out.println(student.getActivities());

    public static void printWholeRecord(){
        StudentDatabaseModel.getAllStudents().forEach(studentModelConsumer);
    }

    /**
     *The method will print out the name and the activities of the Student
     */
//    public static void print(){
//        StudentDatabaseModel.getAllStudents().forEach(x->printNameAndActivities(x));
//    }
////
//    private static void printNameAndActivities(StudentModel student) {
//        Consumer<List<String>> studentActivityConsumer=(activity)-> System.out.println(activity);
//        Consumer<String> studentName=(name)-> System.out.print(name);
//        studentName.accept(student.getName());
//        studentActivityConsumer.accept(student.getActivities());
//
//
//    }
    private static void printNameAndActivities() {

        StudentDatabaseModel.getAllStudents().forEach(c3.andThen(c4)); // This is the feature called Chaining the Consumer like constructor chaining
        System.out.println();
    }

    /**
     * Printing the student name w.r.t their grade=>3
     */
    public static void namesWithHigherGrade()
    {
//        Consumer<StudentModel> c5=(student)-> {
//            if (student.getGradeLevel()>3)
//                System.out.println(student);
//        };
        StudentDatabaseModel.getAllStudents().forEach(x->{
            if (x.getGradeLevel()>=3&&x.getGpa()>=3.9)
                c3.andThen(c4).accept(x);
        });
    }

    public static void main(String[] args) {
//        Consumer<String> stringConsumer=(s)-> System.out.println(s.toUpperCase());
//        stringConsumer.accept("Java 8 is so simple and powerful as the Premam sir told!");
//        printWholeRecord();
//          printNameAndActivities();
          namesWithHigherGrade();
    }



}

