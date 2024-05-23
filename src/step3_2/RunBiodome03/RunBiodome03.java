package step3_2.RunBiodome03;

import java.util.Scanner;

public class RunBiodome03 {
    static FruitStore fs;
    static  Scanner sc;
    public static void main(String[] args) {
         fs = new FruitStore();
         sc = new Scanner(System.in);
        System.out.println("과일 상점에 오신 것을 환영합니다!");

        int choice;
        while(true){
            System.out.println("\n1. 과일 판매하기");
            System.out.println("2. 과일 재고 추가하기");
            System.out.println("3. 모든 과일 재고 조회하기");
            System.out.println("4. 종료하기");
            System.out.print("메뉴를 선택하세요: ");
            choice = Integer.parseInt(sc.nextLine());

            switch(choice){
                case 1:
                    sell();
                    break;
                case 2:
                    addQuantity();
                    break;
                case 3:
                    fs.show();
                    break;
                case 4:
                    fs.save();
                    sc.close();
                    System.exit(0);
                    break;
                default:

                    break;
            }
        }
    }

    private static void addQuantity() {
        System.out.print("재고를 추가할 과일의 이름을 입력하세요: ");
        String fruit = sc.nextLine();
        System.out.print("추가할 수량을 입력하세요: ");
        Integer quantity = Integer.parseInt(sc.nextLine());
        fs.addQuantity(fruit,quantity);

    }

    private static void sell() {
        System.out.print("\n판매할 과일의 이름을 입력하세요: ");
        String fruit = sc.nextLine();
        System.out.print("판매할 수량을 입력하세요: ");
        Integer quantity = Integer.parseInt(sc.nextLine());
        fs.fruitSell(fruit,quantity);
    }

}
