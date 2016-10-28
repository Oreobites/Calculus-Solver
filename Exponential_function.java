package teamProject;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;


public class Exponential_function {
	
	public static void input(){
		Scanner sc = new Scanner(System.in);
		
		String calculus = sc.nextLine();
		//y= n ^x (n은 실수)의 형태로 입력한다.
		String calculus_trim=calculus.trim();  //앞 뒤 공백 제거해서 calculus_trim에 값을 넣는다.
		//char[] arr = calculus_trim.toCharArray(); //문자열을 문자형 하나하나 저장.
		
		int n=0;
			
		// ^ = 94
		// + = 43
		// e = 101
		// x = 120
		// * = 42
		// - = 45
		
		for(int i=0;i<calculus_trim.length();i++) {
			if(calculus_trim.charAt(i)==94)
				n++;
		}
		
		if(n==1) //^가 1개 있을 떄
			System.out.println(expo_1(calculus_trim));
		else  //^가 2개 이상 있을 떄
			System.out.println(expo_2(calculus_trim));
		
		
		
	}
	
	public static String expo_1(String arr) {  //+가 없는 n^x의 단순한 형태 
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
					result += "-";
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
						if(arr.charAt(i)==45)
							continue;
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
					for(int i=k+1; i<arr.length(); i++) {
						if(arr.charAt(i)==120)
							break;
						if(arr.charAt(i)==45)
							continue;
						result += arr.charAt(i); 
					}
					for(int i=0; i<k ;i++) {
						if(i==0)
							result += "*ln";
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
					result += "-";
					for(int i=k+1; i<arr.length(); i++) {
						if(arr.charAt(i)==120)
							break;
						if(arr.charAt(i)==45)
							continue;
						result += arr.charAt(i); 
					}
					for(int i=0; i<k ;i++) {
						if(i==0)
							result += "*ln";
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
							result+="ln";
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
					result += "-";
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
			if(48<=arr.charAt(c+1) && arr.charAt(c+1) <= 57) { // n*e^nx
				for(int i=c+1; i<arr.length(); i++) {
					if(arr.charAt(i)==120)
						break;
					if(arr.charAt(i)==45) 
						continue;
					multiple2 += arr.charAt(i);
				}
				d = Integer.parseInt(multiple2);
				b = b*d;
				for(int i=0;i<arr.length();i++) {
					if(arr.charAt(i)==45)
						p++;
				}
				result += Integer.toString(b);
				result += "*";
				for(int i=k+1; i<arr.length() ; i++)
					result += arr.charAt(i);
			}else { //n*e^x
				result += arr;
			}
			
		}else { //자연로그가 아닌 자연수
			if(48<=arr.charAt(c+1) && arr.charAt(c+1) <= 57) { //n*n^nx
				for(int i=c+1; i<arr.length() ; i++) {
					if(arr.charAt(i)==120)  //x이면 멈춤
						break;
					multiple2 += arr.charAt(i);
				}
				d= Integer.parseInt(multiple2);
				b = b*d;
				result += Integer.toString(b);
				result += "*";
				multiple2 = "";
				for(int i=k+1; i<c ; i++) //*부터 ^까지 돌림
					multiple2 += arr.charAt(i);
				result += "ln";
				result += multiple2;
				result += "*";
				for(int i=k+1; i<arr.length() ; i++)
					result += arr.charAt(i);
				
			}else { //n*n^x
				result += Integer.toString(b);
				result += "*ln";
				for(int i=k+1; i<c ; i++)
					result += arr.charAt(i);
				result += "*";
				for(int i=k+1 ; i<arr.length() ; i++) 
					result += arr.charAt(i);
					
				
			}
		}
		
	}
		
		return result;
		
		
} 
	public static String expo_2(String arr) { //+가 1개 이상 있는 계산식
		String result = "";
		String multiple = "";
		String multiple2 = "";
		int a=0, n_1 = 0, z_1=0, z_2=0, m=0, s=0, f=0, p=0; //n_1은 ^의 개수 카운트, n_2은 +의 개수 카운트, a는 앞에 *가 있는지 없는지 판단할 때 쓰고, z는 *앞에 있는 상수 저장
		boolean d = false;  //m은 *위치, s는 이중 for문 j 초기값, f는 이중 for문 j범위
		
		
		int[] k_2 = new int[99]; //+의 개수만큼 +의 위치를 저장할 int 배열 선언
		
		for(int i=0;i<arr.length();i++) {
			if(arr.charAt(i)==43 || arr.charAt(i)==45) {
				k_2[n_1] = i;
				n_1++;
			}
		} //k_2의 각 방에 +위치, -위치 저장
		
		n_1 = 0; //값 초기화
		
		int[] k_1 = new int[99];
		
		for(int i=0;i<arr.length();i++) {
			if(arr.charAt(i)==94) { //^의 위치 확인 
				k_1[n_1] = i;
				n_1++;
			}
		} //k_1의 각 방에 ^위치 저장
		n_1--;
		
		for(int i=0;i<=n_1;i++) {
			a=0; //a=0으로 초기화 
			d=false; //d는 false로 초기화한다.
			multiple = ""; //multiple 초기화
			multiple2 = "";
			z_1=0;
			z_2=0;
			m=0;
			p=0;
			if(i==0)
				s=0;
			else 
				s=k_2[i-1]+1;
			
			if(i==n_1)
				f=arr.length();
			else 
				f=k_2[i];
			if(i==n_1) {
				for(int j=s;j<f-1;j++) {
					if(arr.charAt(j)==45)
						p++;
				}
			} else {
				for(int j=s;j<=f;j++) {
					if(arr.charAt(j)==45)
						p++;
				} 
			}
			for(int j=s;j<f;j++) { 
				if(arr.charAt(j) == 42)
					a++; // 앞에 *가 있는지 없는지 구분
			}
			if(a==0) { //*없으면
				for(int j=s;j<f;j++) {
					if(arr.charAt(j)==101)
						d=true; //자연로그이면 true를 준다.
				}
				
				if(d) { //지수가 자연로그이면
					if(48<=arr.charAt(k_1[i]+1) && arr.charAt(k_1[i]+1) <= 57) { //e^nx이면
						for(int j=k_1[i]+1;j<f;j++) {
							if(arr.charAt(j)==120) 
								break;
							result += arr.charAt(j);
						}
						result += "*";
						for(int j=s;j<f;j++) {
							if(arr.charAt(j)==0x20) //공백이면
								continue;
							else
								result += arr.charAt(j);
						}
					} else { //e^x이면
						for(int j=s;j<f;j++) {
							if(arr.charAt(j)==0x20)
								continue;
							else
								result += arr.charAt(j);
						}
					}		
				} else {
					if(48<=arr.charAt(k_1[i]+1) && arr.charAt(k_1[i]+1) <= 57) { //2^2x
						for(int j=k_1[i]+1 ; j<f;j++) {
							if(arr.charAt(j)==120)
								break;
							result += arr.charAt(j);
						}
						result += "*ln";
						for(int j=s;j<k_1[i];j++) {
							if(arr.charAt(j)==0x20)
								continue;
							else
								result += arr.charAt(j);
						}
						result += "*";
						for(int j=s;j<f;j++) {
							if(arr.charAt(j)==0x20)
								continue;
							else
								result += arr.charAt(j);
						}
					} else { //2^x
						for(int j=s;j<k_1[i];j++) {
							if(j==s)
								result += "ln";
							if(arr.charAt(j)==0x20)
								continue;
							else
								result += arr.charAt(j);
						}
						result += "*";
						for(int j=s;j<f;j++) {
							if(arr.charAt(j)==0x20)
								continue;
							else
								result += arr.charAt(j);
						}
					}
				}	
			} else {  //*있으면
				for(int j=s;j<f;j++) {
					if(arr.charAt(j)==101)
						d = true; //e가 있는지 없는지 판단한다.
				}
				for(int j=s;j<k_1[i];j++) {
					if(arr.charAt(j)==42) 
						break;
					if(arr.charAt(j)==43)
						continue;
					multiple += arr.charAt(j); //*앞에 있는 상수를 multiple에 저장
				}
				z_1 = Integer.parseInt(multiple.replaceAll("\\D+", "")); //*앞에 있는 상수를 Int형으로 바꿔서 저장	
				if(d) { //자연로그
					if(48 <= arr.charAt(k_1[i]+1) && arr.charAt(k_1[i]+1) <= 57) { // n*e^nx
						for(int j=k_1[i]+1;j<f;j++) {
							if(arr.charAt(j)==120)
								break;
							multiple2 += arr.charAt(j);
						}
						z_2 = Integer.parseInt(multiple2.replaceAll("\\D+", ""));
						z_1 = z_1 * z_2;
						
						//여기서 뭔가 에러가 있다.. 시발 한 번 찾아보자..
						result += Integer.toString(z_1);
						result += "*";
						for(int j=s;j<f;j++) {
							if(arr.charAt(j)==42)
								m=j;
						}
						for(int j=m+1;j<f;j++) {
							if(arr.charAt(j)==0x20)
								continue;
							else
								result += arr.charAt(j);
						}
					} else { //n*e^x
						for(int j=s; j<f; j++) {
							if(arr.charAt(j)==0x20)
								continue;
							else
								result += arr.charAt(j);
						}
					}
				} else { //자연수
					if(48 <= arr.charAt(k_1[i]+1) && arr.charAt(k_1[i]+1) <= 57) { //n*2^nx
						for(int j=k_1[i]+1 ;j<f;j++) {
							if(arr.charAt(j)==120)
								break;
							multiple2 += arr.charAt(j);
						}
						z_2 = Integer.parseInt(multiple2.replaceAll("\\D+", ""));
						z_1 = z_1 * z_2;
						result += Integer.toString(z_1);
						result += "*ln";
						for(int j=s;j<k_1[i];j++) {
							if(arr.charAt(j)==42) {
								m = j; //*위치 저장
								break;
							}
						}
						for(int j=m+1;j<k_1[i];j++) {
							if(arr.charAt(j)==0x20)
								continue;
							else
							 result+=arr.charAt(j);
						}
						result += "*";
						for(int j=m+1;j<f;j++) {
							if(arr.charAt(j)==0x20)
								continue;
							else
								result+=arr.charAt(j);
						}
					} else { //n*2^x
						result += multiple;
						result += "*ln";
						for(int j=s;j<k_1[i];j++) {
							if(arr.charAt(j)==42) {
								m=j; //*위치 저장
 								break;
							}
						}
						for(int j=m+1;j<k_1[i];j++) {
							if(arr.charAt(j)==0x20)
								continue;
							else
								result+=arr.charAt(j);
						}
						result += "*";
						for(int j=m+1;j<f;j++) {
							if(arr.charAt(j)==0x20)
								continue;
							else
								result+=arr.charAt(j);
						}
					}
							
				}
			} //i==0일 때 if문 		bn.,
			if(i==n_1)
				break;
			if(p==0)
				result += " + ";
			else
				result += " - ";
	}
	
		return result;
		
}
	
	public double differential_1(String arr) {
		double value = 0;
		
		return value;
	}
 
	public static void main(String[] args) {
			try {
				input();
			}catch(StringIndexOutOfBoundsException e) {}
	}

}