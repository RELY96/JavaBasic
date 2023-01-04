package z_extra;

public class ForWhileBasic {
    public static void main(String[] args) {
        // * 반복문 3요소 : 초기값, 조건식, 증감식
        // * while - 조건 확인 후 실행 / do-while - 실행 후 조건 확인

        // 1. 1~100까지 합 출력
        int result = 0;
        int i = 0;

        for (i = 1; i <= 100; i++) {
            result += i;
        }
        System.out.println("result :" + result);
        System.out.println("after i :" + i);

        result = 0;
        i = 1;
        while (i <= 100) {
            result += i;
            i++;
        }
        System.out.println("result :" + result);
        System.out.println("after i :" + i);

        result = 0;
        i = 1;
        do {
            result += i;
            i++;
        } while (i <= 100);
        System.out.println("result :" + result);
        System.out.println("after i :" + i);

        //========================================================================================//
        // *** MultiLoop(중첩)
        // 1. 자전거 1회당 줄넘기 10회, 총 자전거 5회 돌리고 줄넘기 횟수 구하기
        int count = 0;
        for (int cycle = 1; cycle <= 5; cycle++) {
            for (int rope = 1; rope <= 10; rope++) {
                System.out.printf("[ %d,%d ]", cycle, rope);
                count++;
            }
            System.out.println("");
        }
        System.out.println("총 줄넘기 횟수? " + count);
        //-----------------------------------------------------------------------------------------//
        // 2. 줄넘기 10번 당(if) 0.2kg 감량, 줄넘기 740번 시(for) 감량 kg 구하기(정수로)
        double results = 0;
        for (int rope2 = 1; rope2 <= 740; rope2++) {
            if (rope2 % 10 == 0) {
                results += 0.2;
            }
        }
        System.out.println("감량 kg는?" + (int) results);
        //-----------------------------------------------------------------------------------------//
        // 3. 1~100까지 정수 중(for) 3의 배수(if) 합(result) 구하기
        int results2 = 0;
        for (int j = 1; j <= 100; j++) {
            if (j % 3 == 0) results2+=j;
        }
        System.out.println("3의 배수 합은?"+results2);

        results2 = 0;
        for (int j = 3; j<=100;) {
            results2+=j;
            j+=3;
        }
        System.out.println("3의 배수 합은?"+results2);

        //========================================================================================//
        // ※ 1. 랜덤게임(1~10 값 맞출 때 까지 반복)






        //----------------------------------------------------------------------------------------//
        // ※ 2. 랜덤게임2(1~100 값 맞출 때 까지 힌트주며 반복)





    } //main
} //class
