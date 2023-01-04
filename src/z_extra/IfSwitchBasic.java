package z_extra;

import java.util.Random;
import java.util.Scanner;

public class IfSwitchBasic {

    public static void main(String[] args) {
        // *** IF
        // 1. a,b 중 큰 수 출력
        // if (a > b) ? a : b;
        int a = 10;
        int b = 5;
        int max;

        if (a > b) max = a;
        else max = b;
        System.out.println("a,b중 큰 수는 ? " + max);

        boolean bool;
        if (a > b) bool = true;
        else bool = false;
        System.out.println("a가 b보다 큰가 ? " + bool);

        char cc;
        if (a > b) cc = 'T';
        else cc = 'F';
        System.out.println("a가 b보다 큰가 ? " + cc);
        System.out.printf("max=%d, bool=%b, cc=%c \n", max, bool, cc);

        // * 결과값에 여러줄 올 때 중괄호 사용 가능 if{...}
        // * else 생략 가능
        // * 연산자들 간 우선순위 - 단항(+-!) > 산술(*/%) > 비교(> < == !=) > 논리(&& ||)
        //------------------------------------------------------------------------------//
        // 2. 점수, 등급 처리
        int studentScore = 83;
        char grade;
        if (studentScore >= 90) {
            grade = 'A';
        } else if (studentScore >= 80) {
            grade = 'B';
        } else if (studentScore >= 70) {
            grade = 'C';
        } else {
            grade = 'F';
        }
        System.out.println("grade: " + grade);
        // 2-2. A중 100점 출력(중첩IF)
        if (studentScore >= 90) {
            grade = 'A';
            if (studentScore == 100) System.out.println("백점 축하합니다");
        } else {
            System.out.println("분발하세요");
        }
        //------------------------------------------------------------------------------//
        // ※3. 숫자 맞추기 랜덤 게임 - 1) 랜덤클래스, 매서드 활용 2) 범위(1~10) 3) 결과 차이따라 금은동
        // 1) Random 범위 지정과 스캐너 생성 및 입력
        Random rn = new Random();
        int rnum = rn.nextInt(10) + 1;

        Scanner sc = new Scanner(System.in);
        System.out.println("1~10까지 정수를 입력하세요.");
        int mynum = sc.nextInt();
        sc.close();

        // 2) 범위 맞는지 확인
        if (mynum < 1 || mynum > 10) {
            System.out.println("1~10까지 정수를 입력하세요.");
            return;
        }

        // 3) 범위 맞으면 결과 처리 & 출력
        System.out.printf("결과값: %d, 입력값: %d", rnum, mynum);
        if (rnum == mynum) System.out.println("금메달");
        else if (Math.abs(rnum - mynum) == 1) System.out.println("은메달");
        else if (Math.abs(rnum - mynum) == 2) System.out.println("동메달");
        else System.out.println("꽝");

        //==================================================================================//
        // *** SWITCH
        // * switch 매개변수 인자는 int, char, String만 가능(실수타입불가)
        // * case블럭 여러줄 중괄호X
        // * case 값으로 변수 사용불가(only리터럴), 변수 없는 식 가능
        // * break; 없을 시 맞아도 자동탈출X, 내려가며 실행
        // * case 안 if, if 안 case 중첩가능

        // ※1. 숫자 맞추기 랜덤 게임
        // 1) 랜덤 범위 정하기
        Random random = new Random();
        int rannum = random.nextInt(10) + 1;
        // 2) scanner 입력받기
        Scanner scanner = new Scanner(System.in);
        System.out.println("1~10까지 정수 입력");
        int num = scanner.nextInt();
        scanner.close();
        // 3) 범위에 맞는지 확인
        if (!(num >= 1 && num <= 10)) {
            System.out.println("1~10까지 정수 입력");
            return;
        }
        // 4) 결과 확인 & 처리
        switch (Math.abs(rannum - num)) {
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

        //------------------------------------------------------------------------------//
        // ※2. 입력 월이 며칠까지, 계절 출력
        // 1,3,5,7,8,10,12=31, 4,6,9,11=30, 2=29
        int day1 = 31;
        int day2 = 30;
        Scanner scan = new Scanner(System.in);
        int month = scan.nextInt();
        scan.close();

        if (month >= 3 && month <= 5) {
            switch (month) {
                case 4:
                    System.out.printf("%d월은 %d일 까지이고 ", month, day2);
                    break;
                default:
                    System.out.printf("%d월은 %d일 까지이고 ", month, day1);
            }
            System.out.println("봄 입니다.");
        } else if (month >= 6 && month <= 8) {
            switch (month) {
                case 6:
                    System.out.printf("%d월은 %d일 까지이고 ", month, day2);
                    break;
                default:
                    System.out.printf("%d월은 %d일 까지이고 ", month, day1);
            }
            System.out.println("여름 입니다.");
        } else if (month >= 9 && month <= 11) {
            switch (month) {
                case 10:
                    System.out.printf("%d월은 %d일 까지이고 ", month, day1);
                    break;
                default:
                    System.out.printf("%d월은 %d일 까지이고 ", month, day2);
            }
            System.out.println("가을 입니다.");
        } else if (month == 12 || month == 1 || month == 2) {
            switch (month) {
                case 2:
                    System.out.printf("%d월은 %d일 까지이고 ", month, 29);
                    break;
                default:
                    System.out.printf("%d월은 %d일 까지이고 ", month, day1);
            }
            System.out.println("겨울 입니다.");
        } else {
            System.out.println("달을 맞게 입력해주세요.");
        }
    } //main
} //class
