package step3_1.BiodomeForever08;


import java.util.Scanner;

public class BiodomeForever08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EnvironmentDataManager em = new EnvironmentDataManager();
        int choice = 0;
        System.out.println("환경 데이터 검색 및 수정 프로그램에 오신 것을 환영합니다!");
        while(true){
            System.out.println("1.날짜 검색  2. 날짜 범위 검색  3. 종료");
            choice = Integer.parseInt(sc.nextLine());
            switch(choice){
                case 1:
                    System.out.print("검색하고 싶은 날짜를 입력하세요: ");
                    String date = sc.nextLine();
                    em.searchAndUpdate(date);//2130-11-12
                    break;
                case 2:
                    System.out.println("검색하고 싶은 날짜 범위를 입력하세요.");
                    System.out.print("시작 날짜 : ");
                    String startDate = sc.nextLine();
                    System.out.print("종료 날짜 : ");
                    String endDate = sc.nextLine();
                    em.RangeSearch(startDate,endDate);
                    break;
                case 3:
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    break;
            }




        }

    }
}
