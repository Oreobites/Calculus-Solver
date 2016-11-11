//�ڱԳ�
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
		 * Divider �� �̿��� �Է¹��� �Լ��� ���׽����� �ɰ� �� �� ���׽��� dividedFunctions �� �����ϰ�, ��
		 * �����ڸ� dividedOperators �� �����Ѵ�.
		 */
		Divider divider = new Divider();
		divider.setBase(func);
		dividedFunctions = divider.expo;
		dividedOperators = divider.Operator;
		cnt = divider.cnt;

		for (int i = 0; i< cnt; i++) System.out.println(dividedFunctions[i]);
		/*
		 * ������ ����� dividedFunctions �� �Լ� �������� ���� ������ dividedFunctionsProcessed ��
		 * �����Ѵ�.
		 */
		dividedFunctionsProcessed = new String[100];

		for (int i = 0; i <= cnt; i++) {
			System.out.println("integral - ���� ó�� ���� ���׽� : " + dividedFunctions[i]);
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
				System.out.println("���� ����");
				dividedFunctionsProcessed[i] = "error";
				break;
			}

		}

		/*
		 * ������ ���е� ����� String ���·� ��� ���� ���� ���� ������� processedFunction �� �����Ѵ�.
		 */
		for (int i = 0; i <= cnt; i++) {
			System.out.println("integral - ���� ó�� ���� ���׽� : " + dividedFunctionsProcessed[i]);
			processedFunction += dividedFunctionsProcessed[i];
			try {
				processedFunction += dividedOperators[i];
			} catch (ArrayIndexOutOfBoundsException e) {
				// �����ڴ� ���׽��� �������� 1�� �����Ƿ� Exception ó��
			}
		}
	}

	public void differential(String func) {

		/*
		 * Divider �� �̿��� �Է¹��� �Լ��� ���׽����� �ɰ� �� �� ���׽��� dividedFunctions �� �����ϰ�, ��
		 * �����ڸ� dividedOperators �� �����Ѵ�.
		 */
		System.out.println("differential - �޼ҵ� �����");
		
		Divider divider = new Divider();
		divider.setBase(func);
		dividedFunctions = divider.expo.clone();
		dividedOperators = divider.Operator.clone();
		cnt = divider.cnt;
		
		System.out.print("differential - ������ ���׽� ���ʴ�� ��� : ");
		for (int i = 0; i <= cnt; i++) {
			System.out.print("'" + dividedFunctions[i] + "' ");
		}		
		System.out.println();
		
		/*
		 * ������ ����� dividedFunctions �� �Լ� �������� ���� �̺��� dividedFunctionsProcessed ��
		 * �����Ѵ�.
		 */
		for (int i = 0; i <= cnt; i++) {

			System.out.println("differential - �̺� ����ϴ� ���׽� : " + dividedFunctions[i]);

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
				System.out.println("�̺� ����");
				dividedFunctionsProcessed[i] = "error";
				break;

			}

		}

		/*
		 * ������ �̺е� ����� String ���·� ��� ���� ���� �̺� ������� processedFunction �� �����Ѵ�.
		 */
		System.out.print("differential - �̺е� ���׽� ���ʴ�� ��� : ");
		for (int i = 0; i <= cnt; i++) {
			System.out.print("'" + dividedFunctionsProcessed[i] + "' ");
			processedFunction += dividedFunctionsProcessed[i];
			try {
				processedFunction += dividedOperators[i];
			} catch (ArrayIndexOutOfBoundsException e) {
				// �����ڴ� ���׽��� �������� 1�� �����Ƿ� Exception ó��
			}
		}
		System.out.println();
	}

	public String getProcessedFunction() {
		System.out.println("getProcessedFunction - processedFunction ��ȯ��");
		return processedFunction;
	}

	public double getOriginalSpecificValue(double value) {

		
		double result = 0;

		for (int i = 0; i <= cnt; i++) {
			System.out.println("getOriginalSpecificValue - ���԰��� ��� ���� ����ϴ� ���׽� : " + dividedFunctions[i]);

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
				System.out.println("���׽��� ������ �� �� ����");
				dividedFunctionsProcessed[i] = "error";
				break;

			}

		}

		return result;
	}
	
	public double getProcessedSpecificValue(int value) {
		double result = 0;

		for (int i = 0; i <= cnt; i++) {
			System.out.println("getProcessedSpecificValue - ���԰��� ��� ���� ����ϴ� ���׽� : " + dividedFunctionsProcessed[i]);

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
				System.out.println("���׽��� ������ �� �� ����, 'error' ����");
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
		//2x^5 ���·� �Լ��� �޴´�.
		double multiply = 1;
		double result = 0;
		
		int xIndex = func.indexOf('x');
		String multiplyCandidate = func.substring(0, xIndex);
		multiply = Integer.parseInt(multiplyCandidate);
		
		func = func.substring(xIndex); //�Լ����� ����� ������
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
