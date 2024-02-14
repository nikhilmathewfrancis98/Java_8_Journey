package Com.Example.Main;


import lombok.Data;

@Data
class Z implements Cloneable
{
    int i;
    String s;

    // A class constructor
    public Z (int i,String s)
    {
        this.i = i;
        this.s = s;
    }
    public Z(){

    }
    // Overriding clone() method
    // by simply calling Object class
    // clone() method.
    @Override
    protected Object clone()
            throws CloneNotSupportedException
    {
        return super.clone();
    }
}
@Data
class S{
    String name;
    int myNum;}


public class DeepAndShalow {
    public static void main(String[] args) throws CloneNotSupportedException {
//        S a=new S();
//        a.myNum=7011;
//        a.name="Nikhil Mathew";
//
//      S b=a; // Shallow copy
//      b.setMyNum(190);
//      b.setMyNum(221);
//      a.setName("Narayanan");
//      // Deepcopy
//        S c=new S();
//      c.setName(a.getName());
//      c.setMyNum(b.getMyNum());
//
//      a.setMyNum(3300);
//      b.setName("Biju");
//      System.out.println(a.getName()+" "+b.getMyNum());
//````````````````````````````````````````````````````````````````````````````

    Z z=new Z(202,"Nik");
    System.out.println(z.getS()+"\n");
    Z a=z;
    a.setS("Math");
    System.out.println(a.getS()+"\n"+z.getS());
    Z b=(Z) a.clone();
    b.setS("Fra");
    a.setS("Baiju");
        System.out.println(a.getS()+"\n"+z.getS()+" "+b.getS());
    }
}
