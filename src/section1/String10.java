package section1;

import java.util.Map;
import java.util.Scanner;

public class String10 {
    /*
    설명:
    한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.

    입력:
    첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.
    문자열의 길이는 100을 넘지 않는다.

    출력:
    첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.
     */

    public int[] soultion (String s, char t) {
        //int형 배열을 동적으로 생성하기
        int[] answer = new int[s.length()];
        //임의로 크게 잡는 것
        int p = 1000;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t) {
                //현재 문자가 t와 같다면 거리는 0
                p = 0;
                answer[i] = p;
            }else {
                //현재 문자가 t와 다르다면 거리를 1 증가
                p++;
                answer[i] = p;
            }
        }
        //거리를 다시 크게 설정
        p = 1000;
        // 두 번째 루프에서는 오른쪽에서 왼쪽으로 이동하며, 각 문자가 t와 얼마나 떨어져 있는지 확인
        for (int i = s.length() -1; i >= 0; i--){
            if (s.charAt(i) == t){
                p = 0;
            }else {
                p++;
                // 왼쪽에서 오른쪽으로 갈 때와 오른쪽에서 왼쪽으로 갈 때 거리 중 더 짧은 거리를 선택
                answer[i] = Math.min(answer[i], p);
            }
        }
        // 각 문자가 t와 떨어진 최소거리가 저장된 배열을 반환
        return answer;
    }

    public static void main(String[] args){
        String10 T = new String10();

        Scanner kb = new Scanner(System.in);
        System.out.println("문자를 입력해주세요 : ");
        String str = kb.next();
        char c = kb.next().charAt(0);

        //str : 문자열, c : 문자

        for (int x : T.soultion(str, c)){
            System.out.println(x + " ");
        }

    }
}
