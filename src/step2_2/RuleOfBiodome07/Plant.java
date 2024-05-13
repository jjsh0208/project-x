package step2_2.RuleOfBiodome07;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Plant{
    private String name;
    private String type;
    private int needWater;
    private LocalDateTime lastWatered;
    private int waterCycle;

    public Plant(String name, String type, int needWater, int waterCycle , LocalDateTime localDateTime) {
        this.name = name;
        this.type = type;
        this.needWater = needWater;
        this.waterCycle = waterCycle;
        this.lastWatered = localDateTime;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = this.lastWatered.format(formatter);

        System.out.println(this.name +", "+ this.needWater +", 마지막 물 공급 일자 : "+ formattedDateTime + ", 물 공급 주기 : "+ this.waterCycle);
    }

    public void water() {
        this.lastWatered = LocalDateTime.now();
        System.out.println(this.name +"에 물을 공급했습니다. 마지막 물 공급 일자 업데이트: [현재 시각]\n");
    }

    // 다음 물 공급 일정 계산
    public LocalDateTime getNextWateringTime() {
        return lastWatered.plusHours(waterCycle); //현재 시간 + 주기
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

    public void setNeedWater(int needWater) {
        this.needWater = needWater;
    }


    public LocalDateTime getLastWatered() {
        return lastWatered;
    }

    public void setLastWatered(LocalDateTime lastWatered) {
        this.lastWatered = lastWatered;
    }

    public int getWaterCycle() {
        return waterCycle;
    }

    public void setWaterCycle(int waterCycle) {
        this.waterCycle = waterCycle;
    }


}