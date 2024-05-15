package step2_2.RuleOfBiodome07;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Plant implements  Comparable<Plant>{
    private String name;
    private String type;
    private int needWater;
    private LocalDateTime lastWatered;
    private int waterCycle;
    private double humidity;

    public Plant(String name, String type, int needWater, int waterCycle , LocalDateTime localDateTime , double humidity) {
        this.name = name;
        this.type = type;
        this.needWater = needWater;
        this.waterCycle = waterCycle;
        this.lastWatered = localDateTime;
        this.humidity = humidity;

        System.out.println(toString());
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = this.lastWatered.format(formatter);
        return this.name +", "+ this.needWater +", 마지막 물 공급 일자 : "+ formattedDateTime + ", 물 공급 주기 : "+ this.waterCycle +
                ", 적정 습도 : " + this.humidity;
    }

    public void water(double humidity) {
        this.lastWatered = LocalDateTime.now();
        System.out.println(this.name +"에 물을 공급했습니다. 마지막 물 공급 일자 업데이트: [현재 시각]\n");
    }

    // 다음 물 공급 일정 계산
    public LocalDateTime getNextWateringTime() {
        return lastWatered.plusHours(waterCycle); //현재 시간 + 주기
    }

    @Override
    public int compareTo(Plant another) {
        return this.getNextWateringTime().compareTo(another.getNextWateringTime());
    }


    public double getHumidity() {
        return humidity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNeedWater() {
        return needWater;
    }


}