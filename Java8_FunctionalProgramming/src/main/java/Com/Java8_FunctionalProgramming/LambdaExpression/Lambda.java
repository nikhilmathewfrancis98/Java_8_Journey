package Com.Java8_FunctionalProgramming.LambdaExpression;

/**
 * Lambda is like equivalent to a method without a name
 * Anonymous method with method params body and return type
 * Lambdas are not tied to any class like a regular method
 * Can be assigned to any variables and passed like normal variables
 * Syntax (params)->{body}
 * Mainly used to implement functional interfaces(Single abstract methods)
 */
public class Lambda {
    public static void main(String[] args) {
/**
 * Implementing the runnable and comparator functional interface Using anonymous class and modern java way using lambda Exp
 */
//Runnable runnable=new Runnable() {
//    @Override
//    public void run() {
//            for (int i=0;i<5;i++)
//                System.out.println("Hello "+(i+1));
//
//    }
//};
//Thread thread=new Thread(runnable);
//thread.start();
// Using the lambda exp
        Runnable runnable=()-> {
                for (int i=0;i<5;i++)
                    System.out.println("Hello "+(i+1));

            };

        Thread thread=new Thread(runnable);
        thread.start();
    }
}
