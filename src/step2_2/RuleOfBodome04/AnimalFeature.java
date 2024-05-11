package step2_2.RuleOfBodome04;

public class AnimalFeature {
    private String characteristic; //특징
    private String classification; //분류
    private String life; //수명

    public AnimalFeature(String characteristic ,String classification ,String life) {
        this.characteristic = characteristic;
        this.classification = classification;
        this.life = life;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public String getClassification() {
        return classification;
    }

    public String getLife() {
        return life;
    }
}
