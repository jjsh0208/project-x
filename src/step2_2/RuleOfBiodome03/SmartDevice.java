package step2_2.RuleOfBiodome03;

class SmartDevice extends DeviceDetails implements AdvancedFeatures{
    private String feature;

    SmartDevice(String model , String feature) {
        super(model);
        this.feature = feature;
        System.out.println("스마트 기기가 생성되었습니다 : " + getModel() +", " + getBRAND() + ", " + getFeature());
    }

    @Override
    public void activateFeature() {
        if (feature != null && !feature.isEmpty()) {
            powerOn();
            System.out.println(feature + " 고급 기능을 활성화 시켰습니다.");
        } else {
            System.out.println("활성화할 고급 기능이 없습니다.");
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Feature : " + feature );
        System.out.println("절전모드 : " +  (isPowerSaving() ? "On" : "Off") );
    }

    public String getFeature() {
        return feature;
    }
}