package Com.Java8_FunctionalProgramming.LambdaExpression;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Person{
    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name=" + name +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int age;
    private String name;
}
public class LambdaOUsingComparator {
    public static void main(String[] args) {

        Comparator<Person> personComparator=new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
//                return (o1.getAge()>o2.getAge())?1:-1;
                Integer o1Age=o1.getAge();
                Integer o2Age=o2.getAge();

            return o1Age.compareTo(o2Age);
                /**
                 * The return will be like 0 if o1==o2
                 * 1 if o1 > o2
                 * -1 if o1 < o2
                 * compareTo is  the method of Integer class
                 */
            }
        };
//        Comparator<Person> personCompareLambda=(o1,o2)-> (o1.getAge()>o2.getAge())?1:-1;
        List<Person> li=new ArrayList<>();
        li.add(new Person(23,"Nik"));
        li.add(new Person(45,"Nik"));
        li.add(new Person(53,"Nik"));
        li.add(new Person(27,"Nik"));
        li.add(new Person(32,"Nik"));
//        Collections.sort(li,personComparator);
//        li.forEach(x->System.out.println(x));
//        Using the Lambda Expression
        Collections.sort(li,(o1,o2)-> (o1.getAge()>o2.getAge())?1:-1);
        li.forEach(x->System.out.println(x));

    }
}
