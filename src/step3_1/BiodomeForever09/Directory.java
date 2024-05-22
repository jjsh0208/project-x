package step3_1.BiodomeForever09;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Directory {
    private final String FILE_PATH = "C:\\coding\\Project-X\\src\\step3_1\\BiodomeForever09\\";

    public void duplicationCheck(String directoryPath)  {
        try{
            List<Path> path = new ArrayList<>();
            //isRegularFile 해당 경로의 파일이 일반적인 파일인지 아닌지 확인하는 매서드이다 tilter로 일반파일만 뽑아내서
            //forEach로 요소 하나하나를 path 배열에 추가한다.
            Files.walk(Paths.get(directoryPath)).filter(Files::isRegularFile).forEach(path::add);

            System.out.println(">>> 탐색 결과");
            for (int i = 0; i < path.size(); i++){
                for (int j = i + 1; j < path.size(); j++){
                    Path file1 = path.get(i);
                    Path file2 = path.get(j);

                    if (file1.toFile().length() == file2.toFile().length()){ //bonus
                        if (fileByteCheck(file1,file2)){
                            System.out.println(file1.getFileName() +"파일과"+ file2.getFileName()+ "파일은 동일한 파일입니다.");
                        }
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("올바르지 않은 경로입니다.");
        }
    }

    private boolean fileByteCheck(Path file1, Path file2) throws IOException {
        try(FileInputStream fis1 = new FileInputStream(file1.toFile());
            FileInputStream fis2 = new FileInputStream(file2.toFile())){

            int b1 ,b2;
            while((b1 = fis1.read()) != -1){
                b2 = fis2.read();
                if (b1 != b2) return false;
            }
            return fis2.read() == - 1;
        }
    }
}
