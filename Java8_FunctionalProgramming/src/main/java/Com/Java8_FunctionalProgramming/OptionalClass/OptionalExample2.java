package Com.Java8_FunctionalProgramming.OptionalClass;

import java.util.Optional;

/**
 *  In this example we are going to learn about the
 *  empty(), ofNullable(), of()
 *  ofNullable() -> can expect a value or null
 *  of() -> accepts only  a valid data not null value -> it will print the nullPointer exception if the Optional.of(null) we give
 */
public class OptionalExample2 {
    public static Optional<String> OfNullable(){
        return Optional.ofNullable("Hello World!");
        // return Optional.of("value") -> valid but return Optional.of(null) -> invalid
    }
    public static Optional<String> empty(){
        return Optional.empty();
        // return Optional.of("value") -> valid but return Optional.of(null) -> invalid
    }
    public static void main(String[] args) {
        Optional<String> opt=OfNullable();
        if (opt.isPresent())
            System.out.println(opt.get());
        else
            System.out.println("Not Found");
        System.out.println(empty());// .get will give the exception
    }
}
