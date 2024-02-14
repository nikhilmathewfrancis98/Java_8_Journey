package Com.Java8_FunctionalProgramming.DefaultAndStatic;

import java.util.Arrays;
import java.util.List;

public class MultiplicationClient {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,2,3);
        Multiplier m=new InterfaceWithDefaultAndStatic();
        System.out.println(m.multiply(list));
        System.out.println("Size of the list: "+m.size(list));
        System.out.println("Is the List empty?: "+Multiplier.isEmpty(list));
    }
}
