package Com.Java8_FunctionalProgramming.MCQ_Solved;
/**
 *  quest 34,33,32,31,29
 */

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Student{
    int id;
    String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMark() {
        return mark;
    }

    int mark;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mark=" + mark +
                '}';
    }

    public Student(int id, String name, int mark) {
        this.id = id;
        this.name = name;
        this.mark = mark;
    }
}
public class Question35 {
    public static void main(String[] args) {
        List<Student> li = Arrays.asList(
                new Student(1, "John", 90),
                new Student(2, "Stephen", 35),
                new Student(3, "Lily", 70),
                new Student(4, "Mortan", 100),
                new Student(5, "Mary", 65)
        );
//        li.forEach(System.out::println);
//        Stream<Student> op = li.stream().filter(s -> s.getName().startsWith("Jo"));
//        op.forEach(System.out::println);
//        double mark=li.stream().collect(Collectors.averagingInt(Student::getMark));
//        System.out.println(mark);
//        String[] arr={"John","Vihan","Nethra","Yagnay"};
//       Stream s= Stream.of(arr);
//       s.forEach(System.out::println);
       Integer num1=null;
       Integer num2=new Integer(10);
       Optional<Integer> a=Optional.ofNullable(num1);
       Optional<Integer> b=Optional.of(num2);

    }
}
