package Java8Examples.MethodReferenceTest2;
class A{
    public Runnable display(){
      final Runnable s = this::display1; // If we need to use the :: the return type should be FI
        return s;
    }
    public void  display1(){
        System.out.println("From A display1");
    }
}
class B extends A{
    public void show(){
        display().run();

    }
}
public class ReferenceUsingClass {
    public static void main(String[] args) {
        B b=new B();
        b.show();

    }
}
