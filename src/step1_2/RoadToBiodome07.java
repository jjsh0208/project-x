package step1_2;

import java.util.*;


public class RoadToBiodome07 {
    private static String[] bubbleSort(LinkedHashMap<String, Integer> animalMap) {
        LinkedList<Map.Entry<String,Integer>> list = new LinkedList<>(animalMap.entrySet());

        for(int i = 0; i < animalMap.size() - 1; i++){ // 0 ~ 4
            for(int j = 0; j < animalMap.size() - i - 1; j++){
                if(list.get(j).getValue() < list.get(j + 1).getValue()){
                    Map.Entry<String,Integer> tem = list.get(j);
                    list.set(j , list.get(j+1));
                    list.set(j+1, tem);
                }
                if(list.get(j).getValue() == list.get(j + 1).getValue()){
                    if(list.get(j).getKey().compareTo(list.get(j+1).getKey()) > 0){
                        Map.Entry<String,Integer> tem = list.get(j);
                        list.set(j , list.get(j+1));
                        list.set(j+1, tem);
                    }
                }
            }
        }

        String[] animal = new String[list.size()];
        for(int i = 0; i < animal.length; i++){
            animal[i] = list.get(i).getKey();
        }

        return  animal;
    }

    private static void mergeSort(LinkedList<Map.Entry<String, Integer>> list, int left, int right) {
        if (left < right) {
            // 중간 지점을 찾아서
            int mid = left + (right - left) / 2;

            // 두 부분으로 나누어 각각 정렬
            mergeSort(list, left, mid);
            mergeSort(list, mid + 1, right);

            // 정렬된 두 부분을 병합
            merge(list, left, mid, right);
        }
    }

    private static void merge(LinkedList<Map.Entry<String, Integer>> list, int left, int mid, int right) {
        // 병합 정렬을 위한 임시 리스트
        LinkedList<Map.Entry<String, Integer>> temp = new LinkedList<>();

        int i = left;
        int j = mid + 1;

        while (i <= mid && j <= right) {
            Map.Entry<String, Integer> leftEntry = list.get(i);
            Map.Entry<String, Integer> rightEntry = list.get(j);

            // 값에 따라 내림차순으로 정렬
            if (leftEntry.getValue() > rightEntry.getValue()) {
                temp.add(leftEntry);
                i++;
            } else if (leftEntry.getValue() < rightEntry.getValue()) {
                temp.add(rightEntry);
                j++;
            } else { // 값이 같을 때는 키를 사전 순으로 오름차순 정렬
                if (leftEntry.getKey().compareTo(rightEntry.getKey()) <= 0) {
                    temp.add(leftEntry);
                    i++;
                } else {
                    temp.add(rightEntry);
                    j++;
                }
            }
        }

        // 남은 요소들 처리
        while (i <= mid) {
            temp.add(list.get(i++));
        }
        while (j <= right) {
            temp.add(list.get(j++));
        }

        // 임시 리스트의 내용을 원본 리스트로 복사
        for (int k = 0; k < temp.size(); k++) {
            list.set(left + k, temp.get(k));
        }
    }



    public static void main(String[] args) {
        if (args.length == 0 || !args[0].matches("^[\\p{L}\\[\\], ]+$")) {
            System.out.println("올바르지 않은 입력입니다. 프로그램을 종료합니다.");
            return; // 프로그램 종료
        }

        String [] animal =  Arrays.stream(args[0].replaceAll("[^\\p{L}]", " ").trim().split("\\s+"))
                .toArray(String[] :: new);

        LinkedHashMap<String ,Integer> animalMap = new LinkedHashMap<>();

        for(String a : animal){
            if(animalMap.containsKey(a)){
                animalMap.put(a,animalMap.get(a)+1);
            }
            else{
                animalMap.put(a,1);
            }
        }

        String[] animalBubbleSort = bubbleSort(animalMap);


//        for (int i = 0; i < animalBubbleSort.length; i++){
//            System.out.print(animalBubbleSort[i]);
//            if(i < animalBubbleSort.length - 1){
//                System.out.print(", ");
//            }
//        }

        //bonus
        LinkedList<Map.Entry<String, Integer>> list = new LinkedList<>(animalMap.entrySet());
        mergeSort(list, 0, list.size() - 1);

        // 병합 정렬된 리스트를 바탕으로 정렬된 동물 이름 배열 생성
        String[] animalMergeSort = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            animalMergeSort[i] = list.get(i).getKey();
        }

        // 병합 정렬된 결과 출력
        for (int i = 0; i < animalMergeSort.length; i++) {
            System.out.print(animalMergeSort[i]);
            if (i < animalMergeSort.length - 1) {
                System.out.print(", ");
            }
        }

    }
}
