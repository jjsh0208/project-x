package step2_1.BiodomeFamily02;

public class Organism {
    private String name;
    private String type;
    private String habitat;
    private String characteristic;
    private  String lifeSpan;



    Organism(){
        this("없음","없음","없음,","","");
    }

    Organism(String name, String type, String habitat, String characteristic,String lifeSpan){
        this.name = name;
        this.type = type;
        this.habitat = habitat;
        this.characteristic = characteristic;
        this.lifeSpan = lifeSpan;
    }


    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    public String getLifeSpan() {
        return lifeSpan;
    }

    public void setLifeSpan(String lifeSpan) {
        this.lifeSpan = lifeSpan;
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
        System.out.println(name + ", " + type + ", " + habitat + ", " + characteristic + " ,"+ lifeSpan);
    }
}
