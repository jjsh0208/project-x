package step3_2.RunBiodome08;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ElephantSensor implements SensorSubject {
    List<SeonsrObserver> observers = new ArrayList<SeonsrObserver>();
    private double temperature;
    private int heartRate;

    @Override
    public void registerObserver(SeonsrObserver o) { //분석기를 등록하는 메서드
        observers.add(o);
    }

    @Override
    public void removeObserver(SeonsrObserver o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() { //분석기에 데이터를 전달하는 메서드
        for (SeonsrObserver observer : observers){
            observer.relayData(temperature,heartRate);
        }
    }

    //10초마다 코끼리의 체온과 심박수를 임의로 생성하는 메서드
    public void monitoring(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                generateDate();
                printData();
                notifyObservers();
            }
        },0,10000);
    }
    //랜덤으로 체온과 심박수 생성 메서드
    private void generateDate() {
        //35.9°C ~ 37.5°C, 안정기 심박수 범위 : 25~40bpm
        Random random = new Random();
        this.temperature = 35.9 + (37.5 -35.9) * random.nextDouble();
        this.heartRate = 25 + random.nextInt(40);

    }
    
    //현재 시간과 함께 데이터를 출력하는 메서드
    private void printData(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초");
        String date = now.format(formatter);
        System.out.printf("%s 체온 : %.1f°C, 심박수 : %d bpm\n",date,this.temperature,this.heartRate);
    }
}