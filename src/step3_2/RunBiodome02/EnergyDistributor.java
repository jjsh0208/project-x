package step3_2.RunBiodome02;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class EnergyDistributor {
    //속성: 구역별 에너지를 관리하는 HashMap<String, Integer> (구역명, 에너지량)
    private HashMap<String,Integer> locations = new HashMap<>();
    private Integer energy = 50000;
    public EnergyDistributor() {
        locations.put("테라노바",0);
        locations.put("루미나베이",0);
        locations.put("플로우브릿지",0);
    }

    public void energyCheck(){
        System.out.println(">>> 전체 남은 에너지: "+ this.energy);
    }


    public void addEnergy(String location, Integer addEnergy) {

        Predicate<Integer> bonus = (energy) -> {
            return energy <= 1000;
        };

        EnergyAdd energyLambda = () -> {
            for (Map.Entry<String, Integer> entry : locations.entrySet()) {
                String key = entry.getKey();
                if (key.equals(location)){
                    if(energy - addEnergy < 0){
                        System.out.println(">>> 할당 가능한 에너지를 초과했습니다.");
                        return;
                    }
                    energy -= addEnergy;
                    entry.setValue(addEnergy);

                    if (bonus.test(energy)){
                        System.out.println(">>> (경고) 에너지가 1000 이하입니다.");
                    }

                    System.out.printf(">>> 테라노바에 %d의 에너지가 할당되었습니다. 남은 전체 에너지: %d\n",addEnergy,energy);
                    return;
                }
            }
        };
        energyLambda.energyAdd();
    }
    public void locationCheck() {
        System.out.println(">>> 구역별 에너지 조회");

        for (Map.Entry<String, Integer> entry : locations.entrySet()) {
            String key = entry.getKey(); // 키 얻기
            Integer value = entry.getValue(); // 값 얻기
            // 키와 값 출력
            System.out.println(key + " : " + value);
        }
    }
}