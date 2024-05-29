package step3_2.RunBiodome08;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunBiodome08 {
    /*
    Subject (주체): 상태를 가지고 있으며, 상태의 변화를 통지할 수 있는 객체이다. 옵저버를 등록, 해지, 그리고 알림을 보내는 메서드를 포함
    Observer (옵저버): 주체의 상태 변화에 따라 행동을 취하는 객체이다. 주체로부터 상태 변화 알림을 받습니다.
    */
    public static void main(String[] args) {
        ElephantSensor elephantSensor = new ElephantSensor();
        DetectorAnalyzer detectorAnalyzer = new DetectorAnalyzer();
        CalculationAnalyzer calculationAnalyzer = new CalculationAnalyzer();

        elephantSensor.registerObserver(detectorAnalyzer);
        elephantSensor.registerObserver(calculationAnalyzer);

        int threadNumber = 3;

        //Executors 클래스 사용
        //고정된 크기의 스레드 풀 생성 (총 threadNumber 개의 스레드를 가진 스레드 풀)
        ExecutorService executor = Executors.newFixedThreadPool(threadNumber);

        //execute 스레드 풀에 할당
        executor.execute(elephantSensor :: monitoring);
        executor.execute(detectorAnalyzer);
        executor.execute(calculationAnalyzer);

        executor.shutdown();
    }
}
