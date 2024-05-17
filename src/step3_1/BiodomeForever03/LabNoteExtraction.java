package step3_1.BiodomeForever03;

import java.io.*;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class LabNoteExtraction {
    private ArrayList<LabNote> labNotes = new ArrayList<>();
    private ArrayList<String> plants = new ArrayList<>();
    LabNoteExtraction(){
        read("213102120900_AquaFern");
        read("213101291200_SolarisThorn");
        read("213104012200_NightBlossom");
        read("213011210700_ShadeMist");
        read("213012071130_Glowberry");
        read("213109211300_SolarFlare");


        for (int i = 0; i < labNotes.size(); i++){
            plantExtraction(labNotes.get(i));
        }

        write();
    }

    public void plantExtraction(LabNote labNote){
        String[] content = labNote.getContent().split("\n");
        String plant = null;
        String ADR = null;
        for (int i = 0; i < content.length; i++) {
            if (content[i].startsWith("Name. ")) {
                plant = content[i].replace("Name. ", "");
                continue;
            }
            if (content[i].startsWith("ADR. ")) {
                ADR = content[i].replace("ADR. ", "");
                if (!plant.isEmpty() && !ADR.isEmpty()){
                    String obj = plant+" - "+ADR;
                    if (plants.contains(obj)) continue; //bonus
                    plants.add(obj);
                    plant = null;
                    ADR = null;
                }
            }
        }
    }

    public void write() {

        DateTimeFormatter dateTimeFormatter =DateTimeFormatter.ofPattern("yyyyMMddHHmm");
        String date = LocalDateTime.now().format(dateTimeFormatter);
        String fileName = date + "_Lumino_ADR.txt";
        String filePath = "C:\\coding\\Project-X\\src\\step3_1\\BiodomeForever03\\";

        File file = new File(filePath + fileName);

        if (file.exists()){
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


        public void read (String fileName){
        String p = "C:\\coding\\Project-X\\src\\step3_1\\BiodomeForever03\\";

        try (FileInputStream file = new FileInputStream(p + fileName+".txt");
            InputStreamReader reader = new InputStreamReader(file,"UTF-8")){

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
}
