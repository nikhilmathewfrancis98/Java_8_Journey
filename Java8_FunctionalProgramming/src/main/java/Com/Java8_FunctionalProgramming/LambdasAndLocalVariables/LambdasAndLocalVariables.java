package Com.Java8_FunctionalProgramming.LambdasAndLocalVariables;

//import java.util.function.Consumer;

/**
 * This is just a theory no coding
 * local var - variables inside the method of a class
 * lambdas have restriction on sing the local variables:
 *    1: Not allowed to use the same local var name as lambda param or inside lambda body
 *    Not allowed to reassign a value to a local variable
 *    If the variable is instance then it has no restrictions
 *    Since the local var is not allowed to reassign and re declared and not editable its internally
 *    declared as final this concept is called effectively final

public class LambdasAndLocalVariables {
    int x=0; // If x was declared and initialized outside this won't give an error
    public static void main(String[] args) {
        int x=0;
        Consumer<Integer> c=(x)->{
            x++; //increment is also not allowed
            int x=2; // reassignment is restricted
            System.out.println(x*x);
        };  // error so commented

    }
}
 */