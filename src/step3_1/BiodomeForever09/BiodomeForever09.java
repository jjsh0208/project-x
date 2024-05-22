package step3_1.BiodomeForever09;

import java.util.Scanner;

public class BiodomeForever09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Directory d  = new Directory();
        long startTime = System.currentTimeMillis();

        System.out.println("중복 파일 검색기에 오신 걸 환영합니다.");

        System.out.print("탐색할 폴더를 입력하세요: ");
        String directoryPath = sc.nextLine();
        d.duplicationCheck(directoryPath);


        performTask();
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        System.out.println("Execution time: " + executionTime + " milliseconds");
    }

    public static void performTask() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
