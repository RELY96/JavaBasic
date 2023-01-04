package z_extra;

public class ForWhileBasic {
    public static void main(String[] args) {
        // * 반복문 3요소 : 초기값, 조건식, 증감식
        // * while - 조건 확인 후 실행 / do-while - 실행 후 조건 확인

        // 1. 1~100까지 합 출력
        int result=0;
        int i=0;

        for (i=1; i<=100; i++) {
            result+=i;
        }
        System.out.println("result :" +result);
        System.out.println("after i :" +i);

        result=0;
        i=1;
        while (i<=100) {
            result+=i;
            i++;
        }
        System.out.println("result :" +result);
        System.out.println("after i :" +i);

        result=0;
        i=1;
        do {
           result+=i;
           i++;
        } while (i<=100);
        System.out.println("result :" +result);
        System.out.println("after i :" +i);

        //========================================================================================//
        // *** MultiLoop





    } //main
} //class
