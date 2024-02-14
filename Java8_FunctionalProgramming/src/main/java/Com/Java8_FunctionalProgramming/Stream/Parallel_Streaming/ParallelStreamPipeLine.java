package Com.Java8_FunctionalProgramming.Stream.Parallel_Streaming;

import Com.Java8_FunctionalProgramming.Consumer.StudentDatabaseModel;
import Com.Java8_FunctionalProgramming.Consumer.StudentModel;

import java.util.List;
import java.util.stream.Collectors;

/**
 * In this eg: we are going to create a real world parallel stream
 * And we see through the real use case of  sequential and the parallel stream  and compare both
 */
public class ParallelStreamPipeLine {
    public static List<String> printStudentActivitiesSequential(){
        long starTime=System.currentTimeMillis();
        List<String>s= StudentDatabaseModel.listSupplier.
                get()
                .stream().
                map(StudentModel::getActivities)
                .flatMap(List::stream)
                .distinct()
                .sorted().collect(Collectors.toList());
        long endTime=System.currentTimeMillis();
        System.out.println("Duration to execute the pipeline in sequential : "+(endTime-starTime));
        return s;
    }

    public static List<String> printStudentActivitiesParallel(){
        long starTime=System.currentTimeMillis();
        List<String>s= StudentDatabaseModel.getAllStudents()
                .stream(). // or we can call parallelStream directly here
                 parallel().
                map(StudentModel::getActivities)
                .flatMap(List::stream)
                .distinct()
                .sorted().collect(Collectors.toList());
        long endTime=System.currentTimeMillis();
        System.out.println("Duration to execute the pipeline in parallel : "+(endTime-starTime));
        return s;
    }
    public static void main(String[] args) {
        System.out.println(printStudentActivitiesSequential());
        System.out.println(printStudentActivitiesParallel());
    }
}
