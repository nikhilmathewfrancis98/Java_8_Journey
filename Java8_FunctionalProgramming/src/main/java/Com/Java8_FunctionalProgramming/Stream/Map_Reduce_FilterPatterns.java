package Com.Java8_FunctionalProgramming.Stream;

import Com.Java8_FunctionalProgramming.Consumer.StudentDatabaseModel;
import Com.Java8_FunctionalProgramming.Consumer.StudentModel;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * In this example we are going to use the ma,filter, reduce combo
 *  UseCase: Calculate the summation of the notebooks each student has
 *  We cannot directly reduce the student notebooks since its an instance so we need to take the notebooks and then reduce
 *
 */
public class Map_Reduce_FilterPatterns {
    public static int noOfNoteBooks(){
        return StudentDatabaseModel.getAllStudents().stream().map(StudentModel::getNoteBooks)
                .reduce(0,(a,b)->a+b);
//        or .reduce(0,Integer::sum); // also Integer::max,min etc.
    }

    public static int noOfNoteBooksOfStudentsWRTGradeLevel(){
        return StudentDatabaseModel.getAllStudents()
                .stream().filter(x->x.getGradeLevel()>=3)
                .filter(x->x.getGender().toLowerCase().equals("female"))
                .map(StudentModel::getNoteBooks)
                .reduce(0,Integer::sum);
    }
   static Function<StudentModel,String> fn=(studentModel -> {
       Optional<StudentModel>name= Optional.ofNullable(studentModel);
      return (name.isPresent())?name.get().getName():"Default Null Encountered";
    });
    public static void main(String[] args) {
//        System.out.println("The number of NoteBooks every student has are : "+noOfNoteBooks());
//        System.out.println("The number of NoteBooks of students who has gradeLevel above 3 are : "+noOfNoteBooksOfStudentsWRTGradeLevel());
        List<StudentModel> list=StudentDatabaseModel.getAllStudents();
        Stream<StudentModel> s=StudentDatabaseModel.getAllStudents().stream();
      s.map(fn).peek(System.out::println).collect(Collectors.toList());

    }
}
