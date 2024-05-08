package step2_1.BiodomeFamily09;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class OrderList {
    private Queue<List<Order>> orders = new ArrayDeque<>();


    public void addOrderList(List<Order> order){
        orders.add(order);
    }


    public List<Order> poll() {
        return orders.poll();
    }

    public Queue<List<Order>> getOrderList() {
        return new ArrayDeque<>(orders);
    }
    public Queue<List<Order>> getOrders() {
        return orders;
    }

}
