package step2_2.RuleOfBiodome04;

public class PlantFeature{
    private String color;
    private String fruit;
    private String flowering;


    public PlantFeature(String color, String fruit, String flowering) {
        this.color = color;
        this.fruit = fruit;
        this.flowering = flowering;
    }

    public String getColor() {
        return color;
    }

    public String getFruit() {
        return fruit;
    }

    public String getFlowering() {
        return flowering;
    }
}
