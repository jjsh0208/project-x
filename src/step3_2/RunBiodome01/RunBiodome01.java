package step3_2.RunBiodome01;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RunBiodome01 {

    /*
    * [과제 목표]

Java의 Stream API 개념을 이해한다.
Stream의 중간 연산과 최종 연산을 사용하여 데이터를 효율적으로 처리하는 방법을 익힌다.
[기능 요구사항]

사용자로부터 회원 정보 데이터(문자열)를 입력받는다.
입력받은 데이터 중 신입-으로 시작하는 회원의 이름을 필터링해 환영인사를 출력한다.
[구현 지침]

프로젝트 이름은 RunBiodome01이다.
Java의 스트림 API를 활용한다.
입력받은 문자열을 배열 리스트에 담는다.
filter를 사용하여 문자열 데이터 중 신입-으로 시작하는 문자를 추출한다
map을 활용하여 신입 회원의 이름에 "님 환영합니다" 메시지를 추가한다.
Collectors.toList()을 사용하여 결과 문자열을 생성한다
main 함수에서 사용자 입력 값을 받아 신입 회원 환영 메시지 출력 기능을 시뮬레이션한다.
    * */
    public static void main(String[] args) {
        //[신입-하브, 멤버-세이지, 신입-아마라, 운영진-아이샤, 신입-미호, 멤버-하린, 멤버-캐머린, 운영진-리즈키, 신입-라스코, 신입-제레드]
        Scanner sc = new Scanner(System.in);
        System.out.println("멤버 리스트를 입력하세요: ");
        String[] members = sc.nextLine().replaceAll("[\\[\\]]","") .split(", ");

        //.collect(Collectors.toList()) 와 toList 동일
//        List<String> test =  Arrays.stream(members)
//                .filter(s -> s.startsWith("신입-"))
//                .map(s -> s+"님 환영합니다").toList();
//
//        System.out.println(">>>");
//        System.out.println(Arrays.toString(test.toArray()));

        //bonus
        Map<String ,List<String>> grouping = Arrays.stream(members)
                .collect(Collectors.groupingBy(s -> {
                    if (s.startsWith("신입-")) {
                        return "신입 멤버";
                    }else if (s.startsWith("멤버-")){
                        return  "일반 멤버";
                    }else {
                        return "운영진";
                    }
                }));

        List<String> newMember = grouping.getOrDefault("신입 멤버", Collections.emptyList()).stream().map(m -> m.replace("신입-","")) .toList();

        List<String> member =  grouping.getOrDefault("일반 멤버", Collections.emptyList()).stream().map(m -> m.replace("멤버-","")).toList();

        System.out.println(">>>");
        System.out.print("신입 멤버: ");
        System.out.println(Arrays.toString(newMember.toArray()));
        System.out.print("일반 멤버: ");
        System.out.println(Arrays.toString(member.toArray()));

    }
}
