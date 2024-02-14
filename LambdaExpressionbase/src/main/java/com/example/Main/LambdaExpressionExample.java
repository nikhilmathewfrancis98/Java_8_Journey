package com.example.Main;

import com.example.Interfaces.Drawable;
import com.example.POJO.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaExpressionExample {
    public static void main(String[] args) {
        //without lambda, Drawable implementation using anonymous class
//        Drawable d= new Drawable() {
//            @Override
//            public void draw() {
//                System.out.println("Without lambda expression");
//            }
//        };
//        d.draw();

//        //with lambda
//        Drawable d2=()->{
//            System.out.println("With lambda expression ");
//        };
//        d2.draw();

//        Used lambda and return value
//        Drawable d2 = ()->{
//           return  "With lambda expression ";
//        };
//       System.out.println(d2.draw());
//
//        System.out.println(new Drawable() {
//            @Override
//            public String  draw() {
//                return  "Anonymous interface ";
//            }
//        }.draw());

//       Lambda with parameters and without using the return statement

//        Drawable d= (String name)-> name+" Hello"; // Here we don't need the return statement
//        System.out.println(d.draw("Nikkooo 1322"));


        // Filtering the List using Stream and lambda and iterating through the stream
//        Product pro=new Product(7,"kkkk",65544444);
//
//        List<Product> list=new ArrayList<Product>();
//        list.add(new Product(1,"Samsung A5",17000f));
//        list.add(new Product(3,"Iphone 6S",65000f));
//        list.add(new Product(2,"Sony Xperia",25000f));
//        list.add(new Product(4,"Nokia Lumia",15000f));
//        list.add(new Product(5,"Redmi4 ",26000f));
//        list.add(new Product(6,"Lenevo Vibe",19000f));
//
////        List<Product> filtered_data = list.stream().filter(p -> p.price >20000).collect(Collectors.toList());
////        for (Product c:filtered_data
////             ) {
////            System.out.println(c.name+": "+c.price);
////        }
//
//        // using lambda to filter data Since we are not converting the Stream into the list we are receiving the output as Stream type itself
//        // we can use the .collect(Collectors.toList()) to convert the value into the List of type Product and can iterate
//        Stream<Product> filtered_data = list.stream().filter((p) -> p.price >20000 );
//
//        // using lambda to iterate through collection
//        filtered_data.forEach(
//                product -> System.out.println(product.name+": "+product.price)
//        );

        // Using ForEach loop lambda

        List<String> li=new ArrayList<String>();
        li.add("ankit");
        li.add("mayank");
        li.add("irfan");
        li.add("jai");

//        li.forEach(
//                (n)->System.out.println(n)
//        );

//        Consumer consumer=new Consumer() {
//            @Override
//            public void accept(Object o) {
//                System.out.println(o.toString());
//            }
//        };
//        li.forEach(x->consumer.accept(x));
//        or li.forEach(x->sout(x));

// Another trick for using the Lambda expression is
//        1: define a method and call that using the Object that method belongs to
//        2: here am trying to use the same class for the method
//        3: If we need to access the Square we need to use the apply method
        System.out.println(Square.apply(4));

        /**
         * Going to create the Object of the main and make it lambda
         */

    }

    //    static Integer Square(int num){
//        return num*num;
//    } // This method can be defined using the lambda expression
//    The Function type in java 8 can be used to express the function in this way
  public static Function<Integer,Integer> Square=(num)->num*num;


}

