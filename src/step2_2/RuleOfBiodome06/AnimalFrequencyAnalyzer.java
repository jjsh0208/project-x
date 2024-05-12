package step2_2.RuleOfBiodome06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AnimalFrequencyAnalyzer {
    private Map<String,Integer> animalCountMap;

    public AnimalFrequencyAnalyzer() {
        this.animalCountMap = new HashMap<>();
    }





    public void animalUpdate(String[] animals){ //어진 동물들의 배열을 분석하여 animalCountMap을 업데이트하는 메서드
        for (String a : animals) {
            animalCountMap.put(a, animalCountMap.getOrDefault(a, 0) + 1);
        }
    }


    public String[] animalMaxCount(){ //animalCountMap을 분석하여 가장 많이 등장한 동물의 이름을 반환하는 메서드
        int max = 0 , cnt = 0 ;
        ArrayList<String> name = new ArrayList<>();
        for (Map.Entry<String, Integer> s : animalCountMap.entrySet()){
            if (s.getValue() > max){
                max = s.getValue();
                name.clear();;
                name.add(s.getKey());
            }
            else if(s.getValue() == max){
                name.add(s.getKey());
            }
        }
        return name.toArray(new String[0]);
    }


    public Set<String> animalName(){ //동물의 고유한 이름값 확인하는 메서드
        return animalCountMap.keySet();
    }


    public Map<Integer, ArrayList<String>> bonus() {
        Map<Integer, ArrayList<String>> group = new HashMap<>();

        // animalCountMap을 반복하며 각 동물의 관찰 횟수에 따라 그룹화
        for (Map.Entry<String, Integer> entry : animalCountMap.entrySet()) {
            String animal = entry.getKey();
            Integer count = entry.getValue();

            // 해당 관찰 횟수를 키로 하는 그룹이 이미 존재하는지 확인
            if (!group.containsKey(count)) {
                // 존재하지 않는 경우 새로운 ArrayList를 생성하여 맵에 추가
                group.put(count, new ArrayList<>());
            }

            // 해당 관찰 횟수 그룹에 동물 이름 추가
            group.get(count).add(animal);
        }

        return group;
    }
}
