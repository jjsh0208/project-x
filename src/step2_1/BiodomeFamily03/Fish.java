package step2_1.BiodomeFamily03;

public class Fish extends Animal{
    private  String finsCount;
    Fish(String name, String type, String habitat, String digestion, String food, String finsCount ) {
        super(name, type, habitat, digestion, food);
        this.finsCount = finsCount;
    }
    public void swim(){
        System.out.println(getName() + "은/는 " + finsCount + "합니다.");
    }
}
