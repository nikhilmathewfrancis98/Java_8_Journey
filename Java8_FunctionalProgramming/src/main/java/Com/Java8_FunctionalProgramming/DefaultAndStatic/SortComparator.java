package Com.Java8_FunctionalProgramming.DefaultAndStatic;

import Com.Java8_FunctionalProgramming.Consumer.StudentDatabaseModel;
import Com.Java8_FunctionalProgramming.Consumer.StudentModel;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 *  In this example we are going to explore the Comparator.comparing()
 *  Comparator.comparingDouble() => double field comparing
 *  Comparator Chaining
 */
public class SortComparator {
    public static Consumer<StudentModel> consumer= System.out::println;
    public static Comparator<StudentModel> studentModelGradeComparator=Comparator.comparingDouble(StudentModel::getGradeLevel); // Since we are comparing w.r.t gpa and its a double we have this method

    public static Comparator<StudentModel> studentModelNameComparator=Comparator.comparing(StudentModel::getName);

    public static void sortByName(List<StudentModel> list){
        list.sort(studentModelNameComparator);
        System.out.println("Sorted w.r.t Name in Ascending order: ");
        list.forEach(consumer);
    }
    public static void sortByGPA(List<StudentModel> list){
        Comparator<StudentModel> studentModelGPAComparator=Comparator.comparingDouble(StudentModel::getGpa); // Since we are comparing w.r.t gpa and its a double we have this method

        list.sort(studentModelGPAComparator);
        System.out.println("Sorted w.r.t GPA in Ascending order: ");
        list.forEach(consumer);
    }
    public static void comparatorChaining(List<StudentModel> list){
        list.sort(studentModelGradeComparator.thenComparing(studentModelNameComparator));
        System.out.println("Sorted w.r.t Comparator Chaining: ");
        list.forEach(consumer); // Compare the result with the list which is not sorted and see the change
    }
    public static void main(String[] args) {
        List<StudentModel> s1= StudentDatabaseModel.getAllStudents();
//        s1.forEach(consumer);
        sortByName(s1);

        sortByGPA(s1);
        comparatorChaining(s1);
    }
}
