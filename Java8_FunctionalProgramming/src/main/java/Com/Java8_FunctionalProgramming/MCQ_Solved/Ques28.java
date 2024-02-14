package Com.Java8_FunctionalProgramming.MCQ_Solved;

interface MyInterface{
    default void method(){
        System.out.println("My Interface Method");
    }
        }
class MyClass implements MyInterface{
   public void method(){ // if we don't use the public keyword it's an error
        System.out.println("My Class Method");
    }
}
public class Ques28 {
    public static void main(String[] args) {
    MyInterface m=new MyClass();
    m.method();
    }
}
