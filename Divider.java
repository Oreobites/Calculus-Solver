public class Calculator {
    public static String[] expo = new String[1000];
    public static char[] Operator = new char[1000];
    public static int setBase(String exp) {
        int i, p = 0, cnt = 0, depth = 0;
        for (i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) == '(') depth ++;
            if (exp.charAt(i) == ')') depth --;
            if ((exp.charAt(i) == '+' || exp.charAt(i) == '-') && depth == 0) {
                expo[cnt] = exp.substring(p, i);
                p = i + 1;
                Operator[cnt] = exp.charAt(i);
                cnt++;
            }
        }
        expo[cnt] = exp.substring(p, i);
        return cnt;
    }
    public static void main(String[] args) {
        String exp = "sinx*cosx/4+ln(x+1)-2^(2x+1)";
        int cnt = setBase(exp);
        for(int i = 0; i <= cnt; i++) System.out.print(expo[i] + " ");
        System.out.println();
        for(int i = 0; i < cnt; i++) System.out.print(Operator[i] + " ");
    }
}