package Com.Java8_FunctionalProgramming.MethodReference;

/**
 * We are really using the method reference for Referring a method inside a class or an interface or any abstract which
 * have our BU logic to get called when another method inside another class is called. Its a kinda referring
 * Also Its used to simplify the implementation of any Functional interfaces
 */
@FunctionalInterface
interface parse2{
    static String convert2(String str){return str.concat(" Hello world");}
    String change(String str);
}
@FunctionalInterface
interface Parse{
    String convert(String str);
}
class StringParser{
    public static String parseTheString(String string){
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
public class MethodReference {
    public static void main(String[] args) {
        String name="ni";
        Printer p=new Printer();

        p.printString(name, new Parse() {

            public String convert(String str) {

                return StringParser.parseTheString(str);
            }
        });
//        Lambda expression of the above code
//        p.printString(name,str -> StringParser.parseTheString(str));

//        The below code will be the method reference of the above one
        p.printString(name, StringParser::parseTheString); // The  StringParser::parseTheString is referenced and placed in the type
//        of Parse interface coz the parseTheString inside the StringParser is called from the anonymous of parse so we directly
//        referred

        p.printString(name, parse2::convert2); // Here we are referring the parse2 convert method
    }
}
