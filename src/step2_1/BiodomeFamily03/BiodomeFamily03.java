package step2_1.BiodomeFamily03;

import java.util.Scanner;

public class BiodomeFamily03 {
    static LifeNest Ln;
    static Scanner sc;
    public static void main(String[] args) {
        Ln = new LifeNest();
        sc = new Scanner(System.in);

        while (true){
            System.out.println("========================");
            System.out.println("1. 동식물추가");
            System.out.println("2. 동식물삭제");
            System.out.println("3. 동식물조회");
            System.out.println("4. 시스템종료");
            System.out.println("========================");
            System.out.println("메뉴를 선택 하세요. ");
            System.out.println("========================");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice){
                case 1:
                    Ln.addOrganism();
                    break;
                case 2:
                    System.out.print("삭제할 동식물의 이름을 입력하세요 : ");
                    String removeName = sc.nextLine();
                    Ln.removeOrganism(removeName);
                    break;
                case 3:
                    Ln.displayAll();
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }
}
