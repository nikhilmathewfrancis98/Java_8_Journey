package Com.Java8_FunctionalProgramming.OptionalClass;

import Com.Java8_FunctionalProgramming.Consumer.StudentDatabaseModel;
import Com.Java8_FunctionalProgramming.Consumer.StudentModel;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *  The Optional is used to represent the NotNull values
 *  Avoids null-pointer Exception and unnecessary null Checks
 */
public class OptionalExample1 {
   public static Function<List<StudentModel>,List<String>> f=(students->{
      return students.stream().map(StudentModel::getName).collect(Collectors.toList());
   });
    public static Optional<List<StudentModel>> getStudentNameOptional(){
        // From the below instance we need to get the student name
      Optional<String> op1=  Optional.ofNullable(StudentDatabaseModel.studentModelSupplier.get().getName()); // Optional[string]
        Optional<StudentModel> op2=  Optional.ofNullable(StudentDatabaseModel.studentModelSupplier.get()); //Optional[StudentModel]
        Optional<List<StudentModel>> op3=  Optional.ofNullable(StudentDatabaseModel.listSupplier.get()); //Optional[List<StudentModel>]
        if(op1.isPresent()) // Since it's a String optional we don't need to extract the name again
            System.out.println("Name from op1: "+op1.map(String::toUpperCase));
            System.out.println("Name from op1: "+op1.map(String::toUpperCase).get());
            System.out.println("Name from op1: "+op1.get().toUpperCase());
        System.out.println("======================================");
        // Here the op2.map() // takes the Function<Student>
        if (op2.isPresent())
            System.out.println("Name from op2: "+op2.map(studentModel -> studentModel.getName()).map(String::toUpperCase));
            System.out.println("Name from op2: "+op2.map(StudentModel::getName).map(String::toUpperCase).get());
            System.out.println("Name from op2: "+op2.get().getName().toUpperCase()); // Both the above and this line of code is same
        System.out.println("======================================");

//        if (op3.isPresent())
//            return op3; // op3.map(f) -> returns Optional <List<String>> , op3.map(f).get() -> returns List<String>  , op1.map(StudentModel::getName) -> return Optional<String>
//
//        else
            return op3;
      }
    public static void main(String[] args) {
    Optional<List<StudentModel>> op3= getStudentNameOptional();

       if (op3.isPresent())
           System.out.println("Name from op3: "+op3.get().stream().map(StudentModel::getName).map(String::toUpperCase).collect(Collectors.toList()));
//           System.out.println("Name from op3: "+op3.map(f).get()); // here the map takes the Function<List<Student>>


    }
}
