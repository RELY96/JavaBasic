package j10_APITest;

//** String 2
//=> String 의 메서드
//=> 문자열 추출
// charAt, length, indexOf, lastIndexOf, substring, trim -> 메서드 적용시 ★변수의 값이 변경되는 것이 아니고★, ★메서드가 적용결과를 return 할뿐. 

public class Ex02_String02_indexof {

	public static void main(String[] args) {
		String name="홍길동";
		String city="   ~~SeoulKorea~~   ";
		String country="01234I6Love Korea     ";
		
		//-----------------------------------------------------//
		
		System.out.printf("* charAt => %s,%s \n",name.charAt(1),city.charAt(10)/*charAt 해당 위치 문자 추출*/);
		System.out.printf("* indexOf => %d, %d, %d \n",name.indexOf("홍"),city.indexOf("e"/*앞에 있는 e index출력*/),country.indexOf("o")); //index리턴은 %d, 특정 글자의 index 리턴함
		
		System.out.printf("* indexOf => %d, %d, %d \n",name.indexOf("김"/*없는 글 출력-> 음수 나옴!*/),city.indexOf("e",10),country.indexOf("o"));
		
		System.out.printf("* lastIndexOf => %d, %d, %d \n",name.lastIndexOf("홍"),city.lastIndexOf("e"),country.lastIndexOf("o")); /*제일 마지막의 해당값이 몇번째인지*/
		
		System.out.printf("* substring => %s, %s \n",country.substring(0,7/*매개변수int로 범위 정할 수O,0~7까지*/),city.substring(12/*12부터 끝까지*/));
		// substring 범위 추출
		
		System.out.printf("* trim => %s, %s \n",city.trim(), country.trim()); /*trim : 앞 뒤 space 제거*/
		
		//-----------------------------------------------------//
		// 변경된 값 변수에 적용하기
		city = city.trim();
		System.out.println("country 변경 값 저장: "+city);
		
		//====================================================//
		System.out.println("--------------------------------------------");
		
		// ** 과제	
		String url="C:\\MTest\\myWork\\Java01\\src\\Ex02_String02.java";
		// 1) 파일명만 추출해서 출력
		System.out.printf("\\:%s, .:%s \n",url.lastIndexOf("\\"),url.lastIndexOf(".")); //파일명은 마지막 \역슬래쉬 다음부터 .사이 + 역슬래쉬 한개 출력하고 싶으면 \\ 두개!
		System.out.println("1) 파일명 출력: "+url.substring(27, 40));
		System.out.println("1) 파일명 출력-완성: "+url.substring(url.lastIndexOf("\\"),url.lastIndexOf(".")));

		// 2) 파일 확장자만 출력
		System.out.print(url.length());
		System.out.println(url.lastIndexOf("j"));
		System.out.println("2) 확장자명 출력: "+url.substring(41, 45));
		System.out.println("2) 확장자명 출력-완성: "+url.substring(url.lastIndexOf(".")+1)); //substring(,)아니니까 .+1부터 끝까지 출력됨
		
		// 3) Korea만 추출해서 출력
		System.out.printf("1k:%d, 1a:%d / 2l:%d, 2a:%d \n",city.indexOf("K"),city.indexOf("a"),country.indexOf("K"),country.indexOf("a"));
		System.out.println("city Korea: "+city.substring(7, 12));
		System.out.println("city Korea-완성: "+city.substring(city.indexOf("K"),city.indexOf("a")+1));
		
		System.out.println("country Korea: "+country.substring(12, 17));
		System.out.println("country Korea-완성: "+country.substring(country.indexOf("K"),country.indexOf("a")+1));
		
		//======================================================================//
		// 4) city 에서 Korea 만 모두 대문자로 바꾸기(substring, toUpperCase)
		System.out.printf("Korea만 모두 대문자로 : %s \n ",city.toUpperCase().substring(city.indexOf("K"),city.indexOf("a")+1));
		// 이렇게 ★매서드를 중첩해서 쓸 수 있음!toUppercase().substring 중첩 (둘이 순서 바꿀 수도 있음)
		
	} //main

} //class
