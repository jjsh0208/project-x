package step2_1.BiodomeFamily05;

public class BiodomeFamily05 {
    public static void main(String[] args) {
        Sorcerer sorcerer = new Sorcerer("아리엘");
        SolarStone solarStone = new SolarStone("태양의 돌");
        WindAmulet windAmulet = new WindAmulet("바람의 부적");
        WaterMirror waterMirror = new WaterMirror("물의 거울");
        System.out.println();

        sorcerer.addAncientArtifacts(solarStone,windAmulet,waterMirror);
        System.out.println();
        sorcerer.checkAncientArtifacts(solarStone,waterMirror);
        System.out.println();

        solarStone.charge(50);
        waterMirror.charge(30);
        solarStone.charge(10);
        System.out.println();

        solarStone.getChargeLevel();
        waterMirror.getChargeLevel();
        System.out.println();

        Chargeable.showChargingTips();
    }
}