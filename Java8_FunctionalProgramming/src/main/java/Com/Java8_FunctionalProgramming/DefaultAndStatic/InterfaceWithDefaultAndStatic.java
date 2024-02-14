package Com.Java8_FunctionalProgramming.DefaultAndStatic;

import java.util.Arrays;
import java.util.List;

/**
 *  In this example we are going to execute the default and static method in an interface manually
 */
public class InterfaceWithDefaultAndStatic implements Multiplier {

    @Override
    public int size(List<Integer> list){
        System.out.println("Inside InterfaceWithDefaultAndStatic class  Method ");
        return list.size();
    }
    @Override
    public int multiply(List<Integer> list) {
        int multi=list.stream().reduce(1,(x,y)->x*y);
        return multi;
    }
}
