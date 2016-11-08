package teamProject;

import java.util.Scanner;

public class Exponential_Integral {
	public static void input() {
		Scanner sc = new Scanner(System.in);
		
		int from = 5;
		
		String calculus = sc.nextLine();
		String calculus_trim = calculus.trim(); //앞 뒤 공백 있으면 제거
		
		System.out.println(Integral(calculus_trim));
		
		
		
	}
	
	public static String Integral(String arr) {  //+가 없는 n^x의 단순한 형태 
		int k=0, a=0, b=0, c=0, d=0, p=0; //b, c, d변수는 *일 때 사용한다. p는 마이너스 
		boolean n = false, g = false; //e인지 n인지 구분, d는 ^뒤에 -있을 때 사용
		String result = "";
		String multiple = ""; //*일 때 사용하는 변수
		String multiple2 =""; //*일 때 사용하는 변수
		String imsi = "";
		
		for(int i=0;i<arr.length();i++) {
			if(arr.charAt(i)==42)  //앞에 *가 있는지 없는지 구분
				a++;
		}
		
		if(a==0) { // 이 부분은 앞에 *가 없을 때
		for(int i=0;i<arr.length();i++) {
			if(arr.charAt(i)==101)
				n=true; //자연로그인지 아닌지
		}
		
		if(n) { //자연로그이면
			for(int i=0; i<arr.length() ; i++) {
				if(arr.charAt(i)==94) //^위치 확인
					k=i;
			}
			for(int i=k;i<arr.length();i++) {
				if(48<=arr.charAt(i) && arr.charAt(i)<=57)
					g = true;
			}
			
			if(g) { //e^nx
				for(int i=0;i<arr.length();i++) {
					if(arr.charAt(i)==45)
						p++;
				}
				if(p%2==0) {
					result += "1/";
					for(int i=k+1; i<arr.length(); i++) {
						if(arr.charAt(i)==120)
							break;
						if(arr.charAt(i)==45)
								continue;
						result += arr.charAt(i);
					}
					result += "*";
					for(int i=0;i<arr.length();i++) {
						if(arr.charAt(i)==45) {
							if(i<k)
								continue;
						}
						result += arr.charAt(i);
					}
				} else {
					result += "-1/";
					for(int i=k+1; i<arr.length(); i++) {
						if(arr.charAt(i)==120)
							break;
						if(arr.charAt(i)==45)
								continue;
						result += arr.charAt(i);
					}
					result += "*";
					for(int i=0;i<arr.length();i++) {
						if(arr.charAt(i)==45) {
							if(i<k)
								continue;
						}
						result += arr.charAt(i);
					}
				}
				
			}else { //e^x
				for(int i=0;i<arr.length();i++) {
					if(arr.charAt(i)==45)
						p++;
				}
				if(p%2==0) {
					for(int i=0;i<arr.length();i++) {
						if(arr.charAt(i)==45) {
							if(i<k)
								continue;
						}
						result += arr.charAt(i);
					}
				}
				else {
					for(int i=0;i<arr.length();i++) {
						if(arr.charAt(i)==45) {
							if(i>k)
								result += "-";
						}
					}
					result += arr;
				}
				
			}
		
		} 
		else { //자연로그가 아닌 자연수이면
			for(int i=0; i<arr.length() ; i++) {
				if(arr.charAt(i) == 94)
					k=i;
			}
			for(int i=k;i<arr.length();i++) {
				if(48<=arr.charAt(i) && arr.charAt(i)<=57)
					g=true;
			}
			if(g) { // 2^2x
				for(int i=0;i<arr.length();i++) {
					if(arr.charAt(i)==45) 
						p++;
				}
				if(p%2==0) {
					result += "1/";
					for(int i=k+1; i<arr.length(); i++) {
						if(arr.charAt(i)==120)
							break;
						if(arr.charAt(i)==45)
							continue;
						result += arr.charAt(i); 
					}
					for(int i=0; i<k ;i++) {
						if(i==0)
							result += "ln";
						if(arr.charAt(i)==45)
							continue;
						result+= arr.charAt(i);
					}
					result += "*";
					for(int i=0;i<arr.length();i++) {
						if(arr.charAt(i)==45) {
							if(i<k)
								continue;
						}
						result += arr.charAt(i);
					}
				} else {
					result += "-1/";
					for(int i=k+1; i<arr.length(); i++) {
						if(arr.charAt(i)==120)
							break;
						if(arr.charAt(i)==45)
							continue;
						result += arr.charAt(i); 
					}
					for(int i=0; i<k ;i++) {
						if(i==0)
							result += "*1/ln";
						if(arr.charAt(i)==45)
							continue;
						result+= arr.charAt(i);
					}
					result += "*";
					for(int i=0;i<arr.length();i++) {
						if(arr.charAt(i)==45) {
							if(i<k)
								continue;
						}
						result += arr.charAt(i);
					}
				}
			}
			else {  //2^x
				for(int i=0;i<arr.length();i++) {
					if(arr.charAt(i)==45) 
						p++;
				}
				if(p%2==0) {
					for(int i=0; i<k ; i++) {
						if(i==0)
							result+="1/ln";
						if(arr.charAt(i)==45)
							continue;
						result += arr.charAt(i);
					}
					result+="*";
					for(int i=0;i<arr.length();i++) {
						if(arr.charAt(i)==45) {
							if(i<k)
								continue;
						}
						result += arr.charAt(i); //몰라 여기서 오류났어 고쳐보자 시발
					}
				} else {
					result += "-1/";
					for(int i=0;i<k;i++) {
						if(i==0)
							result += "ln";
						if(arr.charAt(i)==45)
							continue;
						result += arr.charAt(i);
					}
					result += "*";
					for(int i=0;i<arr.length();i++) {
						if(arr.charAt(i)==45) {
							if(i<k)
								continue;
						}
						result += arr.charAt(i);
					}
					
				}
			}
		}
	}else { // 앞에 상수가 곱해져 있을 때
		for(int i=0; i<arr.length() ; i++) {
			if(arr.charAt(i) == 94)
				c=i; // ^ 위치를 기억
 		}
		for(int i=0; i<arr.length() ; i++) {
			if(arr.charAt(i) == 42) 
				k=i; // * 위치를 기억
		}
		for(int i=0; i<k; i++) {
			if(arr.charAt(i)==45)
				continue;
			multiple += arr.charAt(i);
		}
		b = Integer.parseInt(multiple);
		for(int i=0; i<arr.length(); i++) {
			if(arr.charAt(i)==101)
				n = true;
		}
		if(n) { //자연로그
			for(int i=c;i<arr.length();i++) {
				if(48<=arr.charAt(i) && arr.charAt(i)<=57)
					g=true;
			}
			if(g) { // n*e^nx
				for(int i=0;i<arr.length();i++) {
					if(arr.charAt(i)==45)
						p++;
				}
				if(p%2==0) {
					for(int i=c+1; i<arr.length(); i++) {
						if(arr.charAt(i)==120)
							break;
						if(arr.charAt(i)==45) 
							continue;
						multiple2 += arr.charAt(i);
					}
					d = Integer.parseInt(multiple2);
					b = d/b;
					if(b!=1) {
						result += "1/";
						result += Integer.toString(b);
						result += "*";
					}
					for(int i=k+1; i<arr.length() ; i++) {
						if(arr.charAt(i)==45) {
							if(i<c)
								continue;
						}
						result += arr.charAt(i);
					}
				} else {
					for(int i=c+1; i<arr.length(); i++) {
						if(arr.charAt(i)==120)
							break;
						if(arr.charAt(i)==45) 
							continue;
						multiple2 += arr.charAt(i);
					}
					d = Integer.parseInt(multiple2);
					result += "-";
					b = d/b;
					if(b!=1) {
						result += "1/";
						result += Integer.toString(b);
					}
					if(b!=1)
						result += Integer.toString(b);
					for(int i=k+1; i<arr.length() ; i++) {
						if(arr.charAt(i)==45) {
							if(i<c)
								continue;
						}
						result += arr.charAt(i);
					}
					
				}
			}else { //n*e^x
				for(int i=0;i<arr.length();i++) {
					if(arr.charAt(i)==45) 
						p++;
				}
				if(p%2==0) {
					for(int i=0;i<arr.length();i++) {
						if(arr.charAt(i)==45) {
							if(i<c)
								continue;
						}
						result += arr.charAt(i);
					}
				} else {
					result += "-";
					for(int i=0;i<arr.length();i++) {
						if(arr.charAt(i)==45) {
							if(i<c)
								continue;
						}
						result += arr.charAt(i);
					}
					
				}
			}
			
		}else { //자연로그가 아닌 자연수
			for(int i=c;i<arr.length();i++) {
				if(48<=arr.charAt(i) && arr.charAt(i)<=57)
					g = true;
			}
			if(g) { //n*n^nx
				for(int i=0;i<arr.length();i++) {
					if(arr.charAt(i)==45)
						p++;
				}
				if(p%2==0){
					for(int i=c+1; i<arr.length() ; i++) {
						if(arr.charAt(i)==120)  //x이면 멈춤
							break;
						if(arr.charAt(i)==45)
							continue;
						multiple2 += arr.charAt(i);
					}
					d= Integer.parseInt(multiple2);
					b = d/b;
					multiple2 = "";
					for(int i=k+1; i<c ; i++) //*부터 ^까지 돌림
						multiple2 += arr.charAt(i);
					result += "1/";
					if(b!=1)
						result += Integer.toString(b);
					result+="ln";
					result += multiple2;
					result += "*";
					for(int i=k+1; i<arr.length() ; i++) {
						if(arr.charAt(i)==45) {
							if(i<c)
								continue;
						}
						result += arr.charAt(i);
					}
				} else {
					for(int i=c+1; i<arr.length() ; i++) {
						if(arr.charAt(i)==120)  //x이면 멈춤
							break;
						if(arr.charAt(i)==45)
							continue;
						multiple2 += arr.charAt(i);
					}
					d= Integer.parseInt(multiple2);
					result += "-";
					b = d/b;
					multiple2 = "";
					for(int i=k+1; i<c ; i++) //*부터 ^까지 돌림
						multiple2 += arr.charAt(i);
					result += "1/";
					if(b!=1)
						result += Integer.toString(b);
					result+="ln";
					result += multiple2;
					result += "*";
					for(int i=k+1; i<arr.length() ; i++) {
						if(arr.charAt(i)==45) {
							if(i<c)
								continue;
						}
						result += arr.charAt(i);
					}
					
				}
			}else { //n*n^x
				for(int i=0;i<arr.length();i++) {
					if(arr.charAt(i)==45)
						p++;
				}
				if(p%2==0) {
					result += Integer.toString(b);
					result += "/ln";
					for(int i=k+1; i<c ; i++) {
						if(48<=arr.charAt(i)&&arr.charAt(i)<=57)
							result += arr.charAt(i);
					}
					result += "*";
					for(int i=k+1 ; i<arr.length() ; i++) {
						if(arr.charAt(i)==45) {
							if(i<c)
								continue;
						}
						result += arr.charAt(i);
					}
				} else {
					result += "-";
					result += Integer.toString(b);
					result += "/ln";
					for(int i=k+1; i<c ; i++) {
						if(48<=arr.charAt(i)&&arr.charAt(i)<=57)
							result += arr.charAt(i);
					}
					result += "*";
					for(int i=k+1 ; i<arr.length() ; i++) {
						if(arr.charAt(i)==45) {
							if(i<c)
								continue;
						}
						result += arr.charAt(i);
					}
					
				}
			}
		}
		
	}
		
		return result;
		
		
}
	
