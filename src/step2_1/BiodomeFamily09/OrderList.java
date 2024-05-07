package step2_1.BiodomeFamily09;

import java.util.LinkedList;
import java.util.Queue;

public class OrderList {
    private Queue<Order> orders = new LinkedList<>();


    public void addOrderList(Order order){
        orders.add(order);
    }

}
