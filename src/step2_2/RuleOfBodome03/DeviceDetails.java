package step2_2.RuleOfBodome03;

class DeviceDetails implements Device{ //기계 세부사항
    private String model;
    boolean powerSaving; //절전모드

    private final String BRAND = "DOMETech";

    DeviceDetails(String model) {
        this.model = model;
        this.powerSaving = false;
    }

    public boolean isPowerSaving() {
        return powerSaving;
    }

    public String getBRAND() {
        return BRAND;
    }

    public String getModel() {
        return model;
    }

    public void displayInfo() {
        System.out.println("Model: " + model);
        System.out.println("Brand: " + BRAND);
    }

    @Override
    public void PowerSavingMode(){
        powerSaving = !powerSaving;
    }

    @Override
    public void powerOn() {
        System.out.println(model + " 전원을 켰습니다.");
    }
    @Override
    public void powerOff() {
        System.out.println(model + " 가 꺼집니다.");
    }

}
