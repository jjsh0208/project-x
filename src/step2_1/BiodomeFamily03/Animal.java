package step2_1.BiodomeFamily03;

public class Animal extends Organism{
    private String digestion;
    private String food;

    Animal(String name, String type, String habitat,String digestion, String food) {
        super(name, type, habitat);
        this.digestion = digestion;
        this.food = food;
    }

    @Override
    public void displayInfo() {
        System.out.println( getName() + ", " + getType() + ", " + getHabitat() + ", " + digestion + ", " + food );
    }

}
