package step3_2.RunBiodome06;

import step3_2.RunBiodome05.Sensor;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunBiodome06 {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("물 저장소 관리 시스템에 오신걸 환영합니다.");
        int[] priority = new int[5];

         Thread[] test = new Thread[5];

        for (int i = 1; i < priority.length + 1; i++){
            System.out.print(i+"번 물 저장소 우선순위를 입력해주세요: ");
            priority[i -1] = Integer.parseInt(sc.nextLine());
            test[i -1] = new Thread(new WaterTank(i,priority[i-1]));
            test[i - 1].setPriority(priority[i -1]);
        }
        System.out.println("<물 채우기 시작>");
        for (int i = 10; i >= 0; i--){ //Priority 우선순위는 1~10 까지 수 중 큰 수부터 우선실행
            for (Thread t : test){ //배열에 입력한 순으로 돌아가기 때문에 동일한 우선순위가 나와도 index가 낮은 탱크부터 채워진다.
                if (t.getPriority() == i){
                    t.start();
                    t.join();
                    System.out.println();
                }
            }
        }

        System.out.println("\n물 채우기가 완료되었습니다.");




//        WaterTank waterTank1 = new WaterTank(1,true);
//        WaterTank waterTank2 = new WaterTank(2);
//        WaterTank waterTank3 = new WaterTank(3);
//        WaterTank waterTank4 = new WaterTank(4);
//        WaterTank waterTank5 = new WaterTank(5);
//
//        waterTank1.setNextTank(waterTank2);
//        waterTank2.setNextTank(waterTank3);
//        waterTank3.setNextTank(waterTank4);
//        waterTank4.setNextTank(waterTank5);
//
//        int threadNumber = 5;
//
//        //Executors 클래스 사용
//        //고정된 크기의 스레드 풀 생성 (총 threadNumber 개의 스레드를 가진 스레드 풀)
//        ExecutorService executor = Executors.newFixedThreadPool(threadNumber);
//
//        //execute 스레드 풀에 할당
//        executor.execute(waterTank1);
//        executor.execute(waterTank2);
//        executor.execute(waterTank3);
//        executor.execute(waterTank4);
//        executor.execute(waterTank5);
//        //한 사이클 진행 시 줄바꿈을 넣고싶은데 future 객체를 사용해야하는듯
//
//        synchronized (waterTank1){ waterTank1.notify();}
//        executor.shutdown(); //스레드 풀 종료, 현재 진행중인 작업은 완료하지만 새로운 작업은 수행하지않는 의미
    }
}
