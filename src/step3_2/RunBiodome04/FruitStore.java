package step3_2.RunBiodome04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Stream;


public class FruitStore {
    private final String FILE_PATH = "C:\\coding\\Project-X\\src\\step3_2\\RunBiodome04\\";
    private final String FILE_NAME = "fruit_data_total.csv";
    private HashMap<String, Integer> fruitStock = new HashMap<>(); //과일 이름 , 재고량
    private HashMap<String, String> fruitSalesHistory = new HashMap<>(); //과일 이름, 판매이력 예) 사과 2024-05-23:개수

    FruitStore(){
        read();
    }

    private void read() {
        Path path = Paths.get(FILE_PATH+FILE_NAME);

        try(Stream<String> lines = Files.lines(path)){
            lines.skip(1)
                    .forEach(l -> {
                     String[]parts = l.split(",");
                     fruitStock.put(parts[0],Integer.parseInt(parts[1]));
                        StringBuilder salesHistory = new StringBuilder();
                        for (int i = 2; i < parts.length; i++) {
                            if (i > 2) salesHistory.append(","); // 첫 번째 이후의 항목부터는 쉼표로 구분
                            salesHistory.append(parts[i]);
                        }
                        fruitSalesHistory.put(parts[0], salesHistory.toString());
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void show(){
        System.out.println("\n모든 과일 재고 조회:");
        fruitStock.entrySet().stream()
                .forEach(entry -> {
                    String fruit = entry.getKey();
                    Integer quantity = entry.getValue();
                    System.out.println(fruit +"-"+ quantity+"개"); //max 사용하면될듯?

                });
    }

    public void maxSell() {
        HashMap<String,Integer> totalSell = new HashMap<>(){{
            fruitSalesHistory.forEach((key, value) -> {
                int total = Arrays.stream(value.split(","))
                        .map(s -> s.split(":")[1])
                        .mapToInt(Integer::parseInt)
                        .sum();
                put(key, total);
            });
        }};

        Optional<Map.Entry<String,Integer>> result = totalSell.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());

        if (result.isPresent()){
            System.out.println("가장 많이 팔린 과일: "+result.get().getKey()+" - 총 " +result.get().getValue() +"개 판매됨");
        }


    }

    public void totalSell() {
        HashMap<String,Integer> totalSell = new HashMap<>(){{
            fruitSalesHistory.forEach((key, value) -> {
                int total = Arrays.stream(value.split(","))
                        .map(s -> s.split(":")[1])
                        .mapToInt(Integer::parseInt)
                        .sum();
                put(key, total);
            });
        }};
        System.out.println(">>> 총 판매 과일 수 조회");
        for (Map.Entry<String,Integer> fruit : totalSell.entrySet()){
            System.out.println(fruit.getKey() +" - 총"+ fruit.getValue()+"개 판매됨");
        }

    }

    public void averageSell() {
        HashMap<String,Double> totalSell = new HashMap<>(){{
            fruitSalesHistory.forEach((key, value) -> {
                double total = Arrays.stream(value.split(","))
                        .map(s -> s.split(":")[1])
                        .mapToInt(Integer::parseInt)
                        .average().orElse(0);
                put(key, total);
            });
        }};

        System.out.println(">>> 과일별 평균 판매 개수 조회");
        for (Map.Entry<String,Double> fruit : totalSell.entrySet()){
            System.out.printf("%s - 평균 %.1f개 판매됨\n",fruit.getKey(),fruit.getValue());
        }
    }


    //프로그램 실행시 새로운 메뉴 과일별 판매 조회를 추가한다.
    //과일 이름을 입력 받아 해당 과일의 날짜별 판매 이력과 총 판매 개수를 출력한다.
    //과일의 이름을 입력해 날짜별 판매 이력을 오름차순으로 정렬해 한줄씩 출력한다.
    //날짜별 판매 이력 출력이 끝나면 총 판매 개수를 출력한다.
    public void searchSell(String fruit) {
            fruitSalesHistory.forEach((key, value) -> {
                if (key.equals(fruit)) {

                    System.out.println(">>>판매 이력 ");
                    Arrays.stream(value.split(","))
                            .map(s -> s.split(":"))
                            .sorted(Comparator.comparing(s -> LocalDate.parse(s[0])))
                            .forEach(a -> System.out.println(a[0]+ ":"+a[1]));

                    int total = Arrays.stream(value.split(","))
                            .map(s -> s.split(":")[1])
                            .mapToInt(Integer::parseInt)
                            .sum();
                    System.out.println("총 판매량 : " + total);
                }
            });
    }

}
