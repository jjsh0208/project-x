package step3_2.RunBiodome07;

import java.util.Scanner;

public class RunBiodome07 {
    //싱글톤 : 싱클톤이 적용된 클래스의 인스턴스는 애플리케이션 전역에서 단 하나만 존재하도록 보장해야한다. (static)
    static Scanner sc;
    static EnergyManageCenter center;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        center = EnergyManageCenter.getInstance();
        int choice;
        System.out.println("에너지 관리 시스템에 오신걸 환영합니다.");
        while(true){
            System.out.println("1. 중앙 에너지 센터와 3개 도시 에너지양 조회하기");
            System.out.println("2. 도시에 에너지 할당하기");
            System.out.println("3. 중앙 에너지 센터 에너지 보충하기");
            System.out.println("4. 프로그램 종료하기");
            System.out.print("메뉴 선택 : ");
            try {
                choice = Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException e){
                System.out.println("숫자만 입력해주세요.");
                continue;
            }

            switch (choice){
                case 1:
                    center.energyCheck();
                    break;
                case 2:
                    energyAssign();
                    break;
                case 3:
                    energyAdd();
                    break;
                case 4:
                    System.out.println("\n프로그램을 종료합니다.");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("1~3중에 선택해주세요.");
                    break;
            }
        }
    }

    private static void energyAdd() {
        System.out.print("보충할 에너지양 입력: ");
        try {
            int energy = Integer.parseInt(sc.nextLine());
            center.energyAdd(energy);
        }catch (NumberFormatException e){
            System.out.println("숫자만 입력해주세요.");
        }
    }

    private static void energyAssign() {
        System.out.print("도시 이름 입력 : ");
        String name = sc.nextLine();
        System.out.print("할당할 에너지양 입력 : ");
        try {
            int energy = Integer.parseInt(sc.nextLine());
            center.energyAssign(name,energy);
        }catch (NumberFormatException e){
            System.out.println("숫자만 입력해주세요.");
        }
    }
}
