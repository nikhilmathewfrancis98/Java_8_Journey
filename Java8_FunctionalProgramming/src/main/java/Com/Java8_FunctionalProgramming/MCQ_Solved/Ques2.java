package Com.Java8_FunctionalProgramming.MCQ_Solved;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Students{
    String name;

    public Students(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
public class Ques2 {
    private static List<Students> getListOfStudents(){
        List<Students> list=new ArrayList<>();
        list.add(new Students("Stenny",24));
        list.add(new Students("Rucha",22));
        list.add(new Students("Vihaan",21));
        list.add(new Students("Stenny",22));
        return list;
    }
    public static void main(String[] args) {
        List<Students> list=getListOfStudents();
       Map<String,Integer> mapToAge= list.stream()
                .collect(Collectors.toMap(Students::getName,Students::getAge,(oldValue,newValue)->oldValue));
        System.out.println(mapToAge);
//
//        LocalDate date=LocalDate.of(2019, Month.MARCH,30);
//        System.out.println(date);
//        Stream s= Stream.empty();
//
//        List<Integer> l= Arrays.asList(1,2,3,4,5);
//        Stream<Integer> s1=l.stream();
//        List<Integer> list1=s1.collect(Collectors.toCollection(ArrayList::new));
//        ArrayList<Integer> arrayList=new ArrayList<>(list1);
//        Map<String,Double> countryCapitalmap=new HashMap<>();
//        countryCapitalmap.put("Lenovo",34450.00);
//        countryCapitalmap.put("Apple",92500.00);
//        countryCapitalmap.put("Toshiba",53600.00);
//        countryCapitalmap.forEach((k,v)->{System.out.println("Key:"+k+"Value:"+v);});

        Instant timeStamp=Instant.now();
        System.out.println("Current timeStamp: "+timeStamp);
        Instant specificTime=Instant.ofEpochMilli(timeStamp.toEpochMilli());
        System.out.println(specificTime);

//        List<String> l=Arrays.asList("Java","Ruby","Php");
//        String lan=l.stream().map(String::valueOf).collect(Collectors.joining(",","{","}"));

    }
}
