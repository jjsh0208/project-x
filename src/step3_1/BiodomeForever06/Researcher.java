package step3_1.BiodomeForever06;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Researcher {
    //ID, 이름, 등록 날짜, 담당 위치
    private String id;
    private String name;
    private String regDate;
    private String position;

    public Researcher( int RegistrationOrder , String name, String position) {
        this.id = createID(RegistrationOrder);
        this.name = name;
        this.regDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.position = position;
    }

    private String createID(int RegistrationOrder){
        //LUMI-<등록 연도 4자리>-<등록 순서 2자리>:<3자리 랜덤넘버>
        String year = String.valueOf(LocalDateTime.now().getYear());
        String rgOrder = String.format("%02d",RegistrationOrder);
        String random = String.format("%03d",new Random().nextInt(1000));

        //LUMI-2130-01:587
        String id = String.format("LUMI-%s-%s:%s",year,rgOrder,random);
        return id;
    }

    //LUMI-2023-01:587, 알렉산더 박사, 2130-12-25, 루미노산 정상
    @Override
    public String toString() {
        return this.id + ", "+ this.name + ", " + regDate +", " + position;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRegDate() {
        return regDate;
    }

    public String getPosition() {
        return position;
    }
}
