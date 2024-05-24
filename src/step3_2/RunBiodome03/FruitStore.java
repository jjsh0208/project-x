package step3_2.RunBiodome03;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FruitStore {
    private final String FILE_PATH = "C:\\coding\\Project-X\\src\\step3_2\\RunBiodome03\\";
    private final String FILE_NAME = "fruit_data.csv";
    private HashMap<String, Integer> fruitStock = new HashMap<>(); //과일 이름 , 재고량
    private HashMap<String, String> fruitSalesHistory = new HashMap<>(); //과일 이름, 판매이력 예) 사과 2024-05-23
    private HashMap<String, Integer> fruitSellCount = new HashMap<>();

    FruitStore(){
        read();
    }

    public void updateHistory(String fruit, Integer quantity){
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        // 판매 이력 문자열 생성
        //과일이름과 최근 판매 날짜
        fruitSalesHistory.put(fruit,now);
        System.out.println(fruitSalesHistory.get(fruit).toString());
    }


    public void read(){
        Path path = Paths.get(FILE_PATH+FILE_NAME);

        try(Stream<String> lines = Files.lines(path)){
                    lines.skip(1)
                            .sorted()
                            .forEach(l -> {
                        String[] parts = l.split(",");
                        fruitStock.put(parts[0],Integer.parseInt(parts[1]));
                        fruitSellCount.put(parts[0],0);});
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
                            System.out.println(fruit +"-"+ quantity+"개");
                        });
    }

    public void fruitSell(String fruit, Integer quantity) {
        if (quantity < 1){
            System.out.println("1개 이상만 판매할 수 있습니다.");
            return;
        }

        if (fruitStock.containsKey(fruit)){
            if (fruitStock.get(fruit) >= quantity){
                fruitStock.put(fruit,fruitStock.get(fruit) -  quantity);
                fruitSellCount.put(fruit,fruitSellCount.get(fruit) + quantity);
                System.out.println("\n" + fruit + " " + quantity + "개가 판매되었습니다.");
                updateHistory(fruit,quantity);
                return;
            }else{
                System.out.println("재고가 부족합니다. 현재 재고 : "+fruitStock.get(fruit));
                return;
            }
        }
        System.out.println("판매하지않는 과일입니다.");
    }

    public void addQuantity(String fruit, Integer quantity) {
        if (quantity < 1){
            System.out.println("1개 이상만 재고를 추가할 수 있습니다.");
            return;
        }

        if (fruitStock.containsKey(fruit)){
                fruitStock.put(fruit, fruitStock.get(fruit) +  quantity);
                System.out.println(fruit +" 재고가 "+ quantity+"개 추가되었습니다!");
                return;
            }
        System.out.println("판매하지않는 과일입니다.");
    }

    public void save(){
        //fruitStock 에서 과일 - 개수
        //fruitSalesHistory 에서 판매 이력 마지막 날짜 를 저장
        
        
        if (fruitSalesHistory.isEmpty()){
            System.out.println("판매이력이 없습니다.");
        }else{
            Path path = Paths.get(FILE_PATH+FILE_NAME);

            List<String> lines = new ArrayList<>();
            lines.add("과일명,재고량,최근 판매 정보");
            for (Map.Entry<String, Integer> entry : fruitStock.entrySet()) {
                lines.add(entry.getKey() + "," + entry.getValue() +","+ fruitSalesHistory.get(entry.getKey())+":"+fruitSellCount.get(entry.getKey()));
            }
            try {
                Files.write(path, lines);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
//Path path = Paths.get(FILE_PATH+FILE_NAME);
//
//        try(Stream<String> lines = Files.lines(path)){
//                    lines.skip(1)
//                            .sorted()
//                            .forEach(l -> {
//                        String[] parts = l.split(",");
//                        fruitStock.put(parts[0],Integer.parseInt(parts[1]));
//                        fruitSellCount.put(parts[0],0);});
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

    public void searchSell(String fruit) {
        Path path = Paths.get(FILE_PATH+FILE_NAME);

        try(Stream<String> lines = Files.lines(path)){
            lines.skip(1)
                    .filter(l -> l.contains(fruit))
                    .map(l -> l.split(","))
                    .map(parts -> parts.length > 2 ? parts[2] : null) // 세 번째 요소를 선택
                    .filter(Objects::nonNull)
                    .findFirst() //첫번째 요소를 Optional 객체로 반환
                    .ifPresent(item -> { //Optional 객체의 값이 있는지 없는지 검사 후 있으면 주어진 작업 실행
                        String[] result = item.split(":");
                        if (result.length > 1) {
                            System.out.println(result[0] + " " + result[1] + "개");
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

