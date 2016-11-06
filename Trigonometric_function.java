import java.util.Scanner;
public class Trigonometric_function {
    public static String MyInput;
    public static double x;
    public static double y;
    public static void input() {
        Scanner sc;
        sc = new Scanner(System.in);
        String Input = sc.nextLine();
        MyInput = Input.trim();
        sc = new Scanner(System.in);
        x = sc.nextDouble();
        sc = new Scanner(System.in);
        y = sc.nextDouble();
    }
    public static String Differential() {
        String DResult;
        int pos = MyInput.indexOf("*");
        if(pos != -1) DResult = MyInput.substring(0, pos + 1);
        else DResult = "";
        if (MyInput.indexOf("sin") != -1) DResult += "cosx";
        else if (MyInput.indexOf("cos") != -1) DResult += "-sinx";
        else if (MyInput.indexOf("tan") != -1) DResult += "secx*secx";
        else if (MyInput.indexOf("sec") != -1) DResult += "tanx*secx";
        else if (MyInput.indexOf("csc") != -1) DResult += "-cotx*cscx";
        else DResult = "-cscx*cscx";
        return DResult;
    }
    public static String Integral() {
        String IResult;
        int pos = MyInput.indexOf("*");
        if(pos != -1) IResult = MyInput.substring(0, pos + 1);
        else IResult = "";
        if (MyInput.indexOf("sin") != -1) IResult += "-cosx";
        else if (MyInput.indexOf("cos") != -1) IResult += "sinx";
        else if (MyInput.indexOf("tan") != -1) IResult += "-ln(cox(x))";
        else if (MyInput.indexOf("sec") != -1) IResult += "ln(tan(x)+sec(x))";
        else if (MyInput.indexOf("csc") != -1) IResult += "-ln(cot(x)+csc(x))";
        else IResult = "-ln(sin(x))";
        return IResult;
    }
    public static double NDifferential(double x) {
        double NDResult;
        int pos = MyInput.indexOf("*");
        int Coefficient;
        if(pos != -1) Coefficient = Integer.parseInt(MyInput.substring(0, pos));
        else Coefficient = 1;
        if (MyInput.indexOf("sin") != -1) NDResult = Math.cos(x);
        else if (MyInput.indexOf("cos") != -1) NDResult = -Math.sin(x);
        else if (MyInput.indexOf("tan") != -1) NDResult = 1 / Math.cos(x) / Math.cos(x);
        else if (MyInput.indexOf("sec") != -1) NDResult = Math.sin(x) / Math.cos(x) / Math.cos(x);
        else if (MyInput.indexOf("csc") != -1) NDResult = Math.cos(x) / Math.sin(x) / Math.sin(x);
        else NDResult = -1 / Math.sin(x) / Math.sin(x);
        return NDResult * Coefficient;
    }
    public static double Staticfraction(double x) {
        double NIResult;
        int pos = MyInput.indexOf("*");
        int Coefficient;
        if(pos != -1) Coefficient = Integer.parseInt(MyInput.substring(0, pos));
        else Coefficient = 1;
        if (MyInput.indexOf("sin") != -1) NIResult = -Math.cos(x);
        else if (MyInput.indexOf("cos") != -1) NIResult = Math.sin(x);
        else if (MyInput.indexOf("tan") != -1) NIResult = -Math.log(Math.cos(x));
        else if (MyInput.indexOf("sec") != -1) NIResult = Math.log(Math.tan(x) + 1 / Math.cos(x));
        else if (MyInput.indexOf("csc") != -1) NIResult = -Math.log(Math.cos(x) / Math.sin(x) + 1 / Math.sin(x));
        else NIResult = Math.log(Math.sin(x));
        return NIResult * Coefficient;
    }
    public static void main(String[] args) {
        try {
            input();
        }
        catch(StringIndexOutOfBoundsException e) {}
        System.out.println(Differential());
        System.out.println(Integral());
        System.out.println(NDifferential(x) + " " + NDifferential(y));
        System.out.println(Staticfraction(y) - Staticfraction(x));
    }
}
