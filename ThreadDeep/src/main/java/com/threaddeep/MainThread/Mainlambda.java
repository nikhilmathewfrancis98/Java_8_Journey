package com.threaddeep.MainThread;

//class Helloworld implements Runnable{
//        @Override
//        public void run(){System.out.println("This is Hello World");}
//        }
//
//class Hey implements Runnable{
//    @Override
//    public void run(){System.out.println("This is Hey World");}
//}

import com.threaddeep.Pojo.Increment;

// Here inorder to implements these runnable we can create the anonymous class like below in the main
public class Mainlambda {
    public static void main(String[] args) throws InterruptedException {
        // anonymous class here no any other class that implements Runnable
//        Runnable r1=new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("This is Hello World");
//            }
//        };
//        Thread t=new Thread(r1);
//        t.start();
//       // OR
//       new Thread(new Runnable() {
//           @Override
//           public void run() {
//               System.out.println("This is Hey World");
//           }
//       }).start();

       // Using lambda function
        Increment in=new Increment();
        Thread th= new Thread(()->{
//            System.out.println("");
            for (int i=1;i<=2000;i++){
                in.IncrementCount();
            }
        },"Inside thread 1");
        th.start();
        th.join();
        System.out.println("\n"+th.getName()+"\n");

        Thread th2= new Thread(()->{ for (int i=1;i<=2000;i++){in.IncrementCount();} },"This is thread 2");
        th2.start();
        System.out.println("\n"+th2.getName()+"\n");
        th2.join();


       Thread th3= new Thread(()->{ for (int i=1;i<=2000;i++){in.IncrementCount();} },"This is thread 3");
       th3.start();
       th3.join();
        System.out.println("\n"+th3.getName()+"\n");
        System.out.println("Count is "+in.getCount());
    }
}
