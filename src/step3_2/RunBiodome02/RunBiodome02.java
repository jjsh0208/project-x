package step3_2.RunBiodome02;

import java.util.Scanner;

public class RunBiodome02 {
    static Scanner sc;
    static  EnergyDistributor ed;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        ed = new EnergyDistributor();


        System.out.println("바이오도메 에너지 관리 시스템에 오신 것을 환영합니다.");
        int choice;
        while(true){

            System.out.println("\n1. 전체 에너지 조회하기");
            System.out.println("2. 특정 구역 에너지 할당하기");
            System.out.println("3. 구역별 에너지 조회하기");
            System.out.println("4. 종료하기\n");

            System.out.print("메뉴를 선택하세요: ");
            choice = Integer.parseInt(sc.nextLine());
            System.out.println();
            switch (choice){
                case 1:
                    ed.energyCheck(); //전체 에너지 조회하기:
                    break;
                case 2:
                    //테라노바 루미나베이 플로우브릿지
                     addEnergy(); //특정 구역 에너지 할당하기
                    break;
                case 3:
                    ed.locationCheck();
                    break;
                case 4:
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println(">>> 1번에서 4번 메뉴를 선택해주세요.");
                    break;
            }

        }
    }

    private static void addEnergy() throws NumberFormatException {
        System.out.print("할당하려는 구역 이름을 입력하세요: ");
        String location = sc.nextLine();
        System.out.print("할당하려는 에너지량을 입력하세요: ");
        Integer energy = Integer.parseInt(sc.nextLine());

        ed.addEnergy(location,energy);
    }
}
