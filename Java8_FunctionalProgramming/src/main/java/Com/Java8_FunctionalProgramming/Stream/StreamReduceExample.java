package Com.Java8_FunctionalProgramming.Stream;

import Com.Java8_FunctionalProgramming.Consumer.StudentDatabaseModel;
import Com.Java8_FunctionalProgramming.Consumer.StudentModel;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 * Reduce the stream to a single values
 * It's a terminal operation
 * syntax -> reduce(accumulator,BinaryOperator<T a,U b,R x>)
 */
public class StreamReduceExample {
    static BinaryOperator<Integer> integerBinaryOperator=(a,b)->a+b;
    public static int performAddition(List<Integer> list){
//        Since reduce has many forms that takes different input we are using this form of reduce here
//        return list.stream().reduce(1,(x,y)->x*y); // BinaryOperator or
        return list.stream().reduce(0,integerBinaryOperator);
        // Here identity is the initial value and the accumulator is a
//        value inside b will change and every b element is added with the a which has prev sum value in this case
    }

    public static Optional<Integer> performAdditionWithoutIdentity(List<Integer> list){
        // Here the below return type is Optional -> used for handling null values
//        Here the identity is not present so the return type will be in Optional
        return list.stream().reduce(integerBinaryOperator);
    }

    public static Optional<StudentModel> getTheStudentWithHighestGPA(){
        return StudentDatabaseModel.getAllStudents().stream().reduce(
                ((studentModel, studentModel2) -> {
//                    System.out.println(studentModel+" \n"+ studentModel2+"\n");
                  if (studentModel.getGpa()>studentModel2.getGpa())
                      return studentModel;
                  else
                      return studentModel2;
                })
        );
    }
    public static void main(String[] args) {
        List<Integer> li= Arrays.asList(1,2,3,4,5);
        List<Integer> li2= Arrays.asList(1,2,3);

        System.out.println(performAddition(li));
        Optional<Integer> result=performAdditionWithoutIdentity(li2);
        System.out.println(result.isPresent());
        if (performAdditionWithoutIdentity(li2).isPresent())
            performAdditionWithoutIdentity(li2).ifPresent(System.out::println);

        /**
         *  We are using the useCase like getting the Highest gpa and printing the person name
         *  So we are not using the identity here, so we use the Optional return type
         */
        Optional<StudentModel> studentModelOptional=getTheStudentWithHighestGPA();
        studentModelOptional.ifPresent(System.out::println);
        System.out.println("///////////////////////////////////////////////////\n");
        List<String> names=Arrays.asList("Ant","Bore","Elephant","Giraffe","Lion","ZEBRA");
        Optional<String> largest=names.stream().reduce((x,y)->(x.length()>y.length())?x:y);
        largest.ifPresent(System.out::println);
        System.out.println(Collections.max(names.stream().map(String::toLowerCase).collect(Collectors.toList())));
    }

}
