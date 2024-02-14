package Java8Examples.MethodReferenceTest2;

@FunctionalInterface
interface Parse{
    String convert(String str);
}

class Demo{
    public String convert2(String str){
        return str.toLowerCase();
    }
}
class StringParser{
    public  String parseTheString(String string){
        if (string.length()<3)
           string= string.toLowerCase();
        else
            string=string.toUpperCase();

        return string;
    }
}
class Printer{
    public void printString(String str,Parse p){
       String result= p.convert(str);
        System.out.println(result);
    }
}
public class MethodReference2 {
    public static void main(String[] args) {
        String name="nikhil mathew";
        Printer p=new Printer();

//        p.printString(name, new Parse() {
//
//            public String convert(String str) {
//
//                return StringParser.parseTheString(str);
//            }
//        });
//        Lambda expression of the above code
//        p.printString(name,str -> StringParser.parseTheString(str));

//        The below code will be the method reference of the above one
        p.printString(name,new StringParser()::parseTheString ); // The  StringParser::parseTheString is referenced and placed in the type
//        of Parse interface coz the parseTheString inside the StringParser is called from the anonymous of parse so we directly
//        referred
            // Since am not using the static keyword in the StringParser I can create the object to method reference
//        Demo d=StringParser::parseTheString;
    }
}
