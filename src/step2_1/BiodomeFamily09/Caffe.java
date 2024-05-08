package step2_1.BiodomeFamily09;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Caffe {
    private ArrayList<Menu> menus = new ArrayList<Menu>();
    private  OrderList orderList = new OrderList();

    public void addMenu(Menu menu) {
        menus.add(menu);
        if (menu instanceof Coffee) System.out.println("커피가 추가되었습니다. "+((Coffee) menu).getBean()+" : "+ menu.getPrice()+"원");
        if (menu instanceof Juice) System.out.println("음료가 추가되었습니다. "+menu.getName() +" : "+ menu.getPrice()+"원");
        if (menu instanceof Sandwich)
            System.out.println("샌드위치가 추가되었습니다. "+menu.getName() +" : "+ menu.getPrice()+"원 (재료: "+((Sandwich) menu).getIngredients()+
                            ", 만료일 : " + ((Sandwich) menu).getExpirationDate().getYear()+"-"+((Sandwich) menu).getExpirationDate().getMonthValue()+"-"+
                            ((Sandwich) menu).getExpirationDate().getDayOfMonth()+")");
    }

    public void munuList() {
        System.out.println("==== Menu ====");
        for (Menu menu : menus){
            System.out.println(menu.toString());
        }
    }

    public void addOrder(String customer, String order, String size, int quantity, int choice, List<Order> list) {

        //choice 1. 커피 2. 음료 3. 샌드위치
        //order 주문 명
        //1. 주문한 메뉴가 존재하는지 확인
        for (Menu menu : menus){
            if (menu.getName().equals(order)){
                switch (choice){
                    case 1:
                        Coffee coffee = (Coffee) menu;
                        list.add(new Order(coffee,quantity,size,customer, LocalDateTime.now()));
                        break;
                    case 2:
                        Juice juice = (Juice) menu;
                        list.add(new Order(juice,quantity,size,customer, LocalDateTime.now()));
                        break;
                    case 3:
                        Sandwich sandwich = (Sandwich) menu;
                        if (LocalDateTime.now().isAfter(sandwich.getExpirationDate())) {
                            System.out.println("죄송합니다. 해당 샌드위치의 유통기한이 지났습니다.");
                            return; // 함수 종료
                        }
                        list.add(new Order(sandwich,quantity,customer,LocalDateTime.now()));

                        break;
                    default:
                        break;
                }
                return;
            }
        }
    }

    public void addOrder(String customer, String order, String size,int choice, List<Order> list) {

        //choice 1. 커피 2. 음료 3. 샌드위치
        //order 주문 명
        //1. 주문한 메뉴가 존재하는지 확인
        for (Menu menu : menus){
            if (menu.getName().equals(order)){
                switch (choice){
                    case 1:
                        Coffee coffee = (Coffee) menu;
                        list.add(new Order(coffee,size,customer, LocalDateTime.now()));
                        break;
                    case 2:
                        Juice juice = (Juice) menu;
                        list.add(new Order(juice,size,customer, LocalDateTime.now()));
                        break;
                    case 3:
                        Sandwich sandwich = (Sandwich) menu;
                        if (LocalDateTime.now().isAfter(sandwich.getExpirationDate())) {
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

                            // getOrderTime()으로 LocalDateTime 객체를 가져오고, 이를 원하는 형식의 문자열로 변환
                            String formattedDateTime = sandwich.getExpirationDate().format(formatter);
                            System.out.println(sandwich.getName()+" 주문 시도...");
                            System.out.println("오류: 주문할 수 없는 상품입니다. (만료날짜 : "+formattedDateTime+")");
                            return; // 함수 종료
                        }
                        list.add(new Order(sandwich,customer,LocalDateTime.now()));
                        break;
                    default:
                        break;
                }
                return;
            }
        }
        System.out.println("해당 메뉴가 존재하지 않거나 아직 준비되지 않았습니다.");
    }

    public void addOrderList(List<Order> list){
        orderList.addOrderList(list);
    }

    public void orderListCheck() {
        int orderCnt = 1;
        Queue<List<Order>> list = orderList.getOrderList();
        while(!list.isEmpty()){
            int cnt = 1;
            int sum = 0;
            List<Order> o = list.poll();
            if (o == null){
                System.out.println("=== 주문이 없습니다 ===");
                return;
            }
            System.out.println("주문"+orderCnt++ +".");
            System.out.println("고객: "+ o.getFirst().getCustomer());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            // getOrderTime()으로 LocalDateTime 객체를 가져오고, 이를 원하는 형식의 문자열로 변환
            String formattedDateTime = o.getFirst().getOrderTime().format(formatter);
            System.out.println("주문일자 : "+ formattedDateTime+"\n");
            for(Order order : o){
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
            System.out.println("\n총 금액 : "+sum+"원\n");

            System.out.println("-----------------------------");
        }

    }
    public void orderCancel(String name, String menu) {
        for (List<Order> orderList : orderList.getOrders()) {
            // 각 List<Order> 내의 Order 객체에 대해 반복
            for (Order order : orderList) {
                if (order.getCustomer().equals(name) && order.getMenu().getName().equals(menu) && order.getStatus().equals("주문 완료")){
                    System.out.println("고객 : "+order.getCustomer() +"님의 "+order.getMenu().getName()+"주문이 취소되었습니다.");
                    order.setStatus("취소");
                    orderList.remove(order);
                    return;
                }
            }
        }
    }


}
