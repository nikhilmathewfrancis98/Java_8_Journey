package Com.Java8_FunctionalProgramming.MCQ_Solved;


public class Ques24 {

    final static String language="Java";
    public static void main(String[] args) {
    LanguageService l=message ->
            System.out.println(language+message);
    l.showMessage("Programming");
    }
    interface LanguageService{
        void showMessage(String message);
    }
}
