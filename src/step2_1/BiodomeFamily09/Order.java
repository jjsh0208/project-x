package step2_1.BiodomeFamily09;

import java.time.LocalDateTime;

public class Order {
    private Menu menu; //주문
    private int quantity; //수량
    private String size; //사이즈
    private  String customer; // 고객
    private LocalDateTime OrderTime; //주문시간
    private  String   status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getSize() {
        return size;
    }

    public String getCustomer() {
        return customer;
    }

    public LocalDateTime getOrderTime() {
        return OrderTime;
    }

    public Order(Menu menu, int quantity, String size , String customer, LocalDateTime orderTime) {
        this.menu = menu;
        this.quantity = quantity;
        this.size = size;
        this.customer = customer;
        this.OrderTime = orderTime;
        this.status = "주문 완료";
    }

    public Order(Menu menu, String customer, LocalDateTime orderTime) {
        this.menu = menu;
        this.customer = customer;
        this.OrderTime = orderTime;
        this.quantity = 1;
        this.status = "주문 완료";
    }

    public Order(Menu menu, String size,String customer, LocalDateTime orderTime) {
        this.menu = menu;
        this.size = size;
        this.customer = customer;
        this.OrderTime = orderTime;
        this.quantity = 1;
        this.status = "주문 완료";
    }

    public Order(Menu menu, int quantity, String customer, LocalDateTime orderTime) {
        this.menu = menu;
        this.quantity = quantity;
        this.customer = customer;
        this.OrderTime = orderTime;
        this.status = "주문 완료";
    }
}
