package map;

import java.util.Scanner;

public class TreeSet {
    /*
    설명 :
    현수는 1부터 100사이의 자연수가 적힌 N장의 카드를 가지고 있습니다. 같은 숫자의 카드가 여러장 있을 수 있습니다.
    현수는 이 중 3장을 뽑아 각 카드에 적힌 수를 합한 값을 기록하려고 합니다.
    3장을 뽑을 수 있는 모든 경우를 기록합니다.
    기록한 값 중 K번째로 큰 수를 출력하는 프로그램을 작성하세요.
    만약 큰 수부터 만들어진 수가 25 25 23 23 22 20 19......이고 K값이 3이라면 K번째 큰 값은 22입니다.

    입력 :
    첫 줄에 자연수 N(3<=N<=100)과 K(1<=K<=50) 입력되고, 그 다음 줄에 N개의 카드값이 입력된다.

    출력 :
    첫 줄에 K번째 수를 출력합니다. K번째 수가 존재하지 않으면 -1를 출력합니다.
     */


    /*
    요소들을 정렬된 상태로 유지하는 Set의 구현체 -> TreeSet

    - TreeSet은 이진 검색 트리(binary search tree)라는 자료구조를 기반으로 동작
    - TreeSet에 요소를 추가할 때마다 자동으로 정렬되며, 중복된 요소는 허용하지 않는다.
    - TreeSet은 내부적으로 Red-Black Tree 라는 균형 이진 검색 트리를 사용하여 요소들을 저장하고 정렬
    - 요소들의 순서에 따라 검색, 범위 검색, 최소값/최대값 검색 등 다양한 연산을 효율적으로 수행 가능

    -> TreeSet은 정렬된 상태로 요소들을 저장하고 중복을 허용하지 않는 자료구조
     */

    public int solution(int n, int k, int[] arr){
        int answer = 0;

//        TreeSet<Integer> Tset = new TreeSet<>(Collection.reverseOrder());
        java.util.TreeSet<Integer> Tset = new java.util.TreeSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int l = j+1; l < n; l++) {
                    Tset.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }
        int cnt = 0;
        for (int x : Tset){
            cnt ++;
            if (cnt == k) {
                return x;
            }
            System.out.println(cnt + " " + x);
        }

        return answer;
    }

    public static void main(String[] args) {
        TreeSet T = new TreeSet();

        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(T.solution(n, k, arr));
    }
}
