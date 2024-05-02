package step2_1.BiodomeFamily02;


import java.util.Scanner;

public class BiodomeFamily02 {

    public static void main(String[] args) {
        LifeNest Ln = new LifeNest();
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("========================");
            System.out.println("1. 동식물추가");
            System.out.println("2. 동식물삭제");
            System.out.println("3. 동식물조회");
            System.out.println("4. 동식물검색");
            System.out.println("5. 동식물수정");
            System.out.println("6. 시스템종료");
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
                    System.out.print("동식물의 특징 : " );
                    String characteristic = sc.nextLine();
                    System.out.print("동식물의 수명 : ");
                    String lifeSpan = sc.nextLine();
                    Ln.OrganismAdd(new Organism(name,type,habitat,characteristic,lifeSpan));
                    break;
                case 2:
                    System.out.print("삭제할 동물의 이름을 입력하세요 : ");
                    String removeName = sc.nextLine();
                    Ln.OrganismRemove(removeName);
                    break;
                case 3:
                    System.out.println("전체 동식물 목록 출력 : ");
                    for (Organism O : Ln.organismList){
                        O.displayInfo();
                    }
                    break;
                case 4:
                    System.out.println("검색할 동물의 이름을 입력하세요 : ");
                    String searchName = sc.nextLine();
                    Ln.searchOrganismByName(searchName);
                    break;
                case 5:
                    System.out.println("변경할 속성을 고르세요 (1. 서식지) (2. 특징) : ");
                    int cho = Integer.parseInt(sc.nextLine());
                    switch (cho){
                        case 1:
                            System.out.println("서식지를 변경할 동물의 이름을 입력하세요 : ");
                            String updateName = sc.nextLine();
                            System.out.println("변경할 서식지를 입력해주세요 : ");
                            String HabitatUpdate = sc.nextLine();
                            Ln.habitatUpdate(updateName,HabitatUpdate);
                            break;
                        case 2://characteristic
                            System.out.println("특징을 변경할 동물의 이름을 입력하세요 : ");
                            String updateName1 = sc.nextLine();
                            System.out.println("변경할 특징을 입력해주세요 : ");
                            String characteristicUpdate = sc.nextLine();
                            Ln.characteristicUpdate(updateName1,characteristicUpdate);
                            break;
                    }
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        }
    }
}
