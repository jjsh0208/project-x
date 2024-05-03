package step2_1.BiodomeFamily05;

public class SolarStone extends AncientArtifact implements  EnergyGenerator,Chargeable{
    private  int energy;

    protected SolarStone(String name) {
        super(name);
        System.out.println("태양의 돌 유물이 생성되었습니다.");
    }

    @Override
    public void charge(int amount) {
        this.energy += amount;
        System.out.println(getName()+ "에 " +amount +"만큼 에너지를 충전합니다.");
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
    public void generateEnergy() {
        System.out.println("\""+getName() +"로 에너지 생성 중! 빛을 받은 시간에 따라 에너지의 양이 달라집니다.\"\n");
    }
}
