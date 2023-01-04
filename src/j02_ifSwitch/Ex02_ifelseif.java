package j02_ifSwitch;

public class Ex02_ifelseif {

    public static void main(String[] args) {
        //else if -> if 아니면 else if(조건)

        int score = 99;

        // ** 1. 등급 처리하기 //두줄 이상 실행문일 경우 중괄호 블럭, 아니면 중괄호 생략 가능 ( if ~ else }까지 한문장 )
        char grade;
        if (score >= 90) {
            grade = 'A';
            System.out.println(" ** 우수학생 ** ");
        } else if (score >= 80)
            grade = 'B';
        else {
            grade = 'C';
            System.out.println(" ** 재시험 ** ");
        }
        System.out.println(" ** grade1 : " + grade);

        // ** 2. 비교 -> D를 찍음 if처리하고 계속 밑에 if를 처리해서 최종적으로 나온 D로 덮힘( ; 까지 한문장 )
        if (score >= 90) grade = 'A';
        if (score >= 80) grade = 'B';
        if (score >= 70) grade = 'C';
        else grade = 'F';
        System.out.println(" ** grade2 : " + grade);

        // ** 3. 비교 -> 중첩 if문(if문 안 if문)
        if (score >= 90) {
            grade = 'A';
            if (score == 100) System.out.println(" 장학생 ");
        } else {
            if (score >= 80) grade = 'B'; //아닌 경우 else에 또 if 추가 -> 중첩
            else {
                if (score >= 70) grade = 'C';
                else grade = 'F';
            } // B에 대한 else
        } //A에 대한 else

    } //main

} //class
