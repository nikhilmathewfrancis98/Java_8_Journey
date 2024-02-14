package Com.Java8_FunctionalProgramming.Stream.TerminalMethods;

import Com.Java8_FunctionalProgramming.Consumer.StudentDatabaseModel;
import Com.Java8_FunctionalProgramming.Consumer.StudentModel;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 *  In this example we are seeing through the minBy,maxBy,Collecting andThen, grouping()
 *  UseCase - Getting the least gpa and the highest gpa student from each gradeLevel grouping
 */
public class MaxByMinByAndThen {
    private static Map<Integer,Long> noOfStudentsInEachGrade(){
      return   StudentDatabaseModel.getAllStudents()
                .stream()
              .collect(Collectors.groupingBy(StudentModel::getGradeLevel,counting())); // Maxby returns Optional
  }

  private static Map<Integer,Optional<StudentModel>> getTheHighestGPAStudent(){
        return StudentDatabaseModel.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(StudentModel::getGradeLevel,maxBy(Comparator.comparing(StudentModel::getGpa))));
      //              .collect(Collectors.groupingBy());
//     .collect(Collectors.groupingBy(StudentModel::getGradeLevel,Collectors.groupingBy(StudentModel::getGpa,Collectors.maxBy(Comparator.comparing(StudentModel::getGpa)))));

  }

    private static Map<Integer,StudentModel> getTheHighestGPAStudent2(){
        return StudentDatabaseModel.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(StudentModel::getGradeLevel,collectingAndThen(maxBy(Comparator.comparing(StudentModel::getGpa)),Optional::get)));
        //              .collect(Collectors.groupingBy());
//     .collect(Collectors.groupingBy(StudentModel::getGradeLevel,Collectors.groupingBy(StudentModel::getGpa,Collectors.maxBy(Comparator.comparing(StudentModel::getGpa)))));

    }
    public static void main(String[] args) {
        noOfStudentsInEachGrade().forEach((x,y)-> System.out.println("Grade:"+x+" has "+y+" number of Students."));
        getTheHighestGPAStudent().forEach((x,y)-> System.out.println(x+"  "+y)); // From here we are getting the Optional as the value to avoid this we can
//        Use the andThen and call the optional::get to get the values only but not optional or else we can get the value here like below
        System.out.println("=====");
        getTheHighestGPAStudent().forEach((x,y)-> System.out.println(x+"  "+y.get()));
        // Or else use the collectingAndThen like below method call
        System.out.println("=====");
        getTheHighestGPAStudent2().forEach((x,y)-> System.out.println(x+"  "+y));

        System.out.println("================================Min Values===========================================");
        StudentDatabaseModel.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(StudentModel::getGradeLevel,collectingAndThen(minBy(Comparator.comparing(StudentModel::getGpa)),Optional::get)))
                .forEach((x,y)-> System.out.println(x+"   "+y));


    }
}
