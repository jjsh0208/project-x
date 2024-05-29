package step3_2.RunBiodome08;

public interface SeonsrObserver {
    //상태 변화가있을 때 데이터를 전달하는 메서드
    void relayData (double temperature , int heartRate);

}
