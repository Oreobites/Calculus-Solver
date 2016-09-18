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
		System.out.print("C, ");
		System.out.println("(최고차항의 차수 : " + (cnt + 1) + ")");
	}
	
	public static double power(int a, int b) {
		//a의 b제곱 반환
		double result = 1;
		for (int i = 0; i < b; i++) result *= a;
		return result;
	}
	
	public static double topos(double a) {
		//a의 절댓값 반환
		if (a > 0) return a;
		else return a * (-1);
	}
	
	public static double polynomial(double[] expo, int cnt, int start, int end) {
		//위끝, 아래끝 대입 결과 저장
		double tmp_start = 0;
		double tmp_end = 0;
		double result = 0;
		
		for (int i = 0; i <= cnt; i++) {
			tmp_end += expo[i] * power(end, cnt + 1 - i);
			tmp_start += expo[i] * power(start, cnt + 1 - i);
		}
		
		//절대값
		result = topos(tmp_end - tmp_start);
		
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
	
	public static void printResult(double result) {
		//정수 부분과 소수 부분 분리
		int intPart = (int)result;
		double doublePart = result - intPart;
		
		//Wrapper를 이용해 int와 double을 String으로 변환
		String intPartStr = Integer.toString(intPart);
		String doublePartStr = Double.toString(doublePart);
		
		//출력
		System.out.print("적분 결과 : ");
		System.out.println(intPartStr + doublePartStr.substring(1,5));
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
	
		//부정적분 계산
		int cnt = setBase(expo, exp);
		calcUp(expo, cnt);
		
		//부정적분에 값 대입 (정적분 계산)
		result = polynomial(expo, cnt, start, end);
		
		//소수점 3자리까지만 출력
		printResult(result);
	}

}
