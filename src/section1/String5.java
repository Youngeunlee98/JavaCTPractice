package section1;

import java.util.ArrayList;
import java.util.Scanner;

public class String5 {
    /*
    설명 :
    영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,
    특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.

    입력 :
    첫 줄에 길이가 100을 넘지 않는 문자열이 주어집니다.

    출력 :
    첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다.
     */
    public String soultion (String str) {
        String answer;
        //String 기반 문자배열 생성
        char[] s = str.toCharArray();
        int lt = 0, rt = str.length() -1;

        while(lt < rt){
            //특수문자를 만났을때 참이 되야 하니까 알파벳이 아닐 때 참이 되도록하기
            if(!Character.isAlphabetic(s[lt])){
                lt++;
            } else if (!Character.isAlphabetic(s[rt])) {
                rt--;
            }else {
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
        }
        answer = String.valueOf(s);
        return answer;
    }

    public static void main(String[] args){
        String5 T = new String5();

        Scanner kb = new Scanner(System.in);
        System.out.println("단어를 입력해주세요 : ");
        String str = kb.next();

        System.out.println(T.soultion(str));

    }
}
