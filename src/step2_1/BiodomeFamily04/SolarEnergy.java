package step2_1.BiodomeFamily04;

public class SolarEnergy extends EnergySource{
    protected SolarEnergy(String sourceName) {
        super(sourceName);
    }

    @Override
    public void produceEnergy(int time) {
        this.energyAmount += time * 10;
        total+= time * 10;
        System.out.println(getSourceName() + " 에너지를 " + getEnergyAmount() + "생산했습니다.");
    }
}
