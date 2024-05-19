package step3_1.BiodomeForever04;

import java.io.*;

public class EcoDataManager {

    public EcoDataManager() {
        System.out.println("환경 정보 관리 시스템에 오신 것을 환영합니다.");
    }

    public void write(EcoData ecoData) {
        String filePath = "C:\\coding\\Project-X\\src\\step3_1\\BiodomeForever04\\";
        String fileName = "environment_data.txt";

        try (BufferedWriter  bw = new BufferedWriter(new FileWriter(filePath + fileName,true))) {

            bw.append(ecoData.ecoDataInfo()+'\n');
            bw.flush();
            System.out.println("데이터가 environment_data.txt에 저장되었습니다.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }


    public void read () {
        String filePath = "C:\\coding\\Project-X\\src\\step3_1\\BiodomeForever04\\";
        String fileNmae =  "environment_data.txt";


        try (BufferedReader br = new BufferedReader(new FileReader(filePath + fileNmae));){

            int i;
            String content = "";
            while((i = br.read()) != -1){
                content += ((char) i);
            }

            System.out.println(content);
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

    public void oxygenRead() {
        String filePath = "C:\\coding\\Project-X\\src\\step3_1\\BiodomeForever04\\";
        String fileName =  "environment_data.txt";


        try (BufferedReader br = new BufferedReader(new FileReader(filePath + fileName));){

            String temp;
            String content = "";
            while((temp = br.readLine()) != null){
                String[] Eco = temp.split(",");

                content += (Eco[0]+","+Eco[3]+" - "+Eco[4]+'\n');

            }

            System.out.println(content);
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
