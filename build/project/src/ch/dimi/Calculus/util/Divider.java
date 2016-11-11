//이건호
package ch.dimi.Calculus.util;

class Divider {
    public String[] expo = new String[1000]; //각각 함수가 저장되어 있음
    public char[] Operator = new char[1000]; //각각 연산자가 저장되어 있음
    public int cnt = 0;
    
    public void setBase(String exp) {
        int i, p = 0, depth = 0;
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
    }
    
    public static void main(String[] args) {
    	
    }
}