package step3_2.RunBiodome07;

import java.util.ArrayList;

public class EnergyManageCenter {
    private static EnergyManageCenter singleton;
    private int Energy = 5000;
    private static ArrayList<City> cities = new ArrayList<>();

    private EnergyManageCenter() { //생성자를 private로 설정해 new 키워드로 생성못하게 막음
        cities.add(new City("TerraNova"));
        cities.add(new City("LuminaBay"));
        cities.add(new City("FlowBridges"));
    }

    public static EnergyManageCenter getInstance(){
        if (singleton == null){

            singleton = new EnergyManageCenter();
        }
        return singleton;
    }

    public void energyCheck(){
        System.out.println("중앙 에너지 센터와 3개 도시 에너지양 조회");
        System.out.printf("- 중앙 에너지 센터 : %d\n",Energy);
        for (City c : cities){
            System.out.printf("- %s : %d\n",c.getName(),c.getEnergy());
        }
        System.out.println();
    }

    public void energyAssign(String name, int energy) {
        if (energy < 0){
            System.out.println(">>> 요청된 에너지가 마이너스 값입니다. 다시 입력해주세요.");
            return;
        }
        if ((Energy - energy) < 0){
            System.out.println(">>> 보유한 에너지가 요청한 에너지만큼 없습니다.");
        }


        for (City c : cities){
            if (c.getName().equals(name)){
                c.setEnergy(energy);
                Energy -= energy;
                System.out.printf("- 중앙 에너지 센터: %d\n",Energy);
                System.out.printf("- %s: %d\n\n",c.getName(),c.getEnergy());
                return;
            }
        }

        System.out.println(">>> 해당 이름의 도시가 존재하지 않습니다.");
    }

    public void energyAdd(int energy) {
        if (energy < 0){
            System.out.println(">>> 요청된 에너지가 마이너스 값입니다. 다시 입력해주세요.");
            return;
        }
        Energy += energy;
        System.out.printf("- 중앙 에너지 센터 : %d\n",Energy);
//에너지가 추가된 정보를 에너지 보유량이 적은 2개 도시에 알린다.
//에너지 보유량이 적은 도시에 "중앙 센터에 에너지가 [보충량] 보충되었습니다."라는 메시지를 출력한다.
//도시별 에너지 보유량이 동일한 경우 모든 도시에서 메시지가 출력된다.







        for (City c : cities){
            System.out.printf("- %s : 중앙센터에 에너지가 %d 보충되었습니다.\n",c.getName(),energy);
        }
        System.out.println();
    }
}
