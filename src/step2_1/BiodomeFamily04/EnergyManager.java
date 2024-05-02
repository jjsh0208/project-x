package step2_1.BiodomeFamily04;

public class EnergyManager {
    public static int Total(EnergySource... Energy){
        int sum = 0;
        for(EnergySource energy : Energy){
            sum += energy.getEnergyAmount();
        }
        return sum;
    }
}
