package step3_2.RunBiodome09;

import java.util.concurrent.locks.ReentrantLock;

public class CentralWaterCenter {

    private static volatile  CentralWaterCenter singleton;

    private int amountWater = 10000;

    private final ReentrantLock lock = new ReentrantLock();


    private CentralWaterCenter() {
    }

    public int getAmountWater() {
        return amountWater;
    }


    public static  CentralWaterCenter getInstance(){
        if (singleton == null){ //인스턴스가 생성되지않았을 때만 동기화
            synchronized (CentralWaterCenter.class){ //다른 스레드가 먼저 생성했을 수도있으므로 검사
                if (singleton == null){
                    singleton = new CentralWaterCenter();
                }
            }
        }
        return  singleton;
    }

//    public synchronized boolean addWater(int request){
//        //synchronized 로 동기화를 해 여러 스레드에서 접근해도 한번에 하나의 스레드만이 실행가능하다
//        if(request <= amountWater){
//            amountWater -= request;
//            return true;
//        }else{
//            return false;
//        }
//    }
    public  boolean addWater(int request){
        //ReentrantLock : synchronized  보다 더 정교하게 동기화기능을 제공
        lock.lock(); //락 획득

        try{
            if(request <= amountWater){
                amountWater -= request;
                return true;
            }else{
                return false;
            }
        }finally {
            lock.unlock();
        }
    }


    public void waterAmountCheck() {
        System.out.printf("\n중앙 수자원 센터의 현재 물양: %d\n\n", amountWater);
    }
}
