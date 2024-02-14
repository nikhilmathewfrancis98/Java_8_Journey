package Com.Java8_FunctionalProgramming.MCQ_Solved;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ques27 {
    public static void main(String[] args) {
        List<String> dataList= Arrays.asList("Code","I","Java");
        List<String> sortedData=dataList.stream().
                sorted(String::compareTo).collect(Collectors.toList());
        sortedData.forEach(System.out::println);
    }
}
