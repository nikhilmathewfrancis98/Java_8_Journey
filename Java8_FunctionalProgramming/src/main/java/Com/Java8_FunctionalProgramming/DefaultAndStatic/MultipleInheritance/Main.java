package Com.Java8_FunctionalProgramming.DefaultAndStatic.MultipleInheritance;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main implements Interface1,Interface2,Interface3{
    public static void main(String[] args) {
//        Interface1 i=new Main();
//        i.method1();
//        Interface2 i2=new Main();
//        i2.method2();
//        Interface3 i3=new Main();
//        i3.method3();

//        Main m=new Main();
////        m.method1();
//        m.method2();
//        m.method3();
//        System.out.println("=======");
        Interface3 i3=new Main();
        i3.method3();
        i3.method2();
//        i3.method1();
//        LocalDate d=LocalDate.now();
//
//        LocalDate last=d.with(TemporalAdjusters.lastDayOfYear());
//        Period p=d.until(last);
//        System.out.println(p.getMonths());
    List<String> s=Arrays.asList("nik","mth","sssd");
       Stream s1= Stream.of(s);
        System.out.println(s1.filter(x->x.equals("ni")).findFirst());
//      List<Integer> li= Arrays.asList(2,4,6,8,10);
//        System.out.println(li.stream());
    }

    @Override
    public void method2() { //here interface 3 and 2 are not implemented so we will get an error so we just defied hat method 2 here // if we extended 2 and 3 basically  method2 in interface 3 will get called
        Interface3.super.method2();
    }
}
