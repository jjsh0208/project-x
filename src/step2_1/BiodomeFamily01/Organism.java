package step2_1.BiodomeFamily01;

public class Organism {
    private String name;
    private String type;
    private String habitat;

    Organism(){
        this("없음","없음","없음");
    }

    Organism(String name, String type, String habitat){
        this.name = name;
        this.type = type;
        this.habitat = habitat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public void displayInfo(){
        System.out.println(name + ", " + type + ", " + habitat);
    }
}
