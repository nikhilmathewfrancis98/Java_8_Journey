package StreamApiS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class Stream2 {
    public static void main(String[] args) {

//        ArrayList<ArrayList<Integer>> list=new ArrayList();
//        list.add(new ArrayList(Arrays.asList(1,2,3)));
//        list.add(new ArrayList(Arrays.asList(4,5,6)));
//        list.add(new ArrayList(Arrays.asList(7,8,9)));
//        System.out.println(list.get(0).get(0));

//        ArrayList<ArrayList<Integer>> list=new ArrayList();
//        list.add(new ArrayList());
//        list.add(new ArrayList());
//        list.add(new ArrayList());
//        list.get(0).add(0,1);
//        list.get(0).add(1,2);
//        list.get(0).add(2,3);
//        list.get(1).add(0,4);
//        list.get(1).add(1,5);
//        list.get(1).add(2,6);
//        list.get(2).add(0,7);
//        list.get(2).add(1,8);
//        list.get(2).add(2,9);
//        list.get(0).stream().forEach(x->System.out.println(x+"\t"));

//        Stream using the String type
        Stream.of("Nik","Math","Alice").sorted().forEach(System.out::println); // Alice Math Nik
       Optional<String> opt= Stream.of("Nik","Math","Alice").sorted().findFirst();// Alice
        if (opt.isPresent()){
           System.out.println(opt.get());
        }
//        opt.ifPresent(System.out::println);
        opt.ifPresent(x->System.out.println(x));
        Stream.of("Nik","Math","Alice").sorted().findFirst().ifPresent(System.out::println);// Alice


    }
}
