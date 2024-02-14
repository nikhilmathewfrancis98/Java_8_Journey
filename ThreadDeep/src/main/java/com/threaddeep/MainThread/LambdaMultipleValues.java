package com.threaddeep.MainThread;

import com.threaddeep.Interfaces.LambdaMiddle;
import com.threaddeep.Pojo.Customer;
import lombok.Data;

import java.util.concurrent.atomic.AtomicReference;
@Data
public class LambdaMultipleValues  {
    private static int age;
    private static String name;
    private static int id;
    public static void main(String[] args) {
        Customer cs=new Customer();
        LambdaMiddle l= (vs)->{vs.setAge(21);
       LambdaMultipleValues.age= vs.getAge();
       vs.setName("Niki");
            LambdaMultipleValues.name=vs.getName();
            vs.setCus_id(2121212);
            LambdaMultipleValues.id=vs.getCus_id();
        };
        l.SetValues(cs);
        System.out.println(name+"\t"+age+"\t"+id+" ");
    }


}
