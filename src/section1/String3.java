package section1;

import java.util.Scanner;

public class String3 {
    /*
    설명 :
    한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.
    문장속의 각 단어는 공백으로 구분됩니다.

    입력 :
    첫 줄에 길이가 100을 넘지 않는 한 개의 문장이 주어집니다.
    문장은 영어 알파벳으로만 구성되어 있습니다.

    출력 :
    첫 줄에 가장 긴 단어를 출력한다. 가장 길이가 긴 단어가 여러개일 경우 문장속에서
    가장 앞쪽에 위치한 단어를 답으로 합니다.
     */

    public String soultion (String str){
        String answer = "";
        //가장 작은 값으로 초기화
        int m = Integer.MIN_VALUE;

        //띄어쓰기로 구분되어있는 문장을 String배열에 저장하는 split
        String[] s = str.split(" ");

        //가장 긴 단어를 찾기위해 길이를 구해야한다.
        for (String x : s){
            //System.out.println(x);
            //각각의 길이를 구하기
            int len = x.length();
            //가장 길이가 긴 단어가 여러개일 경우 문장속에서
            //가장 앞쪽에 위치한 단어를 답이기 때문에 >= 로 하면 안된다.
            //이유는 뒤에도 같은 길이가 있으면 = 가 들어갈 경우 뒤쪽 답으로 덮어쓰기가 될 수 있다.
            if(len > m){
                m = len;
                answer = x;
            }
        }

        /*

        int m = Integer.MIN_VALUE, pos;
        while((pos = str.indexOf(" ")) != -1){
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            if(len > m){
                m = len;
                answer = tmp;
            }
            str = str.substring(pos + 1);
        }
            if(str.length() > m){
                answer = str;

            return answer;
        }

         */

        return answer;
    }

    public static void main(String[] args){
        String3 T = new String3();
        Scanner kb = new Scanner(System.in);
        System.out.println("문장를 입력해주세요 : ");
        //단어가 아닌 한 줄을 입력받아야 하기 때문에 nextLine()
        String str = kb.nextLine();
        System.out.println(T.soultion(str));
    }
}
