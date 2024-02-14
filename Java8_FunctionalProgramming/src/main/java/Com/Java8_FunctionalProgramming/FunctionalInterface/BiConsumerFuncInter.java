package Com.Java8_FunctionalProgramming.FunctionalInterface;

import Com.Java8_FunctionalProgramming.Consumer.StudentDatabaseModel;

import java.util.List;
import java.util.function.BiConsumer;

/**
 * in this example we can see that the functioning of the Bi-consumer fInterface
 * In this example we can see that we are passing 2 params so that we don't need to use 2 consumers for the pre eq
 * Here we are going to implement that
 *
 */

public class BiConsumerFuncInter {
    public static void printNameAndActivities(){
        BiConsumer<String, List<String>> biConsumerNameAndActivities=(name,activities)->{
            System.out.println(name+" : "+activities);
        };
        // The below code do not can have the student type so that we cannot method reference this and also cannot pass the bi-consumer objet itself
        StudentDatabaseModel.getAllStudents().forEach(
                x->biConsumerNameAndActivities.accept(x.getName(),x.getActivities())
        );
//        StudentDatabaseModel.getAllStudents().forEach(biConsumerNameAndActivities::accept);
//        ); // Error
    }

    public static void main(String[] args) {
//        BiConsumer<String,Integer> biConsumer=(s,i)-> {System.out.print(s+" ");
//            System.out.print(i);};
//        biConsumer.accept("Nikhil is turning",25);
        BiConsumer<Integer,Integer> biConsumerAddition=(s,i)-> System.out.println("Addition : "+(s+i));
        BiConsumer<Integer,Integer> biConsumerMultiplication=(s,i)-> System.out.println("Multiplication : "+(s*i));
        biConsumerAddition.andThen(biConsumerMultiplication).accept(3,5);

        /**
         * Trying to implement the pre eg
         */
        printNameAndActivities();
    }
}
