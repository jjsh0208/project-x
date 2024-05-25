package step3_2.RunBiodome01;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RunBiodome01 {
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
