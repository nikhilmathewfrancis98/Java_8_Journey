package Com.Java8_FunctionalProgramming.UnaryAndBinaryFunctionalInterface;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

/**
 * It extends the BiFunction so it takes 2 inputs and gives one output
 * So in the senerios we like if the input and the output has same type we use this
 */
public class Binaryoperator {
   static Comparator<Integer> integerComparator=(a,b)->a.compareTo(b);
//    static Comparable<Integer> integerComparable=(a)->a.compareTo(2);
    public static void main(String[] args) {
        BinaryOperator<Integer> integerBinaryOperator=(a,b)->a*b;
        System.out.println(integerBinaryOperator.apply(4,5));
//        Using the maxBy and minBy of the binaryOperator Class
//                maxBy and minBy takes a Comparator instance
      BinaryOperator<Integer> max= BinaryOperator.maxBy(integerComparator);
        System.out.println(max.apply(4,9));

//        BinaryOperator<Integer> integerBinaryOperator1=new BinaryOperator<Integer>() {
//            @Override
//            public Integer apply(Integer integer, Integer integer2) {
//                return null;
//            }
//        };
        int min= BinaryOperator.minBy(integerComparator).apply(9,3);
        System.out.println(min);

        System.out.println(Integer.parseUnsignedInt("4294967295"));

    }
}
