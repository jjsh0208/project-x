package step3_2.RunBiodome06;

public class WaterTank implements Runnable{
    private int tankNumber;
    private int amountWater;
    private int priority;
//    private WaterTank nextTank;
//    private boolean first;


    public WaterTank(int tankNumber,int priority) {
        this.tankNumber = tankNumber;
        this.amountWater = 0;
        this.priority = priority;

    }
//    public WaterTank(int tankNumber, boolean first) {
//        this.tankNumber = tankNumber;
//        this.first = first;
//    }
//    public void setNextTank(WaterTank nextTank) {
//        this.nextTank = nextTank;
//    }

    @Override
    public  void run() {
        synchronized (this){
//            if (!first){
//                try{
//                    wait();
//                } catch (InterruptedException e) {
//                    //에러가 발생했을 때 현재 스레드를 안전하게 종료하기 위해 사용?
//                    Thread.currentThread().interrupt();
//                }
//            }
            while (amountWater != 100){
                addWater();
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

        }
//        if (nextTank != null){
//            synchronized (nextTank){
//                System.out.println();
//                nextTank.notify();}
//        }else{
//            System.out.println("\n물 채우기가 완료되었습니다.");
//        }
    }

    public  void addWater(){
        amountWater += 10;
        System.out.printf("물 저장소%s (우선순위 %s): %d리터\n",tankNumber,priority ,amountWater);
    }

}
