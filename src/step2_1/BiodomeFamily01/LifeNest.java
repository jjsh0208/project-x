package step2_1.BiodomeFamily01;

import java.util.ArrayList;
import java.util.Iterator;

public class LifeNest {
    ArrayList<Organism> organismList = new ArrayList<Organism>();

    public void OrganismAdd (Organism organism){
        organismList.add(organism);
        System.out.println("[LifeNest] "+ organism.getName() + "가 추가되었습니다.");
    }

   public void OrganismRemove(String name){
       Iterator<Organism> iterator = organismList.iterator();
       while(iterator.hasNext()){
           Organism O = iterator.next();
           if(O.getName().equals(name)){
               System.out.println("[LifeNest] "+ O.getName() + "가 삭제되었습니다.");
               iterator.remove();
               break;
           }
       }
   }

   public void searchOrganismByName(String name){
       Iterator<Organism> iterator = organismList.iterator();
       while(iterator.hasNext()){
           Organism O = iterator.next();
           if(O.getName().equals(name)){
               System.out.println(O.getName() +"은/는 " + O.getType() + "이며 " + O.getHabitat() +" 에 서식합니다.");
               break;
           }
       }
   }

}
