package array;

import java.util.ArrayList;
import java.util.Scanner;

public class Array2 {
    /*
    설명 :
    선생님이 N명의 학생을 일렬로 세웠습니다. 일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때,
    맨 앞에 서 있는 선생님이 볼 수 있는 학생의 수를 구하는 프로그램을 작성하세요.
    (앞에 서 있는 사람들보다 크면 보이고, 작거나 같으면 보이지 않습니다.)

    입력 :
    첫 줄에 정수 N(5<=N<=100,000)이 입력된다. 그 다음줄에 N명의 학생의 키가 앞에서부터 순서대로 주어진다.

    출력 :
    선생님이 볼 수 있는 최대학생수를 출력한다.
     */
    public int solution(int n, int[] arr){
        int answer = 1;
        int max = arr[0];

        for (int i = 0; i < n; i++) {
            //자기 앞의 학생들 중에서 가장 키 큰 학생의 키
            if(arr[i] > max){
                //크면 ? +1
                answer++;
                max = arr[i];
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Array2 T = new Array2();

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
        System.out.println(T.solution(n, arr));
    }
}
