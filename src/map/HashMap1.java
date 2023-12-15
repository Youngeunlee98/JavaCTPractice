package map;

import java.util.HashMap;
import java.util.Scanner;

public class HashMap1 {
    /*
    설명 :
    학급 회장을 뽑는데 후보로 기호 A, B, C, D, E 후보가 등록을 했습니다.
    투표용지에는 반 학생들이 자기가 선택한 후보의 기호(알파벳)가 쓰여져 있으며 선생님은 그 기호를 발표하고 있습니다.
    선생님의 발표가 끝난 후 어떤 기호의 후보가 학급 회장이 되었는지 출력하는 프로그램을 작성하세요.
    반드시 한 명의 학급회장이 선출되도록 투표결과가 나왔다고 가정합니다.

    입력 :
    첫 줄에는 반 학생수 N(5<=N<=50)이 주어집니다.
    두 번째 줄에 N개의 투표용지에 쓰여져 있던 각 후보의 기호가 선생님이 발표한 순서대로 문자열로 입력됩니다.

    출력 :
    학급 회장으로 선택된 기호를 출력합니다.
     */

    /*
    해쉬맵은 키(key)와 값(value)으로 이루어진 쌍으로 데이터를 저장하는데, 각 키는 고유한 해시값을 가지고 있다.

    - 해시값은 키를 해시 함수에 넣어서 계산되며, 이 해시값을 인덱스로 사용하여 데이터를 저장하고 검색
    - 해시 함수는 키의 값을 고정된 길이의 해시값으로 변환하는 역할
    - 변환된 해시값을 배열의 인덱스로 사용하여 데이터를 저장하고 검색하기 때문에 매우 빠른 성능을 가지고 있다.
     */

    //주어진 두 개의 단어를 비교하여 알파벳과 그 개수가 일치하는지 확인할 것.


    public char solution(int n, String s){
        char answer = ' ';

        //hashMap 선언
        HashMap<Character, Integer> map = new HashMap<>();

        //map에 자료 채우기
        //key : 'A' , value : '3'
        //map.put('A', 3);

        for (char x : s.toCharArray()){
                    //map.getOrDefault(x,0) : x 의 키 값을 가져오되 없다면 0을 리턴해라
            map.put(x, map.getOrDefault(x, 0) +1);
        }

        int max = Integer.MIN_VALUE;

        //map 탐색하기
        for (char key : map.keySet()){
            //여기서 key 는 키값
            //map.get(key) : key의 value 값
            //System.out.println(key + " " + map.get(key));
            if(map.get(key) > max){
                max = map.get(key);
                answer = key;
            }
        }

        return answer;

    }

    public static void main(String[] args) {
        HashMap1 T = new HashMap1();

        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        String str = kb.next();

        System.out.println(T. solution(n, str));
    }
}
