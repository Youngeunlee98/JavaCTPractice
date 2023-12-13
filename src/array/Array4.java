package array;

import java.util.Scanner;

public class Array4 {
    /*
    설명 :
    1) 피보나키 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
    2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.

    입력 :
    첫 줄에 총 항수 N(3<=N<=45)이 입력된다.

    출력 :
    첫 줄에 피보나치 수열을 출력합니다.
     */

    public int[] solution(int n){
        int[] answer = new int[n];
        // 피보나치 수열의 첫 번째와 두 번째 항은 1
        answer[0] = 1;
        answer[1] = 1;
        // 세 번째 항부터 n번째 항까지 계산하여 배열에 저장
        // 각 항은 바로 앞의 두 항의 합
        for (int i = 2; i < n; i++) {
            answer[i] = answer[i -2] + answer[i -1];
        }
        return answer;
    }

    public static void main(String[] args){
        Array4 T = new Array4();

        Scanner kb = new Scanner(System.in);
        System.out.println("정수를 입력해주세요 : ");
        //정수 받기
        int n = kb.nextInt();

        for (int x : T.solution(n)){
            System.out.println(x + " ");
        }
    }


    ////배열 쓰지 말아라 한다면?
    /*

    public void solution(int n){
        int a = 1;
        int b = 1;
        int c;

        System.out.println(a + " " + b + " " );

        for (int i = 2; i < n ; i++) {
            c = a + b;
            System.out.println(c + " ");
            a = b;
            b = c;
        }

    }

     */
}
