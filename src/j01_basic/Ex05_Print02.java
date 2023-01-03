package j01_basic;

public class Ex05_Print02 {

	   public static void main(String[] args) {
		      
		      float f1 = .10f;   // 0.10, 1.0e-1 => 1*10의 -1승 => 1*1/10
		      float f2 = 1e1f;   // 1*10의 1승 => 10.0, 1.0e1, 1.0e+1
		      float f3 = 3.14e3f; // 3.14*10의 3승 => 3140
		      double d = 1.23456789;
		      
		      // 실수표현 : %f(일반적), %e(지수형식), %g(간단형)
		      System.out.printf("f1=%f, %e, %g \n",f1,f1,f1);
		      System.out.printf("f2=%f, %e, %g \n",f2,f2,f2);
		      System.out.printf("f3=%f, %e, %g \n",f3,f3,f3);
		      
		      System.out.printf("d=%f, %e, %g \n",d,d,d);
		      // %f : 특별히 자리를 지정하지 않았을 때는 소수이하 6자리까지 출력
		      
		      System.out.printf("d=%15.10f  \n",d);
		      // %f 자리수 지정 : 지정된 자릿수 만큼 출력, 전체 15자리 안에서 우측 기준으로 채워지고, 소숫점은 10자리까지 출력, 남는 소수 뒷자리는 0 => d =   1.2345678900
		    
		      // String 타입에서의 출력 .8 -> 왼쪽에서 8글자만 출력
		      String url = "www.greencomputer.com";
		      System.out.printf("[%.8s]%n", url);
		   } //main

		} //class
