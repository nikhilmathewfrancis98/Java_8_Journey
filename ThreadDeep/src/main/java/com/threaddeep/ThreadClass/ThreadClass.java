package com.threaddeep.ThreadClass;

public  class ThreadClass extends Thread implements Runnable {
    public int threadNo;
    public int count=0;

    public ThreadClass(int threadNumber) {
        this.threadNo=threadNumber;
    }

    public int getCount(){return count;}
    @Override
    public void run(){
        for (int i=1;i<=5;i++){
            count+=1;
            System.out.println("From thread "+threadNo+" the number "+i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        System.out.println("\n"+count);
    }
}
