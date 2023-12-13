package section1;

import java.util.Scanner;

public class String11 {
    /*
    설명:
    알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는
    문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
    단 반복횟수가 1인 경우 생략합니다.

    입력:
    첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.

    출력:
    첫 줄에 압축된 문자열을 출력한다.
     */
    public String soultion (String s) {
        //압축된 문자열을 저장할 변수
        String answer = "";
        //마지막 문자와 비교할 수 있도록 입력 문자열 끝에 공백 문자를 추가
        s = s+ " ";
        //연속된 문자의 개수를 세는 변수를 선언 : 초기값은 1
        int cnt = 1;
        // s.length() -1 인 이유: 빈문자 전까지만 i 가 가도록.
        for (int i = 0; i < s.length() -1; i++) {
            //i 지점과 i+1 지점이 같으면 cnt 증가
            //즉, 현재 문자와 다음 문자가 같다면 cnt를 1 증가
            if (s.charAt(i) == s.charAt(i + 1)){
                cnt++;
            }else {
                //현재 문자와 다음 문자가 다르다면 현재 문자를 answer에 추가
                answer += s.charAt(i);
                //cnt가 1보다 크다면 연속된 문자의 개수이므로 answer에 추가
                if (cnt > 1){
                    answer += String.valueOf(cnt);
                    cnt = 1;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String11 T = new String11();

        Scanner kb = new Scanner(System.in);
        System.out.println("문자를 입력해주세요 : ");
        String str = kb.next();

        System.out.println(T.soultion(str));

    }
}
