package step2_1.BiodomeFamily09;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
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
            System.out.println("4. 현재 주문 목록");
            System.out.println("5. 주문 취소");
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
                case 4:
                    caffe.orderListCheck();
                    break;
                case 5:
                    orderCancle();
                    break;
            }
        }
    }

    private static void orderCancle() {
        System.out.print("고객의 이름 :");
        String name = sc.nextLine();
        System.out.print("취소할 메뉴 :");
        String menu = sc.nextLine();

        caffe.orderCancel(name,menu);
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
                System.out.print("음료의 이름을 입력하시오 ( 예) 오렌지 쥬스, 캐모마일, 물: ");
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
    System.out.print("고객명 : ");
    String customer = sc.nextLine();
    List<Order> list = new ArrayList<>();
    boolean check = false;
    while(true) {
        System.out.print("주문 (1. 커피 2. 음료 3. 샌드위치, 0. 주문 종료) : ");
        int choice = Integer.parseInt(sc.nextLine());
        if ((choice == 0)) {
            if (check){
                caffe.addOrderList(list);
                orderCheck(list);
            }
            return; // 주문 종료
        }
        check = true;
        String itemName = "";
        String size = "";
        int quantity = 0;

        switch (choice) {
            case 1:
                itemName = getOrderItem("어떤 커피로 고르시겠습니까?", new String[]{"다크 커피 /", "블렌드 커피 /", "디카페인 커피"});
                size = getOrderSize();
                break;
            case 2:
                itemName = getOrderItem("어떤 음료를 고르겠습니까?", new String[]{"캐모마일 /", "오렌지 쥬스 /", "물"});
                size = getOrderSize();
                break;
            case 3:
                itemName = getOrderItem("어떤 샌드위치를 고르겠습니까?", new String[]{"야채 샌드위치 /", "햄 샌드위치 /", "치즈 샌드위치"});
                break;
        }

        quantity = getQuantity(choice);
        if (quantity > 1){ //1개 이상 주문
            caffe.addOrder(customer, itemName, size, quantity, choice,list );
        }
        else{   //1개만 주문
            caffe.addOrder(customer, itemName, size, choice,list );
        }
    }
}
    private static void orderCheck(List<Order> list) {
        System.out.println("=== 주문이 추가되었습니다. ===");
        int cnt = 1;
        int sum = 0;
        Order o = list.get(0);
        System.out.println("고객: "+ o.getCustomer());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // getOrderTime()으로 LocalDateTime 객체를 가져오고, 이를 원하는 형식의 문자열로 변환
        String formattedDateTime = o.getOrderTime().format(formatter);
        System.out.println("주문일자 : "+ formattedDateTime+"\n");
        for(Order order : list){
            if (order.getMenu() instanceof Coffee || order.getMenu() instanceof Juice) {
                System.out.println(cnt++ + ") " + order.getMenu().getName() + " (사이즈 : " + order.getSize() + ") - " +
                        order.getQuantity() + "잔 : " + order.getMenu().getPrice()  * order.getQuantity());
                sum += order.getMenu().getPrice();
            }
            if (order.getMenu() instanceof  Sandwich){
                System.out.println(cnt++ + ") " + order.getMenu().getName() + "  - " + order.getQuantity() + "개 : " +
                        order.getMenu().getPrice()  * order.getQuantity());
                sum += order.getMenu().getPrice();
            }
        }
        System.out.println("\n총 금액 : "+sum+"원");
    }

    private static String getOrderItem(String message, String[] options) {
        System.out.println(message);
        for (String option : options) {
            System.out.print(option +" ");
        }
        return sc.nextLine();
    }

    private static String getOrderSize() {
        System.out.println("어떤 사이즈로 주문하시겠습니까?");
        System.out.println("숏 , 톨 , 벤티");
        return sc.nextLine();
    }

    private static int getQuantity(int choice) {
        if (choice == 3) {
            System.out.println("몇 개 주문하시겠습니까?");
        } else {
            System.out.println("몇 잔 주문하시겠습니까?");
        }
        return Integer.parseInt(sc.nextLine());
    }

}
