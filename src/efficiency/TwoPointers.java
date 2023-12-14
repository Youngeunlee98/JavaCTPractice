package efficiency;

import java.util.Scanner;

public class TwoPointers {
    /*
    설명 :
    N입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.
    만약 N=15이면
    7+8=15
    4+5+6=15
    1+2+3+4+5=15
    와 같이 총 3가지의 경우가 존재한다.

    입력 :
    첫 번째 줄에 양의 정수 N(7<=N<1000)이 주어집니다.

    출력 :
    첫 줄에 총 경우수를 출력합니다.
     */


    public int solution (int n) {
        // 방법의 수를 저장할 변수
        int answer = 0;
        // 연속된 자연수의 합을 저장할 변수
        int sum = 0;
        // 왼쪽 포인터
        int lt = 0;
        // '오른쪽 포인터'의 최대 범위
        int m = n/2;
        // 1부터 m까지의 자연수를 저장할 배열
        int[] arr = new int[m];

        // 배열에 1부터 m까지의 자연수를 저장
        for (int i = 0; i < m; i++) {
            //0번 인덱스에 1 들어가기
            arr[i] = i + 1;
        }
        // '오른쪽 포인터'를 이용해 배열을 순회
        for (int rt = 0; rt < m; rt++) {
            // 오른쪽 포인터가 가리키는 자연수를 합에 더하기
            sum += arr[rt];
            // 합이 n과 같다면, 방법의 수를 증가
            if(sum == n){
                answer++;
            }
            // 합이 n 이상이라면,
            // 왼쪽 포인터를 오른쪽으로 이동시키면서 합에서 해당 자연수를 뺀다.
            while(sum >= n){
                sum -= arr[lt++];
                // 합이 n과 같다면, 방법의 수를 증가
                if(sum == n){
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        TwoPointers T = new TwoPointers();

        Scanner kb = new Scanner(System.in);
        System.out.println("정수를 입력해주세요 : ");
        //정수 받기
        int n = kb.nextInt();

        System.out.println(T.solution(n));
    }
}
