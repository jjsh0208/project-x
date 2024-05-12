package step2_2.RuleOfBiodome03;

class  NormalDevice extends  DeviceDetails {

    NormalDevice(String model) {
        super(model);
        System.out.println("일반 기기가 생성되었습니다 : "+ getModel() + ", " + getBRAND() +", 절전모드 : " +
                (isPowerSaving() ? "On" : "Off"));
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("절전모드 : " +  (isPowerSaving() ? "On" : "Off") );
    }
}