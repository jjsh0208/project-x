package step3_2.RunBiodome08;



public interface SensorSubject {
    //상태 변화가 생기면 알림을 보내는 인터페이스
    
    //등록
    void registerObserver(SeonsrObserver o);
    //삭제
    void removeObserver(SeonsrObserver o);
    //observer에 알림을 주는 메서드
    void notifyObservers();
}
