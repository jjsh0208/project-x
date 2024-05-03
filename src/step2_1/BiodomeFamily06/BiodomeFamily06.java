package step2_1.BiodomeFamily06;

import java.util.ArrayList;
import java.util.Arrays;
public class BiodomeFamily06 {
    static ArrayList<Animal> animals = new ArrayList<Animal>();
    static ArrayList<Animal_Enum> bonus = new ArrayList<Animal_Enum>();
    private static void animalSort(ArrayList<Animal> animals) {
    //일렬 이동 중 동물은 앞만 볼 수 있고 뒤는 볼 수 없다. (즉, 피식자는 포식자 뒤에 피할 수 있다.)
    //호랑이는 사슴의 포식자로, 사슴 뒤에 호랑이가 올 수 없다.
    //코끼리는 적대 관계의 동물이 없지만, 5살 이하 코끼리는 호랑이 앞에 올 수 없다.
        for(int i = 0; i < animals.size(); i++){
            for (int j = 0; j < animals.size()-1; j++){
                Animal animal = animals.get(j);
                Animal next = animals.get(j + 1);

                //사슴 뒤에 호랑이가 있을 경우
                if(animal.getType().equals("사슴") && next.getType().equals("호랑이")){
                    animals.set(j,next);
                    animals.set(j + 1, animal);
                }
                if (animal.getType().equals("코끼리") && animal.getAge() <=5 && next.getType().equals("호랑이")){
                    animals.set(j,next);
                    animals.set(j + 1, animal);
                }
            }
        }
    }

    private static void EnumSort(ArrayList<Animal_Enum> bonus) {
        //일렬 이동 중 동물은 앞만 볼 수 있고 뒤는 볼 수 없다. (즉, 피식자는 포식자 뒤에 피할 수 있다.)
        //호랑이는 사슴의 포식자로, 사슴 뒤에 호랑이가 올 수 없다.
        //bonus) 코뿔소는 맨앞에있어야한다.
        //bonus) 원숭이랑 개는 붙어있을 수 없다.
        for(int i = 0; i < bonus.size(); i++){
            for (int j = 0; j < bonus.size() -1; j++){
                Animal_Enum animal = bonus.get(j);
                Animal_Enum next = bonus.get(j + 1);

                if(animal.name().equals("DEER") && next.name().equals("TIGER")){
                    bonus.set(j,next);
                    bonus.set(j + 1, animal);
                }
                if(animal.name().equals("RHINOCEROS")){
                    Animal_Enum swap = bonus.get(0);
                    bonus.set(0,animal);
                    bonus.set(j,swap);
                }
                if(j != 0 && animal.name().equals("DOG") && (next.name().equals("MONKEY") ||bonus.get(j-1).name().equals("MONKEY")) ){
                    Animal_Enum swap = bonus.get(bonus.size() -1);
                    bonus.set(j,swap);
                    bonus.set(bonus.size() - 1, animal);
                }

            }
        }
    }


    public static void main(String[] args) {
        animals.add(new Animal("제니","원숭이",4));
        animals.add(new Animal("고먀","코끼리",4));
        animals.add(new Animal("타이","호랑이",9));
        animals.add(new Animal("로아","코뿔소",5));
        animals.add(new Animal("바비","사슴",7));

        System.out.println("변경 전 : "+  Arrays.toString(animals.toArray()));

        animalSort(animals);

        System.out.println(Arrays.toString(animals.toArray()));


        //bonus
        bonus.add(Animal_Enum.MONKEY);

        bonus.add(Animal_Enum.ELEPHANT);
        bonus.add(Animal_Enum.TIGER);
        bonus.add(Animal_Enum.RHINOCEROS);
        bonus.add(Animal_Enum.DOG);
        bonus.add(Animal_Enum.DEER);


        System.out.println("변경 전 : "+  Arrays.toString(bonus.toArray()));

        EnumSort(bonus);

        System.out.println(Arrays.toString(bonus.toArray()));


    }



}
