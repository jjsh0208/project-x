package step3_1.BiodomeForever05;

public class EcoDateAnalyze {
    public  final float PI = 3.14f;
    public  final float uB = 0.415f;
    public double life(EcoData ecoData){
        double life = uB * Math.abs(Math.sqrt(ecoData.getHumidity()) - ecoData.getTemperature())  +  (ecoData.getOxygenLevel() / PI /PI);

        return  life;
    }

    public void LogAvg(EcoData ecoData){
        double logAvg = 2 / (Math.log(ecoData.getOxygenLevel() / 100) + Math.log(ecoData.getHumidity()/100));
        System.out.printf("%.2f",logAvg);
    }
}
