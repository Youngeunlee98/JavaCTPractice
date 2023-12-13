package array;

import java.util.ArrayList;
import java.util.Scanner;

public class Array1 {
    /*
    설명:
    N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.
    (첫 번째 수는 무조건 출력한다)

    입력 :
    첫 줄에 자연수 N(1<=N<=100)이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.

    출력 :
    자신의 바로 앞 수보다 큰 수만 한 줄로 출력한다.
     */

    public ArrayList<Integer> solution(int n, int[] arr){
        //ArrayList<Integer>여기에 숫자들을 넣는다.
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);

        for (int i = 1; i < n; i++) {
            if(arr[i] > arr[i-1]){
                answer.add(arr[i]);
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Array1 T = new Array1();

        Scanner kb = new Scanner(System.in);
        System.out.println("정수를 입력해주세요 : ");
        //정수 받기
        int n = kb.nextInt();
        //배열 생성
        int[] arr = new int[n];
        //배열에 하나씩 넣어주기
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        for (int x : T.solution(n, arr)){
            System.out.println(x + " ");
        }
    }

}
