package step3_2.RunBiodome04;


import java.util.Scanner;

public class RunBiodome04 {
    static FruitStore fs;
    static  Scanner sc;
    public static void main(String[] args) {
         fs = new FruitStore();
         sc = new Scanner(System.in);
        System.out.println("과일 상점에 오신 것을 환영합니다!");

        int choice;
        while(true){
            System.out.println("\n1. 모든 과일 재고 조회하기");
            System.out.println("2. 가장 많이 팔린 과일 조회하기");
            System.out.println("3. 총 판매 과일 수 조회하기");
            System.out.println("4. 과일별 평균 판매 개수 조회하기");
            System.out.println("5. 과일 날짜별 판매량 및 총 판매량 조회");
            System.out.println("6. 종료하기");
            System.out.print("메뉴를 선택하세요: ");
            choice = Integer.parseInt(sc.nextLine());

            switch(choice){
                case 1:
                    fs.show();
                    break;
                case 2:
                    fs.maxSell();
                    break;
                case 3:
                    fs.totalSell();
                    break;
                case 4:
                    fs.averageSell();
                    break;
                case 5:
                    System.out.print("검색할 과일의 이름 : ");
                    String fruit = sc.nextLine();
                    fs.searchSell(fruit);
                    break;
                case 6:
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("존재하지 않는 메뉴입니다. 1번에서 5번을 선택해주세요");
                    break;
            }
        }
    }


}
