package Com.Java8_FunctionalProgramming.Stream;

import Com.Java8_FunctionalProgramming.Consumer.StudentDatabaseModel;
import Com.Java8_FunctionalProgramming.Consumer.StudentModel;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * filter() -> filter the element in the stream
 * The input will be a predicate SAM
 * it actually takes in  boolean value/ condition that gives a boolean
 */
public class StreamFilterExample {
    public static Predicate<StudentModel> StudentPredicate=(x)->x.getGender().toLowerCase().equals("female");
    public boolean checkGender(StudentModel x){
//        return (x.getGender().toLowerCase().equals("female")?true:false);
        return (x.getGender().toLowerCase().equals("female"));
    }
    public  List<StudentModel> getFemalStudents() {

        return StudentDatabaseModel.getAllStudents()
                .stream().filter(StudentPredicate). //or this::checkGender , StudentPredicate::test
                filter(x->x.getGpa()>3.9).
                collect(Collectors.toList());
    }
    public static void main(String[] args) {
       new StreamFilterExample().getFemalStudents().forEach(System.out::println);
    }
}
