package step1_1;

public class HelloBiodome05 {
    public static void main(String[] args) {
        //4bit의 정수 표현범위 2^4 - 1 = 15
        int g = 0,h = 0;
        for(int i = 0; i <=15; i++) {
            for(int j = 0; j<= 15; j++) {
                if(((i & 1>> i << 2 | j + i ^ j ) == 1) &&
                        (i % 2<< j >> i | 1 & 0 ^ 0 ) == 2) {
                    g = i;
                    h = j;
                }
            }
        }

        System.out.println((h*h+ g) * (h<<h) + (g<<g));
        //bonus
        System.out.println((++g * g + --g) * (++g<<g) + g);
    }
}
