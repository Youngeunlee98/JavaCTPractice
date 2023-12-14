package efficiency;

import java.util.Scanner;

public class ComplexProblem2 {
     /*
    설명 :
    0과 1로 구성된 길이가 N인 수열이 주어집니다. 여러분은 이 수열에서 최대 k번을 0을 1로 변경할 수 있습니다.
    여러분이 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾는 프로그램을 작성하세요.
    만약 길이가 길이가 14인 다음과 같은 수열이 주어지고 k=2라면

    1 1 0 0 1 1 0 1 1 0 1 1 0 1

    입력 :
    첫 번째 줄에 수열의 길이인 자연수 N(5<=N<100,000)이 주어집니다.
    두 번째 줄에 N길이의 0과 1로 구성된 수열이 주어집니다.

    출력 :
    첫 줄에 최대 길이를 출력하세요.
     */


    //주어진 수열에서 0을 1로 최대 k번 바꿔서 얻을 수 있는 가장 긴 연속된 1의 길이를 출력할 것

    public int solution (int n, int k, int[] arr) {
        int answer = 0; //가장 긴 연속된 1의 길이를 저장할 변수
        int count = 0; //윈도우 내의 0의 개수를 저장할 변수
        int lt = 0; //왼쪽 포인터

        // '오른쪽 포인터'를 이용해 수열을 순회
        for (int rt = 0; rt < n; rt++) {
            // 오른쪽 포인터가 가리키는 원소가 0이면, 0의 개수를 증가
            if (arr[rt] == 0) count++;

            // 0의 개수가 k를 초과하면, 왼쪽 포인터를 오른쪽으로 이동시키면서 0의 개수를 마이너스
            while (count > k) {
                if (arr[lt] == 0) count--;
                lt++;
            }

            // 윈도우의 길이를 계산하여 최대 길이를 갱신
            answer = Math.max(answer, rt - lt + 1);
        }

        return answer; // 가장 긴 연속된 1의 길이를 반환
    }

    public static void main(String[] args) {
        ComplexProblem2 T = new ComplexProblem2();

        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt(); // 0을 1로 바꿀 수 있는 최대 횟수
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.println(T.solution(n, k, arr));
    }
}
