package step3_1.BiodomeForever01;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LabNoteManager {
    ArrayList<LabNote> labNotes = new ArrayList<>();

    LabNoteManager(){
        loadFiles();
    }
    public void loadFiles(){
        load("213011210700_ShadeMist");
        load("213012071130_Glowberry");
        load("213101291200_SolarisThorn");
        load("213102120900_AquaFern");
        load("213104012200_NightBlossom");
    }


    public void search(String date){
        for (LabNote labNote : labNotes){
            if (labNote.getFileName().contains(date)){
                labNote.NotePrint();
            }
        }
    }



    public void load (String fileName){
        FileInputStream file = null;
        String p = "C:\\coding\\Project-X\\src\\step3_1\\BiodomeForever01\\";

        try {
            file = new FileInputStream(p + fileName+".txt");
            InputStreamReader reader=new InputStreamReader(file,"UTF-8");
            int i;
            String content = "";
            while((i = reader.read()) != -1){
                content += ((char) i);
            }

            String date = fileName.substring(0, fileName.indexOf("_"));

            labNotes.add(new LabNote(fileName,content,date));

        } catch (IOException e) {
            System.out.println("존재하지 않는 파일입니다. 파일 이름을 다시 확인해주세요.");
        } finally {
            if (file != null){
                try {
                    file.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void NotePrint(String fileName){
        for (LabNote labNote : labNotes){
            if (labNote.getFileName().equals(fileName)){
                labNote.NotePrint();
                return;
            }
        }
    }

}
