package Com.Java8_FunctionalProgramming.MCQ_Solved;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ques26 {
    public static void main(String[] args) {
      List<Integer> li= IntStream.rangeClosed(1,100)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        li.forEach(System.out::println);
    }
}
