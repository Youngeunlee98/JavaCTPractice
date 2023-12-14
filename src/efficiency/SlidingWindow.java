package efficiency;

import java.util.ArrayList;
import java.util.Scanner;

public class SlidingWindow {
    /*
    설명 :
    현수의 아빠는 제과점을 운영합니다. 현수 아빠는 현수에게 N일 동안의 매출기록을 주고
    연속된 K일 동안의 최대 매출액이 얼마인지 구하라고 했습니다.
    만약 N=10이고 10일 간의 매출기록이 아래와 같습니다. 이때 K=3이면
    12 1511 20 2510 20 19 13 15
    연속된 3일간의 최대 매출액은 11+20+25=56만원입니다.
    여러분이 현수를 도와주세요.

    입력 :
    첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
    두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.

    출력 :
    첫 줄에 최대 매출액을 출력합니다.
     */
    public int solution (int n, int k, int[] arr) {
        // 최대 매출액을 저장할 변수
        int answer = 0;
        // 연속된 K일 동안의 매출액을 저장할 변수
        int sum = 0;

        // 처음 K일 동안의 매출액을 계산
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        // 처음 K일 동안의 매출액을 최대 매출액으로 설정
        answer = sum;

        // K일 이후부터 매출액을 계산
        for (int i = k; i < n; i++) {
            // slidingWindow
            // 이전 K일 동안의 매출액에서 가장 오래된 날의 매출액을 빼고,
            // 새로운 날의 매출액을 더해서 구한다.
            sum += (arr[i] - arr[i-k]);
            // 최대 매출액을 갱신
            answer = Math.max(answer, sum);
        }

        return answer;
    }

    /*
    여기서 '윈도우'는 배열이나 리스트의 일정 범위를,
    '슬라이딩'은 이 윈도우가 오른쪽으로 이동하는 것을 의미.

    이 알고리즘의 핵심은 고정된 크기의 윈도우를 이용해 배열이나 리스트를 한 번만 훑어서 문제를 해결하는 것.

    윈도우가 오른쪽으로 한 칸 이동할 때마다, 새로 윈도우에 들어온 요소를 합에 더하고,
    윈도우에서 나간 요소를 합에서 빼는 방식으로 계산량을 줄인다.
    이 과정을 배열의 끝까지 반복하면,
    연속된 K개의 요소의 합이 최대가 되는 부분 배열을 효율적으로 찾을 수 있다.
     */



    public static void main(String[] args) {
        SlidingWindow T = new SlidingWindow();

        Scanner kb = new Scanner(System.in);
        System.out.println("정수를 입력해주세요 : ");
        //정수 받기
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.println(T.solution(n, k, arr));
    }
}
