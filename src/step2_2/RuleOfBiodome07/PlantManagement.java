package step2_2.RuleOfBiodome07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class PlantManagement  {
    private Queue<Plant> plantPriorityQueue = new LinkedList<>();

    private double todayHumidity;

    public PlantManagement(double humidity) {
        this.todayHumidity = humidity;
        System.out.println("식물 관리 시스템이 생성되었습니다.");
    }

   public void offer(ArrayList<Plant> plant){
        if (plant == null) {
            System.out.println("추가할 요소가 없습니다.");
            return;
        }



       if (plantPriorityQueue.isEmpty()){
           Collections.sort(plant);
           plantPriorityQueue = new LinkedList<>(plant);
       }
       else{
           ArrayList<Plant> temp = new ArrayList<>(plantPriorityQueue);

           Collections.sort(temp);
           plantPriorityQueue = new LinkedList<>(temp);
       }
       for (Plant p : plant){
           System.out.println(p.getName() +" 이/가 관리 대상 목록에 추가되었습니다");
       }

   }

   public void management(){

        Plant plant = plantPriorityQueue.poll();
        if (plant == null){
            System.out.println("관리할 식물이 남아있지않습니다.");
            return;
        }

        if (todayHumidity < plant.getHumidity()){
            System.out.println("우선 관리 대상 : "+ plant.getName() + ", 필요한 물의 양 : " +plant.getNeedWater() * 1.5 );
        }
        else{
            System.out.println("우선 관리 대상 : "+ plant.getName() + ", 필요한 물의 양 : " +plant.getNeedWater());
        }


        plant.water(todayHumidity);
   }

   public void clear(){
       System.out.println("관리 대상 목록 초기화");
        plantPriorityQueue.clear();
   }


    public void list() {
        System.out.println("(남아있는 식물)");
        ArrayList<Plant> plants = new ArrayList<>(plantPriorityQueue);

        for (Plant p : plants){
            System.out.println(p.toString());
        }

    }
}
