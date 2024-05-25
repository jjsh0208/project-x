package step3_2.RunBiodome06;

public class RunBiodome06 {
    public static void main(String[] args) {
        final int NUM_TANKS = 5; // 탱크의 총 개수
        WaterTank[] tanks = new WaterTank[NUM_TANKS];

        // 탱크 초기화
        for (int i = 0; i < NUM_TANKS; i++) {
            tanks[i] = new WaterTank(i + 1);
        }

        // 각 탱크에 다음 탱크 설정
        for (int i = 0; i < NUM_TANKS - 1; i++) {
            tanks[i].setNextTank(tanks[i + 1]);
        }

        // 스레드 시작
        for (int i = 0; i < NUM_TANKS; i++) {
            new Thread(tanks[i]).start();
        }

        synchronized (tanks[0]) {
            tanks[0].notify(); // 첫 번째 탱크에 신호를 보내 시작
        }
    }
}
