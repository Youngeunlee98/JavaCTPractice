package section1;

import java.util.Scanner;

public class String6 {
    /*
    설명 :
    소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.
    중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.

    입력 :
    첫 줄에 문자열이 입력됩니다. 문자열의 길이는 100을 넘지 않는다.

    출력 :
    첫 줄에 중복문자가 제거된 문자열을 출력합니다.
     */

    public String soultion (String str) {
        String answer = "";

        for (int i = 0; i <str.length(); i++){
            //indexOf ->
            //indexOf() 는 특정 문자나 문자열이 앞에서부터 처음 발견되는 인덱스를 반환하며
            //만약 찾지 못했을 경우 "-1"을 반환
            //System.out.println(str.charAt(i) + " " + i + " " + str.indexOf(str.charAt(i)));

            /*
                예를 들어 위 sout을 ksekkset 라는 문자로 실행했을때
                k   0   0   -> 중복X
                s   1   1   -> 중복X
                e   2   2   -> 중복X
                k   3   0   -> 중복0
                k   4   0   -> 중복0
                s   5   1   -> 중복0
                e   6   2   -> 중복0
                t   7   7   -> 중복X

                이라 출력된다. 여기서 0 0 처럼 동일 한 것은 처음 나온, 즉 중복이 아닌 것이므로 제거되서는 안되지만
                5 1 처럼 숫자가 다르면 이미 나왔던 문자이기 때문에 중복이다. 이것은 출력되면 안된다는 것이다.
             */


            //중복된 문자가 있을 경우 제거해야 한다.
            if(str.indexOf(str.charAt(i)) == i){
                //참일 때는 중복이 아닌것이고 거짓이면 중복이다.
                answer += str.charAt(i);
            }
        }
        return answer;
    }

    public static void main(String[] args){
        String6 T = new String6();

        Scanner kb = new Scanner(System.in);
        System.out.println("문자열을 입력해주세요 : ");
        String str = kb.next();

        System.out.println(T.soultion(str));
    }
}
