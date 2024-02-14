package Com.Java8_FunctionalProgramming.MethodReference;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


class StudentDTO{
    private int id;

    public StudentDTO(Student student) {
        this.FName= student.getFName();
        this.LName=student.getLName();
        this.id=student.getId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public StudentDTO(int id, String FName, String LName) {
        this.id = id;
        this.FName = FName;
        this.LName = LName;
    }

    private String FName;
    private String LName;
}
class Student{
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public Student(int id, String FName, String LName) {
        this.id = id;
        this.FName = FName;
        this.LName = LName;
    }

    private String FName;
    private String LName;

}
public class Simple {
    Function<Student,StudentDTO> f=StudentDTO::new;
    public static void main(String[] args) {
        List<Student> s=new ArrayList<>();
        s.add(new Student(13,"Nik","Math"));
        s.add(new Student(123,"Franc","Bombay"));
        s.add(new Student(12,"Luther","Martin"));
        s.add(new Student(23,"Lia","Peirera"));
        s.add(new Student(0022,"Linu","Mah"));
        s.add(new Student(12443,"Barlin","Anth"));
        System.out.println("The Entity before conversion is : ");
        s.forEach(System.out::println);
       List<StudentDTO> stuDTO= s.stream().map(StudentDTO::new).collect(Collectors.toList()); // Converting the
       //Student -> StudentDTO using the Constructor::Reference
        stuDTO.forEach(System.out::println);
//        Simple sm=new Simple();
        System.out.println("");
//        System.out.println("The converted StudentDTO are: ");
//       sm.ServiceMethod(s).forEach(System.out::println);
//        s.stream().map(new Simple()::EntityToDTo).collect(Collectors.toList());
    }
    public List<StudentDTO> ServiceMethod(List<Student> li){
       List<StudentDTO> list= li.stream().map(this::EntityToDTo)
                .collect(Collectors.toList());
        return list;
    }
    public  StudentDTO EntityToDTo(Student student){
        StudentDTO sDTO=new StudentDTO(student.getId(), student.getFName(), student.getLName());
        return sDTO;
    }
}
