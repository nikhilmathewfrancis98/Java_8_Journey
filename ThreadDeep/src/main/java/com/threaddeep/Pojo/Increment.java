package com.threaddeep.Pojo;

public  class Increment {
    public int count=0;
    public synchronized void IncrementCount(){count+=1;}
    public int getCount(){return count;}
}
