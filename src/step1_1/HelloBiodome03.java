package step1_1;

public class HelloBiodome03 {
    public static final float PI = 3.14f;
    public static final float uB = 0.415f;

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

    public static boolean isNumeric(String str) {

        return (str != null && !str.isEmpty() && str.matches("-?\\d+(\\.\\d+)?"));
    }

    public static void main(String[] args) {

        if((args.length == 3 && isNumeric(args[0]) && isNumeric(args[1]) && isNumeric(args[2])) == false) {
            System.out.println("입력된 값이 올바르지 않습니다. [온도][습도][산소농도] 순서 대로 숫자 값을 입력해주세요");
            System.exit(0);
        }

        float temperature  = Float.parseFloat(args[0]);
        float humidity = Float.parseFloat(args[1]);
        float Oxygen = Float.parseFloat(args[2]);

        double H = life(temperature,humidity,Oxygen);

        //bonus 소수점 3자리에서 반올림
        System.out.printf("생명지수 H = %.2f\n", H);
    }
}