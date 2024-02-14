package com.threaddeep.MainThread;

import com.threaddeep.Interfaces.WAME;
import com.threaddeep.ThreadClass.ThreadClass;

public class ThreadClassAnnony implements WAME {
   public int count;

    public static void main(String[] args) throws InterruptedException {

      Thread t=  new Thread(){
          @Override
            public void run(){
                System.out.println("This is Thread class Anonymous");
            }
        };
      t.setName("1st Thread class Anonymous");
      t.start();
      t.join();
      System.out.println(t.getName()+"\n");

        Thread t2=  new Thread(){
            @Override
            public void run(){
                System.out.println("This is 2nd Thread class Anonymous");
            }
        };
        t2.setName("2nd Thread class Anonymous");
        t2.start();
        t2.join();
        System.out.println(t2.getName()+"\n");

        Thread th3= new Thread(()->{
            System.out.println("This is  thread 3 with runnable interface method is implemented");
        });
        th3.start();
        th3.join();

        Runnable r1=()->  System.out.println("This is runnable interface"); // {} are removed since only one line of code is present

        new Thread(r1).start();

        // here created an new thread and now the we called the show using the object
        // Since we only have one line of statement we did like this without curly braces

//        new Thread(() -> new ThreadClassAnnony().show("Hello")).start();
//        new ThreadClassAnnony().count();

        new Thread(()->{ var x=new ThreadClassAnnony();
        x.show("Hello");
        x.count();
        }).start();

     new Thread(()->{System.out.println("This is the Thread Lambda");}).start();

     Runnable r= new Runnable() {
         @Override
         public void run() {
             System.out.println("Runnable without using the Lambda exp");
         }
     };
     new Thread(r).start();
    System.out.println(new ThreadClassAnnony().display("Nikhil")); // interface method is called here
    // Annoted WAME interface with @FunctionalInterface so we can use the lambda expression
        WAME b=(String n)->{System.out.println("WAME Interface"); return "Hey am "+n;};
        System.out.println(b.display("Babu"));

    }
    @Override
    public String display(String name){System.out.println("This is the Interface methods"); return "Hello this is "+name;}
    public void show(String str){for (int i=0;i<5;i++) System.out.println(str+"\n");count++;}
    public void count(){System.out.println("\n"+count);}

}
