package Com.Java8_FunctionalProgramming.UnaryAndBinaryFunctionalInterface;

 class Model1 {
     String name;
     int age;
     String address;

    @Override
    public boolean equals(Object that) {
        // Here we are taking the Object type because we need to compare the object
        if (this == that) return true;
        if (!(that instanceof Model1)) return false;
        // Now converting the Object type into the Model inorder to compare the fields
        Model1 model = (Model1) that;

        if (age != model.age) return false;
        if (!name.equals(model.name)) return false;
        return address.equals(model.address);
    }

//   here We can give our own algorithm for generating the hashcode
    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        result = 31 * result + address.hashCode();
        return result;
    }
}

public class Model {
    public static void main(String[] args) {
        Model1 model1=new Model1();
        model1.name="Nikhil";
        model1.age=24;
        model1.address="Kunnumpurath";

        Model1 model11=new Model1();
        model11.name="Nikhil";
        model11.age=24;
        model11.address="Kunnumpurath";
        // If the equals method where not present in my model class it would have called the Object class equals
//        Method that compares the hashcode only and return a boolean value
        System.out.println(model1.equals(model11)); // return true would return false if i change one of the value of the object of the Model

        System.out.println(model1.toString()); // Since my model class has ho toString method implemented it can call the Object class method
        // Com.Java8_FunctionalProgramming.UnaryAndBinaryFunctionalInterface.Model1@d5c8638d o/p the class name@hexdecimal(hashcode) // Explore the toString()



    }
}
