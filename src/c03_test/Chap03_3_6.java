package c03_test;

public class Chap03_3_6 {
	// ** 정석 연습문제 3-6
	// 아래는 화씨 를 섭씨 로 변환하는 코드이다.
	// 변환공식이 (Fahrenheit) (Celcius) . 'C =5/9 ×(F - 32)' 라고 할 때 
	// 에 알맞은 코드를 넣으시오.
	// ★단 변환 결과값은 소수점 셋째자리에서 반올림해야한다. => int로 만들어서 소수 탈락(((결과) * 100(소수셋째자리) + 0.5(반올림 하는 효과))) / 100f(*100을 원래대로 실수로 돌려주고 float)
	// (Math.round() ) 를 사용하지 않고 처리할 것
	
	// ★★★ 몇째자리에서 반올림 -> (*자릿수 10e +0.5)/자릿수 10e f 하고 int화 -> 원래대로 돌리고 float화;
	
	public static void main(String[] args) {
		int fahrenheit=100;
		
	    float celcius= (int)((5/9f) * (fahrenheit-32)*100+0.5)/100f;
	    // 자릿수가 5보다 크면 반올림 -> 0.5 더하면 1의 자릿수가 +1로 올라감 -> int로 바꾸면 소숫점 탈락되고 *100f로 해서 다시 실수로 만들어주기
	    // 자릿수가 5보다 작으면 반내림 -> int로 만들 때 소수자리는 탈락됨
	    
		System.out.println("fahrenheit : " +fahrenheit);
		System.out.printf("celcius : " +celcius);
		
	} //main

} //class
