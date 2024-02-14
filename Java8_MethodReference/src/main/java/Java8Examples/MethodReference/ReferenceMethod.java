package Java8Examples.MethodReference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

class Square{
    public static void PrintSquare(int num){
        System.out.println(num*num);
//        return num*num;
    }
}
public class ReferenceMethod {
    public static void main(String[] args) {
        List<Integer> li=new ArrayList<>(Arrays.asList(1,2,3,4,5));
        new ReferenceMethod().display(li);
    }

    public void display(List<Integer> list){

        Consumer<Integer> s2=new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer+integer);
            }
        };
        Consumer<Integer> s= Square::PrintSquare;
        list.forEach(s::accept); // Referenced the accept method here
//        Reference method is always given as higher order functions
//        list.forEach(x->s.accept(x));

    list.forEach(x->s2.accept(x));
    list.forEach(s2::accept);
    }
}

//    public void display(List<Integer> list){
//        Consumer<Integer> s= new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) {
//                Square.PrintSquare(integer);
//            }
//        };
//
//        list.forEach(Square::PrintSquare);