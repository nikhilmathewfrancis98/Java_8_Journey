package Com.Java8_FunctionalProgramming.DefaultAndStatic.MultipleInheritance;

public interface Interface2 extends Interface1 {
    default void method2(){
        System.out.println("Interface2 :-> method2");
    }
}
