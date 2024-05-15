package step2_2.RuleOfBiodome04;

import java.util.*;

public class BiologicalSystem<T> {
    private LinkedList<BiologicalEntity<T>> bs;

    public BiologicalSystem() {
        this.bs = new LinkedList<>();
        System.out.println("생물정보 시스템이 생성되었습니다.");
    }

    public void add(BiologicalEntity<T> Biological){
        bs.add(Biological);
        System.out.println("새로운 생물이 등록되었습니다 : "+  Biological.getName());
    }
    public void delete(){
        if (bs.isEmpty()){
            System.out.println("리스트가 비어있습니다.");
            return;
        }

        System.out.println("생물이 삭제되었습니다 : " + bs.getLast().getName());
        bs.removeLast();
    }
    public void clear(){
        if (bs.isEmpty()){
            System.out.println("리스트가 비어있습니다.");
            return;
        }
        System.out.println("모든 정보를 삭제했습니다.");
        bs.clear();
    }
    public void show(){
        if (bs.isEmpty()){
            System.out.println("리스트가 비어있습니다.");
            return;
        }
        BiologicalEntity<T> bio = bs.getLast();

         if (bio.getFeature() instanceof  AnimalFeature){
             System.out.println("최신 등록 생물 : "+ bio.getName() + ", " + bio.getType() + ", "+ ((AnimalFeature) bio.getFeature()).getCharacteristic() +
                            ((AnimalFeature) bio.getFeature()).getClassification() +", "+ ((AnimalFeature) bio.getFeature()).getLife());
             return;
         }
         if (bio.getFeature() instanceof  PlantFeature){
             System.out.println("최신 등록 생물 : "+ bio.getName() + ", " + bio.getType() + ", " + ((PlantFeature) bio.getFeature()).getColor() + ", "+
                            ((PlantFeature) bio.getFeature()).getFruit()+ ", " + ((PlantFeature) bio.getFeature()).getFlowering());
             return;
         }
         if (bio.getFeature() instanceof  MicrobeFeature){
             System.out.println("최신 등록 생물 : "+ bio.getName() + ", " + bio.getType() + ", " + ((MicrobeFeature) bio.getFeature()).getPh() + ", "+
                            ((MicrobeFeature) bio.getFeature()).getMetabolism());
         }
    }
    public void isEmpty(){
        if (bs.isEmpty()){
            System.out.println("생물 정보 리스트가 비어있습니다.");
            return;
        }
        System.out.println("생물 정보 리스트가 비어있지 않습니다.");
    }


    public void sortByName(){
        bs.sort(new Comparator<BiologicalEntity<T>>() {
            @Override
            public int compare(BiologicalEntity<T> o1, BiologicalEntity<T> o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println("이름을 기준으로 오름차순 완료");


        for (BiologicalEntity<T> b : bs){
            if (b.getFeature() instanceof  AnimalFeature){
                System.out.println(b.getName() + ", " + b.getType() + ", "+ ((AnimalFeature) b.getFeature()).getCharacteristic() +
                        ((AnimalFeature) b.getFeature()).getClassification() +", "+ ((AnimalFeature) b.getFeature()).getLife());
                continue;
            }
            if (b.getFeature() instanceof  PlantFeature){
                System.out.println(b.getName() + ", " + b.getType() + ", " + ((PlantFeature) b.getFeature()).getColor() + ", "+
                        ((PlantFeature) b.getFeature()).getFruit()+ ", " + ((PlantFeature) b.getFeature()).getFlowering());
                continue;
            }
            if (b.getFeature() instanceof  MicrobeFeature){
                System.out.println(b.getName() + ", " + b.getType() + ", " + ((MicrobeFeature) b.getFeature()).getPh() + ", "+
                        ((MicrobeFeature) b.getFeature()).getMetabolism());
            }
        }

    }
}
