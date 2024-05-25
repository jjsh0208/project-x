package step3_2.RunBiodome05;

import java.time.LocalDateTime;
import java.util.Random;

public class Sensor extends Thread{
    //정상 온도 범위 : -5°C~32.5°C, 정상 산도 농도 범위 : 18.5%~23.5%
    private String type;
    private double temperature;
    private double oxygen;
    private double co2;
    private double humidity;
    private double ozone;

    private double minValue;
    private double maxValue; //온도 최대 범위 , 산도 최대 범위

    Sensor(String type){
        if (type.equals("temperature")){
            this.maxValue = 32.5;
            this.minValue = -5;
            this.type = "temperature";
        } else if (type.equals("oxygen")) {
            this.maxValue = 23.5;
            this.minValue = 18.5;
            this.type = "oxygen";
        } else{//bonus (범위 예시가 없어서 산소 농도랑 동일하게함)
            this.maxValue = 23.5;
            this.minValue = 18.5;
            this.type = type;
        }
    }

    @Override
    public void run() {
        while(true){
            LocalDateTime date = LocalDateTime.now();
            switch (type){
                case "temperature":
                    temperature = generateData();
                    checkAndPrint(temperature,date);
                    break;
                case "oxygen":
                    oxygen = generateData();
                    checkAndPrint(oxygen,date);
                    break;
                case "co2":
                    co2 = generateData();
                    checkAndPrint(co2,date);
                    break;
                case "humidity":
                    humidity = generateData();
                    checkAndPrint(humidity,date);
                    break;
                case "ozone":
                    ozone = generateData();
                    checkAndPrint(ozone,date);
                    break;
                default:
                    break;
            }
            try{
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void checkAndPrint(double value, LocalDateTime date){
        String status = "";
        if (value > maxValue){
            status = String.format("%s:%.4s%s [경고: %s 상한 초과]",type,value,type.equals("temperature")? "°C" : "%",type);
        }
        else if (value < minValue) {
            status = String.format("%s:%.4s%s [경고: %s 하한 미달]",type,value,type.equals("temperature")? "°C" : "%",type);
        }else{
            status = String.format("%s:%.4s%s",type,value,type.equals("temperature")? "°C" : "%");
        }

        System.out.printf("%s년 %s월 %s일 %s시 %s분 %s초 %s\n",date.getYear(),date.getMonthValue(),
                date.getDayOfMonth(),date.getHour(),date.getMinute(),date.getSecond(),status);
    }
    private double generateData() {
        Random rand = new Random();
        return  minValue + (maxValue - minValue) * rand.nextDouble() * 1.5;
    }
}