package step3_1.BiodomeForever02;

import java.io.*;
import java.util.ArrayList;

public class LabNoteManager {

    public void empty(int value) throws EmptyFileException {
        if (value == 0) {
            throw new EmptyFileException("파일의 내용이 비어있습니다.");
        }
    }

    public void read (String fileName){
        FileInputStream file = null;
        String p = "C:\\coding\\Project-X\\src\\step3_1\\BiodomeForever02\\";

        int cnt = 0;

        try {
            file = new FileInputStream(p + fileName+".txt");
            InputStreamReader reader = new InputStreamReader(file,"UTF-8");
            int i;
            String content = "";


            while((i = reader.read()) != -1){
                content += ((char) i);
                cnt++;
            }
            empty(cnt);

            LabNote labNote = new LabNote(fileName,content);
            labNote.NotePrint();

        }catch(FileNotFoundException e){ //지정된 경로에 파일이 존재하지않는 경우
            System.out.println("존재하지 않는 파일입니다. 파일 이름을 다시 확인해주세요.");
            e.printStackTrace();
            System.exit(1);
        }catch (SecurityException e){ //보안이나 정책 또는 권한 문제로 파일을 읽을 수 없는 경우
            System.out.println("보안이나 정책 또는 권한 문제로 파일에 엑세스할 수 없습니다.");
            e.printStackTrace();
            System.exit(1);
        } catch (IOException e) { //파일을 읽을 때 도중에 문제가 생긴 경우
            System.out.println("파일을 읽을 때 문제가 생겼습니다.");
            e.printStackTrace();
            System.exit(1);
        } catch (EmptyFileException e) {
            throw new RuntimeException(e);
        } finally {
            if (file != null){
                try {
                    file.close();
                } catch (IOException e) {
                    System.out.println("파일을 읽을 때 문제가 생겼습니다.");
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }
    }


}
