package section1;

import java.util.Scanner;

public class String7 {
    /*
    설명 :
    앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.
    문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력하는 프로그램을 작성하세요.
    단 회문을 검사할 때 대소문자를 구분하지 않습니다.

    입력 :
    첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.

    출력 :
    첫 번째 줄에 회문 문자열인지의 결과를 YES 또는 NO로 출력합니다.
     */

    public String soultion (String str) {
        String answer = "YES";
        //대소문자 구분 안되도록 설정하기 (대문자던 소문자던 상관 없음)
        str = str.toUpperCase();
        //회문 문자열일 경우 길이 / 2 한 것의 몫의 전까지 구하면 된다.
        int len = str.length();

        for (int i = 0; i < len/2 ; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)){
                return "NO";
            }
        }
        return answer;


        //stringBuilder로 해보기 (reverse)
        /*

        String answer = "No";
        String tmp = new StringBuilder(str).reverse().toString();

        //equalsIgnoreCase -> 대소문자 구분 X
        if(str.equalsIgnoreCase(tmp)){
            answer = "YES";
        }
        return answer;

         */
    }

    public static void main(String[] args){
        String7 T = new String7();

        Scanner kb = new Scanner(System.in);
        System.out.println("문자를 입력해주세요 : ");
        String str = kb.next();

        System.out.println(T.soultion(str));
    }
}
