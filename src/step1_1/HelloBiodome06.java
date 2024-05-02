package step1_1;

import java.util.Arrays;

public class HelloBiodome06 {

    public static boolean isequals(String c1, String c2) {
        if(c1.length() != c2.length()) return false;

        char[] code1 = c1.toCharArray();
        char[] code2 = c2.toCharArray();
        for(int i = 0; i < code1.length; i++) {
            if(code1[i] != code2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        if (args.length != 2 || Arrays.stream(args).anyMatch(s -> s.length() < 5 || s.length() > 20)) {
            System.out.println("5개 이상 20미만의 두 개의 유전자 코드를 입력해주세요.");
            return;
        }

        //두 문자열이 동일한지 검사
        if(isequals(args[0],args[1])) {
            System.out.println(args[0] + " " + args[1]);
            System.out.println("동일한 유전자 코드입니다.");
        }
        //첫 번째 문자열가 두 번째 문자열에 부분적으로 포함되는지 검사
        else if(args[1].contains(args[0])){
            System.out.println(args[0] + " " + args[1]);
            System.out.println("부분적으로 포함됩니다.");
        }
        //모든 조건에 만족하지못할 시
        else {
            System.out.println(args[0] + " " + args[1]);
            System.out.println("일치하지 않습니다.");
        }
    }

}
