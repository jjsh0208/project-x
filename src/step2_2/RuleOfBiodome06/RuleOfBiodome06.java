package step2_2.RuleOfBiodome06;

import java.util.*;

public class RuleOfBiodome06 {
    static AnimalFrequencyAnalyzer analyzer;
    static  Scanner sc;
    public static void main(String[] args) {
        analyzer = new AnimalFrequencyAnalyzer();
        sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("========================");
            System.out.println("1. 동물 리스트 입력");
            System.out.println("2. 제일 많이 출현한 동물 확인");
            System.out.println("3. 동물들의 이름");
            System.out.println("4. 동물 그룹확인");
            System.out.println("5. 시스템 종료");
            System.out.println("========================");
            System.out.println("메뉴를 선택 하세요. ");
            System.out.println("========================");

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    System.out.println("동물 배열 입력 : ");
                    String animals = sc.nextLine();

                    String[] animalArray = Arrays.stream(animals.replaceAll("[\\[\\]]", "").split(",\\s*"))
                            .toArray(String[]::new);

                    analyzer.animalUpdate(animalArray);
                    break;
                case 2:
                    String[] result = analyzer.animalMaxCount();

                    System.out.print("가장 많이 출현한 동물 : ");
                    for (String a : result){
                        if (a.equals(result[result.length -1])) {
                            System.out.println(a);
                            break;
                        }
                        System.out.print(a+", ");
                    }
                    break;

                case 3:
                    List<String> set = new ArrayList<>(analyzer.animalName());
                    System.out.print("관찰된 모든 동물 : ");
                    for (String a : set){
                        if (a.equals(set.getLast())) {
                            System.out.println(a);
                            break;
                        }
                        System.out.print(a + ", ");
                    }
                    break;

                case 4:
                    Map<Integer, ArrayList<String>> test = analyzer.bonus();

                    List<Integer> list = new ArrayList<>(test.keySet());
                    Collections.sort(list);

                    for (Integer a : list){
                        System.out.println(a+"회 : " + Arrays.toString(test.get(a).toArray()));
                    }


                    break;

                case 5:
                    sc.close();
                    System.exit(0);
                    break;
            }

        }
    }
}
