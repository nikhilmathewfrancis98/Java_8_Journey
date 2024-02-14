package Com.Java8_FunctionalProgramming.UnaryAndBinaryFunctionalInterface;

import java.util.function.UnaryOperator;

/**
 * The Unary operator extends the Function interface
 * So when can we use this?
 * Use this when we have same type as the input and output
 * This is given for the ease of the function interface
 */
public class Unaryoperator {
    static UnaryOperator<String> stringUnaryOperator=(str)->str.concat(" Default"); // Here the input and the output are the same type
    public static void main(String[] args) {
        System.out.println(stringUnaryOperator.apply("Java is "));
    }
}
