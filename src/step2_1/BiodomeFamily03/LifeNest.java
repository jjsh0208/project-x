package step2_1.BiodomeFamily03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class LifeNest {
    public ArrayList<Organism> organismList = new ArrayList<Organism>();

    public void addOrganism (){
        Scanner sc = new Scanner(System.in);
        System.out.println("추가할 동물의 종을 고르시오 (1. 동물  2. 식물)  : ");
        switch (Integer.parseInt(sc.nextLine())){
            case 1:
                System.out.println("동물의 그룹을 고르시오 (1. 포우류  2.조류  3.어류) : ");
                switch (Integer.parseInt(sc.nextLine())){
                    case 1:
                        System.out.print("동물의 이름 : ");
                        String MammalName = sc.nextLine();
                        System.out.print("동물의 종 : " );
                        String MammalType = sc.nextLine();
                        System.out.print("동물의 서식지 : ");
                        String MammalHabitat = sc.nextLine();
                        System.out.print("동물의 소화방식 : " );
                        String MammalDigestion = sc.nextLine();
                        System.out.print("동물의 먹이 : ");
                        String MammalFood = sc.nextLine();
                        System.out.print("동물의 특징 : ");
                        String WarmBlooded = sc.nextLine();
                        organismList.add(new Mammal(MammalName,MammalType,MammalHabitat,MammalDigestion,MammalFood,WarmBlooded));
                        System.out.println("[LifeNest] "+ MammalName + "가 추가되었습니다.");
                        break;
                    case 2:
                        System.out.print("동물의 이름 : ");
                        String BirdName = sc.nextLine();
                        System.out.print("동물의 종 : " );
                        String BirdType = sc.nextLine();
                        System.out.print("동물의 서식지 : ");
                        String BirdHabitat = sc.nextLine();
                        System.out.print("동물의 소화방식 : " );
                        String BirdDigestion = sc.nextLine();
                        System.out.print("동물의 먹이 : ");
                        String BirdFood = sc.nextLine();
                        System.out.print("동물의 특징 : ");
                        String fly = sc.nextLine();
                        organismList.add(new Bird(BirdName,BirdType,BirdHabitat,BirdDigestion,BirdFood,fly));
                        System.out.println("[LifeNest] "+ BirdName + "가 추가되었습니다.");
                        break;
                    case 3:
                        System.out.print("동물의 이름 : ");
                        String FishName = sc.nextLine();
                        System.out.print("동물의 종 : " );
                        String FishType = sc.nextLine();
                        System.out.print("동물의 서식지 : ");
                        String FishHabitat = sc.nextLine();
                        System.out.print("동물의 소화방식 : " );
                        String FishDigestion = sc.nextLine();
                        System.out.print("동물의 먹이 : ");
                        String FishFood = sc.nextLine();
                        System.out.print("동물의 특징 : ");
                        String finsCount = sc.nextLine();
                        organismList.add(new Fish(FishName,FishType,FishHabitat,FishDigestion,FishFood,finsCount));
                        System.out.println("[LifeNest] "+ FishName + "가 추가되었습니다.");
                        break;
                    default:
                        break;
                }
                break;
            case 2:
                System.out.print("식물의 이름 : ");
                String PlantName = sc.nextLine();
                System.out.print("식물의 종 : " );
                String PlantType = sc.nextLine();
                System.out.print("식물의 서식지 : ");
                String PlantHabitat = sc.nextLine();
                System.out.print("식물의 개화시기 : " );
                String PlantFlowering = sc.nextLine();
                System.out.print("식물의 열매 유무 : ");
                String PlantFruit = sc.nextLine();
                organismList.add(new Plant(PlantName,PlantType,PlantHabitat,PlantFlowering,PlantFruit));
                System.out.println("[LifeNest] "+ PlantName + "가 추가되었습니다.");
                break;
            default:
                System.out.println("1과 2중에 입력해주세요.");
                break;

        }

    }

    public void removeOrganism(String name){
        Iterator<Organism> iterator = organismList.iterator();
        while(iterator.hasNext()){
            Organism O = iterator.next();
            if(O.getName().equals(name)){
                System.out.println("[LifeNest] "+ O.getName() + "가 삭제되었습니다.");
                iterator.remove();
                break;
            }
        }
    }

    public void displayAll(){
        int id = 1;
        System.out.println("전체 동식물 목록 출력 : ");
        for (Organism O : organismList){
            System.out.print(id++ + ". ");
            if(O instanceof Plant){
                O.displayInfo();
            }
            if(O instanceof Mammal){
                O.displayInfo();
                ((Mammal) O).giveBirth(); //다운캐스팅
            }
            if(O instanceof Bird){
                O.displayInfo();
                ((Bird) O).fly(); //다운캐스팅
            }
            if(O instanceof Fish){
                O.displayInfo();
                ((Fish) O).swim(); //다운캐스팅
            }
        }
    }

}
