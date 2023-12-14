package efficiency;

import java.util.ArrayList;
import java.util.Scanner;

public class TwoPointersAlgorithm1 {
    /*
    설명 :
    오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.

    입력 :
    첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.
    두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
    세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.
    네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
    각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.

    출력 :
    오름차순으로 정렬된 배열을 출력합니다.
     */



    /*
    두 개의 포인터를 사용하는 이유는 두 배열 각각을 독립적으로 추적하고 비교하기 위함입니다.
    '병합 정렬' 알고리즘에서는 두 배열의 원소를 한 번에 하나씩 비교해 나가는 과정이 필요합니다.
    이때 각 배열의 원소를 가리키는 포인터 두 개가 필요하며, 이를 통해 현재 비교 대상인 두 원소의 위치를 추적합니다.
    예를 들어, 첫 번째 배열의 원소가 두 번째 배열의 원소보다 작다면, 첫 번째 배열의 포인터를 한 칸 앞으로 이동시키고,
    그 반대의 경우에는 두 번째 배열의 포인터를 한 칸 앞으로 이동시킵니다.
    이렇게 두 개의 포인터를 사용하면, 두 배열의 원소를 순차적으로 비교하면서 병합할 수 있습니다.
    또한, 두 배열 중 하나의 원소를 모두 사용했을 때 나머지 배열의 남은 원소를 쉽게 추가할 수 있습니다.

    따라서 두 개의 포인터를 사용하면 두 개의 정렬된 배열을 효과적으로 병합할 수 있습니다.
     */
    public ArrayList<Integer> solution (int n, int m, int[] a, int[] b){
        ArrayList<Integer> answer= new ArrayList<>();
        // 배열 a를 가리키는 포인터
        int p1 = 0;
        // 배열 b를 가리키는 포인터
        int p2 = 0;

        /*
        while문을 이용하여 두 배열을 합치는 과정은 '병합 정렬'이라는 알고리즘의 일부이다.
        병합 정렬은 이미 정렬된 두 개의 배열을 하나의 정렬된 배열로 합치는 방법을 사용하는데, 이 과정에서 while문이 사용된다.

        1. 두 배열 a와 b의 원소를 순서대로 비교한 후에 두 배열 모두 오름차순으로 정렬되어 있으므로,
        각 배열의 첫 번째 원소(인덱스 p1, p2) 중에서 작은 것을 결괏값에 추가하면 된다.

        2. a[p1]과 b[p2] 중에서 작은 값을 결괏값에 추가한 후, 더 작은 값을 가진 배열의 인덱스(p1 또는 p2)를 1 증가시키면
        결괏값은 항상 오름차순으로 유지되며, 두 배열의 모든 원소를 확인할 때까지 이 과정을 반복한다.

        3. 두 배열 중 한 쪽의 모든 원소를 확인했지만 다른 쪽에는 아직 확인하지 않은 원소가 남아 있는 경우,
        아래의 while문을 통해 남은 원소를 결괏값에 추가한다.

        4.  두 배열의 모든 원소를 오름차순으로 결괏값에 추가하게 되고, 결괏값은 두 배열을 오름차순으로 합친 배열이 된다.
         */

        while (p1 < n && p2 < m){
            // 배열 a의 현재 원소가 배열 b의 현재 원소보다 작으면
            // 배열 a의 원소를 결과에 추가하고, 포인터를 하나 증가
            if (a[p1] < b[p2]){
                answer.add(a[p1++]);
            }else {
                // 그렇지 않으면 배열 b의 원소를 결과에 추가하고,
                // 포인터를 하나 증가
                answer.add(b[p2++]);
            }
        }
        // 배열 a에 남은 원소가 있으면 결과에 추가
        while(p1 < n){
            answer.add(a[p1++]);
        }
        // 배열 b에 남은 원소가 있으면 결과에 추가
        while(p2 < n){
            answer.add(b[p2++]);
        }

        return answer;
    }

    public static void main(String[] args) {
        TwoPointersAlgorithm1 T = new TwoPointersAlgorithm1();

        Scanner kb = new Scanner(System.in);
        System.out.println("정수를 입력해주세요 : ");
        //정수 받기
        int n = kb.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = kb.nextInt();
        }

        int m = kb.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = kb.nextInt();
        }

        for (int x : T.solution(n, m, a, b)){
            System.out.println( x + " ");
        }
    }
}
