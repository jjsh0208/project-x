package step2_2.RuleOfBiodome07;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class RuleOfBiodome07 {
    static ArrayList<Plant> list = new ArrayList<>();
    static PlantManagement pm;
    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        pm = new PlantManagement();
        while (true) {
            System.out.println("========================");
            System.out.println("1. 식물 객체 생성");
            System.out.println("2. 식물 관리 시스템 생성 및 등록");
            System.out.println("3. 식물 관리");
            System.out.println("4. 식물 리스트 초기화");
            System.out.println("========================");
            System.out.println("메뉴를 선택 하세요. ");
            System.out.println("========================");

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("(식물 객체 생성)");
                    createPlant();
                    break;
                case 2:
                    System.out.println("(식물 관리 시스템 생성 및 등록)");
                    if (pm == null) pm = new PlantManagement();
                    addPlant();
                case 3:
                    pm.management();
                    break;
                case 4:
                
            }
        }
        
    }

    private static void createPlant() {

        while(true){
            System.out.print("식물을 추가하시겠습니까? (1. 예 / 2. 아니오)");
            int choice = Integer.parseInt(sc.nextLine());
            if (choice == 2){
                break;
            }
            System.out.print("식물의 이름 : ");
            String name = sc.nextLine();
            System.out.print("식물의 종류 : ");
            String type = sc.nextLine();
            System.out.print("필요한 물의 양: ");
            int needWater = Integer.parseInt(sc.nextLine());
            System.out.print("물의 공급 주기 : ");
            int waterCycle = Integer.parseInt(sc.nextLine());
            System.out.print("마지막 공급 일자 : ( 예) 2024 05 13 시:12 분:30)");
            String date = sc.nextLine();
            String[] dateParts = date.split(" ");

            int year = Integer.parseInt(dateParts[0]);
            int month = Integer.parseInt(dateParts[1]);
            int day = Integer.parseInt(dateParts[2]);
            int hour = Integer.parseInt(dateParts[3]);
            int minute = Integer.parseInt(dateParts[4]);
            LocalDateTime lastWatered = LocalDateTime.of(year,month,day,hour,minute,0);

            list.add(new Plant(name,type,needWater,waterCycle,lastWatered));
        }
    }

    private static void addPlant() {

        for (Plant p : list){
            pm.offer(p);
        }
    }

}