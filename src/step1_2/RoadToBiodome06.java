package step1_2;

import java.util.Arrays;

public class RoadToBiodome06 {

    private static int[] initBonus(String args) {

        String[] parts = args.split("], \\[");
        parts[0] = parts[0].substring(1); // 첫 번째 '[' 제거
        parts[1] = parts[1].substring(0, parts[1].length() - 1); // 마지막 ']' 제거

        // 각 부분을 쉼표로 나누고, 결과를 정수 배열로 변환하여 저장합니다.
        int[] array = Arrays.stream((parts[0]+parts[1]).split(", "))
                    .mapToInt(Integer::parseInt)
                    .filter(h -> h >= 30) //보너스
                    .sorted()
                    .toArray();
        return array;
    }



    private static int[][] init(String args) {

        String[] parts = args.split("], \\[");
        parts[0] = parts[0].substring(1); // 첫 번째 '[' 제거
        parts[1] = parts[1].substring(0, parts[1].length() - 1); // 마지막 ']' 제거

        int[][] array = new int[parts.length][];

        for (int i = 0; i < parts.length; i++) {
            // 각 부분을 쉼표로 나누고, 결과를 정수 배열로 변환하여 저장합니다.
            array[i] = Arrays.stream(parts[i].split(", "))
                    .mapToInt(Integer::parseInt)
//                    .filter(h -> h >= 30) //보너스
                    .sorted()
                    .toArray();
        }
        return array;
    }

    private static double median(int[] energy) {
        if (energy.length % 2 != 0) { //에너지 배열의 길이가 홀수인 경우
            return energy[(energy.length-1)/2];
        }
        else {//짝수인경우
            double test=  (energy[(energy.length)/2] + energy[(energy.length/2)-1]);
            return test / 2f;
        }
    }
    public static double avg(int [][] energy,int n, int m){
        double avg = 0;
        for(int i = 0 ; i < energy.length; i++) {
            for (int v : energy[i]) {
                avg += v;
            }
        }
        return avg /= n+m;
    }

    public static void main(String[] args) {

        int[][] water = init(args[0]);
        int[] bonus = initBonus(args[0]);

        int n = water[0].length;
        int m = water[1].length;
        double Mean  = avg(water,n,m);
        double Median = (median(water[0])+ median(water[1])) / 2;

//        System.out.printf("Mean : %.1f, Median : %.1f" ,Mean , Median);

        //bonus
        System.out.printf("Mean : %.1f, Median : %d" ,Mean ,(int)median(bonus));
    }


}
