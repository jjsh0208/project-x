package step3_2.RunBiodome05;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunBiodome05 {
    /*
    스레드 풀의 크기를 결정할 때 고려해야할 요소는 크게 3가지 정도 되는것 같다(아마도)
    1.하드웨어 리소스 : 사용 가능한 cpu 코어의 수와 메모리 용량이 스레드 풀의 최적 크기를 결정하는 데 중요한 역할을 한다.
                     너무 많은 스레드를 생성하면 컨텍스트 스위칭으로 이한 오버헤드가 증가, 메모리 사용량이 증가해 성능이 저하된다.
    2.작업의 성격    : cpu 바운드 작업 과 I/O 바운드 작업은 서로 다른 스레드 풀 크기를 필요로 한다.
                     cpu 바운드 작업의 경우 사용 가능한 코어 수와 비슷한 크기의 스레드 풀이 일반적으로 효율적, 반면 I/O 바운드 작업의 경우
                     I/O 대기 시간동안 다른 작업을 수행할 수 있기 때문에 더큰 스레드 풀이 유용할 수 있습니다.
    3.작업의 우선순위와 응답시간 요구사항 : 특정 작업이 다른 작업보다 우선순위가 높거나 빠른 응답 시간을 요구하는 경우,스레드 풀의 크기와 작업 할당 방식을
                                     조정하여 이러한 요구사항을 충족할 수 있다.
              
              
                                 
    내가 스레드 풀의 크기를 5로 설정한 이유는 cpu 바운드 작업이라 사용할 만큼만 지정하는게 오버헤드도 없고 성능이 저하 되지않을 거 같아서 5로 설정했다
    크기를 직접 변경해가며 모니터링해서 가장 효율적인 크기를 찾는것이 중요한 것 같다
    */

    public static void main(String[] args) {
        System.out.println("센서 모니터링을 시작합니다...\n");

        int threadNumber = 5;

        //Executors 클래스 사용
        //고정된 크기의 스레드 풀 생성 (총 threadNumber 개의 스레드를 가진 스레드 풀)
        ExecutorService executor = Executors.newFixedThreadPool(threadNumber);

        //execute 스레드 풀에 할당
        executor.execute(new Sensor("temperature"));
        executor.execute(new Sensor("oxygen"));
        executor.execute(new Sensor("co2"));
        executor.execute(new Sensor("humidity"));
        executor.execute(new Sensor("ozone"));
        //한 사이클 진행 시 줄바꿈을 넣고싶은데 future 객체를 사용해야하는듯
        
        
        executor.shutdown(); //스레드 풀 종료, 현재 진행중인 작업은 완료하지만 새로운 작업은 수행하지않는 의미
    }
}
