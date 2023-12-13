package array;

import java.util.Scanner;

public class Array8 {
    /*
    설명 :
    N명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력하는 프로그램을 작성하세요.
    같은 점수가 입력될 경우 높은 등수로 동일 처리한다.
    즉 가장 높은 점수가 92점인데 92점이 3명 존재하면 1등이 3명이고 그 다음 학생은 4등이 된다.

    입력 :
    첫 줄에 N(3<=N<=100)이 입력되고, 두 번째 줄에 국어점수를 의미하는 N개의 정수가 입력된다.

    출력 :
    입력된 순서대로 등수를 출력한다.
     */
    public int[] solution(int n, int[] arr){
        int[] answer = new int[n];
//        for (int i = 0; i < n; i++) {
//            System.out.println(answer[i] + " ");
//        }

        for (int i = 0; i < n; i++) {
            //처음 등수는 무조건 1등으로 초기화 시켜두고 돌린다.
            int cnt = 1;
            for (int j = 0; j < n; j++) {
                if (arr[j] > arr[i]){
                    //j가 i 보다 크면 등수를 증가시킨다
                    //이 의미는
                    /*
                    예를 들어,
                    점수가 50, 85, 66, 45, 90
                    이라는 순서로 있을때 처음에
                    j 가 50이라고 치고 등수를 1로 초기화 시켜준뒤 여기서 i에 해당되는 85는 50 보다 크기때문에 등수가 1등에서 2등으로 cnt가 누적된다.
                    j 와 같은 등수는 넘어가고 작아도 넘어간다.
                     */
                    cnt++;
                }
                answer[i] = cnt;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Array8 T = new Array8();

        Scanner kb = new Scanner(System.in);
        System.out.println("정수를 입력해주세요 : ");
        //정수 받기
        int n = kb.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        for (int x : T.solution(n, arr)){
            System.out.println( x + " ");
        }
    }
}
