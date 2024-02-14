package Com.Java8_FunctionalProgramming.Consumer;
/**
 * Consumer Interface is a functional interface
 */

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConsumerClass <T>{
    public void data(){
        T string= (T) "Nik";
        Consumer<T> c=(a)->{
            System.out.println(a);
        };
        c.accept(string);
    }
    static void printMessage(String name){
        System.out.println("Hello "+name);
    }
    static void printValue(List<Integer> list){
         list= list.stream().map(x->(x * x)).collect(Collectors.toList());
        int result=list.stream()
                 .mapToInt(Integer::intValue)
                 .sum();
         list.forEach(x-> System.out.println(x));
        System.out.println(result);
    }
    public static void main(String[] args) {
//        System.out.println("Hai");
        // We have range and closedRange method
//        int result = IntStream.rangeClosed(0, 100).parallel().sum();
//        System.out.println(result);
//        If needed we can give the generic type here object accepts all but specific type can only accept that type
//        Consumer<String> c=(a)->{
//            System.out.println(a);
//        };
//        c.accept("10");
//        Consumer<String> consumer=new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//
//            }
//        };
//        Consumer to multiply the array nos with 2
//        Simply Integer can be given
//        Consumer<List<Object>> multiply=(list)->{
////            System.out.println();
//            for (int i=0;i<list.size();i++){
//                list.set(i,(Integer)list.get(i)*2);
//            }
//        };
//
//        ArrayList li=new ArrayList(Arrays.asList(2,1,3));
////        System.out.println(li.get(0));
//        multiply.accept(li);
////        li.stream().forEach(System.out::print);
//
//        Consumer<List<Integer>> toPrintTheList=x->{x.stream().forEach(System.out::print);};
//        toPrintTheList.accept(li);

//        We can refer a method into the Consumer interface and access that logic using the accept method
//        Consumer<String> c=ConsumerClass::printMessage;
//        c.accept("String");
////        Creating a list and referencing the method
//
//        Consumer<List<Integer>> c1=ConsumerClass::printValue;
//        c1.accept(li);

//        Declarative way of writing code is like using the already defined methods
//        other than writing the entire logic
//        eg: Find the Unique nos in an arrayList
        List<Integer> list=Arrays.asList(1,2,3,2,4,5,6,4,7,6,8,9,10);
        /**
         * Imperative approach is like
         */
        List<Integer> UniqueElements=new ArrayList<>();
        for (Integer ele: list){
            if (!UniqueElements.contains(ele)){
                UniqueElements.add(ele);
            }
        }
        System.out.println(UniqueElements);

        /**
         * The above problem in Declarative approach is
            The distinct method in the stream can get the distinct elements like in
         SQL and return the unique value
         */
       List<Integer> UniqueElements1= list.stream().distinct().collect(Collectors.toList());
    UniqueElements1.forEach(System.out::print);

    new ConsumerClass<>().data();
    }
}
