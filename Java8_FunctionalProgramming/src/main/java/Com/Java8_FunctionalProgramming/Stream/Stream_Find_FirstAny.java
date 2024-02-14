package Com.Java8_FunctionalProgramming.Stream;

import Com.Java8_FunctionalProgramming.Consumer.StudentDatabaseModel;
import Com.Java8_FunctionalProgramming.Consumer.StudentModel;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 *  Used to find an element in the stream
 *   returns type optional
 *   findFirst() -> first element in the stream w.r.t condition > testCase is if we have parallel streams running the 1st stream that has the element is get returned
 *   findAny() -> return first encountered element in the stream
 *   It's more helpful if we run parallel stream
 */
public class Stream_Find_FirstAny {
   public static Optional<StudentModel> findAnyStudent(){
    return    StudentDatabaseModel.getAllStudents()
               .stream().filter(x->x.getGpa()>=3.9).findAny(); // return first student which satisfies the condition
    }
    public static Optional<StudentModel> findFirstStudent(){
        return    StudentDatabaseModel.getAllStudents()
                .stream().filter(x->x.getGpa()>=3.9).findFirst(); // return first student in the stream which satisfies the condition
    }
    public static void main(String[] args) {
//        System.out.println(findAnyStudent().get());
//        System.out.println(findFirstStudent().get());
        List<Integer> li= Arrays.asList(1,3,2,4,6,3,2,4,5,6,2,7,8);
        System.out.println(li.stream().filter(x->x%2==0) // Stream<Integer> --> all even numbers
                .findFirst()); // return the 1st element

    }
}
