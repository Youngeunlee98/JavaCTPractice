package array;

import java.util.ArrayList;
import java.util.Scanner;

public class Array6 {
    /*
    설명 :
    N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력하는 프로그램을 작성하세요.
    예를 들어 32를 뒤집으면 23이고, 23은 소수이다. 그러면 23을 출력한다.
    단 910를 뒤집으면 19로 숫자화 해야 한다.
    첫 자리부터의 연속된 0은 무시한다.

    입력 :
    첫 줄에 자연수의 개수 N(3<=N<=100)이 주어지고, 그 다음 줄에 N개의 자연수가 주어진다.
    각 자연수의 크기는 100,000를 넘지 않는다.

    출력 :
    첫 줄에 뒤집은 소수를 출력합니다. 출력순서는 입력된 순서대로 출력합니다.
     */

    // 소수 판별 함수
    public boolean isprime(int num){
        if (num == 1){
            // 1은 소수가 아니므로 false를 반환
            return false;
        }
        // 2부터 num-1까지의 수로 num을 나누고,
        // 나누어 떨어지는 수가 있다면 num은 소수가 아니다.
        for (int i = 2; i < num; i++) {
            if (num % i == 0){
                return false;
            }
        }
        // 2부터 num-1까지의 수로 나누어 떨어지는 수가 없다면 num은 소수
        return true;
    }

    public ArrayList<Integer> solution(int n, int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        //뒤집어서 소수인 것은 ArrayList 에 담는다.
        for (int i = 0; i < n; i++) {
            int tmp = arr[i];
            //뒤집기 시작
            int res = 0;

            // tmp가 0이 될 때까지 반복
            // tmp를 10으로 나누면서 마지막 자리 수를 res에 추가

            //while(tmp > 0) 루프는 주어진 자연수 tmp를 뒤집기 위해 사용

            while(tmp > 0){
                // tmp를 10으로 나눈 나머지를 구하여 t에 저장합
                // 이렇게 함으로써 t는 tmp의 일의 자리 숫자가 된다.
                int t = tmp % 10;
                //res에 10을 곱하고 t를 더함으로써 res에는 이전에 구한 일의 자리 숫자들이 뒤집힌 순서로 저장
                res = res * 10 + t;
                //tmp를 10으로 나눠서 일의 자리 숫자를 제거
                //tmp는 나머지를 제외한 앞의 숫자들이 남게 된다.
                tmp = tmp / 10;

                //위의 과정을 tmp가 0이 될 때까지 반복하면, tmp의 각 자릿수가 뒤집힌 순서로 res에 저장되고,
                // tmp는 0이 되어 반복문을 빠져나오게 된다.
            }
            // 뒤집은 수가 소수인지 판별하여 소수이면 answer에 추가
            if(isprime(res)){
                answer.add(res);
            }
        }
        // 뒤집은 소수들이 저장된 ArrayList를 반환
        return answer;
    }

    public static void main(String[] args) {
        Array6 T = new Array6();

        Scanner kb = new Scanner(System.in);
        System.out.println("정수를 입력해주세요 : ");
        //정수 받기
        int n = kb.nextInt();
        int[] arr = new int[n];
        // 자연수를 입력받아 배열에 저장
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        // 뒤집은 소수를 계산하고 결과를 출력
        for (int x : T.solution(n, arr)) {
            System.out.println(x + "");
        }

    }
}
