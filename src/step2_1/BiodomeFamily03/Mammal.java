package step2_1.BiodomeFamily03;

public class Mammal extends  Animal{
    private  String warmBlooded;

    Mammal(String name, String type, String habitat, String digestion, String food, String warmBlooded) {
        super(name, type, habitat, digestion, food);
        this.warmBlooded =warmBlooded;
    }

    public void giveBirth(){
        System.out.println(getName() + "은/는 " + warmBlooded + "합니다.");
    }
}
