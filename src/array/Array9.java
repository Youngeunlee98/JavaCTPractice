package array;

import java.util.Scanner;

public class Array9 {
    /*
    설명 :
    5*5 격자판에 아래롸 같이 숫자가 적혀있습니다.
    N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력합니다.

    열
    ^
    10 13 10 12 15  > 행
    12 39 30 23 11
    11 25 50 53 15
    19 27 29 37 27
    19 13 30 13 19

    입력 :
    첫 줄에 자연수 N이 주어진다.(2<=N<=50)
    두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.

    출력 :
    최대합을 출력합니다.
     */
    public int solution(int n, int[][] arr){
        //answer 에 행, 열, 대각선 합 중 가장 큰 값을 저장할 것이기 떄문에
        //가장 정수값이 적은 것으로 초기화 하고 시작한다.
        //최댓값을 찾아야 하기 때문에!
        int answer = Integer.MIN_VALUE;

        //행과 열의 합을 각각 구해서 answer보다 더 크면 바꿔준다
        //행의 합
        int sum1;
        //열의 합
        int sum2;

        for (int i = 0; i < n; i++) {
            sum1 = sum2 = 0;
            for (int j = 0; j < n; j++) {
                //[i]라는 행이 고정되고 [j]라는 열이 움직이면서 돈다.
                //즉, i 행의 합 값이 구해진다.
                sum1 += arr[i][j];
                //[j]라는 열이 고정되고 [i]라는 합이 움직이면서 돈다.
                //즉, i 열의 합 값이 구해진다.
                sum2 += arr[j][i];
            }
            //최댓값으로 갱신한다!
            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);
            //이렇게 하면 행과 열의 최댓값은 answer에 들어간다.
        }
        // 두 대각선의 합 값 구하기
        sum1 = sum2 = 0;
        for (int i = 0; i < n; i++) {
            //arr[i][i] 로 대각선을 구하는 이유?
            //1행1열 일때, 2행2열 일때, 3행3열 일때.....
            //이런식으로 가야 대각선이 되기 때문이다.
            sum1 += arr[i][i];
            //반대 대각선이 arr[i][n - i - 1] 이것인 이유는?
            /*
                 0   1  2   3   4
                ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
             0  | * |   |  |   | @ |
                |ㅡㅡ|ㅡㅡ|ㅡㅡ|ㅡㅡ|ㅡㅡ|
             1  |   | * |  | @ |   |
                |ㅡㅡ|ㅡㅡ|ㅡㅡ|ㅡㅡ|ㅡㅡ|
             2  |   |  |@ *|  |   |
                |ㅡㅡ|ㅡㅡ|ㅡㅡ|ㅡㅡ|ㅡㅡ|
             3  |   | @ |  | * |   |
                |ㅡㅡ|ㅡㅡ|ㅡㅡ|ㅡㅡ|ㅡㅡ|
             4  | @ |   |  |   | * |
                ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

             일때 첫번째 대각선이 * 이면
             4열에서 시작되는 반대 대각선 (@) 은
             n - i - 1 , 즉  " 5 - 0 - 1 "  => 4
                         즉  " 5 - 1 - 1 "  => 3
                         즉  " 5 - 2 - 1 "  => 2
                         즉  " 5 - 3 - 1 "  => 1
                         ....
             라고 해서 찾을 수 있다.
             */
            sum2 += arr[i][n - i - 1];
        }
        //최댓값으로 갱신한다!
        answer = Math.max(answer, sum1);
        answer = Math.max(answer, sum2);

        return answer;
    }

    public static void main(String[] args){
        Array9 T = new Array9();

        Scanner kb = new Scanner(System.in);
        System.out.println("정수를 입력해주세요 : ");
        //정수 받기
        int n = kb.nextInt();
        //n * n 배열이기 때문에 int[][]로 만든다.
        //2차원 배열
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = kb.nextInt();
            }
        }

        System.out.println(T.solution(n, arr));
    }
}
