package step2_1.BiodomeFamily05;

import java.util.ArrayList;

public class Sorcerer {
    private static String name;
    private static ArrayList<AncientArtifact> ancientArtifacts = new ArrayList<AncientArtifact>();

    public Sorcerer(String name) {
        Sorcerer.name = name;
        System.out.println("마법사 "+ "\'"+name  +"\'" +"이 생성되었습니다.");
    }

    public static String getName() {
        return name;
    }

    public void addAncientArtifacts(AncientArtifact... ancientArtifact){
        for(AncientArtifact a : ancientArtifact){
            ancientArtifacts.add(a);
            System.out.println("마법사 "+"\'" + name + "\'" +"이 "+ a.getName() +"을 소유하게되었습니다.");
        }
    }

    public void checkAncientArtifacts(AncientArtifact... ancientArtifact){

        for(AncientArtifact a : ancientArtifact) {
            if (a instanceof SolarStone) {
                ((SolarStone) a).describe();
            }
            if (a instanceof WaterMirror) {
                ((WaterMirror) a).describe();
            }
            if (a instanceof WindAmulet) {
                ((WindAmulet) a).describe();
            }
        }
    }
}
