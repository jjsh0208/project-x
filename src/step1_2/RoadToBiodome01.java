package step1_2;

import java.util.Arrays;

public class RoadToBiodome01 {

    public static int solution(int[] list){
        int result = 0, cnt = 0;

        for(int num : list){
            for(int i = 0; i < list.length; i++)
            { if(num == list[i]) cnt++;}
            if(cnt == 1) return num;
            cnt = 0;
        }
        return 0;
    }

    public static void main(String[] args) {
        // Command Line Arguments를 입력받을 때 "$Prompt$" 따옴표로 감싸 하나의 문자열로 받아 args[0]에 저장
        // trim()으로 문자열 앞뒤의 공백을 제거하고, split(",")으로 ","를 기준으로 분리
        // mapToInt() 람다식을 사용하여 각 요소의 공백을 제거하고 정수형으로 변환
        // 변환된 정수들을 배열로 반환하고, 그 배열을 solution 메서드의 인자로 전달
        int [] result = Arrays.stream(args[0].trim().split(","))
                .mapToInt(s -> Integer.parseInt(s.trim()))
                .toArray();
        for(int i : result){
            if(!(i >= 0 && i <= 1000)){
                System.out.println("입력된 값의 범위가 올바르지 않습니다. 0에서 1000까지의 값을 입력해주세요.");
                return;
            }
        }

        System.out.println(solution(result));
    }
}
