package step1_2;

import java.util.Arrays;

public class RoadToBiodome05 {

    private static void quickSort(int[] water, int low, int high) {
        //low가 high 보다 크거나 같으면 정렬할 원소가 없다는 의미
        if(low >= high) return;

        int l = low;
        int h = high;
        int pivot = water[(low + high) / 2];

        while (l <= h) {
            while (water[l] < pivot) {
                l++;
            }

            while (water[h] > pivot) {
                h--;
            }

            if (l <= h) {
                int tmp = water[h];
                water[h] = water[l];
                water[l] = tmp;
                l++;
                h--;
            }
        }

        quickSort(water, low, h);
        quickSort(water, l, high);
    }
    private static void bubbleSort(int[] water) {
        int size = water.length;

        for (int i = 0; i < size - 1; i++){
            for(int j = 0; j < size - 1; j++){
                if(water[j] > water[j + 1]){
                    int tem = water[j];
                    water[j] = water[j + 1];
                    water[j + 1] = tem;
                }
            }
        }
    }

    private static void rangeCheck(int[] water) {
        for(int i : water){
            if(i < 0 || i > 1000){
                System.out.println("물의 범위를 벗어납니다. 다시 입력해주세요");
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        //두 개의 배열만 받고 대괄호 안에 쉼표,로 구분된 숫자만 입력받게 하는 정규식
        // 수정된 정규식: 두 개의 배열이 공백으로 구분되어 있는 형태를 검증합니다.
        if (!args[0].matches("^\\[\\d+(,\\s*\\d+)*\\]\\s+\\[\\d+(,\\s*\\d+)*\\]$")) {
            System.out.println("잘못된 입력 형식입니다.");
            return;
        }

        //배열을 하나로 만들어 유효성 검사를 진행한다.
        int[] water = Arrays.stream((args[0]).replaceAll("[^0-9]", " ").trim().split("\\s+"))
                .mapToInt(s -> Integer.parseInt(s.trim()))
                .toArray();
        rangeCheck(water);


        quickSort(water,0,water.length - 1);
        //버블정렬
        bubbleSort(water);

        for (int i : water) {
            System.out.print(i + " ");
        }
    }
}
