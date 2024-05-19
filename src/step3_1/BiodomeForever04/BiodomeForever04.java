package step3_1.BiodomeForever04;

import java.util.Scanner;

public class BiodomeForever04 {
    static Scanner sc;
    static EcoDataManager em;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        em = new EcoDataManager();

        while(true){
            System.out.println("\n1. 새로운 환경 데이터 입력");
            System.out.println("2. 모든 환경 데이터 조회");
            System.out.println("3. 날짜별 산소 수치만 조회");
            System.out.println("4. 프로그램 종료");
            System.out.print("선택 : ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    inputEco();
                    break;
                case 2:
                    em.read();
                    break;
                case 3:
                    em.oxygenRead();
                    break;

                case 4:
                    System.out.println("프로그램을 종료합니다. 감사합니다.");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("1,2,3 중에 입력");
                    break;

            }
        }
    }

    private static void inputEco() {
        try {
            System.out.print("온도 : ");
            float temperature = Float.parseFloat(sc.nextLine());
            System.out.print("습도 : ");
            float humidity = Float.parseFloat(sc.nextLine());
            System.out.print("산소 농도 : ");
            float oxygenLevel = Float.parseFloat(sc.nextLine());
            System.out.print("측정 장소 : ");
            String Location = sc.nextLine();
            em.write(new EcoData(temperature,humidity,oxygenLevel,Location));
        }catch (NumberFormatException e){
            System.out.println("잘못된 값입니다. 온도는 숫자로 입력해주세요.");
        }
    }
}

