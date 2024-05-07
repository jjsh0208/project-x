package step2_1.BiodomeFamily09;

import java.time.LocalDateTime;
import java.util.ArrayList;

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

    public void addOrder(String customer, String order, String size, int quantity, int choice) {
        //choice 1. 커피 2. 음료 3. 샌드위치
        //order 주문 명
        //1. 주문한 메뉴가 존재하는지 확인
        for (Menu menu : menus){
            if (menu.getName().equals(order)){
                switch (choice){
                    case 1:
                        Coffee coffee = (Coffee) menu;
                        orderList.addOrderList(new Order(coffee,quantity,size,customer, LocalDateTime.now()) );
                        break;
                    case 2:
                        Juice juice = (Juice) menu;
                        orderList.addOrderList(new Order(juice,quantity,size,customer,LocalDateTime.now()));
                        break;
                    case 3:
                        Sandwich sandwich = (Sandwich) menu;
                        orderList.addOrderList(new Order(sandwich,quantity,customer,LocalDateTime.now()));
                        break;
                    default:
                        break;
                }
            }
        }
    }

}
