//이지훈
package ch.dimi.Calculus.util;

public class Exponential_function {

	public static String differential(String func) {
		String calculus = func;
		// y= n ^x (n은 실수)의 형태로 입력한다.

		calculus = calculus.trim(); // 앞 뒤 공백 제거해서 calculus_trim에 값을 넣는다.
		// char[] arr = calculus.toCharArray(); //문자열을 문자형 하나하나 저장.

		// ^ = 94
		// + = 43
		// e = 101
		// x = 120
		// * = 42
		// - = 45

		/*
		 * 
		 * for(int i=0;i<calculus.length();i++) { if(calculus.charAt(i)==94)
		 * n++; }
		 * 
		 * if(n==1) //^가 1개 있을 떄 System.out.println(expo_1(calculus)); else //^가
		 * 2개 이상 있을 떄 System.out.println(expo_2(calculus));
		 * 
		 */

		return expo_1(calculus);
	}

	public static String expo_1(String arr) { // +가 없는 n^x의 단순한 형태
		int k = 0, a = 0, b = 0, c = 0, d = 0, p = 0; // b, c, d변수는 *일 때 사용한다.
														// p는 마이너스
		boolean n = false, g = false; // e인지 n인지 구분, d는 ^뒤에 -있을 때 사용
		String result = "";
		String multiple = ""; // *일 때 사용하는 변수
		String multiple2 = ""; // *일 때 사용하는 변수

		for (int i = 0; i < arr.length(); i++) {
			if (arr.charAt(i) == 42) // 앞에 *가 있는지 없는지 구분
				a++;
		}

		if (a == 0) { // 이 부분은 앞에 *가 없을 때
			for (int i = 0; i < arr.length(); i++) {
				if (arr.charAt(i) == 101)
					n = true; // 자연로그인지 아닌지
			}

			if (n) { // 자연로그이면
				for (int i = 0; i < arr.length(); i++) {
					if (arr.charAt(i) == 94) // ^위치 확인
						k = i;
				}
				for (int i = k; i < arr.length(); i++) {
					if (48 <= arr.charAt(i) && arr.charAt(i) <= 57)
						g = true;
				}

				if (g) { // e^nx
					for (int i = 0; i < arr.length(); i++) {
						if (arr.charAt(i) == 45)
							p++;
					}
					if (p % 2 == 0) {
						for (int i = k + 1; i < arr.length(); i++) {
							if (arr.charAt(i) == 120)
								break;
							if (arr.charAt(i) == 45)
								continue;
							result += arr.charAt(i);
						}
						result += "*";
						for (int i = 0; i < arr.length(); i++) {
							if (arr.charAt(i) == 45) {
								if (i < k)
									continue;
							}
							result += arr.charAt(i);
						}
					} else {
						result += "-";
						for (int i = k + 1; i < arr.length(); i++) {
							if (arr.charAt(i) == 120)
								break;
							if (arr.charAt(i) == 45)
								continue;
							result += arr.charAt(i);
						}
						result += "*";
						for (int i = 0; i < arr.length(); i++) {
							if (arr.charAt(i) == 45) {
								if (i < k)
									continue;
							}
							result += arr.charAt(i);
						}
					}

				} else { // e^x
					for (int i = 0; i < arr.length(); i++) {
						if (arr.charAt(i) == 45)
							p++;
					}
					if (p % 2 == 0) {
						for (int i = 0; i < arr.length(); i++) {
							if (arr.charAt(i) == 45)
								continue;
							result += arr.charAt(i);
						}
					} else {
						for (int i = 0; i < arr.length(); i++) {
							if (arr.charAt(i) == 45) {
								if (i > k)
									result += "-";
							}
						}
						result += arr;
					}

				}

			} else { // 자연로그가 아닌 자연수이면
				for (int i = 0; i < arr.length(); i++) {
					if (arr.charAt(i) == 94)
						k = i;
				}
				for (int i = k; i < arr.length(); i++) {
					if (48 <= arr.charAt(i) && arr.charAt(i) <= 57)
						g = true;
				}
				if (g) { // 2^2x
					for (int i = 0; i < arr.length(); i++) {
						if (arr.charAt(i) == 45)
							p++;
					}
					if (p % 2 == 0) {
						for (int i = k + 1; i < arr.length(); i++) {
							if (arr.charAt(i) == 120)
								break;
							if (arr.charAt(i) == 45)
								continue;
							result += arr.charAt(i);
						}
						for (int i = 0; i < k; i++) {
							if (i == 0)
								result += "*ln";
							if (arr.charAt(i) == 45)
								continue;
							result += arr.charAt(i);
						}
						result += "*";
						for (int i = 0; i < arr.length(); i++) {
							if (arr.charAt(i) == 45) {
								if (i < k)
									continue;
							}
							result += arr.charAt(i);
						}
					} else {
						result += "-";
						for (int i = k + 1; i < arr.length(); i++) {
							if (arr.charAt(i) == 120)
								break;
							if (arr.charAt(i) == 45)
								continue;
							result += arr.charAt(i);
						}
						for (int i = 0; i < k; i++) {
							if (i == 0)
								result += "*ln";
							if (arr.charAt(i) == 45)
								continue;
							result += arr.charAt(i);
						}
						result += "*";
						for (int i = 0; i < arr.length(); i++) {
							if (arr.charAt(i) == 45) {
								if (i < k)
									continue;
							}
							result += arr.charAt(i);
						}
					}
				} else { // 2^x
					for (int i = 0; i < arr.length(); i++) {
						if (arr.charAt(i) == 45)
							p++;
					}
					if (p % 2 == 0) {
						for (int i = 0; i < k; i++) {
							if (i == 0)
								result += "ln";
							if (arr.charAt(i) == 45)
								continue;
							result += arr.charAt(i);
						}
						result += "*";
						for (int i = 0; i < arr.length(); i++) {
							if (arr.charAt(i) == 45) {
								if (i < k)
									continue;
							}
							result += arr.charAt(i); // 몰라 여기서 오류났어 고쳐보자 시발
						}
					} else {
						result += "-";
						for (int i = 0; i < k; i++) {
							if (i == 0)
								result += "ln";
							if (arr.charAt(i) == 45)
								continue;
							result += arr.charAt(i);
						}
						result += "*";
						for (int i = 0; i < arr.length(); i++) {
							if (arr.charAt(i) == 45) {
								if (i < k)
									continue;
							}
							result += arr.charAt(i);
						}

					}
				}
			}
		} else { // 앞에 상수가 곱해져 있을 때
			for (int i = 0; i < arr.length(); i++) {
				if (arr.charAt(i) == 94)
					c = i; // ^ 위치를 기억
			}
			for (int i = 0; i < arr.length(); i++) {
				if (arr.charAt(i) == 42)
					k = i; // * 위치를 기억
			}
			for (int i = 0; i < k; i++) {
				if (arr.charAt(i) == 45)
					continue;
				multiple += arr.charAt(i);
			}
			b = Integer.parseInt(multiple);
			for (int i = 0; i < arr.length(); i++) {
				if (arr.charAt(i) == 101)
					n = true;
			}
			if (n) { // 자연로그
				if (48 <= arr.charAt(c + 1) && arr.charAt(c + 1) <= 57) { // n*e^nx
					for (int i = c + 1; i < arr.length(); i++) {
						if (arr.charAt(i) == 120)
							break;
						if (arr.charAt(i) == 45)
							continue;
						multiple2 += arr.charAt(i);
					}
					d = Integer.parseInt(multiple2);
					b = b * d;
					for (int i = 0; i < arr.length(); i++) {
						if (arr.charAt(i) == 45)
							p++;
					}
					result += Integer.toString(b);
					result += "*";
					for (int i = k + 1; i < arr.length(); i++)
						result += arr.charAt(i);
				} else { // n*e^x
					result += arr;
				}

			} else { // 자연로그가 아닌 자연수
				if (48 <= arr.charAt(c + 1) && arr.charAt(c + 1) <= 57) { // n*n^nx
					for (int i = c + 1; i < arr.length(); i++) {
						if (arr.charAt(i) == 120) // x이면 멈춤
							break;
						multiple2 += arr.charAt(i);
					}
					d = Integer.parseInt(multiple2);
					b = b * d;
					result += Integer.toString(b);
					result += "*";
					multiple2 = "";
					for (int i = k + 1; i < c; i++) // *부터 ^까지 돌림
						multiple2 += arr.charAt(i);
					result += "ln";
					result += multiple2;
					result += "*";
					for (int i = k + 1; i < arr.length(); i++)
						result += arr.charAt(i);

				} else { // n*n^x
					result += Integer.toString(b);
					result += "*ln";
					for (int i = k + 1; i < c; i++)
						result += arr.charAt(i);
					result += "*";
					for (int i = k + 1; i < arr.length(); i++)
						result += arr.charAt(i);

				}
			}

		}
		System.out.println("Exponential_function.expo_1 - 미분 완료된 단항식 : " + result);
		return result;
	}

