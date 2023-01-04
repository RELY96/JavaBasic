package z_extra;

import java.util.Random;
import java.util.Scanner;

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
            if (j % 3 == 0) results2 += j;
        }
        System.out.println("3의 배수 합은?" + results2);

        results2 = 0;
        for (int j = 3; j <= 100; ) {
            results2 += j;
            j += 3;
        }
        System.out.println("3의 배수 합은?" + results2);

        //========================================================================================//
        // ※ 1. 랜덤게임(값 맞추기, 1~10범위 벗어나면 재실행)
        // 1) 1~10 범위 판단
        Random rn = new Random();
        int num = rn.nextInt(10) + 1;
        Scanner sc = new Scanner(System.in);
        int input;

        do {
            System.out.println("1~10까지 정수 입력");
            input = sc.nextInt();
        } while (input < 1 || input > 10);

        // 2) (범위 시) 결과처리
        int abs = Math.abs(num - input);
        System.out.printf("출력값: %d, 입력값: %d \n", num, input);
        switch (abs) {
            case 0:
                System.out.println("금메달");
                break;
            case 1:
                System.out.println("은메달");
                break;
            case 2:
                System.out.println("동메달");
                break;
            default:
                System.out.println("꽝");
        }
        //-----------------------------------------------------------------------------------------//
        // *** 반복문 탈출 Continue, Break
        // * continue - continue문 이하 구문 진행X, 다음번째 반복문 실행
        // * break - 반복문 탈출
        // * label - continue, break 이벤트 적용될 반복문 지정, : 표시, 반복문 바로 위 위치




        //========================================================================================//
        // *** 2차원 별찍기





    } //main
} //class
