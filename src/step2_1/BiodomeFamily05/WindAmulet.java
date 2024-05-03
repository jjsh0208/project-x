package step2_1.BiodomeFamily05;

public class WindAmulet extends AncientArtifact implements WeatherController{
    protected WindAmulet(String name) {
        super(name);
        System.out.println("바람의 부적 유물이 생성되었습니다.");
    }

    @Override
    public void describe() {
        System.out.println(Sorcerer.getName() + "이 "+ getName()+ "의 능력을 확인합니다.");
        controlWeather();
    }

    @Override
    public void controlWeather() {
        System.out.println( getName()+"으로 날씨를 변경\n");
    }
}
