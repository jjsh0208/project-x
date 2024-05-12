package step2_2.RuleOfBiodome05;


//식물 저장 : 식물의 이름을 키(key)로, 해당 식물의 특징을 값(value)으로 저장한다.
//식물 조회 : 식물의 이름을 입력받아 식물의 특징을 출력한다.
//식물 삭제 : 식물의 이름을 입력받아 식물의 이름과 특징을 삭제한다.

import java.util.Scanner;

public class RuleOfBiodome05 {

    static Scanner sc;
    static PlantHashMap<String ,String> plantHashMap;
    public static void main(String[] args) {
        plantHashMap = new PlantHashMap<>();
        sc = new Scanner(System.in);
        while (true) {
            System.out.println("========================");
            System.out.println("1. 식물 추가");
            System.out.println("2. 식물 검색");
            System.out.println("3. 식물 삭제");
            System.out.println("4. 식물 인덱스 찾기");
            System.out.println("========================");
            System.out.println("메뉴를 선택 하세요. ");
            System.out.println("========================");

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    addPlant();
                    break;
                case 2:
                    searchPlant();
                    break;
                case 3:
                    removePlant();
                    break;
                case 4:
                    searchIndex();
                    break;
            }

        }
    }



    private static void addPlant() {
        System.out.print("식물 : ");
        String plant = sc.nextLine();
        System.out.print("식물의 특징 : ");
        String characteristic = sc.nextLine();

        plantHashMap.put(plant,characteristic);
    }

    private static void searchPlant() {
        System.out.print("검색할 식물 이름 : ");
        String plant = sc.nextLine();

        String characteristic =  plantHashMap.get(plant);
        if (characteristic != null){
            System.out.println("\'"+plant +"\' 검색 : \'"+ characteristic +'\'' );
        }
    }

    private static void removePlant() {
        System.out.print("삭제할 식물 이름 : ");
        String plant = sc.nextLine();

        plantHashMap.remove(plant);
    }

    private static void searchIndex() {
        System.out.print("인덱스를 찾을 식물 이름 : ");
        String plant = sc.nextLine();

        int index = plantHashMap.getIndex(plant);

        if (index != -1){
            System.out.println("\'"+plant+"\' : "+index);
        }
    }

}
