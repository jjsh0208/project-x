package step2_2.RuleOfBodome04;

import java.util.ArrayList;

public class BiologicalSystem<T> {
    private ArrayList<BiologicalEntity<T>> arrayList;

    public BiologicalSystem() {
        this.arrayList = new ArrayList<>();
        System.out.println("생물정보 시스템이 생성되었습니다.");
    }

    public void add(BiologicalEntity<T> Biological){
        arrayList.add(Biological);
        System.out.println("새로운 생물이 등록되었습니다 : "+  Biological.getName());
    }
    public void delete(){}
    public void clear(){}
    public void show(){}
    public void isEmpty(){}

    public void add(String name, String type, AnimalFeature animalFeature) {

    }
}
