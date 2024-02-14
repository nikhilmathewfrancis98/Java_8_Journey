package Com.Java8_FunctionalProgramming.DefaultAndStatic;

import java.util.List;

/**
 * Both default and static has the body
 * But static cannot be overridden but default can
 */

public interface Multiplier  {
   int  multiply(List<Integer> list);
   default int size(List<Integer> list){
      System.out.println("Inside Interface Method default");
      return list.size();
   }
   static boolean isEmpty(List<Integer> list){ // Cannot be overridden
      return list==null && list.size()==0; // false if list is not empty true if list is empty
   }
}
