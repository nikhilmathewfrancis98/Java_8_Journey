package Com.Java8_FunctionalProgramming.Stream.TerminalMethods;

import Com.Java8_FunctionalProgramming.Consumer.StudentDatabaseModel;
import Com.Java8_FunctionalProgramming.Consumer.StudentModel;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *  As like in SQL groupBy() we use the GroupingBy for grouping the values
 *  Based on a property we group the elements
 *  return type or o/p Map<T k,T v>
 *      versions:
 *        1: groupingBy(classifier)  classifier- classification value need to be applied to the stream I/P
 *        2: groupingBy(classifier,downStream) - downstream-collection/ collector of any type
 *        3: groupingBy(classifier,Supplier,downStream)- supplier-override the default map factory
 *  In this example we are going to group the Students based on their gender
 *  In this Example we covered only one version of GroupingBy(classifier) 
 */
public class GroupingBy {
    private static Map<String, List<StudentModel>> GroupByGender(){
        return StudentDatabaseModel.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(StudentModel::getGender));
    }
//    Customizing the groupingBy with a condition
private static Map<String, List<StudentModel>> GroupByGPA(){
    return StudentDatabaseModel.getAllStudents()
            .stream()
            .collect(Collectors.groupingBy(student->student.getGpa()>=3.9?"OUTSTANDING: ":"AVERAGE: ")); // Here the key will be outstanding and average
}
    public static void main(String[] args) {
        Map<String,List<StudentModel>> studentDetails=GroupByGender();
        studentDetails.forEach((k,v)-> {
            System.out.print(k+"'s are :- ");
            v.forEach(x-> System.out.println(x.getName()));
        });
        System.out.println("==============GPA LEVELS=================");
        Map<String,List<StudentModel>> studentGPA =GroupByGPA();
        studentGPA.forEach((k,v)-> {
            System.out.print(k+" Students are :- ");
            v.forEach(x-> System.out.println(x.getName()));
        });
    }
}
