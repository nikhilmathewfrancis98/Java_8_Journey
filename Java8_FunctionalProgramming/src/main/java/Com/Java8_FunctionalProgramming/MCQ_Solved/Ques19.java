package Com.Java8_FunctionalProgramming.MCQ_Solved;

import java.util.StringJoiner;

public class Ques19 {
    public static void main(String[] args) {
        StringJoiner joiner=new StringJoiner(":","[","]");
        joiner.add("Peter");
        joiner.add("Wilson");
        System.out.println(joiner);
    }
}
