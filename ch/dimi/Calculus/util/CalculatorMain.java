//박규남
package ch.dimi.Calculus.util;

public class CalculatorMain {

	String processedFunction = "";
	String[] dividedFunctions = new String[1000];
	String[] dividedFunctionsProcessed = new String[1000];
	char[] dividedOperators = new char[1000];
	int from;
	int until;
	int cnt;

	public void integral(String func) {

		/*
		 * Divider 를 이용해 입력받은 함수를 단항식으로 쪼갠 후 각 단항식을 dividedFunctions 에 저장하고, 각
		 * 연산자를 dividedOperators 에 저장한다.
		 */
		Divider divider = new Divider();
		divider.setBase(func);
		dividedFunctions = divider.expo;
		dividedOperators = divider.Operator;
		cnt = divider.cnt;

		/*
		 * 위에서 저장된 dividedFunctions 를 함수 종류별로 각각 적분해 dividedFunctionsProcessed 에
		 * 저장한다.
		 */
		dividedFunctionsProcessed = new String[100];

		for (int i = 0; i < cnt; i++) {
			System.out.println("integral - 현재 처리 중인 단항식 : " + dividedFunctions[i]);
			switch (getFunctionType(dividedFunctions[i])) {

			case "triangle":
				// dividedFunctionsProcessed[i] = calcTriangle(func, from,
				// until);
				break;

			case "exponential":
				// dividedFunctionsProcessed[i] = calcExponential(func, from,
				// until);
				break;

			case "log":
				// dividedFunctionsProcessed[i] = calcLog(func, from, until);
				break;

			case "polynomial":
				// dividedFunctionsProcessed[i] = calcPolynomial(func, from,
				// until);
				break;

			default:
				// dividedFunctionsProcessed[i] = "error";
				break;

			}

		}

		/*
		 * 위에서 적분된 결과를 String 형태로 모두 합쳐 최종 적분 결과식을 processedFunction 에 저장한다.
		 */
		for (int i = 0; i < cnt; i++) {
			System.out.println("integral - 현재 처리 중인 단항식 : " + dividedFunctionsProcessed[i]);
			processedFunction += dividedFunctionsProcessed[i];
			try {
				processedFunction += dividedOperators[i];
			} catch (ArrayIndexOutOfBoundsException e) {
				// 연산자는 단항식의 개수보다 1개 적으므로 Exception 처리
			}
		}
	}

	public void differential(String func) {

		/*
		 * Divider 를 이용해 입력받은 함수를 단항식으로 쪼갠 후 각 단항식을 dividedFunctions 에 저장하고, 각
		 * 연산자를 dividedOperators 에 저장한다.
		 */
		System.out.println("differential - 메소드 실행됨");
		
		Divider divider = new Divider();
		divider.setBase(func);
		dividedFunctions = divider.expo.clone();
		dividedOperators = divider.Operator.clone();
		cnt = divider.cnt;
		
		System.out.print("differential - 나눠진 단항식 차례대로 출력 : ");
		for (int i = 0; i <= cnt; i++) {
			System.out.print("'" + dividedFunctions[i] + "' ");
		}		
		System.out.println();
		
		/*
		 * 위에서 저장된 dividedFunctions 를 함수 종류별로 각각 미분해 dividedFunctionsProcessed 에
		 * 저장한다.
		 */
		for (int i = 0; i <= cnt; i++) {

			System.out.println("differential - 미분 대기하는 단항식 : " + dividedFunctions[i]);

			switch (getFunctionType(dividedFunctions[i])) {

			case "triangle":
				// dividedFunctionsProcessed[i] = calcTriangle(func, from,
				// until);
				break;

			case "exponential":
				Exponential_function calculus = new Exponential_function();
				dividedFunctionsProcessed[i] = calculus.calcExponential(dividedFunctions[i]);
				break;

			case "log":
				// dividedFunctionsProcessed[i] = calcLog(func, from, until);
				break;

			case "polynomial":
				// dividedFunctionsProcessed[i] = calcPolynomial(func, from,
				// until);
				break;

			default:
				// dividedFunctionsProcessed[i] = "error";
				break;

			}

		}

		/*
		 * 위에서 미분된 결과를 String 형태로 모두 합쳐 최종 미분 결과식을 processedFunction 에 저장한다.
		 */
		System.out.print("differential - 미분된 단항식 차례대로 출력 : ");
		for (int i = 0; i <= cnt; i++) {
			System.out.print("'" + dividedFunctionsProcessed[i] + "' ");
			processedFunction += dividedFunctionsProcessed[i];
			try {
				processedFunction += dividedOperators[i];
			} catch (ArrayIndexOutOfBoundsException e) {
				// 연산자는 단항식의 개수보다 1개 적으므로 Exception 처리
			}
		}
		System.out.println();
	}

