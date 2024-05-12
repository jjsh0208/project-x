package step2_2.RuleOfBiodome04;

import java.util.Scanner;

public class RuleOfBodome04 {
    static Scanner sc;
    static BiologicalSystem bs;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        bs = new BiologicalSystem();
        while (true) {
            System.out.println("========================");
            System.out.println("1. 생물 추가");
            System.out.println("2. 생물 삭제");
            System.out.println("3. 최근 등록 생물");
            System.out.println("4. 생물 리스트 확인");
            System.out.println("5. 생물 리스트 초기화");
            System.out.println("6. 이름기준 오름차순");
            System.out.println("========================");
            System.out.println("메뉴를 선택 하세요. ");
            System.out.println("========================");

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    addBiological();
                    break;
                case 2:
                    bs.delete();
                    break;
                case 3:
                    bs.show();
                    break;
                case 4:
                    bs.isEmpty();
                    break;
                case 5:
                    bs.clear();
                    break;
                case 6:
                    bs.sortByName();
                    break;
                default:
                    System.out.println("1~5 의 메뉴만 선택해주세요");
                    break;
            }
        }
    }

    private static void addBiological() {
        System.out.print("생물의 이름 : ");
        String name = sc.nextLine();
        System.out.print("생물의 종류 (동물, 식물, 미생물) : ");
        String type = sc.nextLine();
        while (!(type.equals("동물") || type.equals("식물") || type.equals("미생물"))) {
            System.out.println("입력하신 생물은 유효하지 않습니다. 동물, 식물, 미생물 중에서 선택해주세요.");
            type = sc.nextLine();
        }
        switch (type){
            case "동물":
                System.out.print("특징 : ");
                String characteristic = sc.nextLine();
                System.out.print("분류 : ");
                String classification = sc.nextLine();
                System.out.print("수명 : ");
                String life = sc.nextLine();
                bs.add(new BiologicalEntity<>(name,type ,new AnimalFeature(characteristic,classification,life)));
                break;
            case "식물":
                System.out.print("색깔 : ");
                String color = sc.nextLine();
                System.out.print("열매 유무 : ");
                String fruit = sc.nextLine();
                System.out.print("개화 시기 : ");
                String flowering = sc.nextLine();
                bs.add(new BiologicalEntity<>(name,type,new PlantFeature(color,fruit,flowering)));
                break;
            case "미생물":
                System.out.print("산성지수 : ");
                String ph = sc.nextLine();
                System.out.print("대사 방식 : ");
                String metabolism = sc.nextLine();
                bs.add(new BiologicalEntity<>(name,type,new MicrobeFeature(ph,metabolism)));
                break;
            default:
                break;

        }
    }

}
