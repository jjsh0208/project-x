package step2_1.BiodomeFamily05;

public class WaterMirror extends  AncientArtifact implements WeatherController, EnergyGenerator,Chargeable{
    private  int energy;

    public int getEnergy() {
        return energy;
    }

    protected WaterMirror(String name) {
        super(name);
        System.out.println("물의 거울 유물이 생성되었습니다.");
    }


    @Override
    public void charge(int amount) {
        this.energy += amount;
        System.out.println(getName()+ "에 " +getEnergy() +"만큼 에너지를 충전합니다.");
    }

    @Override
    public void getChargeLevel() {
        System.out.println(getName()+"에 총 "+energy + "만큼 에너지가 충전되었습니다.");
    }

    @Override
    public void describe() {
        System.out.println(Sorcerer.getName() + "이 "+ getName()+ "의 능력을 확인합니다.");
        generateEnergy();
    }

    @Override
    public void controlWeather() {
        System.out.println("물을 조종");
    }

    @Override
    public void generateEnergy() {
        System.out.println("\""+getName()+"을 이용해 수증기로 에너지를 생성했습니다!\"\n");
    }
}