	public static double getExponentialSpecificValue(String func, double value) {
		//ln2*2^x 형태로 함수를 받는다.
		//TODO 3*ln2*2^x의 경우.
		double multiply = 1;
		double result = 0;
		int multiplySymbolIndex = func.indexOf('*');
		
		// 계수가 있을 경우 multiply의 값을 계수로 변경하고, 함수에서 계수를 제거함
		if (multiplySymbolIndex != -1) {
			String multiplyCandidate = func.substring( 0, multiplySymbolIndex );
			System.out.println("getExponentialSpecificValue - multiplyCandidate의 값 : " + multiplyCandidate);
			if (multiplyCandidate.contains("ln")) {
				String lnRemoved = multiplyCandidate.substring(2); //예를 들어 ln3 의 경우, ln을 제외한 숫자 부분만 추림
				int parsed = Integer.parseInt(lnRemoved);
				multiply = Math.log(parsed);
				func = func.substring(multiplySymbolIndex + 1);
			} else {
				multiply = (double) Integer.parseInt(multiplyCandidate);
			}
		} 
		
		
		double mit;
		int jisu;
		int powSymbolIndex = func.indexOf('^');
		int xIndex = func.indexOf('x');
		int eIndex = func.indexOf('e');
		// 밑이 e일 경우 Exception 처리해 수동으로 값 지정
		try {
			mit = (double) Integer.parseInt(func.substring(0, powSymbolIndex));
		} catch (Exception e) {
			try {
				multiply = Double.parseDouble(func.substring(0, eIndex));
			} catch (Exception f) {
				
			}
			mit = 2.71;
		}
		
		
		
		// 지수가 1일 경우 Exception 처리해 수동으로 값 지정
		try {
			jisu = Integer.parseInt(func.substring(powSymbolIndex + 1, xIndex));
		} catch (Exception e) {
			jisu = 1;
		}

		result = multiply * Math.pow(mit, jisu * value);
		
		System.out.println("계산된 계수 값 : " + multiply);
		System.out.println("계수가 제거된 단항식 : " + func);
		System.out.println("계산된 최종 단항식 결과 값 : " + result);
		return result;
	}

}