package step4_1.VitaBiodome04;

public class Fruit {
    private String name;
    private int price;
    private boolean isFarmChanged; //농장 변경 여부
    private boolean isReserved; //예약 여부
    private int requestCount; //요청 횟수

    public Fruit(String name, int price ,boolean isFarmChanged,boolean isReserved, int requestCount) {
        this.name = name;
        this.price = price;
        this.isFarmChanged = isFarmChanged;
        this.isReserved = isReserved;
        this.requestCount = requestCount;


    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public boolean isFarmChanged() {
        return isFarmChanged;
    }

    public int getRequestCount() {
        return requestCount;
    }
}
