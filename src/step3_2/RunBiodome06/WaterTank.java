package step3_2.RunBiodome06;

public class WaterTank implements Runnable{
    private int tankNumber;
    private int amountWater;
    private WaterTank nextTank;

    public WaterTank(int tankNumber) {
        this.tankNumber = tankNumber;
        this.amountWater = 0;
    }

    public void setNextTank(WaterTank nextTank) {
        this.nextTank = nextTank;
    }

    @Override
    public void run() {
        while (true){
            addWater();
            if (amountWater == 100){
                if (nextTank != null){
                    synchronized (nextTank){ //synchronized() 괄호 안에 있는 객체에 대한 동기환 접근을 제공
                        nextTank.notify();
                    }
                }
                break;
            }
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void addWater(){
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            amountWater += 10;
        System.out.printf("물 저장소%s: %d리터\n",tankNumber,amountWater);
    }



}
