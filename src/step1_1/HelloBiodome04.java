package step1_1;

public class HelloBiodome04 {

    final static double uB = 0.415;
    final static double PI = 3.14;

    private static boolean isNumeric(String str) {

        return (str != null && !str.isEmpty() && str.matches("-?\\d+(\\.\\d+)?"));
    }
    public static double life(double temperature, double humidity, double oxygen) {
        return  ( uB * abs(sqrt(humidity) - temperature))  +  (oxygen / PI /PI);
    }

    public static double abs (double num) {
        if(num > 0) {
            return num;
        }
        else {
            return -num;
        }
    }

    public static double sqrt(double x) {
        return sqrtRecursive(x,x);
    }

    private static double sqrtRecursive(double x, double guess) {
        double nextGuess = 0.5 * (guess + x / guess);

        if (abs(nextGuess - guess) < 0.000001) {
            return nextGuess;
        }

        return sqrtRecursive(x, nextGuess);
    }



    private static boolean RangeCheck(float temperature, float humidity, float oxygen) {
        if(temperature < 10 || temperature > 27.5) { // 수정된 조건
            System.out.println("온도값이 정상 범위를 벗어났습니다. 확인이 필요합니다.");
            return false;
        }
        else if(humidity <= 40 || humidity > 60) { // 수정된 조건
            System.out.println("습도값이 정상 범위를 벗어났습니다. 확인이 필요합니다.");
            return false;
        }
        else if(oxygen < 19.5 || oxygen > 23.5) { // 수정된 조건
            System.out.println("산소값이 정상 범위를 벗어났습니다. 확인이 필요합니다.");
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        if((args.length == 3 && isNumeric(args[0]) && isNumeric(args[1]) && isNumeric(args[2])) == false) {
            System.out.println("입력된 값이 올바르지 않습니다. [온도][습도][산소농도] 순서대로 숫자 값을 입력해주세요");
            System.exit(0);
        }

        float temperature  = Float.parseFloat(args[0]);
        float humidity = Float.parseFloat(args[1]);
        float Oxygen = Float.parseFloat(args[2]);

        double H = life(temperature,humidity,Oxygen);
        if(RangeCheck(temperature,humidity,Oxygen)) {
            System.out.printf("생명의 나무는 안정적인 상태입니다. 건강지수는 %.2f 입니다.\n",H);
        }
        else {
            System.exit(0);
        }
    }
}
