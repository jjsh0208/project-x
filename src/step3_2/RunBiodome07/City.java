package step3_2.RunBiodome07;

public class City {
    private String name;
    private int Energy;

    public City(String name) {
        this.name = name;
        Energy = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnergy() {
        return Energy;
    }

    public void setEnergy(int energy) {
        Energy = energy;
    }
}