	public String getProcessedFunction() {
		System.out.println("getProcessedFunction - processedFunction 반환함");
		return processedFunction;
	}

	public double getSpecificValue(double value) {

		double result = 0;

		for (int i = 0; i <= cnt; i++) {
			System.out.println("getSpecificValue - 대입값을 얻기 위해 대기하는 단항식 : " + dividedFunctions[i]);

			switch (getFunctionType(dividedFunctions[i])) {

			case "triangle":
				System.out.println("해당 단항식은 아직 값 대입 구현 안 됨");
				// result += getExponentialSpecificValue(dividedFunctions[i],
				// value);
				break;

			case "exponential":
				result += getExponentialSpecificValue(dividedFunctions[i], value);
				break;

			case "log":
				System.out.println("해당 단항식은 아직 값 대입 구현 안 됨");
				// result += getExponentialSpecificValue(dividedFunctions[i],
				// value);
				break;

			case "polynomial":
				System.out.println("해당 단항식은 아직 값 대입 구현 안 됨");
				// result += getExponentialSpecificValue(dividedFunctions[i],
				// value);
				break;

			default:
				System.out.println("단항식의 종류를 알 수 없음");
				// dividedFunctionsProcessed[i] = "error";
				break;

			}

		}

		return result;
	}
	
	public double getDifferentialedValue(int value) {
		double result = 0;

		for (int i = 0; i <= cnt; i++) {
			System.out.println("getDifferentialValue - 대입값을 얻기 위해 대기하는 단항식 : " + dividedFunctionsProcessed[i]);

			switch (getFunctionType(dividedFunctionsProcessed[i])) {

			case "triangle":
				System.out.println("해당 단항식은 아직 값 대입 구현 안 됨");
				// result += getExponentialSpecificValue(dividedFunctionsProcessed[i],
				// value);
				break;

			case "exponential":
				result += getExponentialSpecificValue(dividedFunctionsProcessed[i], value);
				break;

			case "log":
				System.out.println("해당 단항식은 아직 값 대입 구현 안 됨");
				// result += getExponentialSpecificValue(dividedFunctionsProcessed[i],
				// value);
				break;

			case "polynomial":
				System.out.println("해당 단항식은 아직 값 대입 구현 안 됨");
				// result += getExponentialSpecificValue(dividedFunctionsProcessed[i],
				// value);
				break;

			default:
				System.out.println("단항식의 종류를 알 수 없음");
				// dividedFunctionsProcessed[i] = "error";
				break;

			}

		}

		return result;
	}
	
	public double getIntegraledValue(int from, int until) {
		double result = 0;
		result = getSpecificValue(until) - getSpecificValue(from);
		return result;
	}

	public String getFunctionType(String func) {
		if (func.contains("sin") || func.contains("cos"))
			return "triangle";
		else if (func.contains("^"))
			return "exponential";
		else if (func.contains("ln") || func.contains("log"))
			return "log";
		else
			return "polynomial";
	}

	public double getExponentialSpecificValue(String func, double value) {
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
		System.out.println("계산된 계수 값 : " + multiply);
		System.out.println("계수가 제거된 단항식 : " + func);
		
		double mit;
		int jisu;
		int powSymbolIndex = func.indexOf('^');
		int xIndex = func.indexOf('x');
		// 밑이 e일 경우 Exception 처리해 수동으로 값 지정
		try {
			mit = (double) Integer.parseInt(func.substring(0, powSymbolIndex));
		} catch (Exception e) {
			mit = 2.71;
		}

		// 지수가 1일 경우 Exception 처리해 수동으로 값 지정
		try {
			jisu = Integer.parseInt(func.substring(powSymbolIndex + 1, xIndex));
		} catch (Exception e) {
			jisu = 1;
		}

		result = multiply * Math.pow(mit, jisu * value);
		System.out.println("계산된 최종 단항식 결과 값 : " + result);
		return result;
	}

	public double getExponentialIntegraledValue(String func, int from, int until) {
		double result = 0;
		result += getExponentialSpecificValue(func, until) - getExponentialSpecificValue(func, from);
		return result;
	}

	public static void main(String[] args) {

	}

}
