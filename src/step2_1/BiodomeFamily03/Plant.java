package step2_1.BiodomeFamily03;

public class Plant extends Organism{
    private String flowering;
    private String fruit;

    Plant(String name, String type, String habitat,String flowering, String fruit) {
        super(name, type, habitat);
        this.flowering = flowering;
        this.fruit = fruit;
    }




    @Override
    public void displayInfo() {
        System.out.println(getName() + ", " + getType() + ", " + getHabitat() + ", " + flowering + ", " + fruit );
    }
}
