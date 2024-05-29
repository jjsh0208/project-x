package step3_2.RunBiodome08;

import java.util.ArrayList;
import java.util.List;

public class DetectorAnalyzer implements SeonsrObserver , Runnable{
    List<String> abnormalData = new ArrayList<>();
    @Override
    public void relayData(double temperature, int heartRate) {
        //안정기 체온 범위 : 35.9°C ~ 37.5°C, 안정기 심박수 범위 : 25~40bpm

        if (temperature < 35.9 || temperature > 37.5){
            System.out.printf("[분석기 1] 임계치 이상 체온 : %.1f°C\n",temperature);
            abnormalData.add(String.valueOf(temperature));
        }
        if (heartRate < 25|| heartRate > 40){
            System.out.printf("[분석기 1] 임계치 이상 심박수 : %d bpm\n",heartRate);
            abnormalData.add(String.valueOf(heartRate));
        }
    }

    @Override
    public void run() {

    }
}
