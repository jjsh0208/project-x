package step3_1.BiodomeForever02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class LabNote {

    private String fileName;
    private String content;
    private String date;

    public LabNote(String fileName, String content ) {
        this.fileName = fileName;
        this.content = content;
        this.date = date();

    }

    public void NotePrint(){
        System.out.println(this.date +"\n"+ this.content);
    }

    public String getFileName() {
        return fileName;
    }

    public String date(){
        String dateParts = getFileName().substring(0,12);

        //받아오는 형식
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyyMMddHHmm");
        //출력하고싶은 형식
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            Date  inputDate =  inputFormat.parse(dateParts);
            String date = outputFormat.format(inputDate); //원하는 형식의 날짜를 문자열로 반환
            return date;
        } catch (ParseException e) {
            System.out.println("파일 이름에서 날짜를 확인할 수 없습니다.");
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }


}
