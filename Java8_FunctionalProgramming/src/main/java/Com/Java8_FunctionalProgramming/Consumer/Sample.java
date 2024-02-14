package Com.Java8_FunctionalProgramming.Consumer;

class A{
    String AName;

    public void render(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "A{" +
                "AName='" + AName + '\'' +
                '}';
    }

    public A(String AName) {
        this.AName = AName;
    }
}
class B extends A{
    private String BName;

    @Override
    public String toString() {
        return "B{" +
                "BName='" + BName + '\'' +
                "} " + super.toString();
    }

    public B(String AName, String BName) {
        super(AName);
        this.BName=BName;
    }
}
public class Sample {
    public static void main(String[] args) {
        B b=new B("AName","BName");

        System.out.println(b);
    }
}
