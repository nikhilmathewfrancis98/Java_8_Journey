package Com.Java8_FunctionalProgramming.FunctionInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Here the Function Interface can accept 2 params First one is the input and the second one is the output
 * Type parameters:
 * <T> – the type of the input to the function <R> – the type of the result of the function
 */
public class FunctionInter {
    static Function<String,String> functionUpperCase=(name)->name.toUpperCase();
   public static Function<String,String> functionAndThen=(name)->name.concat(" is Great!");
    public static void main(String[] args) {
        List<String> li= Arrays.asList("nikh","math","babu","balu","namboothiri");
//        li.forEach(x-> System.out.println(functionUpperCase.apply(x)));
        System.out.println();
        li.forEach(x-> System.out.println(functionAndThen.andThen(functionUpperCase).apply(x))); // First concat and then to Uppercase
        System.out.println();
        li.forEach(x-> System.out.println(functionUpperCase.andThen(functionAndThen).apply(x))); // First uppercase then Concat Chaining of Function

//        USING THE COMPOSE METHOD
//        Here the instance inside the compose method gets executed first and then rest
        li.forEach(x-> System.out.println(functionUpperCase.compose(functionAndThen).apply(x)));
    }
}
