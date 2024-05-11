package step2_2.RuleOfBodome04;

import java.util.ArrayList;

public class BiologicalSystem<T> {
    private ArrayList<BiologicalEntity<T>> arrayList = new ArrayList<>();

    public void add(BiologicalEntity<T> Biological){
        arrayList.add(Biological);
    }
    public void delete(){}
    public void clear(){}
    public void show(){}
    public void isEmpty(){}

    public void add(String name, String type, AnimalFeature animalFeature) {

    }
}