	/*public static double getValue(String arr, int from) {
		double result = 0;
		double a=1, b=1, c=1;
		//Math.log(5) = ln5, Math.exp(5) = e^5 
		int length = arr.indexOf('^'), f=arr.lastIndexOf('x');
		int l = 1;
		String multiple = "";
		

		if(arr.contains("ln")) {
			l = arr.lastIndexOf('n');
			for(int i=l+1;i<f;i++) {
				if(48<=arr.charAt(i)&&arr.charAt(i)<=57)
					multiple += arr.charAt(i);
			}
			b = Math.log((double)Integer.parseInt(multiple));
		}
		System.out.println(b);
		for(int i=0;i<f;i++) {
			multiple = "";
			if(arr.charAt(i)==108||arr.charAt(i)==110) // l 혹은 n이면 넘어감
				continue;
			if(arr.charAt(i)==42 || arr.charAt(i)==47) // * / 이면 넘어감 
				continue;
			if(i != 0 && arr.charAt(i-1)==47) { //전 것이 /이면 나눔
				multiple += arr.charAt(i);
				a = a/(double)Integer.parseInt(multiple);
			} else {
				multiple += arr.charAt(i);
				try {
					a = a*(double)Integer.parseInt(multiple);
				}catch(NumberFormatException e) {}
			}
		}
		System.out.println(a);
		a=a*b;
		double mit=1;
		int jisu=1;
		int xIndex = arr.indexOf('x');
		multiple="";
		if(arr.charAt(length-1)==101)
			mit = 2.71;
		else {
			for(int i=arr.lastIndexOf('*')+1;i<length;i++) 
				multiple += arr.charAt(i);
			try {
				mit = (double)Integer.parseInt(multiple);
			}catch(NumberFormatException e) {}
		}
		multiple="";
		if(arr.charAt(length+1)==120) 
			jisu = from;
		else {
			for(int i=length+1;i<arr.length();i++) {
				if(arr.charAt(i)==120)
					break;
				multiple += arr.charAt(i);
			}
			jisu = from*Integer.parseInt(multiple);
		}
		System.out.println(mit);
		System.out.println(jisu);
		
		result = a*Math.pow(mit, jisu * from);
		
		System.out.println("getValue : " + result);
		return result;
	}*/
	
 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();

	}

}