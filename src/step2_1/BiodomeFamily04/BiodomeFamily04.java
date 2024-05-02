package step2_1.BiodomeFamily04;

public class BiodomeFamily04 {
    public static void main(String[] args) {
        SolarEnergy solarEnergy = new SolarEnergy("태양광");
        WindEnergy windEnergy = new WindEnergy("풍력");
        GeothermalEnergy geothermalEnergy = new GeothermalEnergy("지열");

        solarEnergy.produceEnergy(1); //10
        windEnergy.produceEnergy(4); //20
        geothermalEnergy.produceEnergy(2); //30

        System.out.println();

        solarEnergy.useEnergy(30); //-30
        windEnergy.useEnergy(30); //-30
        geothermalEnergy.useEnergy(30);

        System.out.println();
        System.out.println("남은 에너지 : " + EnergyManager.Total(solarEnergy,windEnergy,geothermalEnergy));
    }
}
