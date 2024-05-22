package step3_1.BiodomeForever08;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class EnvironmentDataManager {
    private final String FILE_PATH = "C:\\coding\\Project-X\\src\\step3_1\\BiodomeForever08\\";
    private final String FILE_NAME = "environment_data_Lake.txt";
    private BinarySearchTree bst;
    private ArrayList<EnvironmentData> environmentData;

    public EnvironmentDataManager() {
        bst = new BinarySearchTree();
        environmentData= new ArrayList<>();
        loadData();
    }

    private void loadData() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH+FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
//                String[] part = parts[0].split(" ");
                String date = parts[0];
                double temperature = Double.parseDouble(parts[1]);
                double humidity = Double.parseDouble(parts[2]);
                double oxygenLevel = Double.parseDouble(parts[3]);
                EnvironmentData data = new EnvironmentData(date, temperature, humidity, oxygenLevel);
                System.out.println(data);
                bst.add(data);
                environmentData.add(data);
            }
        } catch (IOException e) {
            System.out.println("파일을 읽는 도중 에러가 발생했습니다: " + e.getMessage());
        }
    }

    public void searchAndUpdate(String date) {
        EnvironmentData data = bst.search(date);
        if (data == null) {
            System.out.println(">>> 해당 날짜의 데이터는 존재하지 않습니다.");
            return;
        }

        System.out.println(">>> 검색 결과: " + data);

        Scanner scanner = new Scanner(System.in);
        System.out.print("데이터를 수정하시겠습니까? (Y/N): ");
        String response = scanner.nextLine();

        if (response.equalsIgnoreCase("Y")) {
            System.out.print("새로운 데이터 값을 입력하세요: ");
            String newDataStr = scanner.nextLine();
            String[] newDataParts = newDataStr.split(",");
            try {
                double newTemperature = Double.parseDouble(newDataParts[0]);
                double newHumidity = Double.parseDouble(newDataParts[1]);
                double newOxygenLevel = Double.parseDouble(newDataParts[2]);

                EnvironmentData newData = new EnvironmentData(date, newTemperature, newHumidity, newOxygenLevel);
                bst.update(date, newData);
                saveData();
                System.out.println(">>> 데이터 수정 완료!");
                System.out.println("날짜 " + date + ", 수정된 데이터 " + newData);
            } catch (NumberFormatException e) {
                System.out.println("입력된 데이터에 문자가 포함되어 있습니다. 숫자로 입력해주세요.");
            }
        }
    }

    private void saveData() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH+FILE_NAME))) {
            saveRecursive(bst.getRoot(), bw);
        } catch (IOException e) {
            System.out.println("파일을 쓰는 도중 에러가 발생했습니다: " + e.getMessage());
        }
    }

    private void saveRecursive(Node node, BufferedWriter bw) throws IOException {
        if (node != null) {
            bw.write(node.getData().getDate() + "," +
                    node.getData().getTemperature() + "," +
                    node.getData().getHumidity() + "," +
                    node.getData().getOxygenLevel() + "\n");
            saveRecursive(node.getLeft(), bw);
            saveRecursive(node.getRight(), bw);
        }
    }

    public void RangeSearch(String startDate, String endDate) {
        EnvironmentData[] data = bst.RangeSearch(startDate,endDate);
        if (data == null) {
            System.out.println(">>> 해당 날짜의 데이터는 존재하지 않습니다.");
            return;
        }

        System.out.println(">>>\n검색 결과:");
        System.out.println("--------------------------");
        System.out.println("날짜와 시간        |  온도  |  습도  |  산소 농도");
        System.out.println("--------------------------");
        for (EnvironmentData e : data){
            System.out.println(e.getDate() +" | "+ e.getTemperature()+"°C | "+ e.getHumidity()+"% | "+e.getOxygenLevel()+"%");
        }
        System.out.println("--------------------------");

        System.out.println("\n검색이 완료되었습니다.");
    }
}

