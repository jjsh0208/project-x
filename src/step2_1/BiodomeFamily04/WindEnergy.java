package step2_1.BiodomeFamily04;

public class WindEnergy extends EnergySource{
    protected WindEnergy(String sourceName) {
        super(sourceName);
    }

    @Override
    public void produceEnergy(int speed) {
        this.energyAmount += speed * 5;
        total+= speed * 5;
        System.out.println(getSourceName() + " 에너지를 " + getEnergyAmount() + "생산했습니다.");
    }
}
