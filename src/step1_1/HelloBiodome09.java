package step1_1;

public class HelloBiodome09 {

    public static void main(String[] args) {
        // 입력 인자 검사
        if(args.length < 1 || args.length > 2) {
            System.out.println("잘못된 입력입니다.");
            return;
        }

        int num = 0;
        char ch = '*'; // 기본값으로 '*' 설정

        // 숫자 유효성 검사 및 파싱
        if(args[0].matches("^[0-9]+$")) {
            num = Integer.parseInt(args[0]);
        } else {
            System.out.println("숫자만 입력해 주세요.");
            return;
        }

        // 숫자 범위 검사
        if(num < 3 || num > 100) {
            System.out.println("3 ~ 100 범위 안의 숫자만 입력해 주세요.");
            return;
        }

        // 두 번째 인자가 있으면 특수 문자로 설정
        if(args.length == 2) {
            ch = args[1].charAt(0);
        }

        // 별 그리기
        for(int i = 0; i < num; i++) {
            // 공백 출력
            for(int j = 0; j < num - i - 1; j++) {
                System.out.print(" ");
            }
            // 별 또는 특수 문자 출력
            for(int j = 0; j < i * 2 + 1; j++) {
                if(args.length == 2 && j == i) { // 중앙에 특수 문자 출력
                    System.out.print(ch);
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }

        // 마지막 줄 출력
        for(int i = 0; i < num - 1; i++) {
            System.out.print(" ");
        }
        System.out.println("|");
    }
}
