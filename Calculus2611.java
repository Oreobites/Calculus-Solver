package teamProject;

public class Calculus2611 {

	public static int setBase(double[] expo, String exp) {
		
		//상수항을 제외한 각 항의 계수를 expo 배열에 저장한다.
		int index = 0;
		for (int i = 0; i < exp.length(); i++) {
			char cur = exp.charAt(i);
			if (cur == 'x') {
				if (exp.charAt(i-1) == '+') {
					//계수가 1일 경우는 따로 처리한다.
					expo[index] = 1;
				} else {
					//계수가 1이 아닌 경우는 char 값을 int 값으로 저장한다.
					expo[index] = ( exp.charAt(i - 1) - 48 );
				}
				index++;
			}
		}
		
		//상수항을 expo 배열의 맨 마지막에 저장한다.
		expo[index] = (exp.charAt(exp.length()-1)-48);
		
		System.out.print("입력된 계수(높은 차수 순) : ");
		for (int i = 0; i <= index; i++) {
			System.out.print(expo[i] + ", ");
		}
		System.out.println("(최고차항의 차수 : " + index + ")");
		
		return index;
		 
	}
	
	public static void calcUp(double[] expo, int cnt) {
		//부정적분 계산
		int index;
		
		for (int i = 0; i <= cnt; i++) {
			index = cnt - i;
			expo[i] = expo[i] / (index + 1);
		}
		
		System.out.print("적분된 계수(높은 차수 순) : ");
		for (int i = 0; i <= cnt; i++) {
			System.out.print(expo[i] + ", ");
		}
		System.out.println("C");
	}
	
	public static double polymonial(double[] expo, int cnt, int start, int end) {
		double result = 0;
		for (int i = 0; i <= cnt; i++) {
			
		}
		return result;
	}
	
	public static double triangle(double[] expo, int cnt, int start, int end) {
		double result = 0;
		return result;
	}
	
	public static double exponent(double[] expo, int cnt, int start, int end) {
		double result = 0;
		return result;
	}
	
	public static void main(String[] args) {
		
		// 추후 exp는 '2x^4+x^3+3x^2+4x+5' 형태로 사용자에게 입력받는다.
		// 테스트 위해 exp, start, end는 미리 지정함
		String exp = "2x^4+x^3+3x^2+4x+5";
		int start = 3, end = 4;
		double result;
		
		//각 차수의 미지수의 계수를 저장하는 배열
		//차수가 높은 순서대로 index 0번째부터 저장된다.
		double[] expo = new double[100];
	
		int cnt = setBase(expo, exp);
		calcUp(expo, cnt);
		result = polymonial(expo, cnt, start, end);
		System.out.println("적분 결과 : " + result);
	}

}
