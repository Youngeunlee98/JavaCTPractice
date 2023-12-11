package section1;

import java.util.ArrayList;
import java.util.Scanner;

public class String4 {
    /*
    설명 :
    N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.

    입력 :
    첫 줄에 자연수 N(3<=N<=20)이 주어집니다.
    두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다. 단어는 영어 알파벳으로만 구성되어 있습니다.

    출력 :
    N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집어서 출력합니다.
     */

    public ArrayList<String> soultion (int n, String[] str){
        ArrayList<String> answer = new ArrayList<>();

        for (String x : str){
            //.reverse() -> 뒤집기
            //StringBuilder 객체를 만들고 reverse를 사용해서 뒤집는다.
            //string 은 불변객체이기 때문에 연산시 계속해서 새로운걸 다시 만들고 씌우고 하다보니 메모리 낭비가 발생할 수 있음
            //StringBuilder을 사용하면 메모리 낭비 없이 사용 할 수 있다.
            String tmp = new StringBuilder(x).reverse().toString();
            //뒤집은 단어(tmp)를 answer라는 ArrayList에 담는다
            answer.add(tmp);
        }

        //특정 단어만 뒤집을려면 ?
        /*
        for(String x : str) {
            //단어를 가지는 String이 문자 배열로 만들어진다 toCharArray()
            char[] s = x.toCharArray();
            int lt = 0, rt = x.length() -1;

            while(lt < rt) {
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
            //valueOf -> static 으로 선언된 클래스의 변수
            String tmp = String.valueOf(s);
            answer.add(tmp);

        }
         */

        return answer;
    }

    public static void main(String[] args){
        String4 T = new String4();

        Scanner kb = new Scanner(System.in);
        System.out.println("단어를 여러개 입력해주세요 : ");
        int n = kb.nextInt();
        //n개의 단어들이기 때문에 배열로 String[] str 생성해서 담는다.
        String[] str = new String[n];

        for(int i = 0; i < n; i++){
            str[i] = kb.next();
        }
        //n 개수와 String 배열을 soultion 에 넘겨 출력한다.
        for (String x : T.soultion(n, str)){
            System.out.println(x);
        }
    }
}
