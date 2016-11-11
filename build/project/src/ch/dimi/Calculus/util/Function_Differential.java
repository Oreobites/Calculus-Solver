// 이장근 - 다항함수 미분
package ch.dimi.Calculus.util;

public class Function_Differential {
	//각차수의미지수의계수를저장하는배열
	//차수가높은순서대로index 0번째부터저장된다. 
	static double[] expo = new double[100];
	static double[] Best = new double[100];

	static double[] expo1 = new double[100];
	static double[] Best1 = new double[100];

	static double VALUE1;
	static double VALUE2;
	
	static String plz;
	
	static int cnt;
	
	public static void input(String func, double Value){
		 cnt = setBase(func); //규남아 니 식을 Calculator 안에 넣으면 되.
		 plz = calcUp(cnt);  //미분 계산 // 미분된 식을 plz로 리턴했음.
		 VALUE1 = value1(Value); //VALUE는 미분된 식에 값을 대입한것, Value 안에 대입할 수 넣으면 되.
		 VALUE2 = value2(func, Value); //VALUE2에 원래식에 값을 넣었을떄 바로 나오는 값..이 반환될꺼야.
	}
	
	public static double value2(String exp, double Value) //바로 갖다주려구요 식에 값대입
	{
		int index = 0;
		int index_a = 0;
		double Mainvalue = 1;
		boolean isExistX = false;
		
		for (int i = 0; i < exp.length(); i++) {
			char cur = exp.charAt(i);
			if (cur == 'x') 
			{
				isExistX = true;
				break;
			}
		}
		
		if(isExistX)
		{
			if (exp.charAt(0) == 'x') {
				//계수가 1일 경우는 따로 처리한다. 
				expo1[index] = 1;
			}
			else {
				String[] array;
				array = exp.split("x"); //array[0]가 계수가 1이 아닐때에 계수가 된다.
				//계수가 1이 아닌 경우는 char 값을 int 값으로 저장한다.
				expo1[index] = Double.parseDouble(array[0]);
			}
		}
		else if(isExistX == false)   { expo1[index] = Double.parseDouble(exp);}
		//ㄹㅇ 최고차항의 수가 담긴것 index는 항의 계수에 불과하다.
		   for (int  j= 0; j < exp.length(); j++) {
		    	int a = exp.length();
			char Cbar = exp.charAt(j);
			if(Cbar == '^') {Best1[index_a] = (exp.charAt(j+1) - 48); index_a++; break; } 
			else if(exp.charAt(a-1) == 'x') {Best1[index_a] = 1; index_a++; break;}// 이 break도 단항식 하나만 받아오다 보니 생긴 상황입니다.
		}	
		for(int i = 0; i < Best1[0]; i++){
		    Mainvalue *= Value;
		}
		return Mainvalue * expo1[0]; 
	}
	
	public static int setBase(String exp) {
		//상수항을 제외한 각 항의 계수를 expo 배열에 저장한다.
		int index = 0;
		int index_a = 0;
		boolean isExistX = false;
		
		for (int i = 0; i < exp.length(); i++) {
			char cur = exp.charAt(i);
			if (cur == 'x') 
			{
				isExistX = true;
				break;
			}
		}
		
		if(isExistX)
		{
			if (exp.charAt(0) == 'x') {
				//계수가 1일 경우는 따로 처리한다. 
				expo[index] = 1;
			}
			else {
				String[] array;
				array = exp.split("x"); //array[0]가 계수가 1이 아닐때에 계수가 된다.
				//계수가 1이 아닌 경우는 char 값을 int 값으로 저장한다.
				expo[index] = Double.parseDouble(array[0]);
			}
		}
		else if(isExistX == false)   { expo[index] = Double.parseDouble(exp);}
		//ㄹㅇ 최고차항의 수가 담긴것 index는 항의 계수에 불과하다.
		   for (int  j= 0; j < exp.length(); j++) {
		    	int a = exp.length();
			char Cbar = exp.charAt(j);
			if(Cbar == '^') {Best[index_a] = (exp.charAt(j+1) - 48); index_a++; break; } 
			else if(exp.charAt(a-1) == 'x') {Best[index_a] = 1; index_a++; break;}// 이 break도 단항식 하나만 받아오다 보니 생긴 상황입니다.
		}	
		return index_a;
		 
	}
	
	public static String calcUp(int cnt){ // cnt = 최고차항의 계수 
		//부정적분 계산 //원래는 x 일때는 ^ 뺴야 하지만 신속함을 위해 입력시 ^도 같이 입력하여 실행한다 - 업뎃전
		int index;
		for (int i = 0; i <= cnt; i++) {
			expo[i] = expo[i] * (Best[i]);
		}
		double Gaesu = expo[0];
		double RGaesu = Math.round(Gaesu*100d)/100d; // 위두줄은 소수 둘째짜리 출력을 위해 만듬.//규남아 소수점이 불편하다면 이걸 고치도록 해요
		if(Best[0] != 0) 
			{
			  if(Best[0]-1 == 1)
			  {
				  System.out.println(RGaesu + "x");
				  String a,b;
				  a = Double.toString(RGaesu);
				  b = a+"x";
				  return b;
			  }
			  else if(Best[0] - 1 == 0) 
			  {
				  System.out.println(RGaesu);
				  String a = Double.toString(RGaesu);
				  return a;
			  }
			  else 
			  {
				  System.out.println(RGaesu + "x^"+ (int)(Best[0]-1));
				  String a,b,c;
				  a = Double.toString(RGaesu);
				  b = Integer.toString((int)(Best[0]-1));
				  c = a+"x^"+b;
				  return c;
			  }
			}
		else {
		System.out.println(0);
		String a,b;
		a = Integer.toString(0);
		return a;
		}
	}
	public static double value1(double Value){
		double value = 1;
		double Real = 0;
		double Gaesu = expo[0];
		double RGaesu = Gaesu;
		//Math.round(Gaesu*100d)/100d; // 앞줄은 소수 둘째짜리 출력을 위해 만듬.//주석 쳤으니 주루룩 나올꺼야.
		if(Best[0] != 0) 
			{
			  if(Best[0]-1 == 1)
			  {
				  return (RGaesu * Value);
			  }
			  else if(Best[0] - 1 == 0) 
			  {
				  return RGaesu;
			  }
			  else 
			  {
				  for(int i = 0; i < (int)(Best[0]-1); i++){
					  value *= Value;
				  }
				  Real = (value*RGaesu);
				  return Real;
			  }
			}
		else {
		return 0;
		}
	}
}
//최고차항에 소수를 집어넣을꺼 같진 않아서 int형으로 처리했어.