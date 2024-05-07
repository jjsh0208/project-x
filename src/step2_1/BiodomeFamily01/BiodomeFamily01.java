package step2_1.BiodomeFamily01;

import java.util.Scanner;

public class BiodomeFamily01 {

    public static void main(String[] args) {
        LifeNest Ln = new LifeNest();
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("========================");
            System.out.println("1. 동식물추가");
            System.out.println("2. 동식물삭제");
            System.out.println("3. 동식물조회");
            System.out.println("4. 동식물검색");
            System.out.println("5. 시스템종료");
            System.out.println("========================");
            System.out.println("메뉴를 선택 하세요. ");
            System.out.println("========================");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice){
                case 1:
                    System.out.print("동식물의 이름 : ");
                    String name = sc.nextLine();
                    System.out.print("동식물의 종 : " );
                    String type = sc.nextLine();
                    System.out.print("동식물의 서식지 : ");
                    String habitat = sc.nextLine();
                    Ln.OrganismAdd(new Organism(name,type,habitat));
                    break;
                case 2:
                    System.out.print("삭제할 동물의 이름을 입력하세요 : ");
                    String removeName = sc.nextLine();
                    Ln.OrganismRemove(removeName);
                    break;
                case 3:
                    int id = 1;
                    System.out.println("전체 동식물 목록 출력 : ");
                    for (Organism O : Ln.organismList){
                        System.out.print(id++ + ". ");
                        O.displayInfo();
                    }
                    break;
                case 4:
                    System.out.println("검색할 동물의 이름을 입력하세요 : ");
                    String searchName = sc.nextLine();
                    Ln.searchOrganismByName(searchName);
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }
}
