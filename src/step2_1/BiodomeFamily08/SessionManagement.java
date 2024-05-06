package step2_1.BiodomeFamily08;

import java.time.LocalDateTime;
import java.util.Date;

public interface SessionManagement {

    void openSession(Session session); //연습 개설
    void cancelSession(String location, LocalDateTime localDateTime); //연습 취소
    void postponeSession(String admin, String location, LocalDateTime localDateTime); //연습 연기
}
