package step2_2.RuleOfBiodome04;

public class MicrobeFeature{
    private String ph;
    private String metabolism;

    public MicrobeFeature(String ph, String metabolism) {
        this.ph = ph;
        this.metabolism = metabolism;
    }

    public String getPh() {
        return ph;
    }

    public String getMetabolism() {
        return metabolism;
    }
}
