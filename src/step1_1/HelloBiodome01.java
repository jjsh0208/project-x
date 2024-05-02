package step1_1;

import java.util.Arrays;

public class HelloBiodome01 {
    public static void main(String[] args) {
		/*
		커맨드 라인 인자로 입력 받기
        IDE에서 실행할 경우, 상단의 Run 메뉴 -> Run configurations -> Arguments -> Program Arguments에 입력 값을 설정
        ${string_prompt} 작성 시 직접 입력받을 수 있음
        ${string_prompt}를 ""로 감싸 입력받는 값을 하나의 문자열로 저장
        이 때, 입력 값은 args 배열에 문자열 형태로 저장됩니다. 공백을 기준으로 문자열이 분리되어 배열의 다음 인덱스에 저장
        예) 입력 값이 "김 민수"인 경우
            args[0]은 "김"
            args[1]은 "민수"가 됩니다.
		*/
        // args 배열이 비어있거나 첫 번째 요소가 빈 경우, 사용자에게 입력을 요구
        if ( args.length == 0 || args[0].isEmpty()) {
            System.out.println("한글자 이상 입력해주세요.");
            return;
        }

        // 첫 번째 입력 값에서 공백을 기준으로 문자열을 분리하여 name 배열에 저장
        // "\\s+"는 하나 이상의 공백 문자(space, tab 등)를 의미하는 정규 표현식
        String[] name = args[0].split("\\\\s+");

        // 분리된 문자열 배열(name)의 길이에 따라 다른 인사말을 출력
        if(name.length == 1) {
            System.out.println("안녕하세요, " + name[0] + "님 :)");
        }
        else if(name.length == 2){
            System.out.println("안녕하세요, " + name[0] + name[1] + "님 :)");
        }

        // bonus
        // 이름(입력값 전체)의 길이가 항상 10글자를 넘는다고 가정하고, 10번째 이후 문자를 잘라서 출력한다
        String name1 = args[0];

        // 입력된 전체 이름의 길이가 10글자를 초과하는 경우

        // 이름을 문자(char) 배열로 변환한 뒤, 0부터 10번째 인덱스까지의 문자만을 새로운 배열로 복사
        char[] charArray1 = name1.toCharArray();
        char[] charArray2 =  Arrays.copyOfRange(charArray1, 0, 10);//copyOfRange(복사할 배열, 시작 인덱스, 끝인덱스)


        // 복사된 배열을 이용해 새로운 문자열 생성
        name1 = new String(charArray2);

        // 수정된 이름으로 인사말 출력
        System.out.println("안녕하세요, " + name1 + "님 :)");

    }
}