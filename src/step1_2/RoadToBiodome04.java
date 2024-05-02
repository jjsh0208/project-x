package step1_2;

import java.util.Arrays;

public class RoadToBiodome04 {

    //bonus
    public static int[][] extractNumbersBonus(String args) {
        String[] parts = args.split("], \\[");
        parts[0] = parts[0].substring(1); // 첫 번째 '[' 제거
        parts[parts.length - 1] = parts[parts.length - 1].substring(0, parts[parts.length - 1].length() - 1); // 마지막 ']' 제거


        // 문자열을 정수 배열로 변환합니다.
        int[][] array = new int[parts.length][];

        for (int i = 0; i < parts.length; i++) {
            // 각 부분을 쉼표로 나누고, 결과를 정수 배열로 변환하여 저장합니다.
            array[i] = Arrays.stream(parts[i].split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            // 선택정렬로 정렬합니다.
            for (int j = 0; j < array[i].length - 1; j++) {
                int minIndex = j;
                for (int k = j + 1; k < array[i].length; k++) {
                    if (array[i][k] < array[i][minIndex]) { // 오름차순
                        minIndex = k;
                    }
                }
                // 최소값을 현재 위치로 교환
                int temp = array[i][j];
                array[i][j] = array[i][minIndex];
                array[i][minIndex] = temp;
            }
        }

        return array;
    }

// 기본 문제
    public static int [] extractNumbers(String args){
        int [] energy = Arrays.stream(args.replaceAll("[^0-9]", " ").trim().split("\\s+"))
                .mapToInt(s -> Integer.parseInt(s.trim()))
                .toArray();
        //선택정렬
        for(int i=0; i<energy.length; i++) { // 0 ~ 4
            for(int j=i+1; j<energy.length; j++) {
                if(energy[i] > energy[j]) { //오름차순
                    int tmp = energy[i];
                    energy[i] = energy[j];
                    energy[j] = tmp;
                }
            }
        }
        return energy;
    }
    public static double avg(int [] energy){
        double avg = 0;
        for(int i : energy){
            avg += i;
        }
        return avg /= energy.length;
    }

    private static double median(int[] energy) {
        if (energy.length % 2 != 0) { //에너지 배열의 길이가 홀수인 경우
            return energy[(energy.length-1)/2];
        }
        else {//짝수인경우
            return (energy[(energy.length)/2] + energy[(energy.length/2)-1]) / 2f;
        }
    }

    public static void main(String[] args) {
        //기본문제
        int [] energy = extractNumbers(args[0]);
        System.out.println("평균값 :" +avg(energy) +", 중앙값 :"+ median(energy));


        //bonus
//        int [][] energyList = extractNumbersBonus(args[0]);
//
//        System.out.printf("%.0f %.1f", median(energyList[0]) , median(energyList[1]));
    }
}
