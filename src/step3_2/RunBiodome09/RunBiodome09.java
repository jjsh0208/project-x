package step3_2.RunBiodome09;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RunBiodome09 {
    static Scanner sc= new Scanner(System.in);;
    static List<WaterRequestThread> threadList = new ArrayList<>();

    public static void main(String[] args) {

        threadList.add(new WaterRequestThread("테라노바"));
        threadList.add(new WaterRequestThread("루미나베이"));
        threadList.add(new WaterRequestThread("플로우브릿지"));
        threadList.add(new WaterRequestThread("루미노엣지"));

        CentralWaterCenter center =CentralWaterCenter.getInstance();

        int choice;
        System.out.println("수자원 관리 시스템에 오신걸 환영합니다.");
        while(true){
            System.out.println("1. 중앙 수자원 센터와 4개 도시 보유 물양 조회하기");
            System.out.println("2. 도시에 물 할당하기");
            System.out.println("3. 프로그램 종료하기");
            System.out.print("메뉴를 선택하세요 : ");
            try {
                choice = Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException e){
                System.out.println("숫자만 입력해주세요");
                continue;
            }

            switch (choice){
                case 1:
                    center.waterAmountCheck();
                    break;
                case 2:
                    allocateWater();
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

    private static void allocateWater() {
        for (WaterRequestThread thread : threadList){
            try{
            System.out.print(thread.getLocation()+"에 필요한 물의 양을 입력하세요: ");
            int requestedAmount = Integer.parseInt(sc.nextLine());
            if (requestedAmount < 0){
                System.out.println("마이너스값이 입력되었습니다. 다시 한번 확인해주세요.");
                return;
            }
            thread.setRequestedAmount(requestedAmount);
            }catch (NumberFormatException e ){
            System.out.println("숫자만 입력해주세요.");
            }
        }
        System.out.println("=====물 분배 시작======");

        for (WaterRequestThread thread : threadList){
            try {
                Thread t = new Thread(thread);
                t.start();
                t.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        CentralWaterCenter center =CentralWaterCenter.getInstance();
        System.out.println("최종 남은 물의 양: "+ center.getAmountWater());
    }
}
