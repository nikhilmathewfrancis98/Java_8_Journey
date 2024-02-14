package Com.Example.Main;


// Java program to illustrate Cloneable interface
        import java.lang.Cloneable;

// By implementing Cloneable interface
// we make sure that instances of class A
// can be cloned.
class A implements Cloneable
{
    int i;
    String s;

    // A class constructor
    public A(int i,String s)
    {
        this.i = i;
        this.s = s;
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

// This class is created inorder to show the instanceof keyword
class x extends A{
    x(int a,String b){
        super(a,b);
    }
}

public class Shalow_Deep
{
    public static void main(String[] args)
            throws CloneNotSupportedException
    {
//        A a = new A(20, "GeeksForGeeks");
        x f= new x(5,"Jio");

        // cloning 'a' and holding
        // new cloned object reference in b

        // down-casting as clone() return type is Object


        // here   the b and a are pointing to the same instance so when ever a value is changed using either the ref var
        // The value is reflected // This is SHALLOW COPY
        // if we created a new memory then the we add values of the a instance then if we edith the a instance no change will
        //  be reflected in the new instance // this is DEEP COPY
        f.s="Jingu";
        A b1= (A) f.clone(); // Default it gives the Deep copy
        A b = f; // Shallow copying
        // Just to show the working of the instanceof keyword
//        if (f instanceof A){
//            System.out.println("Yes");
//        }
//        System.out.println(b.hashCode()+"\t"+f.hashCode()+"\t"+b1.hashCode());
        b.s="Balu";
        b1.s="Sonu";
        System.out.println(f.s);
        System.out.println(b.s);

        System.out.println(b1.s);
        b1.s="Nikii";
        f.s="Math";
        System.out.println(f.s);
        System.out.println(b.s);
        System.out.println(b1.s);


    }
}

