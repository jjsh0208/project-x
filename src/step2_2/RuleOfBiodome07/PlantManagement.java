package step2_2.RuleOfBiodome07;

import java.util.LinkedList;
import java.util.Queue;

public class PlantManagement {
    private Queue<Plant> plantPriorityQueue = new LinkedList<>();

    public PlantManagement() {
        System.out.println("식물 관리 시스템이 생성되었습니다.");
    }

   public void offer(Plant plant){
        //1. 현재 큐를 복사하여 순회하면 새로 넣을려는 plant와 비교


       //아 인터페이스 깜빡해버림 망한 코드
//       if (plantPriorityQueue.isEmpty()){
//           plantPriorityQueue.offer(plant);
//           return;
//       }else {
//            boolean added  = false;
//           Queue<Plant> temp = new LinkedList<>();
//
//           while (!plantPriorityQueue.isEmpty()) {
//               Plant currentPlant = plantPriorityQueue.poll();
//               if (!added && plant.getNextWateringTime().isBefore(currentPlant.getNextWateringTime())){
//                   //추가할 식물의 공급일정이 현재 식물보다 빠르면 추가할 식물 삽입;
//                   temp.offer(plant);
//                   added = true;
//               }
//               temp.offer(currentPlant);//그 뒤에 현재 식물을 삽입
//           }
//
//           if (!added){
//               temp.offer(plant);
//           }
//
//           plantPriorityQueue = temp;
//       }
//       System.out.println(plant.getName() +"이/가 관리 대상 목록에 추가되었습니다");

   }

   public void management(){

        Plant plant = plantPriorityQueue.poll();
        if (plant == null){
            System.out.println("관리할 식물이 남아있지않습니다.");
            return;
        }
        System.out.println("우선 관리 대상 : "+ plant.getName() + ", 필요한 물의 양 : " +plant.getNeedWater());
        plant.water();
   }

   public void clear(){
       System.out.println("관리 대상 목록 초기화");
        plantPriorityQueue.clear();
   }




}
