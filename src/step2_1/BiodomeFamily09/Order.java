package step2_1.BiodomeFamily09;

import java.time.LocalDateTime;

public class Order {
    private Menu menu; //주문
    private int quantity; //수량
    private String size; //사이즈
    private  String customer; // 고객
    private LocalDateTime OrderTime; //주문시간

    public Order(Menu menu, int quantity,String size ,String customer, LocalDateTime orderTime) {
        this.menu = menu;
        this.quantity = quantity;
        this.size = size;
        this.customer = customer;
        this.OrderTime = orderTime;
    }

    public Order(Menu menu, String customer, LocalDateTime orderTime) {
        this.menu = menu;
        this.customer = customer;
        this.OrderTime = orderTime;
        this.quantity = 1;
    }
    public Order(Menu menu, int quantity,String customer, LocalDateTime orderTime) {
        this.menu = menu;
        this.quantity = quantity;
        this.customer = customer;
        this.OrderTime = orderTime;
    }
}
