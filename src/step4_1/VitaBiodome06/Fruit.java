package step4_1.VitaBiodome06;

public class Fruit {
    private String name;
    private int price;
    private  int inventory;

    public Fruit(String name, int price, int inventory) {
        this.name = name;
        this.price = price;
        this.inventory = inventory;

    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getInventory() {
        return inventory;
    }
}
