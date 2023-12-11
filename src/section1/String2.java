package section1;

import java.util.Scanner;

public class String2 {
    /*
    설명 :
    대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.

    입력 :
    첫 줄에 문자열이 입력된다. 문자열의 길이는 100을 넘지 않습니다.
    문자열은 영어 알파벳으로만 구성되어 있습니다.

    출력 :
    첫 줄에 대문자는 소문자로, 소문자는 대문자로 변환된 문자열을 출력합니다.
     */


    public String soultion (String str){
        String answer = "";

        for (char x : str.toCharArray()){
            //문자가 소문자면 대문자로 바꿔서 누적한다
            if(Character.isLowerCase(x)){
                answer += Character.toUpperCase(x);
            }else {
                //문자가 대문자면 소문자로 바꿔서 누적한다.
                answer += Character.toLowerCase(x);
            }
        }

        //아스키 넘버로 대문자 : 65 ~ 90 , 소문자 :  97 ~ 122
        //대소문자 변화는 소문자에서 32 를 빼면 대문자가 된다.
        //아스키 넘버를 활용한 방법
        /*

        for (char x : str.toCharArray()){
            if(x >= 65 && x <= 90){
                answer += (char)(x + 32);
            } else {
                answer += (char)(x - 32);
            }
        }

         */

        return answer;
    }

    public static void main(String[] args){
        String2 T = new String2();

        Scanner kb = new Scanner(System.in);
        System.out.println("문자열과 문자를 입력해주세요 : ");
        //문자열 하나 받기 (str)
        String str = kb.next();

        System.out.println(T.soultion(str));
    }
}
