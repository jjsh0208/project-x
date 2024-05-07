package step2_1.BiodomeFamily09;

public class Coffee extends Menu{
    private String bean ;
    private String  size;
    public Coffee(String name, int price, String bean) {
        super(name, price);
        this.bean = bean;
    }


    public String getSize() {
        return size;
    }

    public String getBean() {
        return bean;
    }

    @Override
    public String toString() {
        return super.toString()+ ", " +  "bean='" + bean + '\'' + ", size='" + size + '\'' + '}';
    }
}
