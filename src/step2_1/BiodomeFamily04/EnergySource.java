package step2_1.BiodomeFamily04;

public abstract class EnergySource {
    final String sourceName;
    protected  int energyAmount;

    static int total;

    protected EnergySource(String sourceName) {
        this.sourceName = sourceName;
        this.energyAmount = 0;
    }

    public String getSourceName() {
        return sourceName;
    }

    public int getEnergyAmount() {
        return energyAmount;
    }
    public void useEnergy(int value){
        if(total - value < 0){
            System.out.println("에너지가 부족해 "+ getSourceName() +"에너지 "+ value +"을 사용할 수 없습니다.");
        }
        else{
            System.out.println(getSourceName() + "에너지를 " + value + " 사용했습니다.");
            total -= value;
            this.energyAmount -= value;
        }

    }
    public abstract void produceEnergy(int value);
}
