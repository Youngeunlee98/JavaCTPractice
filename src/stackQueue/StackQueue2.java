package stackQueue;

import java.util.Scanner;
import java.util.Stack;

public class StackQueue2 {
    /*
    설명 :
    입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램을 작성하세요.

    입력 :
    첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.

    출력 :
    남은 문자만 출력한다.
     */

    public String solution(String str) {
        String answer = "";
        Stack<Character> stack = new Stack<>();

        for (char x : str.toCharArray()){
            if (x == ')') {
                //stack.pop 제일 상단에 있는걸 꺼내고 그값을 리턴
                while(stack.pop()!= '(');
            }else stack.push(x);
        }
        for (int i = 0; i < stack.size(); i++) {
            answer+= stack.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        StackQueue2 T = new StackQueue2();

        Scanner kb = new Scanner(System.in);

        String str = kb.next();
        System.out.println(T.solution(T.solution(str)));
    }
}
