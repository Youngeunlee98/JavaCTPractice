package stackQueue;

import java.util.Scanner;
import java.util.Stack;

public class StackQueue5 {
    /*
    설명:
    여러 개의 쇠막대기를 레이저로 절단하려고 한다. 효율적인 작업을 위해서 쇠막대기를 아래에서 위로 겹쳐 놓고,
    레이저를 위에서 수직으로 발사하여 쇠막대기들을 자른다. 쇠막대기와 레이저의 배치는 다음 조건을 만족한다.

    • 쇠막대기는 자신보다 긴 쇠막대기 위에만 놓일 수 있다.
    - 쇠막대기를 다른 쇠막대기 위에 놓는 경우 완전히 포함되도록 놓되,끝점은 겹치지 않도록 놓는다.
    • 각 쇠막대기를 자르는 레이저는 적어도 하나 존재한다.
    • 레이저는 어떤 쇠막대기의 양 끝점과도 겹치지 않는다.

    수평으로 그려진 굵은 실선은 쇠막대기이고, 점은 레이저의 위치,
    수직으로 그려진 점선 화살표는 레이저의 발사 방향이다.

    이러한 레이저와 쇠막대기의 배치는 다음과 같이 괄호를 이용하여 왼쪽부터 순서대로 표현할 수 있다.
    1. 레이저는 여는 괄호와 닫는 괄호의 인접한 쌍 ‘( ) ’ 으로 표현된다. 또한, 모든 ‘( ) ’는 반 드시 레이저를 표현한다.
    2. 쇠막대기의 왼쪽 끝은 여는 괄호 ‘ ( ’ 로, 오른쪽 끝은 닫힌 괄호 ‘) ’ 로 표현된다.

    이와 같은 방식으로 주어진 쇠막대기들은 총 17개의 조각으로 잘려진다.
    쇠막대기와 레이저의 배치를 나타내는 괄호 표현이 주어졌을 때, 잘려진 쇠막대기 조각의 총 개수를 구하는 프로그램을 작성하시오.

    입력 :
    한 줄에 쇠막대기와 레이저의 배치를 나타내는 괄호 표현이 공백없이 주어진다.
    괄호 문자의 개수는 최대 100,000이다.

    출력 :
    잘려진 조각의 총 개수를 나타내는 정수를 한 줄에 출력한다.
     */

    public int solution(String str){
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') stack.push('(');
            else{
                stack.pop();
                if(str.charAt(i-1) == '(') answer += stack.size();
                else answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        StackQueue5 T = new StackQueue5();

        Scanner kb = new Scanner(System.in);

        String str = kb.next();
        System.out.println(T.solution(str));
    }
}