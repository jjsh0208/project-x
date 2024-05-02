package step2_1.BiodomeFamily04;

public class GeothermalEnergy extends EnergySource{
    protected GeothermalEnergy(String sourceName) {
        super(sourceName);
    }

    @Override
    public void produceEnergy(int temperature) {
        this.energyAmount += temperature * 5 + 20;
        total += temperature * 5 + 20;
        System.out.println(getSourceName() + " 에너지를 " + getEnergyAmount() + "생산했습니다.");
    }
}
