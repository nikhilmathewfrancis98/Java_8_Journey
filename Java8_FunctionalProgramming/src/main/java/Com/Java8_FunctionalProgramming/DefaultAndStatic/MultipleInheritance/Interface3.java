package Com.Java8_FunctionalProgramming.DefaultAndStatic.MultipleInheritance;

public interface Interface3{
    default void method3(){
        System.out.println("Interface3 :-> method3");
    }

    default void method2(){
        System.out.println(Interface3.class+" :-> method2");
    }
}
