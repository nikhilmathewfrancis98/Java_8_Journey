package Com.Java8_FunctionalProgramming.MCQ_Solved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class Employee{
    String name;
    int age;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    public Employee(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    int salary;
}
public class Ques1 {
    public static void main(String[] args) {
        Predicate<Employee> employeePredicate=(emp)->emp.getAge()>40;
        List<Employee> li= new ArrayList<>();
        li.add(new Employee("Nik",45,25000));
         li.add( new Employee("Math",25,35000));
        li.add(new Employee("Sam",65,55000));
        li.add(new Employee("rul",22,15000));
        li.add( new Employee("Jill",25,65000));


        li.removeIf(employeePredicate);
        li.forEach(System.out::println);
    }
}
