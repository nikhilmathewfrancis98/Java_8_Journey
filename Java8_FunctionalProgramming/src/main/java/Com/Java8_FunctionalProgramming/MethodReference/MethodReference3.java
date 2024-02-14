package Com.Java8_FunctionalProgramming.MethodReference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class MethodReference3 {
    static Function<String,String> integerIntegerFunction=String::toUpperCase;
    public static void main(String[] args) {
        Consumer<String> stringConsumer=(str)->{
            System.out.println(integerIntegerFunction.apply(str));};
        List<String> Stringli= Arrays.asList("nik","math","fra");
        Stringli.forEach(stringConsumer::accept);
        Stringli.forEach(stringConsumer);
        Stringli.forEach(x->stringConsumer.accept(x));

    }
}
