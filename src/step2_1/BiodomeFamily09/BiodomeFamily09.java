package step2_1.BiodomeFamily09;

import java.time.LocalDateTime;
import java.util.Scanner;

public class BiodomeFamily09 {
    static Caffe caffe;
    static Scanner sc;
    public static void main(String[] args) {
        caffe = new Caffe();
        sc = new Scanner(System.in);;
        while(true){
            System.out.println("========================");
            System.out.println("1. 메뉴추가");
            System.out.println("2. 메뉴목록");
            System.out.println("3. 메뉴주문");
            System.out.println("========================");
            System.out.println("메뉴를 선택 하세요. ");
            System.out.println("========================");

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    addMenu();
                    break;
                case 2:
                    caffe.munuList();
                    break;
                case 3:
                    addOrder();
                    break;
            }
        }
    }

    private static void addMenu() {
        System.out.println("추가할 메뉴를 선택하시오 ( 1. 커피 2. 음료 3. 샌드위치 )");
        int choice = Integer.parseInt(sc.nextLine());
        System.out.print("가격을 입력하시오 :");
        int price = Integer.parseInt(sc.nextLine());
        switch(choice){
            case 1:
                System.out.print("원두를 고르시오( 예) 블렌드, 다크, 디카페인 )");
                String bean = sc.nextLine();

                caffe.addMenu(new Coffee(bean +" 커피",price,bean));
                break;
            case 2:
                System.out.print("메뉴의 이름을 입력하시오 : ");
                String name = sc.nextLine();

                caffe.addMenu(new Juice(name,price));
                break;
            case 3:
                System.out.print("재료를 고르시오 (예: 야채, 햄, 치즈): ");
                String ingredient = sc.nextLine();
                System.out.print("유통 기한을 입력하시오 ( 예) 2024 05 05 )");
                String date = sc.nextLine();
                String[] dateParts = date.split(" ");

                int year = Integer.parseInt(dateParts[0]);
                int month = Integer.parseInt(dateParts[1]);
                int day = Integer.parseInt(dateParts[2]);
                LocalDateTime expirationDate = LocalDateTime.of(year,month,day,0,0,0);
                caffe.addMenu(new Sandwich(ingredient+" 샌드위치",price,ingredient,expirationDate));
                break;
            default:
                System.out.println("커피 , 음료, 샌드위치만 추가 가능합니다.");
                break;
        }
    }

    private static void addOrder() {
        System.out.print("고객명 :");
        String customer =  sc.nextLine();
        while(true){
            System.out.print("주문 (1. 커피 2. 음료 3. 샌드위치) : ");
            int choice = Integer.parseInt(sc.nextLine());
            switch(choice){
                case 1:
                    System.out.println("어떤 커피로 고르시겠습니까?");
                    System.out.println("다크 커피, 블렌드 커피, 디카페인 커피");
                    String coffee = sc.nextLine();
                    System.out.println("어떤 사이즈로 주문하시겠습니까?");
                    System.out.println("숏 , 톨 , 벤티");
                    String size = sc.nextLine();
                    System.out.println("몇 잔 주문하시겠습니까?");
                    int quantity = Integer.parseInt(sc.nextLine());
                    if (quantity != 1){
                        caffe.addOrder(customer,coffee,size,quantity,choice);
                    }//한개만 주문 되었을 때 addOrder 오버로딩 하기
                    //생성자 오버로딩으로  조정
                    break;
                case 2:
                    System.out.println("어떤 음료를 고르겠습니까?");
                    System.out.println("캐모마일, 오렌지 쥬스, 물");
                    String juice = sc.nextLine();
                    System.out.println("어떤 사이즈로 주문하시겠습니까?");
                    System.out.println("숏 , 톨 , 벤티");
                     size = sc.nextLine();
                    System.out.println("몇 잔 주문하시겠습니까?");
                    quantity = Integer.parseInt(sc.nextLine());
                    if (quantity != 1){
                        caffe.addOrder(customer,juice,size,quantity,choice);
                    }
                    break;
                case 3:
                    System.out.println("어떤 샌드위치를 고르겠습니까?");
                    System.out.println("야채 샌드위치, 햄 샌드위치, 치즈 샌드위치");
                    String sandwich = sc.nextLine();
                    System.out.println("몇 개 주문하시겠습니까?");
                    quantity = Integer.parseInt(sc.nextLine());
                    if (quantity != 1){
                        caffe.addOrder(customer,sandwich,"",quantity,choice);
                    }
                    break;
            }

        }

    }

}
