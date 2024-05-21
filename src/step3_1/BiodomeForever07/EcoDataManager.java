package step3_1.BiodomeForever07;

import step3_1.BiodomeForever08.EnvironmentData;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class EcoDataManager {
    private final String FILE_PATH = "C:\\coding\\Project-X\\src\\step3_1\\BiodomeForever07\\";
    private final String FILE_NAME = "environment_data_Lumino.txt";
    private ArrayList<EnvironmentData> ecoDataList = new ArrayList<>();
    public void read(String search) {
        //2130-08-01 00:00
        if (!search.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}")){
            System.out.println("입력한 값이 날짜의 형태와 일치하지않습니다.");
            return;
        }


        try (RandomAccessFile raf = new RandomAccessFile(FILE_PATH+FILE_NAME,"r");){

            String info = "";
            while((info = raf.readLine()) != null){
                 if (info.startsWith(search)){

                     String[] result = info.split(",");
                     EnvironmentData ecoData = new EnvironmentData(result[0],Float.parseFloat(result[1]),Float.parseFloat(result[2]),Float.parseFloat(result[3]));
                     ecoDataList.add(ecoData);

                     System.out.println("\n>>> 검색 결과: "+ecoData.toString());
                     return;
                 }
            }
            DataNotExist();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (DataNotExist e){}
    }

    public void DataNotExist() throws DataNotExist {
        System.out.println(">>> 해당 날짜의 데이터는 존재하지 않습니다");
    }


    public void write(String date) {
        if (!date.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}")){
            System.out.println("입력한 값이 날짜의 형태와 일치하지않습니다.");
            return;
        }


        String fileName = date+"_environment_data.txt";
        try (RandomAccessFile readRaf = new RandomAccessFile(FILE_PATH+FILE_NAME,"r");
             RandomAccessFile writeRaf = new RandomAccessFile(FILE_PATH + fileName, "rw")){

            writeRaf.seek(writeRaf.length());

            String info = "";
            while((info = readRaf.readLine()) != null){
                if (info.startsWith(date)){
                    writeRaf.writeBytes(info + "\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
