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

		for (int i = 0; i< cnt; i++) System.out.println(dividedFunctions[i]);
		/*
		 * 위에서 저장된 dividedFunctions 를 함수 종류별로 각각 적분해 dividedFunctionsProcessed 에
		 * 저장한다.
		 */
		dividedFunctionsProcessed = new String[100];

		for (int i = 0; i <= cnt; i++) {
			System.out.println("integral - 현재 처리 중인 단항식 : " + dividedFunctions[i]);
			switch (getFunctionType(dividedFunctions[i])) {

			case "triangle":
				dividedFunctionsProcessed[i] = Trigonometric_function.Integral(dividedFunctions[i]);
				break;

			case "exponential":
				dividedFunctionsProcessed[i] = Exponential_Integral.Integral(dividedFunctions[i]);
				break;

			case "polynomial":
				Function_Integral.input(dividedFunctions[i], 0, 0);
				dividedFunctionsProcessed[i] = Function_Integral.plz;
				break;
				
			default:
				System.out.println("적분 오류");
				dividedFunctionsProcessed[i] = "error";
				break;
			}

		}

		/*
		 * 위에서 적분된 결과를 String 형태로 모두 합쳐 최종 적분 결과식을 processedFunction 에 저장한다.
		 */
		for (int i = 0; i <= cnt; i++) {
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
				dividedFunctionsProcessed[i] = Trigonometric_function.Differential(dividedFunctions[i]);
				break;

			case "exponential":
				dividedFunctionsProcessed[i] = Exponential_function.differential(dividedFunctions[i]);
				break;

			case "polynomial":
				Function_Differential.input(dividedFunctions[i], 0);
				dividedFunctionsProcessed[i] = Function_Differential.plz;
				break;

			default:
				System.out.println("미분 오류");
				dividedFunctionsProcessed[i] = "error";
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

	public double getOriginalSpecificValue(double value) {

		
		double result = 0;

		for (int i = 0; i <= cnt; i++) {
			System.out.println("getOriginalSpecificValue - 대입값을 얻기 위해 대기하는 단항식 : " + dividedFunctions[i]);

			switch (getFunctionType(dividedFunctions[i])) {

			case "triangle":
				result += Trigonometric_function.Direct(dividedFunctions[i], value);
				break;

			case "exponential":
				result += Exponential_function.getExponentialSpecificValue(dividedFunctions[i], value);
				break;

			case "polynomial":
				result += Function_Differential.value2(dividedFunctions[i], value);
				break;

			default:
				System.out.println("단항식의 종류를 알 수 없음");
				dividedFunctionsProcessed[i] = "error";
				break;

			}

		}

		return result;
	}
	
	public double getProcessedSpecificValue(int value) {
		double result = 0;

		for (int i = 0; i <= cnt; i++) {
			System.out.println("getProcessedSpecificValue - 대입값을 얻기 위해 대기하는 단항식 : " + dividedFunctionsProcessed[i]);

			switch (getFunctionType(dividedFunctionsProcessed[i])) {
			case "triangle":
				result += Trigonometric_function.Direct(dividedFunctionsProcessed[i], value);
				break;

			case "exponential":
				result += Exponential_function.getExponentialSpecificValue(dividedFunctionsProcessed[i], value);
				break;

			case "polynomial":
				result += Function_Differential.value2(dividedFunctionsProcessed[i], value);
				break;

			default:
				System.out.println("단항식의 종류를 알 수 없음, 'error' 저장");
				dividedFunctionsProcessed[i] = "error";
				break;
			}

		}

		return result;
	}
	
	public double getIntegraledValue(int from, int until) {
		double result = 0;
		result = getProcessedSpecificValue(until) - getProcessedSpecificValue(from);
		return result;
	}

	public String getFunctionType(String func) {
		boolean isFuncConstant = true;
		
		try {
			Integer.parseInt(func);
		} catch (Exception e) {
			isFuncConstant = false;
		}
		
		System.out.println("getFunctionType - func : " + func);
		if ( func.contains("sin") || func.contains("cos") || func.contains("tan") || func.contains("csc") || func.contains("sec") || func.contains("cot") ) {
			System.out.println("type : triangle");
			return "triangle";
		} else if (func.contains("^") && !func.contains("x^")) {
			System.out.println("type : exponential");
			return "exponential";
		} else if (func.contains("x^") || isFuncConstant) {
			System.out.println("type : polynomial");
			return "polynomial";
		} else {
			System.out.println("type : error!");
			return "error";
		}	
	}
	
	public double getPolynomialSpecificValue(String func, double value) {
		//2x^5 형태로 함수를 받는다.
		double multiply = 1;
		double result = 0;
		
		int xIndex = func.indexOf('x');
		String multiplyCandidate = func.substring(0, xIndex);
		multiply = Integer.parseInt(multiplyCandidate);
		
		func = func.substring(xIndex); //함수에서 계수를 제거함
		int powSymbolIndex = func.indexOf('^');
		String powNumCandidate = func.substring(powSymbolIndex+1);
		double powNum = Integer.parseInt(powNumCandidate);
		
		result = multiply * Math.pow(value, powNum);
		return result;
	}
	
	public double getPolynomialIntegraledValue(String func, int from, int until) {
		double result = 0;
		result += Function_Differential.value2(func, until) - Function_Differential.value2(func, from);		
		return result;
	}
	
	public double getTrigonometricIntegraledValue(String func, int from, int until) {
		double result = 0;
		result += Trigonometric_function.Direct(func, until) - Trigonometric_function.Direct(func, from);
		return result;
	}
	
	public double getExponentialIntegraledValue(String func, int from, int until) {
		double result = 0;
		result += Exponential_function.getExponentialSpecificValue(func, until) - Exponential_function.getExponentialSpecificValue(func, from);
		return result;
	}

}
