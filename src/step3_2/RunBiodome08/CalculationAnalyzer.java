package step3_2.RunBiodome08;

import java.util.ArrayList;
import java.util.List;

public class CalculationAnalyzer  implements SeonsrObserver ,Runnable{
    List<Double> temperatures = new ArrayList<>();

    @Override
    public void relayData(double temperature, int heartRate) {
            temperatures.add(temperature);
            printStatistics();
    }

    private void printStatistics() {
        double average = temperatures.stream() //평균
                .mapToDouble(Double ::doubleValue)
                .average()
                .orElse(0.0);
        double max = temperatures.stream()
                .mapToDouble(Double ::doubleValue)
                .max()
                .orElse(0.0);
        double min = temperatures.stream()
                .mapToDouble(Double ::doubleValue)
                .min()
                .orElse(0.0);

        System.out.printf("[분석기 2] 평균 체온 : %.1f\n",average);
        System.out.printf("[분석기 2] 최대 체온 : %.1f\n",max);
        System.out.printf("[분석기 2] 최소 체온 : %.1f\n\n",min);
    }

    @Override
    public void run() {
    }
}
