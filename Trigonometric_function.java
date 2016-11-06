import java.util.Scanner;
public class Trigonometric_function {
    public static String MyInput;
    public static String DResult;
    public static String IResult;
    public static void input() {
        Scanner sc = new Scanner(System.in);
        String calculus = sc.nextLine();
        MyInput = calculus.trim();
    }
    public static void Differential() {
        int pos = MyInput.indexOf("*");
        if(pos != -1) DResult = MyInput.substring(0, pos + 1);
        else DResult = "";
        if (MyInput.indexOf("sin") != -1) DResult += "cosx";
        else if (MyInput.indexOf("cos") != -1) DResult += "-sinx";
        else if (MyInput.indexOf("tan") != -1) DResult += "secx*secx";
        else if (MyInput.indexOf("sec") != -1) DResult += "tanx*secx";
        else if (MyInput.indexOf("csc") != -1) DResult += "-cotx*cscx";
        else DResult = "-cscx*cscx";
    }
    public static void Integral() {
        int pos = MyInput.indexOf("*");
        if(pos != -1) IResult = MyInput.substring(0, pos + 1);
        else IResult = "";
        if (MyInput.indexOf("sin") != -1) IResult += "-cosx";
        else if (MyInput.indexOf("cos") != -1) IResult += "sinx";
        else if (MyInput.indexOf("tan") != -1) IResult += "-ln(cox(x))";
        else if (MyInput.indexOf("sec") != -1) IResult += "ln(tan(x)+sec(x))";
        else if (MyInput.indexOf("csc") != -1) IResult += "-ln(cot(x)+csc(x))";
        else IResult = "-ln(sin(x))";
    }
    public static void main(String[] args) {
        try {
            input();
        }
        catch(StringIndexOutOfBoundsException e) {}
        Differential();
        Integral();
        System.out.println(DResult + " " + IResult);
    }
}
