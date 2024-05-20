package step3_1.BiodomeForever05;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EcoDataManager {
    private List<EcoData> ecoDataList = new ArrayList<>();
    private EcoDateAnalyze ecoDateAnalyze = new EcoDateAnalyze();


    public EcoDataManager() {
        System.out.println("환경 정보 관리 시스템에 오신 것을 환영합니다.");
    }

    public void write(EcoData ecoData) {
        String filePath = "C:\\coding\\Project-X\\src\\step3_1\\BiodomeForever05\\";
        String fileName = "environment_data.ser";


        try (FileOutputStream fis = new FileOutputStream(filePath + fileName);
             ObjectOutputStream os = new ObjectOutputStream(fis)) {

            ecoDataList.add(ecoData);

            os.writeObject(ecoDataList);

            System.out.println("데이터가 성공적으로 저장되었습니다.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }


    public void read () {
        String filePath = "C:\\coding\\Project-X\\src\\step3_1\\BiodomeForever05\\";
        String fileName =  "environment_data.ser";

        int cnt = 1;

        try (FileInputStream fis = new FileInputStream(filePath + fileName);
            ObjectInputStream ois = new ObjectInputStream(fis)){

           List<EcoData> ecoData = (List<EcoData>) ois.readObject();

            System.out.println("모든 환경 데이터 :");

            for (EcoData e : ecoData){
                System.out.println(cnt++ + ". "+ e.ecoDataInfo());
            }

        } catch(FileNotFoundException e){ //지정된 경로에 파일이 존재하지않는 경우
            System.out.println("존재하지 않는 파일입니다. 파일 이름을 다시 확인해주세요.");
            e.printStackTrace();
            System.exit(1);
        }catch (IOException e) { //파일을 읽을 때 도중에 문제가 생긴 경우
            System.out.println("파일을 읽을 때 문제가 생겼습니다.");
            e.printStackTrace();
            System.exit(1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



    }

    public void lifeRead() {
        String filePath = "C:\\coding\\Project-X\\src\\step3_1\\BiodomeForever05\\";
        String fileName =  "environment_data.ser";


        try (FileInputStream fis = new FileInputStream(filePath + fileName);
             ObjectInputStream ois = new ObjectInputStream(fis)){

            List<EcoData> ecoDataList = (List<EcoData>) ois.readObject();

            System.out.println("모든 환경 데이터 :");

            for (EcoData e : ecoDataList){
                System.out.printf("%s, %s: %.2f\n",e.getDateTime(),e.getMeasurementLocation(),ecoDateAnalyze.life(e));
//                ecoDateAnalyze.LogAvg(e); //bonus
            }

        } catch(FileNotFoundException e){ //지정된 경로에 파일이 존재하지않는 경우
            System.out.println("존재하지 않는 파일입니다. 파일 이름을 다시 확인해주세요.");
            e.printStackTrace();
            System.exit(1);
        }catch (IOException e) { //파일을 읽을 때 도중에 문제가 생긴 경우
            System.out.println("파일을 읽을 때 문제가 생겼습니다.");
            e.printStackTrace();
            System.exit(1);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
