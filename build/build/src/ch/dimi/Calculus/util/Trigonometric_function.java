//�̰�ȣ
package ch.dimi.Calculus.util;

public class Trigonometric_function {
    
    public static String Differential(String func) { //�̺��� �Լ��� String���� ��ȯ
        String DResult;
        int pos = func.indexOf("*");
        if(pos != -1) DResult = func.substring(0, pos + 1);
        else DResult = "";
        if (func.indexOf("sin") != -1) DResult += "cosx";
        else if (func.indexOf("cos") != -1) DResult += "-sinx";
        else if (func.indexOf("tan") != -1) DResult += "secx*secx";
        else if (func.indexOf("sec") != -1) DResult += "tanx*secx";
        else if (func.indexOf("csc") != -1) DResult += "-cotx*cscx";
        else DResult = "-cscx*cscx";
        return DResult;
    }
    
    public static String Integral(String func) { //�������� (���л�� ����)
        String IResult;
        int pos = func.indexOf("*");
        if(pos != -1) IResult = func.substring(0, pos + 1);
        else IResult = "";
        if (func.indexOf("sin") != -1) IResult += "-cosx";
        else if (func.indexOf("cos") != -1) IResult += "sinx";
        else if (func.indexOf("tan") != -1) IResult += "-ln(cox(x))";
        else if (func.indexOf("sec") != -1) IResult += "ln(tan(x)+sec(x))";
        else if (func.indexOf("csc") != -1) IResult += "-ln(cot(x)+csc(x))";
        else IResult = "-ln(sin(x))";
        return IResult;
    }
    
    public static double NDifferential(String func, double x) { //f(x)�� x�� �־����� f'(x)�� ��ȯ
        double NDResult;
        int pos = func.indexOf("*");
        int Coefficient;
        if(pos != -1) Coefficient = Integer.parseInt(func.substring(0, pos));
        else Coefficient = 1;
        if (func.indexOf("sin") != -1) NDResult = Math.cos(x);
        else if (func.indexOf("cos") != -1) NDResult = -Math.sin(x);
        else if (func.indexOf("tan") != -1) NDResult = 1 / Math.cos(x) / Math.cos(x);
        else if (func.indexOf("sec") != -1) NDResult = Math.sin(x) / Math.cos(x) / Math.cos(x);
        else if (func.indexOf("csc") != -1) NDResult = Math.cos(x) / Math.sin(x) / Math.sin(x);
        else NDResult = -1 / Math.sin(x) / Math.sin(x);
        return NDResult * Coefficient;
    }
    
    public static double Staticfraction(String func, double x) { //�������� �Լ��� ���� ������ ���� ��ȯ
        double NIResult;
        int pos = func.indexOf("*");
        int Coefficient;
        if(pos != -1) Coefficient = Integer.parseInt(func.substring(0, pos));
        else Coefficient = 1;
        if (func.indexOf("sin") != -1) NIResult = -Math.cos(x);
        else if (func.indexOf("cos") != -1) NIResult = Math.sin(x);
        else if (func.indexOf("tan") != -1) NIResult = -Math.log(Math.cos(x));
        else if (func.indexOf("sec") != -1) NIResult = Math.log(Math.tan(x) + 1 / Math.cos(x));
        else if (func.indexOf("csc") != -1) NIResult = -Math.log(Math.cos(x) / Math.sin(x) + 1 / Math.sin(x));
        else NIResult = Math.log(Math.sin(x));
        return NIResult * Coefficient;
    }
    
    public static double Direct(String func, double x) {
        double Result;
        int pos = func.indexOf("*");
        int Coefficient;
        if(pos != -1) Coefficient = Integer.parseInt(func.substring(0, pos));
        else {
            if(func.indexOf("-") != -1) Coefficient = -1;
            else Coefficient = 1;
        }
        if (func.indexOf("sin") != -1) Result = Math.sin(x);
        else if (func.indexOf("cos") != -1) Result = Math.cos(x);
        else if (func.indexOf("tan") != -1) Result = Math.tan(x);
        else if (func.indexOf("sec") != -1) Result = 1 / Math.cos(x);
        else if (func.indexOf("csc") != -1) Result = 1 / Math.sin(x);
        else Result = 1 / Math.tan(x);
        return Result * Coefficient;
    }
}
