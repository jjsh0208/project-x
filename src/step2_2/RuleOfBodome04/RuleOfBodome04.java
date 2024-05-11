package step2_2.RuleOfBodome04;

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
            System.out.println("========================");
            System.out.println("메뉴를 선택 하세요. ");
            System.out.println("========================");

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    addBiological();
                    break;
                case 2:
                    break;
                case 3:
                    break;
            }
        }
    }

    private static void addBiological() {
        System.out.print("생물의 이름 : ");
        String name = sc.nextLine();
        System.out.print("생물의 종류 : (동물, 식물, 미생물");
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
                System.out.println("수명 : ");
                String life = sc.nextLine();
                bs.add(new BiologicalEntity<>(name,classification ,new AnimalFeature(characteristic,characteristic,life)));
                break;
            case "식물":

                break;
            case "미생물":
                break;
            default:
                break;

        }


    }

}
