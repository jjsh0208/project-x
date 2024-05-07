package step2_1.BiodomeFamily09;

public class Juice extends Menu{
    public String size;
    public Juice(String name, int price) {
        super(name, price);
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    @Override
    public String toString() {
        return super.toString() +",  "+ '\'' +this.size + '\'' +" }";
    }
}
