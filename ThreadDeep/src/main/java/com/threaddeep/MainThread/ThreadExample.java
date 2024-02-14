package com.threaddeep.MainThread;

import com.threaddeep.ThreadClass.ThreadClass;

public class ThreadExample {
    public static void main(String[] args) throws InterruptedException {
        ThreadClass t;
        int cnt=0;
        for (int i=1;i<=3;i++) {
             t = new ThreadClass(i);

//            Thread th=new Thread(t); // diff instances

            t.start(); //We can also put run but it will not work as a thread coz directly calling the run()
           t.join(); // This wait for one thread to finish its task to call another thread
            // Also we give it for the Main thread to wait until the other to complete the task
            cnt+=t.getCount();
        }
        // This will print only the no 5 coz 3 threads have 3 instances
        // So we did like this
        System.out.println("\n"+cnt);
    }
}
