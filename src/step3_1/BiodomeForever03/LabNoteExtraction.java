package step3_1.BiodomeForever03;

import step3_1.BiodomeForever02.EmptyFileException;

import java.io.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class LabNoteExtraction {
    private ArrayList<LabNote> labNotes = new ArrayList<>();
    private ArrayList<String> plants = new ArrayList<>();
    LabNoteExtraction(){
        try {
            read("213102120900_AquaFern");
            read("213101291200_SolarisThorn");
            read("213104012200_NightBlossom");
            read("213011210700_ShadeMist");
            read("213012071130_Glowberry");
            read("213109211300_SolarFlare");
        }catch (NoDataAvailableException e){
            e.printStackTrace();
            System.exit(1);
        }

        for (int i = 0; i < labNotes.size(); i++){
            plantExtraction(labNotes.get(i));
        }

        write();
    }

    public void plantExtraction(LabNote labNote){
        String[] content = labNote.getContent().split("\n");
        String plant = null;
        String ADR = null;
        int cnt = 0;

        for (int i = 0; i < content.length; i++) {
            if (content[i].startsWith("Name. ")) {
                plant = content[i].replace("Name. ", "");
                cnt++;
                continue;
            }
            if (content[i].startsWith("ADR. ")) {
                ADR = content[i].replace("ADR. ", "");
                cnt++;
                if (!plant.isEmpty() && !ADR.isEmpty()){
                    String obj = plant+" - "+ADR;
                    if (plants.contains(obj)) return; //bonus
                    plants.add(obj);
                    plant = null;
                    ADR = null;
                }
            }
        }
        if ( cnt != 2) System.out.println(labNote.getFileName() + " 식물명 또는 주소 정보가 누락되었습니다.");
    }

    public void write() {

        DateTimeFormatter dateTimeFormatter =DateTimeFormatter.ofPattern("yyyyMMddHHmm");
        String date = LocalDateTime.now().format(dateTimeFormatter);
        String fileName = date + "_Lumino_ADR.txt";
        String filePath = "C:\\coding\\Project-X\\src\\step3_1\\BiodomeForever03\\";

        File file = new File(filePath + fileName);

        if (file.exists()){ //동일한 파일명이 존재하면 초 단위까지 생성
            DateTimeFormatter formatterWithSeconds = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
            date = LocalDateTime.now().format(formatterWithSeconds);
            fileName = date + "_Lumino_ADR.txt";
            file = new File(filePath + fileName);
        }
        try (FileOutputStream fos = new FileOutputStream(file);
             OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8"); //인코딩
             BufferedWriter bw = new BufferedWriter(osw)) {

            for (String plant : plants) {
                bw.write(plant);
                bw.newLine(); // 새로운 라인 추가
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }




    public void read (String fileName) throws NoDataAvailableException {
        String filePath = "C:\\coding\\Project-X\\src\\step3_1\\BiodomeForever03\\";

        File file = new File(filePath + fileName+".txt");

        fileExists(file);

        try (FileInputStream fis = new FileInputStream(file);
            InputStreamReader reader = new InputStreamReader(fis,"UTF-8")){


            int i;
            String content = "";
            while((i = reader.read()) != -1){
                content += ((char) i);
            }

            String date = fileName.substring(0, fileName.indexOf("_"));

            labNotes.add(new LabNote(fileName,content));

        } catch(FileNotFoundException e){ //지정된 경로에 파일이 존재하지않는 경우
            System.out.println("존재하지 않는 파일입니다. 파일 이름을 다시 확인해주세요.");
            e.printStackTrace();
            System.exit(1);
        }catch (IOException e) { //파일을 읽을 때 도중에 문제가 생긴 경우
            System.out.println("파일을 읽을 때 문제가 생겼습니다.");
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void fileExists(File file) throws NoDataAvailableException {
        if (!file.exists()){
            throw new NoDataAvailableException("분석할 파일이 없습니다");
        }
    }
}
