package section1;

import java.util.Scanner;

public class String1 {

    /*
    설명:
    한 개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정문자가 입력받은 문자열에 몇 개 존재하는지 알아내는 프로그램을 작성하세요.
    대소문자를 구분하지 않습니다.문자열의 길이는 100을 넘지 않습니다.

    입력 :
    첫 줄에 문자열이 주어지고, 두 번째 줄에 문자가 주어진다.
    문자열은 영어 알파벳으로만 구성되어 있습니다.

    출력 :
    첫 줄에 해당 문자의 개수를 출력한다.
    */


    public int solution(String str, char t){
        int answer = 0;
        //str이 다 대문자가 됨
        str = str.toUpperCase();
        t = Character.toUpperCase(t);
        System.out.println("입력한 문자열: " + str + ", 찾고자 하는 문자: " + t);


		/*for(int i=0; i<str.length(); i++){
			if(str.charAt(i)==t) answer++;
		}*/

        //string을 탐색하려면 문자배열로 만들어서 탐색해야하며 , 그것은 .toCharArray() 이다.
        //.toCharArray() -> 문자열을 기준으로해서 문자배열을 생성해서 탐색한다.
        for(char x : str.toCharArray()){
            //여기서 x 는 str이 문자배열이 되고 여기 안의 각각의 문자를 뜻한다.
            if(x == t) answer++;
        }
        return answer;
    }

    public static void main(String[] args){
        String1 T = new String1();
        //콘솔 입출력용 스캐너
        Scanner kb = new Scanner(System.in);
        System.out.println("문자열과 문자를 입력해주세요 : ");
        //문자열 하나 받기 (str)
        String str = kb.next();

        //문자열애서 문자 한개만 가져와야함
        //그래서 .next() -> 옆에 , .charAt(0) -> 문자열 중 문자 하나 읽기
        char c = kb.next().charAt(0);

        System.out.print(T.solution(str, c));
    }

}
