package Com.Java8_FunctionalProgramming.Stream.TerminalMethods;

import Com.Java8_FunctionalProgramming.Consumer.StudentDatabaseModel;
import Com.Java8_FunctionalProgramming.Consumer.StudentModel;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toSet;

/**
 *  Kind of groupingBy() collector
 *  accepts predicate as input
 *  return type is Map<K,V> k-> boolean
 *  2 versions
 *  partitioningBy(predicate) , partitioningBy(predicate,downstream)
 *  there will be 2 partitioning the true one and the false one
 *  true -> Type{all the o/p satisfies the condition of predicate}
 *  false -> Type{all the o/p do not satisfy the condition of predicate}
 */
public class PartitioningBy {
   private static void GPA_partitioning(){
       Predicate<StudentModel> gpaPredicate=(student)->student.getGpa()>=3.8;
      Map<Boolean, List<StudentModel>> booleanListMap=StudentDatabaseModel.getAllStudents()
               .stream()
               .collect(Collectors.partitioningBy(gpaPredicate)); // With one arg
       booleanListMap.forEach((k,v)-> System.out.println(k+" "+v));
    }
    private static void GPA_partitioning_2(){
        Predicate<StudentModel> gpaPredicate=(student)->student.getGpa()>=3.8;
        Map<Boolean, Set<StudentModel>> booleanListMap1=StudentDatabaseModel.getAllStudents()
                .stream()
                .collect(Collectors.partitioningBy(gpaPredicate,toSet())); // With 2 args predicate and a downstream it can be a list also
        booleanListMap1.forEach((k,v)-> System.out.println(k+" "+v));
    }
    public static void main(String[] args) {
        GPA_partitioning(); // ppl satisfies and un satisfies both are shown here
        GPA_partitioning_2();
    }
}
