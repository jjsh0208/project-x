package step3_1.BiodomeForever06;

import java.util.Scanner;

public class BiodomeForever06 {
    static Scanner sc;
    static ResearcherManager rm;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        rm = new ResearcherManager();

        while(true){
            System.out.println("-----------------------------------");
            System.out.println("연구원 정보 관리 시스템");
            System.out.println("-----------------------------------");
            System.out.println("1. 새로운 연구자 등록");
            System.out.println("2. 모든 연구자 조회");
            System.out.println("3. 조건 기반 연구자 검색");
            System.out.println("4. 프로그램 종료");
            System.out.println("-----------------------------------");
            System.out.print("선택하세요 (1-4): ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    addResearcher();
                    break;
                case 2:
                    rm.readAll();
                    break;
                case 3:
                    searchResearcher();
                    break;
                case 4:
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("1~4 중에 선택해주세요.");
                    break;
            }

        }
    }

    private static void searchResearcher() {
        System.out.print("검색할 연구원의 ID를 입력하세요 : ");
        String id = sc.nextLine();
        rm.searchResearcher(id);
    }


    private static void addResearcher() {
        System.out.print("연구원의 이름을 입력하세요: ");
        String name = sc.nextLine();
        System.out.print("연구원의 담당 위치를 입력하세요: ");
        String position = sc.nextLine();

        rm.addResearcher(name,position);
    }
}

