package efficiency;

import java.util.ArrayList;
import java.util.Scanner;

public class ComplexProblem {
    /*
    설명 :
    N개의 수로 이루어진 수열이 주어집니다.
    이 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램을 작성하세요.
    만약 N=8, M=6이고 수열이 다음과 같다면
    1 2 1 3 1 1 1 2
    합이 6이 되는 연속부분수열은 {2, 1, 3}, {1, 3, 1, 1}, {3, 1, 1, 1}로 총 3가지입니다.

    입력 :
    첫째 줄에 N(1≤N≤100,000), M(1≤M≤100,000,000)이 주어진다.
    수열의 원소값은 1,000을 넘지 않는 자연수이다.

    출력 :
    첫째 줄에 경우의 수를 출력한다.
     */
    public int solution (int n, int m, int[] arr) {
        // 특정 합을 가지는 연속 부분 수열의 개수를 저장할 변수
        int answer = 0;
        // 연속 부분 수열의 합을 저장할 변수
        int sum = 0;
        // '투 포인터' 알고리즘에서 사용할 '왼쪽 포인터'
        int lt = 0;

        // '오른쪽 포인터'를 이용해 수열을 순회
        for (int rt = 0; rt < n; rt++) {
            // 오른쪽 포인터가 가리키는 원소를 합에 더하기
            sum += arr[rt];
            // 합이 m과 같다면, 연속 부분 수열의 개수를 증가
            if (sum == m){
                answer++;
            }
            // 합이 m 이상이라면, 왼쪽 포인터를 오른쪽으로 이동시키면서 합에서 해당 원소를 뺀다
            while (sum >= m){
                sum -= arr[lt++];
                // 합이 m과 같다면, 연속 부분 수열의 개수를 증가
                if (sum == m){
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        ComplexProblem T = new ComplexProblem();

        Scanner kb = new Scanner(System.in);
        System.out.println("정수를 입력해주세요 : ");
        //정수 받기
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.println(T.solution(n, m, arr));
    }
}
