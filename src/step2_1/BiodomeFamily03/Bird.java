package step2_1.BiodomeFamily03;

public class Bird extends Animal{
    private String wingSpan;
    Bird(String name, String type, String habitat, String digestion, String food, String wingSpan) {
        super(name, type, habitat, digestion, food);
        this.wingSpan = wingSpan;
    }

    public  void fly(){
        System.out.println(getName() + "은/는 " + wingSpan + "합니다.");
    }
}
