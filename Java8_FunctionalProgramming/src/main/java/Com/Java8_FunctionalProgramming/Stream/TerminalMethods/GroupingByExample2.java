package Com.Java8_FunctionalProgramming.Stream.TerminalMethods;

import Com.Java8_FunctionalProgramming.Consumer.StudentDatabaseModel;
import Com.Java8_FunctionalProgramming.Consumer.StudentModel;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *  In this example we are going to cover the next version
 *  groupingBy(classifier,downstream)
 *  2 level of grouping can be done here
 *  1st we do grouping w.r.t a classifier the again we do a grouping which is the
 *  downstream and group again
 *  downstream can be any version of the grouping impl or collector impl
 */
public class GroupingByExample2 {

    // Example 1 2 level mapping
    private static Map<Integer,Map<String, List<StudentModel>>> towLevelGrouping(){
      return   StudentDatabaseModel.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(StudentModel::getGradeLevel // level one grouping w.r.t gradeLevel return type Map<Integer,Map<String,List<StudentModel>>>
                ,Collectors.groupingBy(student->student.getGpa()>=3.9?"OUTSTANDING: ":"AVERAGE: "))); // level2 grouping // return type will be Map<String,List<StudentModel>>
    }
    private static Map<Integer,Integer> towLevelGrouping2(){ // In this example we are grouping w.r.t gradeLevel and then using the collect method/terminal method summingInt to getAll the notebook sum
        return   StudentDatabaseModel.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(StudentModel::getGradeLevel // level one grouping w.r.t gradeLevel return type Map<Integer,Map<String,List<StudentModel>>>
                        ,Collectors.summingInt(StudentModel::getNoteBooks)));// level2 grouping // return type will be Map<String,List<StudentModel>>
    }
    private static Map<String,Integer> towLevelGrouping3(){ // In this example we are grouping w.r.t gradeLevel and then using the collect method/terminal method summingInt to getAll the notebook sum
        return   StudentDatabaseModel.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(StudentModel::getName // level one grouping w.r.t gradeLevel return type Map<Integer,Map<String,List<StudentModel>>>
                        ,Collectors.summingInt(StudentModel::getNoteBooks)));// level2 grouping // return type will be Map<String,List<StudentModel>>
    }
    public static void main(String[] args) {
//        System.out.println(towLevelGrouping());
        Map<Integer,Map<String, List<StudentModel>>> studentDetails=towLevelGrouping();
        studentDetails.forEach((k,v)-> {
            System.out.println(k+"'s category are :- "+v);
        });
        System.out.println("\n ===================================================");
        System.out.println(towLevelGrouping2());
        System.out.println(towLevelGrouping3());
    }
}
