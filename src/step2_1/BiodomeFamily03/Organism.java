package step2_1.BiodomeFamily03;

public class Organism {
    private int id;
    private String name;
    private String type;
    private String habitat;
    Organism(String name, String type, String habitat){
        this.name = name;
        this.type = type;
        this.habitat = habitat;
    }

    public int getId() {
        return id;
    }

    public void displayInfo(){}

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
}
