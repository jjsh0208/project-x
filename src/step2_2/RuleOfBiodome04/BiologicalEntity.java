package step2_2.RuleOfBiodome04;

public class BiologicalEntity<T> {
    private String name;
    private String type;
    private T feature;


    public BiologicalEntity(String name, String type, T feature) {
        this.name = name;
        this.type = type;
        this.feature = feature;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public T getFeature() {
        return feature;
    }
}
