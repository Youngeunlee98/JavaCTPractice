package section1;

import java.util.Scanner;

public class String8 {
    /*
    설명 :
    앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 팰린드롬이라고 합니다.
    문자열이 입력되면 해당 문자열이 팰린드롬이면 "YES", 아니면 “NO"를 출력하는 프로그램을 작성하세요.
    단 회문을 검사할 때 알파벳만 가지고 회문을 검사하며, 대소문자를 구분하지 않습니다.
    알파벳 이외의 문자들의 무시합니다.

    입력 :
    첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.

    출력 :
    첫 번째 줄에 팰린드롬인지의 결과를 YES 또는 NO로 출력합니다.
     */

    //found7, time: study; Yduts; emit, 7Dnuof

    public String soultion (String s) {
        String answer = "NO";
        //replaceAll : 앞에 " " 에 해당하는 것을 뒤의 " " 로 바꾼다 전부
        //[^A-Z] -> 정규식 : 대문자 A ~ Z 까지가 아니면! 이라는 뜻
        // ^ 이 꺽쇠가 부정형이다.
        s = s.toUpperCase().replaceAll("[^A-Z]", "");
        //알파벳만 뽑아내기
        //System.out.println(s);

        String tmp = new StringBuilder(s).reverse().toString();

        if (s.equals(tmp)){
            answer = "YES";
        }

        return answer;
    }

    public static void main(String[] args){
        String8 T = new String8();

        Scanner kb = new Scanner(System.in);
        System.out.println("문자열을 입력해주세요 : ");
        String str = kb.nextLine();

        System.out.println(T.soultion(str));
    }
}
