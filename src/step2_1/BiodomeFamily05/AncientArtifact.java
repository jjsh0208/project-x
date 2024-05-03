package step2_1.BiodomeFamily05;

public abstract class AncientArtifact {
    private final String name;

    protected AncientArtifact(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void describe();

}
