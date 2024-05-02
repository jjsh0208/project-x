package step1_1;


public class HelloBiodome02 {
    public static void main(String[] args) {

        int  a = Integer.parseInt(args[0]);
        int  b = Integer.parseInt(args[1]);
        int  c = Integer.parseInt(args[2]);

        if(a > 30000 || a < 0 || b > 30000 || b < 0 || c > 30000 || c < 0) {
            System.out.println("각 에너지 생산량의 최대값은 30,000이고 음수가 될 수 없습니다.");
            return;
        }

        int sum = 0; //입력된 에너지 생산량의 총합을 저장할 정수 변수

        sum = a + b + c;

        // 총 에너지 생산량 출력
        System.out.println("총 에너지 생산량은 "+sum + "입니다.");

        //bonus

        double aa = ((double) a / sum) * 100;
        double bb = ((double) b / sum) * 100;
        double cc = ((double) c / sum) * 100;

        System.out.printf("태양광 %.9f%% 풍력 %.9f%% 지열 %.9f%%\n", aa, bb, cc);
    }
}
