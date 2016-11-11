//이장근 - 다항함수 적분
package ch.dimi.Calculus.util;

public class Function_Integral {
	
	 static double[] expo = new double[100];
     static double[] Best = new double[100];
     static int cnt;
     static String plz;
     static double VALUE;
     
   public static void input(String func, double Start, double End){
       cnt = setBase(func); //규남아 니식을 Calculator 대신 넣으면 되.
       plz = calcUp(cnt);  //적분 계산 //plz라는 스트링으로 부정적분식이 반환됨.
       VALUE = value(Start,End); //규남아 대입할 값을 Value에 넣으면 되.//처음값 Start, 끝값 End로!
   }
   
   public static int setBase(String exp) {
      //상수항을 제외한 각 항의 계수를 expo 배열에 저장한다.
      int index = 0;
      int index_a = 0;
      String babe = exp;
      boolean isExistX = false;
      
      for (int i = 0; i < exp.length(); i++) {
         char cur = exp.charAt(i);
         if(cur == 'x')
         {
            isExistX = true;
            break;
         }
      }
         
         
      if (isExistX) 
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
      else if(!isExistX) {expo[index] = Double.parseDouble(exp);  } 
      
      //ㄹㅇ 최고차항의 수가 담긴것 index는 항의 계수에 불과하다.
          for (int  j= 0; j < exp.length(); j++) {
             int a = exp.length();
         char Cbar = exp.charAt(j);
         if(Cbar == '^') {Best[index_a] = (exp.charAt(j+1) - 48); index_a++; break; } 
         else if(exp.charAt(a-1) == 'x') {Best[index_a] = 1; index_a++; break;}// 이 break도 단항식 하나만 받아오다 보니 생긴 상황입니다.
         
            //그냥 x^1 을 그냥 x로 할수는 없을까.... ㅠㅠ
      }   
      return index_a; //72의 단서가..?
       
   }
   
   public static String calcUp(int cnt){ 
      //부정적분 계산 //원래는 x 일때는 ^ 뺴야 하지만 신속함을 위해 입력시 ^도 같이 입력하여 실행한다 - 업뎃전
      int index;
      for (int i = 0; i <= cnt; i++) {
         expo[i] = expo[i] / (Best[i] + 1);
      }
      double Gaesu = expo[0];
      double RGaesu = Gaesu;
            //Math.round(Gaesu*100d)/100d; // 앞에는 소수 둘째짜리 출력을 위해 만듬.//너가 무엇을 원할지 몰라서 주석해놨어. 주욱 더블일꺼야
      if(Best[0] != 0) {
       System.out.println(RGaesu + "x^"+ (int)(Best[0]+1));   
        String a,b,c;
        a = Double.toString(RGaesu);
        b = Integer.toString((int)(Best[0]+1));
        c = a+"x^"+b; 
        return c;
      }
      else 
      {
         System.out.println(RGaesu + "x");
         String a,b,c;
           a = Double.toString(RGaesu);
           b = a+"x";
           return b;
      }
      
   }
   
   public static double value(double Start, double End){
      //double value = 1;
      //double Real = 0;
      double Gaesu = expo[0];
      double StartValue = 0;
      double EndValue = 0;
      double RGaesu = Gaesu;
         //Math.round(Gaesu*100d)/100d; // 위에랑 같은거야 더블로 주루룩
      if(Best[0] != 0) {
         double valueS = 1;
         double valueE = 1;
         for(int i = 0; i < (int)(Best[0]+1); i++){
              valueS *= Start;
              valueE *= End;
           }
           double RealS = 0;
           double RealE = 0;
           RealS = (valueS*RGaesu);
           RealE = (valueE*RGaesu);
           StartValue = RealS;
           EndValue = RealE;
         }
         else 
         {
            StartValue = (RGaesu * Start);
            EndValue = (RGaesu * End);
         }
      return EndValue - StartValue;
         
      }
   
}