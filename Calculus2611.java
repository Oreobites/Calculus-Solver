package teamProject;

public class Calculus2611 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Data calculus = new Data();
		calculus.setBase();
	}

}

class Data {

	public void setExpo(int[] expo, String exp) {
		// exp는 '2x^4+x^3+3x^2+4x+5.' 형태로 입력받는다.
		int index = 0;
		for (int i = 0; i < exp.length(); i++) {
			char cur = exp.charAt(i);
			if (cur == 'x') {
				if (exp.charAt(i-1) == '+') expo[index] = 1;
				else expo[index] = (exp.charAt(i-1)-48);
				index++;
			}
		}
		expo[index] = (exp.charAt(exp.length()-1)-48);
		
		for (int i = 0; i < (index+1); i++) System.out.println(expo[i]);
	}
	
	public void setBase() {
		String exp = "2x^4+x^3+3x^2+4x+5";
		int[] expo = new int[100];
		setExpo(expo, exp);
	}
	
	public double triangle(int[] expo) {
		double result = 0;
		return result;
	}
	
	public double exponent(int[] expo) {
		double result = 0;
		return result;
	}
	
}