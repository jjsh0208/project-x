package step3_2.RunBiodome09;

import static step3_2.RunBiodome09.RunBiodome09.sc;

public class WaterRequestThread implements Runnable{

    private String location; //요청 지역 이름
    private int requestedAmount; //요청 물 양

    private int amountWater;

    public WaterRequestThread(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setRequestedAmount(int requestedAmount) {
        this.requestedAmount = requestedAmount;
    }

    @Override
    public void run() {
        CentralWaterCenter center = CentralWaterCenter.getInstance();


        boolean check = center.addWater(requestedAmount);

        if (check){
            amountWater += requestedAmount;
            System.out.println(location+"에 "+requestedAmount+"만큼의 물을 할당하였습니다. 남은 물의 양 : "+ center.getAmountWater());
            requestedAmount = 0;
        }else{
            System.out.println("물 할당 실패");
        }
    }
}
