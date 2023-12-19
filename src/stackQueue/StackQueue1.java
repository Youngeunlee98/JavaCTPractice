package stackQueue;

import java.util.Scanner;
import java.util.Stack;

public class StackQueue1 {
    /*
    설명:
    괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.
    (())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.

    입력 :
    첫 번째 줄에 괄호 문자열이 입력됩니다. 문자열의 최대 길이는 30이다.

    출력 :
    첫 번째 줄에 YES, NO를 출력한다.
     */

    public String solution(String str) {
        String answer = "Yes";
        Stack<Character> stack = new Stack<>();

        for (char x : str.toCharArray()) {
            if (x == '(') stack.push(x);
            else {
                //여는 괄호가 아닐때 스택이 비어있으면
                if (stack.isEmpty()) {
                    return "NO";
                } else {
                    //스택에 상단에 하나 꺼내기
                    stack.pop();
                }
            }
        }

        if (!stack.isEmpty()){
            return "NO!";
        }
            return answer;

    }





    public static void main(String[] args) {
        StackQueue1 T = new StackQueue1();

        Scanner kb = new Scanner(System.in);

        String str = kb.next();
        System.out.println(T.solution(T.solution(str)));
    }
}
