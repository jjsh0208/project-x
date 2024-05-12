package step2_2.RuleOfBiodome05;

public class PlantHashMap<K,V> {
    private Entity<K,V>[] entity;
    private final int size = 16;

    public PlantHashMap() {
        this.entity = new Entity[size];
    }

    static class Entity<K, V>{
        private K plant;
        private V characteristic;
        private  Entity<K, V> next;

        public Entity(K plant, V characteristic , Entity<K, V> next) {
            this.plant = plant;
            this.characteristic = characteristic;
            this.next  = next; // 다음 Entity 객체를 가리키는 참조. 같은 인덱스에 위치한 연결 리스트의 다음 노드를 가리킴

        }

        public K getPlant() {
            return plant;
        }

        public V getCharacteristic() {
            return characteristic;
        }
    }

    public void put(K plant , V characteristic){
        int index = plant.hashCode() % size;

        Entity<K,V> e = new Entity<>(plant,characteristic,null);

        if (entity[index] == null){
            entity[index] = e;
            System.out.println("\'"+plant+"\' 추가 : \'" +characteristic+'\'');
        }
        else {
            Entity<K,V> current = entity[index];

            while (current.next != null) { //다음 노드가 존재할 때까지 리스트를 순회한다
                if (current.plant.equals(plant)) { //현재 식물의 이름과 입력한 추가할려는 식물의 이름이 같으면
                    System.out.println("\'"+plant+"\' 이미 존재 : \'" +characteristic+"\' (추가되지 않음)"); //추가하지않음
                    return;
                }
                current = current.next; //스페어 주소를 대입한다.
            }

            if (current.plant.equals(plant)) { //현재 인덱스의 식물의 이름과 입력한 이름이 동일하면 추가하지않는다.
                System.out.println("\'"+plant+"\' 이미 존재 : \'" +characteristic+"\' (추가되지 않음)");
                return;
            }
            current.next = e; //아무것도 해당되지않으면 스페어로 넘긴다.
            System.out.println("\'"+plant+"\' 추가 : \'" +characteristic+'\'');
        }
    }

    public V get(K plant){
        //해당 인덱스에서 식물을 찾아 특징을 반환한다. 식물이 리스트에 없으면 null을 반환한다
        System.out.println("(식물 특징 검색)");
        int index = plant.hashCode() % size;

        Entity<K,V> e = entity[index];

        if (e != null && entity[index].getPlant().equals(plant)){
            return e.getCharacteristic();
        }

        System.out.println("해당 이름의 식물이 존재하지않습니다.");
        return  null;
    }

    public void remove(K plant){
        System.out.println("(식물 삭제)");
        int index = plant.hashCode() % size;

        Entity<K,V> current = entity[index];
        Entity<K,V> prev = null;

        while (current != null) { //해당 인덱스가 null이 아니면 반복
            if (current.getPlant().equals(plant)) { //해당 인덱스의 식물 이름과 입력한 식물의 이름이 같으면
                if (prev == null) {  //해당 인덱스의 첫 번째 노드가 삭제 대상일 경우, 다음 노드를 첫 번째 노드로 설정하여 삭제 대상 노드를 제거한다
                    entity[index] = current.next;
                } else {//null이 아닐 시 다음 주소를 대입한다.
                    prev.next = current.next;
                }
                System.out.println("\'"+plant +"\' 삭제 : \'"+ current.getPlant()+"\'와 그 특징이 삭제되었습니다.");
                return;
            }
            prev = current;
            current = current.next;
        }
        System.out.println("해당 이름의 식물이 존재하지않습니다.");
    }


    public int getIndex(K plant){
        System.out.println("(식물 이름으로 인덱스 출력)");
        int index =  plant.hashCode() % size;

        Entity<K,V> e = entity[index];

        if (e != null && entity[index].getPlant().equals(plant)){
            return index;
        }
        
        //검색 실패시 -1을 반환한다
        return -1;
    }

}
